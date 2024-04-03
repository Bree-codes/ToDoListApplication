import {Container, Nav, Navbar} from "react-bootstrap";
import {useState} from "react";

export default function HomeHeader() {

    const [signUpBg,setSignUpBg] = useState("transparent");
    const  [signInBg, setSignInBg] = useState("transparent")


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
                            <Nav.Link href="/signup" className={"p-1 m-1 ps-4 ms-2 px-3"}
                                      onMouseOver={() => setSignUpBg("lime")}
                                      onMouseLeave={() => setSignUpBg("transparent")}
                                      style={{justifyContent:"center", color:"white", background:signUpBg,
                                          borderRadius:20, zIndex:2, float:"-moz-initial", display:"flex",
                                      fontSize: 20, fontFamily: "serif"}}>SIGN UP</Nav.Link>
                            <Nav.Link href="/signin" className={"p-1 m-1 mb-2 ps-4 ms-2 px-3"}
                                      onMouseLeave={() => setSignInBg("transparent")}
                                      onMouseOver={() => setSignInBg("lime")}
                                      style={{justifyContent:"center", color:"white",background:signInBg,
                                          borderRadius:20, zIndex:2,display:"flex",
                                      fontFamily:"serif", fontSize: 20}}>SIGN IN</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    );
}
