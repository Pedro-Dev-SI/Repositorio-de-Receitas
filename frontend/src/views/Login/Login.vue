<template>
  <div class="main">
    <img class="bg-effect" src="@/assets/fundo.png">
    <div class="login">
      <img class="logo" src="@/assets/logo_gtchef.png">
      <form >
        <label>E-mail</label>
        <input type="email">

        <label>Senha</label>
        <input type="password">

        <button type="submit">Entrar</button>
      </form>

      <div class="links">
        <p>Não tem uma conta ?<a href="#"> Cadastre-se</a></p>
        <a href="#">Esqueci minha senha</a>
      </div>

    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped lang="scss" src="./style.scss"/>
  
