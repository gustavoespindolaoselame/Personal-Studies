import { useState } from 'react';
import style from './songUploadPage.module.css';
import {useDropzone} from 'react-dropzone'
import { useCallback } from 'react';
import { useFlashErrMsg } from '../../messageBox/messageBox'
import ValueInput from '../../../elements/valueInput/valueInput';

function uploadPage() {

    const [artistId, setArtistId] = useState([""]);
    const [albumId, setAlbumId] = useState([""]);
    const [songName, setSongName] = useState("");
    const [songDescription, setSongDescription] = useState("");
    const [songBinary, setSongBinary] = useState();
    const [artBinary, setArtBinary] = useState();
    const [songFileName, setSongFileName] = useState('Drag Song MP3 Here');
    const [artFileName, setArtFileName] = useState('Drag Song Image Here');


    const onSongDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];
        setSongFileName(file.name);
        const reader = new FileReader();
    
        reader.onload = () => {
            const arrayBuffer = reader.result;
            setSongBinary(arrayBuffer);
            console.log("Arquivo carregado com sucesso!");
        };
        reader.readAsArrayBuffer(file);
    }, []);

    const onArtDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];
        setArtFileName(file.name);
        const reader = new FileReader();
        reader.onload = () => {
            const arrayBuffer = reader.result;
            setArtBinary(arrayBuffer);
            console.log("Imagem carregada com sucesso!");
        };
        reader.readAsArrayBuffer(file);
    }, []);

    const {
        getRootProps: getSongRootProps,
        getInputProps: getSongInputProps,
        isDragActive: isSongDragActive
    } = useDropzone({ onDrop: onSongDrop, multiple: false });

    const {
        getRootProps: getArtRootProps,
        getInputProps: getArtInputProps,
        isDragActive: isArtDragActive
    } = useDropzone({ onDrop: onArtDrop, multiple: false });

    const flashErrMsg = useFlashErrMsg(' Failed to send files. ');

    const sendable = songBinary&&artBinary&&artistId!==""&&albumId!==""&&songName!==""&&songDescription!=="";

    const send = async () => {
            if(sendable){
            const formData = new FormData();
            formData.append("song", new Blob([songBinary], { type: "audio/mpeg" }));
            formData.append("songArt", new Blob([artBinary], { type: "image/jpeg" }));
            formData.append("artistId", artistId.filter(item => item !== "") || []);
            formData.append("albumId", albumId.filter(item => item !== "") || []);
            formData.append("name", songName);
            formData.append("description", songDescription);
            try {
                await fetch(`${import.meta.env.VITE_API_URL}/song`, {
                    method: "POST",
                    body: formData
                });
            } catch (error) {
                flashErrMsg('Failed to Connect to Server');
                console.error(error);
            }
        }
    }


    return (
        <div className={style.uploadPage}>
            <div className={style.uploadPageIn}>
                <h1>Upload Forms</h1>
                <input value={songName} onChange={e => setSongName(e.target.value)} type='text' placeholder='Nome música'/>
                <input value={songDescription} onChange={e => setSongDescription(e.target.value)} type='text' placeholder='Descrição música'/>
                <ValueInput title='Artist Id Type' type='number' state={[artistId, setArtistId]} />
                <ValueInput title='Album Id Type' type='number' state={[albumId, setAlbumId]} />
                <div {...getSongRootProps()} className={style.dropZone}>
                    <input {...getSongInputProps()} />
                    {isSongDragActive ? <p>Solte a música aqui...</p> : <p>{songFileName}</p>}
                </div>
                <div {...getArtRootProps()} className={style.dropZone}>
                    <input {...getArtInputProps()} />
                    {isArtDragActive ? <p>Solte a imagem aqui...</p> : <p>{artFileName}</p>}
                </div>
                <button onClick={sendable ? send : flashErrMsg}>Send Files</button>
            </div>
        </div>
    );
}

export default uploadPage;