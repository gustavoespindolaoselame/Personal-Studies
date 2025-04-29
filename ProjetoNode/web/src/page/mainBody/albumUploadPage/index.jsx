import { useState } from 'react';
import style from './index.module.css';
import ValueInput from '../../../elements/valueInput'

function AlbumUploadPage() {
    const [artistId, setArtistId] = useState([undefined]);
    const [songId, setSongId] = useState([undefined]);


    return (
        <div className={style.uploadPage}>
                <ValueInput title='Artist Id' type='number' state={[artistId, setArtistId]} />
                <ValueInput title='Song Id' type='number' state={[songId, setSongId]}/>
        </div>
    );
}

export default AlbumUploadPage;
