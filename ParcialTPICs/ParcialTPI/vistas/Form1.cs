using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;
using WebSocketSharp;
using ParcialTPI.vistas.Conexion;
using ParcialTPI.vistas.Controladores;
using ParcialTPI.vistas.Mapeo;
using ParcialTPI.vistas.vistas;
using TareaTPI.Excepciones;

namespace ParcialTPI.vistas
{
    public partial class Form1 : Form, INotificadorUI
    {
        private IngresoDetalleExamenController controller;
        private IngresoDetalleExamen tuplaActual;
        private Boolean editando;

        public Form1()
        {
            try
            {
                InitializeComponent();
                agregarPropiedadesAutoSizing();
                blockearControles();
                editando = false;
                controller = new IngresoDetalleExamenController(this);
            }
            catch (NetworkConnectionException ex) {
                notificarError();
            }
            
        }

        private void agregarPropiedadesAutoSizing()
        {
            foreach(DataGridViewColumn columna in tabla.Columns) {
                columna.AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
            }
            
        }

        public void NotificarConexionAbierta()
        {
            loadData("Datos leidos de forma exitosa");
        }

        public void NotificarCambiosEnDatos(String mensaje)
        {
            loadData(mensaje);
        }

        public void NotificarErrorEnConexion()
        {
            if (this.Visible)
            {
                this.Invoke(new Action(delegate()
                {
                    output.Text = "Error al conectarse al servidor...";
                        
                }));
            }
            else
            {
                notificarError();
            }
        }

        private void loadData(String mensaje)
        {
            this.Invoke(new Action(delegate()
            {
                procesarActualizacionDesdeOtraThread();
                output.Text = mensaje;
                updateControlesPaginado();
            }));

        }

        private void procesarActualizacionDesdeOtraThread()
        {
            tabla.Rows.Clear();
            var datos = controller.GetListaDatos();

            if (datos != null)
            {
                insertarDatosDesdeOtraThread(datos);
            }
        }

        private void insertarDatosDesdeOtraThread(List<IngresoDetalleExamen> datos)
        {
            foreach (var ide in datos)
            {
                mostrarTupla(ide);
            }
        }

        private void mostrarTupla(IngresoDetalleExamen ide)
        {
            tabla.Rows.Add(ide.idIngresoDetalleExamen, getNombreYApellidoPaciente(ide),
                getNombreMedico(ide), getNombreCentro(ide), getNombreExamen(ide), getFechaExamen(ide));
        }

        private String getNombreYApellidoPaciente(IngresoDetalleExamen ide)
        {
            return ide.ingresoDetalle.ingreso.idPaciente.getNombreYApellido();
        }

        private String getNombreMedico(IngresoDetalleExamen ide)
        {
            return ide.ingresoDetalle.asignacionPersonalCentroAreaEspacio
                .asignacionPersonalCentroArea.idPersonal.apellidos;
        }

        private String getNombreCentro(IngresoDetalleExamen ide)
        {
            return ide.ingresoDetalle.asignacionPersonalCentroAreaEspacio
                .asignacionPersonalCentroArea.idAreaCentro.idCentro.nombreCorto;
        }

        private String getNombreExamen(IngresoDetalleExamen ide)
        {
            return ide.idExamen.nombre;
        }

        private String getFechaExamen(IngresoDetalleExamen ide)
        {
            return ide.fechaRealizacion.ToShortDateString();
        }

        private String getFechaIngresoDetalle(IngresoDetalleExamen ide)
        {
            return ide.ingresoDetalle.fechaDetalle.ToShortDateString();
        }


        private void tabla_SelectionChanged(object sender, EventArgs e)
        {
            if(hayRegistroSeleccionado() && editando == false) {
                var ide = getIngresoDetalleSeleccionado();
                mostrarIngresoDetalleExamen(ide);
                controller.RegistrarSeleccionExamen(ide.idExamen);
                controller.RegistrarSeleccionIngresoDetalle(ide.ingresoDetalle);
                tuplaActual = ide;
            }
        }

        private Boolean hayRegistroSeleccionado()
        {
            return tabla.SelectedRows.Count != 0;
        }

