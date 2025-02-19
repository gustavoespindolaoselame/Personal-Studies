import React, { useState } from 'react'
import NPButton from './components/NPButton'
import NPScreen from './components/NPScreen'
import Logic from './logic'

import './Styles.css'

export default _ => {
    const [screenValueString, setScreenValueString] = useState('0');
    const operations = ['/','*','-','+']
    const updateScreenValue = screenString => {
        setScreenValueString(screenString)
    }

    const checkedUpdateScreenValue = appendedString => {
        operations.forEach(operation => {
            if (screenValueString.endsWith(operation) && appendedString === operation) {
                appendedString = '';
            }
        });
        let finalString = screenValueString + appendedString;
        if(finalString.startsWith('0')){
            finalString = finalString.slice(1);
        }
        updateScreenValue(finalString);
    }

    const runEquation = _ => {Logic(screenValueString, updateScreenValue);}

    return (
        <div id='container'>
        <NPScreen>{screenValueString}</NPScreen>
        <NPButton num={'/'} action={checkedUpdateScreenValue}/>
        <NPButton num={'-'} action={checkedUpdateScreenValue}/>
        <NPButton num={'+'} action={checkedUpdateScreenValue}/>
        <NPButton num={'9'} action={checkedUpdateScreenValue}/>
        <NPButton num={'8'} action={checkedUpdateScreenValue}/>
        <NPButton num={'7'} action={checkedUpdateScreenValue}/>
        <NPButton num={'6'} action={checkedUpdateScreenValue}/>
        <NPButton num={'5'} action={checkedUpdateScreenValue}/>
        <NPButton num={'4'} action={checkedUpdateScreenValue}/>
        <NPButton num={'3'} action={checkedUpdateScreenValue}/>
        <NPButton num={'2'} action={checkedUpdateScreenValue}/>
        <NPButton num={'1'} action={checkedUpdateScreenValue}/>
        <NPButton num={'*'} action={checkedUpdateScreenValue}/>
        <NPButton num={'0'} action={checkedUpdateScreenValue}/>
        <NPButton num={'='} action={runEquation}/>
        </div>
    )
}