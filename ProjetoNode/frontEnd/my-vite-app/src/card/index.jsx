import Playback from '../playback';
import style from './index.module.css';
import React, { useEffect, useState } from 'react';

function Card(props) {
    const [descriptionFetch, setDescriptionFetch] = useState({});

    useEffect(
        () => {
            async function fetchDescription() {
                try{
                    const response = await fetch(`http://localhost:3007/song/details?id=${props.id}`);
                    const dataArray = await response.json();
                    console.log(dataArray);
                    setDescriptionFetch(dataArray[0]);
                } catch (error){
                    console.log(error);
                }
            }
            console.log(descriptionFetch);
            fetchDescription();
        }, []
    )

    return (
        <div className={style.Card}>
            <div className={style.description}>
                <h2>{descriptionFetch.name||'Undefined'}</h2>
                <p>{descriptionFetch.descrip}</p>
            </div>
            <Playback id={props.id}/>
        </div>
    );
}

export default Card;