import {useEffect, useState} from "react";
import {Auth} from "../SectionComponents/Auth.js";
import {useNavigate} from "react-router";
import {ActivityField} from "../SectionComponents/ActivityField.jsx";
import {Col, Row} from "react-bootstrap";
import "./../Styles/main.css"
import {SideBar} from "../SectionComponents/SideBar.jsx";

const CreatePage = () => {
    const navigate = useNavigate();
    const [section, setSection] = useState([]);

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
                return [
                    ...prev,
                    // eslint-disable-next-line react/jsx-key
                    <ActivityField handleAdding={handleAdding}/>
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
        <Row className={"container-fluid"}>
            <Col className={"col-lg-3"}>
                <SideBar />
            </Col>
            <Col className={"col-12 col-lg-9 input-section"}>
                <div></div>
                <Row className={"input-header"}>
                    <Col className={"col-lg-4"} >ACTIVITY</Col>
                    <Col className={"col-lg-3"}>START </Col>
                    <Col className={"col-lg-3"}>STOP</Col>
                    <Col className={"col-lg-1"}>ACTION</Col>
                </Row>
                {section.map((sec, index) => {
                    // eslint-disable-next-line react/jsx-key
                    return(<div className={"fields-display"} key={index+1}>{sec}</div>);
                })}
            </Col>
        </Row>
    );
};

export default CreatePage;
