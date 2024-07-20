<script setup>
import { SignIn } from "vue-clerk";
</script>

<template>
  <main class="z-20">
    <div class="absolute top-0 left-0 size-full">
      <!-- <div class="bg-[rgba(6, 3, 3, 0.711)] backdrop-blur-sm" /> -->
      <img src="../assets/images/purple-books.jpg" alt="purple-books" />
    </div>

    <div class="">
      <SignIn after-sign-in-url="/" sign-up-url="/sign-up" />
    </div>
  </main>
</template>
