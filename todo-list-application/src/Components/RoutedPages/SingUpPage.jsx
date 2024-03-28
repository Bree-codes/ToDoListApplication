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

                   <Form.Group className={"group"}>
                       <Form.Label>Username</Form.Label>
                       <Form.Control type={"text"} placeholder={"e.g Red-Stevo"} autoComplete={"false"} />
                   </Form.Group>

                    <Form.Group className={"group"}>
                        <Form.Label>Email</Form.Label>
                        <Form.Control type={"email"} placeholder={"breecodes@gmail.com"} autoComplete={"false"}/>
                    </Form.Group>

                    <Form.Group className={"group"}>
                        <Form.Label>Password</Form.Label>
                        <Form.Control type={"password"} autoComplete={"false"}/>
                    </Form.Group>

                    <Form.Group className={"group"}>
                        <Form.Label>Confirm Password</Form.Label>
                        <Form.Control type={"password"} autoComplete={"false"}/>
                    </Form.Group>
                </Form>
            </div>
        </Container>
    );
}
