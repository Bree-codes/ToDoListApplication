import { Route, Navigate } from 'react-router-dom';

// eslint-disable-next-line react/prop-types
const ProtectedRoute = ({ element: Element, ...rest }) => {
    const isAuthenticated = true; // Replace with your authentication logic

    return (
        <Route
            {...rest}
            element={isAuthenticated ? <Element /> : <Navigate to="/signin" replace />}
        />
    );
};

export default ProtectedRoute;
