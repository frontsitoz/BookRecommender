<script setup>
import { RouterLink } from "vue-router";
import { SignedIn, SignedOut, UserButton } from "vue-clerk";
</script>

<template>
  <header
    class="relative bg-[#060815] px-36 z-50 border-b-[0.5px] border-[#a5fe52]"
  >
    <div class="flex justify-between items-center h-20 w-full">
      <div @click="$router.push('/')" class="cursor-pointer">
        <img
          src="@/assets/images/inkradar-white-logo.svg"
          alt="logo"
          width="180"
        />
      </div>

      <nav class="flex items-center gap-10 text-xl font-semibold">
        <SignedOut>
          <RouterLink
            to="/sign-in"
            class="font-castoro text-[22px] text-white hover:text-[#b5b5b5]"
            >SignIn</RouterLink
          >
          <RouterLink
            to="/sign-up"
            class="font-castoro text-[22px] text-white hover:text-[#b5b5b5]"
            >SignUp</RouterLink
          >
        </SignedOut>

        <SignedIn>
          <RouterLink
            to="/profile"
            class="font-castoro text-[22px] text-white hover:text-[#b5b5b5]"
            >Profile</RouterLink
          >
          <UserButton after-sign-out-url="/sign-in" />
        </SignedIn>
      </nav>
    </div>
  </header>
</template>
