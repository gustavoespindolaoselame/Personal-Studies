import { useEffect, useState } from "react";
import style from './imgComponent.module.css';

function ImageComponent({ id }) {
const [imageUrl, setImageUrl] = useState(null);

useEffect(() => {
    async function fetchSource() {
      try {
        const response = await fetch(`http://localhost:5000/album/art?id=${id}`);
        const blob = await response.blob();
        const objectUrl = URL.createObjectURL(blob);
        setImageUrl(objectUrl);
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


return <img src={imageUrl} alt="Fetched from API"/>;
}

export default ImageComponent;