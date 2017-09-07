namespace ParcialTPI.vistas
{
    partial class Form1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.tabla = new System.Windows.Forms.DataGridView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombrePaciente = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreMedico = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.centro = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.examen = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fechaDetalle = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.lblPaciente = new System.Windows.Forms.Label();
            this.txtPaciente = new System.Windows.Forms.TextBox();
            this.lblMedico = new System.Windows.Forms.Label();
            this.txtMedico = new System.Windows.Forms.TextBox();
            this.lblNombreCentro = new System.Windows.Forms.Label();
            this.txtNombreCentro = new System.Windows.Forms.TextBox();
            this.lblFechaDetalle = new System.Windows.Forms.Label();
            this.txtFechaDetalle = new System.Windows.Forms.TextBox();
            this.btnSeleccionarIngresoDetalle = new System.Windows.Forms.Button();
            this.lblIdDetalle = new System.Windows.Forms.Label();
            this.txtIdIngresoDetalleExamen = new System.Windows.Forms.TextBox();
            this.lblFechaOrden = new System.Windows.Forms.Label();
            this.dpFechaOrden = new System.Windows.Forms.DateTimePicker();
            this.lblFechaRealizacion = new System.Windows.Forms.Label();
            this.dpFechaRealizacion = new System.Windows.Forms.DateTimePicker();
            this.lblHoraRealizacion = new System.Windows.Forms.Label();
            this.dpHoraRealizacion = new System.Windows.Forms.DateTimePicker();
            this.lblExamen = new System.Windows.Forms.Label();
            this.txtNombreExamen = new System.Windows.Forms.TextBox();
            this.btnSeleccionarExamen = new System.Windows.Forms.Button();
            this.btnModificar = new System.Windows.Forms.Button();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.btnGuardar = new System.Windows.Forms.Button();
            this.btnInsertar = new System.Windows.Forms.Button();
            this.output = new System.Windows.Forms.Label();
            this.btnEliminar = new System.Windows.Forms.Button();
            this.pnlDerecho = new System.Windows.Forms.Panel();
            this.pnlIzquierdo = new System.Windows.Forms.Panel();
            this.btnAtras = new System.Windows.Forms.Button();
            this.btnAdelante = new System.Windows.Forms.Button();
            this.pnlFiltros = new System.Windows.Forms.Panel();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.txtFiltroNombreExamen = new System.Windows.Forms.TextBox();
            this.lblFiltroExamen = new System.Windows.Forms.Label();
            this.txtFiltroApellido = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.tabla)).BeginInit();
            this.pnlDerecho.SuspendLayout();
            this.pnlIzquierdo.SuspendLayout();
            this.pnlFiltros.SuspendLayout();
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
            this.id,
            this.nombrePaciente,
            this.nombreMedico,
            this.centro,
            this.examen,
            this.fechaDetalle});
            this.tabla.Location = new System.Drawing.Point(60, 34);
            this.tabla.MultiSelect = false;
            this.tabla.Name = "tabla";
            this.tabla.ReadOnly = true;
            this.tabla.RowHeadersWidthSizeMode = System.Windows.Forms.DataGridViewRowHeadersWidthSizeMode.AutoSizeToAllHeaders;
            this.tabla.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.tabla.Size = new System.Drawing.Size(711, 215);
            this.tabla.TabIndex = 0;
            this.tabla.SelectionChanged += new System.EventHandler(this.tabla_SelectionChanged);
            // 
            // id
            // 
            this.id.HeaderText = "Id detalle examen";
            this.id.Name = "id";
            this.id.ReadOnly = true;
            // 
            // nombrePaciente
            // 
            this.nombrePaciente.HeaderText = "Paciente";
            this.nombrePaciente.Name = "nombrePaciente";
            this.nombrePaciente.ReadOnly = true;
            // 
            // nombreMedico
            // 
            this.nombreMedico.HeaderText = "Nombre medico";
            this.nombreMedico.Name = "nombreMedico";
            this.nombreMedico.ReadOnly = true;
            // 
            // centro
            // 
            this.centro.HeaderText = "Centro de atencion";
            this.centro.Name = "centro";
            this.centro.ReadOnly = true;
            // 
            // examen
            // 
            this.examen.HeaderText = "Examen";
            this.examen.Name = "examen";
            this.examen.ReadOnly = true;
            // 
            // fechaDetalle
            // 
            this.fechaDetalle.HeaderText = "Fecha examen";
            this.fechaDetalle.Name = "fechaDetalle";
            this.fechaDetalle.ReadOnly = true;
            // 
            // lblPaciente
            // 
            this.lblPaciente.AutoSize = true;
            this.lblPaciente.Location = new System.Drawing.Point(48, 20);
            this.lblPaciente.Name = "lblPaciente";
            this.lblPaciente.Size = new System.Drawing.Size(52, 13);
            this.lblPaciente.TabIndex = 1;
            this.lblPaciente.Text = "Paciente:";
            // 
            // txtPaciente
            // 
            this.txtPaciente.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtPaciente.Enabled = false;
            this.txtPaciente.Location = new System.Drawing.Point(113, 13);
            this.txtPaciente.Name = "txtPaciente";
            this.txtPaciente.Size = new System.Drawing.Size(222, 20);
            this.txtPaciente.TabIndex = 2;
            // 
            // lblMedico
            // 
            this.lblMedico.AutoSize = true;
            this.lblMedico.Location = new System.Drawing.Point(55, 53);
            this.lblMedico.Name = "lblMedico";
            this.lblMedico.Size = new System.Drawing.Size(45, 13);
            this.lblMedico.TabIndex = 3;
            this.lblMedico.Text = "Medico:";
            // 
            // txtMedico
            // 
            this.txtMedico.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtMedico.Enabled = false;
            this.txtMedico.Location = new System.Drawing.Point(113, 53);
            this.txtMedico.Name = "txtMedico";
            this.txtMedico.Size = new System.Drawing.Size(222, 20);
            this.txtMedico.TabIndex = 4;
            // 
            // lblNombreCentro
            // 
            this.lblNombreCentro.AutoSize = true;
            this.lblNombreCentro.Location = new System.Drawing.Point(20, 94);
            this.lblNombreCentro.Name = "lblNombreCentro";
            this.lblNombreCentro.Size = new System.Drawing.Size(80, 13);
            this.lblNombreCentro.TabIndex = 5;
            this.lblNombreCentro.Text = "Nombre centro:";
            // 
            // txtNombreCentro
            // 
            this.txtNombreCentro.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtNombreCentro.Enabled = false;
            this.txtNombreCentro.Location = new System.Drawing.Point(113, 94);
            this.txtNombreCentro.Name = "txtNombreCentro";
            this.txtNombreCentro.Size = new System.Drawing.Size(222, 20);
            this.txtNombreCentro.TabIndex = 6;
            // 
            // lblFechaDetalle
            // 
            this.lblFechaDetalle.AutoSize = true;
            this.lblFechaDetalle.Location = new System.Drawing.Point(26, 133);
            this.lblFechaDetalle.Name = "lblFechaDetalle";
            this.lblFechaDetalle.Size = new System.Drawing.Size(74, 13);
            this.lblFechaDetalle.TabIndex = 7;
            this.lblFechaDetalle.Text = "Fecha detalle:";
            // 
            // txtFechaDetalle
            // 
            this.txtFechaDetalle.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtFechaDetalle.Enabled = false;
            this.txtFechaDetalle.Location = new System.Drawing.Point(113, 133);
            this.txtFechaDetalle.Name = "txtFechaDetalle";
            this.txtFechaDetalle.Size = new System.Drawing.Size(222, 20);
            this.txtFechaDetalle.TabIndex = 8;
            // 
            // btnSeleccionarIngresoDetalle
            // 
            this.btnSeleccionarIngresoDetalle.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnSeleccionarIngresoDetalle.BackColor = System.Drawing.SystemColors.Control;
            this.btnSeleccionarIngresoDetalle.Location = new System.Drawing.Point(98, 178);
            this.btnSeleccionarIngresoDetalle.Name = "btnSeleccionarIngresoDetalle";
            this.btnSeleccionarIngresoDetalle.Size = new System.Drawing.Size(166, 23);
            this.btnSeleccionarIngresoDetalle.TabIndex = 9;
            this.btnSeleccionarIngresoDetalle.Text = "Seleccionar ingreso detalle";
            this.btnSeleccionarIngresoDetalle.UseVisualStyleBackColor = false;
            this.btnSeleccionarIngresoDetalle.Click += new System.EventHandler(this.btnSeleccionarIngresoDetalle_Click);
            // 
            // lblIdDetalle
            // 
            this.lblIdDetalle.AutoSize = true;
            this.lblIdDetalle.Location = new System.Drawing.Point(37, 16);
            this.lblIdDetalle.Name = "lblIdDetalle";
            this.lblIdDetalle.Size = new System.Drawing.Size(93, 13);
            this.lblIdDetalle.TabIndex = 10;
            this.lblIdDetalle.Text = "Id detalle examen:";
            // 
            // txtIdIngresoDetalleExamen
            // 
            this.txtIdIngresoDetalleExamen.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtIdIngresoDetalleExamen.Enabled = false;
            this.txtIdIngresoDetalleExamen.Location = new System.Drawing.Point(146, 10);
            this.txtIdIngresoDetalleExamen.MinimumSize = new System.Drawing.Size(60, 20);
            this.txtIdIngresoDetalleExamen.Name = "txtIdIngresoDetalleExamen";
            this.txtIdIngresoDetalleExamen.Size = new System.Drawing.Size(99, 20);
            this.txtIdIngresoDetalleExamen.TabIndex = 11;
            // 
            // lblFechaOrden
            // 
            this.lblFechaOrden.AutoSize = true;
            this.lblFechaOrden.Location = new System.Drawing.Point(60, 53);
            this.lblFechaOrden.Name = "lblFechaOrden";
            this.lblFechaOrden.Size = new System.Drawing.Size(70, 13);
            this.lblFechaOrden.TabIndex = 12;
            this.lblFechaOrden.Text = "Fecha orden:";
            // 
            // dpFechaOrden
            // 
            this.dpFechaOrden.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dpFechaOrden.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.dpFechaOrden.Location = new System.Drawing.Point(146, 50);
            this.dpFechaOrden.Name = "dpFechaOrden";
            this.dpFechaOrden.Size = new System.Drawing.Size(232, 20);
            this.dpFechaOrden.TabIndex = 13;
            // 
            // lblFechaRealizacion
            // 
            this.lblFechaRealizacion.AutoSize = true;
            this.lblFechaRealizacion.Location = new System.Drawing.Point(22, 94);
            this.lblFechaRealizacion.Name = "lblFechaRealizacion";
            this.lblFechaRealizacion.Size = new System.Drawing.Size(108, 13);
            this.lblFechaRealizacion.TabIndex = 14;
            this.lblFechaRealizacion.Text = "Fecha de realizacion:";
            // 
            // dpFechaRealizacion
            // 
            this.dpFechaRealizacion.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dpFechaRealizacion.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.dpFechaRealizacion.Location = new System.Drawing.Point(146, 91);
            this.dpFechaRealizacion.Name = "dpFechaRealizacion";
            this.dpFechaRealizacion.Size = new System.Drawing.Size(232, 20);
            this.dpFechaRealizacion.TabIndex = 15;
            // 
            // lblHoraRealizacion
            // 
            this.lblHoraRealizacion.AutoSize = true;
            this.lblHoraRealizacion.Location = new System.Drawing.Point(29, 136);
            this.lblHoraRealizacion.Name = "lblHoraRealizacion";
            this.lblHoraRealizacion.Size = new System.Drawing.Size(101, 13);
            this.lblHoraRealizacion.TabIndex = 16;
            this.lblHoraRealizacion.Text = "Hora de realizacion:";
            // 
            // dpHoraRealizacion
            // 
            this.dpHoraRealizacion.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dpHoraRealizacion.Format = System.Windows.Forms.DateTimePickerFormat.Time;
            this.dpHoraRealizacion.Location = new System.Drawing.Point(146, 130);
            this.dpHoraRealizacion.Name = "dpHoraRealizacion";
            this.dpHoraRealizacion.Size = new System.Drawing.Size(232, 20);
            this.dpHoraRealizacion.TabIndex = 17;
            // 
            // lblExamen
            // 
            this.lblExamen.AutoSize = true;
            this.lblExamen.Location = new System.Drawing.Point(82, 176);
            this.lblExamen.Name = "lblExamen";
            this.lblExamen.Size = new System.Drawing.Size(48, 13);
            this.lblExamen.TabIndex = 18;
            this.lblExamen.Text = "Examen:";
            // 
            // txtNombreExamen
            // 
            this.txtNombreExamen.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtNombreExamen.Enabled = false;
            this.txtNombreExamen.Location = new System.Drawing.Point(146, 173);
            this.txtNombreExamen.Name = "txtNombreExamen";
            this.txtNombreExamen.Size = new System.Drawing.Size(232, 20);
            this.txtNombreExamen.TabIndex = 19;
            // 
            // btnSeleccionarExamen
            // 
            this.btnSeleccionarExamen.Location = new System.Drawing.Point(176, 209);
            this.btnSeleccionarExamen.Name = "btnSeleccionarExamen";
            this.btnSeleccionarExamen.Size = new System.Drawing.Size(75, 23);
            this.btnSeleccionarExamen.TabIndex = 20;
            this.btnSeleccionarExamen.Text = "Seleccionar examen";
            this.btnSeleccionarExamen.UseVisualStyleBackColor = true;
            this.btnSeleccionarExamen.Click += new System.EventHandler(this.btnSeleccionarExamen_Click);
            // 
            // btnModificar
            // 
            this.btnModificar.Location = new System.Drawing.Point(106, 261);
            this.btnModificar.Name = "btnModificar";
            this.btnModificar.Size = new System.Drawing.Size(75, 23);
            this.btnModificar.TabIndex = 21;
            this.btnModificar.Text = "Modificar";
            this.btnModificar.UseVisualStyleBackColor = true;
            this.btnModificar.Click += new System.EventHandler(this.btnModificar_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnCancelar.Location = new System.Drawing.Point(260, 261);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(75, 23);
            this.btnCancelar.TabIndex = 22;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.UseVisualStyleBackColor = true;
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // btnGuardar
            // 
            this.btnGuardar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnGuardar.Location = new System.Drawing.Point(163, 261);
            this.btnGuardar.Name = "btnGuardar";
            this.btnGuardar.Size = new System.Drawing.Size(75, 23);
            this.btnGuardar.TabIndex = 23;
            this.btnGuardar.Text = "Guardar";
            this.btnGuardar.UseVisualStyleBackColor = true;
            this.btnGuardar.Click += new System.EventHandler(this.btnGuardar_Click);
            // 
            // btnInsertar
            // 
            this.btnInsertar.Location = new System.Drawing.Point(25, 261);
            this.btnInsertar.Name = "btnInsertar";
            this.btnInsertar.Size = new System.Drawing.Size(75, 23);
            this.btnInsertar.TabIndex = 24;
            this.btnInsertar.Text = "Insertar";
            this.btnInsertar.UseVisualStyleBackColor = true;
            this.btnInsertar.Click += new System.EventHandler(this.button1_Click);
            // 
            // output
            // 
            this.output.AutoSize = true;
            this.output.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.output.Location = new System.Drawing.Point(79, 284);
            this.output.Name = "output";
            this.output.Size = new System.Drawing.Size(0, 29);
            this.output.TabIndex = 25;
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(187, 261);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(75, 23);
            this.btnEliminar.TabIndex = 26;
            this.btnEliminar.Text = "Eliminar";
            this.btnEliminar.UseVisualStyleBackColor = true;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click);
            // 
            // pnlDerecho
            // 
            this.pnlDerecho.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.pnlDerecho.BackColor = System.Drawing.Color.Lavender;
            this.pnlDerecho.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pnlDerecho.Controls.Add(this.txtPaciente);
            this.pnlDerecho.Controls.Add(this.lblPaciente);
            this.pnlDerecho.Controls.Add(this.lblMedico);
            this.pnlDerecho.Controls.Add(this.btnGuardar);
            this.pnlDerecho.Controls.Add(this.txtMedico);
            this.pnlDerecho.Controls.Add(this.btnCancelar);
            this.pnlDerecho.Controls.Add(this.lblNombreCentro);
            this.pnlDerecho.Controls.Add(this.txtNombreCentro);
            this.pnlDerecho.Controls.Add(this.lblFechaDetalle);
            this.pnlDerecho.Controls.Add(this.txtFechaDetalle);
            this.pnlDerecho.Controls.Add(this.btnSeleccionarIngresoDetalle);
            this.pnlDerecho.Location = new System.Drawing.Point(434, 373);
            this.pnlDerecho.MinimumSize = new System.Drawing.Size(250, 300);
            this.pnlDerecho.Name = "pnlDerecho";
            this.pnlDerecho.Size = new System.Drawing.Size(363, 300);
            this.pnlDerecho.TabIndex = 27;
            // 
            // pnlIzquierdo
            // 
            this.pnlIzquierdo.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.pnlIzquierdo.BackColor = System.Drawing.Color.Lavender;
            this.pnlIzquierdo.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pnlIzquierdo.Controls.Add(this.dpFechaOrden);
            this.pnlIzquierdo.Controls.Add(this.lblIdDetalle);
            this.pnlIzquierdo.Controls.Add(this.btnEliminar);
            this.pnlIzquierdo.Controls.Add(this.txtIdIngresoDetalleExamen);
            this.pnlIzquierdo.Controls.Add(this.btnInsertar);
            this.pnlIzquierdo.Controls.Add(this.lblFechaOrden);
            this.pnlIzquierdo.Controls.Add(this.lblFechaRealizacion);
            this.pnlIzquierdo.Controls.Add(this.dpFechaRealizacion);
            this.pnlIzquierdo.Controls.Add(this.btnModificar);
            this.pnlIzquierdo.Controls.Add(this.lblHoraRealizacion);
            this.pnlIzquierdo.Controls.Add(this.dpHoraRealizacion);
            this.pnlIzquierdo.Controls.Add(this.btnSeleccionarExamen);
            this.pnlIzquierdo.Controls.Add(this.lblExamen);
            this.pnlIzquierdo.Controls.Add(this.txtNombreExamen);
            this.pnlIzquierdo.Location = new System.Drawing.Point(35, 373);
            this.pnlIzquierdo.MinimumSize = new System.Drawing.Size(250, 300);
            this.pnlIzquierdo.Name = "pnlIzquierdo";
            this.pnlIzquierdo.Size = new System.Drawing.Size(393, 300);
            this.pnlIzquierdo.TabIndex = 28;
            // 
            // btnAtras
            // 
            this.btnAtras.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.btnAtras.Enabled = false;
            this.btnAtras.Location = new System.Drawing.Point(329, 255);
            this.btnAtras.Name = "btnAtras";
            this.btnAtras.Size = new System.Drawing.Size(75, 23);
            this.btnAtras.TabIndex = 29;
            this.btnAtras.Text = "<";
            this.btnAtras.UseVisualStyleBackColor = true;
            this.btnAtras.Click += new System.EventHandler(this.btnAtras_Click);
            // 
            // btnAdelante
            // 
            this.btnAdelante.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.btnAdelante.Enabled = false;
            this.btnAdelante.Location = new System.Drawing.Point(464, 255);
            this.btnAdelante.Name = "btnAdelante";
            this.btnAdelante.Size = new System.Drawing.Size(75, 23);
            this.btnAdelante.TabIndex = 30;
            this.btnAdelante.Text = ">";
            this.btnAdelante.UseVisualStyleBackColor = true;
            this.btnAdelante.Click += new System.EventHandler(this.btnAdelanet_Click);
            // 
            // pnlFiltros
            // 
            this.pnlFiltros.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.pnlFiltros.BackColor = System.Drawing.Color.LightGray;
            this.pnlFiltros.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pnlFiltros.Controls.Add(this.pictureBox1);
            this.pnlFiltros.Controls.Add(this.txtFiltroNombreExamen);
            this.pnlFiltros.Controls.Add(this.lblFiltroExamen);
            this.pnlFiltros.Controls.Add(this.txtFiltroApellido);
            this.pnlFiltros.Controls.Add(this.label2);
            this.pnlFiltros.Location = new System.Drawing.Point(61, 331);
            this.pnlFiltros.Name = "pnlFiltros";
            this.pnlFiltros.Size = new System.Drawing.Size(710, 36);
            this.pnlFiltros.TabIndex = 32;
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(14, -1);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(60, 36);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 33;
            this.pictureBox1.TabStop = false;
            // 
            // txtFiltroNombreExamen
            // 
            this.txtFiltroNombreExamen.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtFiltroNombreExamen.Location = new System.Drawing.Point(446, 6);
            this.txtFiltroNombreExamen.Name = "txtFiltroNombreExamen";
            this.txtFiltroNombreExamen.Size = new System.Drawing.Size(240, 20);
            this.txtFiltroNombreExamen.TabIndex = 35;
            this.txtFiltroNombreExamen.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtFiltroNombreExamen_KeyUp);
            // 
            // lblFiltroExamen
            // 
            this.lblFiltroExamen.AutoSize = true;
            this.lblFiltroExamen.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblFiltroExamen.Location = new System.Drawing.Point(369, 6);
            this.lblFiltroExamen.Name = "lblFiltroExamen";
            this.lblFiltroExamen.Size = new System.Drawing.Size(71, 20);
            this.lblFiltroExamen.TabIndex = 34;
            this.lblFiltroExamen.Text = "Examen:";
            // 
            // txtFiltroApellido
            // 
            this.txtFiltroApellido.Location = new System.Drawing.Point(151, 6);
            this.txtFiltroApellido.Name = "txtFiltroApellido";
            this.txtFiltroApellido.Size = new System.Drawing.Size(240, 20);
            this.txtFiltroApellido.TabIndex = 33;
            this.txtFiltroApellido.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtFiltroApellido_KeyUp);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(77, 5);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(69, 20);
            this.label2.TabIndex = 32;
            this.label2.Text = "Apellido:";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.GhostWhite;
            this.ClientSize = new System.Drawing.Size(828, 683);
            this.Controls.Add(this.pnlFiltros);
            this.Controls.Add(this.btnAdelante);
            this.Controls.Add(this.btnAtras);
            this.Controls.Add(this.pnlIzquierdo);
            this.Controls.Add(this.pnlDerecho);
            this.Controls.Add(this.output);
            this.Controls.Add(this.tabla);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MinimumSize = new System.Drawing.Size(650, 721);
            this.Name = "Form1";
            this.RightToLeftLayout = true;
            this.Text = "Clinica San Juan";
            this.Resize += new System.EventHandler(this.Form1_Resize);
            ((System.ComponentModel.ISupportInitialize)(this.tabla)).EndInit();
            this.pnlDerecho.ResumeLayout(false);
            this.pnlDerecho.PerformLayout();
            this.pnlIzquierdo.ResumeLayout(false);
            this.pnlIzquierdo.PerformLayout();
            this.pnlFiltros.ResumeLayout(false);
            this.pnlFiltros.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView tabla;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombrePaciente;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreMedico;
        private System.Windows.Forms.DataGridViewTextBoxColumn centro;
        private System.Windows.Forms.DataGridViewTextBoxColumn examen;
        private System.Windows.Forms.DataGridViewTextBoxColumn fechaDetalle;
        private System.Windows.Forms.Label lblPaciente;
        private System.Windows.Forms.TextBox txtPaciente;
        private System.Windows.Forms.Label lblMedico;
        private System.Windows.Forms.TextBox txtMedico;
        private System.Windows.Forms.Label lblNombreCentro;
        private System.Windows.Forms.TextBox txtNombreCentro;
        private System.Windows.Forms.Label lblFechaDetalle;
        private System.Windows.Forms.TextBox txtFechaDetalle;
        private System.Windows.Forms.Button btnSeleccionarIngresoDetalle;
        private System.Windows.Forms.Label lblIdDetalle;
        private System.Windows.Forms.TextBox txtIdIngresoDetalleExamen;
        private System.Windows.Forms.Label lblFechaOrden;
        private System.Windows.Forms.DateTimePicker dpFechaOrden;
        private System.Windows.Forms.Label lblFechaRealizacion;
        private System.Windows.Forms.DateTimePicker dpFechaRealizacion;
        private System.Windows.Forms.Label lblHoraRealizacion;
        private System.Windows.Forms.DateTimePicker dpHoraRealizacion;
        private System.Windows.Forms.Label lblExamen;
        private System.Windows.Forms.TextBox txtNombreExamen;
        private System.Windows.Forms.Button btnSeleccionarExamen;
        private System.Windows.Forms.Button btnModificar;
        private System.Windows.Forms.Button btnCancelar;
        private System.Windows.Forms.Button btnGuardar;
        private System.Windows.Forms.Button btnInsertar;
        private System.Windows.Forms.Label output;
        private System.Windows.Forms.Button btnEliminar;
        private System.Windows.Forms.Panel pnlDerecho;
        private System.Windows.Forms.Panel pnlIzquierdo;
        private System.Windows.Forms.Button btnAtras;
        private System.Windows.Forms.Button btnAdelante;
        private System.Windows.Forms.Panel pnlFiltros;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtFiltroApellido;
        private System.Windows.Forms.Label lblFiltroExamen;
        private System.Windows.Forms.TextBox txtFiltroNombreExamen;
        private System.Windows.Forms.PictureBox pictureBox1;


    }
}

