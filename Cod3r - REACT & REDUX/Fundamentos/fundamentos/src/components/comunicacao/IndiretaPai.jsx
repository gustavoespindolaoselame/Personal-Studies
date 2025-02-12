import React, { useState } from 'react'
import IndiretaFilho from './IndiretaFilho'

export default props => {
    const [nome, setNome]= useState('null');
    const [idade, setIdade] =  useState(0);
    const [nerd, setNerd] = useState(false);
    function fornecerInformações(nomeParam, idadeParam, nerdParam){
        setNome(nomeParam);
        setIdade(idadeParam);
        setNerd(nerdParam);
    }
    return (
        <div>
            <div>
                <span>{nome}<br/></span>
                <span>{idade}<br/></span>
                <span>{nerd?'Verdadeiro':'Falso'}<br/></span>
            </div>
            <IndiretaFilho quandoClicar={fornecerInformações}/>
        </div>
    )
}