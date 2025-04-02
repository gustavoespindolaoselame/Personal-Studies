import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Card from './card'

createRoot(document.getElementById('root')).render(
	<StrictMode>
		<Card id='9'/>
		<Card id='10'/>
		<Card id='11'/>
	</StrictMode>,
)
