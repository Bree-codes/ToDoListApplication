import {useEffect, useState} from "react";
import {Auth} from "../SectionComponents/Auth.js";
import {useNavigate} from "react-router";
import {ActivityField} from "../SectionComponents/ActivityField.jsx";
import {Col, Row} from "react-bootstrap";

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
            <Row className={"justify-content-center align-items-center"}>
                <Col>
                        Side bar
                </Col>
                <Col className={"col-12 col-lg-8"}>
                {section.map((sec) => {
                    return(sec);
                })}
                </Col>
            </Row>
    );
};

export default CreatePage;
