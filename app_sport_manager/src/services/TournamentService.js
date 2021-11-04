import axios from "axios"
const CREATE_TOURNAMENT_REST_API_URL ="http://localhost:8080/tournament/add"
class TournamentService {

    create(data){
        return axios.post(CREATE_TOURNAMENT_REST_API_URL,data);
    }
}
export default new TournamentService()