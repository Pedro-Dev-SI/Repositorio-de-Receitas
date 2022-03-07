import api from './api.js';

export default{

   save:(data)=>{
      return api.post('new-user', data);
   }

   
}