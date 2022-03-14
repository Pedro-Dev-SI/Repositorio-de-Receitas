import { createStore } from 'vuex'

export default createStore({
  state: {

    recipe: {
      id: undefined,
      nomeReceita: '',
      tempoPreparo: '',
      rendimentoDescricao: '',
      rendimentoUnidade: '',
      categoria: '',
      ingredientes: '',
      modoDePreparo: '',
    },

    ingredients: [],
    newIngredient:{},

    instructions: [],
    newInstruction:{},

    user: {
      primeiroNome: '',
      ultimoNome: '',
      email: '',
      senha: '',
      confirmarSenha: '',
      valid: true,
    }

  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
