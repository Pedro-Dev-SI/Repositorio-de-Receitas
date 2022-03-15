<template>
  <div>

    <NavBar/>
    
    <div class="main">
      
      <div class="up-div">

        <div class="search-recipe">
          <h1>Receitas</h1>
          <hr>
          <input class="search-input" type="text" placeholder="Buscar por..." v-model="pesquisaReceita">
          <button class="search-btn" @click.prevent="$store.dispatch('listRecipies')"><img class="search-icon" src="@/assets/search.svg">Pesquisar</button>
        </div>

        <router-link style="text-decoration: none;" to="/new-recipe"><button class="add-recipe-btn"><strong class="plus-sign">+</strong> Cadastrar receita</button></router-link>

      </div>

      <div class="table-section" v-if="$store.state.receitas.length > 0">

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
      
            <tr v-for="receita in $store.state.receitas" :key="receita.id">
              <td>{{receita.nomeReceita}}</td>
              <td>{{receita.tempoPreparo}}</td>
              <td>{{receita.categoria}}</td>
              <td>{{$store.state.usuario.primeiroNome + ' ' + $store.state.usuario.ultimoNome}}</td>
              <td>{{receita.rendimentoDescricao + ' ' + receita.rendimentoUnidade}}</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Ações</button>
                  <div class="dropdown-content">
                    <a @click="$store.commit('showDetails', receita)" data-bs-toggle="modal" data-bs-target="#staticBackdrop"><img class="select-icon" src="@/assets/eye.svg">Visualizar</a>
                    <a @click="$store.commit('editRecipe', receita)"><img class="select-icon" src="@/assets/edit.svg">Editar</a>
                    <a @click="$store.dispatch('deleteRecipe', receita)"><img class="select-icon" src="@/assets/trash.svg">Deletar</a>
                  </div>
                </div>
              </td>
            </tr>

          </tbody>
        </table>
      </div>

      <div class="message-box" v-else>
        <img src="@/assets/mango.svg" alt="Frutas">
        <h2>Nenhuma receita encontrada</h2>
      </div>

      <!-- Modal Visulização-->
      <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h3 class="modal-title" id="staticBackdropLabel">{{$store.state.receita.nomeReceita}}</h3>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <p><strong>Tempo de preparo: </strong> {{$store.state.receita.tempoPreparo}}</p>
              <p><strong>Rendimento: </strong> {{$store.state.receita.rendimentoDescricao + ' ' + $store.state.receita.rendimentoUnidade}}</p>
              <p><strong>Categorias: </strong> {{$store.state.receita.categoria}}</p>

              <div class="ingredients-div">
                <h4>Ingredientes</h4>
                <hr>
                <ul v-for="(ingrediente, index) in $store.state.ingredientes" :key="index" >
                  <li>{{ ingrediente.quantidadeIngrediente + ' ' + ingrediente.unidadeMedida }} de {{ingrediente.nomeIngrediente}}</li>
                </ul>
              </div>

              <div class="preparation-div">
                <h4>Modo de preparo</h4>
                <hr>
                <ul v-for="(instrucao, index) in $store.state.instrucoes" :key="index">
                  <li>{{instrucao.passo}}</li>
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
              <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Deletar</button>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
  
</template>

<script>

import NavBar from '@/components/NavBar/NavBar.vue'

export default {
  name: 'Home',

  components: {
    NavBar,
  },

  computed: {

    pesquisaReceita: {
      get(){
        return this.$store.state.pesquisaReceita
      },
      set(nomeReceita){
        this.$store.commit('setPesquisaReceita', nomeReceita)
      }
    }

  },

  mounted(){
    
    this.$store.dispatch('listRecipies')
  }

}
</script>

<style scoped lang="scss" src="./style.scss"/>