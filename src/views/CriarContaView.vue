<template>
  <div id="painelRedefinir">
    <h3 style="font-size: 30px">Criar Conta</h3>

    <!-- <input class="input is-rounded" type="text" placeholder="Rounded input"> -->

    <span style="margin: 1rem; display: flex; flex-direction: column">
      <label for="nome1">Nome do usuário </label>
      <input type="text" ref="userName" maxlength="20" minlength="5" />
    </span>

    <span style="margin: 1rem; display: flex; flex-direction: column">
      <label for="senha"> Nome </label>
      <input type="text" ref="firstName" />
    </span>

    <span style="margin: 1rem; display: flex; flex-direction: column">
      <label for="senha"> Sobrenome </label>
      <input type="text" ref="lastName" />
    </span>

    <span style="margin: 1rem; display: flex; flex-direction: column">
      <label for="email1">Email </label>
      <input type="text" ref="email" />
    </span>

    <span style="margin: 1rem; display: flex; flex-direction: column">
      <label for="senha"> Senha </label>
      <input type="password" ref="password" />
    </span>

    <!-- <div style="display: flex; justify-content: center">
      <div style="margin: 10px 10px">
        <input type="checkbox" name="permissoes" value="adm" /> ADM
      </div>
      <div style="margin: 10px 10px">
        <input type="checkbox" name="permissoes" value="gerente" /> Gerente
      </div>
      <div style="margin: 10px 10px">
        <input type="checkbox" name="permissoes" value="diretor" /> Diretor
      </div>
    </div> -->

    <Button class="button is-dark is-smal" style="margin-top: 10px" @click="signup">Criar</Button>

    <span v-if="mensagem">{{ mensagem }}</span>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      mensagem: "",
    }
  },
  
  methods: {
    signup() {
      const username = this.$refs.userName.value;
      const firstName = this.$refs.firstName.value;
      const lastName = this.$refs.lastName.value;
      const email = this.$refs.email.value;
      const password = this.$refs.password.value;

      const headers = { "Content-Type": "application/json" };

      const body = {
        username,
        password,
        email,
        fname: firstName,
        lname: lastName,
        status: "ativo",
        role: ["user"]
      };

      axios
        .post("http://localhost:8081/api/auth/signup", body, headers)
        .then((result) => {
          if(result.status === 200) {
            this.mensagem = `Usuário ${username} criado com sucesso, acesse a tela de login para acessar a aplicação!`;
          } else {
            this.mensagem = `Erro ao criar usuário`;
          }
        });
      // .catch(error => {
      //   if (error.status === 401){
      //     console.log('Você não está autorizado')
      //   }
      // })
    },
  },
};
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