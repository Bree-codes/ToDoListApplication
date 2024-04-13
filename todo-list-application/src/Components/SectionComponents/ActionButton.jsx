import {useRef, useState} from "react";
import {Overlay, Tooltip} from "react-bootstrap";

export const  ActionButton = () => {

        const [show, setShow] = useState(false);
        const target = useRef(null);

        return (
            <>
                <button ref={target} onClick={() => setShow(!show)}> : </button>
                <Overlay target={target.current} show={show} placement="right">
                    {(props) => (
                        <Tooltip id="overlay-example" {...props}>
                            My Tooltip
                        </Tooltip>
                    )}
                </Overlay>
            </>);
}