<template>
   <nav>
      <router-link class="logo" to="/home"><img class="logo" src="@/assets/logo_gtchef.png"></router-link>

      <div class="user-section">
         <hr>

         <div class="circle"></div>

         <div class="user-description">
            <h2>John Taylor</h2>
            <p>Chef iniciante</p>
         </div>
         
         <router-link to="/"><a> <img class="logout-icon" src="@/assets/logout.svg"></a></router-link>
      </div>

   </nav>
</template>

<script>
export default {
   name: 'NavBar',
}
</script>

<style scoped lang="scss" src="./style.scss"/>