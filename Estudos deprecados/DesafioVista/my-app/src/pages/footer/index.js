import Link from 'next/link'
import Style from './style.module.css'

export default function(){
    return (
        <footer className={Style.footer}>
            <div className={Style.container}>
                <div className={Style.column}>
                    <div className={Style.logo}>
                        <h2>Lakewood</h2>
                        <h3>Church</h3>
                    </div>
                </div>
                <div className={Style.column}>
                    <h4>WATCH</h4>
                    <p>LIVE STREAM</p>

                    <h4>VISIT</h4>
                    <p>LAKEWOOD EXPERIENCE</p>
                    <p>LOCATION/DIRECTIONS</p>
                    <p>Time/SPEAKING SCHEDULE</p>
                </div>
                <div className={Style.column}>
                    <h4>CONNECT</h4>
                    <p>GIVE</p>
                    <p>MISSIONS</p>

                    <h4>LWC APP</h4>
                    <p>APPLE</p>
                    <p>ANDROID</p>

                </div>
                <div className={Style.column}>
                    <h4>GROW</h4>
                    <p>NEW BEGINNINGS</p>
                    <p>KIDSLIFE</p>
                    <p>MARRIAGE</p>
                    <p>YOUTH</p>
                    <p>YOUNG ADULTS</p>
                    <p>CLASSES AND EVENTS</p>
                    <p>ESPAÑOL</p>
                </div>
                <div className={Style.column}>
                    <h4>CARE</h4>

                    <h4>STORE</h4>
                    <p>MY ACCOUNT</p>
                    <p>SHOPPING CART</p>

                </div>
                <div className={Style.column}>
                    <h4>ABOUT LAKEWOOD</h4>
                    <p>OUR HISTORY</p>
                    <p>CONTACT US</p>
                    <p>TELEVISION LISTINGS</p>
                    <p>PRIVACY POLICY</p>
                    <p>TERMS OF USE</p>
                    <p>CAREERS</p>

                </div>
            </div>
            <div className={Style.fullBottom}>
                <Link className={Style.Link} href='youtube.com'>Youtube</Link>
                <Link className={Style.Link} href='facebook.com'>Facebook</Link>
                <Link className={Style.Link} href='x.com'>Twitter</Link>
                <Link className={Style.Link} href='instagram.com'>Instagram</Link>
            </div>
        </footer>
    )
}