import style from './page.module.css';
import {ErrMsgComponent} from '../elements/messageBox/messageBox'

function mainPage(props) {
    return (
        <div>
            <div>
                <ErrMsgComponent/>
            </div>
            <div className={style.mainPage}>
                {props.children}
            </div>
        </div>
    );
}

export default mainPage;