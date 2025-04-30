import { createContext, useContext, useState } from 'react';
import style from './messageBox.module.css';

export const ErrMsg = createContext();

export function ErrMsgComponent(){
    const { errMsg, errMsgText } = useContext(ErrMsg);
    return (
        <div className={errMsg ? style.isOn : style.isOff}>
            {errMsgText}
        </div>
    )
}

export function useFlashErrMsg(text) {
    const { setErrMsgText, setErrMsg } = useContext(ErrMsg);
    function flash() {
        setErrMsgText(text)
        setErrMsg(true);
        setTimeout(() => {
            setErrMsg(false);
        }, 1500);
    }
    return flash;
}

export default function(props){
    const [errMsg, setErrMsg] = useState(false);
    const [errMsgText, setErrMsgText] = useState('Default Error Message Text');

    return (
        <ErrMsg.Provider value={{errMsg, setErrMsg, errMsgText, setErrMsgText}}>
            {props.children}
        </ErrMsg.Provider>
    );
};
