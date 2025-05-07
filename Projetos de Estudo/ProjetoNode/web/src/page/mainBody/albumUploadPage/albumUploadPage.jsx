import { useCallback, useState } from 'react';
import style from './albumUploadPage.module.css';
import ValueInput from '../../../elements/valueInput/valueInput'
import { useDropzone } from 'react-dropzone';
import { useFlashErrMsg } from '../../messageBox/messageBox';

function AlbumUploadPage() {
    
    const [artistId, setArtistId] = useState([""]);
    const [songId, setSongId] = useState([""]);
    const [albumDescription, setAlbumDescription] = useState("");
    const [albumName, setAlbumName] = useState("");
    const [artBinary, setArtBinary] = useState();
    const [artFileName,setArtFileName] = useState("Drag Album Image Here");

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

    const sendable = artistId!==""&&songId!==""&&albumDescription!==""&&artBinary&&artFileName;

    const send = async () => {
        
        if(sendable){
            const formData = new FormData();
            formData.append("albumArt", new Blob([artBinary], { type: "image/jpeg" }));
            formData.append("artistId", artistId.filter(item => item !== "") || []);
            formData.append("songId", songId.filter(item => item !== "") || []);
            formData.append("name", albumName);
            formData.append("description", albumDescription);
            try {
                await fetch(`${import.meta.env.VITE_API_URL}/album`, {
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
            <ValueInput title='Artist Id' type='number' state={[artistId, setArtistId]} />
            <ValueInput title='Song Id' type='number' state={[songId, setSongId]}/>
            <input value={albumDescription} onChange={e => setAlbumDescription(e.target.value)} type='text' placeholder='Album Description'/>
            <input value={albumName} onChange={e => setAlbumName(e.target.value)} type='text' placeholder='Album Name'/>
            <div {...getArtRootProps()} className={style.dropZone}>
                <input {...getArtInputProps()} />
                {isArtDragActive ? <p>Solte a imagem aqui...</p> : <p>{artFileName}</p>}
            </div>
            <button onClick={sendable ? send : flashErrMsg}>Send Files</button>
        </div>
    );
}

export default AlbumUploadPage;
