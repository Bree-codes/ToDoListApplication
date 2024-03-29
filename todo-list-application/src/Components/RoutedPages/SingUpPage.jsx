import '../Styles/singUp.css'
import {Alert, Button, Container, Form} from "react-bootstrap";
import {useState} from "react";
import {register} from "../BackendSources.js";

export default function SingUpPage() {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const PASSWORD_REGEX = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/
    const [alert, setAlert] = useState('');


    const handleRegister = (e) => {
        e.preventDefault();
        if (username === ''){
            setAlert("Username can not be empty");
            return;
        }
        if(email === '') {
            setAlert("email can not be null");
            return;
        }
        if(!checkStrength(password) && !checkMatch()) {
            setAlert("check on you password please.");
            return;
        }

        register(username, email, password).then((response) => {
                setEmail('');
                setUsername('');
                setConfirmPassword('');
                setPassword('');

                localStorage.setItem("user", response.data.toString());

            }
        ).catch((error) =>{
            setAlert(error.response.data.message);
        })

    }

    const handlePasswords = (e) => {
        e.preventDefault();

        setConfirmPassword(e.target.value);

        if (checkMatch()) {
            setAlert('');
            if (checkStrength(confirmPassword)) {
                setAlert('');
            }
        }
    }

    const handlePasswordStrength = (e) => {
        e.preventDefault();

        setPassword(e.target.value);

        if (checkStrength(password)) {
            setAlert('');
            if (checkMatch()) {
                setAlert('');
            }
        }
    }

    const checkMatch = () => {
        if(password.match(confirmPassword)){
            return true;
        } else {
            setAlert("Passwords does not match");
            return false;
        }
    }

    const checkStrength = (pass) =>{
        if(PASSWORD_REGEX.test(pass)){
            setAlert('');
            return true;
        }else {
            setAlert("A password must contain at least 9 characters :- a least : - 1 Upper case letter" +
                "1 lower case letter, 1 number and a special character");
            return false;
        }
    }


    return (
        <Container className={"container"}>
            <div className="section">
                <Form onSubmit={handleRegister}>
                    <Form.Label className={"label"}>Sing Up</Form.Label>

                    {alert && <Alert className={"alert"}>{alert}</Alert>}

                   <Form.Group className={"group"}>
                       <Form.Label className={"star label"}>Username</Form.Label>
                       <Form.Control type={"text"} placeholder={"e.g Red-Stevo"} autoComplete={"false"}
                       onChange={(e) => setUsername(e.target.value)}
                       value={username}/>
                   </Form.Group>

                    <Form.Group className={"group"}>
                        <Form.Label className={"star label"}>Email</Form.Label>
                        <Form.Control type={"email"} placeholder={"breecodes@gmail.com"} autoComplete={"false"}
                        onChange={(e) => setEmail(e.target.value)}
                        value={email}/>
                    </Form.Group>

                    <Form.Group className={"group"}>
                        <Form.Label className={"star label"} >Password</Form.Label>
                        <Form.Control type={"password"} autoComplete={"false"}
                        onChange={handlePasswordStrength}
                        value={password}/>
                    </Form.Group>

                    <Form.Group className={"group"}>
                        <Form.Label className={"star label"} >Confirm Password</Form.Label>
                        <Form.Control type={"password"} autoComplete={"false"}
                          onChange={handlePasswords}
                            value={confirmPassword}/>
                    </Form.Group>
                        <Button type={"submit"}>Register</Button>
                </Form>
            </div>
        </Container>
    );
}
