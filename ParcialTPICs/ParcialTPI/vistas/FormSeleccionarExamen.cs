using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ParcialTPI.vistas.Controladores;
using ParcialTPI.vistas.Mapeo;

namespace ParcialTPI.vistas.vistas
{
    public partial class FormSeleccionarExamen : Form
    {
        private ExamenController controller;

        public FormSeleccionarExamen()
        {
            InitializeComponent();
            controller = new ExamenController();
            agregarPropiedadesAutoSizing();
            loadData();
            updateControlesPaginado();
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
            if(lista != null) {
                foreach(var examen in lista) {
                    agregarExamen(examen);
                }
            }
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

        private void agregarExamen(Examen examen)
        {
            tabla.Rows.Add(examen.idExamen, examen.nombre, 
                examen.activo ? "Si" : "No", examen.idTipoExamen.nombre);
        }

        private void btnAtras_Click(object sender, EventArgs e)
        {
            controller.notificarPaginadoHaciaAtras();
            updateControlesPaginado();
            loadData();
        }

        private void btnAdelante_Click(object sender, EventArgs e)
        {
            controller.notificarPaginadoHaciaAdelante();
            updateControlesPaginado();
            loadData();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            int idSeleccionada = getIdSeleccionada();
            controller.RegistrarSeleccion(idSeleccionada);
            this.Hide();
        }

        private int getIdSeleccionada()
        {
            return int.Parse(tabla.SelectedRows[0].Cells[0].Value.ToString());
        }

        public Boolean HaySeleccion()
        {
            return controller.HaySeleccion();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.Hide();
        }

        public Examen getExamenSeleccionado()
        {
            return controller.GetExamenSeleccionado();
        }

        private void txtFiltroNombreExamen_KeyUp_1(object sender, KeyEventArgs e)
        {
            String filtro = txtFiltroNombreExamen.Text.ToLower();
            controller.addFiltroNombreExamen(filtro);
            loadData();
        }
    }
}
