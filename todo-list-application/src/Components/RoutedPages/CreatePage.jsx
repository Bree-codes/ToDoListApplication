import {useEffect, useState} from "react";
import {Auth} from "../SectionComponents/Auth.js";
import {useNavigate} from "react-router";
import {ActivityField} from "../SectionComponents/ActivityField.jsx";
import {Col, Image, Row} from "react-bootstrap";
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
                <Col className={`col-lg-4 side-bar ${showSidebar ? 'show' : ''}`}>
                    <div className="side-bar-header">
                        <div>
                            <Image src={profileImage} height={50} width={50} className="side-bar-image"/>
                            <br/>
                            <span>{sessionStorage.getItem("username")}</span>
                            </div>
                        <span className="close-btn" onClick={toggleSidebar}>&times;</span>
                    </div>
                    {/* Sidebar content here */}
                </Col>
                <Col className="col-12 col-md-8 input-section">
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
