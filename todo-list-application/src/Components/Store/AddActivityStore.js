import {createSlice} from "@reduxjs/toolkit";

export const AddActivityStore = createSlice({
    name:"activity",
    initialState:{
        activityName:'',
        startTime:'00:00:00',
        endTime:'00:00:00'
    },
    reducers:{
        setActivityName:(state, value) => {state.activityName = value.payload},
        setStartTime:(state, value) => {state.startTime = value.payload},
        setEndTime:(state, value) => {state.endTime = value.payload}
    }
});

export const {
    setActivityName
    , setStartTime
    , setEndTime
} = AddActivityStore.actions;

export default AddActivityStore;