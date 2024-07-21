<script setup>
import { RouterLink, RouterView } from "vue-router";
import { SignedIn, SignedOut, UserButton, ClerkLoaded } from "vue-clerk";
</script>

<template>
  <section class="relative">
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

        <SignedOut>
          <nav class="flex items-center gap-10 text-xl font-semibold">
            <RouterLink to="/sign-in" class="text-white hover:text-[#b5b5b5]"
              >SignIn</RouterLink
            >
            <RouterLink to="/sign-up" class="text-white hover:text-[#b5b5b5]"
              >SignUp</RouterLink
            >
          </nav>
        </SignedOut>

        <SignedIn>
          <UserButton after-sign-out-url="/sign-in" />
        </SignedIn>
      </div>
    </header>

    <main class="container mx-auto">
      <div class="flex items-center justify-center min-h-[calc(100dvh-80px)]">
        <div>
          <ClerkLoaded>
            <RouterView />
          </ClerkLoaded>
        </div>
      </div>
    </main>
  </section>
</template>
