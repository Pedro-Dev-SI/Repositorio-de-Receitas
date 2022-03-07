import api from './api.js';

export default{


   listRecipies:()=>{
      return api.get('dashboard/recipies');
   },

   save:(data)=>{
      return api.post('dashboard/new-recipe', data);
   }

   
}