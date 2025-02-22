import Vue from 'vue'
import Router, {RouteConfig} from 'vue-router'
import Layout from '@/layout/index.vue'

Vue.use(Router)

export default new Router({
  // mode: 'history',  // Enable this if you need.
  scrollBehavior: (to, from, savedPosition) => {
    if (savedPosition) {
      return savedPosition
    } else {
      return {x: 0, y: 0}
    }
  },
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/login',
      component: () => import(/* webpackChunkName: "login" */ '@/views/login/index.vue'),
      meta: {
        title: '登陆界面',
        hidden: true
      }
    },
    {
      path: '/404',
      component: () => import(/* webpackChunkName: "404" */ '@/views/404.vue'),
      meta: {hidden: true}
    },
    {
      path: '/',
      component: Layout,
      redirect: '/dashboard',
      children: [
        {
          path: 'dashboard',
          component: () => import('@/views/dashboard/index.vue'),
          meta: {
            title: '主界面',
            icon: 'dashboard'
          }
        },
      ]
    },
    {
      path: '/admin',
      component: Layout,
      meta: {
        title: '管理员相关',
      },
      children: [
        {
          path: 'admin-editor',
          component: () => import('@/views/admins/index.vue'),
          meta: {
            title: '管理员管理',
            icon: 'admin'
          }
        }
      ]
    },
    {
      path: '/editor',
      component: Layout,
      redirect: '/editor/posts',
      meta: {
        title: '作者相关',
        icon: 'nested'
      },
      children: [
        {
          path: 'arts',
          component: () => import('@/views/table/arts/index.vue'),
          meta: {
            title: '作品管理'
          }
        },
        {
          path: 'comments',
          component: () => import('@/views/table/comments/index.vue'),
          meta: {
            title: '评论管理'
          }
        },
        {
          path: 'users',
          component: () => import('@/views/table/users/index.vue'),
          meta: {
            title: '用户管理'
          }
        },
        {
          path: 'tags',
          component: () => import('@/views/table/tags/index.vue'),
          meta: {
            title: '标签管理'
          }
        },
        {
          path: 'sizes',
          component: () => import('@/views/table/sizes/index.vue'),
          meta: {
            title: '尺寸管理'
          }
        },
        {
          path: 'articles',
          component: () => import('@/views/table/articles/index.vue'),
          meta: {
            title: '文章管理'
          }
        }
      ]
    },
    {
      path: '*',
      redirect: '/404',
      meta: { hidden: true }
    }
  ]
})
