<script setup>
import { defineProps } from "vue";

const props = defineProps(["title"]);
</script>

<template>
  <article class="flex flex-col w-full h-auto">
    <h1 class="text-white text-4xl font-castoro">{{ props.title }}:</h1>
    <div class="flex flex-wrap justify-between w-full h-auto">
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
      <div class="w-52 h-52 mt-7"></div>
    </div>
  </article>
</template>
