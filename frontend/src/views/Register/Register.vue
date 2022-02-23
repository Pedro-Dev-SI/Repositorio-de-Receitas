<template>
  <div class="main">
    <img class="bg-effect" src="@/assets/fundo.png">
    <div class="login">
      <img class="logo" src="@/assets/logo_gtchef.png" alt="Logo da GTchef">
      <form >
         
         <label>E-mail</label>
         <input type="email">

         <label>Senha</label>
         <input type="password">

         <label>Confirmar senha</label>
         <input type="password">

        <button type="submit">Cadastrar</button>
        <a href="#" class="cancel-btn">Cancelar</a>
      </form>

    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped lang="scss" src="./style.scss"/>
  
