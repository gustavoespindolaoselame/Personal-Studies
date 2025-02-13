import React from 'react'

export default props => {
    return (
        <>
            <p className='ContadorItem' >Valor: </p>
            <h3>
                {props.numero}
            </h3>
        </>
    )
}