import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/ad/list',
    method: 'get',
    params
  })
}

export function save(params) {
  return request({
    url: '/ad',
    method: 'post',
    params
  })
}


export function update(params) {
  return request({
    url: '/ad',
    method: 'put',
    params
  })
}

export function remove(id) {
  return request({
    url: '/ad',
    method: 'delete',
    params: {
      id:id
    }
  })
}
