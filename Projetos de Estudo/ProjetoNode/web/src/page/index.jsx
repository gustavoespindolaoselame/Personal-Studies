import style from './index.module.css';
import {ErrMsgComponent} from './messageBox'

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