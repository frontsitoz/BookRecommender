<script setup>
import { RouterLink } from "vue-router";
</script>

<template>
  <section class="w-72 h-full px-7 py-10 bg-[#060814]">
    <div class="w-full h-full pl-4">
      <RouterLink to="/" class="flex text-white hover:text-[#b5b5b5]">
        <p class="text-2xl font-castoro mr-2">Categories</p>
        <img
          src="../assets/images/category-icon.svg"
          alt="category_icon"
          width="20"
          height="20"
          class="invert mr-10"
        />
        <img
          src="../assets/images/dropdown-arrow.svg"
          alt="dropdown_arrow"
          width="30"
          height="30"
          class="invert"
        />
      </RouterLink>
    </div>
  </section>
</template>
