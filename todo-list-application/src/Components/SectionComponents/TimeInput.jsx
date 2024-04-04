export const TimeInput = (props) =>{


    return (
        <div>
            <label htmlFor="hour">Hour: </label>
            <select id="hour">
                {Array.from({length: 24}, (_, i) => (
                    <option key={i} value={i}>
                        {i}
                    </option>
                ))}
            </select>
            <label htmlFor="minute">Minute: </label>
            <select id="minute">
                {Array.from({length: 60}, (_, i) => (
                    <option key={i} value={i}>
                        {i}
                    </option>
                ))}
            </select>
        </div>
    );
}