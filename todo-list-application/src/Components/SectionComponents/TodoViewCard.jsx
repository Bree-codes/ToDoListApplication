import {Button, Card} from "react-bootstrap";

// eslint-disable-next-line react/prop-types
export const TodoViewCard = ({ date }) => {
    return(
        <Card style={{ width: '18rem' }}>
            <Card.Img variant="top" src="holder.js/100px180" alt={"todo list card image"} />
            <Card.Body>
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