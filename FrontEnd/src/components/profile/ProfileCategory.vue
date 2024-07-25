<script setup>
import { defineProps } from "vue";
import BookCard from "../shared/BookCard.vue";

const props = defineProps(["title"]);

const cards = [1, 2, 3, 4, 5, 6, 7];
</script>

<template>
  <article class="flex flex-col w-full h-auto pb-5 border-b border-[#B0FC63]">
    <h1 class="text-white text-4xl font-castoro mb-7">{{ props.title }}:</h1>
    <div
      class="grid max-lg:grid-cols-1 lg:grid-cols-2 xl:grid-cols-4 2xl:grid-cols-7 place-items-center w-full h-auto"
    >
      <BookCard v-for="(card, index) in cards" :key="index" />
    </div>
  </article>
</template>
