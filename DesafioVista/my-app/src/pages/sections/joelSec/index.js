import Image from 'next/image'
import style from './style.module.css'
import Link from 'next/link'

export default function(){
    return (
        <section className={style.container}>
            <div className={style.img}>
                <img src={'./joelVictoria.png'} alt="ImgErr" />
            </div>
            <div className={style.text}>
                <h2 className={style.title}>
                JOEL & VICTORIA OSTEEN
                </h2>
                <p className={style.paragraph}>
                At Lakewood, we believe your best days are still out in front of you. Whether you are joining us in person or online, we invite you to experience our services and be a part of the Lakewood family. The Bible says when you are planted in the house of the Lord, you will flourish. Get ready to step into a new level of your destiny!
                </p>
                <div className={style.buttons}>
                    <Link className={style.button} href='./lakewood-experience'>
                            Welcome to Lakewood
                    </Link>
                    <Link className={style.button} href='./new-here?'>
                            New Here?
                    </Link>
                </div>
            </div>
        </section>
    )
}