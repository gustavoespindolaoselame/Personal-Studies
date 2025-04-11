import style from './index.module.css';


function topNav(props) {
    return (
        <div className={style.topNav}>
            <a href="/download">Download</a>
            <a href="/upload">Upload</a>
        </div>
    );
}

export default topNav;