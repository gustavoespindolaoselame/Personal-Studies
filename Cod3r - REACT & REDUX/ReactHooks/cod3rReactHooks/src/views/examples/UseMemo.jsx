import React, { useState } from 'react'
import PageTitle from '../../components/layout/PageTitle'

const sum = (n1,n2) => {
    const future = Date.now() + 2000
    while(Date.now() < future){
    
    }
    return n1+n2
}
const UseMemo = (props) => {
    const [getN1, setN1] = useState(0)
    const [getN2, setN2] = useState(0)
    const [getN3, setN3] = useState(0)

    const result = sum(getN1,getN2)

    return (
        <div className="UseMemo">
            <PageTitle
                title="Hook UseMemo"
                subtitle="Retorna um valor memoizado!"
            />
            <div className='center'>
                <input type="number" className='input' value={getN1||0} onChange={e=>setN1(parseInt(e.target.value))}/>
            </div>
            <div className='center'>
                <input type="number" className='input' value={getN2||0} onChange={e=>setN2(parseInt(e.target.value))}/>
            </div>
            <div className='center'>
                <input type="number" className='input' value={getN3} onChange={e=>setN3(parseInt(e.target.value))}/>
            </div>
            <span className="text">{result}</span>
        </div>
    )
}

export default UseMemo
