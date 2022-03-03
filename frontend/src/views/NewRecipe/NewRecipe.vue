<template>

   <NavBar/>
   <div class="main">
      <h1>Cadastrar receita</h1>
      <hr>
      <div class="row">

         <div class="recipe-info">
            <form class="recipe-form">
               <div class="recipe-group-form">
                  <label>Nome da Receita: </label>
                  <input type="text" class="recipe-name-input">
               </div>
               
               <div class="recipe-group-form form-group-time-yield">
                  
                  <div class="time-prepare-section">
                     <label>Tempo de preparo: </label>
                     <input type="text" class="prepare-time-input">
                  </div>

                  <div class="yield-section">
                     <label>Rendimento: </label>
                     <div>
                        <input type="text" class="yield-input">
                        <select class="form-select" aria-label="Default select example">
                           <option selected>unidade(s)</option>
                           <option value="Porção">Porção</option>
                           <option value="Unidades">Unidade(s)</option>
                           <option value="Pessoas">Pessoas</option>
                        </select>
                     </div>
                  </div>
               </div>

               <div class="recipe-group-form">
                  <label>Categorias: </label><br>
                  <div class="checkboxes">
                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                           Salgado
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                           Doce
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                           Vegano
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                           Salada
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                           Almoço
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                           Sobremesa
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                           Fit
                        </label>
                     </div>

                     <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
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
               <input type="text" class="prepare-step-input">
               <button class="add-btn"><strong>+</strong>Adicionar</button>
            </form>

            <table class="table table-striped table-hover prepare-method-table">
               <thead>
                  <tr>
                  <th>Passo</th>
                  <th></th>
                  </tr>
               </thead>
               <tbody>
            
                  <tr>
                  <td>1 Pré aquecer o forno</td>
                  <td><a><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
                  </tr>

                  <tr>
                  <td>2 Colocar para assar</td>
                  <td><a><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
                  </tr>

                  <tr>
                  <td>3 Cozinhar o arroz</td>
                  <td><a><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
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
                  <input type="text" class="ingredient-name-input">
               </div>
               <div class="form-ingredients-group amount-div">
                  <label>Quantidade: </label><br>
                  <div class="flex">
                     <input type="text" class="amount-input">
                     <select class="form-select" aria-label="Default select example">
                        <option selected>unidade(s)</option>
                        <option value="g">gramas</option>
                        <option value="kg">quilo</option>
                        <option value="l">litro</option>
                        <option value="colher de sopa">colher de sopa</option>
                        <option value="xícara">xícara</option>
                        <option value="un">unidade</option>
                     </select>
                     <button class="add-btn"><strong>+</strong>Adicionar</button>
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
            
                  <tr>
                  <td>Arroz</td>
                  <td>500g</td>
                  <td><a><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
                  </tr>

                  <tr>
                  <td>Leite</td>
                  <td>3l</td>
                  <td><a><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
                  </tr>

                  <tr>
                  <td>Ovos</td>
                  <td>12un</td>
                  <td><a><img src="@/assets/trash.svg" class="trash-icon" alt=""></a></td>
                  </tr>
               </tbody>
            </table>


      </div>

      <div class="buttons">
         <button class="cancel-btn">Cancelar</button>
         <button class="save-btn"><strong>+</strong>Cadastrar</button>
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
}
</script>

<style scoped lang="scss" src="./style.scss"/>