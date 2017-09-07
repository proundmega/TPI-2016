namespace ParcialTPI.vistas.vistas
{
    partial class FormSeleccionarIngresoDetalle
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormSeleccionarIngresoDetalle));
            this.tabla = new System.Windows.Forms.DataGridView();
            this.paciente = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.apellidosMedico = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreCentro = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreAreaCentro = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.diaDetalle = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idIngreso = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idAsignacionPersonalCentroArea = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idAreaCentroEspacio = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idTurno = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnAceptar = new System.Windows.Forms.Button();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.btnAtras = new System.Windows.Forms.Button();
            this.btnAdelante = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.txtFiltroNombreExamen = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.tabla)).BeginInit();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // tabla
            // 
            this.tabla.AllowUserToAddRows = false;
            this.tabla.AllowUserToDeleteRows = false;
            this.tabla.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tabla.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.tabla.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.paciente,
            this.apellidosMedico,
            this.nombreCentro,
            this.nombreAreaCentro,
            this.diaDetalle,
            this.idIngreso,
            this.idAsignacionPersonalCentroArea,
            this.idAreaCentroEspacio,
            this.idTurno});
            this.tabla.Location = new System.Drawing.Point(37, 77);
            this.tabla.MultiSelect = false;
            this.tabla.Name = "tabla";
            this.tabla.ReadOnly = true;
            this.tabla.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.tabla.Size = new System.Drawing.Size(634, 238);
            this.tabla.TabIndex = 1;
            // 
            // paciente
            // 
            this.paciente.HeaderText = "Nombre de paciente";
            this.paciente.Name = "paciente";
            this.paciente.ReadOnly = true;
            // 
            // apellidosMedico
            // 
            this.apellidosMedico.HeaderText = "Apellidos medico";
            this.apellidosMedico.Name = "apellidosMedico";
            this.apellidosMedico.ReadOnly = true;
            // 
            // nombreCentro
            // 
            this.nombreCentro.HeaderText = "Nombre del centro";
            this.nombreCentro.Name = "nombreCentro";
            this.nombreCentro.ReadOnly = true;
            // 
            // nombreAreaCentro
            // 
            this.nombreAreaCentro.HeaderText = "Nombre de area de centro";
            this.nombreAreaCentro.Name = "nombreAreaCentro";
            this.nombreAreaCentro.ReadOnly = true;
            // 
            // diaDetalle
            // 
            this.diaDetalle.HeaderText = "Fecha del detalle";
            this.diaDetalle.Name = "diaDetalle";
            this.diaDetalle.ReadOnly = true;
            // 
            // idIngreso
            // 
            this.idIngreso.HeaderText = "Id ingreso";
            this.idIngreso.Name = "idIngreso";
            this.idIngreso.ReadOnly = true;
            // 
            // idAsignacionPersonalCentroArea
            // 
            this.idAsignacionPersonalCentroArea.HeaderText = "Id Asignacion personal centro area";
            this.idAsignacionPersonalCentroArea.Name = "idAsignacionPersonalCentroArea";
            this.idAsignacionPersonalCentroArea.ReadOnly = true;
            this.idAsignacionPersonalCentroArea.Visible = false;
            // 
            // idAreaCentroEspacio
            // 
            this.idAreaCentroEspacio.HeaderText = "Id area centro espacio";
            this.idAreaCentroEspacio.Name = "idAreaCentroEspacio";
            this.idAreaCentroEspacio.ReadOnly = true;
            this.idAreaCentroEspacio.Visible = false;
            // 
            // idTurno
            // 
            this.idTurno.HeaderText = "Id turno";
            this.idTurno.Name = "idTurno";
            this.idTurno.ReadOnly = true;
            this.idTurno.Visible = false;
            // 
            // btnAceptar
            // 
            this.btnAceptar.Location = new System.Drawing.Point(545, 444);
            this.btnAceptar.Name = "btnAceptar";
            this.btnAceptar.Size = new System.Drawing.Size(75, 23);
            this.btnAceptar.TabIndex = 2;
            this.btnAceptar.Text = "Aceptar";
            this.btnAceptar.UseVisualStyleBackColor = true;
            this.btnAceptar.Click += new System.EventHandler(this.btnAceptar_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.Location = new System.Drawing.Point(626, 444);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(75, 23);
            this.btnCancelar.TabIndex = 3;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.UseVisualStyleBackColor = true;
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // btnAtras
            // 
            this.btnAtras.Location = new System.Drawing.Point(249, 336);
            this.btnAtras.Name = "btnAtras";
            this.btnAtras.Size = new System.Drawing.Size(75, 23);
            this.btnAtras.TabIndex = 4;
            this.btnAtras.Text = "<";
            this.btnAtras.UseVisualStyleBackColor = true;
            this.btnAtras.Click += new System.EventHandler(this.btnAtras_Click);
            // 
            // btnAdelante
            // 
            this.btnAdelante.Location = new System.Drawing.Point(371, 336);
            this.btnAdelante.Name = "btnAdelante";
            this.btnAdelante.Size = new System.Drawing.Size(75, 23);
            this.btnAdelante.TabIndex = 5;
            this.btnAdelante.Text = ">";
            this.btnAdelante.UseVisualStyleBackColor = true;
            this.btnAdelante.Click += new System.EventHandler(this.btnAdelante_Click);
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.Silver;
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Controls.Add(this.pictureBox1);
            this.panel1.Controls.Add(this.txtFiltroNombreExamen);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Location = new System.Drawing.Point(37, 27);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(634, 43);
            this.panel1.TabIndex = 6;
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(16, -1);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(61, 43);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 3;
            this.pictureBox1.TabStop = false;
            // 
            // txtFiltroNombreExamen
            // 
            this.txtFiltroNombreExamen.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtFiltroNombreExamen.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtFiltroNombreExamen.Location = new System.Drawing.Point(196, 9);
            this.txtFiltroNombreExamen.Name = "txtFiltroNombreExamen";
            this.txtFiltroNombreExamen.Size = new System.Drawing.Size(323, 26);
            this.txtFiltroNombreExamen.TabIndex = 2;
            this.txtFiltroNombreExamen.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtFiltroNombreExamen_KeyUp_1);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(102, 9);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(88, 24);
            this.label2.TabIndex = 1;
            this.label2.Text = "Paciente:";
            // 
            // FormSeleccionarIngresoDetalle
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Lavender;
            this.ClientSize = new System.Drawing.Size(713, 474);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.btnAdelante);
            this.Controls.Add(this.btnAtras);
            this.Controls.Add(this.btnCancelar);
            this.Controls.Add(this.btnAceptar);
            this.Controls.Add(this.tabla);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FormSeleccionarIngresoDetalle";
            this.Text = "Seleccionar Ingreso Detalle";
            ((System.ComponentModel.ISupportInitialize)(this.tabla)).EndInit();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView tabla;
        private System.Windows.Forms.Button btnAceptar;
        private System.Windows.Forms.Button btnCancelar;
        private System.Windows.Forms.Button btnAtras;
        private System.Windows.Forms.Button btnAdelante;
        private System.Windows.Forms.DataGridViewTextBoxColumn paciente;
        private System.Windows.Forms.DataGridViewTextBoxColumn apellidosMedico;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreCentro;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreAreaCentro;
        private System.Windows.Forms.DataGridViewTextBoxColumn diaDetalle;
        private System.Windows.Forms.DataGridViewTextBoxColumn idIngreso;
        private System.Windows.Forms.DataGridViewTextBoxColumn idAsignacionPersonalCentroArea;
        private System.Windows.Forms.DataGridViewTextBoxColumn idAreaCentroEspacio;
        private System.Windows.Forms.DataGridViewTextBoxColumn idTurno;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.TextBox txtFiltroNombreExamen;
        private System.Windows.Forms.Label label2;

    }
}