<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <header class="bg-[#6c47ff] px-36">
    <div class="flex justify-between items-center h-20 w-full">
      <div
        @click="$router.push('/')"
        class="text-2xl font-extrabold text-white cursor-pointer"
      >
        Book Recommender
      </div>
      <nav class="flex items-center gap-10 text-white text-xl font-semibold">
        <RouterLink to="/sign-in">SignIn</RouterLink>
        <RouterLink to="/sign-up">SignUp</RouterLink>
      </nav>
    </div>
  </header>

  <main class="container mx-auto">
    <div class="flex items-center justify-center min-h-[calc(100dvh-80px)]">
      <div>
        <RouterView />
      </div>
    </div>
  </main>
</template>
