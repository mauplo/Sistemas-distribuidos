from django.urls import path

from . import views


urlpatterns = [
    path('', views.inicio, name='inicio'),
    path('<int:tienda_id>/<str:monto>/recibe_ventas/', views.recibe_ventas, name='recibe_ventas'),
]
