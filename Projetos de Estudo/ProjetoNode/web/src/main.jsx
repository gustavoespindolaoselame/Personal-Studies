import { createRoot } from 'react-dom/client'
import './main.css'
import Page from './page/page'
import MainBody from './page/mainBody/mainBody'
import TopNav from './page/topNav/topNav'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import DownloadPage from './page/mainBody/songDownloadPage/songDownloadPage'
import UploadPage from './page/mainBody/songUploadPage/songUploadPage'
import DevPage from './page/mainBody/devPage/devPage'
import AlbumDownloadPage from './page/mainBody/albumDownloadPage/albumDownloadPage'
import AlbumUploadPage from './page/mainBody/albumUploadPage/albumUploadPage'
import MessageBox from './page/messageBox/messageBox'


createRoot(document.getElementById('root')).render(
  <MessageBox>
    <Router>
      <Page>
			<TopNav>
        <a href="/albums/download">ALBUM - Downloads</a>
        <a href="/albums/upload">ALBUM - Uploads</a>
        <a href="/songs/download">SONG - Downloads</a>
        <a href="/songs/upload">SONG - Uploads</a>
        <a href="/developer">DEV</a>
      </TopNav>
      <Routes>
        <Route path="/albums/download" element={<MainBody><AlbumDownloadPage/></MainBody>} />
        <Route path="/albums/upload" element={<MainBody><AlbumUploadPage/></MainBody>} />
        <Route path="/songs/download" element={<MainBody><DownloadPage/></MainBody>} />
        <Route path="/songs/upload" element={<MainBody><UploadPage/></MainBody>} />
        <Route path="/developer" element={<MainBody><DevPage/></MainBody>} />
      </Routes>
      </Page>
    </Router>
  </MessageBox>
)
