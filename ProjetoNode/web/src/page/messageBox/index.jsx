// FlashContext.js
import { createContext, useContext, useState, useEffect } from 'react';

const FlashContext = createContext();

export function FlashProvider({ children }) {
    const [isOn, setIsOn] = useState(false);

    useEffect(() => {
        const interval = setInterval(() => {
            setIsOn(true);
            setTimeout(() => setIsOn(false), 500);
        }, 3000);
        return () => clearInterval(interval);
    }, []);

    return (
        <FlashContext.Provider value={{ isOn }}>
        {children}
        </FlashContext.Provider>
    );
}

export function useFlash() {
    return useContext(FlashContext);    
}
