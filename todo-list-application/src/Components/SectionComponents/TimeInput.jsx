import './../Styles/main.css'

// eslint-disable-next-line no-unused-vars,react/prop-types
export const TimeInput = () =>{


    return (
        <>
            <select id="hour" className={'hours'} >
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