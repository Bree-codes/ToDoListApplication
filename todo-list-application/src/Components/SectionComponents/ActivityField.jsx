import './../Styles/main.css'
import {Col, Form, Row} from "react-bootstrap";
import {TimeInput} from "./TimeInput.jsx";
import {useState} from "react";



export const ActivityField = () =>{
    const [activityName, setActivityName] = useState();
    const [startTime, setStartTime] = useState({hours:0, minutes:0});
    const [endTime, setEndtTime] = useState({hours:0, minutes:0});





    return(
        <div className={'activity'}>
            <Form>
                <Row>
                    <Col sm className={'m-2'}>
                        <Form.Control placeholder="activity-name:- e.g. cleaning" />
                    </Col>
                    <Col sm className={'m-2'}>
                        <TimeInput />
                    </Col>
                    <Col sm className={'m-2'}>
                        <TimeInput />
                    </Col>
                </Row>
            </Form>
        </div>
    )
}

