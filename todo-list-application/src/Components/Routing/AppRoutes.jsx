import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "../RoutedPages/Home.jsx";
import SignUpPage from "../RoutedPages/SignUpPage.jsx";
import SignInPage from "../RoutedPages/SignInPage.jsx";
import MainPage from "../RoutedPages/MainPage.jsx";
import ProtectedRoutes from "./ProtectedRoutes.jsx";


export  default function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"}>
                    <Route index element={<Home/>}/>
                    <Route path={"/singup"} element={ <SignUpPage /> } />
                    <Route path={"/singin"} element={ <SignInPage /> } />
                    <ProtectedRoutes path={"/user/main"} element={ <MainPage /> }/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}
