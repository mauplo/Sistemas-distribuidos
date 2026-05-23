document.addEventListener('DOMContentLoaded', function () {
    const select = document.getElementById('estudiante-select');
    const detallesContainer = document.getElementById('detalles-container');
    console.log('myjavascript: DOMContentLoaded');

    if (!select) {
        console.warn('myjavascript: no se encontró el select #estudiante-select');
        return; // nothing to do
    }

    select.addEventListener('change', async function (e) {
        const estudianteId = e.target.value;
        if (!estudianteId) {
            detallesContainer.innerHTML = '';
            return;
        }
        // Mostrar indicador de carga
        detallesContainer.innerHTML = '<p>Cargando detalles...</p>';

        // Construir URL relativa robusta usando la ruta actual
        // Si la página de índice está en /myfirstapp/ entonces basePath será '/myfirstapp/'
        let basePath = window.location.pathname;
        if (!basePath.endsWith('/')) basePath += '/';
        const url = `${basePath}${estudianteId}/detalles_ajax/`;
        console.log('myjavascript: solicitando detalles desde', url);

        try {
            const resp = await fetch(url);
            if (!resp.ok) {
                console.error('myjavascript: respuesta no OK', resp.status);
                const text = await resp.text().catch(() => '');
                detallesContainer.innerHTML = `<p>Error cargando detalles (HTTP ${resp.status})</p><pre>${text}</pre>`;
                return;
            }
            const html = await resp.text();
            detallesContainer.innerHTML = html;
        } catch (err) {
            console.error('myjavascript: error durante fetch', err);
            detallesContainer.innerHTML = `<p>Error en la solicitud: ${err.message}</p>`;
        }
    });
});
