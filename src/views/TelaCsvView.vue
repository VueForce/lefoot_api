<template>
  <div id="card">
      <h3 style="font-size: 30px; text-align: center">Carregar arquivo CSV</h3> 

    <form>
        <div style="display: flex; justify-content: center;">
            <label for="arquivo" >Insira arquivo aqui</label>
            <input type="file" @change="uploadFile" ref="file" name="arquivo" id="arquivo" accept=".csv">
        </div>
    </form>
      <div style="display: grid; grid-template-columns: 1fr 1fr; grid-column-gap: 32px;">
        <Button style="margin-top: 10px">Voltar</Button>
        <Button style="margin-top: 10px" @click="submitFile">Enviar</Button>
      </div>
  </div>
</template>

<style scoped>
#card {
    width: 30%;
    min-width: 350px;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    margin-top: 60px;
    display: flex;
    flex-direction: column;
    /* color: white; */
    background-color: white;
    padding: 50px;
    border-radius: 10px;
    border: 1px solid rgb(148, 148, 148);
    box-shadow: 1px 2px 2px rgba(0, 0, 0, 0.733);
}
button {
  padding: 10px;
  border: none;
  font-weight: 700;
  color: #2c3e50;
}
button:hover {
  background-color: #272727;
  color:white;
}
input {
  padding: 5px;
}

input[type="file"] {
    display: none;
}

label:hover {
  font-weight: 700;
  letter-spacing: 0.5px;
  font-size: 1rem;
  background-color: #cfcfcf;
  color:#2c3e50;
}

label {
    font-weight: 700;
    letter-spacing: 0.5px;
    font-size: 1rem;
    color: rgb(59, 59, 59);
    color:  #333;
    padding: 50px;
    width: 200px;
    /* background-color: #333; */
    text-transform: uppercase;
    text-align: center;
    margin-top: 10px;
    cursor: pointer;
    border: 2px dashed rgba(0, 0, 0, 0.623);
}
</style>

<script>
import axios from 'axios';

export default {
  data: () => ({file: null, fileName: ''}),
    methods: {
      uploadFile() {
        this.file = this.$refs.file.files[0];
        this.fileName = this.$refs.file.files[0].name;
      },
      submitFile() {
        const formData = new FormData();
        
        formData.append('file', this.file);

        const headers = { 'Content-Type': 'multipart/form-data' };
        
        axios.post('http://localhost:8080/api/csv/upload', formData, { headers })
        .then((res) => {
          res.data.files;
          res.status;

          if(res.status === 200) {
            alert(`O arquivo ${this.fileName} foi enviado com sucesso`);
          }
        });
      }
    }
}
</script>