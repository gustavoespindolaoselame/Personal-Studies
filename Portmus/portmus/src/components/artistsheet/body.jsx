import React from 'react' 
import Card from '../artistsheet/card'
import './artistsheet.css'

export default props => {
    return (
        <div className='artistsSheetBody'>
            <Card>
                <h1>Graganakth Void</h1>
                <hr/>
                <p>Melodic Death Metal</p>
            </Card>
            <Card>
                <h1>Vondale</h1>
                <hr/>
                <p>Hard Rock</p>
            </Card>
        </div>
    )
}