import {useEffect, useRef, useState} from "react";
import {Col, Form, InputGroup, Overlay, Tooltip} from "react-bootstrap";



// eslint-disable-next-line react/prop-types
export const TimeInput = ({onChange, disable}) =>{

    const [hours, setHours] = useState("00");
    const [minutes, setMinutes] = useState("00");
    const [hoursInput, setHoursInput] = useState(false);
    const [minutesInput, setMinutesInput] = useState(false);
    const hoursRef = useRef(null);
    const minutesRef = useRef(null);

    const handleHours = (e) => {
        setHours(() => {return e.target.value});
        setHoursInput(false);
        return hours;
    }

    const handleMinutes = (e) => {
        setMinutes(() => {return e.target.value});
        setMinutesInput(false);
        return minutes;
    }


    useEffect(() => {
        onChange(`${hours}:${minutes}:00`);
    }, [hours, minutes]);

    return (
            <div>
                    <InputGroup>
                        <Col className={"col-md-3"}>
                            <Form.Control ref={hoursRef} onClick={() => setHoursInput(!hoursInput)}
                                value={`${hours}`} onChange={handleHours} className={'hours-control'}/>
                            <Overlay target={hoursRef.current} show={hoursInput} placement="bottom-start">
                                {(props) => (
                                    <Tooltip {...props}>
                                        <select className={'time-selector'}
                                                onChange={handleHours}
                                                disabled={disable}
                                                value={hours}>
                                            {Array.from({length: 24}, (_, i) => (
                                                <option key={i} value={i}>
                                                    {i}
                                                </option>
                                            ))}
                                        </select>
                                    </Tooltip>)}
                            </Overlay>
                        </Col>
                        <Col className={"col-md-3"}>
                            <Form.Control ref={minutesRef} onClick={() => setMinutesInput(!minutesInput)}
                                value={`${minutes}`} onChange={handleMinutes} className={'minutes-control'}/>
                            <Overlay target={minutesRef.current} show={minutesInput} placement="bottom-end">
                                {(props) => (
                                    <Tooltip  {...props}>
                                        <select className={'time-selector'}
                                                onChange={handleMinutes}
                                                disabled={disable}
                                                value={minutes}>
                                            {Array.from({length: 60}, (_, i) => (
                                                <option key={i} value={i}>
                                                    {i}
                                                </option>))}
                                        </select>
                                    </Tooltip>)}
                            </Overlay>
                        </Col>
                </InputGroup>
            </div>);
}

