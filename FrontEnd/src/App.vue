<script setup>
import { RouterView } from "vue-router";
import { ClerkLoaded } from "vue-clerk";
import Navbar from "./components/shared/Navbar.vue";
</script>

<template>
  <section class="min-h-screen overflow-hidden">
    <ClerkLoaded>
      <Navbar />

      <main class="flex items-center justify-center min-h-[calc(100vh-80px)]">
        <RouterView />
      </main>
    </ClerkLoaded>
  </section>
</template>

<style>
body {
  overflow: hidden;
}
</style>
