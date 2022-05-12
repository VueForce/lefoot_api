<script setup>
import { RouterLink, RouterView } from "vue-router";
import HelloWorld from "@/components/HelloWorld.vue";
</script>

<template>
  <!-- <header>
    <img alt="LeFoot logo" class="logo" src="@/assets/logo.jpeg" width="125" height="125" />

    <div class="wrapper">
      <HelloWorld msg="You did it!" />

      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
        <RouterLink to="/redefinir-senha">Redefinir Senha</RouterLink>
      </nav>
    </div> 
  </header> -->

  <div
    style="
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      width: 100%;
    "
  >
    <!-- <div style="display: flex; justify-content: center; width: 100%">
      <a href="/"><button class="square-btn button is-info">Home</button></a>
      <a href="/new/account"><button class="square-btn button is-info">Criar conta</button></a>
      <a href="/filtrar-clientes"><button class="square-btn button is-info">CSV</button></a>
      <a href="/login"><button class="square-btn button is-info">Login</button></a>
    </div> -->

    <nav class="navbar" role="navigation" aria-label="main navigation">
      <div class="navbar-brand">
        <a class="navbar-item">
          <img src="./assets/logo.svg" width="100">
        </a>
        <a class="navbar-item" href="/">Home</a>
        <a class="navbar-item" href="/new/account">Criar conta</a>
        <a class="navbar-item" href="/filtrar-clientes">CSV</a>
        <a class="navbar-item" href="/login">Login</a>
      </div>
      <div class="navbar-menu">
        <!-- navbar start, navbar end -->
      </div>
    </nav>
    <RouterView />
  </div>
</template>

<style>
@import "@/assets/base.css";

.square-btn {
  border-radius: 0;
}

#app {
  display: flex;
  place-items: center;
  align-content: center;
  justify-content: center;
}

header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

a,
.green {
  text-decoration: none;
  color: hsla(160, 100%, 37%, 1);
  transition: 0.4s;
}

@media (hover: hover) {
  a:hover {
    background-color: hsla(160, 100%, 37%, 0.2);
  }
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  body {
  }

  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  nav {
    text-align: left;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
