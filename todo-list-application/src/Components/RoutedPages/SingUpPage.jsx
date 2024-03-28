import './../Styles/RotationCss.css'
import {Alert, Button, Container, Form} from "react-bootstrap";
import {useRef, useState} from "react";

export default function SingUpPage() {
    const [username, setUsername] = useState(' ');
    const [email, setEmail] = useState(' ');
    const [password, setPassword] = useState(' ');
    const [confirmPassword, setConfirmPassword] = useState(' ');
    const PASSWORD_REGEX = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{7,}$/
    const [passwordStrengthAlert, setPasswordStrengthAlert] = useState('');


    const handleRegister = () =>{

    }

    const handlePasswords = () => {



    }

    const handlePasswordStrength = (e) =>{

        //set the entered password
        setPassword(e.target.value);

        //verify the password strength
        if(!PASSWORD_REGEX.test(password) && password !== ''){
            setPasswordStrengthAlert("Password must have at least 8 characters :- an upper case letter, " +
                "a lower case letter, a number and a special character");
        }
        else {
            setPasswordStrengthAlert('');
        }
    }

    return (
        <Container className={"container"}>
            <div className="section">
                <Form onSubmit={handleRegister}>
                    <Form.Label className={"label"}>Register</Form.Label>

                    {passwordStrengthAlert && <Alert className={"alert"}>{passwordStrengthAlert}</Alert>}

                   <Form.Group className={"group"}>
                       <Form.Label className={"star label"}>Username</Form.Label>
                       <Form.Control type={"text"} placeholder={"e.g Red-Stevo"} autoComplete={"false"}
                       onChange={(e) => setUsername(e.target.value)}/>
                   </Form.Group>

                    <Form.Group className={"group"}>
                        <Form.Label className={"star label"}>Email</Form.Label>
                        <Form.Control type={"email"} placeholder={"breecodes@gmail.com"} autoComplete={"false"}
                        onChange={(e) => setEmail(e.target.value)}/>
                    </Form.Group>

                    <Form.Group className={"group"}>
                        <Form.Label className={"star label"} >Password</Form.Label>
                        <Form.Control type={"password"} autoComplete={"false"}
                        onChange={handlePasswordStrength}/>
                    </Form.Group>

                    <Form.Group className={"group"}>
                        <Form.Label className={"star label"} >Confirm Password</Form.Label>
                        <Form.Control type={"password"} autoComplete={"false"}
                          onChange={handlePasswords}/>
                    </Form.Group>
                        <Button type={"submit"}>Register</Button>
                </Form>
            </div>
        </Container>
    );
}
