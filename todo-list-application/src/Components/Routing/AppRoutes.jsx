import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "../RoutedPages/Home.jsx";
import SingUpPage from "../RoutedPages/SingUpPage.jsx";


export  default function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"}>
                    <Route index element={<Home/>}/>
                    <Route path={"register"} element={<SingUpPage />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
}
