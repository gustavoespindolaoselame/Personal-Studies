import Style from './style.module.css'

export default function(props){
    return (
        <div className={Style.card}>
            {props.img ? props.img : 'nada'}
            {props.title ? props.title : 'nada'}
            {props.text ? props.text : 'nada'}
            {props.learnMore ? props.learnMore : 'nada'}
        </div>
    )
}