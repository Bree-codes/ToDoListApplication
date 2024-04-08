import {useEffect, useState} from "react";
import {getDate} from "../BackendSources.js";
import {setDates} from "../Store/TodoDates.js";
import {useDispatch, useSelector} from "react-redux";
import {Alert, Stack} from "react-bootstrap";
import {TodoViewCard} from "../SectionComponents/TodoViewCard.jsx";
import './../Styles/viewPage.css'

export const  ViewPage = () => {
    const userId = sessionStorage.getItem('id');
    const dispatch = useDispatch();
    const [error, setError] = useState('');
    const todoLists = useSelector(state => state.datesList.dates);

    /*Load the todo list from the server when the page loads.*/
    useEffect(() => {

        getDate(userId).then((res) =>{
            console.log(res.status);
            dispatch(setDates(res.data));

        }).catch(error => {

            setError(error.response.message);
        });

    }, []);


    return(
        <div className={"todo-cards"}>
            {error && <Alert>{error}</Alert>}
            <Stack direction={"vertical"} className={'cards'} gap={3}>

                {todoLists ? todoLists.map((date, index) => {
                return(
                    <>
                        <TodoViewCard date={date} key={index}/>
                        <TodoViewCard date={date} key={index}/>
                        <TodoViewCard date={date} key={index}/>
                        <TodoViewCard date={date} key={index}/>
                        <TodoViewCard date={date} key={index}/>
                    </>
                );
            }) : <h1 className={"no-list"}>Create Your First Todo List</h1>}
            </Stack>
        </div>
    )
}