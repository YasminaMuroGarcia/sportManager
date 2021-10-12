import React from "react";
import sportServices from "../services/SportServices";
import {Navbar, Nav,Form,FormControl,Button}  from 'react-bootstrap';
import ModalSport from "./ModalSport";


class SportComponents extends React.Component{

    constructor(props){
        super(props)
        this.handleShow = this.handleShow.bind(this);
        this.handleClose = this.handleClose.bind(this);
        this.state ={
            sports:[] ,
            name: '' ,
            show : false,
            
            
        }
    };
  
    modalSportRef = (obj) => {
        this.showModal = obj && obj.handleShow;
      }
     
      addSportClick = () => {
       this.showModal();
      }

    handleChange = event => {
        this.setState({ name: event.target.value });
    }

    handleShow() {
        this.setState({ show: true })
    }
    handleClose(){
        this.setState({ show: false })
    }

    handleSubmit = event => {
        event.preventDefault();
    
        const sport = {
            name: this.state.name
        };
        console.log(sport)
        sportServices.create(sport);
    }
    componentDidMount(){
        sportServices.getSports().then((Response)=>{
            this.setState({sports:Response.data})
        });
        
        
        // Simple POST request with a JSON body using axios
        // const article = { title: 'React POST Request Example' };
        // axios.post('https://reqres.in/api/articles', article)
        //     .then(Response => this.setState({ sports:Response.data.id }));
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
                <ModalSport ref={this.modalSportRef} ></ModalSport>

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
                    <form onSubmit={this.handleSubmit}>
                    <label>
                        Sport Name:
                        <input type="text" name="name" onChange={this.handleChange} />
                    </label>
                    <button type="submit">Add</button>
                    </form>
                </div>

                <div>                 
                    
                </div>
            </div> 

            
        )
    }
}export default SportComponents