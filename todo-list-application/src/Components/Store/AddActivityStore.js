import {createSlice} from "@reduxjs/toolkit";

export const AddActivityStore = createSlice({
    name:"todoActivity",
    initialState:{
        activity:'',
        startTime:'00:00:00',
        endTime:'00:00:00'
    },
    reducers:{
        setActivityName:(state, value) => {state.activity = value.payload},
        setStartTime:(state, value) => {state.startTime = value.payload},
        setEndTime:(state, value) => {state.endTime = value.payload}
    }
});

export const {
    setActivityName
    , setStartTime
    , setEndTime
} = AddActivityStore.actions;

export default AddActivityStore.reducer;