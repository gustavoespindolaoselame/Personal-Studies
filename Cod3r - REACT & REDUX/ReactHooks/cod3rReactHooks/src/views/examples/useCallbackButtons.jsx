import React from 'react'

const useCallbackButtons = props => {
    console.log('render...')
    return (
        <div>
            <button className="btn" onClick={_ => props.inc(6)}>+6</button>
            <button className="btn" onClick={_ => props.inc(12)}>+12</button>
            <button className="btn" onClick={_ => props.inc(24)}>+24</button>
        </div>
    )
}

export default React.memo(useCallbackButtons);
// export default useCallbackButtons;