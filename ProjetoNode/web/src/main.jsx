import { createRoot } from 'react-dom/client'
import './index.css'
import Page from './page'
import MainBody from './page/mainBody'
import TopNav from './page/topNav'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import DownloadPage from './page/mainBody/downloadPage'
import UploadPage from './page/mainBody/uploadPage'

createRoot(document.getElementById('root')).render(
	<Router>
      <Page>
			<TopNav>
        <a href="/download">Download</a>
        <a href="/upload">Upload</a>
      </TopNav>
      <Routes>
        <Route path="/upload" element={<MainBody><UploadPage/></MainBody>} />
        <Route path="/download" element={<MainBody><DownloadPage/></MainBody>} />
      </Routes>
      </Page>
    </Router>
)
