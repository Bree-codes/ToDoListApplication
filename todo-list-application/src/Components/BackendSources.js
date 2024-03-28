import axios from "axios";

const openAPI = axios.create({
    baseURL:"https://localhost:8080/api/v1",
    headers:{
        Authorization:""
    }
})

export async function register() {

}