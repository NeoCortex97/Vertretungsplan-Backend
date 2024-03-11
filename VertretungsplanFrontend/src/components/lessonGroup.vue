<template>
    <div @click="dialog = true">
        <span class="block font-weight-black">{{ lesson.group }}</span>
        <span class="block">GRUPPIERT</span>
        <span class="block font-weight-thin">Für details antippen</span>
    </div>
    <v-dialog v-model="dialog" transition="dialog-bottom-transition" fullscreen>
        <v-card>
        <v-toolbar>
            <v-btn
                icon="mdi-close"
                @click="dialog = false">
                </v-btn>
            <v-toolbar-title>Settings</v-toolbar-title>

            <v-spacer></v-spacer>

            <v-toolbar-items>
            <v-btn
                text="Save"
                variant="text"
                @click="dialog = false"
            ></v-btn>
            </v-toolbar-items>
            </v-toolbar>
            <v-list>
                <lesson :lesson="l" :key="l"     v-for="l in lesson.lessons"></lesson>
            </v-list>
        </v-card>
    </v-dialog>
</template>

<script lang="ts" setup>
    defineProps(['lesson'])
    let  dialog = false;

    function showGroup(data: any) {
        console.log(data)
        dialog = true;
    }
</script>