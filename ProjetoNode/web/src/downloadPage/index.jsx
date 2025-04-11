import style from './index.module.css';
import Card from '../card'

function downloadPage(props) {
    return (
        <div className={style.downloadPage}>
            <Card id='1'/>
            <Card id='2'/>
            <Card id='3'/>
            <Card id='4'/>
            <Card id='5'/>
            <Card id='6'/>
            <Card id='7'/>
            <Card id='8'/>
            <Card id='9'/>
            <Card id='10'/>
        </div>
    );
}

export default downloadPage;