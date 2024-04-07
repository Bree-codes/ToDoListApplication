import {useEffect, useState} from "react";
import {Auth} from "../SectionComponents/Auth.js";
import {useNavigate} from "react-router";
import './../Styles/main.css'
import {ActivityField} from "../SectionComponents/ActivityField.jsx";
import {Stack} from "react-bootstrap";

const MainPage = () => {
    const navigate = useNavigate();
    const [section, setSection] = useState([]);


    useEffect(() => {
            if(!Auth()){
                navigate('/signin');
            }
            else {
                // eslint-disable-next-line react/jsx-key
                setSection(() => [ <ActivityField handleAdding={handleAdding} />] );
            }
    }, [navigate]);

    const handleAdding = () => {
        setSection((prev) => {
            return [
                ...prev, // Spread the previous array elements
                // eslint-disable-next-line react/jsx-key
                <ActivityField key={section.length+1} handleAdding={handleAdding} />
            ];
        });
    }


    return (
        <div className={"main-container"}>
            <Stack className={"input-page"}>
                {section.map((sec) => {
                    return(sec);
                })}
            </Stack>

        </div>
    );
};

export default MainPage;
