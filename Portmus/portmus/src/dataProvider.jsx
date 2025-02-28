import Data from './data.json'
import AlbumsCard from './components/albums/card.jsx'
import ArtistSheetCard from './components/artistsheet/card.jsx'
import React, { useEffect, useState } from 'react'

const initialState = {
    albumsData: [],   
    artistSheetData: [],      
    artistData: null
}      

export const AppContext = React.createContext(initialState)

export default props => {
    const [albumsData, setAlbumsData] = useState([]);
    const [artistSheetData, setArtistSheetData] = useState([]);
    const [artistData, setArtistData] = useState(null);

    useEffect(()=>{
        setAlbumsData(
            Data.artists[0].albums.map(album => {
                return <AlbumsCard key={album.albumId}>
                        <h1>{album.title}</h1>
                        <hr/>
                        <p>{album.description}</p>
                    </AlbumsCard>
                })
        )

        setArtistSheetData(
            Data.artists.map(artist => {
                return <ArtistSheetCard key={artist.artistId}>
                        <h1>{artist.title}</h1>
                        <hr/>
                        <p>{artist.description}</p>
                    </ArtistSheetCard>
                })
        )
        setArtistData(
                <div className='artistBody'>
                    {Data.artists[0].specificDescription || '0'}
                </div>
        )
    },[])

    return (
        <AppContext.Provider value={{
            albumsData,
            artistSheetData,
            artistData
        }}>
            {props.children}
        </AppContext.Provider>
    )
}