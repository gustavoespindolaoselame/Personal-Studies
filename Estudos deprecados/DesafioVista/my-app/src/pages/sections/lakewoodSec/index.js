import Image from 'next/image'
import style from './style.module.css'
import Link from 'next/link'

export default function(){
    return (
        <section className={style.container}>
            <div className={style.text}>
                <h2 className={style.title1}>
                    THIS WEEK AT LAKEWOOD
                </h2>
                <hr/>
                <h1 className={style.title2}>
                    JOEL OSTEEN
                </h1>
                <p className={style.paragraph}>
                    In-Person or Online Sunday at 8:30 & 11am
                </p>
                <div>
                    <Link className={style.button} href='./schedule'>
                            Speaking Schedule
                    </Link>
                    <Link className={style.button} href='./experience'>
                            Experience Lakewood
                    </Link>
                </div>
            </div>
        </section>
    )
}