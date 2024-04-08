import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from '../RoutedPages/Home.jsx';
import SignUpPage from '../RoutedPages/SignUpPage.jsx';
import SignInPage from '../RoutedPages/SignInPage.jsx';
import CreatePage from '../RoutedPages/CreatePage.jsx';
import {ViewPage} from "../RoutedPages/ViewPage.jsx";


export default function AppRoutes() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/signup" element={<SignUpPage />} />
                <Route path="/signin" element={<SignInPage />} />
                <Route path="/user/main" element={<CreatePage />} />
                <Route path="/user/todo/view" element={<ViewPage /> } />
            </Routes>
        </Router>
    );
}
