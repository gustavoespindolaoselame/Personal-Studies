import React from 'react'

export default props => {
    return (
        <div>
            <button className='ContadorItem' onClick={props.onInc}>+</button>
            <button className='ContadorItem' onClick={props.onDec}>-</button>
        </div>
    )
}