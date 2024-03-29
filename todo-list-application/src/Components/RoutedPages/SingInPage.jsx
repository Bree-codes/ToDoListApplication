import {Alert, Button, Form} from "react-bootstrap";
import './../Styles/singUp.css'
import {useState} from "react";
import {singin} from "../BackendSources.js";

export default function SingInPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [alert, setAlert] = useState('');

    const handleSingIn = (e) =>{
        e.preventDefault();

        singin(username, password).then((response) =>{

            setUsername('');
            setPassword('');

            localStorage.setItem("user", response.data.value);
        }).catch((error) =>
        {
            if(error.response.status === 401){
                setAlert("Incorrect Username or Password");
            }
        });
    }


    return (
        <div className="contain" >
            <div className="section">
                <Form onSubmit={handleSingIn}>
                    <Form.Label className='label' >Sing In</Form.Label>
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

                    <Button type={'submit'} className={"button"}>Singin</Button>

                </Form>
            </div>
        </div>
    );
}
