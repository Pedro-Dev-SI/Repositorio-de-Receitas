<template>
  <div class="main">
    <img class="bg-effect" src="@/assets/fundo.png">
    <div class="register">
      <img class="logo" src="@/assets/logo_gtchef.png" alt="Logo da GTchef">
      <form @submit.prevent="$store.dispatch('handleSubmitUser')">
         
        <label>Primeiro nome</label>
         <input type="text" v-model="primeiroNome" placeholder="Primeiro nome...">

         <label>Último nome</label>
         <input type="text" v-model="ultimoNome" placeholder="Último nome...">

         <label>E-mail</label>
         <input type="email" v-model="email" placeholder="exemplo@exemplo.com">

         <label>Senha</label>
         <input type="password" v-model="senha" placeholder="Sua senha...">

         <label>Confirmar senha</label>
         <input type="password" v-model="confirmarSenha" placeholder="Confirme a senha...">

         <p class="danger-warning" v-if="!$store.state.usuario.valid">As senhas não coincidem</p>

        <button>Cadastrar</button>
        <router-link style="text-decoration: none;" to="/"><a href="#" class="cancel-btn">Cancelar</a></router-link>
      </form>

    </div>
  </div>
</template>

<script>

export default {
  name: 'Register',

  computed:{
    primeiroNome:{
      get(){
        return this.$store.state.usuario.primeiroNome;
      },
      set(primeiroNome){
        this.$store.commit('setPrimeiroNome', primeiroNome);
      }
      
    },

    ultimoNome:{
      get(){
        return this.$store.state.usuario.ultimoNome;
      },
      set(ultimoNome){
        this.$store.commit('setUltimoNome', ultimoNome);
      }
    },

    email:{
      get(){
        return this.$store.state.usuario.email;
      },
      set(email){
        this.$store.commit('setEmail', email);
      }
    },

    senha:{
      get(){
        return this.$store.state.usuario.senha;
      },
      set(senha){
        this.$store.commit('setSenha', senha);
      }
    },

    confirmarSenha:{
      get(){
        return this.$store.state.usuario.confirmarSenha;
      },
      set(confirmarSenha){
        this.$store.commit('setConfirmarSenha', confirmarSenha);
      }
    }
  }
}
</script>

<style scoped lang="scss" src="./style.scss"/>
  
