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
import ParOuImpar from './components/condicional/ParOuImpar'
import UsuarioInfo from './components/condicional/UsuarioInfo'
import DiretaPai from './components/comunicacao/DiretaPai'
import IndiretaPai from './components/comunicacao/IndiretaPai'
import Input from './components/formulario/Input'
import Contador from './components/contador/Contador'

import './App.css'

export default _ => 
    <div className="App">
        <div className="Cards">
        <Card titulo="Contador" color ="#f63003">
                <Contador numeroInicial={10} passo={5}/>
            </Card> 
            <Card titulo="Componente Controlado" color ="#63003f">
                <Input/>
            </Card> 
            <Card titulo="Comunicação Indireta" color ="#3003f6">
                <IndiretaPai/>
            </Card> 
            <Card titulo="Comunicação Direta" color ="#003f63">
                <DiretaPai/>
            </Card> 
            <Card titulo="Renderização Condicional" color ="#033606">
                <ParOuImpar numero={20}/>
                <UsuarioInfo usuario={{nome: 'Fernando'}}/>
                <UsuarioInfo usuario={{email: 'Fernando'}}/>
            </Card> 
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