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
        <Row >
            <Col className={"col-lg-3 side-bar d-md-flex d-none"}>
                <Col className={"side-bar-header"}>
                    <div>
                        <Image src={profileImage} height={50} width={50} className={"side-bar-image"} />
                        <br />
                        <span>{sessionStorage.getItem("username")}</span>
                    </div>
                </Col>
            </Col>
            <Col className={"col-12 col-md-9 input-section"}>
                <Row className={"input-header"}>
                    <Col className={"col-lg-4"} >ACTIVITY</Col>
                    <Col className={"col-lg-3"}>START </Col>
                    <Col className={"col-lg-3"}>STOP</Col>
                    <Col className={"col-lg-1"}>ACTION</Col>
                </Row>
                {section.map((sec) => {
                    return(sec);
                })}
            </Col>
        </Row>
    );
};

export default CreatePage;
