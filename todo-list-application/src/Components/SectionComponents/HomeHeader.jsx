import {Container, Nav, Navbar} from "react-bootstrap";
import {useState} from "react";

export default function HomeHeader() {

    const [singUpBg,setSingUpBg] = useState("transparent");
    const  [singInBg, setSingInBg] = useState("transparent")


    return (
        <div style={{height:137}}>
            <Navbar expand="lg" style={{background:"none", justifyContent:"end"}}>
                <Container fluid style={{justifyContent:"end"}} >
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll" style={{justifyContent:"end"}}>
                        <Nav
                            className="my-2 my-lg-0"
                            style={{ maxHeight: '100px', justifyContent:"center"}}
                            navbarScroll>
                            <Nav.Link href="/singup" className={"p-1 m-1 ps-2 ms-2"}
                                      onMouseOver={() => setSingUpBg("lime")}
                                      onMouseLeave={() => setSingUpBg("transparent")}
                                      style={{justifyContent:"center", color:"white", background:singUpBg,
                                          borderRadius:20, zIndex:2, float:"-moz-initial",
                                      fontSize: 20, fontFamily: "serif"}}>SING UP</Nav.Link>
                            <Nav.Link href="/singin" className={"p-1 m-1 mb-2 ps-2 ms-2"}
                                      onMouseLeave={() => setSingInBg("transparent")}
                                      onMouseOver={() => setSingInBg("lime")}
                                      style={{justifyContent:"center", color:"white",background:singInBg,
                                          borderRadius:20, zIndex:2,
                                      fontFamily:"serif", fontSize: 20}}>SING IN</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    );
}
