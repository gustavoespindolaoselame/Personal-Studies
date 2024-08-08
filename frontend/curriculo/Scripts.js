const navimage = document.querySelectorAll('.navimage');
const buttons = document.querySelectorAll('.navbutton');
const sections = document.querySelectorAll('section');

function FilterOverlay(bbdisplay, button) {
    this.element = bbdisplay;
    this.button = button;
};

const filterconst = new FilterOverlay([], [], []);

document.addEventListener('DOMContentLoaded', () => {
    for (let index = 0; index < navimage.length; index++) {
        filterconst.element[index] = document.createElement('div');
        filterconst.element[index].className = 'cover';
        filterconst.element[index].style.width = `${navimage[index].offsetWidth}px`;
        filterconst.element[index].style.height = `${navimage[index].offsetHeight}px`;
        filterconst.element[index].style.top = `${navimage[index].offsetTop}px`;
        filterconst.element[index].style.left = `${navimage[index].offsetLeft}px`;
        filterconst.element[index].classList.add('new-element');
        navimage[index].parentNode.appendChild(filterconst.element[index]);
        filterconst.button[index] = buttons[index];
        filterconst.element[0].style.opacity = '0';
    };
    toggleTitleBracket();
});

window.addEventListener('click', () => {
    for (let index = 0; index < navimage.length; index++) {
        filterconst.button[index].addEventListener('click', () => {
            window.scrollTo({
                top: `${sections[index].offsetTop}`,
                behavior: 'smooth'
            });
        });
    }
});
window.addEventListener('scroll', () => {
    for (let index = 0; index < navimage.length; index++) {
        if (window.scrollY >= sections[index].offsetTop - 300 && window.scrollY < sections[index + 1].offsetTop - 300) {
            filterconst.element[index].style.opacity = '0';
        } else if (window.scrollY >= sections[navimage.length - 1].offsetTop - 300) {
            filterconst.element[navimage.length - 1].style.opacity = '0';
            filterconst.element[navimage.length - 2].style.opacity = '0.8';
        } else {
            filterconst.element[index].style.opacity = '0.8';
        }
    }
});

function toggleTitleBracket() {
    const titlebracket = document.getElementById('titlebracket');
    const newH2 = document.createElement('h2');
    newH2.textContent = '|';
    
    titlebracket.appendChild(newH2);

    setInterval(() => {
        newH2.style.visibility = newH2.style.visibility === 'hidden' ? 'visible' : 'hidden';
    }, 500);
}