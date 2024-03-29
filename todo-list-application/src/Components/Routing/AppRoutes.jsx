import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "../RoutedPages/Home.jsx";
import SingUpPage from "../RoutedPages/SingUpPage.jsx";
import SingInPage from "../RoutedPages/SingInPage.jsx";


export  default function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"}>
                    <Route index element={<Home/>}/>
                    <Route path={"/singup"} element={<SingUpPage />} />
                    <Route path={"/singin"} element={<SingInPage />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
}
