import Link from "next/link";
import Style from "./style.module.css"

export default function(){
    return (
        <nav>
            <div className={Style.menu}>
                <Link href='./'>
                    <img src={'./globe.svg'} style={{
                        width:'4vh'
                    }}/>
                </Link>
                <div>
                    <Link href='./config'>
                        <img src={'./file.svg'} style={{
                            width:'4vh'
                        }}/>
                    </Link>
                    <Link href='./search'>
                        <img src={'./globe.svg'} style={{
                            width:'4vh'
                        }}/>
                    </Link>
                    <Link href='./marketplace'>
                        <img src={'./file.svg'} style={{
                            width:'4vh'
                        }}/>
                    </Link>
                    <Link href='./selection'>
                        <img src={'./globe.svg'} style={{
                            width:'4vh'
                        }}/>
                    </Link>
                </div>
            </div>
        </nav>
    )
}