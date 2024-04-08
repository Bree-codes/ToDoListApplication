import {createSlice} from "@reduxjs/toolkit";


export const TodoDates = createSlice({
    name:"userTodoDates",
    initialState: {
        dates:[]
    },
    reducers:{
        setDates: (state, dates) =>{state.dates = dates.payload}
    }
});

export const { setDates } = TodoDates.actions

export default TodoDates;