import Playback from './playback';
import style from './index.module.css';
import React, { useEffect, useState } from 'react';

function Card(props) {
    const [descriptionFetch, setDescriptionFetch] = useState({});

    useEffect(
        () => {
            async function fetchDescription() {
                try{
                    const response = await fetch(`http://localhost:5000/song/details?id=${props.id}`);
                    const dataArray = await response.json();
                    setDescriptionFetch(dataArray[0]);
                } catch (error){
                    console.log(error);
                }
            }
            fetchDescription();
        }, []
    )

    return (
        <div className={style.Card}>
            <div className={style.description ? style.description : 'Undefined'}>
                <h2>{descriptionFetch ? descriptionFetch.name : 'Undefined'}</h2>
                <p>{descriptionFetch ? descriptionFetch.descrip : 'Undefined'}</p>
            </div>
            <Playback id={props.id}/>
        </div>
    );
}

export default Card;