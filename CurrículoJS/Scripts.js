class navButtonClass {
    constructor(navimage, ishovered, isscrolled, isclicked) {
        this.navimage = navimage;
        this.ishovered = ishovered;
        this.isscrolled = isscrolled;
        this.isclicked = isclicked;
    }
}

const navButton = new navButtonClass(document.querySelectorAll('.navimage'), [], [], [])
const sections = document.querySelectorAll('section');
let isSubPageShown = false;

document.addEventListener('DOMContentLoaded', () => {

    // On page load;
    navButton.isscrolled[0] = true;
    titleOpenTextBracket();
    drawOpacityChange();
});

window.addEventListener('click', () => {

    // Defines the current clicked location on the isclicked array and runs the draw function for it, also anchors the page to the right section, this could've been done with anchors, but this seems a little more modular to me
    for (let index = 0; index < navButton.navimage.length; index++) {
        navButton.navimage[index].addEventListener('click', () => {
            window.scrollTo({
                top: `${sections[index].offsetTop}`,
                behavior: 'smooth'
            });
            navButton.isclicked[index] = true;
        });
        navButton.isclicked[index] = false;
    }
    drawOpacityChange();
});

window.addEventListener('mouseover', () => {

    // Defines the current hovered location on the ishovered array and runs the draw function for it
    for (let index = 0; index < navButton.navimage.length; index++) {
        navButton.navimage[index].addEventListener('mouseover', () => {
            navButton.ishovered[index] = true;
        });
        navButton.navimage[index].addEventListener('mouseout', () => {
            navButton.ishovered[index] = false;
        });
    }
    drawOpacityChange();
});

window.addEventListener('scroll', () => {

    // Defines the current scroll location on the isscrolled array and runs the draw function for it
    for (let index = 0; index < navButton.navimage.length; index++) {
        if (window.scrollY > `${sections[index].offsetTop}` - `${sections[index].clientHeight}` / 2) {
            navButton.isscrolled[index + 1] = false;
            navButton.isscrolled[index] = true;
            navButton.isscrolled[index - 1] = false;
        } else {
            navButton.isscrolled[index] = false;
        }
    }
    drawOpacityChange();
});

function drawOpacityChange() {

    // Defines the opacity for the various conditions on the side nav bar buttons
    for (let index = 0; index < navButton.navimage.length; index++) {
        navButton.navimage[index].style.opacity = '0.08';
        if (navButton.isscrolled[index]) {
            navButton.navimage[index].style.opacity = '0.8';
        }
        else if (navButton.ishovered[index]) {
            navButton.navimage[index].style.opacity = '0.333';
        }
        else if (navButton.isclicked[index]) {
            navButton.navimage[index].style.opacity = '0.8';
        }
    }
}

function titleOpenTextBracket() {

    // Creates title text bracket
    let titleBracket = document.getElementById('titleBracket');

    // Sets the interval for it showing and hiding
    setInterval(() => {
        titleBracket.textContent = titleBracket.textContent.concat('|');
        setTimeout(() => {
            titleBracket.textContent = titleBracket.textContent.replace('|', '');
        }, 500);
    }, 1000);
}

function toggleOverlay(overlayId, ovSettingId) {

    // Creates overlay and a check for current scroll bracket for closing on scroll
    var overlay = document.getElementById(overlayId);
    // On/Off switch for subpage
    if (ovSettingId === 'subPageOn' && !isSubPageShown) {
            overlay.style.display = 'block';
            isSubPageShown = true;
    }

    if (ovSettingId==='subPageOff' && isSubPageShown){
        overlay.style.display = 'none';
        isSubPageShown = false;
    }

    // On/Off switch for message box
    if (ovSettingId === 'msBoxOn') {
        if (overlay.style.display === 'none' || overlay.style.display === '') {
            overlay.style.display = 'flex';
            setTimeout(() => {
                overlay.style.display = 'none';
            }, 1000);
        } else {
            overlay.style.display = 'none';
        }
    }

    // Closer overlay on esc
    window.addEventListener('keydown', function (event) {
        if (event.key === 'Escape' || event.key === 'Esc') {
            overlay.style.display = 'none';
            document.body.style.overflow = '';
            isSubPageShown = false;
        }
    });

}
function copyText(textToCopy) {

    // Recebe o valor para a área de transferência e transfere para a mesma
    navigator.clipboard.writeText(textToCopy).then(function () {
        console.log('Copiado para área de transferência');
    });
}

function blurButtonImg(buttonImgID) {
    buttonImgID.style.opacity = '50%';
    setTimeout(() => {
        buttonImgID.style.opacity = '100%';
    }, 500);
}