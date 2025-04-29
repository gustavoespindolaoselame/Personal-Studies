import style from './index.module.css';

function ValueInput(props) {
    const [inputValue, setInputValue] = props.state;

    const handleChange = (e, index) => {
        const newValues = [...inputValue];
        newValues[index] = e.target.value;
        setInputValue(newValues);
    };

    const handleKeyDown = (e, index) => {
        if (e.key === 'Enter') {
            e.preventDefault();
            const newValues = [...inputValue];
            newValues.splice(index + 1, 0, props.type == 'number'? undefined : ""); // insert empty string after current
            setInputValue(newValues);
        }
    };

    return (
        <div className={style.backSection}>
            {inputValue.map((value, index) => (
                <input
                    key={index}
                    value={value}
                    onChange={e => handleChange(e, index)}
                    onKeyDown={e => handleKeyDown(e, index)}
                    placeholder={props.title}
                    type={props.type}
                />
            ))}
        </div>
    );
}

export default ValueInput;
