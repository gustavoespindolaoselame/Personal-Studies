import React from 'react'
import "./Card.css"

export default props => {
    return (
    <div className="Card">
        <h2 className="Title">
            { props.titulo }
        </h2>
        <div className="Content">
            { props.children }
        </div>
    </div>
    )
};