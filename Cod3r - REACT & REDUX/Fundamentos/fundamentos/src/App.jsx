import React from 'react'
import Primeiro from './components/basicos/primeiro'
import { Banana } from './components/basicos/primeiro'
import ComParametro from './components/basicos/ComParametro'
import Fragmento from './components/basicos/Fragmento'
import DesafioRandom from './components/basicos/DesafioRandom'
import Card from './components/layout/Card'
import Familia from './components/basicos/Familia'
import FamiliaMembro from './components/basicos/FamiliaMembro'
import ListaAlunos from './components/repeticao/ListaAlunos'
import DesafioProduto from './components/repeticao/DesafioProduto'
import './App.css'

export default _ => 
    <div className="App">
        <div className="Cards">
            <Card titulo="DesafioRepeticao" color ="#336060">
                <DesafioProduto/>
            </Card> 
            <Card titulo="Repeticao" color ="#360603">
                <ListaAlunos/>
            </Card> 
            <Card titulo="Componentes com Filhos" color="#606033">
                <Familia sobrenome="Ferreira">
                    <FamiliaMembro nome="Lucas"/>
                    <FamiliaMembro nome="Gabriel"/>
                    <FamiliaMembro nome="Mateus"/>
                </Familia>
            </Card>
            <Card titulo="Primeiro" color ="#090">
                <Primeiro/>
            </Card> 
            <Card titulo="Banana" color ="#900">
                <Banana/>
            </Card> 
            <Card titulo="ComParametro" color ="#009">
                <ComParametro nome="Pedro" nota={9.3}/>
            </Card> 
            <Card titulo="ComParametro 2" color ="#363">
                <ComParametro nome="SlaQuemNãoPassou" nota={5.3}/>
            </Card> 
            <Card titulo="Fragmento" color ="#633">
                <Fragmento />
            </Card> 
            <Card titulo="Desafio Aleatório "color ="#336">
                <DesafioRandom min={10} max={60}/>
            </Card> 
        </div>
    </div>;