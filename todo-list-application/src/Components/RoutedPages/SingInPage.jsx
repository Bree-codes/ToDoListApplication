import './../Styles/Singin.css';
import {Form} from "react-bootstrap";
import './../Styles/singUp.css'

export default function SingInPage() {
    return (
        <div className="contain" >
            <div className="section">
                <Form>
                    <Form.Label className='label' >Sing In</Form.Label>

                    <Form.Group className='group'>
                        <Form.Label className='label' >Username</Form.Label>
                        <Form.Control type={"text"} placeholder={"Username"} />
                    </Form.Group>

                    <Form.Group className='group'>
                        <Form.Label className='label' >Password</Form.Label>
                        <Form.Control type={"password"} placeholder={"Username"} />
                    </Form.Group>

                </Form>
            </div>
        </div>
    );
}
