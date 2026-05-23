# Integracion de ventas

Este proyecto integra el registro de ventas de dos sucursales en una sola aplicacion web en Django.

## Arquitectura

- `services/soap_service.py`: servicio SOAP para la TIENDA 1.
- `services/rest_service.py`: servicio REST para la TIENDA 2.
- `integracion/service_clients.py`: clientes HTTP para hablar con los servicios externos.
- `integracion/registro_ventas.py`: orquestacion del registro de venta y su persistencia.
- `integracion/models.py`: modelo `Venta` almacenado en SQLite.
- `templates/integracion/inicio.html`: landpage con instrucciones, historial y total acumulado.

## Instalacion

```bash
./.venv/bin/pip install -r requirements.txt
```

## Base de datos

La aplicacion usa `SQLite` en el archivo `db.sqlite3`.

Este workspace no trae el modulo nativo `sqlite3`, por eso se usa `pysqlite3-binary` como reemplazo compatible desde `config/sqlite.py`.

Para crear la base:

```bash
./.venv/bin/python manage.py migrate
```

## Ejecucion

Puedes levantar todo en terminales separadas:

```bash
./.venv/bin/python services/soap_service.py
./.venv/bin/python services/rest_service.py
./.venv/bin/python manage.py runserver
```

O usar el script:

```bash
./run_all.sh
```

## Uso

La URL para registrar ventas es:

```text
/integracion/<tienda_id>/<monto>/recibe_ventas/
```

Ejemplos:

- `http://127.0.0.1:8000/integracion/1/10000.45/recibe_ventas/`
- `http://127.0.0.1:8000/integracion/2/20000.75/recibe_ventas/`

La landpage en `http://127.0.0.1:8000/` muestra:

- Como registrar ventas mediante URLs.
- El listado de ventas persistidas.
- El total acumulado de los montos.
