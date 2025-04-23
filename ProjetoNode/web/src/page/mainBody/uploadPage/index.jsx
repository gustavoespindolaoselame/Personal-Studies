import { useState } from 'react';
import style from './index.module.css';
import {useDropzone} from 'react-dropzone'
import { useCallback } from 'react';

function uploadPage() {

    const [artistId, setArtistId] = useState();
    const [albumId, setAlbumId] = useState();
    const [songName, setSongName] = useState();
    const [songDescription, setSongDescription] = useState();
    const [songBinary, setSongBinary] = useState();
    const [artBinary, setArtBinary] = useState();


    const onSongDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];
        const reader = new FileReader();
    
        reader.onload = () => {
            const arrayBuffer = reader.result;
            setSongBinary(arrayBuffer); // agora sim!
            console.log("Arquivo carregado com sucesso!");
        };
    
        reader.onerror = () => console.log('Erro ao ler o arquivo');
        reader.onabort = () => console.log('Leitura do arquivo abortada');
    
        reader.readAsArrayBuffer(file); // deve ser chamado aqui!
    }, []);

    const onArtDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];
        const reader = new FileReader();
    
        reader.onload = () => {
            const arrayBuffer = reader.result;
            setArtBinary(arrayBuffer);
            console.log("Imagem carregada com sucesso!");
        };
    
        reader.onerror = () => console.log('Erro ao ler a imagem');
        reader.onabort = () => console.log('Leitura da imagem abortada');
    
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

    
    const send = async () => {
        const formData = new FormData();
        formData.append("song", new Blob([songBinary], { type: "audio/mpeg" }));
        formData.append("songArt", new Blob([artBinary], { type: "image/jpeg" }));
        formData.append("artistId", artistId || 0);
        formData.append("albumId", albumId || 0);
        formData.append("name", songName);
        formData.append("description", songDescription);
        try {
            await fetch("http://localhost:5000/song", {
                method: "POST",
                body: formData
            });
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <div className={style.uploadPage}>
            <div className={style.uploadPageIn}>
                Upload forms
                <input value={artistId} onChange={e => {setArtistId(e.target.value)}} type='number' placeholder='Id Artista'/>
                <input value={albumId} onChange={e => setAlbumId(e.target.value)} type='number' placeholder='Id Album'/>
                <input value={songName} onChange={e => setSongName(e.target.value)} type='text' placeholder='Nome música'/>
                <input value={songDescription} onChange={e => setSongDescription(e.target.value)} type='text' placeholder='Descrição música'/>
                <div {...getSongRootProps()} className={style.dropZone}>
                    <input {...getSongInputProps()} />
                    {isSongDragActive ? <p>Solte a música aqui...</p> : <p>Arraste a música ou clique aqui</p>}
                </div>
                <div {...getArtRootProps()} className={style.dropZone}>
                    <input {...getArtInputProps()} />
                    {isArtDragActive ? <p>Solte a imagem aqui...</p> : <p>Arraste a imagem de capa ou clique aqui</p>}
                </div>
                <button onClick={send}>Send Files</button>
            </div>
        </div>
    );
}

export default uploadPage;