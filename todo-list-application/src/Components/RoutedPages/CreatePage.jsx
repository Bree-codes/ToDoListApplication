import {useEffect, useState} from "react";
import {Auth} from "../SectionComponents/Auth.js";
import {useNavigate} from "react-router";
import {ActivityField} from "../SectionComponents/ActivityField.jsx";
import {Col, Container, Image, Nav, Navbar, Row} from "react-bootstrap";
import profileImage from './../images/profileImage.jpeg'

const CreatePage = () => {
    const navigate = useNavigate();
    const [section, setSection] = useState([]);
    const [showSidebar, setShowSidebar] = useState(false);

    const toggleSidebar = () => {
        setShowSidebar(!showSidebar);
    };

    useEffect(() => {
            if(!Auth()){
                navigate('/signin');
            }
            else {
                // eslint-disable-next-line react/jsx-key
                setSection(() => [ <ActivityField handleAdding={handleAdding} />] );
            }
    }, [navigate]);

    const handleAdding = (num) => {
        if(num === 1) {
            setSection((prev) => {
                console.log(section.length);
                return [
                    ...prev,
                    // eslint-disable-next-line react/jsx-key
                    <ActivityField key={section.length + 1} handleAdding={handleAdding}/>
                ];
            });
        }else{
            setSection((pre) => {
                return [...pre]
            });
            navigate("/user/todo/view");
        }
    }


    return (
        <div className="container">
            <Row className={"justify-content-center align-items-center"}>
                <Navbar expand="XXl" className="bg-body-tertiary">
                    <Container className={""}>
                        <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
                        <Navbar.Toggle aria-controls="basic-navbar-nav" />
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="me-auto">
                                <Nav.Link href="#home">Home</Nav.Link>
                                <Nav.Link href="#link">Link</Nav.Link>
                            </Nav>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>
                <Col className="col-12 col-md-8 input-section content">
                    <Row className="input-header">
                        <Col className="col-lg-4">ACTIVITY</Col>
                        <Col className="col-lg-3">START</Col>
                        <Col className="col-lg-3">STOP</Col>
                        <Col className="col-lg-1">ACTION</Col>
                    </Row>
                    {/* Main content here */}
                    {/* Use enough content to enable scrolling */}
                    <div>
                        {section.map((sec) => {
                            return(sec);
                        })}
                    </div>
                </Col>
            </Row>
        </div>
    );
};

export default CreatePage;
