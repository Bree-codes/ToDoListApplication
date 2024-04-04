import React from 'react'
import  ReactDom from 'react-dom/client'
import App from "./App.jsx";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Provider} from "react-redux";
import DataStore from "./Components/Store/DataStore.js";



ReactDom.createRoot(document.getElementById("root")).render(
    <React.StrictMode>
        <Provider store={DataStore}>
            <App />
        </Provider>
    </React.StrictMode>
)

