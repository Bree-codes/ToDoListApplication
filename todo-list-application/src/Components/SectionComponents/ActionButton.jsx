import {useRef, useState} from "react";
import {Button, Overlay, Tooltip} from "react-bootstrap";

export const  ActionButton = () => {

        const [show, setShow] = useState(false);
        const target = useRef(null);

        return (
            <>
                <Button ref={target} onClick={() => setShow(!show)} className={"mx-md-0 ma-lg-3"}> : </Button>
                    <Overlay target={target.current} show={show} placement="bottom-start">
                            {(props) => (
                                <Tooltip {...props}>
                                        My Tooltip
                                </Tooltip>
                            )}
                    </Overlay>
            </>);
}