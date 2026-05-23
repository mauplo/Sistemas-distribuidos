import json
import os
from urllib import error, request


SOAP_SERVICE_URL = os.getenv('SOAP_SERVICE_URL', 'http://127.0.0.1:8001/')
REST_SERVICE_URL = os.getenv('REST_SERVICE_URL', 'http://127.0.0.1:8002/ventas')
SOAP_NAMESPACE = 'http://ventas.soap.example'


class ServiceError(Exception):
    pass


def registrar_venta_tienda_1(monto):
    envelope = """<?xml version="1.0" encoding="utf-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tns="{namespace}">
  <soapenv:Body>
    <tns:registrar_venta>
      <tns:monto>{monto}</tns:monto>
    </tns:registrar_venta>
  </soapenv:Body>
</soapenv:Envelope>
""".format(namespace=SOAP_NAMESPACE, monto=monto)
    soap_request = request.Request(
        SOAP_SERVICE_URL,
        data=envelope.encode('utf-8'),
        headers={
            'Content-Type': 'text/xml; charset=utf-8',
            'SOAPAction': 'registrar_venta',
        },
        method='POST',
    )
    _perform_request(soap_request, 'SOAP de la tienda 1')


def registrar_venta_tienda_2(monto):
    payload = json.dumps({'monto': monto}).encode('utf-8')
    rest_request = request.Request(
        REST_SERVICE_URL,
        data=payload,
        headers={'Content-Type': 'application/json'},
        method='POST',
    )
    _perform_request(rest_request, 'REST de la tienda 2')


def _perform_request(service_request, service_name):
    try:
        with request.urlopen(service_request, timeout=5) as response:
            response.read()
            if response.status >= 400:
                raise ServiceError('El servicio {0} devolvio un error.'.format(service_name))
    except error.URLError as exc:
        raise ServiceError(
            'No fue posible comunicarse con el servicio {0}: {1}'.format(service_name, exc)
        )
