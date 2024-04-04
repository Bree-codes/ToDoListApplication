import { configureStore } from "@reduxjs/toolkit";
import {AddActivityStore} from "./AddActivityStore.js";

export  default configureStore({
    reducer:{
        activity:AddActivityStore
    }
});