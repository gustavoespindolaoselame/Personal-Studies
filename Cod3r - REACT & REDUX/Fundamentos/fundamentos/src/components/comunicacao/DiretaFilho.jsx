import React from 'react'

export default props => {
    return (
        <div>
            <div> { props.texto } </div>
            <div> { props.idade } </div>
            <div> { props.nerd ? 'Nerd' : 'Não Nerd'} </div>
        </div>
    )
}