import './../Styles/main.css'
import {useState} from "react";


// eslint-disable-next-line react/prop-types
export const TimeInput = ({onChange}) =>{

    const [hours, setHours] = useState("00");
    const [minutes, setMinutes] = useState("00");

    const handleHours = (e) => {
        setHours(e.target.value);
        setHours(e.target.value);
        onChange(hours+":"+minutes+":00");
    }

    const handleMinutes = (e) => {
        setMinutes(e.target.value);
        setMinutes(e.target.value);
        onChange(hours+":"+minutes+":00");
    }

    return (
        <>
            <select id="hour" className={'hours'}
            onChange={handleHours} value={hours}>
                {Array.from({length: 24}, (_, i) => (
                    <option key={i} value={i} className={"bg-dark"}>
                        {i}
                    </option>
                ))}
            </select>
            <select id="minute" className={'minutes'}
            onChange={handleMinutes} value={minutes}>
                {Array.from({length: 60}, (_, i) => (
                    <option key={i} value={i} className={"bg-dark"}>
                        {i}
                    </option>
                ))}
            </select>
        </>
    );
}

