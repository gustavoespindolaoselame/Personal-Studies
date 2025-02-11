import React from 'react'
import "./Card.css"

export default props => {
    const { color, titulo ,children} = props
    const estilo = {
        backgroundColor: color|| '#F00',
        borderColor: color|| '#F00'
    }
    return (
    <div className="Card" style={estilo}>
        <h2 className="Title">
            { titulo }
        </h2>
        <div className="Content">
            { children }
        </div>
    </div>
    )
};