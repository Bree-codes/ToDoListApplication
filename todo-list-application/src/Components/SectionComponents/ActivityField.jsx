import {Col, Form, Row} from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import {setActivityName, setEndTime, setStartTime} from "../Store/AddActivityStore.js";
import {TimeInput} from "./TimeInput.jsx";
import './../Styles/main.css'

export const ActivityField = () => {
    const activity = useSelector(state => state.activity.activityName);
    const dispatch = useDispatch();


    return (
        <div className={'activity'}>
            <Form>
                <Row>
                    <Col lg className={'m-2 '}>
                        <label htmlFor="activity" className={'label'}>Activity: </label>
                        <Form.Control id='activity' placeholder="activity-name" className={'activity-name'}
                          onChange={e => dispatch(setActivityName(e.target.value)) }
                        value={activity}/>
                    </Col>
                    <Col lg className={'m-3 '}>
                        <label htmlFor="start" className={'label'}>Start: </label> <br/>
                        <TimeInput id={'start'}  onChange={(value) => dispatch(setStartTime(value))}/>
                    </Col>
                    <Col lg className={'m-3'}>
                        <label htmlFor="end" className={'label'}>End: </label> <br/>
                        <TimeInput id={"end"} onChange={(value) => dispatch(setEndTime(value))} />
                    </Col>
                </Row>
                <Row className={'buttons'}>
                    <Col xs={2} className={'m-3 column'} ><button className={'add'}>Add</button></Col>
                    <Col xs={2} className={'m-3 column'}><button className={'done'}>Done</button></Col>
                </Row>
            </Form>
        </div>
    );
};

