import "./assets/main.css";

import { createApp } from "vue";
import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";
import { clerkPlugin } from "vue-clerk";

const PUBLISHABLE_KEY = import.meta.env.VITE_CLERK_PUBLISHABLE_KEY;

if (!PUBLISHABLE_KEY) {
  throw new Error("Missing Publishable Key");
}

const app = createApp(App);

app.use(createPinia());
app.use(clerkPlugin, {
  publishableKey: PUBLISHABLE_KEY,
});
app.use(router);

app.mount("#app");
