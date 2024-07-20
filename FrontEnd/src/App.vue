<script setup>
import { RouterLink, RouterView } from "vue-router";
import { SignedIn, SignedOut, UserButton } from "vue-clerk";
</script>

<template>
  <section class="relative">
    <header class="relative bg-[#060815] px-36 z-50">
      <div class="flex justify-between items-center h-20 w-full">
        <div
          @click="$router.push('/')"
          class="text-2xl font-extrabold text-[#a5fe52] hover:text-[#8ad346] cursor-pointer"
        >
          Book Recommender
        </div>

        <SignedOut>
          <nav class="flex items-center gap-10 text-xl font-semibold">
            <RouterLink
              to="/sign-in"
              class="text-[#a5fe52] hover:text-[#8ad346]"
              >SignIn</RouterLink
            >
            <RouterLink
              to="/sign-up"
              class="text-[#a5fe52] hover:text-[#8ad346]"
              >SignUp</RouterLink
            >
          </nav>
        </SignedOut>

        <SignedIn>
          <UserButton />
        </SignedIn>
      </div>
    </header>

    <main class="container mx-auto">
      <div class="flex items-center justify-center min-h-[calc(100dvh-80px)]">
        <div>
          <RouterView />
        </div>
      </div>
    </main>
  </section>
</template>
