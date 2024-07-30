<script setup>
import BookCard from "../shared/BookCard.vue";
import { useUser } from "vue-clerk";
// import { books } from "@/constants";

const { user } = useUser();

const currentUser = user.value;

import { ref, onMounted } from "vue";

const books = ref([]);
const isLoading = ref(true);

const searchBooks = async () => {
  try {
    isLoading.value = true;
    const response = await fetch(
      "http://localhost:5173/api/books/searchBooks?query="
    );
    if (!response.ok) {
      throw new Error("Network response was not ok");
    }
    const data = await response.json();
    books.value = data.content;
    console.log(books.value);
  } catch (error) {
    console.error("Error searching books:", error);
  } finally {
    isLoading.value = false;
  }
};

onMounted(() => {
  searchBooks();
});
</script>

<template>
  <section class="flex flex-col w-full h-full overflow-scroll custom-scrollbar">
    <div class="flex flex-col justify-center px-10 w-full h-28 pt-14 mb-4">
      <h1 class="text-white text-5xl font-castoro mb-2">
        Welcome Home Again
        <span class="uppercase">
          {{ currentUser.firstName }}
        </span>
      </h1>
      <p class="text-white text-xl font-montserrat">
        Here are some books we picked up just for you:
      </p>
    </div>

    <div v-if="isLoading" class="flex justify-center items-center h-full">
      <div
        class="animate-spin rounded-full h-32 w-32 border-t-2 border-b-2 border-green-500"
      ></div>
    </div>

    <div
      v-else
      class="grid max-lg:grid-cols-1 lg:grid-cols-2 xl:grid-cols-4 2xl:grid-cols-7 place-items-center px-10 py-10 gap-10 w-full h-auto"
    >
      <BookCard v-for="book in books" :key="book.id" :book="book" />
    </div>
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
