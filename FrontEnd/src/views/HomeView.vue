<script setup>
import { SignedIn, UserButton } from "vue-clerk";
</script>

<template>
  <main>
    <h1 class="text-3xl font-bold underline text-red-500">Home Page</h1>

    <SignedIn>
      <UserButton />
    </SignedIn>
  </main>
</template>
