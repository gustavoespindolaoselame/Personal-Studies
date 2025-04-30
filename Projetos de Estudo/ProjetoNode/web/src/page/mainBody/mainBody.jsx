import style from './mainBody.module.css';

function mainBody(props) {
    return (
        <div className={style.mainBody}>
            {props.children}
        </div>
    );
}

export default mainBody;