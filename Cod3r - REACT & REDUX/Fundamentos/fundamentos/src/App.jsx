import React from 'react'
import Primeiro from './components/basicos/primeiro'
import { Banana } from './components/basicos/primeiro'
import ComParametro from './components/basicos/ComParametro'
import Fragmento from './components/basicos/Fragmento'
import DesafioRandom from './components/basicos/DesafioRandom'
import Card from './components/layout/Card'
import './App.css'

export default _ => 
    <div className="App">
        <div className="Cards">
            <Card titulo="Primeiro">
                <Primeiro/>
            </Card> 
            <Card titulo="Banana">
                <Banana/>
            </Card> 
            <Card titulo="ComParametro">
                <ComParametro nome="Pedro" nota={9.3}/>
            </Card> 
            <Card titulo="ComParametro 2">
                <ComParametro nome="SlaQuemNãoPassou" nota={5.3}/>
            </Card> 
            <Card titulo="Fragmento">
                <Fragmento />
            </Card> 
            <Card titulo="Desafio Aleatório">
                <DesafioRandom min={10} max={60}/>
            </Card> 
        </div>
    </div>;