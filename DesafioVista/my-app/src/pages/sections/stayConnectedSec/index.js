import { useState } from 'react'
import style from './style.module.css'
import Link from 'next/link'

export default function(){

    const [firstName, setFirstName] = useState('First Name');
    const [lastName, setLastName] = useState('Last Name');
    const [emailAdress, setEmailAdress] = useState('E-Mail Adress');

    return (
        <section className={style.container}>
            <h2>Stay Connected</h2>
            <p>To stay up to date on everything happening at Lakewood, subscribe to our weekly newsletter.</p>
            <h3>Newsletter Signup</h3>
            <p>First Name</p>
            <input type='text' value={firstName} onChange={e => setFirstName(e.target.value)}></input>
            <p>Last Name</p>
            <input type='text' value={lastName} onChange={e => setLastName(e.target.value)}></input>
            <p>Email Adress</p>
            <input type='text' value={emailAdress} onChange={e => setEmailAdress(e.target.value)}></input>
            <br/>
            <button>Submit</button>
        </section>
    )
}