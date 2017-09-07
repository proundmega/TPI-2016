using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ParcialTPI.vistas.Mapeo
{
    public class DAOIngresoDetalleExamen : SuperToString
    {
        public IngresoDetalleExamen ingresoDetalleExamen { get; set; }
        public String opcion { get; set; }
        
        public const String OPCION_INSERTAR = "insertar";
        public const String OPCION_MODIFICAR = "modificar";
        public const String OPCION_ELIMINAR = "eliminar";
    }
}
