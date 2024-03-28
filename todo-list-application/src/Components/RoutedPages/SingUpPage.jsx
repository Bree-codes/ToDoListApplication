import './../Styles/RotationCss.css'
import {Button, Container, Form} from "react-bootstrap";
import {useState} from "react";

export default function SingUpPage() {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');


    const handleRegister = () =>{

    }

    const handlePasswords = () => {

    }

    return (
        <Container className={"container"}>
            <div className="section">
                <Form onSubmit={handleRegister}>
                    <Form.Label className={"label"}>Register</Form.Label>

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
                        onChange={handlePasswords}/>
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
