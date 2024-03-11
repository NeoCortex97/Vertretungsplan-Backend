<template>
    <div v-if="i < day.length && day[i - 1].group == undefined">
        <div class="cell rounded-lg" :key="key" v-for="(lesson, key) in day[i - 1].lessons" v-if="i < day.length">
        <lesson :lesson="lesson"/>
        </div>
    </div>
    <div v-else>
        <div class="cell rounded-lg" v-if="i < day.length" >
        <lesson-group :lesson="day[i - 1].lessons"/>
        </div>
    </div>
</template>

<script setup>
defineProps(['day', 'i'])
</script>