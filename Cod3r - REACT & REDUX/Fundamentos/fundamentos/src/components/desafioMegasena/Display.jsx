import React, { useState } from 'react'
import ParamForms from './ParamForms'
import Results from './Results'
import Generate from './StartButton'
import logica from './Logica'


export default props => {
    let [results, setResults] =  useState(0);

    const params = {
        numParams: useState(0),
        numMin: useState(0),
        numMax: useState(0)
    }

    const runMega = () =>{
        setResults(logica(
            +params.numParams[0],
            +params.numMin[0],
            +params.numMax[0]
        ))
    }

    return (
        <div>
            <h1>MEGASENA</h1>
            <ParamForms 
            onNumParams={params.numParams[0]} 
            onSetNumParams={e => params.numParams[1](e.target.value)}
            onMinParams={params.numMin[0]} 
            onSetMinParams={e => params.numMin[1](e.target.value)}
            onMaxParams={params.numMax[0]} 
            onSetMaxParams={e => params.numMax[1](e.target.value)}
            />
            <Generate onRunMega={runMega}/>
            <Results onResults={results}/>
        </div>
    )
}