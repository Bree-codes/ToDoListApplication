import { configureStore } from "@reduxjs/toolkit";
import {AddActivityStore} from "./AddActivityStore.js";
import TodoDates from "./TodoDates.js";

export  default configureStore({
    reducer:{
        activity:AddActivityStore.reducer,
        datesList:TodoDates.reducer
    }
});