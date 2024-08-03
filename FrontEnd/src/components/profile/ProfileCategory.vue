<script setup>
import { defineProps } from "vue";
import BookCard from "../shared/BookCard.vue";
const { type, books } = defineProps(["type", "books"]);
</script>

<template>
  <article class="flex flex-col w-full h-auto pb-5 border-b border-[#B0FC63]">
    <h1 class="text-white text-4xl font-castoro mb-7">Bookmarked</h1>
    <div
      class="grid max-lg:grid-cols-1 lg:grid-cols-2 xl:grid-cols-4 2xl:grid-cols-7 place-items-center w-full h-auto"
    >
      <BookCard v-for="book in books" :key="book.idBook" :book="book" />
    </div>
  </article>
</template>
