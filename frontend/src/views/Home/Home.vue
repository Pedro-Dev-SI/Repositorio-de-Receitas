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

        <router-link to="/new-recipe"><a class="add-recipe-btn"><strong class="plus-sign">+</strong> Cadastrar receita</a></router-link>

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
      
            <tr>
              <td>Bolo de cenoura</td>
              <td>40 minutos</td>
              <td>Doce, Sobremesa</td>
              <td>John Taylor</td>
              <td>8 porções</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Ações</button>
                  <div class="dropdown-content">
                    <a href="#"><img class="select-icon" src="@/assets/eye.svg">Visualizar</a>
                    <a href="#"><img class="select-icon" src="@/assets/edit.svg">Editar</a>
                    <a href="#"><img class="select-icon" src="@/assets/trash.svg">Deletar</a>
                  </div>
                </div>
              </td>
            </tr>

            <tr>
              <td>Bolo de cenoura</td>
              <td>40 minutos</td>
              <td>Doce, Sobremesa</td>
              <td>John Taylor</td>
              <td>8 porções</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Ações</button>
                  <div class="dropdown-content">
                    <a href="#"><img class="select-icon" src="@/assets/eye.svg">Visualizar</a>
                    <a href="#"><img class="select-icon" src="@/assets/edit.svg">Editar</a>
                    <a href="#"><img class="select-icon" src="@/assets/trash.svg">Deletar</a>
                  </div>
                </div>
              </td>
            </tr>

            <tr>
              <td>Bolo de cenoura</td>
              <td>40 minutos</td>
              <td>Doce, Sobremesa</td>
              <td>John Taylor</td>
              <td>8 porções</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Ações</button>
                  <div class="dropdown-content">
                    <a href="#"><img class="select-icon" src="@/assets/eye.svg">Visualizar</a>
                    <a href="#"><img class="select-icon" src="@/assets/edit.svg">Editar</a>
                    <a href="#"><img class="select-icon" src="@/assets/trash.svg">Deletar</a>
                  </div>
                </div>
              </td>
            </tr>

            <tr>
              <td>Bolo de cenoura</td>
              <td>40 minutos</td>
              <td>Doce, Sobremesa</td>
              <td>John Taylor</td>
              <td>8 porções</td>
              <td>
                <div class="dropdown">
                  <button class="dropbtn">Ações</button>
                  <div class="dropdown-content">
                    <a href="#"><img class="select-icon" src="@/assets/eye.svg">Visualizar</a>
                    <a href="#"><img class="select-icon" src="@/assets/edit.svg">Editar</a>
                    <a href="#"><img class="select-icon" src="@/assets/trash.svg">Deletar</a>
                  </div>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
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

}
</script>

<style scoped lang="scss" src="./style.scss"/>