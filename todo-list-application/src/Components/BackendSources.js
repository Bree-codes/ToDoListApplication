import axios from "axios";

const openAPI = axios.create({
    withCredentials : true,
    baseURL:"http://localhost:8080/api/v1"
});

export async function singup(username, email, password) {

    const registrationRequest = {
        username: username,
        email: email,
        password: password
    }

    //send the registration request
    return  await (openAPI.post("/register", registrationRequest));
}

export async function singin(username, password){

    const LoginRequest = {
        username:username,
        password:password
    }
    return await (openAPI.post('/login', LoginRequest));
}


const secureAPI = axios.create({
    baseURL:"http://localhost:8080/api/v1",
    withCredentials:true,
    /*headers:{
        Authorization:`Bearer ${sessionStorage.getItem("token")}`
    }*/
});


export async function addActivity(toDoListRequest, userId){
    return await secureAPI.post("/todoList/create/"+userId, toDoListRequest);
}

export async function getDate(userId){
    return await (secureAPI.get(`/todoList/get/${userId}`));
}

export async function logout(){
    return await secureAPI.get("/logout");
}