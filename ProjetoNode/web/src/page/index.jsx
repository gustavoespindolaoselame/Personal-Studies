import style from './index.module.css';

function mainPage(props) {
    return (
        <div className={style.mainPage}>
            {props.children}
        </div>
    );
}

export default mainPage;