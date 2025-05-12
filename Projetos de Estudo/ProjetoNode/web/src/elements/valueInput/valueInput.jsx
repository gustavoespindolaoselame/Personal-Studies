import { useState } from 'react';
import style from './valueInput.module.css';

function ValueInput(props) {
    const [inputValue, setInputValue] = props.state;
    const selectionArray = props.selectionArray;
    const [isSelectionVisible, setIsSelectionVisible] = useState([...selectionArray].map(_=>false));
    const [oldIndex, setOldIndex] = useState(null);

    const defInputOnInputChange = (e, index, bypass) => {
        const newValues = [...inputValue];
        bypass?
        newValues[index] = bypass:
        newValues[index] = e.target.value;
        setInputValue(newValues);
        closeSelection(index);
    };

    const defInputOnSelect = (select, index) => {
        const newValues = [...inputValue];
        newValues[index] = select;
        setInputValue(newValues);
        closeSelection(index);
    };

    const onKeyClick = (e, index) => {
        if (e.key === 'Enter' || e === 'ButtonInput') {
            if(e!='ButtonInput') e.preventDefault();
            const newValues = [...inputValue];
            newValues.splice(index + 1, 0, "");
            setInputValue(newValues);
        }
        if((e.key=== 'Backspace' || e.key=== 'Delete')&& !inputValue[index]){
            removeInput(index)
        }
    };

    const openSelection = (index) => {
        closeSelection();
        let newArray=[...isSelectionVisible];
        newArray[index]=true;
        setIsSelectionVisible(newArray);
        setOldIndex(index);
    }
    
    const closeSelection = () => {
        let newArray=[...isSelectionVisible];
        newArray[oldIndex]=false;
        setIsSelectionVisible(newArray);
    }    

    const removeInput = (index) => {
        if(inputValue.length>1){
            const newValues = [...inputValue];
            newValues.splice(index, 1);
            setInputValue(newValues);
        }
    }

    const customInput = (value, index) => (<input
        value={value}
        onChange={e => defInputOnInputChange(e, index)}
        onKeyDown={e => onKeyClick(e, index)}
        onClick={_=> openSelection(index)}
        placeholder={props.title}
        type={props.type}
    />)

    const selection = (index) => (
        isSelectionVisible[index] && selectionArray.map((value, listId)=>
        <li 
            key={listId}
            onMouseDown={_=>defInputOnSelect(value, index)}
            >{value}
        </li>))

    const addInputButton = (index) => (
        <button onClick={_ => onKeyClick('ButtonInput', index)}>+</button>
    )

    const removeInputButton = (index) => (
        index>0?<button onClick={_ => removeInput(index)}>-</button>:<button style={{backgroundColor:'rgba(0, 0, 0, 0)',border:'0'}}/>
    )

    const inputComponentCollection = inputValue.map((value, index) => (
        <div className={style.inputButtonBox} key={index}>
            <div className={style.blurBox} onBlur={_=>closeSelection(index)}>
                <div className={style.inputAndButtons}>
                    {customInput(value,index)}  
                    {addInputButton(index)}
                    {removeInputButton(index)}
                </div>
                <div className={style.scrollContainer}>
                    <div className={style.scroll}>
                        {selection(index)}
                    </div>
                </div>
            </div> 
        </div>
    ));

    return (<div className={style.backSection}>
                {inputComponentCollection}
            </div>)
}

export default ValueInput;