        private void mostrarIngresoDetalleExamen(IngresoDetalleExamen ide)
        {
            txtIdIngresoDetalleExamen.Text = ide.idIngresoDetalleExamen.ToString();

            mostrarIngresoDetalle(ide.ingresoDetalle);

            dpFechaOrden.Value = ide.fechaOrden;
            dpFechaRealizacion.Value = ide.fechaRealizacion;
            dpHoraRealizacion.Value = ide.horaRealizacion;

            mostrarExamen(ide.idExamen);
        }

        private void mostrarExamen(Examen examen)
        {
            txtNombreExamen.Text = examen.nombre;
        }

        private void mostrarIngresoDetalle(IngresoDetalle ingresoDetalle)
        {
            txtPaciente.Text = ingresoDetalle.ingreso.idPaciente.getNombreYApellido();
            txtFechaDetalle.Text = ingresoDetalle.fechaDetalle.ToShortDateString();
            txtMedico.Text = ingresoDetalle.asignacionPersonalCentroAreaEspacio
                .asignacionPersonalCentroArea.idPersonal.apellidos;

            txtNombreCentro.Text = ingresoDetalle
                .asignacionPersonalCentroAreaEspacio.asignacionPersonalCentroArea.idAreaCentro.idCentro.nombreCorto;
        }

        private IngresoDetalleExamen getIngresoDetalleSeleccionado()
        {
            int valorSeleccionado = getIdDetalleExamenSeleccionado();
            return controller.GetDatoById(valorSeleccionado);
        }

        private int getIdDetalleExamenSeleccionado()
        {
            return int.Parse(tabla.SelectedRows[0].Cells[0].Value.ToString());
        }

        private void blockearControles()
        {
            setBotonesHabilitados(false);
        }

        private void desblockearControles()
        {
            setBotonesHabilitados(true);
            
        }

        private void setBotonesHabilitados(Boolean blockear)
        {
            btnSeleccionarExamen.Enabled = blockear;
            btnSeleccionarIngresoDetalle.Enabled = blockear;
            dpFechaOrden.Enabled = blockear;
            dpFechaRealizacion.Enabled = blockear;
            dpHoraRealizacion.Enabled = blockear;
            btnCancelar.Enabled = blockear;
            btnModificar.Enabled = !blockear;
            btnGuardar.Enabled = blockear;
            btnInsertar.Enabled = !blockear;
            btnEliminar.Enabled = !blockear;
            tabla.Enabled = !blockear;
        }

