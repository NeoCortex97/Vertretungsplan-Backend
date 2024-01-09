<template>
  <v-app>
    <v-toolbar density="compact" title="Vertretungsplan">
      <v-spacer></v-spacer>
      <v-btn icon><v-icon>mdi-qrcode</v-icon></v-btn>
      <v-btn icon><v-icon>mdi-cog</v-icon></v-btn>
    </v-toolbar>
    <v-main>
      <v-table>
        <thead>
          <td></td>
          <td>Montag</td>
          <td>Dienstag</td>
          <td>Mittwoch</td>
          <td>Donnerstag</td>
          <td>Freitag</td>
        </thead>
        <tr v-bind:key="i" v-for="i in stunden">
          <td>{{ i }}. Stunde</td>
          <td>{{ i }}</td>
          <td>{{ i }}</td>
          <td>{{ i }}</td>
          <td>{{ i }}</td>
          <td>{{ i }}</td>
        </tr>
      </v-table>
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
  import { ref } from 'vue';

  const stunden = ref([1, 2, 3, 4, 5, 6, 7, 8])
</script>
