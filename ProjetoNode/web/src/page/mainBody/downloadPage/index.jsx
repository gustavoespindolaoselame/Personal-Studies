import style from './index.module.css';
import Card from './card'
import { useEffect, useState } from 'react';

function downloadPage(props) {

    const [numCards, setNumCards] = useState(0);
    const [cardList, setCardList] = useState([]);


    useEffect(
        () => {
            async function fetchNumSongs() {
                try{
                    const response = await fetch(`http://localhost:5000/song/size`);
                    setNumCards(await response.json());
                } catch (error){
                    console.log(error);
                }
            }
            fetchNumSongs();
        }, []
    )

    useEffect(() => {
        if (numCards > 0) {
            const newCardList = [];
            for (let i = 1; i < numCards+1; i++) {
                newCardList.push(<Card id={i} />);
            }
            setCardList(newCardList);
        }
    }, [numCards]);
        


    return (
        <div className={style.downloadPage}>
            <div className={style.cardSpace}>
                {cardList}
            </div>
        </div>
    );
}

export default downloadPage;