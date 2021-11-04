import React from "react";
import "../css/SportHomePage.css";
import sportServices from "../services/SportServices";
import tournamentService from "../services/TournamentService";

 
class SportHomePage extends React.Component{
    constructor(props){
        super(props)
        this.state = {
          contestantType: 'players',
          name: '',
          gameId: '',
          numberPlayers: '',
          sports:[] ,
        }
      this.handleChangeTeams = this.handleChangeTeams.bind(this);
    };

    componentDidMount(){
        sportServices.getAll().then((Response)=>{
            this.setState({sports:Response.data})
        });
    }

    handleChangeName = event => {
        this.setState({ name: event.target.value });
    }
    handleChangeGame = event => {
        this.setState({ gameId: event.target.value });
    }
    handleChangeNumPlayers = event => {
        this.setState({ numberPlayers: event.target.value });
    }
    handleChangeTeams = event => {
        this.setState({ contestantType: event.target.value });
    }
    handleSubmit = event => {
        event.preventDefault();
        const tournament = { 
            name : this.state.name,
            contestantType: this.state.contestantType,
            gameId: this.state.gameId,
            numberPlayers: this.state.numberPlayers};
           console.log(tournament);
        tournamentService.create(tournament).then((Response)=>{
            console.log(Response.data);
        });
    }

    render(){
        return(
            <div className="flex">
            <div className="d-flex align-items-center justify-content-center" id="wrapper">
                <h1>BANNER</h1>
            </div>
            <div className="container col-3">
                <div>
                    <label className="col-5">Tournament Name</label>
                    <input className="col-7"  onChange={this.handleChangeName}></input>
                </div>
                <div>
                    <label className="col-5">Game</label>
                    
                    <select className="col-7" onChange={this.handleChangeGame} >
                        <option>Choose</option>
                        {
                            this.state.sports.map(
                                sport =>
                                <option value={sport.id} name={sport.name}>{sport.name}</option>
                            )
                        }
                    </select>
                </div>
               <div>
                    <label className="col-5">Nº Player</label>
                    <input className="col-7" type="number" id="points"  min="0" name="points" step="1" onChange={this.handleChangeNumPlayers} ></input>
               </div>
                
                <div>
                    <input type="radio" value="player" name="contestant" checked={this.state.contestantType === "players"} onChange={this.handleChangeTeams} /> Players
                    <input type="radio" name="contestant" value="teams"  checked={this.state.contestantType === "teams"}  onChange={this.handleChangeTeams}/> Teams
                </div>
                
                
                <button id="buttonCreate" onClick={this.handleSubmit}>Create Tournament</button>  
            </div> 
                      
        </div>
        )
    }
};
    
export default SportHomePage


