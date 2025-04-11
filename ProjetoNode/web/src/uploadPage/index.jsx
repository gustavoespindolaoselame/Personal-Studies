import { useState } from 'react';
import style from './index.module.css';
import {useDropzone} from 'react-dropzone'
import { useCallback } from 'react';


// "INSERT INTO songStreams (song) VALUES (?); 
// insert into songDetails (artistId, albumId, name, descrip) values (?,?,?,?);"

function uploadPage(props) {

    const [artistId, setArtistId] = useState();
    const [albumId, setAlbumId] = useState();
    const [songName, setSongName] = useState();
    const [songDescription, setSongDescription] = useState();
    const [songBinary, setSongBinary] = useState();

    const onDrop = useCallback(acceptedFiles => {
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
      
    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop, multiple: false})
    
    const send = async () => {
        const formData = new FormData();
        formData.append("song", new Blob([songBinary], { type: "audio/mpeg" }));
        formData.append("artistId", artistId || 0);
        formData.append("albumId", albumId || 0);
        formData.append("name", songName);
        formData.append("description", songDescription);
    
        try {
            console.log(formData)
            const response = await fetch("http://localhost:5000/song", {
                method: "POST",
                body: formData
            });
            const data = await response.json();
            console.log(data);
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <div className={style.uploadPage}>
            Upload forms
            <input value={artistId} onChange={e => {setArtistId(e.target.value)}} type='number' placeholder='Id Artista'/>
            <input value={albumId} onChange={e => setAlbumId(e.target.value)} type='number' placeholder='Id Album'/>
            <input value={songName} onChange={e => setSongName(e.target.value)} type='text' placeholder='Nome música'/>
            <input value={songDescription} onChange={e => setSongDescription(e.target.value)} type='text' placeholder='Descrição música'/>

            <div {...getRootProps()} className={style.dropZone}>
                <input {...getInputProps()} />
                {
                    isDragActive ?
                    <p>Drop the files here ...</p> :
                    <p>Drag 'n' drop some files here, or click to select files</p>
                }
            </div>
            <button onClick={send}>Send Files</button>
        </div>
    );
}

export default uploadPage;