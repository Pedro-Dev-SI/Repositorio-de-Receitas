<template>
  <div class="main">
    <img class="bg-effect" src="@/assets/fundo.png">
    <div class="register">
      <img class="logo" src="@/assets/logo_gtchef.png" alt="Logo da GTchef">
      <form @submit.prevent="handleSubmit">
         
        <label>Primeiro nome</label>
         <input type="text" v-model="primeiro_nome" placeholder="Primeiro nome...">

         <label>Último nome</label>
         <input type="text" v-model="ultimo_nome" placeholder="Último nome...">

         <label>E-mail</label>
         <input type="email" v-model="email" placeholder="exemplo@exemplo.com">

         <label>Senha</label>
         <input type="password" v-model="senha" placeholder="Sua senha...">

         <label>Confirmar senha</label>
         <input type="password" v-model="confirmar_senha" placeholder="Confirme a senha...">

         <p class="danger-warning" v-if="!this.valid">As senhas não coincidem</p>

        <button>Cadastrar</button>
        <router-link style="text-decoration: none;" to="/"><a href="#" class="cancel-btn">Cancelar</a></router-link>
      </form>

    </div>
  </div>
</template>

<script>

import User from '@/services/user.js';

export default {
  name: 'Register',

  data(){
    return{
      primeiro_nome: '',
      ultimo_nome: '',
      email: '',
      senha: '',
      confirmar_senha: '',
      valid: true,
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

      if(data.primeiro_nome == undefined || data.ultimo_nome == undefined || data.email == undefined || data.senha == undefined || data.confirmar_senha == undefined) {
        alert('Preencha todos os campos');
        return;
      }else if(data.senha != data.confirmar_senha) {
        this.valid = false;
        return;
      }

      User.save(data).then(
        this.$router.push('/')
      );


    }

    

  }
}
</script>

<style scoped lang="scss" src="./style.scss"/>
  
