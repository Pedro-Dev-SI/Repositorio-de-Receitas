<template>
  <div class="main">
    <img class="bg-effect" src="@/assets/fundo.png">
    <div class="login">
      <img class="logo" src="@/assets/logo_gtchef.png" alt="Logo da GTchef">
      <form @submit.prevent="handleSubmit">
         
        <label>Primeiro nome</label>
         <input type="text" v-model="primeiro_nome">

         <label>Último nome</label>
         <input type="text" v-model="ultimo_nome">

         <label>E-mail</label>
         <input type="email" v-model="email">

         <label>Senha</label>
         <input type="password" v-model="senha">

         <label>Confirmar senha</label>
         <input type="password" v-model="confirmar_senha">

        <button>Cadastrar</button>
        <a href="#" class="cancel-btn">Cancelar</a>
      </form>

    </div>
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: 'Register',

  data(){
    return{
      primeiro_nome: '',
      ultimo_nome: '',
      email: '',
      senha: '',
      confirmar_senha: '',
    }
  },

  methods: {
    handleSubmit() {

      const URL_API = "http://localhost:8080/api/v1/new-user";

      const data = {
        primeiro_nome: this.primeiro_nome,
        ultimo_nome: this.ultimo_nome,
        email: this.email,
        senha: this.senha,
        confirmar_senha: this.confirmar_senha,
      }

      axios.post(URL_API, data)

    }
  }
}
</script>

<style scoped lang="scss" src="./style.scss"/>
  
