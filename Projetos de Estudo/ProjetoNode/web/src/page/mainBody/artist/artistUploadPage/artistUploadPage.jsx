import { useCallback, useEffect, useState } from 'react';
import style from './artistUploadPage.module.css';
import ValueInput from '../../../../elements/valueInput/valueInput'
import { useDropzone } from 'react-dropzone';
import { useFlashErrMsg } from '../../../../elements/messageBox/messageBox';

function ArtistUploadPage() {

    return (
        <div className={style.uploadPage}>
            artist upload page
        </div>
    );
}

export default ArtistUploadPage;
