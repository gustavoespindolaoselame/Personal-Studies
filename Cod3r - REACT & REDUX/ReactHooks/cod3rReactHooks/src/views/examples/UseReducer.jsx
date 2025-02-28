import React, { useReducer, useState } from 'react'
import PageTitle from '../../components/layout/PageTitle'

const initialState = {
    cart:[],
    products:[{},{}],
    user:null,
    //foco ...
    number:0
}

const reducer = (state,action) => {
    switch(action.type){
        case 'number_add2':
            return {...state, number:state.number + 2 }
        case 'number_multiplyby7':
            return {...state, number:state.number * 7 }
        case 'number_divideby25':
            return {...state, number:state.number /25 }
        case 'number_parsetoint':
            return {...state, number:parseInt(state.number)}
        case 'number_add4':
            return {...state, number:state.number + 4 }
        case 'number_addn':
            return {...state, number:state.number + action.payload.number}
        case 'login':
            return {...state, user: { name: action.payload.name}}
        default:
            return state;
    }
}

const UseReducer = (props) => {

    const [state, dispatch] = useReducer(reducer, initialState)
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
                <button className="btn" onClick={()=>dispatch({type:'number_add2'})}>+2</button>
                <button className="btn" onClick={()=>dispatch({type:'number_add4'})}>+4</button>
                <button className="btn" onClick={()=>dispatch({type:'number_multiplyby7'})}>*7</button>
                <button className="btn" onClick={()=>dispatch({type:'number_divideby25'})}>/25</button>
                <button className="btn" onClick={()=>dispatch({type:'number_parsetoint'})}>round</button>
                <button className="btn" onClick={()=>dispatch({type:'number_addn', payload: {number:nNumber}})}>addNTo</button>
                <input type='number' value={nNumber} onChange={e => setNNumber(parseFloat(e.target.value))}></input>

                <hr/>
                
                <button className="btn" onClick={()=>dispatch({type:'login', payload: {name:loginName}})}>login</button>
                <input type='text' value={loginName} onChange={e => setLoginName(e.target.value)}></input>
                </div>
            </div>
        </div>
    )
}

export default UseReducer
