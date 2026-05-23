function di_hola(nombre){
    alert("Hola " + nombre);
}

function cambiar(id){
            let elemento = document.getElementById(id);
            elemento.innerHTML = "Texto cambiado";
}

 function changeImage() {
    let element = document.getElementById("myimage");
    if (element.src.match("down")) {
        element.src = "images/up.png";
    } else {
        lement.src = "images/down.png";
    }
 }

 function myFunction() {
    var y = document.getElementById("mess");
    y.innerHTML="";
    try {
        var x =document.getElementById("demo").value;
        if (x === "") throw "empty";
        if (isNaN(x)) throw "not a number";
        if (x > 10) throw "too high";
        if (x < 5) throw "too low";
    } catch(err) {
    y.innerHTML="Error: " + err + ".";
 }
}

function increaseText(id){
    document.getElementById(id).innerHTML=
    document.getElementById(id).innerHTML.charAt(0)+
    document.getElementById(id).innerHTML;
 }

 function upperCase(id){
    var text=document.getElementById(id);
    text.value=text.value.toUpperCase();
 }

function eventMouseOver(obj) {
    obj.innerHTML="Thank You";
}
function eventMouseOut(obj){
    obj.innerHTML="Mouse Over Me";
}