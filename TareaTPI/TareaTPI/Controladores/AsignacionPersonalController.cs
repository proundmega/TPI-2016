using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TareaTPI.Excepciones;
using TareaTPI.Mapeo;

namespace TareaTPI.Vistas
{
    class AsignacionPersonalController : AbstractPaginadoController<AsignacionPersonalCentroAreaEspacio> 
    {
        private AsignacionPersonalCentroAreaEspacio asignacionPersonalActual;
        private Boolean haySeleccion;

        public AsignacionPersonalController()
        : base(new AsignacionPersonalClienteRest()) {
            haySeleccion = false;
        }

        public void setAsignacionSeleccionada(AsignacionPersonalCentroAreaEspacio apcae)
        {
            this.asignacionPersonalActual = apcae;
        }

        public Boolean seSeleccionoAsignacion()
        {
            return haySeleccion;
        }

        public void registrarSeleccion(AsignacionPersonalCentroAreaEspacioPK pk)
        {
            foreach (var valor in listaValoresActuales)
            {
                if (valor.asignacionPersonalCentroAreaEspacioPK.Equals(pk))
                {
                    haySeleccion = true;
                    this.asignacionPersonalActual = valor;
                }
            }

            if(haySeleccion == false) {
                throw new ApplicationException("Se ha buscado registrar un id que no existe");
            }

        }

        public AsignacionPersonalCentroAreaEspacio getAsignacionSelecionada()
        {
            return asignacionPersonalActual;
        }
    }
}
