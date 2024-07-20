<script setup>
import { SignUp } from "vue-clerk";
</script>

<template>
  <main class="z-20">
    <div class="absolute top-0 left-0 size-full">
      <!-- <div class="bg-[rgba(6, 3, 3, 0.711)] backdrop-blur-sm" /> -->
      <img src="../assets/images/purple-books.jpg" alt="purple-books" />
    </div>

    <div class="">
      <SignUp after-sign-up-url="/" sign-in-url="/sign-in" />
    </div>
  </main>
</template>
