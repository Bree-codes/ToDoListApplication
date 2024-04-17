import {Button, Image, Offcanvas} from "react-bootstrap";
import profileImage from "../images/profileImage.jpeg";
import {useState} from "react";
import "./../Styles/main.css"

export const SideBar = () => {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return(
        <>
            <Button variant="primary" className="d-lg-none" onClick={handleShow}>
                Launch
            </Button>
            <Offcanvas show={show} onHide={handleClose} responsive="lg">
            <Offcanvas.Header className={"side-bar-header"} closeButton>
                <Image src={profileImage} height={50} width={50} className={"side-bar-image"} />
                <br />
                <span>{sessionStorage.getItem("username")}</span>
            </Offcanvas.Header>
            <Offcanvas.Body className={"side-bar"}>
                <div>
                    <div className={"col-lg-4"}>ACTIVITY</div>
                    <div className={"col-lg-3"}>START</div>
                    <div className={"col-lg-3"}>STOP</div>
                    <div className={"col-lg-1"}>ACTION</div>
                    <div className={"col-lg-4"}>ACTIVITY</div>
                    <div className={"col-lg-3"}>START</div>
                    <div className={"col-lg-3"}>STOP</div>
                    <div className={"col-lg-1"}>ACTION</div>
                </div>
            </Offcanvas.Body>
            </Offcanvas>
        </>
    );
}