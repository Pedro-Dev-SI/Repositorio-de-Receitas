<template>
  <div class="main">

    <img class="bg-effect" src="@/assets/fundo.png">

    <div class="container">
      <img class="logo" src="@/assets/logo_gtchef.png">

      <h2>Esqueceu sua senha ?</h2>
      <p class="text">Informe seu email e aguarde!</p>
      <p>Vamos enviar as instruções para recuperar sua senha.</p>

      <form>
        <label>E-mail</label>
        <input type="email" v-model="email" required placeholder="Informe seu e-mail">
        <button>Recuperar senha</button>
      </form>

      <router-link to="/"><a> <img src="@/assets/left-arrow.svg"> Retornar ao login</a></router-link>

    </div>
  </div>
</template>

<script>
export default {
  name: 'ForgotPassword',
}
</script>

<style scoped lang="scss" src="./style.scss"/>