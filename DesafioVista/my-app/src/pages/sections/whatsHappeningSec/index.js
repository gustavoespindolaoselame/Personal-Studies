import { useState } from 'react';
import Card from './card';
import style from './style.module.css';
import Link from 'next/link';

export default function () {
    const [cursor, setCursor] = useState(1);

    const arrayOfCards = [
        <Card img=' img '></Card>,
        <Card title=' title '></Card>,
        <Card learnMore=' learnMore '></Card>,
        <Card text=' text '></Card>,
        <Card img=' imgaaaaaaaaaaaaa '></Card>
    ];

    const moveRight = () => {
        if (cursor < 1) {
            setCursor(arrayOfCards.length - 1);
        } else {
            setCursor(cursor - 1);
        }
        
    };

    const moveLeft = () => {
        if (cursor >= arrayOfCards.length - 1) {
            setCursor(0);
        } else {
            setCursor(cursor + 1);
        }
    };

    const treatedArrayOfCards = () => {
        if(cursor===0){
            return [arrayOfCards[arrayOfCards.length-2],arrayOfCards[arrayOfCards.length-1],arrayOfCards[0]]
        }
        if(cursor===1){
            return [arrayOfCards[arrayOfCards.length-1],arrayOfCards[0],arrayOfCards[1]]
        }
        if(cursor===arrayOfCards.length-1){
            return [arrayOfCards[cursor],arrayOfCards[0],arrayOfCards[1]]
        }
        return [arrayOfCards[cursor-1],arrayOfCards[cursor],arrayOfCards[cursor+1]]
    };

    const chooseIndex = (index) => {
        setCursor(index)
    }

    const buttonFunction = () => {
        return arrayOfCards.map((_, index) => (
            <button 
            className={style.bottonButtons} 
            onClick={_ => chooseIndex(arrayOfCards.length - 1 - index)}
            key={arrayOfCards.length - 1 - index}
            style={{
                 backgroundColor:`${cursor==arrayOfCards.length - 1 - index?'black':'gray'}`
            }}>
                &nbsp;
                </button>
        ));
    };

    return (
        <section className={style.container}>
            <h1>WHAT'S HAPPENING</h1>
            <div className={style.cardDisplay}>
                <button className={style.sideArrow} onClick={moveLeft}>&lt;</button>
                {treatedArrayOfCards()}
                <button className={style.sideArrow} onClick={moveRight}>&gt;</button>
            </div>
            <div>
                {buttonFunction()}
            </div>
        </section>
    );
}
