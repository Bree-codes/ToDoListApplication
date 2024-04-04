import './../Styles/main.css'
import {Col, Form, Row} from "react-bootstrap";
import {TimeInput} from "./TimeInput.jsx";


export const ActivityField = () =>{



    return(
        <div className={'activity'}>
            <Form>
                <Row>
                    <Col lg className={'m-2 '}>
                        <label htmlFor="activity" className={'label'}>Activity: </label>
                        <Form.Control id='activity' placeholder="activity-name" className={'activity-name'}
                         />
                    </Col>
                    <Col lg className={'m-3 '}>
                        <label htmlFor="start" className={'label'}>Start: </label> <br/>
                        <TimeInput id={'start'} />
                    </Col>
                    <Col lg className={'m-3'}>
                        <label htmlFor="end" className={'label'}>End: </label> <br/>
                        <TimeInput id={"end"}  />
                    </Col>
                </Row>
            </Form>
        </div>
    )
}

