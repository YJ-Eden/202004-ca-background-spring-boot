<script>

let httpRequestUrl = null
let websocketUrl = null

if (process.env.NODE_ENV == 'development') {
  httpRequestUrl = 'http://127.0.0.1:8088/user'
  websocketUrl = 'ws://127.0.0.1:8002'
} else if (process.env.NODE_ENV == 'debug') {
  httpRequestUrl = 'http://127.0.0.1:8088/user'
  websocketUrl = 'ws://127.0.0.1:8002'
} else if (process.env.NODE_ENV == 'production') {
  httpRequestUrl = 'http://127.0.0.1:8088/user'
  websocketUrl = 'ws://127.0.0.1:8002'

}
const showFileUrl = httpRequestUrl + '/file/showFile?path=';

export default {
  httpRequestUrl,
  websocketUrl,
  showFileUrl

}
</script>
