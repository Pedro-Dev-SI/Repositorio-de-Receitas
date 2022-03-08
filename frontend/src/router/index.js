import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../views/Login/Login.vue'
import Home from '../views/Home/Home.vue'
import Register from '../views/Register/Register.vue'
import ForgotPassword from '../views/Forgot-Password/ForgotPassword.vue'
import NewRecipe from '../views/NewRecipe/NewRecipe.vue'
import UpdateRecipe from '../views/UpdateRecipe/UpdateRecipe.vue'

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/new-user',
    name: 'Register',
    component: Register
  },
  {
    path: '/forgot-password',
    name: 'ForgotPassword',
    component: ForgotPassword
  },
  {
    path: '/new-recipe',
    name: 'NewRecipe',
    component: NewRecipe
  },
  {
    path: '/update-recipe/:id',
    name: 'UpdateRecipe',
    component: UpdateRecipe
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
