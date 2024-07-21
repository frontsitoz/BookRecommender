<script setup>
import { RouterLink, RouterView } from "vue-router";
import { SignedIn, SignedOut, UserButton, ClerkLoaded } from "vue-clerk";
</script>

<template>
  <section class="min-h-screen overflow-hidden">
    <header
      class="relative bg-[#060815] px-36 z-50 border-b-[0.5px] border-[#a5fe52]"
    >
      <div class="flex justify-between items-center h-20 w-full">
        <div @click="$router.push('/')" class="cursor-pointer">
          <img
            src="./assets/images/inkradar-white-logo.svg"
            alt="logo"
            width="180"
          />
        </div>

        <nav class="flex items-center gap-10 text-xl font-semibold">
          <SignedOut>
            <RouterLink to="/sign-in" class="text-white hover:text-[#b5b5b5]"
              >SignIn</RouterLink
            >
            <RouterLink to="/sign-up" class="text-white hover:text-[#b5b5b5]"
              >SignUp</RouterLink
            >
          </SignedOut>

          <SignedIn>
            <RouterLink to="/profile" class="text-white hover:text-[#b5b5b5]"
              >Profile</RouterLink
            >
            <UserButton after-sign-out-url="/sign-in" />
          </SignedIn>
        </nav>
      </div>
    </header>

    <main class="flex items-center justify-center min-h-[calc(100vh-80px)]">
      <ClerkLoaded>
        <RouterView />
      </ClerkLoaded>
    </main>
  </section>
</template>

<style>
body {
  overflow: hidden;
}
</style>
