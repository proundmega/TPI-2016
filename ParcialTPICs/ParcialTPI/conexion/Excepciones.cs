using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TareaTPI.Excepciones
{
    class NetworkConnectionException : Exception
    {
        public NetworkConnectionException(String mensaje)
            : base(mensaje)
        {

        }

    }
}
