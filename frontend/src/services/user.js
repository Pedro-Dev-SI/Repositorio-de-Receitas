import api from './api.js';

export default{

   save:(data)=>{
      return api.post('user/new-user', data);
   },

   findByEmail:(email)=>{
      return api.get(`user/verify-email?email=${email}`);
   }

   
}