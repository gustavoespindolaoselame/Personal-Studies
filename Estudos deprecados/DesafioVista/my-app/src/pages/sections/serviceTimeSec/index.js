import style from './style.module.css'
import Link from 'next/link'

export default function(){
    return (
        <section className={style.container}>
            <div className={style.topSection}>
                <h2>
                    GIVING HOPE TO THE WORLD
                </h2>
                <Link href='./schedule'>
                SEE FULL SCHEDULE &gt;
                </Link>
            </div>
            <hr/>
            <div className={style.botSection}>
                <div className={style.botSectionQuadrants}>
                    <h3>Wednesday, Mar 19, 2025</h3>
                    <p>7:30 PM ONLINE SERVICE</p>
                </div>
                <div className={style.botSectionQuadrants}>
                    <h3>Thursday, Mar 20, 2025</h3>
                    <p>7:30 PM ONLINE SERVICE (EN ESPAÑOL)</p>
                </div>
                <div className={style.botSectionQuadrants}>
                    <h3>SUNDAY, Mar 23, 2025</h3>
                    <p>8:30 AM IN-PERSON & ONLINE SERVICE</p>
                    <p>11:00 AM IN-PERSON & ONLINE SERVICE</p>
                    <p>2:00 PM IN-PERSON & ONLINE SERVICE</p>
                </div>
            </div>
        </section>
    )
}