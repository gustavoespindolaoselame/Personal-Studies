import React, { useEffect, useState } from 'react'
import PageTitle from '../../components/layout/PageTitle'
import SectionTitle from '../../components/layout/SectionTitle'

function calcFatorial(num){
    const n = parseFloat(num) || 0
    if(n<0){ 
        return NaN 
    }
    if(n == 0) { 
        return 1 
    }
    if(n>10000) {
        return 'infinity'
    }
    return (calcFatorial (n - 1 ) * n)
}

const UseEffect = (props) => {
    const [ getCount , setCount] = useState( 1 )
    const [getFatorial, setFatorial] = useState( 1 )

    const [ getCountPouI , setCountPouI] = useState( 0 )
    const [ getPouI , sePouI] = useState( 'Par' )

    useEffect(function(){
        setFatorial(calcFatorial(getCount))
    }, [getCount])

    useEffect(function(){
        sePouI((getCountPouI % 2 == 0) ? 'Par ' : 'Impar')
    }, [getCountPouI])

    return (
        <div className="UseEffect">
            <PageTitle
                title="Hook UseEffect"
                subtitle="Permite executar efeitos colaterais em componentes funcionais!"
            />
            <SectionTitle title="Exercício #01" />
            <div className="center">
                <span className="text">Fatorial:</span>
                <span className="text red">{getFatorial}</span>
                <input 
                    value={getCount} 
                    type="number" 
                    className="input" 
                    onChange={e => setCount(e.target.value)}/>
                </div>
            <SectionTitle title="Exercício #02 - Desafio" />
            <div className="center">
                <span className="text">{getPouI}</span>
                <input 
                    value={getCountPouI} 
                    type="number" 
                    className="input" 
                    onChange={e => setCountPouI(e.target.value)}/>
            </div>
        </div>
    )
}

export default UseEffect
