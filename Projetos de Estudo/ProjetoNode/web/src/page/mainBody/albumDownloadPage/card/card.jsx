import style from './card.module.css';
import React, { useEffect, useState } from 'react';
import ImageComponent from './imgComponent/imgComponent';

function Card(props) {
    const [descriptionFetch, setDescriptionFetch] = useState({});

    useEffect(
        () => {
            async function fetchDescription() {
                try{
                    const response = await fetch(`http://localhost:5000/album/details?id=${props.id}`);
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
            <div className={style.topSection}>
                <h2>{descriptionFetch ? descriptionFetch.name || 'Undefined Title' : 'Undefined Title'}</h2>
                <ImageComponent id={props.id}/>
            </div>
            <div className={style.botSection}>
                <p>{descriptionFetch ? descriptionFetch.descrip || 'Undefined Description' : 'Undefined Description'}</p>
            </div>
        </div>
    );
}

export default Card;