<script setup>
import { useAuth } from "vue-clerk";
import { useMiddleware } from "@/helpers/useMiddleware";
import HomeLeftSidebar from "../components/home/HomeLeftSidebar.vue";
import HomeContent from "@/components/home/HomeContent.vue";

const { isSignedIn } = useAuth();

useMiddleware(isSignedIn.value);
</script>

<template>
  <main
    class="flex bg-gradient-to-br from-[#0A0C15] via-[#1D4938] to-green-700 w-full h-[calc(100vh-80px)]"
  >
    <HomeLeftSidebar />

    <HomeContent />
  </main>
</template>
