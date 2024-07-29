<script setup>
import { defineProps } from "vue";
import BookCard from "../shared/BookCard.vue";
import { books } from "@/constants";

const props = defineProps(["title"]);
</script>

<template>
  <article class="flex flex-col w-full h-auto pb-5 border-b border-[#B0FC63]">
    <h1 class="text-white text-4xl font-castoro mb-7">{{ props.title }}:</h1>
    <div
      class="grid max-lg:grid-cols-1 lg:grid-cols-2 xl:grid-cols-4 2xl:grid-cols-7 place-items-center w-full h-auto"
    >
      <BookCard v-for="book in books" :key="book.id" :book="book" />
    </div>
  </article>
</template>
