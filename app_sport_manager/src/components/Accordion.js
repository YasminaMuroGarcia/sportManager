import React from "react";


const Accordion = ({title,active,setActive,bodyA}) => {
    return(
        <div className="accordion">
            <div className="accordionHeading">
                <div className="container">
                    <p>{title}</p>
                    <span onClick={() => setActive(title)}>
                        {active === title ? "X" : "|||"}
                    </span>
                </div>
            </div>
            <div className={(active === title ? "show" : "") + " accordionContent"}>
                <div className="container">
                    <p>
                        {bodyA}
                    </p>
                </div>
            </div>
        </div>
    );
};
export default Accordion;