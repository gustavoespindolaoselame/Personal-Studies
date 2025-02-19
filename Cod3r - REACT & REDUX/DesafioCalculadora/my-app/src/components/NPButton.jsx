import React from 'react'
import '../Styles.css'

export default props =>{
    return (
        <button class='NPButton' onClick=
        {() => props.action(props.num)}
        >
            {props.num}
        </button>
    )
}