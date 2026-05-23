from django.db import models


class Venta(models.Model):
    tienda_id = models.PositiveSmallIntegerField()
    monto = models.DecimalField(max_digits=12, decimal_places=2)
    servicio = models.CharField(max_length=10)
    creada_en = models.DateTimeField(auto_now_add=True)

    class Meta:
        ordering = ['-creada_en', '-id']

    def __str__(self):
        return 'Tienda {0} - ${1}'.format(self.tienda_id, self.monto)
