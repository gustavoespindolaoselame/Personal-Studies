import React from 'react' 
import Card from '../albums/card'
import './albums.css'

export default props => {
    const cardsToBeDisplayed = [
        (<Card>
            <h1>Last Breath Taken</h1>
            <hr/>
            <p>Melodic Death Metal</p>
        </Card>),
        ( <Card>
            <h1>0</h1>
            <hr/>
            <p>Electronic/Industrial</p>
        </Card>),
        (<Card>
            <h1>Grasping at The Seams</h1>
            <hr/>
            <p>Black Metal</p>
        </Card>)]

    return (
        <div className='albumsBody'>
            {cardsToBeDisplayed}
        </div>
    )
}