class navButtonClass {
    constructor(navimage, ishovered, isscrolled, isclicked){
        this.navimage = navimage;
        this.ishovered = ishovered;
        this.isscrolled = isscrolled;
        this.isclicked = isclicked;
    }
}

const navButton = new navButtonClass(document.querySelectorAll('.navimage'), [], [], [])
const sections = document.querySelectorAll('section');

document.addEventListener('DOMContentLoaded', () => {

    // On page load;
    navButton.isscrolled[0]=true;
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
            navButton.isclicked[index]=true;
        });
        navButton.isclicked[index]=false;
    }
    drawOpacityChange();
});

window.addEventListener('mouseover', () => {

    // Defines the current hovered location on the ishovered array and runs the draw function for it
    for (let index = 0; index < navButton.navimage.length; index++) {
        navButton.navimage[index].addEventListener('mouseover', () => {        
            navButton.ishovered[index]=true;
        });   
        navButton.navimage[index].addEventListener('mouseout', () => {        
                navButton.ishovered[index]=false;
        });
    }
    drawOpacityChange();
});

window.addEventListener('scroll', () => {

    // Defines the current scroll location on the isscrolled array and runs the draw function for it
    for (let index = 0; index < navButton.navimage.length; index++) {
        if (window.scrollY > `${sections[index].offsetTop}`-`${sections[index].clientHeight}`/2)
        {   
            navButton.isscrolled[index+1]=false;
            navButton.isscrolled[index]=true;
            navButton.isscrolled[index-1]=false;
        }  else{
            navButton.isscrolled[index]=false;
        }
    }   
    drawOpacityChange();
});

function drawOpacityChange(){

    // Defines the opacity for the various conditions on the side nav bar buttons
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

    // Creates title text bracket
    let titlebracket = document.getElementById('titlebracket');
    let newDiv = document.createElement('div');
    newDiv.textContent = '|';
    titlebracket.appendChild(newDiv);

    // Sets the interval for it showing and hiding
    setInterval(() => {
        newDiv.style.visibility = newDiv.style.visibility === 'hidden' ? 'visible' : 'hidden';
    }, 500);
}

function toggleOverlay(overlayId) {
    
    // Creates overlay and a check for current scroll bracket for closing on scroll
    var overlay = document.getElementById(overlayId);
    var currentScrollBracket;

    // On/Off switch for display
    if (overlay.style.display === 'none' || overlay.style.display === '') {
        currentScrollBracket=window.scrollY;
        overlay.style.display = 'block';
    } else {
        overlay.style.display = 'none';
    }

    // Closes overlay on scroll
    window.addEventListener('scroll', () => {
        if(window.scrollY>currentScrollBracket+`${sections[0].clientHeight}`/1.5||
            window.scrollY<currentScrollBracket-`${sections[0].clientHeight}`/1.5){
            overlay.style.display = 'none';
            currentScrollBracket=window.scrollY;
        } 
    });

    // Closer overlay on esc
    window.addEventListener('keydown', function(event) {
        if (event.key === 'Escape' || event.key === 'Esc') {
            overlay.style.display = 'none';
        }
    });
    
}

function copyText(textToCopy) {

    // Recebe o valor para a área de transferência e transfere para a mesma
    navigator.clipboard.writeText(textToCopy).then(function() {
        console.log('Copiado para área de transferência');
    });
}

function blurButtonImg(buttonImgID){
    buttonImgID.style.opacity='50%';
        setTimeout(() => {
            buttonImgID.style.opacity='100%';  
        }, 500);
}