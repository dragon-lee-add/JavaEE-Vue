import axios from 'axios'
import qs from 'qs'


axios.interceptors.request.use(
    // config => {
    //     config.method === 'post' ?
    //         config.data = qs.stringify({...config.data }) :
    //         config.params = {...config.params };
    //     config.headers['Content-Type'] = 'application/x-www-form-urlencoded';
    //     return config
    // },
    // err => {
    //     console.error('axios request 请求出错：', err)
    //     return Promise.reject(err)
    // }
)


axios.interceptors.response.use(
    response => {
        if (response && response.data) {
            let data = response.data || {}
            if (data && (data['code'] === "201")) {
                //登录失效
            }
        }
        return response
    },
    err => {
        console.error('axios response 请求出错：', err)
        let res = {
            success: false,
            message: '系统错误，请重试！'
        }
        return Promise.resolve(res)
    }
)
export default axios