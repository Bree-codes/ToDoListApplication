import {Container} from "react-bootstrap";
import AppRoutes from "./Components/Routing/AppRoutes.jsx";

function App() {
    return (
        <Container fluid={'xs'}>
            <AppRoutes />
        </Container>
    );
}

export default App;