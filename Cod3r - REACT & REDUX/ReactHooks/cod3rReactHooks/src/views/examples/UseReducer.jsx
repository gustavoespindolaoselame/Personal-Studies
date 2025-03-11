import React, { useReducer, useState } from 'react'
import PageTitle from '../../components/layout/PageTitle'
import reduceConfig from '../../store/config'

const UseReducer = (props) => {

    const [state, dispatch] = useReducer(reduceConfig.reducer, reduceConfig.initialState)
    const [loginName, setLoginName] = useState('null')
    const [nNumber, setNNumber] = useState(0)

    return (
        <div className="UseReducer">
            <PageTitle
                title="Hook UseReducer"
                subtitle="Uma outra forma de ter estado em componentes funcionais!"
            />
            <div className="center">
                <span className="text">
                    {state.number}
                </span>
                {state.user?<span className="text">
                    {state.user.name}
                </span> : <span className="text">offline</span>
                }
                
                <div>
                <button className="btn" onClick={reduceConfig.actions.number_add2(dispatch)}>+2</button>
                <button className="btn" onClick={()=>dispatch({type:'number_add4'})}>+4</button>
                <button className="btn" onClick={()=>dispatch({type:'number_multiplyby7'})}>*7</button>
                <button className="btn" onClick={()=>dispatch({type:'number_divideby25'})}>/25</button>
                <button className="btn" onClick={()=>dispatch({type:'number_parsetoint'})}>round</button>
                <button className="btn" onClick={()=>dispatch({type:'number_addn', payload: {number:nNumber}})}>addNTo</button>
                <input type='number' value={nNumber} onChange={e => setNNumber(parseFloat(e.target.value))}></input>

                <hr/>
                
                <button className="btn" onClick={reduceConfig.actions.login(dispatch,loginName)}>login</button>
                <input type='text' value={loginName} onChange={e => setLoginName(e.target.value)}></input>
                </div>
            </div>
        </div>
    )
}

export default UseReducer
