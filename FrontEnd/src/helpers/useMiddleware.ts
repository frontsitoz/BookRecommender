import { onBeforeMount } from "vue";
import { useRouter } from "vue-router";

export const useMiddleware = (isSignedIn: boolean | undefined) => {
  const router = useRouter();

  onBeforeMount(() => {
    if (!isSignedIn) {
      router.push("/sign-in");
    }
  });
};
