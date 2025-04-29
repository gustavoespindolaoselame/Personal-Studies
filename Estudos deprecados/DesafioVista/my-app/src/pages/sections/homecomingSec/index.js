import Image from 'next/image'
import style from './style.module.css'
import Link from 'next/link'

export default function(){
    return (
        <section className={style.container}>
            <div className={style.img}>
                <img src={'./homecoming.png'} alt="ImgErr" />
            </div>
            <div className={style.text}>
                <h2 className={style.title}>
                Homecoming Weekend

                </h2>
                <p className={style.paragraph}>
                Saturday–Sunday, March 29th–30th (In-Person)                
                </p>
                <p className={style.paragraphSmall}>
                Come join us for an unforgettable weekend together. RSVP today!      
                </p>
                <div>
                    <Link className={style.button} href='./homecoming/learnMore'>
                        Learn More
                    </Link>
                </div>
            </div>
        </section>
    )
}