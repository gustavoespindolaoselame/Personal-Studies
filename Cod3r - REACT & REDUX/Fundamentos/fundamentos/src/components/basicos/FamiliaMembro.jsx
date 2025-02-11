import React from 'react'

export default props => {
    return (
        <div>
            <span>
                { props.nome + " "}
            </span>
            <strong>
                { props.sobrenome }
            </strong>
        </div>
    )
}