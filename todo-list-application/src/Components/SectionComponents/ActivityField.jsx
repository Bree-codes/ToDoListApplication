import {Alert, Col, Form, Row} from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import {setEndTime, setStartTime} from "../Store/AddActivityStore.js";
import {TimeInput} from "./TimeInput.jsx";
import './../Styles/main.css'
import {addActivity} from "../BackendSources.js";
import {useState} from "react";
import {ActivityNameInput} from "./ActivityNameInput.jsx";

// eslint-disable-next-line react/prop-types
export const ActivityField = ({handleAdding}) => {
    const activity = useSelector(state => state.activity.activityName);
    const startTime = useSelector((state) => state.activity.startTime);
    const endTime = useSelector((state) => state.activity.endTime);
    const dispatch = useDispatch();
    const [error, setError] = useState();

    const handleAdd = (e) => {
        e.preventDefault();
        const userId = sessionStorage.getItem('id');

        const request = {
            activityName : activity,
            startTime:startTime,
            endTime:endTime
        }

        addActivity(request, userId).then(res =>{
            res.status;
            handleAdding();
        }).catch(error => {
            setError(error.response.message);
        });
    }

    const handleDone = (e) => {
        e.preventDefault();
    }


    return (
        <div className={'activity'}>
            {error && <Alert>{error}</Alert>}
            <Form>
                <Row>
                    <Col lg className={'m-2 '}>
                         <ActivityNameInput dispatch={dispatch} />
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
                    <Col xs={2} className={'m-3 column'} >
                        <button className={'add'} onClick={handleAdd}>Add</button>
                    </Col>
                    <Col xs={2} className={'m-3 column'}>
                        <button className={'done'} onChange={handleDone}>Done</button>
                    </Col>
                </Row>
            </Form>
        </div>
    );
};

