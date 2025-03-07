import React, { useEffect, useRef, useState } from 'react'
import PageTitle from '../../components/layout/PageTitle'
import SectionTitle from '../../components/layout/SectionTitle'

const UseRef = (props) => {

    const merge = (s1, s2) => {
        let returnStringArray = [];
        for(let i = 0, j=0, y=0; i<=s1.length+s2.length; i++){
            if(i%2==0){
                returnStringArray.push([...s1][j])
                j++;
            } else {
                returnStringArray.push([...s2][y])
                y++;
            }
        }
        return returnStringArray.join('');
    }
    const [getValue1, setValue1] = useState("");
    const [getValue2, setValue2] = useState("");
    const count = useRef(0)
    const myInput1 = useRef(null)
    const myInput2 = useRef(null)

    useEffect(()=> {
        count.current = count.current + 1
        myInput2.current.focus()
    },[getValue1])

    useEffect(()=> {
        count.current = count.current + 1
        myInput1.current.focus()
    },[getValue2])

    return (
        <div className="UseRef">
            <PageTitle
                title="Hook UseRef"
                subtitle="Retorna um objeto mutável com a propriedade .current!"
            />
            <SectionTitle title="Exercício #01" />
            <div className="center">
                <div>
                    <span className="text">Valor:</span>
                    <span className="text">{merge(getValue1,getValue2)} [</span>
                    <span className="text red">{count.current}</span>
                    <span className="text">]</span>
                </div>

                <input type="text"  className="input" ref={myInput1} value={getValue1} onChange={e => setValue1(e.target.value)}/>
            </div>
            <SectionTitle title="Exercício #02" />
            <div className="center">
                <input type="text" className="input" ref={myInput2} value={getValue2} onChange={e => setValue2(e.target.value)}/>
            </div>
        </div>
    )
}

export default UseRef
