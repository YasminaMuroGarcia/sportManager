import React from "react";
import sportServices from "../services/SportServices";
import {Navbar, Nav,Form,FormControl,Button}  from 'react-bootstrap';
import ModalSport from "./ModalSport";


class SportComponents extends React.Component{

    constructor(props){
        super(props)
        this.addCreatedSport = this.addCreatedSport.bind(this);
        this.state ={
            sports:[] ,
            
        }
    };
  
    modalSportRef = (obj) => {
        this.showModal = obj && obj.handleShow;
    }
     
    addSportClick = () => {
        this.showModal();
    }

    addCreatedSport(newSport){
        const updatedSports = this.state.sports.concat(newSport);
        this.setState({sports: updatedSports});
    }

    componentDidMount(){
        sportServices.getAll().then((Response)=>{
            this.setState({sports:Response.data})
        });
    }
  
    render(){

        return(
            <div>
                <Navbar bg="dark" variant="dark">
                  <Navbar.Brand href="#home">SportManager</Navbar.Brand>
                        <Nav className="mr-auto">
                            <Nav.Link href="#home">Home</Nav.Link>
                            <Nav.Link href="#features">Features</Nav.Link>
                            <Nav.Link href="#pricing">News</Nav.Link>
                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                            <Button variant="outline-info">Search</Button>
                        </Form>
                </Navbar>

               
                
                <h1 className = "text-center">Sport List</h1>
                <ModalSport ref={this.modalSportRef} addCreatedSport={this.addCreatedSport}  ></ModalSport>


                <div class="btn-group" role="group" aria-label="Basic example">
                    <button type="button" class="btn btn-secondary" onClick={this.addSportClick}>Add Sport</button>
                    <button type="button" class="btn btn-secondary">Edit Sport</button>
                    <button type="button" class="btn btn-secondary">Delete Sport</button>
                </div>
                
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <th>Sport Id</th>
                            <th>Name</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            this.state.sports.map(
                                sport =>
                                <tr key = {sport.id}>
                                    <td>{sport.id}</td>
                                    <td>{sport.name}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
                <div>                 
                    
                </div>
            </div> 

            
        )
    }
}export default SportComponents