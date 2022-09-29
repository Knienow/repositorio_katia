//classe document
document.write("aula 15-09");

//title - retorna o título da página
//URL - retorna a url completa da página
document.write("<h2>" + document.title + "</h2>");
//ln - escrever em nova linha
document.writeln(document.URL);

//requisitando informações do html e alterando-as
function fAlterar(){
    var x = document.getElementById("paragrafo");
    x.innerHTML="Bom dia";
}

/*function turnOff() {
    if (image.src.match("bulbon")){
        image.src = "./image/lampon.gif";
    } else {
        image.src = "./image/lampoff.gif";
    }
}*/

function changeLamp() {
    var image = document.getElementById('lampChange');
    if (image.src.match("lampon")) {
        image.src = "./image/lampoff.gif";
    } else {
       image.src = "./image/lampon.gif";
    }
    turnOff();
}

function somar() {
    //converte de string(v1) pra inteiro(n1) 
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: " + (n1+n2);
}

function subtrair() {
    //converte de string(v1) pra inteiro(n1) 
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: " + (n1-n2);
}

function multiplicar() {
    //converte de string(v1) pra inteiro(n1) 
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: " + (n1*n2);
}

function dividir() {
    //converte de string(v1) pra inteiro(n1) 
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: " + (n1/n2);
}

function porcentagem() {
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: " + (((n1*n2)/100));
}

function resto() {
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: " + (n1 % n2);
}

function limpar() {
    var n1 = parseInt(document.getElementById("v1"));
    var n2 = parseInt(document.getElementById("v2"));
    var r = parseInt(document.getElementById("res"));
    n1.value = "";
    n2.value = "";
    r.innerHTML = "Resposta: ";
}