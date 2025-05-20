import { useCallback, useEffect, useState } from 'react';
import style from './albumUploadPage.module.css';
import ValueInput from '../../../../elements/valueInput/valueInput'
import { useDropzone } from 'react-dropzone';
import { useFlashErrMsg } from '../../../../elements/messageBox/messageBox';

function AlbumUploadPage() {
    const [artistId, setArtistId] = useState([""]);
    const [songName, setSongName] = useState([""]);
    const [albumDescription, setAlbumDescription] = useState("");
    const [albumName, setAlbumName] = useState("");
    const [artBinary, setArtBinary] = useState();
    const [artFileName,setArtFileName] = useState("Drag Album Image Here");
    const [availableSongs, setAvaliableSongs] = useState([]);

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
            getRootProps: getArtRootProps,
            getInputProps: getArtInputProps,
            isDragActive: isArtDragActive
        } = useDropzone({ onDrop: onArtDrop, multiple: false });

    const flashErrMsg = useFlashErrMsg(' Failed to send files. ');

    const sendable = artistId!==""&&songName!==""&&albumDescription!==""&&artBinary&&artFileName;

    const appendFormData = (formData) => {
        formData.append("albumArt", 
            new Blob([artBinary], 
            { type: "image/jpeg" }));
        formData.append("artistId", 
            artistId.filter(item => item !== "") || []);
        formData.append("songId", 
            songNamesToSongIds());
        formData.append("name", 
            albumName);
        formData.append("description", 
            albumDescription);
        return formData;
    }

    const songNamesToSongIds = () => {
        songIds = [];
        songName.forEach(songNameFor => {
            availableSongs.forEach(song => {
                song.name == songNameFor?
                songIds.push(song.name):{}
            });
        });
        return songIds;
    }

    const send = async () => {
        if(sendable){
            const formData = appendFormData(new FormData());
            try {
                await fetch(`${import.meta.env.VITE_API_URL}/album/stream`, {
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
                    const response = await fetch(`http://localhost:5000/song/details`);
                    const dataArray = await response.json();
                    setAvaliableSongs(dataArray);
                } catch (error){
                    console.log(error);
                }
            }
            fetchDescription();
        }, []
    )

    return (
        <div className={style.uploadPage}>
            <h1>Upload Forms</h1>
            <ValueInput selectionArray={[]} title='Artist Id' type='number' state={[artistId, setArtistId]} />
            <ValueInput selectionArray={availableSongs.map(e=>e.name)} title='Song Id' type='text' state={[songName, setSongName]}/>
            <input className={style.singleInput} value={albumDescription} onChange={e => setAlbumDescription(e.target.value)} type='text' placeholder='Album Description'/>
            <input className={style.singleInput} value={albumName} onChange={e => setAlbumName(e.target.value)} type='text' placeholder='Album Name'/>
            <div {...getArtRootProps()} className={style.dropZone}>
                <input {...getArtInputProps()} />
                {isArtDragActive ? <p>Solte a imagem aqui...</p> : <p>{artFileName}</p>}
            </div>
            <button onClick={sendable ? send : flashErrMsg}>Send Files</button>
        </div>
    );
}

export default AlbumUploadPage;
