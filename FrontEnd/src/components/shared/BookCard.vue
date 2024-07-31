<script setup>
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { ref } from "vue";

const { book } = defineProps({
  book: {
    type: Object,
    required: true,
  },
});

const dialogContentClass = ref(
  "max-w-[840px] flex flex-col gap-6 px-16 py-8 bg-[#0A0C15] overflow-scroll custom-scrollbar"
);
</script>

<template>
  <Dialog>
    <DialogTrigger as-child>
      <div
        class="flex flex-col px-5 py-4 w-60 h-[400px] rounded-lg bg-[#0A0C15] cursor-pointer"
      >
        <img
          :src="book.imageUrl"
          alt="book_portrait"
          class="w-full h-60 object-cover rounded-md mb-4"
        />
        <h3
          class="text-white text-lg line-clamp-2 font-bold font-castoro w-full mb-3"
        >
          {{ book.title }}
        </h3>
        <p class="text-white text-xs font-montserrat w-full line-clamp-1 mb-2">
          {{ book.authors.replace(/^\[|\]$/g, "") }}
        </p>
        <h5 class="w-full line-clamp-1 text-[#35c068] font-montserrat text-sm">
          {{ book.genre.replace(/^\[|\]$/g, "") }}
        </h5>
      </div>
    </DialogTrigger>
    <DialogContent :class="dialogContentClass">
      <DialogHeader class="flex flex-col items-center">
        <DialogTitle
          class="text-white max-w-[500px] text-4xl font-normal text-center pb-7 font-castoro w-full border-b border-[#9BFE48] line-clamp-3 max-h-[120px]"
          >{{ book.title }}</DialogTitle
        >
        <div class="w-full h-auto flex mt-7">
          <img
            :src="book.imageUrl"
            alt="book_portrait"
            class="w-[350px] max-w-[350px] h-[385px] object-cover rounded-lg mr-5"
          />

          <div
            class="w-full h-96 border-l border-[#9BFE48] flex flex-col justify-between"
          >
            <div class="flex flex-col gap-10 pl-5 text-white">
              <div class="w-full max-h-6 flex gap-5 line-clamp-1">
                <h3 class="text-xl font-castoro font-bold">Author:</h3>
                <p class="font-montserrat text-base">
                  {{ book.authors.replace(/^\[|\]$/g, "") }}
                </p>
              </div>

              <div class="w-full flex gap-5">
                <h3 class="text-xl font-castoro font-bold">Release Date:</h3>
                <p class="font-montserrat text-base">
                  {{ book.publishedDate }}
                </p>
              </div>

              <div class="w-full flex gap-5">
                <h3 class="text-xl font-castoro font-bold">
                  Publishing House:
                </h3>
                <p class="font-montserrat text-base">{{ book.publisher }}</p>
              </div>

              <div class="w-full flex gap-5">
                <h3 class="text-xl font-castoro font-bold">Pages:</h3>
                <p class="font-montserrat text-base">{{ book.pageCount }}</p>
              </div>

              <div class="w-full flex gap-5">
                <h3 class="text-xl font-castoro font-bold">Category:</h3>
                <p class="font-montserrat text-base">
                  {{ book.genre.replace(/^\[|\]$/g, "") }}
                </p>
              </div>
            </div>

            <div class="w-full h-10 flex justify-around">
              <img
                src="/images/unfavorite-icon.svg"
                alt="star"
                class="h-full invert cursor-pointer"
              />

              <img
                src="/images/bookmark-icon.svg"
                alt="bookmark"
                class="h-full invert cursor-pointer"
              />

              <img
                src="/images/book-open-icon.svg"
                alt="open_book"
                class="h-full invert cursor-pointer"
              />
            </div>
          </div>
        </div>
      </DialogHeader>

      <DialogDescription class="w-full min-h-44 max-h-60 flex flex-col gap-2">
        <h1 class="w-full h-auto text-white font-bold font-castoro text-xl">
          Description:
        </h1>
        <p class="text-white font-montserrat text-base">
          {{ book.description }}
        </p>
      </DialogDescription>
    </DialogContent>
  </Dialog>
</template>

<style>
/* Personalizar la barra de desplazamiento para el componente DialogContent */
.custom-scrollbar::-webkit-scrollbar {
  width: 2px;
}

.custom-scrollbar::-webkit-scrollbar-track {
  background: transparent;
}

.custom-scrollbar::-webkit-scrollbar-thumb {
  background: #b0fc63;
  border-radius: 10px;
}

.custom-scrollbar::-webkit-scrollbar-thumb:hover {
  background: #5b8333;
}

/* Estilos para navegadores Firefox */
.custom-scrollbar {
  scrollbar-width: thin;
  scrollbar-color: #b0fc63 transparent;
}

/* Estilos específicos para el componente DialogContent */
:deep(.dialog-content) {
  scrollbar-width: thin;
  scrollbar-color: #b0fc63 transparent;
}

:deep(.dialog-content)::-webkit-scrollbar {
  width: 2px;
}

:deep(.dialog-content)::-webkit-scrollbar-track {
  background: transparent;
}

:deep(.dialog-content)::-webkit-scrollbar-thumb {
  background: #b0fc63;
  border-radius: 10px;
}

:deep(.dialog-content)::-webkit-scrollbar-thumb:hover {
  background: #5b8333;
}
</style>
