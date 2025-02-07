import ReactDOM from 'react-dom'
import React from 'react'
import './index.css'

import Primeiro from './components/basicos/primeiro'
import { Banana } from './components/basicos/primeiro'

import ComParametro from './components/basicos/ComParametro'

ReactDOM.render(
    <div id="app">
        <Primeiro/>
        <Banana/>
        <ComParametro titulo="Segundo Componente" subtitulo="Terceiro Componente"/>
    </div>, 
    document.getElementById('root')
)