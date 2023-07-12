import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/* StrictMode - it mounts and immediately unmounts your components 
      useful for spotting memory leaks

      only used in dev server - NOT IN PRODUCTION BUILD */}
    { /** everything returned by App.jsx, display here */ }
    <App />
  </React.StrictMode>,
)
