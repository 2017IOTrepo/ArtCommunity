import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

// 路由
const routes = [
    {
        path: '/',
        name: '首页',
        meta: {
            title: '首页入口'
        },
        component: () => import('@/views/Main.vue')
    },
    {
        path: '/login',
        name: '登录界面',
        meta: {
            title: '登录界面'
        },
        component: () => import('@/views/Login.vue')
    },
    {
        path: '/register',
        name: '注册界面',
        meta: {
            title: '注册界面'
        },
        component: () => import('@/views/Register.vue')
    },
    {
        path: '/my-profile',
        name: '个人界面',
        meta: {
            title: '个人界面'
        },
        component: () => import('@/views/SelfProfile.vue')
    },
    {
        path: '/modify-profile',
        name: '修改个人信息',
        meta: {
            title: '修改个人信息'
        },
        component: () => import('@/views/ProfileModify.vue')
    },
    {
        path: '/other-profile',
        name: '他人界面',
        meta: {
            title: '他人界面'
        },
        component: () => import('@/views/OtherProfile.vue')
    },
    {
        path: '/add-article',
        name: '添加文章',
        meta: {
            title: '添加文章'
        },
        component: () => import('@/views/AddArticle.vue')
    },
    {
        path: '/update-article',
        name: '修改文章',
        meta: {
            title: '修改文章'
        },
        component: () => import('@/views/UpdateArticle.vue')
    },
    {
        path: '/content-article',
        name: '文章详情',
        meta: {
            title: '文章详情'
        },
        component: () => import('@/views/ArticleContent.vue')
    },
    {
        path: '/list-article',
        name: '社区',
        meta: {
            title: '社区'
        },
        component: () => import('@/views/ArticleList.vue')
    },
    {
        path: '/add-art',
        name: '添加作品',
        meta: {
            title: '添加作品'
        },
        component: () => import('@/views/AddArt.vue')
    },
    {
        path: '/update-art',
        name: '修改作品',
        meta: {
            title: '修改作品'
        },
        component: () => import('@/views/UpdateArt.vue')
    },
    {
        path: '/content-art',
        name: '作品详情',
        meta: {
            title: '作品详情'
        },
        component: () => import('@/views/ArtContent.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
