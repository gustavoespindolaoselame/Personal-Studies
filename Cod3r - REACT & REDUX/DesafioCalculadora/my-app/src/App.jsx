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
        operations.forEach(operation1 => {
            operations.forEach(operation2 => {
                if (screenValueString.endsWith(operation1) && appendedString === operation2) {
                    if(!(appendedString === '-' && !screenValueString.endsWith('-'))){
                        appendedString = '';
                    }
                }
            })
            
        });

        let finalString = screenValueString + appendedString;
        if(finalString.startsWith('0') && !operations.includes(finalString.charAt(1)) && finalString.charAt(1)!='.'){
            finalString = finalString.slice(1);
        }
        updateScreenValue(finalString);
    }

    const runEquation = _ => {Logic(screenValueString, updateScreenValue);}

    const removeLast = _ => {
        
        if(screenValueString.length==1){
        setScreenValueString('0');
        } else {
            setScreenValueString(screenValueString.slice(0, -1));
        }
    }

    const removeAll = _ => {
        setScreenValueString('0');
    }

    const addDot = _ => {
        setScreenValueString(screenValueString+'.');
    }

    return (
        <div id='container'>
        <NPScreen>{screenValueString}</NPScreen>
        
        
        
        <NPButton num={'9'} action={checkedUpdateScreenValue}/>
        <NPButton num={'8'} action={checkedUpdateScreenValue}/>
        <NPButton num={'7'} action={checkedUpdateScreenValue}/>
        <NPButton num={'+'} action={checkedUpdateScreenValue}/>
        <NPButton num={'6'} action={checkedUpdateScreenValue}/>
        <NPButton num={'5'} action={checkedUpdateScreenValue}/>
        <NPButton num={'4'} action={checkedUpdateScreenValue}/>
        <NPButton num={'-'} action={checkedUpdateScreenValue}/>
        <NPButton num={'3'} action={checkedUpdateScreenValue}/>
        <NPButton num={'2'} action={checkedUpdateScreenValue}/>
        <NPButton num={'1'} action={checkedUpdateScreenValue}/>
        <NPButton num={'*'} action={checkedUpdateScreenValue}/>
        <NPButton num={'del'} action={removeAll}/>
        <NPButton num={'0'} action={checkedUpdateScreenValue}/>
        <NPButton num={'.'} action={addDot}/>
        <NPButton num={'/'} action={checkedUpdateScreenValue}/>   
        <NPButton num={'bac'} action={removeLast}/>   
        <NPButton num={'='} action={runEquation}/>
        </div>
    )
}