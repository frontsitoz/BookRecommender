<script setup>
import { useUser } from "vue-clerk";
const { user } = useUser();

console.log(user.value);

const currentUser = user.value;
</script>

<template>
  <section
    class="flex flex-col px-7 py-5 gap-3 items-center w-[350px] h-full border-r border-[#B9FC6E]"
  >
    <div class="flex flex-col items-center">
      <img
        :src="currentUser.imageUrl"
        alt="profile-img"
        width="150"
        class="rounded-full mb-7 shadow-[0_0_15px] shadow-[#B9FC6E]"
      />
      <img
        src="@/assets/images/inkradar-member-logo.svg"
        alt="member-img"
        width="200"
        class="mb-5"
      />
      <h1
        class="font-montserrat uppercase line-clamp-2 max-w-[219px] max-h-[64px] text-center mb-1 text-white text-2xl font-medium"
      >
        {{ currentUser.fullName }}
      </h1>
      <h4
        class="font-montserrat truncate max-w-[219px] mb-7 text-white text-xl"
      >
        @{{ currentUser.username }}
      </h4>
    </div>

    <div class="flex flex-col gap-5 items-center">
      <h1 class="text-[#B9FC6E] text-2xl font-montserrat">
        Bookmarked:
        <span class="text-white"> 3</span>
      </h1>
      <h1 class="text-[#B9FC6E] text-2xl font-montserrat">
        Favorites:
        <span class="text-white"> 15</span>
      </h1>
      <h1 class="text-[#B9FC6E] text-2xl font-montserrat">
        Books read:
        <span class="text-white"> 7</span>
      </h1>
    </div>
  </section>
</template>
