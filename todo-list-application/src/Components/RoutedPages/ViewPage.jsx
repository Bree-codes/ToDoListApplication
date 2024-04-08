import {useEffect, useState} from "react";
import {getDate} from "../BackendSources.js";
import {setDates} from "../Store/TodoDates.js";
import {useDispatch} from "react-redux";
import {Alert} from "react-bootstrap";

export const  ViewPage = () => {
    const userId = localStorage.getItem('id');
    const dispatch = useDispatch();
    const [error, setError] = useState('');

    useEffect(() => {
        getDate(userId).then((res) =>{

            dispatch(setDates(res.data));

        }).catch(error => {

            setError(error.response.message);
        });

    }, []);



    return(
        <div>
            {error && <Alert>{error}</Alert>}
            <h1>view page</h1>
        </div>
    )
}