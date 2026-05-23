import os

from django.core.wsgi import get_wsgi_application

from .sqlite import install_sqlite_patch


install_sqlite_patch()
os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'config.settings')

application = get_wsgi_application()
