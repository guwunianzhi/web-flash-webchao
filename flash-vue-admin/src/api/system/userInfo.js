import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/userInfo/list',
    method: 'get',
    params
  })
}


export function exportXls(params) {
  return request({
    url: '/userInfo/export',
    method: 'get',
    params
  })
}


export function save(params) {
  return request({
    url: '/userInfo',
    method: 'post',
    params
  })
}

export function remove(id) {
  return request({
    url: '/userInfo',
    method: 'delete',
    params: {
      id: id
    }
  })
}
