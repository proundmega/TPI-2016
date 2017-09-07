using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TareaTPI.Mapeo;

namespace TareaTPI.Mapeo
{
    public class SuperToString
    {
        public override string ToString()
        {
            PropertyDescriptorCollection coll = TypeDescriptor.GetProperties(this);
            StringBuilder builder = new StringBuilder();
            foreach (PropertyDescriptor pd in coll)
            {
                if (pd.GetValue(this) != null)
                {
                    builder.Append(string.Format("{0} : {1} \n", pd.Name, pd.GetValue(this).ToString()));
                }
                else
                {
                    builder.Append(string.Format("{0} : null \n", pd.Name));
                }
            }
            return builder.ToString();
        }
    }

    public class TipoCentro : SuperToString
    {
        public int idTipoCentro { get; set; }
        public String nombre { get; set; }
        public Boolean activo { get; set; }
        public String observaciones { get; set; }

    }

    public class Ingreso : SuperToString {

        public int? idIngreso { get; set; }
        public DateTime fechaIngreso { get; set; }
        public DateTime horaIngreso { get; set; }
        public DateTime? fechaEgreso { get; set; }
        public DateTime? horaEgreso { get; set; }
        public String observaciones { get; set; }
        public TipoIngreso idTipoIngreso { get; set; }
        public Paciente idPaciente { get; set; }

    }

    public class Paciente : SuperToString {
        public int idPaciente { get; set; }
        public String nombres { get; set; }
        public String apellidos { get; set; }
        public DateTime fechaNacimiento { get; set; }
        public DateTime fechaDefuncion { get; set; }

    }

    public class TipoIngreso : SuperToString
    {
        public int idTipoIngreso { get; set; }
        public Boolean activo { get; set; }
        public String nombre { get; set; }

    }

    public class IngresoDetalle : SuperToString
    {
        public IngresoDetallePK ingresoDetallePK { get; set; }
        public DateTime fechaDetalle { get; set; }
        public DateTime horaDetalle { get; set; }
        public String observaciones { get; set; }
        public Ingreso ingreso { get; set; }
        public AsignacionPersonalCentroAreaEspacio asignacionPersonalCentroAreaEspacio {get; set;}

    }

    public class IngresoDetallePK : SuperToString
    {
        public int idIngreso { get; set; }
        public int idAsignacionPersonalCentroArea { get; set; }

        public int idAreaCentroEspacio { get; set; }
        public int idTurno { get; set; }

        public override bool Equals(object obj)
        {
            IngresoDetallePK obj2 = (IngresoDetallePK)obj;
            return obj2.idAreaCentroEspacio == this.idAreaCentroEspacio
                && obj2.idAsignacionPersonalCentroArea == this.idAsignacionPersonalCentroArea
                && obj2.idIngreso == this.idIngreso
                && obj2.idTurno == this.idTurno;

        }
    }

    public class AsignacionPersonalCentroAreaEspacio : SuperToString
    {
        public AsignacionPersonalCentroAreaEspacioPK asignacionPersonalCentroAreaEspacioPK { get; set; }
        public DateTime fechaDesde { get; set; }
        public AsignacionPersonalCentroArea asignacionPersonalCentroArea { get; set; }
        public String observaciones { get; set; }
    }

    public class AsignacionPersonalCentroAreaEspacioPK : SuperToString
    {
        public int idAsignacionPersonalCentroArea { get; set; }
        public int idAreaCentroEspacio { get; set; }
        public int idTurno { get; set; }

        public override bool Equals(object obj)
        {
            var otraPK = (AsignacionPersonalCentroAreaEspacioPK)obj;
            return otraPK.idAreaCentroEspacio == this.idAreaCentroEspacio
                && otraPK.idAsignacionPersonalCentroArea == this.idAsignacionPersonalCentroArea
                && otraPK.idTurno == this.idTurno;
        }
    }

    public class AsignacionPersonalCentroArea : SuperToString
    {
        public int idAsignacionPersonalCentroArea { get; set; }
        public DateTime fechaDesde { get; set; }
        public DateTime fechaHasta { get; set; }
        public AreaCentro idAreaCentro { get; set; }
        public Personal idPersonal { get; set; }

    }

    public class AreaCentro : SuperToString
    {
        public String nombre { get; set; }
        public Centro idCentro { get; set; }
    }

    public class Personal : SuperToString
    {
        public int idPersonal { get; set; }
        public String dui { get; set; }
        private DateTime fechaIngreso { get; set; }

        public String apellidos { get; set; }
        public String nombres { get; set; }
    }

    public class Centro : SuperToString {
        public String nombreCorto { get; set; }
    }
}
