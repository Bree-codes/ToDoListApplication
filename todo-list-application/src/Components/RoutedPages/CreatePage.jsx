import {useEffect, useState} from "react";
import {Auth} from "../SectionComponents/Auth.js";
import {useNavigate} from "react-router";
import {ActivityField} from "../SectionComponents/ActivityField.jsx";
import {Col, Container, Image, Nav, Navbar, Row, ToggleButton} from "react-bootstrap";
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
                <Col className={"col-lg-2 "}>
                <Navbar expand="md" className="bg-body-tertiary">
                        <Navbar.Brand href="#home">Home</Navbar.Brand>
                    <ToggleButton id={"side-bar"} value={"Profile"} >Todo Lists</ToggleButton>
                        <Container id="side-bar">
                            <Col className="me-auto">
                                <Row href="#home">Home</Row>
                                <Row href="#link">Link</Row>
                            </Col>
                        </Container>
                </Navbar>
            </Col>
                <Col className="col-12 col-md-10 input-section content">
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
