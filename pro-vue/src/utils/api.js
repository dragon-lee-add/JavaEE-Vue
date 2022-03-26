import axios from '../utils/base'
import QS from 'qs'

export const getData = data => {
    return axios({
        url: '/api/findAllRoomVue',
        method: 'get',
    })
};
export function Login(data) {
    return axios({
        url: '/api/loginClient',
        method: 'post',
        data: QS.stringify(data)
    })
}