import Image from 'next/image'
import style from './style.module.css'
import Link from 'next/link'

export default function(){
    return (
        <section className={style.container}>
            <div className={style.text}>
                <h2 className={style.title1}>
                    LATEST MESSAGE
                </h2>
                <p className={style.paragraph}>
                    What happened to you did not stop your purpose. Mistakes you've made did not cancel your assignment.
                    There is stil a beautiful life of blessing, fulfillment, abundance that belongs to you.
                </p>
                <hr/>
                <h1 className={style.title2}>
                    Getting Unstuck
                </h1>
                <p className={style.paragraph}>
                    Sunday, Mar 16, 2025
                </p>
                <div className={style.Links}>
                    <Link className={style.button} href='./schedule'>
                            Watch Now
                    </Link>
                    <Link className={style.button} href='./experience'>
                            View All Messages
                    </Link>
                </div>
            </div>
        </section>
    )
}