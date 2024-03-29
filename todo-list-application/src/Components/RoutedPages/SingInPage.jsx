import {Button, Form} from "react-bootstrap";
import './../Styles/singUp.css'
import {useState} from "react";

export default function SingInPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");



    return (
        <div className="contain" >
            <div className="section">
                <Form>
                    <Form.Label className='label' >Sing In</Form.Label>

                    <Form.Group className='group'>
                        <Form.Label className='label' >Username</Form.Label>
                        <Form.Control type={"text"} placeholder={"Username"}
                        value={username} onChange={(e) => setUsername(e.target.value)}/>
                    </Form.Group>

                    <Form.Group className='group'>
                        <Form.Label className='label' >Password</Form.Label>
                        <Form.Control type={"password"} placeholder={"Password"}
                        value={password} onChange={(e) => setPassword(e.target.value)}/>
                    </Form.Group>

                    <Button type={'submit'} className={"button"}>Singin</Button>

                </Form>
            </div>
        </div>
    );
}
