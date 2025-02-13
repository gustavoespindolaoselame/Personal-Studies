import React from 'react'
import './Style.css'

export default props => {
    return (
        <div>
            <p className='DesafioItens'>Número de Resultados</p>
            <input type='number' value={props.onNumParams} onChange={props.onSetNumParams}/>
            <p className='DesafioItens'>Valor Mínimo</p>
            <input type='number' value={props.onMinParams} onChange={props.onSetMinParams}/>
            <p className='DesafioItens'>Valor Máximo</p>
            <input type='number' value={props.onMaxParams} onChange={props.onSetMaxParams}/>
        </div>
    )
}