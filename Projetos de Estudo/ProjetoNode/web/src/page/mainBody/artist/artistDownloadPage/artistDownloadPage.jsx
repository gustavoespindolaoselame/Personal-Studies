import style from './artistDownloadPage.module.css';
import Card from './card/card'
import { useEffect, useState } from 'react';
import { useFlashErrMsg } from '../../../../elements/messageBox/messageBox'

function artistDownloadPage(props) {
    return (
        <div className={style.ArtistDownloadPage}>
            teste
            <div className={style.cardSpace}>
                artistDownloadPage
            </div>
        </div>
    );
}

export default artistDownloadPage;