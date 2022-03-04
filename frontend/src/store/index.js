import { createStore } from 'vuex'

export default createStore({
  
  strict: true,

  state: {

    user:{ 
      firstName: '',
      lastName: '',
      email: '',
      password: '',
    },

    recipe:{
      name: '',
      prepareTime: '',
      yield: '',
      yield_unit: '',
      chefName:'',
      categories: '',
      ingredients: '',
      instructions: '',
    },

    ingredients:{
      ingredientName: '',
      ingredientQuantity: '',
      ingredientQuantityUnit: '',
    },

    instructions:{
      step: '',
    }

  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
