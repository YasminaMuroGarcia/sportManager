import React, { Component } from "react";
import { Modal,Button } from "react-bootstrap";
import sportServices from "../services/SportServices";
class ModalSport extends Component{

    constructor(props){
      super(props)
      this.handleShow = this.handleShow.bind(this);
      this.handleClose = this.handleClose.bind(this);
      this.state = {
        show: false
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
  
      const sport = {
          name: this.state.name
      };
      console.log(sport)
      sportServices.create(sport);
      this.setState({ show: false })
  }

    render(){
        return(
          <Modal show={this.state.show} onHide={this.handleClose}>
          <Modal.Header closeButton>
          <Modal.Title>Modal Heading</Modal.Title>
          </Modal.Header>
          <Modal.Body>Woohoo, you're reading this text in a modal!
          <form>
                    <label>
                        Sport Name:
                        <input type="text" name="name" onChange={this.handleChange} />
                    </label>
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
