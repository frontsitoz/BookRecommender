<script setup>
import { useAuth, useUser } from "vue-clerk";
import { useMiddleware } from "@/helpers/useMiddleware";
import HomeLeftSidebar from "../components/home/HomeLeftSidebar.vue";
import HomeContent from "@/components/home/HomeContent.vue";
import { onMounted } from "vue";

const { isSignedIn } = useAuth();
const { user } = useUser();

useMiddleware(isSignedIn.value);

const saveUserToBackend = async () => {
  if (isSignedIn.value && user.value) {
    try {
      const response = await fetch("http://localhost:9090/api/users/save", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          idUser: user.value.id,
          username: user.value.username,
          email: user.value.primaryEmailAddress.emailAddress,
          passwordHash: "placeholder",
          createdAt: new Date().toISOString(),
        }),
      });

      if (!response.ok) {
        const errorData = await response.text();
        console.error("Error response:", errorData);
        throw new Error(`Error al guardar el usuario: ${errorData}`);
      }

      const savedUser = await response.json();
      console.log("Usuario guardado exitosamente:", savedUser);
    } catch (error) {
      console.error("Error al guardar el usuario:", error);
    }
  }
};

onMounted(() => {
  saveUserToBackend();
});
</script>

<template>
  <main
    class="flex bg-gradient-to-br from-[#0A0C15] via-[#1D4938] to-green-700 w-full h-[calc(100vh-80px)]"
  >
    <HomeLeftSidebar />

    <HomeContent />
  </main>
</template>
