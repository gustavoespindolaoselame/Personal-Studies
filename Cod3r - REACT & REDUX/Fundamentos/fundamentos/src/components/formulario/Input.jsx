~]import React, { useState } from 'react'
import "./input.css"

export default props => {

    const [valor, setValor] = useState('Inicial');

    const quandoMudar = e => setValor(e.target.value)

    return (
        <div className='Input'>
            <h2>{valor}</h2>
            <div style={{
                display: 'flex',
                flexDirection: 'column'
            }}>
            <input value={valor} onChange={quandoMudar}/>
            <input value={valor} readOnly />
            <input value={undefined}/>
            </div>
        </div>
    )
}