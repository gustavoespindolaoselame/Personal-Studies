import React from 'react'

import { useParams } from 'react-router-dom'

const Param = props => {
    const { id } = useParams()
    return (
        <aside className='Param'>
            <h1>Componente Param</h1>
            <p>Valor: {id }</p>
        </aside>
    )
}

export default Param;