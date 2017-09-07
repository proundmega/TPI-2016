using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using TareaTPI.Mapeo;
using TareaTPI.Excepciones;

namespace TareaTPI.Vistas
{


    public partial class FormIngresoDetalle : Form
    {
        private IngresoDetalleController controller;

        public FormIngresoDetalle(Ingreso ingreso)
        {
            try
            {
                InitializeComponent();
                controller = new IngresoDetalleController(ingreso);
                loadData();
            }

            catch(NetworkConnectionException ex) {
                notificarAlUsuarioSobreProblemasDeConexion();
            }

            
        }

        private void notificarAlUsuarioSobreProblemasDeConexion()
        {
            MessageBox.Show("No se ha podido conectar al servicio... por favor intente mas tarde");
            lblOutput.Text = "Se han encontrado problemas en la conexion... intente mas tarde";
        }

        private void loadData()
        {
            tabla.Rows.Clear();
            var lista = controller.GetIngresosDetalle();
            foreach (var ingresoDetalle in lista)
            {
                meterEnTabla(ingresoDetalle);
            }

            blockearControles();
        }

        private void meterEnTabla(IngresoDetalle ingresoDetalle)
        {
            tabla.Rows.Add(getApellidosMedico(ingresoDetalle), getNombreCentro(ingresoDetalle)
                , getNombreAreaCentro(ingresoDetalle), getFechaDetalle(ingresoDetalle), getHoraDetalle(ingresoDetalle)
                , getIdIngreso(ingresoDetalle), getIdAsignacionPersonalCentroArea(ingresoDetalle)
                , getIdAreaCentroEspacion(ingresoDetalle), getIdTurno(ingresoDetalle));
        }

        private String getApellidosMedico(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.asignacionPersonalCentroAreaEspacio
                .asignacionPersonalCentroArea.idPersonal.apellidos;
        }

        private String getNombreCentro(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.asignacionPersonalCentroAreaEspacio
                .asignacionPersonalCentroArea.idAreaCentro.idCentro.nombreCorto;
        }

        private String getNombreAreaCentro(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.asignacionPersonalCentroAreaEspacio
                .asignacionPersonalCentroArea.idAreaCentro.nombre;
        }

        private String getFechaDetalle(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.fechaDetalle.ToShortDateString();
        }

        private String getHoraDetalle(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.fechaDetalle.ToShortTimeString();
        }

        private String getIdIngreso(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.ingresoDetallePK.idIngreso.ToString();
        }

        private String getIdAsignacionPersonalCentroArea(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.ingresoDetallePK.idAsignacionPersonalCentroArea.ToString();
        }

        private String getIdAreaCentroEspacion(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.ingresoDetallePK.idAreaCentroEspacio.ToString();
        }

        private String getIdTurno(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.ingresoDetallePK.idTurno.ToString();
        }

        private void tabla_SelectionChanged(object sender, EventArgs e)
        {
            mostrarTuplaSeleccionadaActualmente();
            
        }

        private void mostrarTuplaSeleccionadaActualmente()
        {
            if (tabla.SelectedRows.Count != 0)
            {
                var ingresoDetallePk = getIngresoDetallePKElementoSeleccionadoDesdeTabla();
                IngresoDetalle ingresoDetalle = controller.GetIngresoDetalleById(ingresoDetallePk);

                mostrarIngresoDetalle(ingresoDetalle);
            }
        }

        private void mostrarIngresoDetalle(IngresoDetalle ingresoDetalle)
        {
            controller.registrarAsignacionSeleccionada(ingresoDetalle.asignacionPersonalCentroAreaEspacio);
            mostrarDatosAsignacionPersonal(ingresoDetalle.asignacionPersonalCentroAreaEspacio);
            dpFechaDetalle.Value = ingresoDetalle.fechaDetalle;
            dpHoraDetalle.Value = ingresoDetalle.horaDetalle;

            if (ingresoDetalle.observaciones != null)
            {
                txaObservaciones.Text = ingresoDetalle.observaciones;
            }
        }

        private void mostrarDatosAsignacionPersonal(AsignacionPersonalCentroAreaEspacio asignacionPersonal)
        {
            txtApellidos.Text = asignacionPersonal.asignacionPersonalCentroArea.idPersonal.apellidos;
            txtNombreAreaCentro.Text = asignacionPersonal.asignacionPersonalCentroArea.idAreaCentro.nombre;
            txtNombreCentro.Text = asignacionPersonal.asignacionPersonalCentroArea.idAreaCentro.idCentro.nombreCorto;
        }

        private IngresoDetallePK getIngresoDetallePKElementoSeleccionadoDesdeTabla()
        {
            var tuplaSeleccionada = tabla.SelectedRows[0];
            var ingresoDetallePk = new IngresoDetallePK();

            ingresoDetallePk.idIngreso = int.Parse(tuplaSeleccionada.Cells[5].Value.ToString());
            ingresoDetallePk.idAsignacionPersonalCentroArea = int.Parse(tuplaSeleccionada.Cells[6].Value.ToString());
            ingresoDetallePk.idAreaCentroEspacio = int.Parse(tuplaSeleccionada.Cells[7].Value.ToString());
            ingresoDetallePk.idTurno = int.Parse(tuplaSeleccionada.Cells[8].Value.ToString());

            return ingresoDetallePk;
        }

