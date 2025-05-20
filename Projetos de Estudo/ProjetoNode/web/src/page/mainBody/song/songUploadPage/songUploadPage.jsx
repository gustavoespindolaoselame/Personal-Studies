import { useEffect, useState } from 'react';
import style from './songUploadPage.module.css';
import {useDropzone} from 'react-dropzone'
import { useCallback } from 'react';
import { useFlashErrMsg } from '../../../../elements/messageBox/messageBox'
import ValueInput from '../../../../elements/valueInput/valueInput';

function uploadPage() {

    const [artistIds, setArtistIds] = useState([""]);
    const [albumNames, setAlbumNames] = useState([""]);
    const [songName, setSongName] = useState("");
    const [songDescription, setSongDescription] = useState("");
    const [songBinary, setSongBinary] = useState();
    const [artBinary, setArtBinary] = useState();
    const [songFileName, setSongFileName] = useState('Drag Song MP3 Here');
    const [artFileName, setArtFileName] = useState('Drag Song Image Here');
    const [availableAlbums, setAvaliableAlbums] = useState([]);

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

    const sendable = songBinary&&artBinary&&artistIds!==""&&albumNames!==""&&songName!==""&&songDescription!=="";

    const send = async () => {
            if(sendable){
            const formData = new FormData();

            let albumIds = [];
            albumNames.forEach(albumNameFor => {
                availableAlbums.forEach(album => {
                    album.name == albumNameFor?
                    albumIds.push(album.id):
                    {}
                });
            });

            formData.append("albumId", albumIds || []);
            formData.append("song", new Blob([songBinary], { type: "audio/mpeg" }));
            formData.append("songArt", new Blob([artBinary], { type: "image/jpeg" }));
            formData.append("artistId", artistIds.filter(item => item !== "") || []);
            formData.append("name", songName);
            formData.append("description", songDescription);
            try {
                await fetch(`${import.meta.env.VITE_API_URL}/song/stream`, {
                    method: "POST",
                    body: formData
                });
            } catch (error) {
                flashErrMsg('Failed to Connect to Server');
                console.error(error);
            }
        }
    }

    useEffect(
        () => {
            async function fetchDescription() {
                try{
                    const response = await fetch(`http://localhost:5000/album/details`);
                    const dataArray = await response.json();
                    setAvaliableAlbums(dataArray);
                } catch (error){
                    console.log(error);
                }
            }
            fetchDescription();
        }, []
    )

    return (
        <div className={style.uploadPage}>
            <div className={style.uploadPageIn}>
                <h1>Upload Forms</h1>
                <input className={style.singleInput} value={songName} onChange={e => setSongName(e.target.value)} type='text' placeholder='Nome música'/>
                <input className={style.singleInput} value={songDescription} onChange={e => setSongDescription(e.target.value)} type='text' placeholder='Descrição música'/>
                <ValueInput selectionArray={[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]} title='Artist Id Type' type='number' state={[artistIds, setArtistIds]} />
                <ValueInput selectionArray={availableAlbums.map(e=>e.name)} title='Album Name' state={[albumNames, setAlbumNames]} />
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