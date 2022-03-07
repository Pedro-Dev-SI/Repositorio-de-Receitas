<template>
  <div>

    <NavBar/>
    
    <div class="main">
      
      <div class="up-div">

        <div class="search-recipe">
          <h1>Receitas</h1>
          <hr>
          <input class="search-input" type="text" placeholder="Buscar por...">
          <button class="search-btn"><img class="search-icon" src="@/assets/search.svg">Pesquisar</button>
        </div>

        <router-link style="text-decoration: none;" to="/new-recipe"><button class="add-recipe-btn"><strong class="plus-sign">+</strong> Cadastrar receita</button></router-link>

      </div>

      <div class="table-section">

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
              <td>{{recipe.nome_receita}}</td>
              <td>{{recipe.tempo_preparo}}</td>
              <td>{{recipe.categoria}}</td>
              <td>John Taylor</td>
              <td>{{recipe.rendimento}}</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Ações</button>
                  <div class="dropdown-content">
                    <a @click="showDetails(recipe)" data-bs-toggle="modal" data-bs-target="#staticBackdrop"><img class="select-icon" src="@/assets/eye.svg">Visualizar</a>
                    <a><img class="select-icon" src="@/assets/edit.svg">Editar</a>
                    <a><img class="select-icon" src="@/assets/trash.svg">Deletar</a>
                  </div>
                </div>
              </td>
            </tr>

          </tbody>
        </table>
      </div>

      <!-- Modal -->
      <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h3 class="modal-title" id="staticBackdropLabel">{{this.recipe.nome_receita}}</h3>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <p><strong>Tempo de preparo: </strong> {{this.recipe.tempo_preparo}}</p>
              <p><strong>Rendimento: </strong> {{this.recipe.rendimento}}</p>
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

    </div>
  </div>
  
</template>

<script>

import NavBar from '@/components/NavBar/NavBar.vue'
import Recipe from '@/services/recipies.js'

export default {
  name: 'Home',

  components: {
    NavBar,
  },

  data(){
    return{
      
      recipe:{
        id: undefined,
        nome_receita: '',
        tempo_preparo: '',
        rendimento: '',
        categoria: '',
        ingredientes: '',
        modo_de_preparo: '',
      },
      recipies: [],

      ingredients: [],
      instructions: [],

    }
  },

  mounted(){
    this.listRecipies();
    
  },

  methods:{

    listRecipies(){
      Recipe.listRecipies().then(response => {

        console.log(response);
        this.recipies = response.data.content
      })
    },

    showDetails(recipe){
      this.recipe = recipe;
      
      this.ingredients = JSON.parse(this.recipe.ingredientes);
      this.instructions = JSON.parse(this.recipe.modo_de_preparo);
      
    }
  }

}
</script>

<style scoped lang="scss" src="./style.scss"/>