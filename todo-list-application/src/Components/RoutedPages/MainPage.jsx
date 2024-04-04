import {useEffect} from "react";
import {Auth} from "../SectionComponents/Auth.js";
import {useNavigate} from "react-router";

const MainPage = () => {
const navigate = useNavigate();

    useEffect(() => {
            if(!Auth()){
                navigate('/signin');
            }
    }, [navigate]);

    return (
        <div>
            <h1>The Main Page</h1>
        </div>
    );
};

export default MainPage;
