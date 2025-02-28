import React, { useContext, useEffect } from 'react'
import PageTitle from '../../components/layout/PageTitle'


import DataContext from '../../data/DataContext'
import SectionTitle from '../../components/layout/SectionTitle'
import { AppContext } from '../../data/Store'


const UseContext = (props) => {

    const { getState, setState } = useContext(DataContext)

    const addNumber = delta =>{
        setState({
            ...getState,
            number: getState.number + delta
        })
    }

    const {number, setNumber, text, setText} = useContext(AppContext)

    useEffect(()=>{
        if(number > 1250){
            setText('Eita!')
        } else {
            setText('Context API + Hooks')
        }
        
    }, [number])

    return (
        <div className="UseContext">
            <PageTitle
                title="Hook UseContext"
                subtitle="Aceita um objeto de contexto e retorna o valor atual do contexto!"
            />
            <div className="center">
                <span className="text">
                    {getState.text}
                </span>
                <span className="text">
                    {getState.number}
                </span>
            </div>
            <div>
                <button className="btn" onClick={()=>addNumber(1)}>+1</button>
                <button className="btn" onClick={()=>addNumber(-1)}>-1</button>
            </div>
            <SectionTitle title="Exercício #02"/>
            <div className="center">
                <span className="text">{text}</span>
                <span className="text">{number}</span>
                <div>
                    <button className="btn" onClick={() => setNumber(number+1)}>+1</button>
                    <button className="btn" onClick={() => setNumber(number-1)}>-1</button>
                </div>
            </div>
        </div>
    )
}

export default UseContext
