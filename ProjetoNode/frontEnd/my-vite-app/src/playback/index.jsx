import style from './index.module.css';

function Playback(props = 1) {
  return (
    <audio controls key={props.id}>
        <source src={`http://localhost:3007/song?id=${props.id}`} type="audio/mp3" />
        Your browser does not support the audio element.
    </audio>
  );
}

export default Playback;