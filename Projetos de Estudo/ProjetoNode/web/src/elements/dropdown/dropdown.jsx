import { useEffect, useState } from 'react';
import style from './dropdown.module.css';

function Dropdown(props) {
    const [isDropped, setIsDropped] = useState(false);
    const [isDroppedProxy, setIsDroppedProxy] = useState(false);

    const [isUploadDropped, setIsUploadDropped] = useState(false);
    const [isUploadDroppedProxy, setIsUploadDroppedProxy] = useState(false);


    const selectWaitForMouseOut = () => {
        setTimeout(() => {
            !isDroppedProxy?
            setIsDropped(false):
            setIsDropped(true);
        }, 750);
    }
    useEffect(selectWaitForMouseOut,[isDroppedProxy]);

    const uploadWaitForMouseIn = () => {
        setTimeout(() => {
            isUploadDroppedProxy?
            setIsUploadDropped(true):
            setIsUploadDropped(false);
        }, 500);
    }
    useEffect(uploadWaitForMouseIn,[isUploadDroppedProxy]);

    return (
        <div className={style.dropdownContainer}>
            <div className={style.dropdown} onMouseOver={_ => {setIsDropped(true); setIsDroppedProxy(true);}} onMouseOut={_ => {setIsDroppedProxy(false);}}>
                <div className={style.navButton}>
                    select
                </div>
                {isDropped&&(
                    <>
                        <div className={style.section}>
                        <a href="/artist/download">ARTIST</a>
                        </div>
                        <div className={style.section}>
                        <a href="/albums/download">ALBUM</a>
                        </div>
                        <div className={style.section}>
                        <a href="/songs/download">SONG</a>
                        </div>
                        <div onMouseOver={() => {setIsUploadDroppedProxy(true);}} onMouseOut={() => {setIsUploadDroppedProxy(false);}}>
                            {isUploadDropped?(<>
                                <div className={style.slide}>
                                    <div className={style.section}>
                                    <a href="/artist/upload">ARTIST - Uploads</a>
                                    </div>
                                    <div className={style.section}>
                                    <a href="/albums/upload">ALBUM - Uploads</a>
                                    </div>
                                    <div className={style.section}>
                                    <a href="/songs/upload">SONG - Uploads</a>
                                    </div>
                                </div>
                            </>):
                            <div className={style.section}>
                                upload
                            </div>}
                        </div>
                        <div className={style.section}>
                        <a href="/developer">DEV</a>
                        </div>
                    </>)}
            </div>
        </div>
    );
}

export default Dropdown;



        
        
        
       
        
        