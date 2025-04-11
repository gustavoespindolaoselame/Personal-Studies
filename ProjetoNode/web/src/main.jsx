import { createRoot } from 'react-dom/client'
import './index.css'
import MainPage from './mainPage'
import MainBody from './mainBody'
import TopNav from './topNav'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import DownloadPage from './downloadPage'
import UploadPage from './uploadPage'

createRoot(document.getElementById('root')).render(
	<Router>
      <MainPage>
			<TopNav/>
		</MainPage>
      <Routes>
        <Route path="/upload" element={<MainBody><UploadPage/></MainBody>} />
        <Route path="/download" element={<MainBody><DownloadPage/></MainBody>} />
      </Routes>
    </Router>
)
