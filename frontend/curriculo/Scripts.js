class navButtonClass {
    constructor(navimage, ishovered, isscrolled, isclicked){
        this.navimage = navimage;
        this.ishovered = ishovered;
        this.isscrolled = isscrolled;
        this.isclicked = isclicked;
    }
}

const navButton = new navButtonClass(document.querySelectorAll('.navimage'), [], [], [])
const overlayOpener = document.querySelectorAll('.overlayOpener');
const sections = document.querySelectorAll('section');

document.addEventListener('DOMContentLoaded', () => {
    navButton.isscrolled[0]=true;
    titleOpenTextBracket();
    drawOpacityChange();
});

window.addEventListener('click', () => {
    for (let index = 0; index < overlayOpener.length; index++) {
        overlayOpener[index].addEventListener('click', () => {
            const test = this.getAttribute('data-index');
            document.getElementById('overlay-' + test).style.display = 'flex';
            console.log("que");
        });
    }
    for (let index = 0; index < navButton.navimage.length; index++) {
        navButton.navimage[index].addEventListener('click', () => {
            window.scrollTo({
                top: `${sections[index].offsetTop}`,
                behavior: 'smooth'
            });
            navButton.isclicked[index]=true;
        });
        navButton.isclicked[index]=false;
    }
    drawOpacityChange();
});

window.addEventListener('mouseover', () => {
    for (let index = 0; index < navButton.navimage.length; index++) {
        navButton.navimage[index].addEventListener('mouseover', () => {        
            navButton.ishovered[index]=true;
            navButton.navimage[index].style.cursor = 'pointer';
        });   
        navButton.navimage[index].addEventListener('mouseout', () => {        
                navButton.ishovered[index]=false;
        });
    }
    drawOpacityChange();
});

window.addEventListener('scroll', () => {
    for (let index = 0; index < navButton.navimage.length; index++) {
        if (window.scrollY > `${sections[index].offsetTop}`-`${sections[index].clientHeight}`/2)
        {
            navButton.isscrolled[index]=true;
            navButton.isscrolled[index-1]=false;
        }  else{
            navButton.isscrolled[index]=false;
        }
    }   
    drawOpacityChange();
});

function drawOpacityChange(){
    for (let index = 0; index < navButton.navimage.length; index++) {
        navButton.navimage[index].style.opacity = '0.1';
        if(navButton.isscrolled[index]){
            navButton.navimage[index].style.opacity = '1';
        } 
        else if(navButton.ishovered[index]){
            navButton.navimage[index].style.opacity = '0.333';
        } 
        else if(navButton.isclicked[index]){
            navButton.navimage[index].style.opacity = '1';
        }
    }   
}

function titleOpenTextBracket(){
    let titlebracket = document.getElementById('titlebracket');
    let newSpan = document.createElement('span');
    newSpan.textContent = '|';
    titlebracket.appendChild(newSpan);
    setInterval(() => {
        newSpan.style.visibility = newSpan.style.visibility === 'hidden' ? 'visible' : 'hidden';
    }, 500);
}