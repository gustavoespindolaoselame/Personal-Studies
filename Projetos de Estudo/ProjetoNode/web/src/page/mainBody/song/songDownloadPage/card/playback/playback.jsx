import { useEffect, useState } from 'react';
import style from './playback.module.css';

function Playback({ id }) {

  const [url, setUrl] = useState(null);

  useEffect(() => {
    async function fetchSource() {
      try {
        const response = await fetch(`http://localhost:5000/song/stream?id=${id}`);
        const blob = await response.blob();
        const objectUrl = URL.createObjectURL(blob);
        setUrl(objectUrl);
      } catch (error) {
        console.error('Error fetching audio:', error);
      }
    }
  
    fetchSource();
  
    return () => {
      if (url) {
        URL.revokeObjectURL(url);
      }
    };
  }, [id]);
  
  return (
    <audio controls key={id} className={style.audioPlayer}>
      {url ? (
        <source src={url} type="audio/mpeg" />
      ) : (
        <p>Loading audio...</p>
      )}
      Your browser does not support the audio element.
    </audio>
  );
}

export default Playback;