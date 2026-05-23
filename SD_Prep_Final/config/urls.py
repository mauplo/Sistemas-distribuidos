from django.urls import include, path


urlpatterns = [
    path('integracion/', include('integracion.urls')),
    path('', include('integracion.urls')),
]
