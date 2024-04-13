import {useEffect, useState} from "react";
import {Auth} from "../SectionComponents/Auth.js";
import {useNavigate} from "react-router";
import './../Styles/main.css'
import {ActivityField} from "../SectionComponents/ActivityField.jsx";
import {Col, Row, Stack} from "react-bootstrap";

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
        <div>
            <Row>
                <Col className={"col-md-4"}>

                </Col>
            <Stack className={"col-md-8"}>
                {section.map((sec) => {
                    return(sec);
                })}
            </Stack>
            </Row>
        </div>
    );
};

export default CreatePage;
