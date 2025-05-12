import style from './card.module.css';
import React, { useEffect, useState } from 'react';
import ImageComponent from './imgComponent/imgComponent';

function Card(props) {
    const [descriptionFetch, setDescriptionFetch] = useState({id:"",name:"",descrip:""});

    useEffect(
        () => {
            async function fetchDescription() {
                const response = await fetch(`http://localhost:5000/album/details?id=${props.id}`);
                const dataArray = await response.json();
                const albumsongsResponse = await fetch(`http://localhost:5000/albumssongs/name?id=${props.id}`);
                const albumsongsDataArray = await albumsongsResponse.json();
                let descriptionHandler = {
                    id: 
                    dataArray[0].id||'0', 
                    name:
                    dataArray[0].name||'Default Name', 
                    descrip:
                    dataArray[0].descrip + " Songs:" + albumsongsDataArray.map(matches=>matches[0].name).join(' ')||'Default description'
                }
                setDescriptionFetch(descriptionHandler);
            }
            fetchDescription();
        }, []
    )

    return (
        <div className={style.Card}>
            <div className={style.topSection}>
                <h2>{descriptionFetch.name}</h2>
                <ImageComponent id={props.id}/>
            </div>
            <div className={style.botSection}>
                <p>{descriptionFetch.descrip}</p>
            </div>
        </div>
    );
}

export default Card;