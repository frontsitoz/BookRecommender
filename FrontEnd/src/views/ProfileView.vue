<script setup>
import { useMiddleware } from "@/helpers/useMiddleware";
import ProfileLeftSidebar from "../components/ProfileLeftSidebar.vue";
import { useAuth } from "vue-clerk";

const { isSignedIn } = useAuth();

useMiddleware(isSignedIn.value);
</script>

<template>
  <main
    class="flex justify-center items-center px-24 py-12 bg-gradient-to-br from-[#0A0C15] via-[#1D4938] to-green-700 w-full h-[calc(100vh-80px)]"
  >
    <ProfileLeftSidebar />
  </main>
</template>
