import './../Styles/main.css'
import {useEffect, useState} from "react";



// eslint-disable-next-line react/prop-types
export const TimeInput = ({onChange}) =>{

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
            <select id="hour" className={'hours'}
                    value={hours} onChange={handleHours} >
                {Array.from({length: 24}, (_, i) => (
                    <option key={i} value={i} className={"bg-dark"}>
                        {i}
                    </option>
                ))}
            </select>

            <select id="minute" className={'minutes'}
                    value={minutes} onChange={handleMinutes} >
                {Array.from({length: 60}, (_, i) => (
                    <option key={i} value={i} className={"bg-dark"}>
                        {i}
                    </option>
                ))}
            </select>
        </>
    );
}

