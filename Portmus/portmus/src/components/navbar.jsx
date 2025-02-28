import React from 'react' 
import { Link, BrowserRouter, Routes, Route } from 'react-router'
import ArtistBody from './artist/body'
import AlbumsBody from './albums/body'
import ArtistSheetBody from './artistsheet/body'

export default props => {

    const preexistingId=0;
    return (
        <BrowserRouter>
        <nav className='navBar'>
            {/* <h1 className='title'>Graganakth Void</h1> */}
            <Link to="/"><button className='title'>Artists</button></Link>
            <Link to={`/${preexistingId}/artist`}><button className='button'>Artist</button></Link>
            <Link to={`/${preexistingId}/albums`}><button className='button'>Albums</button></Link>
            </nav>
            <Routes>
                <Route path="/" element={<ArtistSheetBody/>}/>
                <Route path=":id/artist" element={<ArtistBody/>}/>
                <Route path=":id/albums" element={<AlbumsBody/>}/>
            </Routes>
        </BrowserRouter>
    )
}