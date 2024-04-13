import {Form} from "react-bootstrap";
import './../Styles/main.css'
import {useEffect, useState} from "react";
import {setActivityName} from "../Store/AddActivityStore.js";



// eslint-disable-next-line react/prop-types
export const  ActivityNameInput = ({dispatch, disable}) => {

    const [activityName, setActivityField] = useState('');

    useEffect(() => {
        dispatch(setActivityName(activityName));

    }, [activityName]);

    return(<Form.Control id='activity' placeholder="activity-name"
                          onChange={(e) =>
                          {return setActivityField(() => {return (e.target.value)})} }
                          value={activityName} disabled={disable}/>);
}