<script setup>
import { RouterLink } from "vue-router";
import { defineProps } from "vue";

const props = defineProps(["title", "iconUrl"]);
</script>

<template>
  <RouterLink
    to="/"
    class="flex justify-between text-white hover:text-[#b5b5b5]"
  >
    <div class="flex gap-2">
      <p class="text-2xl font-castoro">{{ props.title }}</p>
      <img
        :src="props.iconUrl"
        alt="item_icon"
        width="20"
        height="20"
        class="invert mr-10 mb-1"
      />
    </div>
    <img
      src="/images/dropdown-arrow.svg"
      alt="dropdown_arrow"
      width="30"
      height="30"
      class="invert"
    />
  </RouterLink>
</template>
