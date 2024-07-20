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
  <main class="">
    <div class="absolute top-0 left-0 w-full h-full overflow-hidden">
      <img
        src="../assets/images/purple-books.jpg"
        alt="purple-books"
        class="w-full h-full object-cover"
      />
      <div
        class="absolute top-0 left-0 w-full h-full bg-black opacity-50 backdrop-blur-sm"
      ></div>
    </div>

    <div class="relative z-30">
      <SignUp
        after-sign-up-url="/"
        sign-in-url="/sign-in"
        :appearance="appearance"
      />
    </div>
  </main>
</template>
