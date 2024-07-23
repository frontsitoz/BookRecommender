<script setup>
import { useMiddleware } from "@/helpers/useMiddleware";
import ProfileLeftSidebar from "../components/ProfileLeftSidebar.vue";
import ProfileDetails from "../components/ProfileDetails.vue";
import { useAuth } from "vue-clerk";

const { isSignedIn } = useAuth();

useMiddleware(isSignedIn.value);
</script>

<template>
  <main
    class="flex justify-center items-center px-24 py-12 bg-gradient-to-br from-[#0A0C15] via-[#1D4938] to-green-700 w-full h-[calc(100vh-80px)]"
  >
    <div class="flex py-10 gap-9 w-full h-full bg-[#0A0C15] rounded-3xl">
      <ProfileLeftSidebar />

      <ProfileDetails />
    </div>
  </main>
</template>
