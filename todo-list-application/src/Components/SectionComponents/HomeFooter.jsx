import ack from "./../images/footerLogo.svg"
import bree from './../images/BreeCodesGithub.svg'
import stevo from './../images/RedStevoGithub.svg'
import email from  './../images/emailIcon.svg'
import {Container} from "react-bootstrap";

export default function HomeFooter() {

    return (
        <Container style={{height: "137px", display: "flex", flexDirection: "column", alignItems: "center"}}>
            <div style={{height: "50%", display: "flex", justifyContent: "center", alignItems: "center"}}>
                <img src={ack} alt={"footer Logo"} style={{width: "auto", height: "100%", maxWidth: "100%",
                    maxHeight: "100%", justifyContent: "center"}}/>
            </div>
            <div style={{height: "50%", display: "flex", width: "100%"}}>
                <div style={{flex: 1, display: "flex", justifyContent: "flex-start", alignItems: "center"}}>
                    <img src={stevo} alt="stevo" style={{width: "10%", height: "30%", margin:"10px"}}
                         onClick={() => window.location.href="https://github.com/Red-stevo"}/>
                    <img src={email} alt="email" style={{width: "10%", height: "30%", margin:"10px"}}
                         onClick={() => window.location.href="https://github.com/Red-stevo"}/>
                </div>
                <div style={{flex: 1, display: "flex", justifyContent: "flex-end", alignItems: "center"}}>
                    <img src={bree} alt="bree" style={{width: "10%", height: "30%", margin:"10px"}}
                    onClick={() => window.location.href="https://github.com/Bree-codes/"}/>
                    <img src={email} alt="email" style={{width: "10%", height: "30%", margin:"10px"}}
                         onClick={() => window.location.href="https://github.com/Bree-codes/"}/>
                </div>
            </div>
        </Container>



    );
}
