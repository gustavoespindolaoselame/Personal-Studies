import React from 'react'

export default props => {
    return (
        <div>
            <h4 className='ContadorItem' >Passo:</h4>
            <input type="number" className='ContadorItem' value={props.onPasso} onChange={props.onSetPasso}/>
        </div>
    )
}