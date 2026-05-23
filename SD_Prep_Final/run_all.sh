#!/usr/bin/env bash

set -e

cleanup() {
    kill "$SOAP_PID" "$REST_PID" "$DJANGO_PID" 2>/dev/null || true
}

trap cleanup EXIT INT TERM

./.venv/bin/python services/soap_service.py &
SOAP_PID=$!

./.venv/bin/python services/rest_service.py &
REST_PID=$!

./.venv/bin/python manage.py runserver 127.0.0.1:8000 --noreload &
DJANGO_PID=$!

wait "$SOAP_PID" "$REST_PID" "$DJANGO_PID"
