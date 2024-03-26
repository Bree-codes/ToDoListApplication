import {Carousel} from "react-bootstrap";
import motivation1 from './../images/motivation1.jpeg'
import motivation2 from './../images/motivation2.jpeg'
import motivation3 from './../images/motivation3.jpeg'
import motivation4 from './../images/motivation4.jpeg'
import motivation5 from './../images/motivation5.jpeg'
import motivation6 from './../images/motivation6.jpeg'
import motivation7 from './../images/motivation7.jpeg'
import motivation8 from './../images/motivation8.jpeg'
import motivation9 from './../images/motivation9.jpeg'
import motivation10 from './../images/motivation10.jpeg'
import motivation11 from './../images/motivation11.jpeg'
import motivation12 from './../images/motivation12.jpeg'
import motivation13 from './../images/motivation13.jpeg'
import motivation14 from './../images/motivation14.jpeg'
import motivation15 from './../images/motivation15.jpeg'
import motivation16 from './../images/motivation16.jpeg'


const HomePageImages = () => {


    const images = [motivation1,
        motivation2,motivation3,motivation4,motivation5,
        motivation6,motivation7,motivation8,motivation9,
        motivation10,motivation11,motivation12,motivation13,
        motivation14,motivation15,motivation16];

    return (
        <Carousel interval={1000}>
            {images.map((value, index) => (
                <Carousel.Item key={index}>
                    <img src={value} className="d-block w-100" height={509} alt={"Motivation quote image"} />
                </Carousel.Item>
            ))}
        </Carousel>
    );
};

export default HomePageImages;