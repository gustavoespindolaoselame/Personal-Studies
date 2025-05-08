import { useState } from 'react';
import style from './valueInput.module.css';

function ValueInput(props) {
    const [inputValue, setInputValue] = props.state;
    const selectionArray = props.selectionArray;
    const [isSelectionVisible, setIsSelectionVisible] = useState([...inputValue].map(_=>false));

    const handleChange = (e, index, bypass) => {
        const newValues = [...inputValue];
        bypass?
        newValues[index] = bypass:
        newValues[index] = e.target.value;
        setInputValue(newValues);
    };

    const handleKeyDown = (e, index) => {
        if (e.key === 'Enter' || e === 'ButtonInput') {
            if(e!='ButtonInput') e.preventDefault();
            const newValues = [...inputValue];
            newValues.splice(index + 1, 0, "");
            setInputValue(newValues);
        }
        if((e.key=== 'Backspace' || e.key=== 'Delete')&& !inputValue[index]){
            handleRemoval(index)
        }
    };

    const handleClick = (index) => {
        let newArray=[...isSelectionVisible];
        newArray[index]=true;
        setIsSelectionVisible(newArray);
    }
    
    const handleBlur = (index) => {
        setTimeout(() => {
            let newArray=[...isSelectionVisible];
            newArray[index]=false;
            setIsSelectionVisible(newArray);
        }, 100);
    }    

    const handleRemoval = (index) => {
        if(inputValue.length>1){
            const newValues = [...inputValue];
            newValues.splice(index, 1);
            setInputValue(newValues);
        }
    }

    return <div className={style.backSection}>
            {inputValue.map((value, index) => (
                <div className={style.inputButtonBox} key={index} onMouseLeave={_=>handleBlur(index)}>
                    <div className={style.inputBoxAndSelection}>
                    <input
                        value={value}
                        onChange={e => handleChange(e, index)}
                        onKeyDown={e => handleKeyDown(e, index)}
                        onClick={_=> handleClick(index)}
                        placeholder={props.title}
                        type={props.type}
                    />
                    {isSelectionVisible[index] && selectionArray.map((value, listId)=>
                        <li 
                            key={listId}
                            className={style.selection}
                            onClick={e=>handleChange(e, index, value)}
                            >{value}
                        </li>)}
                    </div> 
                    <button onClick={_ => handleKeyDown('ButtonInput', index)}>+</button>
                    {index>0?<button onClick={_ => handleRemoval(index)}>-</button>:null}
                </div>
            ))}
        </div>
}

export default ValueInput;
