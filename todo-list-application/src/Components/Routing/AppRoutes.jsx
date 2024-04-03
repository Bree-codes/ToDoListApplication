import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from '../RoutedPages/Home.jsx';
import SignUpPage from '../RoutedPages/SignUpPage.jsx';
import SignInPage from '../RoutedPages/SignInPage.jsx';
import MainPage from '../RoutedPages/MainPage.jsx';
import NotFoundPage from "../RoutedPages/NotFoundPage.jsx";

export default function AppRoutes() {
    return (
        <Router>
            <Routes>
                <Route path="/">
                    <Route index element={<Home />} />
                    <Route path="/signup" element={<SignUpPage />} />
                    <Route path="/signin" element={<SignInPage />} />
                    <Route path="/user/main" element={<MainPage />} />
                    <Route path={"*"} element={<NotFoundPage /> } />
                </Route>
            </Routes>
        </Router>
    );
}
