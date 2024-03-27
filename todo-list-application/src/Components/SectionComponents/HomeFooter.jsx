import ack from "./../images/footerLogo.svg"
import {Container} from "react-bootstrap";

export default function HomeFooter() {
    return (
        <Container style={{height: 137, justifyContent: "center", display: "flex", alignItems: "center"}}>
            <div style={{height: 137, justifyContent: "center", display: "flex", alignItems: "center"}}>
                <img src={ack} alt={"footer Logo"}
                     style={{width: "100%", justifyContent: "center", motionRotation: "initial"}}/>
            </div>
        </Container>

    );
}
