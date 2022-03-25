<template>

   <NavBar/>
   <div class="main">
      
      <div class="routes">
        <router-link to="/home"><a class="home-link">Home</a></router-link>
        <img src="@/assets/right-arrow.svg" alt="arrow" class="arrow">
        <a class="recipies-link">Receitas</a>
        <img src="@/assets/right-arrow.svg" alt="arrow" class="arrow">
        <a class="recipies-link">Cadastrar</a>
      </div>

      <h1>Cadastrar receita</h1>
      <hr>
      <div class="row">
         <div class="column">

            <div class="recipe-info">
               <form class="recipe-form">
                  <div class="recipe-group-form">
                     <label>Nome da Receita: </label>
                     <input type="text" class="recipe-name-input" required v-model="nomeReceita">
                  </div>
                  
                  <div class="recipe-group-form form-group-time-yield">
                     
                     <div class="time-prepare-section">
                        <label>Tempo de preparo: </label>
                        <input type="text" class="prepare-time-input" required v-model="tempoPreparo">
                     </div>

                     <div class="yield-section">
                        <label>Rendimento: </label>
                        <div>
                           <input type="text" class="yield-input" required v-model="rendimentoDescricao">
                           <select class="form-select" aria-label="Default select example" required v-model="rendimentoUnidade">
                              <option selected>unidade(s)</option>
                              <option value="porção">porção</option>
                              <option value="un">unidade(s)</option>
                              <option value="pessoas">pessoa(s)</option>
                              <option value="L">litros</option>
                              <option value="ml">mililitros</option>
                              <option value="g">gramas</option>
                              <option value="mg">miligramas</option>
                           </select>
                        </div>
                     </div>
                  </div>

                  <div class="recipe-group-form">
                     <label>Categorias: </label><br>
                     <div class="checkboxes">
                        <div class="form-check">
                           <input class="form-check-input" type="checkbox" value="Salgado" id="salgado" v-model="categoria">
                           <label class="form-check-label" for="flexCheckDefault">
                              Salgado
                           </label>
                        </div>

                        <div class="form-check">
                           <input class="form-check-input" type="checkbox" value="Doce" id="flexCheckDefault" v-model="categoria">
                           <label class="form-check-label" for="flexCheckDefault">
                              Doce
                           </label>
                        </div>

                        <div class="form-check">
                           <input class="form-check-input" type="checkbox" value="Vegano" id="flexCheckDefault" v-model="categoria">
                           <label class="form-check-label" for="flexCheckDefault">
                              Vegano
                           </label>
                        </div>

                        <div class="form-check">
                           <input class="form-check-input" type="checkbox" value="Salada" id="flexCheckDefault" v-model="categoria">
                           <label class="form-check-label" for="flexCheckDefault">
                              Salada
                           </label>
                        </div>

                        <div class="form-check">
                           <input class="form-check-input" type="checkbox" value="Almoço" id="flexCheckDefault" v-model="categoria">
                           <label class="form-check-label" for="flexCheckDefault">
                              Almoço
                           </label>
                        </div>

                        <div class="form-check">
                           <input class="form-check-input" type="checkbox" value="Sobremesa" id="flexCheckDefault" v-model="categoria">
                           <label class="form-check-label" for="flexCheckDefault">
                              Sobremesa
                           </label>
                        </div>

                        <div class="form-check">
                           <input class="form-check-input" type="checkbox" value="Fit" id="flexCheckDefault" v-model="categoria">
                           <label class="form-check-label" for="flexCheckDefault">
                              Fit
                           </label>
                        </div>

                        <div class="form-check">
                           <input class="form-check-input" type="checkbox" value="Jantar" id="flexCheckDefault" v-model="categoria">
                           <label class="form-check-label" for="flexCheckDefault">
                              Jantar
                           </label>
                        </div>
                     </div>
                  </div>

               </form>
            </div>

            <div class="ingredients">
               <h2>Ingredientes</h2>
               <form class="form-ingredients">
                  <div class="form-ingredients-group">
                     <label>Nome do Ingrediente: </label><br>
                     <input type="text" class="ingredient-name-input" required v-model="nomeIngrediente">
                  </div>
                  <div class="form-ingredients-group amount-div">
                     <label>Quantidade: </label><br>
                     <div class="flex">
                        <input type="text" class="amount-input" required  v-model="quantidade">
                        <select class="form-select" aria-label="Default select example" required  v-model="unidadeMedida">
                           <option selected>unidade(s)</option>
                           <option value="g">gramas</option>
                           <option value="kg">quilo</option>
                           <option value="L">litro</option>
                           <option value="mg">miligramas</option>
                           <option value="ml">mililitros</option>
                           <option value="un">unidade</option>
                        </select>
                        <button class="add-btn" @click.prevent="$store.commit('addIngredient')"><strong>+</strong>Adicionar</button>
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
               
                     <tr v-for="(ingrediente, index) in $store.state.ingredientes" :key="index">
                        <td>{{ingrediente.nomeIngrediente}}</td>
                        <td>{{ingrediente.quantidadeIngrediente + ' ' + ingrediente.unidadeMedida}}</td>
                        <td><a @click.prevent="$store.commit('removeIngredient', index)"><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
                     </tr>
                  </tbody>
               </table>
            </div>
         </div>

         <div class="prepare-method">
            <h2>Modo de preparo</h2>
            <form class="form-prepare-method">
               <label>Passo: </label><br>
               <input type="text" class="prepare-step-input" required v-model="modoDePreparo">
               <button class="add-btn" @click.prevent="$store.commit('addInstruction')"><strong>+</strong>Adicionar</button>
            </form>

            <table class="table table-striped table-hover prepare-method-table">
               <thead>
                  <tr>
                  <th>Passo</th>
                  <th></th>
                  </tr>
               </thead>
               <tbody>
               
                  <tr v-for="(instrucao, index) in $store.state.instrucoes" :key="index">
                     <td> <strong>{{index}} -</strong> {{instrucao.passo}}</td>
                     <td><a @click.prevent="$store.commit('removeInstruction', index)"><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
                  </tr>

               </tbody>
            </table>
         </div>
      </div>
      
      <div class="buttons">
         <router-link to="/home"><button class="cancel-btn">Cancelar</button></router-link>
         <button class="save-btn" @click.prevent="$store.dispatch('handleSubmitRecipe')"><strong>+</strong>Cadastrar</button>
      </div>

   </div>
