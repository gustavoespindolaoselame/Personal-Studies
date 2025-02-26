import React from 'react' 
import { Link, BrowserRouter, Routes, Route } from 'react-router'
import ArtistBody from './artist/body'
import AlbumsBody from './albums/body'
import ArtistSheetBody from './artistsheet/body'

export default props => {
    return (
        <BrowserRouter>
        <nav className='navBar'>
            {/* <h1 className='title'>Graganakth Void</h1> */}
            <Link to="/"><button className='title'>Artists</button></Link>
            <Link to="/artist"><button className='button'>Artist</button></Link>
            <Link to="/albums"><button className='button'>Albums</button></Link>
            </nav>
            <Routes>
                <Route path="/" element={<ArtistSheetBody/>}/>
                <Route path="artist" element={<ArtistBody/>}/>
                <Route path="albums" element={<AlbumsBody/>}/>
            </Routes>
        </BrowserRouter>
    )
}