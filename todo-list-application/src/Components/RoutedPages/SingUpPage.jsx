import './../Styles/RotationCss.css'
import {Container, Form} from "react-bootstrap";

export default function SingUpPage() {


    const handleRegister = () =>{

    }

    return (
        <Container className={"container"}>
            <div className="section">
                <Form onSubmit={handleRegister}>
                    <Form.Label>Register</Form.Label>
                   <Form.Group>
                       <Form.Label>Username</Form.Label>
                       <Form.Control type={"text"} placeholder={"e.g Red-Stevo"} />
                   </Form.Group>

                    <Form.Group>
                        <Form.Label>Email</Form.Label>
                        <Form.Control type={"email"} placeholder={"breecodes@gmail.com"}/>
                    </Form.Group>

                    <Form.Group>
                        <Form.Label>Password</Form.Label>
                        <Form.Control type={"password"} />
                    </Form.Group>

                    <Form.Group>
                        <Form.Label>Confirm Password</Form.Label>
                        <Form.Control type={"password"}/>
                    </Form.Group>
                </Form>
            </div>
        </Container>
    );
}
