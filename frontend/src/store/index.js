import { createStore } from 'vuex'
import Recipe from '@/services/recipies.js'
import User from '@/services/user.js';
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

    page: { 
      pageNumber: 0,
      totalPages: 0,
    },
    pages: [],

    usuario: {
      primeiroNome: '',
      ultimoNome: '',
      email: '',
      senha: '',
      confirmarSenha: '',
      valid: true,
    }

  },

  mutations: {

    /* ---------- HOME ---------- */
    listRecepies(state, data){
      state.receitas = data
    },

    showDetails(state, receita){
      state.receita = receita;
      
      state.ingredientes = JSON.parse(state.receita.ingredientes);
      state.instrucoes = JSON.parse(state.receita.modoDePreparo);
    },

    editRecipe(state, receita){

      state.receita = receita;

      console.log(state.receita)

      router.push({
        name: 'UpdateRecipe',
        params: {
          id: state.receita.id
        }
      })
    },

    getDefaultRecipeState(state){
      state.receita = {
        id: undefined,
        nomeReceita: '',
        tempoPreparo: '',
        rendimentoDescricao: '',
        rendimentoUnidade: '',
        categoria: [],
        ingredientes: '',
        modoDePreparo: '',
      }

      state.ingredientes = [];
      state.instrucoes = [];
    },
    
    //HOME - SETTERS
    setPesquisaReceita(state, nomeReceita){
      state.pesquisaReceita = nomeReceita;
    },

    /* ---------------------------------------- */

    /* ---------- NEW RECIPE ---------- */
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
    },
    /* ---------------------------------------- */

    /* ---------- PAGES ---------- */

    listPages(state, data){
      state.page.totalPages = data.totalPages;
      state.page.pageNumber = data.pageable.pageNumber;
      let cont = data.totalPages
      for (let i = 1; i <= cont; i++) {
        state.pages.push(i);
      }
      
    },

    /* ---------- USER ---------- */

    getDefaultUserState(state){
      state.usuario = {
        primeiroNome: '',
        ultimoNome: '',
        email: '',
        senha: '',
        confirmarSenha: '',
        valid: true,
      }
    },

    //USER - SETTERS
    setPrimeiroNome(state, primeiroNome){
      state.usuario.primeiroNome = primeiroNome;
    },

    setUltimoNome(state, ultimoNome){
      state.usuario.ultimoNome = ultimoNome;
    },

    setEmail(state, email){
      state.usuario.email = email;
    },

    setSenha(state, senha){
      state.usuario.senha = senha;
    },

    setConfirmarSenha(state, confirmarSenha){
      state.usuario.confirmarSenha = confirmarSenha;
    }

  },

  actions: {

    /* ---------- HOME ---------- */
    listRecipies({ commit }, index){

      if(this.state.pesquisaReceita == ''){

        Recipe.listRecipies(index).then(response => {
          this.state.pages = [];
          commit('listPages', response.data);
          commit('listRecepies', response.data.content);
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

    /* ---------------------------------------- */
    
    /* ---------- NEW RECIPE ---------- */
    handleSubmitRecipe(){

      let ingredientesStr = JSON.stringify(this.state.ingredientes);
      let instrucoesStr =   JSON.stringify(this.state.instrucoes);
      let categoriasStr = this.state.receita.categoria.join(" | ");

      const data = {
        id: this.state.receita.id,
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

    /* ---------------------------------------- */

    /* ---------- USER ---------- */
    handleSubmitUser(){

      const data = {
        primeiroNome: this.state.usuario.primeiroNome,
        ultimoNome: this.state.usuario.ultimoNome,
        email: this.state.usuario.email,
        senha: this.state.usuario.senha,
        confirmarSenha: this.state.usuario.confirmarSenha,
      }

      if(data.primeiroNome == undefined || data.ultimoNome == undefined || data.email == undefined || data.senha == undefined || data.confirmarSenha == undefined) {
        alert('Preencha todos os campos');
        return;
      }else if(data.senha != data.confirmarSenha) {
        this.state.usuario.valid = false;
        return;
      }

      User.findByEmail(data.email).then(response => {
        
        if(response.data){
          swal('Oops', 'Este usuário ja está cadastrado', 'error');
          this.state.usuario.email = '';
          return;
        }else{
          User.save(data).then(
            swal('Yeeeeaah', 'Cadastro realizado com sucesso!', 'success'),
            this.commit('getDefaultUserState'),
            router.push('/')
          );
        }
      })
      
    }
  },
  modules: {
  }
})
