import style from './index.module.css';


const devPage = (props) => {
    async function dropDB(){
        try {
            const reset = await fetch("http://localhost:5000/reset", {
                method: "GET"
            });
            console.log(await reset.json());
        } catch (error) {
            console.error(error);
        }
    }

    async function logDB(){
        try {
            const log = await fetch("http://localhost:5000/tables", {
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