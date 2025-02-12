import React from 'react'
import DiretaFilho from './DiretaFilho'

export default props => {
    return (
        <div>
            <DiretaFilho texto="Junior" idade={20} nerd={true}/>
            <DiretaFilho texto="Gabriel" idade={18} nerd={false}/>
        </div>
    )
}