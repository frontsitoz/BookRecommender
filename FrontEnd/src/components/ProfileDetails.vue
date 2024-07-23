<script setup>
import ProfileCategory from "./ProfileCategory.vue";
</script>

<template>
  <section class="flex flex-col gap-24 w-full max-h-full overflow-scroll">
    <ProfileCategory title="Bookmarked" />

    <ProfileCategory title="Favorites" />

    <ProfileCategory title="Books Read" />
  </section>
</template>
