namespace TareaTPI.Vistas
{
    partial class FormIngresoDetalle
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
            this.nombreCentro = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreAreaCentro = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.diaDetalle = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.horaDetalle = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idIngreso = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idAsignacionPersonalCentroArea = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idAreaCentroEspacio = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idTurno = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnEditar = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.txtNombreCentro = new System.Windows.Forms.TextBox();
            this.txtNombreAreaCentro = new System.Windows.Forms.TextBox();
            this.txtApellidos = new System.Windows.Forms.TextBox();
            this.btnSeleccionarCentroYMedico = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.dpFechaDetalle = new System.Windows.Forms.DateTimePicker();
            this.btnGuardar = new System.Windows.Forms.Button();
            this.btnCerrar = new System.Windows.Forms.Button();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.txaObservaciones = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.dpHoraDetalle = new System.Windows.Forms.DateTimePicker();
            this.lblOutput = new System.Windows.Forms.Label();
            this.btnNuevo = new System.Windows.Forms.Button();
            this.btnEliminar = new System.Windows.Forms.Button();
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
            this.nombreCentro,
            this.nombreAreaCentro,
            this.diaDetalle,
            this.horaDetalle,
            this.idIngreso,
            this.idAsignacionPersonalCentroArea,
            this.idAreaCentroEspacio,
            this.idTurno});
            this.tabla.Location = new System.Drawing.Point(47, 42);
            this.tabla.MultiSelect = false;
            this.tabla.Name = "tabla";
            this.tabla.ReadOnly = true;
            this.tabla.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.tabla.Size = new System.Drawing.Size(634, 290);
            this.tabla.TabIndex = 0;
            this.tabla.SelectionChanged += new System.EventHandler(this.tabla_SelectionChanged);
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
            // horaDetalle
            // 
            this.horaDetalle.HeaderText = "Hora del detalle";
            this.horaDetalle.Name = "horaDetalle";
            this.horaDetalle.ReadOnly = true;
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
            // btnEditar
            // 
            this.btnEditar.Location = new System.Drawing.Point(159, 609);
            this.btnEditar.Name = "btnEditar";
            this.btnEditar.Size = new System.Drawing.Size(88, 23);
            this.btnEditar.TabIndex = 1;
            this.btnEditar.Text = "Editar";
            this.btnEditar.UseVisualStyleBackColor = true;
            this.btnEditar.Click += new System.EventHandler(this.btnEditar_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(86, 441);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(97, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Nombre del centro:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(45, 477);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(138, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Nombre del area del centro:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(77, 403);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(106, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Apellidos del medico:";
            // 
            // txtNombreCentro
            // 
            this.txtNombreCentro.Enabled = false;
            this.txtNombreCentro.Location = new System.Drawing.Point(189, 438);
            this.txtNombreCentro.Name = "txtNombreCentro";
            this.txtNombreCentro.Size = new System.Drawing.Size(171, 20);
            this.txtNombreCentro.TabIndex = 5;
            // 
            // txtNombreAreaCentro
            // 
            this.txtNombreAreaCentro.Enabled = false;
            this.txtNombreAreaCentro.Location = new System.Drawing.Point(189, 477);
            this.txtNombreAreaCentro.Name = "txtNombreAreaCentro";
            this.txtNombreAreaCentro.Size = new System.Drawing.Size(171, 20);
            this.txtNombreAreaCentro.TabIndex = 6;
            // 
            // txtApellidos
            // 
            this.txtApellidos.Enabled = false;
            this.txtApellidos.Location = new System.Drawing.Point(189, 400);
            this.txtApellidos.Name = "txtApellidos";
            this.txtApellidos.Size = new System.Drawing.Size(171, 20);
            this.txtApellidos.TabIndex = 7;
            // 
            // btnSeleccionarCentroYMedico
            // 
            this.btnSeleccionarCentroYMedico.Location = new System.Drawing.Point(118, 516);
            this.btnSeleccionarCentroYMedico.Name = "btnSeleccionarCentroYMedico";
            this.btnSeleccionarCentroYMedico.Size = new System.Drawing.Size(195, 23);
            this.btnSeleccionarCentroYMedico.TabIndex = 8;
            this.btnSeleccionarCentroYMedico.Text = "Seleccionar otro centro y medico";
            this.btnSeleccionarCentroYMedico.UseVisualStyleBackColor = true;
            this.btnSeleccionarCentroYMedico.Click += new System.EventHandler(this.btnSeleccionarCentroYMedico_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(393, 400);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(74, 13);
            this.label4.TabIndex = 9;
            this.label4.Text = "Fecha detalle:";
            // 
            // dpFechaDetalle
            // 
            this.dpFechaDetalle.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.dpFechaDetalle.Location = new System.Drawing.Point(471, 397);
            this.dpFechaDetalle.Name = "dpFechaDetalle";
            this.dpFechaDetalle.Size = new System.Drawing.Size(200, 20);
            this.dpFechaDetalle.TabIndex = 10;
            // 
            // btnGuardar
            // 
            this.btnGuardar.Location = new System.Drawing.Point(471, 609);
            this.btnGuardar.Name = "btnGuardar";
            this.btnGuardar.Size = new System.Drawing.Size(75, 23);
            this.btnGuardar.TabIndex = 11;
            this.btnGuardar.Text = "Guardar";
            this.btnGuardar.UseVisualStyleBackColor = true;
            this.btnGuardar.Click += new System.EventHandler(this.btnGuardar_Click);
            // 
            // btnCerrar
            // 
            this.btnCerrar.Location = new System.Drawing.Point(652, 609);
            this.btnCerrar.Name = "btnCerrar";
            this.btnCerrar.Size = new System.Drawing.Size(75, 23);
            this.btnCerrar.TabIndex = 12;
            this.btnCerrar.Text = "Cerrar";
            this.btnCerrar.UseVisualStyleBackColor = true;
            this.btnCerrar.Click += new System.EventHandler(this.btnCerrar_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.Location = new System.Drawing.Point(564, 609);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(75, 23);
            this.btnCancelar.TabIndex = 13;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.UseVisualStyleBackColor = true;
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(386, 474);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(81, 13);
            this.label5.TabIndex = 14;
            this.label5.Text = "Observaciones:";
            // 
            // txaObservaciones
            // 
            this.txaObservaciones.Location = new System.Drawing.Point(473, 474);
            this.txaObservaciones.Multiline = true;
            this.txaObservaciones.Name = "txaObservaciones";
            this.txaObservaciones.Size = new System.Drawing.Size(198, 102);
            this.txaObservaciones.TabIndex = 15;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(400, 438);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(67, 13);
            this.label6.TabIndex = 16;
            this.label6.Text = "Hora detalle:";
            // 
            // dpHoraDetalle
            // 
            this.dpHoraDetalle.Format = System.Windows.Forms.DateTimePickerFormat.Time;
            this.dpHoraDetalle.Location = new System.Drawing.Point(473, 438);
            this.dpHoraDetalle.Name = "dpHoraDetalle";
            this.dpHoraDetalle.Size = new System.Drawing.Size(198, 20);
            this.dpHoraDetalle.TabIndex = 17;
            // 
            // lblOutput
            // 
            this.lblOutput.AutoSize = true;
            this.lblOutput.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblOutput.Location = new System.Drawing.Point(42, 351);
            this.lblOutput.Name = "lblOutput";
            this.lblOutput.Size = new System.Drawing.Size(0, 33);
            this.lblOutput.TabIndex = 18;
            // 
            // btnNuevo
            // 
            this.btnNuevo.Location = new System.Drawing.Point(69, 609);
            this.btnNuevo.Name = "btnNuevo";
            this.btnNuevo.Size = new System.Drawing.Size(75, 23);
            this.btnNuevo.TabIndex = 19;
            this.btnNuevo.Text = "Nuevo";
            this.btnNuevo.UseVisualStyleBackColor = true;
            this.btnNuevo.Click += new System.EventHandler(this.btnNuevo_Click);
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(267, 610);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(75, 23);
            this.btnEliminar.TabIndex = 20;
            this.btnEliminar.Text = "Eliminar";
            this.btnEliminar.UseVisualStyleBackColor = true;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click);
            // 
            // FormIngresoDetalle
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(738, 645);
            this.Controls.Add(this.btnEliminar);
            this.Controls.Add(this.btnNuevo);
            this.Controls.Add(this.lblOutput);
            this.Controls.Add(this.dpHoraDetalle);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.txaObservaciones);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.btnCancelar);
            this.Controls.Add(this.btnCerrar);
            this.Controls.Add(this.btnGuardar);
            this.Controls.Add(this.dpFechaDetalle);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.btnSeleccionarCentroYMedico);
            this.Controls.Add(this.txtApellidos);
            this.Controls.Add(this.txtNombreAreaCentro);
            this.Controls.Add(this.txtNombreCentro);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnEditar);
            this.Controls.Add(this.tabla);
            this.Name = "FormIngresoDetalle";
            this.Text = "FormIngresoDetalle";
            ((System.ComponentModel.ISupportInitialize)(this.tabla)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView tabla;
        private System.Windows.Forms.Button btnEditar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtNombreCentro;
        private System.Windows.Forms.TextBox txtNombreAreaCentro;
        private System.Windows.Forms.TextBox txtApellidos;
        private System.Windows.Forms.Button btnSeleccionarCentroYMedico;
        private System.Windows.Forms.DataGridViewTextBoxColumn apellidosMedico;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreCentro;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreAreaCentro;
        private System.Windows.Forms.DataGridViewTextBoxColumn diaDetalle;
        private System.Windows.Forms.DataGridViewTextBoxColumn horaDetalle;
        private System.Windows.Forms.DataGridViewTextBoxColumn idIngreso;
        private System.Windows.Forms.DataGridViewTextBoxColumn idAsignacionPersonalCentroArea;
        private System.Windows.Forms.DataGridViewTextBoxColumn idAreaCentroEspacio;
        private System.Windows.Forms.DataGridViewTextBoxColumn idTurno;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.DateTimePicker dpFechaDetalle;
        private System.Windows.Forms.Button btnGuardar;
        private System.Windows.Forms.Button btnCerrar;
        private System.Windows.Forms.Button btnCancelar;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txaObservaciones;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.DateTimePicker dpHoraDetalle;
        private System.Windows.Forms.Label lblOutput;
        private System.Windows.Forms.Button btnNuevo;
        private System.Windows.Forms.Button btnEliminar;
    }
}