from decimal import Decimal, InvalidOperation

from django.db.models import Sum
from django.http import HttpResponseBadRequest, HttpResponseServerError
from django.shortcuts import render

from .models import Venta
from .registro_ventas import SERVICIOS_POR_TIENDA, registrar_venta_integrada
from .service_clients import ServiceError


def inicio(request):
    ventas = Venta.objects.all()
    total_montos = ventas.aggregate(total=Sum('monto'))['total'] or Decimal('0.00')
    ejemplos = [
        {
            'descripcion': 'Registrar una venta para TIENDA 1 usando SOAP',
            'url': 'http://127.0.0.1:8000/integracion/1/10000.45/recibe_ventas/',
        },
        {
            'descripcion': 'Registrar una venta para TIENDA 2 usando REST',
            'url': 'http://127.0.0.1:8000/integracion/2/20000.75/recibe_ventas/',
        },
    ]
    contexto = {
        'ejemplos': ejemplos,
        'ventas': ventas,
        'total_montos': '{0:.2f}'.format(total_montos),
    }
    return render(request, 'integracion/inicio.html', contexto)


def recibe_ventas(request, tienda_id, monto):
    try:
        monto_decimal = Decimal(monto)
    except InvalidOperation:
        return HttpResponseBadRequest('El monto indicado no es valido.')

    if monto_decimal <= 0:
        return HttpResponseBadRequest('El monto debe ser mayor a cero.')

    if tienda_id not in SERVICIOS_POR_TIENDA:
        return HttpResponseBadRequest('La tienda indicada no existe.')

    try:
        venta = registrar_venta_integrada(tienda_id, monto_decimal)
    except ServiceError as exc:
        return HttpResponseServerError(str(exc))

    contexto = {
        'venta': venta,
    }
    return render(request, 'integracion/venta_registrada.html', contexto)
