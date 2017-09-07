using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TareaTPI.Vistas
{
    class DateFormattersController
    {
        private DateTimePicker fechaIngreso;
        private DateTimePicker horaIngreso;
        private DateTimePicker fechaEgreso;
        private DateTimePicker horaEgreso;

        public DateFormattersController(DateTimePicker fechaIngreso,
            DateTimePicker horaIngreso, DateTimePicker fechaEgreso, DateTimePicker horaEgreso)
        {
            this.fechaEgreso = fechaEgreso;
            this.fechaIngreso = fechaIngreso;
            this.horaEgreso = horaEgreso;
            this.horaIngreso = horaIngreso;
        }

        public String getStringFecha(DateTime? fecha)
        {
            if (fecha == null)
            {
                return "";
            }
            else
            {
                return fecha.GetValueOrDefault().ToShortDateString();
            }
        }

        public String getStringHora(DateTime? hora)
        {
            if (hora == null)
            {
                return "";
            }
            else
            {
                return hora.GetValueOrDefault().ToShortTimeString();
            }
        }

        public void prepararTiempoDatePicker(DateTimePicker picker, DateTime fecha)
        {
            picker.Format = DateTimePickerFormat.Time;
            picker.Text = fecha.ToShortTimeString();
        }

        public void prepararFechaDatePicker(DateTimePicker picker, DateTime fecha)
        {
            picker.Format = DateTimePickerFormat.Short;
            picker.Text = fecha.ToShortDateString();
        }

        public void prepararTiempoDatePicker(DateTimePicker picker, DateTime? fecha)
        {
            prepararDatePickerConFormato(picker, fecha, DateTimePickerFormat.Time);
        }

        public void prepararFechaDatePicker(DateTimePicker picker, DateTime? fecha)
        {
            prepararDatePickerConFormato(picker, fecha, DateTimePickerFormat.Short);
        }

        private void prepararDatePickerConFormato(DateTimePicker picker, DateTime? fecha, DateTimePickerFormat formatoSiValido)
        {
            if (fecha == null)
            {
                picker.Format = DateTimePickerFormat.Custom;
                picker.CustomFormat = " ";

            }
            else
            {
                picker.Format = formatoSiValido;
                picker.Text = fecha.GetValueOrDefault().ToShortTimeString();
            }
        }

        public void unlockComponentesEgreso()
        {
            if (estaEnBlancoLosEgresos())
            {
                mostrarEnEgresoLosDatosDeEsteMomento();
            }

        }

        private bool estaEnBlancoLosEgresos()
        {
            return esFechaEgresoNulo() || esHoraEgresoNulo();
        }

        private bool esHoraEgresoNulo()
        {
            return horaEgreso.Format.Equals(DateTimePickerFormat.Custom);
        }

        private bool esFechaEgresoNulo()
        {
            return fechaEgreso.Format.Equals(DateTimePickerFormat.Custom);
        }

        private void mostrarEnEgresoLosDatosDeEsteMomento()
        {
            fechaEgreso.Format = DateTimePickerFormat.Short;
            fechaEgreso.Text = DateTime.Now.ToShortDateString();

            horaEgreso.Format = DateTimePickerFormat.Time;
            horaEgreso.Text = DateTime.Now.ToShortTimeString();
        }

        public DateTime? getFechaEgreso()
        {
            if (fechaEgreso.Format.Equals(DateTimePickerFormat.Custom))
            {
                return null;
            }
            return fechaEgreso.Value;
        }

        public DateTime? getHoraEgreso()
        {
            if (horaEgreso.Format.Equals(DateTimePickerFormat.Custom))
            {
                return null;
            }
            return horaEgreso.Value;
        }

        public void ponerEnNuloAmbosEgresos()
        {
            prepararFechaDatePicker(fechaEgreso, null);
            prepararFechaDatePicker(horaEgreso, null);
        }
    }
}
