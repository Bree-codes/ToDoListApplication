import {Button, Col, Image, Offcanvas} from "react-bootstrap";
import profileImage from "../images/profileImage.jpeg";
import {useState} from "react";

export const SideBar = () => {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return(
        <>
            <Button variant="primary" className="d-lg-none" onClick={handleShow}>
                Launch
            </Button>
            <Offcanvas show={show} onHide={handleClose} responsive="md">
            <Offcanvas.Header closeButton>
                <Col className={"side-bar-header"}>
                    <div>
                        <Image src={profileImage} height={50} width={50} className={"side-bar-image"} />
                        <br />
                        <span>{sessionStorage.getItem("username")}</span>
                    </div>
                </Col>
            </Offcanvas.Header>
            <Offcanvas.Body>
            </Offcanvas.Body>
            </Offcanvas>
        </>
    );
}