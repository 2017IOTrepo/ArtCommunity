import {IArticleData} from "@/api/types";
import request from "@/utils/request";

export const defaultArticleData: IArticleData = {
  id: BigInt(0),
  articleContent: '',
  articleAuthor: BigInt(0),
  articleFront: '',
  articleTitle: '',
  createTime: '',
  userName: ''
}

export const getArticles = (data: any) =>
  request({
    url: '/article/list',
    method: 'POST',
    data
  })

export const getUserArticles = (data: any) =>
    request({
        url: '/article/find_user_art_list',
        method: 'POST',
        data
    })

export const getArticleDetail = (data: any) =>
  request({
    url: '/article/detail',
    method: 'POST',
    data
  })

export const createArticle = (data: any) =>
  request({
    url: '/article/add',
    method: 'POST',
    data
  })

export const updateArticle = (data: any) =>
  request({
    url: '/article/update',
    method: 'PATCH',
    data
  })

export const deleteArticle = (data: any) =>
  request({
    url: '/article/delete',
    method: 'DELETE',
    data
  })
