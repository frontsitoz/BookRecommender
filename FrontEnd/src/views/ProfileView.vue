<script setup>
import { useAuth, useUser } from "vue-clerk";
import { useMiddleware } from "@/helpers/useMiddleware";

const { isSignedIn } = useAuth();
const { user } = useUser();

console.log(user.value);

const currentUser = user.value;

useMiddleware(isSignedIn.value);
</script>

<template>
  <main
    class="flex justify-center items-center px-24 py-12 bg-gradient-to-br from-[#0A0C15] via-[#1D4938] to-green-700 w-full h-[calc(100vh-80px)]"
  >
    <div class="flex py-10 gap-9 w-full h-full bg-[#0A0C15] rounded-3xl">
      <div
        class="flex flex-col px-7 items-center w-80 h-full border-r border-[#B9FC6E]"
      >
        <img
          :src="currentUser.imageUrl"
          alt="profile-img"
          width="150"
          class="rounded-full mb-5"
        />
        <img
          src="../assets/images/inkradar-member-logo.svg"
          alt="member-img"
          width="200"
          class="mb-3"
        />
        <p class="uppercase mb-1 text-white text-2xl font-medium">
          {{ currentUser.fullName }}
        </p>
        <p class="mb-7 text-white text-xl">@{{ currentUser.username }}</p>
      </div>

      <!-- <div>
        <p class="uppercase mb-3 text-white text-5xl text-center">
          {{ currentUser.fullName }}
        </p>
        <p class="text-white text-2xl text-center">
          @{{ currentUser.username }}
        </p>
      </div> -->
    </div>
  </main>
</template>
