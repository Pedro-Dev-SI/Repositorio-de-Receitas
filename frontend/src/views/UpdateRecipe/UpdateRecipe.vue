<template>

   <NavBar/>
   <div class="main">
      <h1>Editar Receita</h1>
      <hr>
      <div class="row">

         <div class="recipe-info">
            <form class="recipe-form">
               <div class="recipe-group-form">
                  <label>Nome da Receita: </label>
                  <input type="text" class="recipe-name-input" required v-model="this.recipe.nome_receita">
               </div>
               
               <div class="recipe-group-form form-group-time-yield">
                  
                  <div class="time-prepare-section">
                     <label>Tempo de preparo: </label>
                     <input type="text" class="prepare-time-input" required v-model="this.recipe.tempo_preparo">
                  </div>

                  <div class="yield-section">
                     <label>Rendimento: </label>
                     <div>
                        <input type="text" class="yield-input" required v-model="this.recipe.rendimento_descricao">
                        <select class="form-select" aria-label="Default select example" required v-model="this.recipe.rendimento_unidade">
                           <option selected>unidade(s)</option>
                           <option value="Porção">Porção</option>
                           <option value="Unidade">Unidade(s)</option>
                           <option value="Pessoas">Pessoa(s)</option>
                        </select>
                     </div>
                  </div>
               </div>

               <div class="recipe-group-form">
                  <label>Categorias: </label><br>
                  <div class="checkboxes">
                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="Salgado" id="salgado" v-model="this.recipe.categoria">
                        <label class="form-check-label" for="flexCheckDefault">
                           Salgado
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="Doce" id="flexCheckDefault" v-model="this.recipe.categoria">
                        <label class="form-check-label" for="flexCheckDefault">
                           Doce
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="Vegano" id="flexCheckDefault" v-model="this.recipe.categoria">
                        <label class="form-check-label" for="flexCheckDefault">
                           Vegano
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="Salada" id="flexCheckDefault" v-model="this.recipe.categoria">
                        <label class="form-check-label" for="flexCheckDefault">
                           Salada
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="Almoço" id="flexCheckDefault" v-model="this.recipe.categoria">
                        <label class="form-check-label" for="flexCheckDefault">
                           Almoço
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="Sobremesa" id="flexCheckDefault" v-model="this.recipe.categoria">
                        <label class="form-check-label" for="flexCheckDefault">
                           Sobremesa
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="Fit" id="flexCheckDefault" v-model="this.recipe.categoria">
                        <label class="form-check-label" for="flexCheckDefault">
                           Fit
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="Jantar" id="flexCheckDefault" v-model="this.recipe.categoria">
                        <label class="form-check-label" for="flexCheckDefault">
                           Jantar
                        </label>
                     </div>
                  </div>
               </div>

            </form>
         </div>

         <div class="prepare-method">
            <h2>Modo de preparo</h2>
            <form class="form-prepare-method">
               <label>Passo: </label><br>
               <input type="text" class="prepare-step-input" required v-model="this.newInstruction.step">
               <button class="add-btn" @click.prevent="addInstruction"><strong>+</strong>Adicionar</button>
            </form>

            <table class="table table-striped table-hover prepare-method-table">
               <thead>
                  <tr>
                  <th>Passo</th>
                  <th></th>
                  </tr>
               </thead>
               <tbody>
            
                  <tr v-for="(instruction, index) in instructions" :key="index">
                     <td>{{instruction.step}}</td>
                     <td><a @click.prevent="removeInstruction(index)"><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
                  </tr>

               </tbody>
            </table>
         </div>
      </div>

      <div class="ingredients">
            <h2>Ingredientes</h2>
            <form class="form-ingredients">
               <div class="form-ingredients-group">
                  <label>Nome do Ingrediente: </label><br>
                  <input type="text" class="ingredient-name-input" required v-model="this.newIngredient.ingredient_name">
               </div>
               <div class="form-ingredients-group amount-div">
                  <label>Quantidade: </label><br>
                  <div class="flex">
                     <input type="text" class="amount-input" required  v-model="this.newIngredient.amount">
                     <select class="form-select" aria-label="Default select example" required  v-model="this.newIngredient.amountUnit">
                        <option selected>unidade(s)</option>
                        <option value="g">gramas</option>
                        <option value="kg">quilo</option>
                        <option value="L">litro</option>
                        <option value="mg">miligramas</option>
                        <option value="un">unidade</option>
                     </select>
                     <button class="add-btn" @click.prevent="addIngredient"><strong>+</strong>Adicionar</button>
                  </div>
               </div>
            </form>

            <table class="table table-striped table-hover ingredients-table">
               <thead>
                  <tr>
                  <th>Ingrediente</th>
                  <th>Quantidade</th>
                  <th></th>
                  </tr>
               </thead>
               <tbody>
            
                  <tr v-for="(ingredient, index) in this.ingredients" :key="index">
                     <td>{{ingredient.ingredient_name}}</td>
                     <td>{{ingredient.amount + ' ' + ingredient.amountUnit}}</td>
                     <td><a @click.prevent="removeIngredient(index)"><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
                  </tr>

               </tbody>
            </table>


      </div>

      <div class="buttons">
         <router-link to="/home"><button class="cancel-btn">Cancelar</button></router-link>
         <button class="save-btn" @click.prevent="handleSubmit">Salvar</button>
      </div>

   </div>
