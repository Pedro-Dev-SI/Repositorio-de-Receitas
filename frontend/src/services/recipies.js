import api from './api.js';

export default{


   listRecipies:()=>{
      return api.get('dashboard/recipies');
   },

   save:(data)=>{
      return api.post('dashboard/new-recipe', data);
   },

   update:(id, data)=>{
      return api.put(`dashboard/update-recipe/${id}`, (id, data));
   },

   getOne:(id)=>{
      return api.get('dashboard/' + id);
   },

   delete:(id)=>{
      return api.delete('dashboard/' + id);
   }

   
}