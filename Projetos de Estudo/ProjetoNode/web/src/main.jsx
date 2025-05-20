import { createRoot } from 'react-dom/client'
import './main.css'
import Page from './page/page'
import MainBody from './page/mainBody/mainBody'
import TopNav from './page/topNav/topNav'
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import SongDownload from './page/mainBody/song/songDownloadPage/songDownloadPage'
import SongUpload from './page/mainBody/song/songUploadPage/songUploadPage'
import DevPage from './page/mainBody/devPage/devPage'
import AlbumDownload from './page/mainBody/album/albumDownloadPage/albumDownloadPage'
import AlbumUpload from './page/mainBody/album/albumUploadPage/albumUploadPage'
import ArtistDownload from './page/mainBody/artist/artistDownloadPage/artistDownloadPage'
import ArtistUpload from './page/mainBody/artist/artistUploadPage/artistUploadPage'
import MessageBox from './elements/messageBox/messageBox'
import Dropdown from './elements/dropdown/dropdown'

createRoot(document.getElementById('root')).render(
  <MessageBox>
    <Router>
      <TopNav/>
      <Page>
      <Routes>
        <Route path="/albums/download" element={<MainBody><AlbumDownload/></MainBody>} />
        <Route path="/albums/upload" element={<MainBody><AlbumUpload/></MainBody>} />
        <Route path="/songs/download" element={<MainBody><SongDownload/></MainBody>} />
        <Route path="/songs/upload" element={<MainBody><SongUpload/></MainBody>} />
        <Route path="/artist/download" element={<MainBody><ArtistDownload/></MainBody>} />
        <Route path="/artist/upload" element={<MainBody><ArtistUpload/></MainBody>} />
        <Route path="/developer" element={<MainBody><DevPage/></MainBody>} />
      </Routes>
      </Page>
    </Router>
  </MessageBox>
)
