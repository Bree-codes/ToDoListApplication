import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "../RoutedPages/Home.jsx";


export  default function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"}>
                    <Route index element={<Home/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}
