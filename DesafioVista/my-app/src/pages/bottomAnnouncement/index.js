import { useEffect, useState } from 'react'
import Style from './style.module.css'

export default function(){
    const [date, setDate] = useState([])

    useEffect(()=>{
        setInterval(() => {
            let dateClass = new Date();
            setDate([dateClass.getUTCFullYear(), dateClass.getMonth(), dateClass.getDay(), dateClass.getHours(), dateClass.getMinutes(), dateClass.getSeconds()]) 
        }, 1000);
    }, [])

    return (
        <div className={Style.announcement}>
            <span>
            Next Live Service Begins in: {739082-date[0]*365+date[1]*30+date[2]} days, {24 - date[3]} hours, {60 - date[4]} mins, {60 - date[5]} secs
            </span>
            </div>
    )
}