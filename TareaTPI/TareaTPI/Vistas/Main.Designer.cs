namespace TareaTPI.Vistas
{
    partial class FormMain
    {
        /// <summary>
        /// Variable del diseñador requerida.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén utilizando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben eliminar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido del método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.tabla = new System.Windows.Forms.DataGridView();
            this.idIngreso = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fechaIngreso = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.horaIngreso = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fechaEgreso = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.horaEgreso = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.apellidosPaciente = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnAtras = new System.Windows.Forms.Button();
            this.btnAdelante = new System.Windows.Forms.Button();
            this.txtIdIngreso = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.btnEditarIngreso = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.dpHoraIngreso = new System.Windows.Forms.DateTimePicker();
            this.label5 = new System.Windows.Forms.Label();
            this.dpFechaIngreso = new System.Windows.Forms.DateTimePicker();
            this.dpFechaEgreso = new System.Windows.Forms.DateTimePicker();
            this.label6 = new System.Windows.Forms.Label();
            this.dpHoraEgreso = new System.Windows.Forms.DateTimePicker();
            this.label7 = new System.Windows.Forms.Label();
            this.txaObservaciones = new System.Windows.Forms.TextBox();
            this.txtPaciente = new System.Windows.Forms.TextBox();
            this.btnSeleccionarPaciente = new System.Windows.Forms.Button();
            this.btnGuardar = new System.Windows.Forms.Button();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.cmbTipoIngreso = new System.Windows.Forms.ComboBox();
            this.lblOutput = new System.Windows.Forms.Label();
            this.btnNuevo = new System.Windows.Forms.Button();
            this.btnEliminar = new System.Windows.Forms.Button();
            this.btnIngresoDetalle = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.tabla)).BeginInit();
            this.SuspendLayout();
            // 
            // tabla
            // 
            this.tabla.AllowUserToAddRows = false;
            this.tabla.AllowUserToDeleteRows = false;
            this.tabla.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.tabla.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idIngreso,
            this.fechaIngreso,
            this.horaIngreso,
            this.fechaEgreso,
            this.horaEgreso,
            this.apellidosPaciente});
            this.tabla.Location = new System.Drawing.Point(56, 34);
            this.tabla.MultiSelect = false;
            this.tabla.Name = "tabla";
            this.tabla.ReadOnly = true;
            this.tabla.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.tabla.Size = new System.Drawing.Size(667, 215);
            this.tabla.TabIndex = 0;
            this.tabla.SelectionChanged += new System.EventHandler(this.tabla_SelectionChanged);
            // 
            // idIngreso
            // 
            this.idIngreso.HeaderText = "id ingreso";
            this.idIngreso.Name = "idIngreso";
            this.idIngreso.ReadOnly = true;
            // 
            // fechaIngreso
            // 
            this.fechaIngreso.HeaderText = "Fecha de ingreso";
            this.fechaIngreso.Name = "fechaIngreso";
            this.fechaIngreso.ReadOnly = true;
            // 
            // horaIngreso
            // 
            this.horaIngreso.HeaderText = "Hora de ingreso";
            this.horaIngreso.Name = "horaIngreso";
            this.horaIngreso.ReadOnly = true;
            // 
            // fechaEgreso
            // 
            this.fechaEgreso.HeaderText = "Fecha de egreso";
            this.fechaEgreso.Name = "fechaEgreso";
            this.fechaEgreso.ReadOnly = true;
            // 
            // horaEgreso
            // 
            this.horaEgreso.HeaderText = "Hora de egreso";
            this.horaEgreso.Name = "horaEgreso";
            this.horaEgreso.ReadOnly = true;
            // 
            // apellidosPaciente
            // 
            this.apellidosPaciente.HeaderText = "Apellidos Paciente";
            this.apellidosPaciente.Name = "apellidosPaciente";
            this.apellidosPaciente.ReadOnly = true;
            // 
            // btnAtras
            // 
            this.btnAtras.Location = new System.Drawing.Point(317, 274);
            this.btnAtras.Name = "btnAtras";
            this.btnAtras.Size = new System.Drawing.Size(75, 23);
            this.btnAtras.TabIndex = 1;
            this.btnAtras.Text = "<";
            this.btnAtras.UseVisualStyleBackColor = true;
            this.btnAtras.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // btnAdelante
            // 
            this.btnAdelante.Location = new System.Drawing.Point(422, 274);
            this.btnAdelante.Name = "btnAdelante";
            this.btnAdelante.Size = new System.Drawing.Size(75, 23);
            this.btnAdelante.TabIndex = 2;
            this.btnAdelante.Text = ">";
            this.btnAdelante.UseVisualStyleBackColor = true;
            this.btnAdelante.Click += new System.EventHandler(this.button2_Click);
            // 
            // txtIdIngreso
            // 
            this.txtIdIngreso.Enabled = false;
            this.txtIdIngreso.Location = new System.Drawing.Point(194, 377);
            this.txtIdIngreso.Name = "txtIdIngreso";
            this.txtIdIngreso.ReadOnly = true;
            this.txtIdIngreso.Size = new System.Drawing.Size(198, 20);
            this.txtIdIngreso.TabIndex = 3;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(117, 380);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(56, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "Id ingreso:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(117, 419);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(52, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "Paciente:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(92, 491);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(77, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Fecha ingreso:";
            // 
            // btnEditarIngreso
            // 
            this.btnEditarIngreso.Location = new System.Drawing.Point(194, 619);
            this.btnEditarIngreso.Name = "btnEditarIngreso";
            this.btnEditarIngreso.Size = new System.Drawing.Size(75, 23);
            this.btnEditarIngreso.TabIndex = 9;
            this.btnEditarIngreso.Text = "Editar";
            this.btnEditarIngreso.UseVisualStyleBackColor = true;
            this.btnEditarIngreso.Click += new System.EventHandler(this.btnEditarIngreso_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(88, 535);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(85, 13);
            this.label4.TabIndex = 11;
            this.label4.Text = "Hora de ingreso:";
            // 
            // dpHoraIngreso
            // 
            this.dpHoraIngreso.Format = System.Windows.Forms.DateTimePickerFormat.Time;
            this.dpHoraIngreso.Location = new System.Drawing.Point(194, 535);
            this.dpHoraIngreso.Name = "dpHoraIngreso";
            this.dpHoraIngreso.Size = new System.Drawing.Size(198, 20);
            this.dpHoraIngreso.TabIndex = 12;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(446, 377);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(75, 13);
            this.label5.TabIndex = 13;
            this.label5.Text = "Fecha egreso:";
            // 
            // dpFechaIngreso
            // 
            this.dpFechaIngreso.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.dpFechaIngreso.Location = new System.Drawing.Point(194, 491);
            this.dpFechaIngreso.Name = "dpFechaIngreso";
            this.dpFechaIngreso.Size = new System.Drawing.Size(198, 20);
            this.dpFechaIngreso.TabIndex = 14;
            // 
            // dpFechaEgreso
            // 
            this.dpFechaEgreso.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.dpFechaEgreso.Location = new System.Drawing.Point(527, 374);
            this.dpFechaEgreso.Name = "dpFechaEgreso";
            this.dpFechaEgreso.Size = new System.Drawing.Size(206, 20);
            this.dpFechaEgreso.TabIndex = 15;
            this.dpFechaEgreso.Enter += new System.EventHandler(this.dpFechaEgreso_Enter);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(447, 416);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(74, 13);
            this.label6.TabIndex = 16;
            this.label6.Text = "Hora engreso:";
            // 
            // dpHoraEgreso
            // 
            this.dpHoraEgreso.Format = System.Windows.Forms.DateTimePickerFormat.Time;
            this.dpHoraEgreso.Location = new System.Drawing.Point(527, 410);
            this.dpHoraEgreso.Name = "dpHoraEgreso";
            this.dpHoraEgreso.Size = new System.Drawing.Size(206, 20);
            this.dpHoraEgreso.TabIndex = 17;
            this.dpHoraEgreso.Enter += new System.EventHandler(this.dpHoraEgreso_Enter);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(440, 491);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(81, 13);
            this.label7.TabIndex = 18;
            this.label7.Text = "Observaciones:";
            // 
            // txaObservaciones
            // 
            this.txaObservaciones.Location = new System.Drawing.Point(527, 491);
            this.txaObservaciones.Multiline = true;
            this.txaObservaciones.Name = "txaObservaciones";
            this.txaObservaciones.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.txaObservaciones.Size = new System.Drawing.Size(206, 100);
            this.txaObservaciones.TabIndex = 19;
            // 
            // txtPaciente
            // 
            this.txtPaciente.Enabled = false;
            this.txtPaciente.Location = new System.Drawing.Point(194, 416);
            this.txtPaciente.Name = "txtPaciente";
            this.txtPaciente.Size = new System.Drawing.Size(198, 20);
            this.txtPaciente.TabIndex = 20;
            // 
            // btnSeleccionarPaciente
            // 
            this.btnSeleccionarPaciente.Location = new System.Drawing.Point(216, 450);
            this.btnSeleccionarPaciente.Name = "btnSeleccionarPaciente";
            this.btnSeleccionarPaciente.Size = new System.Drawing.Size(132, 23);
            this.btnSeleccionarPaciente.TabIndex = 21;
            this.btnSeleccionarPaciente.Text = "Seleccionar paciente";
            this.btnSeleccionarPaciente.UseVisualStyleBackColor = true;
            this.btnSeleccionarPaciente.Click += new System.EventHandler(this.button1_Click);
            // 
            // btnGuardar
            // 
            this.btnGuardar.Location = new System.Drawing.Point(561, 619);
            this.btnGuardar.Name = "btnGuardar";
            this.btnGuardar.Size = new System.Drawing.Size(75, 23);
            this.btnGuardar.TabIndex = 22;
            this.btnGuardar.Text = "Guardar";
            this.btnGuardar.UseVisualStyleBackColor = true;
            this.btnGuardar.Click += new System.EventHandler(this.btnGuardar_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.Location = new System.Drawing.Point(658, 619);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(75, 23);
            this.btnCancelar.TabIndex = 23;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.UseVisualStyleBackColor = true;
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(438, 455);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(83, 13);
            this.label8.TabIndex = 24;
            this.label8.Text = "Tipo de ingreso:";
            // 
            // cmbTipoIngreso
            // 
            this.cmbTipoIngreso.FormattingEnabled = true;
            this.cmbTipoIngreso.Location = new System.Drawing.Point(527, 452);
            this.cmbTipoIngreso.Name = "cmbTipoIngreso";
            this.cmbTipoIngreso.Size = new System.Drawing.Size(206, 21);
            this.cmbTipoIngreso.TabIndex = 25;
            // 
            // lblOutput
            // 
            this.lblOutput.AutoSize = true;
            this.lblOutput.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblOutput.Location = new System.Drawing.Point(50, 309);
            this.lblOutput.Name = "lblOutput";
            this.lblOutput.Size = new System.Drawing.Size(0, 31);
            this.lblOutput.TabIndex = 26;
            this.lblOutput.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // btnNuevo
            // 
            this.btnNuevo.Location = new System.Drawing.Point(94, 619);
            this.btnNuevo.Name = "btnNuevo";
            this.btnNuevo.Size = new System.Drawing.Size(75, 23);
            this.btnNuevo.TabIndex = 27;
            this.btnNuevo.Text = "Nuevo";
            this.btnNuevo.UseVisualStyleBackColor = true;
            this.btnNuevo.Click += new System.EventHandler(this.btnNuevo_Click);
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(296, 619);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(75, 23);
            this.btnEliminar.TabIndex = 28;
            this.btnEliminar.Text = "Eliminar";
            this.btnEliminar.UseVisualStyleBackColor = true;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click);
            // 
            // btnIngresoDetalle
            // 
            this.btnIngresoDetalle.Location = new System.Drawing.Point(166, 579);
            this.btnIngresoDetalle.Name = "btnIngresoDetalle";
            this.btnIngresoDetalle.Size = new System.Drawing.Size(144, 23);
            this.btnIngresoDetalle.TabIndex = 29;
            this.btnIngresoDetalle.Text = "Motrar ingreso detalle";
            this.btnIngresoDetalle.UseVisualStyleBackColor = true;
            this.btnIngresoDetalle.Click += new System.EventHandler(this.btnIngresoDetalle_Click);
            // 
            // FormMain
            // 
            this.ClientSize = new System.Drawing.Size(789, 665);
            this.Controls.Add(this.btnIngresoDetalle);
            this.Controls.Add(this.btnEliminar);
            this.Controls.Add(this.btnNuevo);
            this.Controls.Add(this.lblOutput);
            this.Controls.Add(this.cmbTipoIngreso);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.btnCancelar);
            this.Controls.Add(this.btnGuardar);
            this.Controls.Add(this.btnSeleccionarPaciente);
            this.Controls.Add(this.txtPaciente);
            this.Controls.Add(this.txaObservaciones);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.dpHoraEgreso);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.dpFechaEgreso);
            this.Controls.Add(this.dpFechaIngreso);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.dpHoraIngreso);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.btnEditarIngreso);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtIdIngreso);
            this.Controls.Add(this.btnAdelante);
            this.Controls.Add(this.btnAtras);
            this.Controls.Add(this.tabla);
            this.Name = "FormMain";
            this.Text = "Manejo de ingreso";
            ((System.ComponentModel.ISupportInitialize)(this.tabla)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView tabla;
        private System.Windows.Forms.DataGridViewTextBoxColumn idIngreso;
        private System.Windows.Forms.DataGridViewTextBoxColumn fechaIngreso;
        private System.Windows.Forms.DataGridViewTextBoxColumn horaIngreso;
        private System.Windows.Forms.DataGridViewTextBoxColumn fechaEgreso;
        private System.Windows.Forms.DataGridViewTextBoxColumn horaEgreso;
        private System.Windows.Forms.DataGridViewTextBoxColumn apellidosPaciente;
        private System.Windows.Forms.Button btnAtras;
        private System.Windows.Forms.Button btnAdelante;
        private System.Windows.Forms.TextBox txtIdIngreso;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnEditarIngreso;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.DateTimePicker dpHoraIngreso;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.DateTimePicker dpFechaIngreso;
        private System.Windows.Forms.DateTimePicker dpFechaEgreso;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.DateTimePicker dpHoraEgreso;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox txaObservaciones;
        private System.Windows.Forms.TextBox txtPaciente;
        private System.Windows.Forms.Button btnSeleccionarPaciente;
        private System.Windows.Forms.Button btnGuardar;
        private System.Windows.Forms.Button btnCancelar;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.ComboBox cmbTipoIngreso;
        private System.Windows.Forms.Label lblOutput;
        private System.Windows.Forms.Button btnNuevo;
        private System.Windows.Forms.Button btnEliminar;
        private System.Windows.Forms.Button btnIngresoDetalle;

    }
}

