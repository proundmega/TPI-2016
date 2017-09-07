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
using TareaTPI.Vistas;
using TareaTPI.Excepciones;

namespace TareaTPI.Vistas
{
    public partial class FormSeleccionarPaciente : Form
    {
        private PacienteController controller;

        public FormSeleccionarPaciente()
        {
            try
            {
                InitializeComponent();
                controller = new PacienteController();
                controller.setPacienteSeleccionado(null);
                loadData();
            }

            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioSobreProblemasDeConexion();
            }
        }

        private void notificarAlUsuarioSobreProblemasDeConexion()
        {
            MessageBox.Show("No se ha podido conectar al servicio... por favor intente mas tarde");
        }

        public FormSeleccionarPaciente(Paciente paciente)
        {
            try
            {
                InitializeComponent();
                controller = new PacienteController();
                controller.setPacienteSeleccionado(paciente);
                loadData();
            }

            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioSobreProblemasDeConexion();
            }
        }

        private void loadData()
        {
            vaciarTabla();
            List<Paciente> pacientes = controller.GetListaDatos();
            if (pacientes != null)
            {
                mostrarDatosEnTabla(pacientes);
                updateControlesPaginado();
            }
            else
            {
                MessageBox.Show("Se ha detectado un problema obteniendo los datos... por favor intente mas tarde");
            }
        }

        private void vaciarTabla()
        {
            tablaPaciente.Rows.Clear();
        }

        private void mostrarDatosEnTabla(List<Paciente> listaPacientes)
        {
            foreach (Paciente paciente in listaPacientes)
            {
                tablaPaciente.Rows.Add(paciente.idPaciente, paciente.nombres,
                    paciente.apellidos, getStringFecha(paciente.fechaNacimiento));
            }
        }

        private String getStringFecha(DateTime fecha)
        {
            if (DateTime.MinValue.Equals(fecha))
            {
                return "";
            }
            else
            {
                return fecha.ToShortDateString();
            }
        }

        private void btnAtras_Click(object sender, EventArgs e)
        {
            try
            {
                controller.notificarPaginadoHaciaAtras();
                loadData();
            }

            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioSobreProblemasDeConexion();
            }
        }

        private void btnAdelante_Click(object sender, EventArgs e)
        {
            try
            {
                controller.notificarPaginadoHaciaAdelante();
                loadData();
            }

            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioSobreProblemasDeConexion();
            }
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

        public Boolean seSeleccionoPaciente()
        {
            return controller.seSeleccionoPaciente();
        }

        public Paciente GetPacienteSeleccionado()
        {
            return controller.getPacienteSeleccionado();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.Hide();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            DataGridViewRow tuplaSeleccionada = tablaPaciente.SelectedRows[0];
            String idPacienteSeleccionada = tuplaSeleccionada.Cells[0].Value.ToString();
            controller.registrarSeleccion(int.Parse(idPacienteSeleccionada));
            this.Hide();
        }
    }
}
