const cards = document.querySelectorAll('.card');
let hasFlippedCard = false;
let lockBoard = false;
let primeiraCarta, segundaCarta;

//função que vai revelar a carta
function flipCard() {
    if(lockBoard) return;
    if(this === primeiraCarta) return;

    this.classList.add('flip');
    if(!hasFlippedCard){
        hasFlippedCard = true;
        primeiraCarta = this;
        return;
    }

    segundaCarta = this;
    hasFlippedCard = false;
    checkForMatch();
}

//função qie verifica a igualdade das cartas
function checkForMatch() {
    if(primeiraCarta.dataset.card === segundaCarta.dataset.card){
        disableCards();
        return;
    }
    unflipCards();
}

//função que desabilitará as cartas
function disableCards() {
    primeiraCarta.removeEventListener('click', flipCard);
    segundaCarta.removeEventListener('click', flipCard);
   
    resetBoard();
}

//função que irá desvirar as cartas
function unflipCards() {
    lockBoard = true;

    setTimeout(() => {
        primeiraCarta.classList.remove('flip');
        segundaCarta.classList.remove('flip');
        resetBoard();
    }, 1500);
}

//função que irá resetar o tabuleiro
function resetBoard() {
    [hasFlippedCard, lockBoard] = [false, false];
    [primeiraCarta, segundaCarta] = [null, null];
}

//função que embaralha as cartas
(function shuffle() {
    cards.forEach((card) => {
        let randomPosition = Math.floor(Math.random() * 12);
        card.style.order = randomPosition;
    })
})();

//evento clique na carta
cards.forEach((card) => {
    card.addEventListener('click', flipCard);
});
