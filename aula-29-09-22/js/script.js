function contar1() {
    let out1 = document.getElementById('out1');
    out1.innerHTML += `<h2> Contando de 1 até 10 </h2>`;
    
    let cont1 = 1
    while (cont1 <= 10) {
        out1.innerHTML += `${cont1} &#x1F449;`;
        cont1++;
    }
    out1.innerHTML += `&#x1F449;`;
}

function contar2() {
    let out2 = document.getElementById('out2');
    out2.innerHTML += `<h2> Contando de 1 até 10 - marcando pares </h2>`;

    let cont2 = 1;
    while (cont2 <= 10) {
        if(cont2 % 2 == 0) {
            out2.innerHTML += `<mark><strong> ${cont2}</mark></strong>&#x1F449;`;
        } else {
            out2.innerHTML +=  `${cont2} &#x1F449;`;
        }
        cont2++;
    }
    out2.innerHTML += `&#x1F449;`;
}

function contar3() {
    let out3 = document.getElementById('out3');
    out3.innerHTML += `<h2> Contando de 1 até 10 - marcando ímpares </h2>`;

    let cont3 = 1;
    while (cont3 <= 10) {
        if(cont3 % 2 == 1) {
            out3.innerHTML += `<mark><strong> ${cont3}</mark></strong>&#x1F449;`;
        } else {
            out3.innerHTML +=  `${cont3} &#x1F449;`;
        }
        cont3++;
    }
    out3.innerHTML += `&#x1F449;`;
}

function contar4() {
    let out4 = document.getElementById('out4');
    out4.innerHTML += `<h2> Contagem regressiva de 10 até 1</h2>`;
    let cont4 = 10;
    while(cont4 >= 1){
        out4.innerHTML += `${cont4} &#x1F449;`;
        cont4--;
    }
    out4.innerHTML += `&#x1F449;`;
}

function contagem5() {
    let out5 = document.getElementById('out5');
    let n1 = Number(document.getElementById('fn1').value);
    let n2 = Number(document.getElementById('fn2').value);
    let cont5;

    out5.innerHTML += `<h2> Contando de ${n1} até ${n2}</h2>`;
        if(n1 < n2){
            cont5 = n1;
            while(cont5 <= n2) {
                out5.innerHTML += `${cont5} &#x1F449;`;
                cont5++;
        
            }
        }else if(n2 < n1) {
            cont5 = n1;
            while(cont5 >= n2){
                out5.innerHTML += `${cont5} &#x1F449;`;
                cont5--;
            }
        } else{
            out5.innerHTML += `não é possível contar, pois o números são iguais!`;
        }
        out5.innerHTML += `&#x1F449;`;
}