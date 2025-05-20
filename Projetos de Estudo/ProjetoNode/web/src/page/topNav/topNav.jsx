import style from './topNav.module.css';
import Dropdown from '../../elements/dropdown/dropdown';

function topNav(props) {
    return (
        <div className={style.topNav}>
            <Dropdown/>
        </div>
    );
}

export default topNav;