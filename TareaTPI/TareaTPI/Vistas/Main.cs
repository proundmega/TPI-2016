using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using TareaTPI.Excepciones;
using TareaTPI.Mapeo;


// <>
namespace TareaTPI.Vistas
{
    public partial class FormMain : Form
    {
        private IngresoController controller;
        private DataGridViewRow tuplaActual;
        private DateFormattersController dateController;

        public FormMain()
        {
            try
            {
                InitializeComponent();
                controller = new IngresoController();
                dateController = new DateFormattersController(dpFechaIngreso, dpHoraIngreso,
                    dpFechaEgreso, dpHoraEgreso);

                loadData();
                blockearControles();
            }
            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioProblemasDeConexion();
            }

        }

        private void loadData()
        {
            try
            {
                prepararTabla();
                prepararListaTipoIngreso();
            }
            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioProblemasDeConexion();
            }
            
        }

        private void prepararTabla()
        {
            vaciarTabla();

            List<Ingreso> listaIngresos = controller.GetListaDatos();
            prepararTablaYDatos(listaIngresos);
            updateControlesPaginado();

        }

        private void notificarAlUsuarioProblemasDeConexion()
        {
            MessageBox.Show("Han habido problemas al cargar los datos... Intente mas tarde");
            blockearControles();
        }

        private void prepararTablaYDatos(List<Ingreso> listaIngresos) {
            foreach(Ingreso ingreso in listaIngresos){
                tabla.Rows.Add(ingreso.idIngreso, dateController.getStringFecha(ingreso.fechaIngreso),
                    dateController.getStringHora(ingreso.horaIngreso), dateController.getStringFecha(ingreso.fechaEgreso),
                    dateController.getStringHora(ingreso.horaEgreso), ingreso.idPaciente.apellidos);
            }
        }

        private void vaciarTabla() {
            tabla.Rows.Clear();
        }

        private void updateControlesPaginado() {
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
            else {
                btnAtras.Enabled = false;
            }
        }

        private void prepararListaTipoIngreso()
        {
            vaciarLista();

            List<TipoIngreso> lista = controller.getTiposIngreso();
            foreach (TipoIngreso tipo in lista)
            {
                cmbTipoIngreso.Items.Add(tipo.nombre);

            }
        }

        private void vaciarLista()
        {
            cmbTipoIngreso.Items.Clear();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            try
            {
                controller.notificarPaginadoHaciaAtras();
                loadData();
            }
            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioProblemasDeConexion();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                controller.notificarPaginadoHaciaAdelante();
                loadData();
            }
            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioProblemasDeConexion();
            }
            
        }

        private void tabla_SelectionChanged(object sender, EventArgs e)
        {
            if (tabla.SelectedRows.Count != 0)
            {
                var tuplaSeleccionada = tabla.SelectedRows[0];
                prepararDatosEnSeleccion(tuplaSeleccionada);

                btnEditarIngreso.Enabled = true;
            }

            else {

                btnEditarIngreso.Enabled = false;
            }

        }

        private void prepararDatosEnSeleccion(DataGridViewRow tuplaSeleccionada)
        {
            String idIngreso = tuplaSeleccionada.Cells[0].Value.ToString();
            Ingreso ingreso = controller.getIngresoById(idIngreso);

            prepararIngresoAMostrar(ingreso);
        }

        private void prepararIngresoAMostrar(Ingreso ingreso)
        {
            txtIdIngreso.Text = ingreso.idIngreso.ToString();
            prepararTextoPaciente(ingreso.idPaciente);
            dateController.prepararTiempoDatePicker(dpHoraIngreso, ingreso.horaIngreso);
            dateController.prepararFechaDatePicker(dpFechaIngreso, ingreso.fechaIngreso);
            dateController.prepararTiempoDatePicker(dpHoraEgreso, ingreso.horaEgreso);
            dateController.prepararFechaDatePicker(dpFechaEgreso, ingreso.fechaEgreso);
            prepararComboBoxTipoIngresoSeleccionado(ingreso.idTipoIngreso);
            txaObservaciones.Text = ingreso.observaciones;
        }

        private void prepararTextoPaciente(Paciente paciente) {
            String nombres = paciente.nombres;
            String apellidos = paciente.apellidos;
            txtPaciente.Text = apellidos + ", " + nombres;
            controller.registrarPacienteSeleccionado(paciente);
        }

        private void prepararComboBoxTipoIngresoSeleccionado(TipoIngreso tipoIngreso)
        {
            cmbTipoIngreso.SelectedItem = tipoIngreso.nombre;
        }

        private void btnEditarIngreso_Click(object sender, EventArgs e)
        {
            if (tabla.SelectedRows.Count != 0)
            {
                desblockearControles();
                controller.notificarModificacion();
                tuplaActual = tabla.SelectedRows[0];
            }
            else
            {
                try
                {
                    loadData();
                }
                catch (NetworkConnectionException ex)
                {
                    notificarAlUsuarioProblemasDeConexion();
                }
            }
        }

        private void blockearControles() {
            setHabilidatoControles(false);
        }

        private void desblockearControles() {
            setHabilidatoControles(true);       
        }

        private void setHabilidatoControles(Boolean habilidato) {
            dpFechaEgreso.Enabled = habilidato;
            dpFechaIngreso.Enabled = habilidato;
            dpHoraEgreso.Enabled = habilidato;
            dpHoraIngreso.Enabled = habilidato;
            txaObservaciones.Enabled = habilidato;
            btnSeleccionarPaciente.Enabled = habilidato;
            tabla.Enabled = !habilidato;
            btnCancelar.Enabled = habilidato;
            btnGuardar.Enabled = habilidato;
            btnEditarIngreso.Enabled = !habilidato;
            cmbTipoIngreso.Enabled = habilidato;
            btnEliminar.Enabled = !habilidato;
            btnIngresoDetalle.Enabled = !habilidato;
            btnNuevo.Enabled = !habilidato;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormSeleccionarPaciente form = new FormSeleccionarPaciente(controller.GetPacienteSeleccionado());
            form.ShowDialog();
            if(form.seSeleccionoPaciente()) {
                controller.registrarPacienteSeleccionado(form.GetPacienteSeleccionado());
                prepararTextoPaciente(controller.GetPacienteSeleccionado());
            }
            
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            controller.notificarAccionCancelada();
            blockearControles();
            prepararDatosEnSeleccion(tuplaActual);
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            try
            {
                if(todoValido()) {
                    procederAEjecutarAccion();
                }
            }
            catch(NetworkConnectionException ex) {
                notificarAlUsuarioProblemasDeConexion();
            }

        }

        private Boolean todoValido()
        {
            if(controller.GetPacienteSeleccionado() == null) {
                lblOutput.Text = "Debes de seleccionar a un paciente";
                return false;
            }
            return true;
        }

        private void procederAEjecutarAccion()
        {
            if (controller.seEstaModificando())
            {
                blockearControles();
                Ingreso ingresoCreado = crearIngreso();
                Ingreso ingresoModificado = controller.EjecutarAccion(ingresoCreado);

                updateDatos(ingresoModificado);

                lblOutput.Text = "Modificaciones hechas de forma exitosa!";
            }
            else
            {
                blockearControles();
                Ingreso ingresoObtenido = crearIngreso();
                Ingreso ingresoCreado = controller.EjecutarAccion(ingresoObtenido);

                updateDatos(ingresoCreado);

                lblOutput.Text = "Creacion de ingreso de forma exitosa!";
            }
        }

        private void updateDatos(Ingreso ingreso)
        {
            loadData();
            prepararIngresoAMostrar(ingreso);
            mostrarIngresoSeleccionadoEntabla(ingreso);
        }

        private void mostrarIngresoSeleccionadoEntabla(Ingreso ingreso)
        {
            for (int i = 0; i < tabla.Rows.Count; i++ )
            {
                var tupla = tabla.Rows[i];
                int idIngresoEnTupla = int.Parse(tupla.Cells[0].Value.ToString());
                if(idIngresoEnTupla == ingreso.idIngreso){
                    tabla.Rows[i].Selected = true;
                }
            }
        }

        private Ingreso crearIngreso()
        {
            Ingreso ingreso = new Ingreso();
            ingreso.idIngreso = txtIdIngreso.Text.Length == 0 ? (int?)null : int.Parse(txtIdIngreso.Text);
            ingreso.idPaciente = controller.GetPacienteSeleccionado();
            ingreso.fechaIngreso = dpFechaIngreso.Value;
            ingreso.horaIngreso = dpHoraIngreso.Value;

            ingreso.horaEgreso = dateController.getHoraEgreso();
            ingreso.fechaEgreso = dateController.getFechaEgreso();
            ingreso.observaciones = txaObservaciones.Text;

            String nombreTipoIngreso = cmbTipoIngreso.SelectedItem.ToString();
            ingreso.idTipoIngreso = controller.getTipoIngresoByNombre(nombreTipoIngreso);
            return ingreso;
        }

        private void dpFechaEgreso_Enter(object sender, EventArgs e)
        {
            dateController.unlockComponentesEgreso();
        }

        private void dpHoraEgreso_Enter(object sender, EventArgs e)
        {
            dateController.unlockComponentesEgreso();
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            if (tabla.SelectedRows.Count != 0)
            {
                tuplaActual = tabla.SelectedRows[0];
                limpiarControles();
                desblockearControles();
                controller.notificarInsercion();
            }
            else
            {
                loadData();
            }
        }

        private void limpiarControles()
        {
            txtIdIngreso.Text = "";
            txtPaciente.Text = "";
            dpFechaIngreso.Value = DateTime.Now;
            dpHoraIngreso.Value = DateTime.Now;
            dateController.ponerEnNuloAmbosEgresos();
            txaObservaciones.Text = "";
            cmbTipoIngreso.SelectedIndex = 1;
            controller.registrarPacienteSeleccionado(null);
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            try
            {
                if (borradoConfirmado())
                {
                    int idIngreso = int.Parse(txtIdIngreso.Text);
                    if (controller.eliminar(idIngreso))
                    {
                        lblOutput.Text = "Elemento eliminado de forma exitosa";
                        loadData();
                    }
                    else
                    {
                        lblOutput.Text = "No se pudo borrar el elemento seleccionado...";
                    }
                }

            }
            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioProblemasDeConexion();
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

        private Boolean hayElementoSeleccionado()
        {
            return tabla.RowCount != 0 && txtIdIngreso.Text.Length != 0;
        }

        private void btnIngresoDetalle_Click(object sender, EventArgs e)
        {
            Ingreso ingresoSeleccionado = controller.getIngresoById(txtIdIngreso.Text);
            FormIngresoDetalle form = new FormIngresoDetalle(ingresoSeleccionado);
            form.ShowDialog();
        }
    }
}
