import React, { useState } from 'react'
import PageTitle from '../../components/layout/PageTitle'
import SectionTitle from '../../components/layout/SectionTitle'

const UseState = (props) => {
    const [ getCount , setCount] = useState( 0 )
    const [ getAdd , setAdd] = useState( 1 )

    const [ getName, setName] = useState('input')

    return (
        <div className="UseState">
            <PageTitle
                title="Hook UseState"
                subtitle="Estado em componentes funcionais!"
            />
            <SectionTitle title="Exercício #01" />
            <div className="center">
                <span className='text'>{getCount}</span>
                <button className="btn" onClick={() => setCount(getCount+getAdd)}>+{getAdd}</button>
                <button className="btn" onClick={() => setCount(getCount-getAdd)}>-{getAdd}</button>
                <input value={getAdd} onChange={e=>setAdd(parseFloat(e.target.value))}></input>
            </div>
            <SectionTitle title="Exercício #02" />
            <input type="text" className="input" value={ getName } onChange={e => setName(e.target.value)}/>
        </div>
    )
}

export default UseState
