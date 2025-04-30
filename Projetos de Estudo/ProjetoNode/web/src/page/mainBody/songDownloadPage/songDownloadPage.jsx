import style from './songDownloadPage.module.css';
import Card from './card/card'
import { useEffect, useState } from 'react';
import { useFlashErrMsg } from '../../messageBox/messageBox'

function downloadPage(props) {

    const [numCards, setNumCards] = useState(0);
    const [cardList, setCardList] = useState([]);
    const flashErrMsg = useFlashErrMsg('No Amount Of Songs Retrieved');


    useEffect(
        () => {
            async function fetchNumSongs() {
                try{
                    const response = await fetch(`http://localhost:5000/song/size`);
                    if(response!==0){
                        setNumCards(await response.json());
                    } else {
                        flashErrMsg();
                    }
                } catch (error){
                    flashErrMsg();
                    console.log(error);
                }
            }
            fetchNumSongs();
        }, []
    )

    useEffect(() => {
        if(numCards>0){
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