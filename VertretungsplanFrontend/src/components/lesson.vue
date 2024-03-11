<template>
    <span class="block font-weight-black">{{ lesson.subj }}</span>
    <span class="block">{{ lesson.teacher }}</span>
    <span class="block font-weight-thin">{{ (lesson.room.length > 0 ? lesson.room : '-') }}</span>
</template>

<script setup>
    defineProps(['lesson'])
</script>