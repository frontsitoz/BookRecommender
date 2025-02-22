<script setup>
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { ref, onMounted } from "vue";

const props = defineProps({
  book: {
    type: Object,
    required: true,
  },
  isBookMarked: {
    type: Boolean,
    default: false,
  },
});

const { book } = props;

const dialogContentClass = ref(
  "max-w-[840px] flex flex-col gap-6 px-16 py-8 bg-[#0A0C15] overflow-scroll custom-scrollbar"
);

const rating = ref(0);

const setRating = (value) => {
  if (rating.value === value) {
    // Si el usuario hace clic en la estrella ya seleccionada, quita el rating
    rating.value = 0;
  } else {
    // Si no, establece el nuevo rating
    rating.value = value;
  }
};

const isBookmarked = ref(props.isBookMarked);

onMounted(() => {
  isBookmarked.value = props.isBookMarked;
});

const toggleBookmark = async () => {
  try {
    const newBookmarkedState = !isBookmarked.value;
    if (newBookmarkedState) {
      const bookData = {
        idBook: book.idBook,
        title: book.title,
        authors: book.authors,
        description: book.description,
        genre: book.genre,
        publisher: book.publisher,
        publishedDate: book.publishedDate,
        imageUrl: book.imageUrl,
        pageCount: book.pageCount,
        rating: book.rating || 0,
        isBookMarked: true,
        isRead: book.isRead || false,
        isReading: book.isReading || false,
        isLike: book.isLike || false,
      };

      const response = await fetch("http://localhost:9090/api/books/save", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(bookData),
      });

      if (!response.ok) {
        throw new Error("Error al guardar el libro");
      }

      const savedBook = await response.json();
      console.log("Libro guardado:", savedBook);

      book.idBook = savedBook.idBook;
      book.isBookMarked = true;
    } else {
      if (!book.idBook) {
        throw new Error("No se puede eliminar un libro sin ID");
      }
      console.log("Intentando eliminar libro con ID:", book.idBook);
      try {
        const response = await fetch(
          `http://localhost:9090/api/books/${book.idBook}`,
          {
            method: "DELETE",
          }
        );

        if (!response.ok) {
          const errorText = await response.text();
          console.error("Error response:", response.status, errorText);
          throw new Error(`Error al eliminar el libro: ${errorText}`);
        }

        console.log("Libro eliminado exitosamente");
        book.isBookMarked = false;
      } catch (error) {
        console.error("Error al eliminar el libro:", error);
        // No lanzar el error aquí, solo registrarlo
      }
    }

    isBookmarked.value = newBookmarkedState;
    emit("book-updated", { ...book, isBookMarked: newBookmarkedState });
  } catch (error) {
    console.error("Error al manejar el bookmark:", error);
  }
};

const emit = defineEmits(["book-updated"]);

const updateBookInList = (updatedBook) => {
  emit("book-updated", updatedBook);
};
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
          draggable="false"
          class="w-full h-60 object-cover rounded-md mb-4"
        />
        <h3
          class="text-white text-lg line-clamp-2 font-bold font-castoro w-full mb-3"
        >
          {{ book.title }}
        </h3>
        <p class="text-white text-xs font-montserrat w-full line-clamp-1 mb-2">
          {{
            book.authors
              ? book.authors.replace(/^\[|\]$/g, "")
              : "No authors found"
          }}
        </p>
        <h5 class="w-full line-clamp-1 text-[#35c068] font-montserrat text-sm">
          {{
            book.genre
              ? book.genre.replace(/^\[|\]$/g, "")
              : "No category found"
          }}
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
            draggable="false"
          />

          <div
            class="w-full h-96 border-l border-[#9BFE48] flex flex-col justify-between"
          >
            <div class="flex flex-col gap-10 pl-5 text-white">
              <div class="w-full max-h-6 flex gap-5 line-clamp-1">
                <h3 class="text-xl font-castoro font-bold">Author:</h3>
                <p class="font-montserrat text-base">
                  {{
                    book.authors
                      ? book.authors.replace(/^\[|\]$/g, "")
                      : "No authors found"
                  }}
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
                  {{
                    book.genre
                      ? book.genre.replace(/^\[|\]$/g, "")
                      : "No category found"
                  }}
                </p>
              </div>
            </div>

            <div class="w-full flex">
              <div class="w-max px-10 h-10 flex justify-around">
                <img
                  src="/images/bookmark-icon.svg"
                  alt="bookmark"
                  class="w-12 h-full cursor-pointer"
                  :class="{
                    'invert opacity-100': isBookmarked,
                    'invert opacity-50': !isBookmarked,
                  }"
                  @click="toggleBookmark"
                  draggable="false"
                />
              </div>
              <div class="w-full h-10 flex justify-center items-center">
                <img
                  v-for="star in 5"
                  :key="star"
                  src="/images/unfavorite-icon.svg"
                  :alt="'Estrella ' + star"
                  @click="setRating(star)"
                  draggable="false"
                  :class="[
                    'h-10 w-10 cursor-pointer mx-1 invert',
                    {
                      'opacity-100': star <= rating,
                      'opacity-50': star > rating,
                    },
                  ]"
                />
              </div>
            </div>
          </div>
        </div>
      </DialogHeader>

      <DialogDescription class="w-full min-h-44 max-h-60 flex flex-col gap-2">
        <h1 class="w-full h-auto text-white font-bold font-castoro text-xl">
          Description:
        </h1>
        <p v-if="book.description" class="text-white font-montserrat text-base">
          {{ book.description }}
        </p>
        <div v-else class="w-full h-36 flex justify-center items-center">
          <h1 class="text-white font-castoro text-xl font-bold">
            No description available
          </h1>
        </div>
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
