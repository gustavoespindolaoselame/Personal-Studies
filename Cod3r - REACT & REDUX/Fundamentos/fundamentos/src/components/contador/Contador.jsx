import React, { Component }  from 'react'

class Contador extends Component {

    state = {
        numero: this.props.numeroInicial || 0,
        passo: 1
    };

    inc = () => {
        this.setState({
            numero: this.state.numero + this.state.passo
        })
    }

    dec = () => {
        this.setState({
            numero: this.state.numero - this.state.passo
        })
    }

    setPasso = e => {
        this.setState({
            passo: parseInt(e.target.value)
        })
    }

    render(){
        return <div>
            <h2>Contador</h2>
            <p>Valor: {this.state.numero}</p>
            <button onClick={this.inc}>+</button>
            <button onClick={this.dec}>-</button>
            <input value={this.state.passo} onChange={this.setPasso}/>
        </div>
    }
}

export default Contador