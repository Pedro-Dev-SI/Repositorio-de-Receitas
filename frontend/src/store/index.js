import { createStore } from 'vuex'
import Recipe from '@/services/recipies.js'
import router from '@/router/index.js'
import swal from 'sweetalert';

export default createStore({
  state: {

    receita: {
      id: undefined,
      nomeReceita: '',
      tempoPreparo: '',
      rendimentoDescricao: '',
      rendimentoUnidade: '',
      categoria: [],
      ingredientes: '',
      modoDePreparo: '',
    },
    receitas: [],
    pesquisaReceita: '',
    receitasPesquisadas: [],

    ingredientes: [],
    novoIngrediente:{},

    instrucoes: [],
    novaInstrucao:{},

    usuario: {
      primeiroNome: 'John',
      ultimoNome: 'Taylor',
      email: '',
      senha: '',
      confirmarSenha: '',
      valid: true,
    }

  },

  mutations: {

    //HOME
    listRecepies(state, data){
      state.receitas = data
    },

    showDetails(state, receita){
      state.receita = receita;
      
      state.ingredientes = JSON.parse(state.receita.ingredientes);
      state.instrucoes = JSON.parse(state.receita.modoDePreparo);
    },

    editRecipe(state, receita){

      receita.ingredientes = JSON.parse(receita.ingredientes);
      receita.modoDePreparo = JSON.parse(receita.modoDePreparo);

      router.push({
        name: 'UpdateRecipe',
        params: {
          id: receita.id,
        }
      })
    },
    
    //HOME - SETTERS
    setPesquisaReceita(state, nomeReceita){
      state.pesquisaReceita = nomeReceita;
    },

    //NEW-RECIPE
    addIngredient(state){

      if(!state.novoIngrediente.nomeIngrediente == '' || !state.novoIngrediente.quantidadeIngrediente == '' || !state.novoIngrediente.unidadeMedida == ''){
        state.ingredientes.push(state.novoIngrediente);
        state.novoIngrediente = {}
      }

      
    },

    removeIngredient(state, index){
      state.ingredientes.splice(index, 1)
    },

    addInstruction(state){

      if(!state.novaInstrucao.passo == ''){
        state.instrucoes.push(state.novaInstrucao)
        state.novaInstrucao = {}
      }
    },

    removeInstruction(state, index){
      state.instrucoes.splice(index, 1)
    },

    addCategory(state, event){
      state.receita.categoria += event.target.value + ','
      console.log(this.recipe.categoria)
    },

    //NEW-RECIPE - SETTERS
    setNomeReceita(state, nomeReceita){
      state.receita.nomeReceita = nomeReceita;
    },

    setTempoPreparo(state, tempoPreparo){
      state.receita.tempoPreparo = tempoPreparo;
    },

    setRendimentoDescricao(state, rendimentoDescricao){
      state.receita.rendimentoDescricao = rendimentoDescricao;
    },

    setRendimentoUnidade(state, rendimentoUnidade){
      state.receita.rendimentoUnidade = rendimentoUnidade;
    },

    setCategoria(state, categoria){
      state.receita.categoria = categoria;
    },

    setNomeIngrediente(state, nomeIngrediente){
      state.novoIngrediente.nomeIngrediente = nomeIngrediente;
    },

    setQuantidadeIngrediente(state, quantidadeIngrediente){
      state.novoIngrediente.quantidadeIngrediente = quantidadeIngrediente;
    },

    setUnidadeMedida(state, unidadeMedida){
      state.novoIngrediente.unidadeMedida = unidadeMedida;
    },

    setModoDePreparo(state, modoDePreparo){
      state.novaInstrucao.passo = modoDePreparo;
    }


  },

  actions: {

    //Home
    listRecipies({ commit }){

      if(this.state.pesquisaReceita == ''){

        Recipe.listRecipies().then(response => {
  
          commit('listRecepies', response.data.content)
        })
      }else{  

        Recipe.listSearchedRecipies(this.state.pesquisaReceita).then(response => {
    
          commit('listRecepies', response.data)
        })
      }
      
     
    },

    deleteRecipe(state, receita){

      swal({
        title: "Tem certeza ?!",
        text: "Ao remover esta receita todos os usuários perderão acesso a ela.",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((willDelete) => {
        if (willDelete) {
          Recipe.delete(receita.id).then(response => {
            console.log(response);
            this.dispatch('listRecipies');
          })
          swal("Poof! Receita deletada com sucesso!", {
            icon: "success",
          });
        }
      });

      
    },

    //New-Recipe
    handleSubmitRecipe(){

      let ingredientesStr = JSON.stringify(this.state.ingredientes);
      let instrucoesStr =   JSON.stringify(this.state.instrucoes);
      let categoriasStr = this.state.receita.categoria.join(" | ");

      const data = {
        categoria: categoriasStr,
        ingredientes: ingredientesStr,
        modoDePreparo: instrucoesStr,
        nomeReceita: this.state.receita.nomeReceita,
        rendimentoDescricao: this.state.receita.rendimentoDescricao,
        rendimentoUnidade: this.state.receita.rendimentoUnidade,
        tempoPreparo: this.state.receita.tempoPreparo,
      }

      if(data.nomeReceita == '' || data.tempoPreparo == '' || data.rendimentoDescricao == '' || data.rendimentoUnidade == ''|| data.categoria == ''){
        swal('Oops', 'Preencha todos os dados da receita', 'error');
      }else{

        Recipe.save(data).then(
          swal('Yeeeeaah', 'Receita cadastrada com sucesso!', 'success'),
          this.dispatch('listRecipies'),
          router.push('/home')
        )
      }
    },
  },
  modules: {
  }
})
