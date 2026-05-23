from .models import Venta
from .service_clients import registrar_venta_tienda_1, registrar_venta_tienda_2


SERVICIOS_POR_TIENDA = {
    1: ('SOAP', registrar_venta_tienda_1),
    2: ('REST', registrar_venta_tienda_2),
}


def registrar_venta_integrada(tienda_id, monto):
    servicio, registrador = SERVICIOS_POR_TIENDA[tienda_id]
    registrador('{0:.2f}'.format(monto))
    return Venta.objects.create(
        tienda_id=tienda_id,
        monto=monto,
        servicio=servicio,
    )
