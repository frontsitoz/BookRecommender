import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import SignInView from "@/views/SignInView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/sign-in",
      name: "signin",
      component: SignInView,
    },
  ],
});

export default router;
