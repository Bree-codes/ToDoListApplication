import {Alert} from "react-bootstrap";
import  './../Styles/home.css'

const NotFoundPage = () => {
    return (
        <div className={"error"}>
            <Alert className={'alert'}>404 PAGE NOT FOUND</Alert>
        </div>
    );
};

export default NotFoundPage;
