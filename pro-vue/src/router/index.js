import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
const Login = () => import('@/components/Login');
const Register = () => import('@/components/Register');
const Detail = () => import('@/components/Detail');
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/Register',
      name: 'Register',
      component: Register
    },
    {
      path: '/Detail',
      name: 'Detail',
      component: Detail
    }
  ]
})
