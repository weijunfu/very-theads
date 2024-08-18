import axios from 'axios'

import { requestTimeout } from '../settings'

const request = axios.create({
  baseURL: '/',
  timeout: requestTimeout
})

export default request
