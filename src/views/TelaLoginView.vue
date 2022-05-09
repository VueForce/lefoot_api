<template>
  <div id="painelRedefinir">
    <h3 style="font-size: 30px">LeFoot</h3>

    <span style="margin: 1rem; display: flex; flex-direction: column">
      <label for="nome1"> Nome </label>
      <input type="text" ref="userName"/>
    </span>
    <span style="margin: 1rem; display: flex; flex-direction: column">
      <label for="senha"> Senha </label>
      <input type="password" ref="password"/>
    </span>

    <Button class="button is-dark is-small" style="margin-top: 10px" @click="login">Entrar</Button>
    
  </div>
</template>

<script>
import axios from 'axios';
  
  export default {
    // data: () => (),
    methods: {
      login() {
        const username = this.$refs.userName.value;
        const password = this.$refs.password.value;

        const headers = { 'Content-Type': 'application/json'}

        const body = { username, password }

        axios.post('http://localhost:8081/api/auth/signin', body, headers)
        .then(result => {
          const token = result.data.accessToken;
          localStorage.setItem('userToken', token);
          
          this.$router.push('/filtrar-clientes')

        })
        // .catch(error => {
        //   if (error.status === 401){
        //     console.log('Você não está autorizado')
        //   }
        // })
      }
    }
    
  }
</script>

<style scoped>
#painelRedefinir {
  width: 30%;
  min-width: 20%;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
  display: flex;
  flex-direction: column;
  /* color: white; */
  background-color: white;
  padding: 20px;
  border-radius: 10px;
  border: 1px solid rgb(148, 148, 148);
  box-shadow: 1px 2px 2px rgba(0, 0, 0, 0.733);
}
label {
  font-weight: 700;
  letter-spacing: 0.5px;
  font-size: 1rem;
  color: rgb(59, 59, 59);
}
button {
  padding: 5px;
  border: none;
}
input {
  padding: 5px;
}
#app {
}
.app-container {
  background-color: white;
  text-align: center;
}
body #app .p-button {
  margin-left: 0.2em;
}
form {
  margin-top: 2em;
}
</style>