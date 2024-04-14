import {useRef, useState} from "react";
import {Button, Overlay} from "react-bootstrap";

// eslint-disable-next-line react/prop-types
export const  ActionButton = ({add, done, disable}) => {

        const [show, setShow] = useState(false);
        const target = useRef(null);

        return (
            <>
                <Button ref={target} onClick={() => setShow(!show)} disabled={disable}
                        className={"bg-light border-0 text-dark-emphasis mx-4 fw-bolder"}> Add </Button>
                    <Overlay target={target.current} show={show} placement="bottom-start">
                            {(props) => (
                                <div {...props} className={"bg-dark rounded-2"}>
                                    <Button className={"bg-dark border-0 text-light-emphasis mt-3 mx-3"}
                                    onClick={(e) =>{ add(e);
                                        setShow(!show);
                                    }}>Add List</Button>
                                    <hr className={"bg-light"} />
                                    <Button className={"bg-dark border-0 text-light-emphasis mb-3 mx-3"}
                                    onClick={(e) => {done(e);
                                        setShow(!show);
                                    }}>Submit List</Button>
                                </div>
                            )}
                    </Overlay>
            </>);
}