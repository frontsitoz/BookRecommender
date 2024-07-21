<script setup>
import { useAuth, useUser } from "vue-clerk";
import { useMiddleware } from "@/helpers/useMiddleware";

const { isSignedIn } = useAuth();
const { user } = useUser();

const currentUser = user.value;

useMiddleware(isSignedIn.value);
</script>

<template>
  <main
    class="flex justify-center items-center px-24 py-12 bg-gradient-to-br from-[#0A0C15] via-[#1D4938] to-green-700 w-full h-[calc(100vh-80px)]"
  >
    <div
      class="flex flex-col py-10 gap-9 w-full h-full bg-[#0A0C15] rounded-full"
    >
      <div>
        <p class="text-white text-6xl text-center">
          {{ currentUser.username }}
        </p>
      </div>
    </div>
  </main>
</template>
