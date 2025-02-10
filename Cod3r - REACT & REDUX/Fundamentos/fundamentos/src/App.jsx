import React from 'react'
import Primeiro from './components/basicos/primeiro'
import { Banana } from './components/basicos/primeiro'
import ComParametro from './components/basicos/ComParametro'
import Fragmento from './components/basicos/Fragmento'

export default function(props){
    return (
    <div id="app">
        <Primeiro/>
        <Banana/>
        <ComParametro nome="Pedro" nota={9.3}/>
        <ComParametro nome="SlaQuemNãoPassou" nota={5.3}/>
        <Fragmento />
    </div>
    )
}