
import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import SignUp from '../views/SignUp.vue'
import User from '../views/User.vue'
import admin from '../views/admin.vue'
import board from '../views/board.vue'
import write from '../views/write.vue'
import article from '../views/article.vue'
import Survey from '../views/Survey.vue'
import surveywrite from '../views/surveywrite.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/user',
    name: 'User',
    component: User
  },
  {
    path: '/admin',
    name: 'admin',
    component:admin
  },
  {
    path: '/board',
    name: 'board',
    component:board
  },
  {
    path: '/survey',
    name: 'Survey',
    component: Survey
  },
  {
    path: '/write',
    name: 'write',
    component:write,
  },
  {
    path: '/surveywrite',
    name: 'surveywrite',
    component:surveywrite,
  },
  {path: '/article/:bId',
   name:'article',
   component:article
  }
]
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

