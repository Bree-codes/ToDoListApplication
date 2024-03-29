import axios from "axios";

const openAPI = axios.create({
    baseURL:"http://localhost:8080/api/v1"
});

export async function register(username, email, password) {

    const registrationRequest = {
        username: username,
        email: email,
        password: password
    }

    //send the registration request
    return (await openAPI.post("/register", registrationRequest));
}