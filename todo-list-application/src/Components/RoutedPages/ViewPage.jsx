import {useEffect, useState} from "react";
import {getDate} from "../BackendSources.js";
import {setDates} from "../Store/TodoDates.js";
import {useDispatch, useSelector} from "react-redux";
import {Alert} from "react-bootstrap";

export const  ViewPage = () => {
    const userId = sessionStorage.getItem('id');
    const dispatch = useDispatch();
    const [error, setError] = useState('');
    const todoLists = useSelector(state => {state.datesList.dates});

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
            {todoLists.map(date =>{
                return(
                    // eslint-disable-next-line react/jsx-key
                    <h1>{date}</h1>
                )
            }) }
        </div>
    )
}