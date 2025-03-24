import { useEffect, useState } from 'react';
import Card from './card';
import Style from './style.module.css';
import Link from 'next/link';

export default function () {
    const [cursor, setCursor] = useState(1);

    const arrayOfCards = [
        <Card img='./welcome.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={0}></Card>,

        <Card img='./joelVictoria.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={1}></Card>,

        <Card 
        img='./welcome.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={2}></Card>,

        <Card img='./joelVictoria.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={3}></Card>,
        
        <Card img='./welcome.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={4}></Card>,

        <Card img='./joelVictoria.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={5}></Card>,

        <Card img='./welcome.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={6}></Card>,

        <Card img='./joelVictoria.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={7}></Card>,

        <Card img='./welcome.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={8}></Card>,

        <Card img='./joelVictoria.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={9}></Card>,

        <Card img='./welcome.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={10}></Card>,

        <Card img='./joelVictoria.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={11}></Card>,

        <Card img='./welcome.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={12}></Card>,

        <Card img='./joelVictoria.png' 
        title='New Beginnings' 
        text='Join us Saturday-Sunday, march 29th-30th' 
        learnMore='Learn More >' 
        learnMoreLink='./link'
        key={13}></Card>
    ];

    const moveLeft = () => {
        setCursor(prevCursor => {
            if (prevCursor == 0) {
                return arrayOfCards.length - 1;
            };
            return prevCursor - 1;
        });
    };

    const moveRight = () => {
        setCursor(prevCursor => {
            if (prevCursor === arrayOfCards.length - 1) {
                return 0;
            }
            return prevCursor + 1;
        });
    };

    const treatedArrayOfCards = () => {
        return [
            arrayOfCards[(cursor - 1 + arrayOfCards.length) % arrayOfCards.length],
            arrayOfCards[cursor],
            arrayOfCards[(cursor + 1) % arrayOfCards.length]
        ];
    };

    const chooseIndex = (index) => {
        setCursor(index)
    }

    const buttonFunction = () => {
        return arrayOfCards.map((_, index) => (
            <button 
            className={Style.bottonButtons} 
            onClick={_ => chooseIndex(arrayOfCards.length-1-index)}
            key={arrayOfCards.length-1-index}
            style={{
                 backgroundColor:`${cursor==arrayOfCards.length-1-index?'black':'gray'}`
            }}>
                &nbsp;
                </button>
        ));
    };

    useEffect(() => {
        const interval = setInterval(() => {
            moveLeft();
        }, 6000);
    
        return () => clearInterval(interval); // Cleanup to prevent memory leaks
    }, []);    

    return (
        <section className={Style.container}>
            <h1>WHAT'S HAPPENING</h1>
            <div className={Style.cardDisplay}>
                <button className={Style.sideArrow} onClick={moveRight}>&lt;</button>
                {treatedArrayOfCards()}
                <button className={Style.sideArrow} onClick={moveLeft}>&gt;</button>
            </div>
            <div className={Style.buttonFunction}>
                {buttonFunction()}
            </div>
        </section>
    );
}
