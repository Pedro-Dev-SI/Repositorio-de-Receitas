<template>
  <div class="nav-page">
      <div v-for="(page, index) in $store.state.pages" :key=index>
         <button class="btn-page" @click.prevent="$store.dispatch('listRecipies', index)" :class="{'active' : (index == $store.state.page.pageNumber)}" >{{page}}</button>
      </div>
  </div>
</template>

<script>
export default {
   name: 'PageButtons',
}
</script>

<style scoped lang="scss" src="./style.scss"/>