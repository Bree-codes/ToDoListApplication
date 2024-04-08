import {Button, Card} from "react-bootstrap";
import './../Styles/viewPage.css'

// eslint-disable-next-line react/prop-types
export const TodoViewCard = ({ date }) => {
    return(
        <Card style={{ width: '16rem', background:"transparent", border:"none", color:"white" }}>
            <Card.Body className={'date'}>
                <Card.Title>{date}</Card.Title>
                <Card.Text>
                    Some quick example text to build on the card title and make up the
                    bulk of the cards content.
                </Card.Text>
                <Button variant="outline-success">Get Started</Button>
            </Card.Body>
        </Card>
    )
}