        private void btnModificar_Click(object sender, EventArgs e)
        {
            if(hayRegistroSeleccionado()) {
                desblockearControles();
                controller.RegistrarModificacion();
                editando = true;
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            blockearControles();
            if(tabla.SelectedRows.Count != 0) {
                mostrarIngresoDetalleExamen(tuplaActual);
            }
            controller.CancelarAccionGuardada();
            editando = false;
        }

        private void btnSeleccionarExamen_Click(object sender, EventArgs e)
        {

            try
            {
                FormSeleccionarExamen form = new FormSeleccionarExamen();
                form.ShowDialog();
                if (form.HaySeleccion())
                {
                    Examen examen = form.getExamenSeleccionado();
                    controller.RegistrarSeleccionExamen(examen);
                    mostrarExamen(examen);
                }
            }
            catch(NetworkConnectionException ex) {
                notificarError();
            }
        }

        private void btnSeleccionarIngresoDetalle_Click(object sender, EventArgs e)
        {
            try
            {
                FormSeleccionarIngresoDetalle form = new FormSeleccionarIngresoDetalle();
                form.ShowDialog();
                if (form.HaySeleccion())
                {
                    IngresoDetalle idet = form.GetIngresoDetalleSeleccionado();
                    controller.RegistrarSeleccionIngresoDetalle(idet);
                    mostrarIngresoDetalle(idet);
                }
            }
            catch (NetworkConnectionException ex)
            {
                notificarError();
            }
        }

        private void notificarError()
        {
            MessageBox.Show("Error al conectarse al servidor...");
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            if(todoValido()) {
                enviarMensajeAServidor();
            }
            editando = false;
        }

        private void enviarMensajeAServidor()
        {
            var ide = getIngresoDetalleExamenActual();
            controller.EnviarMensaje(ide);
            blockearControles();
        }

        private Boolean todoValido()
        {
            Boolean valido = true;
            if(txtNombreCentro.Text.Length == 0) {
                valido = false;
                output.Text = "Seleccione el ingreso detalle al que pertenece este examen";
            }
            else if(txtNombreExamen.Text.Length == 0) {
                valido = false;
                output.Text = "Seleccione un examen";
            }
            return valido;
        }

        private IngresoDetalleExamen getIngresoDetalleExamenActual()
        {
            IngresoDetalleExamen ide = new IngresoDetalleExamen();
            ide.fechaOrden = dpFechaOrden.Value;
            ide.fechaRealizacion = dpFechaRealizacion.Value;
            ide.horaRealizacion = dpHoraRealizacion.Value;

            ide.idExamen = controller.GetExamenSeleccionado();
            ide.ingresoDetalle = controller.GetIngresoDetalleSeleccionado();
            ide.idIngresoDetalleExamen = getIdEnDialogo();

            return ide;
        }

        private int? getIdEnDialogo()
        {
            String texto = txtIdIngresoDetalleExamen.Text;
            if (texto.Length != 0)
            {
                return int.Parse(texto);
            }
            else
            {
                return null;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            desblockearControles();
            controller.RegistrarInsercion();
            limpiar();
            editando = true;
        }

        private void limpiar()
        {
            txtFechaDetalle.Text = "";
            txtIdIngresoDetalleExamen.Text = "";
            txtMedico.Text = "";
            txtNombreCentro.Text = "";
            txtNombreExamen.Text = "";
            txtPaciente.Text = "";
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if(hayRegistroSeleccionado() && borradoConfirmado()) {
                controller.RegistrarEliminacion();
                enviarMensajeAServidor();
            }
        }

        private Boolean borradoConfirmado()
        {
            String mensaje = "¿Esta seguro que desea borrar el elemento seleccionado de forma permanete?";

            DialogResult dialogResult = MessageBox.Show(mensaje, "Borrar ingreso", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                return true;
            }
            else if (dialogResult == DialogResult.No)
            {
                return false;
            }
            else
            {
                return false;
            }
        }

        private void Form1_Resize(object sender, EventArgs e)
        {
            resizePanels();
            resizeFiltros();
        }

        private void resizePanels()
        {
            int tamanio = tabla.Width / 2 + 20;
            pnlIzquierdo.Width = tamanio;
            pnlDerecho.Width = tamanio;
            pnlDerecho.Location = new Point(pnlIzquierdo.Location.X + tamanio + 6, pnlDerecho.Location.Y);
        }

        private void resizeFiltros()
        {
            int tamanio = tabla.Width / 2 - 150;
            txtFiltroApellido.Width = tamanio;
            txtFiltroNombreExamen.Width = tamanio;

            int calculoLocacionTextoExamen = txtFiltroApellido.Location.X + tamanio + 20;
            lblFiltroExamen.Location = new Point(calculoLocacionTextoExamen, lblFiltroExamen.Location.Y);
            txtFiltroNombreExamen.Location = new Point(calculoLocacionTextoExamen + lblFiltroExamen.Width + 6,
                txtFiltroNombreExamen.Location.Y);

        }

        private void updateControlesPaginado()
        {
            if (controller.hayPaginadoHaciaAdelante())
            {
                btnAdelante.Enabled = true;
            }
            else
            {
                btnAdelante.Enabled = false;
            }

            if (controller.hayPaginadoHaciaAtras())
            {
                btnAtras.Enabled = true;
            }
            else
            {
                btnAtras.Enabled = false;
            }
        }

        private void btnAdelanet_Click(object sender, EventArgs e)
        {
            controller.notificarPaginadoHaciaAdelante();
            loadData("");
        }

        private void btnAtras_Click(object sender, EventArgs e)
        {
            controller.notificarPaginadoHaciaAtras();
            loadData("");
        }

        private void txtFiltroApellido_KeyUp(object sender, KeyEventArgs e)
        {
            String filtro = txtFiltroApellido.Text.ToLower();
            controller.addFiltroApellido(filtro);
            loadData("");
        }

        private void txtFiltroNombreExamen_KeyUp(object sender, KeyEventArgs e)
        {
            String filtro = txtFiltroNombreExamen.Text.ToLower();
            controller.addFiltroNombreExamen(filtro);
            loadData("");
        }

    }
}
