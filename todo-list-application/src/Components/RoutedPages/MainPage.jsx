import {useEffect} from "react";
import {Auth} from "../SectionComponents/Auth.js";
import {useNavigate} from "react-router";
import './../Styles/main.css'
import {ActivityField} from "../SectionComponents/ActivityField.jsx";

const MainPage = () => {
const navigate = useNavigate();

    useEffect(() => {
            if(!Auth()){
                navigate('/signin');
            }
    }, [navigate]);

    return (
        <div className={"main-container"}>
            <ActivityField />
        </div>
    );
};

export default MainPage;
