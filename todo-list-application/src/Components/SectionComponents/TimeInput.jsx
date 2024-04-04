import './../Styles/main.css'
import {useState} from "react";

s
// eslint-disable-next-line react/prop-types
export const TimeInput = ({onChange}) =>{

    const [hours, setHours] = useState();
    const [minutes, setMinutes] = useState();

    const handleHours = (e) => {

    }

    const handleMinutes = (e) => {

    }

    return (
        <>
            <select id="hour" className={'hours'}
            onChange={e => onChange}>
                {Array.from({length: 24}, (_, i) => (
                    <option key={i} value={i} className={"bg-dark"}>
                        {i}
                    </option>
                ))}
            </select>
            <select id="minute" className={'minutes'} >
                {Array.from({length: 60}, (_, i) => (
                    <option key={i} value={i} className={"bg-dark"}>
                        {i}
                    </option>
                ))}
            </select>
        </>
    );
}