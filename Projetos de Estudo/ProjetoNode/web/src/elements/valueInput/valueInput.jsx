import style from './valueInput.module.css';

function ValueInput(props) {
    const [inputValue, setInputValue] = props.state;

    const handleChange = (e, index) => {
        const newValues = [...inputValue];
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

    const handleRemoval = (index) => {
        if(inputValue.length>1){
            const newValues = [...inputValue];
            newValues.splice(index, 1);
            setInputValue(newValues);
        }
    }

    return <div className={style.backSection}>
            {inputValue.map((value, index) => (
                <div className={style.inputButtonBox} key={index}>
                    <input
                        key={index}
                        value={value}
                        onChange={e => handleChange(e, index)}
                        onKeyDown={e => handleKeyDown(e, index)}
                        placeholder={props.title}
                        type={props.type}
                    />
                    <button onClick={_ => handleKeyDown('ButtonInput', index)}>+</button>
                    {index>0?<button onClick={_ => handleRemoval(index)}>-</button>:null}
                </div>
            ))}
        </div>
}

export default ValueInput;
