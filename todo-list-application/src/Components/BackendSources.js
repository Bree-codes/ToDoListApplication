import axios from "axios";

const openAPI = axios.create({
    baseURL:"https://localhost:8080/api/v1",
    headers:{
        Authorization:""
    }
})

export async function register(username, email, password) {

    const user = {
        username:username,
        email:email,
        password:password
    }

    //send the registration request
    return await openAPI.post("/register", user);
}