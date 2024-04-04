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
                    <Col sm className={'m-2 '}>
                        <label htmlFor="activity">Activity: </label>
                        <Form.Control id='activity' placeholder="activity-name"/>
                    </Col>
                    <Col sm className={'m-4 '}>
                        <label htmlFor="start">Start: </label>
                        <TimeInput id={'start'}/>
                    </Col>
                    <Col sm className={'m-4'}>
                        <label htmlFor="end">End: </label>
                        <TimeInput id={"end"}/>
                    </Col>
                </Row>
            </Form>
        </div>
    )
}

