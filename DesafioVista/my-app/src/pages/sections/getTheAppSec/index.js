import Image from 'next/image'
import style from './style.module.css'
import Link from 'next/link'

export default function(){
    return (
        <section className={style.container}>
            <h2>
                GET THE APP!
            </h2>
            <p>
            With the app from Lakewood, you can view live services, catch up on recent messages and learn more about upcoming events. Plus, you'll know who's speaking next week and can give without pulling out your wallet.
            </p>
            <Link className={style.appleButton} href='./apple'>Download on the App Store</Link>
        </section>
    )
}