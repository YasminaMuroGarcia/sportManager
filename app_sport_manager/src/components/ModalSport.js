import React, { Component } from "react";
import { Modal,Button } from "react-bootstrap";
import sportServices from "../services/SportServices";


class ModalSport extends Component{

    constructor(props){
      super(props)
      this.handleShow = this.handleShow.bind(this);
      this.handleClose = this.handleClose.bind(this);
      this.state = {
        show: false,
        name: '' 
      }
      
    };

    
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
      const sport = { name : this.state.name};
      sportServices.create(sport).then((Response)=>{
        var addCreatedSport = this.props.addCreatedSport;
        console.log(Response.data);
        addCreatedSport(Response.data);
      });
      this.setState({ show: false })
  }

  

    render(){
        return(
          <Modal show={this.state.show} onHide={this.handleClose}>
          <Modal.Header closeButton>
          <Modal.Title>Create Sport</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <form>
              <div class="form-group row">
                  <label  class="col-sm-2 col-form-label">
                      Name*
                  </label>
                  <div class="col-sm-10">
                          <input class="form-control" type="text" name="name" onChange={this.handleChange} /> 
                  </div>
              </div>
            </form>
          </Modal.Body>
          <Modal.Footer>
          
          <Button variant="secondary" onClick={this.handleClose}>
              Close
          </Button>
          <Button variant="primary" onClick={this.handleSubmit}>
              Save Changes
          </Button>
          </Modal.Footer>
      </Modal>
        )
    }
    
}

export default ModalSport;
