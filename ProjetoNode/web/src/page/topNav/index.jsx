import style from './index.module.css';


function topNav(props) {
    return (
        <div className={style.topNav}>
            {props.children}
        </div>
    );
}

export default topNav;