</template>

<script>
import NavBar from '@/components/NavBar/NavBar.vue'
import Recipe from '@/services/recipies.js'


export default {

   name: 'NewRecipe',

   components: {
      NavBar
   },

   data(){
      return{

         id: this.$route.params.id,

         recipe:{
            id: undefined,
            nome_receita: '',
            tempo_preparo: '',
            rendimento_descricao: '',
            rendimento_unidade: '',
            categoria: [],
            ingredientes: '',
            modo_de_preparo: '',
         }, 

         ingredients: [],
         newIngredient:{},

         instructions: [],
         newInstruction:{},



      }
   },

   methods: {
      addIngredient(){

         if(this.newIngredient.ingredient_name == undefined || this.newIngredient.amount == undefined || this.newIngredient.amountUnit == undefined){
            alert('Preencha todos os campos');
         }else{
            this.ingredients.push(this.newIngredient);
            this.newIngredient = {}
         }
      },

      removeIngredient(index){
         this.ingredients.splice(index, 1)
      },

      addInstruction(){

         if(this.newInstruction.step == undefined){
            alert('Preencha todos os campos');
         }else{

            this.instructions.push(this.newInstruction)
            this.newInstruction = {}
         }
      },

      removeInstruction(index){
         this.instructions.splice(index, 1)
      },

      addCategory(event){
         this.recipe.categories += event.target.value + ','
         console.log(this.recipe.categories)
      },

      async handleSubmit(){

         let ingredientsStr = JSON.stringify(this.ingredients);
         let instructionsStr =   JSON.stringify(this.instructions);
         let categoriesStr = this.recipe.categoria.join(" | ");

         const data = {
            id: this.id,
            categoria: categoriesStr,
            ingredientes: ingredientsStr,
            modo_de_preparo: instructionsStr,
            nome_receita: this.recipe.nome_receita,
            rendimento_descricao: this.recipe.rendimento_descricao,
            rendimento_unidade: this.recipe.rendimento_unidade,
            tempo_preparo: this.recipe.tempo_preparo,
         }

         if(data.nome_receita == '' || data.tempo_preparo == '' || data.rendimento == '' || data.categoria == ''){
            alert('Preencha todos os campos');
         }else{

            Recipe.update(this.id, data).then(
               response => {
                  console.log(response);
                  alert('Receita alterada com sucesso!');
                  this.$router.push('/home');
               },
            )
         }
         
      }

   },

   created(){

      Recipe.getOne(this.id).then(response => {
         this.recipe = response.data;
         this.ingredients = JSON.parse(response.data.ingredientes);
         this.instructions = JSON.parse(response.data.modo_de_preparo);
         this.recipe.categoria = this.recipe.categoria.split('|');
         this.recipe.categoria = []
      })

      
   },



}
</script>

<style scoped lang="scss" src="./style.scss"/>