import { createRoot } from 'react-dom/client'
import './index.css'
import Page from './page'
import MainBody from './page/mainBody'
import TopNav from './page/topNav'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import DownloadPage from './page/mainBody/downloadPage'
import UploadPage from './page/mainBody/uploadPage'
import DevPage from './page/mainBody/devPage'


createRoot(document.getElementById('root')).render(
	<Router>
      <Page>
			<TopNav>
        <a href="/download">DOWNLOAD</a>
        <a href="/upload">UPLOAD</a>
        <a href="/developer">DEV</a>
      </TopNav>
      <Routes>
        <Route path="/upload" element={<MainBody><UploadPage/></MainBody>} />
        <Route path="/download" element={<MainBody><DownloadPage/></MainBody>} />
        <Route path="/developer" element={<MainBody><DevPage/></MainBody>} />
      </Routes>
      </Page>
    </Router>
)
