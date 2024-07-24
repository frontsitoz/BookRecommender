<script setup>
import { defineProps } from "vue";
import BookCard from "../shared/BookCard.vue";

const props = defineProps(["title"]);

const cards = [1, 2, 3, 4];
</script>

<template>
  <article class="flex flex-col w-full h-auto">
    <h1 class="text-white text-4xl font-castoro">{{ props.title }}:</h1>
    <div class="flex flex-wrap justify-between w-full h-auto">
      <BookCard v-for="(card, index) in cards" :key="index" />
    </div>
  </article>
</template>
