import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8082/api/';

class UserService {
  getUsers() {
    return axios.get(API_URL + 'auth/users', { headers: authHeader() });
  }

  createUser(user) {
    return axios.post(API_URL + 'auth/signup', user, { headers: authHeader() });
  }

  

  newForm(form) {
    return axios.post(API_URL + 'config/form/add', form, { headers: authHeader() });
  }

  saveForm(id, config) {
    return axios.post(API_URL + 'config/form/update/' + id, config, { headers: authHeader() });
  }

  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUserBoard() {
    return axios.get(API_URL + 'user', { headers: authHeader() });
  }

  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();
