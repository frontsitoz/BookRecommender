<script setup>
import { SignUp } from "vue-clerk";

const appearance = {
  variables: {
    colorBackground: "#060815",
    colorPrimary: "#2e026d", // Color principal para coherencia
    colorText: "#ffffff", // Color del texto
    borderRadius: "8px", // Bordes redondeados para un estilo moderno
  },
  elements: {
    card: {
      backgroundColor: "#060815",
      borderRadius: "8px",
    },
    formButtonPrimary: {
      backgroundColor: "#2e026d",
      borderRadius: "8px",
      color: "#ffffff",
      "&:hover": {
        backgroundColor: "#240158",
      },
    },
    socialButtons: {
      backgroundColor: "#2e026d",
      borderRadius: "8px",
      color: "#ffffff",
      "&:hover": {
        backgroundColor: "#240158",
      },
    },
    inputField: {
      borderRadius: "8px",
      backgroundColor: "#1e1e2e",
      color: "#ffffff",
    },
    labelText: {
      color: "#ffffff",
    },
  },
};
</script>

<template>
  <main
    class="bg-gradient-to-br from-[#0A0C15] via-[#1D4938] to-green-700 w-full h-[calc(100vh-80px)] flex items-center justify-center"
  >
    <div class="relative z-30">
      <SignUp
        after-sign-up-url="/"
        sign-in-url="/sign-in"
        :appearance="appearance"
      />
    </div>
  </main>
</template>
