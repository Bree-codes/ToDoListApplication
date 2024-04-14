import {Alert, Col, Row} from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import {setEndTime, setStartTime} from "../Store/AddActivityStore.js";
import {TimeInput} from "./TimeInput.jsx";
import './../Styles/main.css'
import {addActivity} from "../BackendSources.js";
import {useEffect, useState} from "react";
import {ActivityNameInput} from "./ActivityNameInput.jsx";
import {ActionButton} from "./ActionButton.jsx";

// eslint-disable-next-line react/prop-types
export const ActivityField = ({handleAdding}) => {

    const activity = useSelector(state => state.activity.activityName);
    const startTime = useSelector((state) => state.activity.startTime);
    const endTime = useSelector((state) => state.activity.endTime);
    const dispatch = useDispatch();
    const [error, setError] = useState('');
    const [editable, setEditable] = useState(false);

    const handleAdd = (e) => {
        addField(e, 1);
    }


    const handleDone = (e) => {
        addField(e, 0)
    }

    function addField(e,num) {
        e.preventDefault();

        const userId = sessionStorage.getItem('id');

        const request = {
            activityName: activity,
            startTime: startTime,
            endTime: endTime
        }

        addActivity(request, userId).then(res => {
            res.status;

            handleAdding(num);

            setEditable(() => true);

        }).catch(error => {
            setError(error.response.message);

        });
    }

    useEffect(() => {
        setError('');
    }, [activity, startTime,endTime]);



    return (
        <div>
            {error && <Alert>{error}</Alert>}
                <Row>
                    <Col className={"col-md-4"}>
                         <ActivityNameInput dispatch={dispatch} disable={editable} />
                    </Col>
                    <Col className={"col-md-3"}>
                        <TimeInput id={'start'} onChange={(value) => dispatch(setStartTime(value))} disable={editable} />
                    </Col>
                    <Col className={"col-md-3 "}>
                        <TimeInput id={"end"} onChange={(value) => dispatch(setEndTime(value))} disable={editable}/>
                    </Col>
                    <Col className={"col-md-2 "}>
                        <ActionButton add={handleAdd} done={handleDone} />
                    </Col>
                </Row>
        </div>
    );
};

