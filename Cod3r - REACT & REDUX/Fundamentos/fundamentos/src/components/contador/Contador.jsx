import React, { Component }  from 'react'
import Display from './Display';
import './Style.css'
import Botoes from './Botoes';
import PassoForm from './PassoForm';

class Contador extends Component {

    state = {
        numero: this.props.numeroInicial || 0,
        passo: 1
    };

    inc = () => {
        return this.setState({
            numero: this.state.numero + this.state.passo
        })
    }

    dec = () => {
        return this.setState({
            numero: this.state.numero - this.state.passo
        })
    }

    setPasso = (novoPasso) => {
        return this.setState({
            passo: parseInt(novoPasso.target.value)
        })
    }

    render(){
        return (
        <div className='Contador'>
            <h2 className='ContadorTitulo'>Contador</h2>
            <Display className='ContadorItem' numero={this.state.numero}/>
            <Botoes className='ContadorItem' onInc={this.inc} onDec={this.dec}/>
            <PassoForm onPasso={this.state.passo} onSetPasso={this.setPasso}/>
        </div>
        )
    }
}

export default Contador