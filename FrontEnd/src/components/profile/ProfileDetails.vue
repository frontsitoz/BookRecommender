<script setup>
import ProfileCategory from "./ProfileCategory.vue";
</script>

<template>
  <section
    class="flex flex-col gap-24 w-full max-h-full overflow-scroll custom-scrollbar"
  >
    <ProfileCategory title="Bookmarked" />
    <ProfileCategory title="Favorites" />
    <ProfileCategory title="Books Read" />
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
  background: #555; /* Color de la barra de desplazamiento al pasar el mouse */
}
</style>
