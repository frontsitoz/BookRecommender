<script setup>
import { RouterLink } from "vue-router";
</script>

<template>
  <section class="w-72 h-full px-7 py-10 bg-[#060814]">
    <div class="flex flex-col gap-12 w-full h-full pl-4">
      <RouterLink
        to="/"
        class="flex justify-between text-white hover:text-[#b5b5b5]"
      >
        <div class="flex gap-2">
          <p class="text-2xl font-castoro">New</p>
          <img
            src="@/assets/images/star-icon.svg"
            alt="category_icon"
            width="20"
            height="20"
            class="invert mr-10 mb-1"
          />
        </div>
        <img
          src="@/assets/images/dropdown-arrow.svg"
          alt="dropdown_arrow"
          width="30"
          height="30"
          class="invert"
        />
      </RouterLink>

      <RouterLink
        to="/"
        class="flex justify-between text-white hover:text-[#b5b5b5]"
      >
        <div class="flex gap-2">
          <p class="text-2xl font-castoro">Hot</p>
          <img
            src="@/assets/images/flame-icon.svg"
            alt="category_icon"
            width="20"
            height="20"
            class="invert mr-10 mb-1"
          />
        </div>
        <img
          src="@/assets/images/dropdown-arrow.svg"
          alt="dropdown_arrow"
          width="30"
          height="30"
          class="invert"
        />
      </RouterLink>

      <RouterLink
        to="/"
        class="flex justify-between text-white hover:text-[#b5b5b5]"
      >
        <div class="flex gap-2">
          <p class="text-2xl font-castoro">Categories</p>
          <img
            src="@/assets/images/category-icon.svg"
            alt="category_icon"
            width="20"
            height="20"
            class="invert mr-10"
          />
        </div>
        <img
          src="@/assets/images/dropdown-arrow.svg"
          alt="dropdown_arrow"
          width="30"
          height="30"
          class="invert mb-1"
        />
      </RouterLink>
    </div>
  </section>
</template>
