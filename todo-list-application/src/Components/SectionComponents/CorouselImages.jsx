import {Carousel} from "react-bootstrap";


const CarouselImages = () => {
    return (
        <Carousel>
            <Carousel.Item interval={1000}>
                <Carousel.Caption>
                    <h3>First slide label</h3>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>
    );
};

export default CarouselImages;