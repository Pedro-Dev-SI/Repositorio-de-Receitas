<template>
  <div>

    <NavBar/>
    
    <div class="main">
      
      <div class="up-div">

        <div class="search-recipe">
          <h1>Receitas</h1>
          <hr>
          <input class="search-input" type="text" placeholder="Buscar por..." v-model="this.searchRecipe">
          <button class="search-btn" @click.prevent="listRecipies()"><img class="search-icon" src="@/assets/search.svg">Pesquisar</button>
        </div>

        <router-link style="text-decoration: none;" to="/new-recipe"><button class="add-recipe-btn"><strong class="plus-sign">+</strong> Cadastrar receita</button></router-link>

      </div>

      <div class="table-section" v-if="this.recipies.length > 0">

        <table class="table table-striped table-hover recipe-table">
          <thead>
            <tr>
              <th>Nome da receita</th>
              <th>Tempo de Preparo</th>
              <th>Categoria</th>
              <th>Chef</th>
              <th>Rendimento</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
      
            <tr v-for="recipe in this.recipies" :key="recipe.id">
              <td>{{recipe.nomeReceita}}</td>
              <td>{{recipe.tempoPreparo}}</td>
              <td>{{recipe.categoria}}</td>
              <td>John Taylor</td>
              <td>{{recipe.rendimentoDescricao + ' ' + recipe.rendimentoUnidade}}</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Ações</button>
                  <div class="dropdown-content">
                    <a @click="showDetails(recipe)" data-bs-toggle="modal" data-bs-target="#staticBackdrop"><img class="select-icon" src="@/assets/eye.svg">Visualizar</a>
                    <a @click="editRecipe(recipe)"><img class="select-icon" src="@/assets/edit.svg">Editar</a>
                    <a @click="deleteRecipe(recipe)"><img class="select-icon" src="@/assets/trash.svg">Deletar</a>
                  </div>
                </div>
              </td>
            </tr>

          </tbody>
        </table>
      </div>

      <div class="message-box" v-else>
        <img src="@/assets/mango.svg" alt="Frutas">
        <h2>Nenhuma receita cadastrada no sistema</h2>
      </div>

      <!-- Modal Visulização-->
      <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h3 class="modal-title" id="staticBackdropLabel">{{this.recipe.nomeReceita}}</h3>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <p><strong>Tempo de preparo: </strong> {{this.recipe.tempoPreparo}}</p>
              <p><strong>Rendimento: </strong> {{this.recipe.rendimentoDescricao + ' ' + this.recipe.rendimentoUnidade}}</p>
              <p><strong>Categorias: </strong> {{this.recipe.categoria}}</p>

              <div class="ingredients-div">
                <h4>Ingredientes</h4>
                <hr>
                <ul v-for="(ingredient, index) in this.ingredients" :key="index" >
                  <li>{{ ingredient.amount + ' ' + ingredient.amountUnit }} de {{ingredient.ingredient_name}}</li>
                </ul>
              </div>

              <div class="preparation-div">
                <h4>Modo de preparo</h4>
                <hr>
                <ul v-for="(instruction, index) in this.instructions" :key="index">
                  <li>{{instruction.step}}</li>
                </ul>
              </div>

            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
            </div>
          </div>
        </div>
      </div>

      <!-- Modal Exclusão-->
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title" id="exampleModalLabel">Confirmação</h4>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <p>Tem certeza que deseja remover esta receita ? Ao remove-la todos os usuários perderão acesso a ela.</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              <button type="button" class="btn btn-danger"  @click.prevent="deleteRecipe(recipe)" data-bs-dismiss="modal">Deletar</button>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
  
</template>

<script>

import NavBar from '@/components/NavBar/NavBar.vue'
import Recipe from '@/services/recipies.js'
import swal from 'sweetalert';


export default {
  name: 'Home',

  components: {
    NavBar,
  },

  data(){
    return{
      
      recipe:{
        id: undefined,
        nomeReceita: '',
        tempoPreparo: '',
        rendimentoDescricao: '',
        rendimentoUnidade: '',
        categoria: '',
        ingredientes: '',
        modoDePreparo: '',
      },

      searchRecipe: '',

      recipies: [],
      searchedRecipies: [],

      ingredients: [],
      instructions: [],


    }
  },

  mounted(){
    this.listRecipies();
    
  },

  methods:{

    listRecipies(){

      if(this.searchRecipe == ''){

        Recipe.listRecipies().then(response => {
  
          this.recipies = response.data.content
        })
      }else{  

        Recipe.listSearchedRecipies(this.searchRecipe).then(response => {
    
          this.recipies = response.data
        })
      }
      
     
    },


    showDetails(recipe){
      this.recipe = recipe;
      
      this.ingredients = JSON.parse(this.recipe.ingredientes);
      this.instructions = JSON.parse(this.recipe.modoDePreparo);
      
    },

    editRecipe(recipe){
      recipe.ingredientes = JSON.parse(recipe.ingredientes);
      recipe.modoDePreparo = JSON.parse(recipe.modoDePreparo);

      this.$router.push({
        name: 'UpdateRecipe',
        params: {
          id: recipe.id,
        }
      })
    },

    deleteRecipe(recipe){

      swal({
        title: "Tem certeza ?!",
        text: "Ao remover esta receita todos os usuários perderão acesso a ela.",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((willDelete) => {
        if (willDelete) {
          Recipe.delete(recipe.id).then(response => {
            console.log(response);
            this.listRecipies();
          })
          swal("Poof! Receita deletada com sucesso!", {
            icon: "success",
          });
        }
      });

      
    }
  }

}
</script>

<style scoped lang="scss" src="./style.scss"/>