import json
from http.server import BaseHTTPRequestHandler, HTTPServer


HOST = '127.0.0.1'
PORT = 8002


class RestHandler(BaseHTTPRequestHandler):
    def do_POST(self):
        if self.path != '/ventas':
            self.send_error(404, 'Ruta no encontrada')
            return

        content_length = int(self.headers.get('Content-Length', 0))
        raw_body = self.rfile.read(content_length).decode('utf-8')

        try:
            payload = json.loads(raw_body or '{}')
            monto = payload['monto']
        except (ValueError, KeyError):
            self.send_error(400, 'El cuerpo debe contener un JSON con la llave "monto"')
            return

        print('TIENDA 2: venta registrada por ${0}'.format(monto), flush=True)

        response = json.dumps({'mensaje': 'Venta registrada en TIENDA 2'}).encode('utf-8')
        self.send_response(200)
        self.send_header('Content-Type', 'application/json; charset=utf-8')
        self.send_header('Content-Length', str(len(response)))
        self.end_headers()
        self.wfile.write(response)

    def log_message(self, format, *args):
        return


def main():
    print('Servicio REST disponible en http://{0}:{1}/ventas'.format(HOST, PORT))
    server = HTTPServer((HOST, PORT), RestHandler)
    server.serve_forever()


if __name__ == '__main__':
    main()
