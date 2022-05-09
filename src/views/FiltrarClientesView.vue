<template>
  <div id="painelRedefinir">
    <h3 style="font-size: 30px">Filtrar Clientes</h3>

    <div class="is-flex">
      <Button
        class="button is-normal is-responsive is-info is-light"
        style="font-weight: bold; margin-top: 10px"
        @click="loadCsv"
        >Selecionar CSV existente</Button
      >

      <Button
        class="button is-normal is-responsive is-info is-light"
        style="font-weight: bold; margin-top: 10px"
        @click="toggleCsvInput"
        >Informar novo CSV</Button
      >
    </div>

    <div v-if="dados.length > 0" style="display: flex; margin: 20px">
      <div class="field">
        <label class="label">Gênero</label>
        <div class="select">
          <select ref="filtroGenero" @change="filtrarDados">
            <option>-</option>
            <option>Masculino</option>
            <option>Feminino</option>
            <option>Outros</option>
          </select>
        </div>
      </div>
    </div>

    <div
      v-if="showCsvInput"
      style="display: flex; justify-content: center; margin: 30px"
    >
      <csv-input />
    </div>

    <div v-if="listaFiltrada.length == 0">
      Nenhum registro
    </div>

    <div v-if="listaFiltrada.length > 0" class="table-container">
      <table class="table is-bordered is-striped is-narrow is-hoverable">
        <thead>
          <tr>
            <th @click="() => sortList('name')"><strong>Nome</strong></th>
            <th @click="() => sortList('age')"><strong>Idade</strong></th>
            <th @click="() => sortList('cpf')"><strong>CPF</strong></th>
            <th @click="() => sortList('birthdate')"><strong>Data de nascimento</strong></th>
            <th @click="() => sortList('gender')"><strong>Gênero</strong></th>
            <th @click="() => sortList('email')"><strong>E-mail</strong></th>
            <th @click="() => sortList('cep')"><strong>CEP</strong></th>
            <th @click="() => sortList('address')"><strong>Endereço</strong></th>
            <th @click="() => sortList('number')"><strong>Número</strong></th>
            <th @click="() => sortList('neighborhood')"><strong>Bairro</strong></th>
            <th @click="() => sortList('city')"><strong>Municipio</strong></th>
            <th @click="() => sortList('state')"><strong>Estado</strong></th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="pessoa in listaFiltrada" :key="pessoa.name">
            <td>{{ pessoa.name }}</td>
            <td>{{ pessoa.age }}</td>
            <td>{{ pessoa.cpf }}</td>
            <td>{{ pessoa.birthdate }}</td>
            <td>{{ pessoa.gender }}</td>
            <td>{{ pessoa.email }}</td>
            <td>{{ pessoa.cep }}</td>
            <td>{{ pessoa.address }}</td>
            <td>{{ pessoa.number }}</td>
            <td>{{ pessoa.neighborhood }}</td>
            <td>{{ pessoa.city }}</td>
            <td>{{ pessoa.state }}</td>
          </tr>
          <!-- <tr>
                <td>
                    Helen
                </td>
            </tr>
            <tr>
                <td>
                Addam
                </td>
            </tr> -->
        </tbody>
        <!-- <tfoot>LeFoot</tfoot> -->
      </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import CsvInput from "../components/CSVInput.vue";

export default {
  components: {
    CsvInput,
  },

  data() {
    return {
      listaFiltrada: [],
      dados: [],
      showCsvInput: false,
      sortOrder: "ASC",
      sortType: ""
    };
  },
  methods: {
    toggleCsvInput() {
      this.showCsvInput = !this.showCsvInput;
    },

    filtrarDados() {
      this.listaFiltrada = [];
      for (let i = 0; i < this.dados.length; i++) {
        if (this.$refs.filtroGenero.value === this.dados[i].gender) {
          this.listaFiltrada.push(this.dados[i]);
        }
      }
    },

    sortList(type) {
      if (this.sortType !== type) {
        this.sortType = type;
      }

      if (this.sortOrder === "ASC" && this.sortType === type) {
        this.sortOrder = "DESC"
      } else {
        this.sortOrder = "ASC"
      }

      if (this.sortOrder === "ASC") {
        this.listaFiltrada.sort((a, b) => a[type].localeCompare(b[type]));
      } else if (this.sortOrder === "DESC") {
        this.listaFiltrada.sort((a, b) => a[type].localeCompare(b[type])).reverse();
      }
    },

    loadCsv() {
      const headers = {
        "Content-Type": "multipart/form-data",
        Authorization: `Bearer ${localStorage.getItem("userToken")}`,
      };

      axios
        .get("http://localhost:8081/api/csv/csvdata", { headers })
        .then((res) => {
          this.dados = res.data;
          this.listaFiltrada = res.data;
        });
    },
  },
};
</script>


<style scoped>
#painelRedefinir {
  width: 90%;
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

table {
  margin-top: 20px;
  overflow-x: scroll;
}

thead {
  background-color: rgb(235, 235, 235);
}
</style>

