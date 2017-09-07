using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ParcialTPI.vistas.Mapeo;
using ParcialTPI.vistas.Controladores;
using TareaTPI.Excepciones;

namespace ParcialTPI.vistas.vistas
{
    public partial class FormSeleccionarIngresoDetalle : Form
    {
        private IngresoDetalleController controller;

        public FormSeleccionarIngresoDetalle()
        {
            InitializeComponent();
            controller = new IngresoDetalleController();
            loadData();
            updateControlesPaginado();
            agregarPropiedadesAutoSizing();
        }

        private void agregarPropiedadesAutoSizing()
        {
            foreach (DataGridViewColumn columna in tabla.Columns)
            {
                columna.AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
            }

        }

        private void loadData()
        {
            tabla.Rows.Clear();
            var lista = controller.GetListaDatos();
            if (lista != null)
            {
                foreach (var detalle in lista)
                {
                    meterEnTabla(detalle);
                }
            }
        }

        private void meterEnTabla(IngresoDetalle ingresoDetalle)
        {
            tabla.Rows.Add(getNombresPaciente(ingresoDetalle), getApellidosMedico(ingresoDetalle), getNombreCentro(ingresoDetalle)
                , getNombreAreaCentro(ingresoDetalle), getFechaDetalle(ingresoDetalle)
                , getIdIngreso(ingresoDetalle), getIdAsignacionPersonalCentroArea(ingresoDetalle)
                , getIdAreaCentroEspacion(ingresoDetalle), getIdTurno(ingresoDetalle));
        }

        private String getNombresPaciente(IngresoDetalle ingresoDetalle)
        {
            return ingresoDetalle.ingreso.idPaciente.getNombreYApellido();
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

        public Boolean HaySeleccion()
        {
            return controller.HaySeleccion();
        }

        public IngresoDetalle GetIngresoDetalleSeleccionado()
        {
            return controller.GetIngresoDetalleSeleccionado();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.Hide();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            var pk = getIngresoDetallePKElementoSeleccionadoDesdeTabla();
            controller.RegistrarSeleccion(pk);
            this.Hide();
        }

        private void btnAtras_Click(object sender, EventArgs e)
        {
            controller.notificarPaginadoHaciaAtras();
            loadData();
            updateControlesPaginado();
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

        private void btnAdelante_Click(object sender, EventArgs e)
        {
            controller.notificarPaginadoHaciaAdelante();
            loadData();
            updateControlesPaginado();
        }

        private void txtFiltroNombreExamen_KeyUp_1(object sender, KeyEventArgs e)
        {
            String filtro = txtFiltroNombreExamen.Text.ToLower();
            controller.addFiltroNombrePaciente(filtro);
            loadData();
        }
    }
}
