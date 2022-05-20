import Vue from 'vue'
import Vuex from 'vuex'
import Route from '../router/index'
import axios from 'axios'
import router from '../router/index'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    Userinfo:{User_Id:null,User_Name:null,User_auth:[],User_token:null},
    boardlist:[],
    UserList:[],
    article:[]
  },
  mutations: {
    NewUsers: (state,payload) => {
      state.UserList.push(payload)
      Route.push("/login")
    },
    SET_USER(state, data) {
      state.Userinfo.User_Id = data.username
      state.Userinfo.User_Name = data.name
      state.Userinfo.User_auth = data.authorities
      state.Userinfo.User_token = data.token
      Route.push("/user")
  },
    READ_USER_LIST(state,data) {
      state.UserList = data
    },
    WRITE(state,data) {
      state.Userinfo = data
    },
    READ_BOARD_LIST(state,data) {
      state.boardlist = data
    },
    READ_ARTICLE(state,data) {
      state.article.bId = data.bId
      state.article = data
      console.log(state.article)
    },
  INSERT_TOKEN(state) {
    state.Userinfo.User_token = localStorage.getItem("token")
  },
  SET_USER_REFRESH(state,data) {
   state.Userinfo.User_Id = data.username
   state.Userinfo.User_Name = data.name
   state.Userinfo.User_auth = data.authorities
   state.Userinfo.User_token = data.token
  },
  logout(state) {
   state.Userinfo.User_Id = null
   state.Userinfo.User_Name = null
   state.Userinfo.User_auth = null
   state.Userinfo.User_token = null
   localStorage.removeItem("token")
   console.log(state.Userinfo)
   console.log("Logout"+localStorage.getItem("token"))
  }
 },
  actions: {
    loginProcess({ commit }, payload) {
      console.log(payload)
      return new Promise((resolve, reject) => {
          axios.post('http://localhost:9000/api/auth/signin', payload)
              .then(Response => {
                  console.log(Response.data)
                  if (Response.data.username != null) {
                      axios.defaults.headers.common['Authorization'] = `Bearer ${Response.data.token}`
                      localStorage.setItem("token",Response.data.token)
                      commit('SET_USER', Response.data)   
                  }
              })
              .catch(Error => {
                  console.log('error')
                  reject(Error)
              })
      })
   },
   SignUp({commit},payload) {
    console.log(payload)
    return new Promise((resolve, reject) => {
        axios.post('http://localhost:9000/api/auth/signup', payload)
            .then(Response => {
                console.log(Response.data)
                if(Response.data === "success") {
                  Route.push("/login")
                }
            })
            .catch(Error => {
                console.log('error')
                reject(Error)
                alert("아이디가 중복")
                Route.push("/signup")
            })
    })
   },
   admin({commit,state}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.get('http://localhost:9000/api/admin/adminPage')
          .then(Response => {
            console.log(Response.data)
             commit('READ_USER_LIST',Response.data)
          })
          .catch(Error => {
            // console.log(Error)
              console.log('admin_error')
              Route.push("/")
          })
  })
  },
  board({commit},payload) {
    return new Promise((resolve,reject) => {
      axios.get('http://localhost:9000/api/board', payload)
        .then(Response => {
          console.log(Response.data)
            commit('READ_BOARD_LIST',Response.data)
        })
        .catch(Error => {
          console.log('error')
          reject(Error)
        })
    })
  },
  article({commit},payload) {
    //var obj= {bId: router.currentRoute.params.bId}
    //payload = obj
    console.log(payload)
    return new Promise((resolve,reject) => {
      axios.get('http://localhost:9000/api/article', payload)
        .then(Response => {
          console.log(Response.data)
            commit('READ_ARTICLE',Response.data)
        })
        .catch(Error => {
          console.log('error')
          reject(Error)
        })
    })
  },
  writeaction({commit},payload) {
    console.log(payload)
    const formData= new FormData()
    formData.append('bTitle', payload.bTitle)
    formData.append('bContent', payload.bContent)
    formData.append('file', payload.file)
    console.log(formData)
    return new Promise((resolve, reject) => {
      axios.post('http://localhost:9000/api/writeaction',
        formData, {
          headers: {
            'Content-Type': 'multipart/form-data; boundary=----WebKitFormBoundarynHlbq58vtkmKcQMl'
          }
        }
      )
        .then(Response => {
          console.log(Response.data)
          alert('게시글이 등록되었습니다.')
         .then(() => Route.push({name : 'board'}))
        })
        .catch(Error => {
          console.log('error')
          reject(Error)
          alert('게시글 등록 실패')
        })
    })
  },
   UnpackToken({commit}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem("token")}`
      axios.get('http://localhost:9000/api/auth/unpackToken')
          .then(Response => {
            console.log(Response.data)
            commit('SET_USER_REFRESH',Response.data)
          })
          .catch(Error => {
            console.log(Error)
              console.log('unpackToken_error')
          })
  })
  }
}})