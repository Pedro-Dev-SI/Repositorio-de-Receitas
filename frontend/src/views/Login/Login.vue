<template>
  <div class="main">
    <img class="bg-effect" src="@/assets/fundo.png">
    <div class="login">
      <img class="logo" src="@/assets/logo_gtchef.png">
      <form @submit.prevent="handleSubmit">
        <label>E-mail</label>
        <input type="email" v-model="email" required placeholder="Seu e-mail...">

        <label>Senha</label>
        <input type="password" v-model="senha" required placeholder="Sua senha...">

        <button>Entrar</button>
      </form>

      <div class="links">
        <p>Não tem uma conta ?<router-link to="/new-user"><a href="#"> Cadastre-se</a></router-link></p>
        <router-link to="/forgot-password"><a href="#">Esqueci minha senha</a></router-link>
      </div>

    </div>
  </div>
</template>

<script>
// import axios from "axios";
export default {
  name: 'Login',

  data(){
    return {
      email: '',
      senha: '',
    }
  },

  methods: {

    async handleSubmit(){
      // const data = {
      //   email: this.email,
      //   senha: this.senha,
      // }

      // await axios.post('', data);

      this.$router.push('/home');
    }
  }
}
</script>

<style scoped lang="scss" src="./style.scss"/>
  