        private void blockearControles()
        {
            setSeleccion(false);
        }

        private void desblockearControles()
        {
            setSeleccion(true);
        }

        private void setSeleccion(Boolean habilitado)
        {
            btnSeleccionarCentroYMedico.Enabled = habilitado;
            dpFechaDetalle.Enabled = habilitado;
            txaObservaciones.Enabled = habilitado;
            dpHoraDetalle.Enabled = habilitado;
            tabla.Enabled = !habilitado;
            btnEditar.Enabled = !habilitado;
            btnEliminar.Enabled = !habilitado;
            btnCancelar.Enabled = habilitado;
            btnGuardar.Enabled = habilitado;
            btnNuevo.Enabled = !habilitado;
        }

        private void btnSeleccionarCentroYMedico_Click(object sender, EventArgs e)
        {
            FormSeleccionaAsignacionPersonalCentroArea form = new FormSeleccionaAsignacionPersonalCentroArea();
            form.ShowDialog();

            if(form.seSeleccionoAsignacion()) {
                var asignacionPersonal = form.getAsignacionPersonalSeleccionado();
                controller.registrarAsignacionSeleccionada(asignacionPersonal);
                mostrarDatosAsignacionPersonal(asignacionPersonal);
            }
        }

        private void btnEditar_Click(object sender, EventArgs e)
        {
            limpiarOutput();
            desblockearControles();
            controller.notificarModificacion();
        }

        private void btnCerrar_Click(object sender, EventArgs e)
        {
            this.Hide();
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            try
            {
                if (todoValido())
                {
                    procederAEjecutarAccion();
                }
            }

            catch(NetworkConnectionException ex) {
                notificarAlUsuarioSobreProblemasDeConexion();
            }
            

        }

        private void procederAEjecutarAccion()
        {
            if (controller.seEstaModificando())
            {
                IngresoDetalle ingresoDetalle = crearIngresoDetalle();
                IngresoDetalle ingresoModificado = controller.modificar(ingresoDetalle);
                mostrarIngresoDetalle(ingresoModificado);
                lblOutput.Text = "Modificacion realizada de forma exitosa!!";
                loadData();
            }
            else if (controller.seEstaInsertando())
            {
                IngresoDetalle ingresoDetalle = crearIngresoDetalle();
                IngresoDetalle ingresoCreado = controller.Insertar(ingresoDetalle);

                mostrarIngresoDetalle(ingresoCreado);
                lblOutput.Text = "Insercion realizada de forma exitosa!!";
                loadData();
            }
        }

        private Boolean todoValido()
        {
            if(controller.getAsignacionSeleccionada() == null) {
                lblOutput.Text = "Por favor seleccione una asignacion...";
                return false;
            }
            return true;
        }

        private IngresoDetalle crearIngresoDetalle()
        {
            IngresoDetalle ingresoDetalle = new IngresoDetalle();
            ingresoDetalle.ingresoDetallePK = crearPkDesdeDatosSeleccionados();

            ingresoDetalle.observaciones = txaObservaciones.Text;
            ingresoDetalle.fechaDetalle = dpFechaDetalle.Value;
            ingresoDetalle.horaDetalle = dpHoraDetalle.Value;
            ingresoDetalle.asignacionPersonalCentroAreaEspacio = controller.getAsignacionSeleccionada();
            ingresoDetalle.ingreso = controller.getIngresoSeleccionado();

            return ingresoDetalle;
        }

        private IngresoDetallePK crearPkDesdeDatosSeleccionados()
        {
            IngresoDetallePK pk = new IngresoDetallePK();

            pk.idIngreso = controller.getIdIngreso();
            var pkAsignacion = controller.GetPkAsignacionSeleccionada();
            pk.idTurno = pkAsignacion.idTurno;
            pk.idAreaCentroEspacio = pkAsignacion.idAreaCentroEspacio;
            pk.idAsignacionPersonalCentroArea = pkAsignacion.idAsignacionPersonalCentroArea;

            return pk;
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            limpiar();
            blockearControles();
            mostrarTuplaSeleccionadaActualmente();
            controller.notificarAccionCancelada();
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            desblockearControles();
            limpiar();
            controller.notificarInsercion();
        }

        private void limpiar()
        {
            txtApellidos.Text = "";
            txtNombreAreaCentro.Text = "";
            txtNombreCentro.Text = "";
            controller.registrarAsignacionSeleccionada(null);
            txaObservaciones.Text = "";
            dpFechaDetalle.Value = DateTime.Now;
            dpHoraDetalle.Value = DateTime.Now;
            lblOutput.Text = "";
        }

        private void limpiarOutput()
        {
            lblOutput.Text = "";
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            try
            {
                if (tabla.SelectedRows.Count != 0)
                {
                    if (borradoConfirmado())
                    {
                        procederAEliminar();
                    }
                }
            }
            catch(NetworkConnectionException ex) {
                notificarAlUsuarioSobreProblemasDeConexion();
            }

            
        }

        private void procederAEliminar()
        {
            IngresoDetallePK pk = getIngresoDetallePKElementoSeleccionadoDesdeTabla();
            blockearControles();
            loadData();
            if (controller.Eliminar(pk))
            {
                lblOutput.Text = "Elemento eliminado de forma exitosa!!";
                loadData();
            }
            else
            {
                lblOutput.Text = "No se pudo eliminar el elemento seleccionado";
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
    }
}
