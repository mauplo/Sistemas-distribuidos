from spyne import Application, ServiceBase, Unicode, rpc
from spyne.protocol.soap import Soap11
from spyne.server.wsgi import WsgiApplication
from wsgiref.simple_server import make_server


HOST = '127.0.0.1'
PORT = 8001
NAMESPACE = 'http://ventas.soap.example'


class Tienda1SoapService(ServiceBase):
    @rpc(Unicode, _returns=Unicode)
    def registrar_venta(ctx, monto):
        print('TIENDA 1: venta registrada por ${0}'.format(monto), flush=True)
        return 'Venta registrada en TIENDA 1'


application = Application(
    [Tienda1SoapService],
    tns=NAMESPACE,
    in_protocol=Soap11(validator='soft'),
    out_protocol=Soap11(),
)


def main():
    print('Servicio SOAP disponible en http://{0}:{1}/'.format(HOST, PORT))
    print('WSDL en http://{0}:{1}/?wsdl'.format(HOST, PORT))
    server = make_server(HOST, PORT, WsgiApplication(application))
    server.serve_forever()


if __name__ == '__main__':
    main()
