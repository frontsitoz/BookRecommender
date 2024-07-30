<script setup>
import { RouterLink } from "vue-router";
import { SignedIn, SignedOut, UserButton } from "vue-clerk";
import { useAuth } from "vue-clerk";

const { isSignedIn } = useAuth();
const signedIn = isSignedIn.value;

const appearance = {
  variables: {
    colorBackground: "#1A3E30",
    colorPrimary: "#2e026d",
    colorText: "#ffffff",
    borderRadius: "8px",
  },
  elements: {
    userButton: {
      backgroundColor: "#060815",
      color: "#ffffff",
      borderRadius: "8px",
      padding: "10px",
      "&:hover": {
        backgroundColor: "#240158",
      },
    },
    userProfile: {
      backgroundColor: "#060815",
      borderRadius: "8px",
    },
    card: {
      backgroundColor: "#060815",
      borderRadius: "8px",
    },
    inputField: {
      borderRadius: "8px",
      backgroundColor: "#1e1e2e",
      color: "#ffffff",
    },
    labelText: {
      color: "#ffffff",
    },
    userButtonPopoverActionButton: {
      color: "#ffffff",
    },
    userButtonPopoverActionButtonHover: {
      backgroundColor: "#240158",
    },
  },
};
</script>

<template>
  <header
    class="relative bg-[#060815] px-36 z-50 border-b-[0.5px] border-[#a5fe52]"
  >
    <div class="flex justify-between items-center h-20 w-full">
      <div @click="signedIn && $router.push('/')" class="cursor-pointer">
        <img src="/images/inkradar-white-logo.svg" alt="logo" width="180" />
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
          <UserButton after-sign-out-url="/sign-in" :appearance="appearance" />
        </SignedIn>
      </nav>
    </div>
  </header>
</template>
