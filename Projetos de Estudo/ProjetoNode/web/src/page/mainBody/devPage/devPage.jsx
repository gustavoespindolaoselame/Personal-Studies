import style from './devPage.module.css';


const devPage = (props) => {
    async function dropDB(){
        try {
            const reset = await fetch(`${import.meta.env.VITE_API_URL}/reset`, {
                method: "GET"
            });
            console.log(await reset.json());
        } catch (error) {
            console.error(error);
        }
    }

    async function logDB(){
        try {
            const log = await fetch(`${import.meta.env.VITE_API_URL}/tables`, {
                method: "GET"
            });
            console.log(await log.json());
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <div className={style.devPage}>
            <button onClick={_ => dropDB()}>Drop DB</button>
            <button onClick={_ => logDB()}>Log DBs</button>
        </div>
    )
}

export default devPage;