<template>
  <div class="main">
    <img class="bg-effect" src="@/assets/fundo.png">
    <div class="register">
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
        <router-link to="/"><a href="#" class="cancel-btn">Cancelar</a></router-link>
      </form>

    </div>
  </div>
</template>

<script>

import api from '@/services/api.js';

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
    async handleSubmit() {

      const data = {
        primeiro_nome: this.primeiro_nome,
        ultimo_nome: this.ultimo_nome,
        email: this.email,
        senha: this.senha,
        confirmar_senha: this.confirmar_senha,
      }

      await api.post('new-user', data);
      
      this.$router.push('/');

    }

    

  }
}
</script>

<style scoped lang="scss" src="./style.scss"/>
  
