<script setup>
import { useAuth } from "vue-clerk";
import { useMiddleware } from "@/helpers/useMiddleware";

const { isSignedIn } = useAuth();

useMiddleware(isSignedIn.value);
</script>

<template>
  <main>
    <h1 class="text-3xl font-bold underline text-red-500">Home Page</h1>
  </main>
</template>
