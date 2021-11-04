import axios from "axios"
const SPORT_REST_API_URL ="http://localhost:8080/sport/all"
const CREATE_SPORT_REST_API_URL ="http://localhost:8080/sport"
class SportServices {
    getAll(){
        return axios.get(SPORT_REST_API_URL);
    }
    create(data){
        return axios.post(CREATE_SPORT_REST_API_URL,data);
    }
}
export default new SportServices();