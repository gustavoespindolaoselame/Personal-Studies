import Link from 'next/link'
import Style from './style.module.css'

export default function(props){
    return (
        <div className={Style.card}>
            {props.img ?<img src={props.img} alt="ImgErr" style={{height:'22vw'}}/>: 'nada'}
            <div className={Style.bottomSection}>
                <div>
                    {props.title ? <h2>{props.title}</h2> : 'nada'}
                    {props.text ? <p>{props.text}</p> : 'nada'}
                </div>
                {props.learnMore ? <Link href={props.learnMoreLink ? props.learnMoreLink : './404'}>{props.learnMore}</Link> : 'nada'}
            </div>
        </div>
    )
}