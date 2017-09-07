using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ParcialTPI.vistas.Mapeo;

namespace ParcialTPI.vistas.Controladores
{
    public abstract class TipoMensaje
    {

        private String accion;
        protected const String CAMBIO_EXTERNO = "Se ha realizado un cambio externo de los datos";

        private TipoMensaje(String accion)
        {
            this.accion = accion;
        }

        public override bool Equals(object obj)
        {
            TipoMensaje otro = (TipoMensaje)obj;
            return this.accion.Equals(otro.accion);
        }

        public abstract String actualizarDatos(List<IngresoDetalleExamen> datos,
            DAOIngresoDetalleExamen dao, Boolean enEspera);

        public String getAccion()
        {
            return accion;
        }

        public static TipoMensaje crearInsertar()
        {
            return new Insertar();
        }

        private sealed class Insertar : TipoMensaje
        {
            public Insertar()
                : base(DAOIngresoDetalleExamen.OPCION_INSERTAR)
            {

            }

            public override String actualizarDatos(List<IngresoDetalleExamen> datos,
                DAOIngresoDetalleExamen dao, Boolean enEspera)
            {
                datos.Add(dao.ingresoDetalleExamen);
                if (enEspera)
                {
                    return "Registro agregado de forma exitosa";
                }
                else
                {
                    return CAMBIO_EXTERNO;
                }
            }
        }

        public static TipoMensaje crearModificar()
        {
            return new Modificar();
        }

        private sealed class Modificar : TipoMensaje
        {
            public Modificar()
                : base(DAOIngresoDetalleExamen.OPCION_MODIFICAR)
            {

            }

            public override String actualizarDatos(List<IngresoDetalleExamen> datos,
                DAOIngresoDetalleExamen dao, Boolean enEspera)
            {
                int index = datos.IndexOf(dao.ingresoDetalleExamen);
                if (index != -1)
                {
                    datos[index] = dao.ingresoDetalleExamen;
                    if (enEspera)
                    {
                        return "Modificacion realizada de forma exitosa";
                    }
                    else
                    {
                        return CAMBIO_EXTERNO;
                    }

                }
                else
                {
                    throw new ApplicationException("Me pides substituir un elemento que no existe...");
                }

            }
        }

        public static TipoMensaje crearEliminacion()
        {
            return new Eliminar();
        }

        private sealed class Eliminar : TipoMensaje
        {
            public Eliminar()
                : base(DAOIngresoDetalleExamen.OPCION_ELIMINAR)
            {

            }

            public override String actualizarDatos(List<IngresoDetalleExamen> datos,
                DAOIngresoDetalleExamen dao, Boolean enEspera)
            {
                datos.Remove(dao.ingresoDetalleExamen);
                if (enEspera)
                {
                    return "Eliminacion realizada de forma exitosa";
                }
                else
                {
                    return CAMBIO_EXTERNO;
                }
            }
        }

        public static TipoMensaje GetTipoMensajeFromString(String tipoMensaje)
        {
            switch (tipoMensaje)
            {

                case DAOIngresoDetalleExamen.OPCION_INSERTAR:
                    return crearInsertar();

                case DAOIngresoDetalleExamen.OPCION_MODIFICAR:
                    return crearModificar();

                case DAOIngresoDetalleExamen.OPCION_ELIMINAR:
                    return crearEliminacion();

                default:
                    throw new ApplicationException("Tipo de mensaje no esperado: " + tipoMensaje);
            }
        }
    }
}