</template>

<script>
import NavBar from '@/components/NavBar/NavBar.vue'

export default {

   name: 'NewRecipe',

   components: {
      NavBar
   },

   computed: {
      nomeReceita: {
         get(){
            return this.$store.state.receita.nomeReceita
         },
         set(nomeReceita){
            this.$store.commit('setNomeReceita', nomeReceita)
         }
      },

      tempoPreparo: {
         get(){
            return this.$store.state.receita.tempoPreparo
         },
         set(tempoPreparo){
            this.$store.commit('setTempoPreparo', tempoPreparo)
         }
      },

      rendimentoDescricao: {
         get(){
            return this.$store.state.receita.rendimentoDescricao
         },
         set(rendimentoDescricao){
            this.$store.commit('setRendimentoDescricao', rendimentoDescricao)
         }
      },

      rendimentoUnidade: {
         get(){
            return this.$store.state.receita.rendimentoUnidade
         },
         set(rendimentoUnidade){
            this.$store.commit('setRendimentoUnidade', rendimentoUnidade)
         }
      },

      categoria: {
         get(){
            return this.$store.state.receita.categoria
         },
         set(categoria){
            this.$store.commit('setCategoria', categoria)
         }
      },

      nomeIngrediente: {
         get(){
            return this.$store.state.novoIngrediente.nomeIngrediente
         },
         set(nomeIngrediente){
            this.$store.commit('setNomeIngrediente', nomeIngrediente)
         }
      },

      quantidade: {
         get(){
            return this.$store.state.novoIngrediente.quantidadeIngrediente
         },
         set(quantidade){
            this.$store.commit('setQuantidadeIngrediente', quantidade)
         }
      },

      unidadeMedida: {
         get(){
            return this.$store.state.novoIngrediente.unidadeMedida
         },
         set(unidadeMedida){
            this.$store.commit('setUnidadeMedida', unidadeMedida)
         }
      },

      modoDePreparo: {
         get(){
            return this.$store.state.receita.modoDePreparo
         },
         set(modoDePreparo){
            this.$store.commit('setModoDePreparo', modoDePreparo)
         }
      },

      
   },



}
</script>

<style scoped lang="scss" src="./style.scss"/>