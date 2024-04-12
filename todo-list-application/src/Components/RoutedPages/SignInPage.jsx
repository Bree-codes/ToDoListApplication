import {Alert, Button, Form} from "react-bootstrap";
import './../Styles/singUp.css'
import {useEffect, useState} from "react";
import {singin} from "../BackendSources.js";
import {useNavigate} from "react-router";

export default function SignInPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [alert, setAlert] = useState('');
    const navigate = useNavigate();



    useEffect(() => {
        if(sessionStorage.getItem("isLoggedIn"))
            navigate("/user/main");

        console.log("is logged in")
    }, []);

    const handleSingIn = (e) =>{
        e.preventDefault();

        singin(username, password).then((response) =>{

            setUsername('');
            setPassword('');

            sessionStorage.setItem("username", response.data.username);
            sessionStorage.setItem('id', response.data.id);
            sessionStorage.setItem("isLoggedIn", "true");
            sessionStorage.setItem("token", response.data.jwt);

            //navigate to the next page.
            navigate("/user/main");

        }).catch((error) =>
        {
            if(error.status === 401){
                setAlert("Incorrect Username or Password");
            }
        });
    }


    return (
        <div className="contain" >
            <div className="section">
                <Form onSubmit={handleSingIn}>
                    <Form.Label className='label' >Sign In</Form.Label>
                    {alert && <Alert className="alert">{alert}</Alert>}
                    <Form.Group className='group'>
                        <Form.Label className='label' >Username</Form.Label>
                        <Form.Control type={"text"} placeholder={"Username"}
                        value={username} onChange={(e) => {
                            setAlert('');
                            setUsername(e.target.value); }}/>
                    </Form.Group>

                    <Form.Group className='group'>
                        <Form.Label className='label' >Password</Form.Label>
                        <Form.Control type={"password"} placeholder={"Password"}
                        value={password} onChange={(e) => {
                            setPassword(e.target.value);
                            setAlert("");}}/>
                    </Form.Group>

                    <Button type={'submit'} className={"button"}>Signin</Button>

                </Form>
            </div>
        </div>
    );
}
