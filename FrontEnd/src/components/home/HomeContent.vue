<script setup>
import BookCard from "../shared/BookCard.vue";

const cards = [
  1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
  23,
];
</script>

<template>
  <section
    class="grid max-lg:grid-cols-1 lg:grid-cols-2 xl:grid-cols-4 2xl:grid-cols-7 place-items-center px-10 py-10 gap-10 w-full h-full overflow-scroll custom-scrollbar"
  >
    <BookCard v-for="(card, index) in cards" :key="index" />
  </section>
</template>

<style scoped>
/* Personalizar la barra de desplazamiento */
.custom-scrollbar::-webkit-scrollbar {
  width: 5px; /* Ancho de la barra de desplazamiento */
  height: 100%; /* Altura de la barra de desplazamiento */
}

.custom-scrollbar::-webkit-scrollbar-track {
  background: #0d0f15; /* Fondo de la pista de desplazamiento */
}

.custom-scrollbar::-webkit-scrollbar-thumb {
  background: #b0fc63; /* Color de la barra de desplazamiento */
  border-radius: 10px; /* Opcional: redondear la barra de desplazamiento */
}

.custom-scrollbar::-webkit-scrollbar-thumb:hover {
  background: #5b8333; /* Color de la barra de desplazamiento al pasar el mouse */
}
</style>
