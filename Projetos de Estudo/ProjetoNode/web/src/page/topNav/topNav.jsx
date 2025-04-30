import style from './topNav.module.css';


function topNav(props) {
    return (
        <div className={style.topNav}>
            <div className={style.topNavContainer}>
                {props.children}
            </div>
        </div>
    );
}

export default topNav;