async function hola(){
    let param = "name=" + document.getElementById("name").value;
    let response = await fetch("/app_divisas/asincrono" + param);
    if (response.ok.ok){
        let texto = response.json();
    }else {
        alert("Error en la llamada asincrona");
    }
}