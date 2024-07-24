<script setup>
import SidebarItem from "./SidebarItem.vue";

// Importar las imágenes
import starIcon from "@/assets/images/star-icon.svg";
import flameIcon from "@/assets/images/flame-icon.svg";
import categoryIcon from "@/assets/images/category-icon.svg";
</script>

<template>
  <section class="w-72 h-full px-7 py-10 bg-[#060814]">
    <div class="flex flex-col gap-12 w-full h-full pl-4">
      <SidebarItem title="New" :icon-url="starIcon" />
      <SidebarItem title="Hot" :icon-url="flameIcon" />
      <SidebarItem title="Categories" :icon-url="categoryIcon" />
    </div>
  </section>
</template>
