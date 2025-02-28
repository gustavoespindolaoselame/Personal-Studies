import React, { useContext } from 'react' 
import './albums.css'
import { AppContext } from '../../dataProvider'

// export default props => {
//     const { albumsData } = useContext(AppContext)
//     console.log(albumsData)
//     return (
//         <div className='albumsBody'>
//             {albumsData}
//         </div>
//     )
// }

const Body = props => {
    const { albumsData } = useContext(AppContext)
    console.log(albumsData)
    return (
        <div className='albumsBody'>
            {albumsData}
        </div>
    )
}

export default Body;