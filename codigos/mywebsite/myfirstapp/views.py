from django.shortcuts import render
from django.http import HttpResponse, Http404
from django.template import loader
from .models import Estudiante
from django.shortcuts import render, get_object_or_404


# Create your views here.
def index(request):
    estudiantes = Estudiante.objects.order_by("apellidos")
    #diccionario de parametros
    contexto = {
        "estudiantes" : estudiantes
    }
    template = loader.get_template("myfirstapp/index.html")

    return HttpResponse(template.render(contexto, request))

def carreras(request, estudiante_id):
    return HttpResponse("Carreras del estudiante %s" % estudiante_id)

def detalles(request, estudiante_id):
    estudiante = get_object_or_404(Estudiante, pk=estudiante_id)
    return render(request, 
                  "myfirstapp/detalles.html", 
                  {"estudiante" : estudiante}) 


def detalles_ajax(request, estudiante_id):
    """Devuelve el fragmento HTML con los detalles del estudiante (para peticiones AJAX)."""
    estudiante = get_object_or_404(Estudiante, pk=estudiante_id)
    # Renderizamos solamente el fragmento de detalles
    return render(request, "myfirstapp/detalles_fragment.html", {"estudiante": estudiante})

def agrega_carrera(request, estudiante_id, tipo, nombre):
    estudiante = Estudiante.objects.get(pk=estudiante_id)
    estudiante.carrera_set.create(tipo = int(tipo), nombre=nombre)
    return HttpResponse("Carrera agregada al estudiante %s" % estudiante_id)


def agrega_estudiante(request, nombre, apellidos, edad, foraneo, promedio):
    foraneo = foraneo.lower() == "true"
    estudiante = Estudiante(	nombre=nombre, 
				apellidos=apellidos, 
				edad=int(edad), 
				foraneo=foraneo, 
				promedio=float(promedio))
    estudiante.save()
    return HttpResponse("Estudiante %s agregado exitósamente" % estudiante.id)


def borra_estudiante(request, estudiante_id):
    estudiante = Estudiante.objects.get(pk=estudiante_id)
    estudiante.delete()
    return HttpResponse("Estudiante %s borrado exitósamente" % estudiante_id)


def edita_estudiante(request, estudiante_id, promedio):
    estudiante = Estudiante.objects.get(pk=estudiante_id)
    estudiante.promedio = float(promedio)
    estudiante.save()    
    return HttpResponse("El promedio del estudiante %s se ha actualizado exitósamente" % estudiante.id)


def agrega_estudiante_forma(request):
    nombre = request.POST.get("nombre")
    apellidos = request.POST.get("apellidos")
    edad = int(request.POST.get("edad"))
    promedio = float(request.POST.get("promedio"))
    if "foraneo" in request.POST:
        foraneo = True
    else:
        foraneo = False
    estudiante = Estudiante(nombre=nombre, 
                    apellidos=apellidos, 
                    edad=edad, 
                    promedio=promedio,
                    foraneo=foraneo)
    estudiante.save()
    identificador = str(estudiante.id)
    return HttpResponse("El estudiante %s fue agregado" % identificador)

def asincrono(request):
    nombre = request.GET.get("name")
    return HttpResponse("Hola" + nombre)

