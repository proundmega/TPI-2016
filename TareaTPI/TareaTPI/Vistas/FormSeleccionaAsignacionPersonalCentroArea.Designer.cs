namespace TareaTPI.Vistas
{
    partial class FormSeleccionaAsignacionPersonalCentroArea
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
            this.tabla = new System.Windows.Forms.DataGridView();
            this.apellidosMedico = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreMedico = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreCentro = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreAreaCentro = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fechaDesde = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idAsignacionPersonalCentroE = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idAreaCentroEspacio = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idTurno = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnAtras = new System.Windows.Forms.Button();
            this.btnAdelante = new System.Windows.Forms.Button();
            this.btnSeleccionar = new System.Windows.Forms.Button();
            this.btnCancelar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.tabla)).BeginInit();
            this.SuspendLayout();
            // 
            // tabla
            // 
            this.tabla.AllowUserToAddRows = false;
            this.tabla.AllowUserToDeleteRows = false;
            this.tabla.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.tabla.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.apellidosMedico,
            this.nombreMedico,
            this.nombreCentro,
            this.nombreAreaCentro,
            this.fechaDesde,
            this.idAsignacionPersonalCentroE,
            this.idAreaCentroEspacio,
            this.idTurno});
            this.tabla.Location = new System.Drawing.Point(46, 44);
            this.tabla.MultiSelect = false;
            this.tabla.Name = "tabla";
            this.tabla.ReadOnly = true;
            this.tabla.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.tabla.Size = new System.Drawing.Size(544, 213);
            this.tabla.TabIndex = 0;
            // 
            // apellidosMedico
            // 
            this.apellidosMedico.HeaderText = "Apellidos del medico";
            this.apellidosMedico.Name = "apellidosMedico";
            this.apellidosMedico.ReadOnly = true;
            // 
            // nombreMedico
            // 
            this.nombreMedico.HeaderText = "Nombre del medico";
            this.nombreMedico.Name = "nombreMedico";
            this.nombreMedico.ReadOnly = true;
            // 
            // nombreCentro
            // 
            this.nombreCentro.HeaderText = "Nombre del centro";
            this.nombreCentro.Name = "nombreCentro";
            this.nombreCentro.ReadOnly = true;
            // 
            // nombreAreaCentro
            // 
            this.nombreAreaCentro.HeaderText = "Nombre area de centro";
            this.nombreAreaCentro.Name = "nombreAreaCentro";
            this.nombreAreaCentro.ReadOnly = true;
            // 
            // fechaDesde
            // 
            this.fechaDesde.HeaderText = "Fecha desde";
            this.fechaDesde.Name = "fechaDesde";
            this.fechaDesde.ReadOnly = true;
            // 
            // idAsignacionPersonalCentroE
            // 
            this.idAsignacionPersonalCentroE.HeaderText = "Asignacion personal centro espacio";
            this.idAsignacionPersonalCentroE.Name = "idAsignacionPersonalCentroE";
            this.idAsignacionPersonalCentroE.ReadOnly = true;
            this.idAsignacionPersonalCentroE.Visible = false;
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
            // btnAtras
            // 
            this.btnAtras.Location = new System.Drawing.Point(231, 287);
            this.btnAtras.Name = "btnAtras";
            this.btnAtras.Size = new System.Drawing.Size(75, 23);
            this.btnAtras.TabIndex = 1;
            this.btnAtras.Text = "<";
            this.btnAtras.UseVisualStyleBackColor = true;
            this.btnAtras.Click += new System.EventHandler(this.btnAtras_Click);
            // 
            // btnAdelante
            // 
            this.btnAdelante.Location = new System.Drawing.Point(367, 287);
            this.btnAdelante.Name = "btnAdelante";
            this.btnAdelante.Size = new System.Drawing.Size(75, 23);
            this.btnAdelante.TabIndex = 2;
            this.btnAdelante.Text = ">";
            this.btnAdelante.UseVisualStyleBackColor = true;
            this.btnAdelante.Click += new System.EventHandler(this.btnAdelante_Click);
            // 
            // btnSeleccionar
            // 
            this.btnSeleccionar.Location = new System.Drawing.Point(461, 388);
            this.btnSeleccionar.Name = "btnSeleccionar";
            this.btnSeleccionar.Size = new System.Drawing.Size(83, 24);
            this.btnSeleccionar.TabIndex = 3;
            this.btnSeleccionar.Text = "Seleccionar";
            this.btnSeleccionar.UseVisualStyleBackColor = true;
            this.btnSeleccionar.Click += new System.EventHandler(this.btnSeleccionar_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.Location = new System.Drawing.Point(550, 388);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(75, 23);
            this.btnCancelar.TabIndex = 4;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.UseVisualStyleBackColor = true;
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // FormSeleccionaAsignacionPersonalCentroArea
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(637, 423);
            this.Controls.Add(this.btnCancelar);
            this.Controls.Add(this.btnSeleccionar);
            this.Controls.Add(this.btnAdelante);
            this.Controls.Add(this.btnAtras);
            this.Controls.Add(this.tabla);
            this.Name = "FormSeleccionaAsignacionPersonalCentroArea";
            this.Text = "FormSeleccionaAsignacionPersonalCentroArea";
            ((System.ComponentModel.ISupportInitialize)(this.tabla)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView tabla;
        private System.Windows.Forms.Button btnAtras;
        private System.Windows.Forms.Button btnAdelante;
        private System.Windows.Forms.DataGridViewTextBoxColumn apellidosMedico;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreMedico;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreCentro;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreAreaCentro;
        private System.Windows.Forms.DataGridViewTextBoxColumn fechaDesde;
        private System.Windows.Forms.DataGridViewTextBoxColumn idAsignacionPersonalCentroE;
        private System.Windows.Forms.DataGridViewTextBoxColumn idAreaCentroEspacio;
        private System.Windows.Forms.DataGridViewTextBoxColumn idTurno;
        private System.Windows.Forms.Button btnSeleccionar;
        private System.Windows.Forms.Button btnCancelar;
    }
}