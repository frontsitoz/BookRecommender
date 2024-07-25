<script setup>
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
</script>

<template>
  <Dialog>
    <DialogTrigger as-child>
      <div
        class="flex flex-col px-5 py-4 w-60 h-[400px] rounded-lg bg-[#0A0C15] cursor-pointer"
      >
        <img
          src="../../assets/images/book_portrait_demo.jpeg"
          alt="book_portrait"
          class="w-full h-60 object-cover rounded-md mb-4"
        />
        <h3
          class="text-white text-lg line-clamp-2 font-bold font-castoro w-full mb-3"
        >
          Perdí un planeta y gane un hogar
        </h3>
        <p class="text-white text-xs font-montserrat w-full line-clamp-1 mb-2">
          Una novela de Kate Johnson
        </p>
        <h5 class="w-full line-clamp-1 text-[#35c068] font-montserrat text-sm">
          Fantasy
        </h5>
      </div>
    </DialogTrigger>
    <DialogContent
      class="max-w-[60%] flex flex-col gap-10 px-20 py-12 bg-[#0A0C15]"
    >
      <DialogHeader class="flex flex-col items-center gap-14">
        <DialogTitle
          class="text-white max-w-[500px] text-4xl font-normal text-center font-castoro w-full"
          >Perdí un planeta y gane un hogar</DialogTitle
        >
        <div class="w-full h-auto flex">
          <img
            src="../../assets/images/book_portrait_demo.jpeg"
            alt="book_portrait"
            class="w-72 object-cover rounded-lg"
          />

          <div class="size-full text-white px-10 flex flex-col gap-10">
            <div class="w-full flex gap-5">
              <h3 class="text-xl font-castoro font-bold">Author:</h3>
              <p class="font-montserrat text-base">Katie Johnson</p>
            </div>

            <div class="w-full flex gap-5">
              <h3 class="text-xl font-castoro font-bold">Release Date:</h3>
              <p class="font-montserrat text-base">February 21st of 2021</p>
            </div>

            <div class="w-full flex gap-5">
              <h3 class="text-xl font-castoro font-bold">Author:</h3>
              <p class="font-montserrat text-base">Katie Johnson</p>
            </div>

            <div class="w-full flex gap-5">
              <h3 class="text-xl font-castoro font-bold">Author:</h3>
              <p class="font-montserrat text-base">Katie Johnson</p>
            </div>

            <div class="w-full flex gap-5">
              <h3 class="text-xl font-castoro font-bold">Author:</h3>
              <p class="font-montserrat text-base">Katie Johnson</p>
            </div>
          </div>
        </div>
      </DialogHeader>

      <DialogDescription>
        Make changes to your profile here. Click save when you're done.
      </DialogDescription>
    </DialogContent>
  </Dialog>
</template>
