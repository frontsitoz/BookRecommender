<script setup>
import ProfileCategory from "./ProfileCategory.vue";
import { ref, onMounted } from "vue";

const books = ref([]);

const fetchBooks = async () => {
  try {
    const response = await fetch("http://localhost:9090/api/books");
    if (!response.ok) {
      throw new Error("Error al obtener los libros");
    }
    const data = await response.json();
    books.value = data;
  } catch (error) {
    console.error("Error:", error);
  }
};

onMounted(() => {
  fetchBooks();
});
</script>

<template>
  <section
    class="flex flex-col gap-14 w-full max-h-full overflow-scroll custom-scrollbar"
  >
    <ProfileCategory type="bookmarked" :books="books" />
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
