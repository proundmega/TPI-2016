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
    public partial class FormSeleccionaAsignacionPersonalCentroArea : Form
    {
        private AsignacionPersonalController controller;

        public FormSeleccionaAsignacionPersonalCentroArea()
        {
            try
            {
                InitializeComponent();
                controller = new AsignacionPersonalController();
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

        public FormSeleccionaAsignacionPersonalCentroArea(AsignacionPersonalCentroAreaEspacio asignacionPersonalCentroAreaEspacio)
        {
            try
            {
                InitializeComponent();
                controller = new AsignacionPersonalController();
                loadData();
            }

            catch (NetworkConnectionException ex)
            {
                notificarAlUsuarioSobreProblemasDeConexion();
            }

        }

        private void loadData()
        {
            tabla.Rows.Clear();

            var lista = controller.GetListaDatos();

            foreach(var apcae in lista) {
                meterEnTabla(apcae);
            }

            updateControlesPaginado();
        }

        private void meterEnTabla(AsignacionPersonalCentroAreaEspacio apcae)
        {
            tabla.Rows.Add(getApellidosMedico(apcae), getNombresMedico(apcae)
                , getNombreCentro(apcae), getNombreAreaCentro(apcae), getStringFechaDesde(apcae)
                , getIdAsignacionPersonalCentroArea(apcae), getIdAreaCentroEspacio(apcae)
                , getIdTurno(apcae));
        }

        private String getApellidosMedico(AsignacionPersonalCentroAreaEspacio apcae)
        {
            return apcae.asignacionPersonalCentroArea.idPersonal.apellidos;
        }

        private String getNombresMedico(AsignacionPersonalCentroAreaEspacio apcae)
        {
            return apcae.asignacionPersonalCentroArea.idPersonal.nombres;
        }

        private String getNombreCentro(AsignacionPersonalCentroAreaEspacio apcae)
        {
            return apcae.asignacionPersonalCentroArea.idAreaCentro.idCentro.nombreCorto;
        }

        private String getNombreAreaCentro(AsignacionPersonalCentroAreaEspacio apcae)
        {
            return apcae.asignacionPersonalCentroArea.idAreaCentro.nombre;
        }

        private String getStringFechaDesde(AsignacionPersonalCentroAreaEspacio apcae)
        {
            return apcae.fechaDesde.ToShortDateString();
        }

        private String getIdAsignacionPersonalCentroArea(AsignacionPersonalCentroAreaEspacio apcae)
        {
            return apcae.asignacionPersonalCentroAreaEspacioPK.idAsignacionPersonalCentroArea.ToString();
        }

        private String getIdAreaCentroEspacio(AsignacionPersonalCentroAreaEspacio apcae)
        {
            return apcae.asignacionPersonalCentroAreaEspacioPK.idAreaCentroEspacio.ToString();
        }

        private String getIdTurno(AsignacionPersonalCentroAreaEspacio apcae)
        {
            return apcae.asignacionPersonalCentroAreaEspacioPK.idTurno.ToString();
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

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            var pkSeleccionada = getPkTuplaSeleccionada();
            controller.registrarSeleccion(pkSeleccionada);
            this.Hide();
        }

        private AsignacionPersonalCentroAreaEspacioPK getPkTuplaSeleccionada()
        {
            DataGridViewRow tuplaSeleccionada = tabla.SelectedRows[0];
            var pk = new AsignacionPersonalCentroAreaEspacioPK();
            pk.idAsignacionPersonalCentroArea = int.Parse(tuplaSeleccionada.Cells[5].Value.ToString());
            pk.idAreaCentroEspacio = int.Parse(tuplaSeleccionada.Cells[6].Value.ToString());
            pk.idTurno = int.Parse(tuplaSeleccionada.Cells[7].Value.ToString());

            return pk;
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.Hide();
        }

        public Boolean seSeleccionoAsignacion()
        {
            return controller.seSeleccionoAsignacion();
        }

        public AsignacionPersonalCentroAreaEspacio getAsignacionPersonalSeleccionado()
        {
            return controller.getAsignacionSelecionada();
        }
    }
}
