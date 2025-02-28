import React from 'react'
import Navbar from './components/navbar'
import './index.css'
import DataProvider from './dataProvider'


export default props => {
	return (
		<DataProvider className='app'>
		<Navbar />
		</DataProvider>
	)
}