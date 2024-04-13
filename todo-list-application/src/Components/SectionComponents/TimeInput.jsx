import './../Styles/main.css'
import {useEffect, useState} from "react";
import {Form, InputGroup} from "react-bootstrap";



// eslint-disable-next-line react/prop-types
export const TimeInput = ({onChange, disable}) =>{

    const [hours, setHours] = useState("00");
    const [minutes, setMinutes] = useState("00");

    const handleHours = (e) => {
        setHours(() => {return e.target.value});
        return hours;
    }

    const handleMinutes = (e) => {
        setMinutes(() => {return e.target.value});
        return minutes;
    }


    useEffect(() => {
        onChange(`${hours}:${minutes}:00`);
    }, [hours, minutes]);

    return (
        <>
            <div>
                <Form>
                    <InputGroup>
                        <Form.Control  value={`${hours}`} onChange={handleHours}/>
                        <Form.Control  value={`${minutes}`} onChange={handleMinutes}/>
                    </InputGroup>
                </Form>
            </div>
            <div>
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

            <select className={'time-selector'}
                onChange={handleMinutes}
                disabled={disable}
                value={minutes}>
                {Array.from({length: 60}, (_, i) => (
                    <option key={i} value={i}>
                        {i}
                    </option>
                ))}
            </select>
            </div>
        </>
    );
}

