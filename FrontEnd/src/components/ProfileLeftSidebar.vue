<script setup>
import { useUser } from "vue-clerk";
const { user } = useUser();

console.log(user.value);

const currentUser = user.value;
</script>

<template>
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
  </div>
</template>
