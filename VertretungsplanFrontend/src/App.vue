<template>
  <v-app theme="dark">
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
        <tr v-bind:key="i" v-for="i in maxLen">
          <td class="term">{{ i - 1 }}</td>
          <td>
            <lesson-cell :day="stunden.monday" :i="i"/>
          </td>
          <td>
            <lesson-cell :day="stunden.tuesday" :i="i"/>
          </td>
          <td>
            <lesson-cell :day="stunden.wednesday" :i="i"/>
          </td>
          <td>
            <lesson-cell :day="stunden.thursday" :i="i"/>
          </td>
          <td>
            <lesson-cell :day="stunden.friday" :i="i"/>
          </td>
        </tr>
      </v-table>
      <!-- <qr-code text="TEST"></qr-code> -->
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
  import { ref } from 'vue';

  type ObjectKey = keyof typeof data;

  const data = {
    monday: [
      {lessons: []},
      {lessons: [{subj: "englisch", teacher: "Dr. Nina Tomaszewski", room: "M02"}]},
      {lessons: [{subj: "englisch", teacher: "Dr. Nina Tomaszewski", room: "M02"}]},
      {lessons: [
        {subj: "Französisch als 3. Fremdsprache", teacher: "Labes", room: "H306"},
        {subj: "PK/R", teacher: "Knuds", room: "M02"},
        {subj: "BI/CH", teacher: "Gunzer", room: "H308"},
        {subj: "E/GES", teacher: "Kircher", room: "M03"},
        ],
        group: "Differenzierungsunterricht"
      },
      {lessons: [{subj: "Geschichte", teacher: "Hedwig Maria Deffer", room: "H206"}]},
      {lessons: [{subj: "Sport", teacher: "Daniel Schüller", room: "SP1"}]},
      {lessons: [{subj: "Biologie", teacher: "Daniel Schüller", room: "U11"}]}],
    tuesday: [
      {lessons: []},
      {lessons: [
        {subj: "Praktisch", teacher: "Jörg Rollert", room: "H004"},
        {subj: "REL-1", teacher: "Bowyer", room: "M21"},
        {subj: "REL-2", teacher: "Langwald", room: "M22"},
        {subj: "REL-3", teacher: "Kircher", room: "M03"},
      ], group: "Religion"},
      {lessons: [{subj: "Kunst", teacher: "Ahlers", room: "H004"}]},
      {lessons: [{subj: "Kunst", teacher: "Ahlers", room: "H004"}]},
      {lessons: [
        {subj: "Französisch", teacher: "Labes", room: "H306"},
        {subj: "PK/R", teacher: "Knuds", room: "M02"},
        {subj: "BI/CH", teacher: "Gunzer", room: "H308"},
        {subj: "E/GES", teacher: "Kircher", room: "M03"},
      ], group: "fremdsprache "},
      {lessons: [
        {subj: "Französisch", teacher: "Labes", room: "H306"},
        {subj: "PK/R", teacher: "Knuds", room: "M02"},
        {subj: "BI/CH", teacher: "Gunzer", room: "H308"},
        {subj: "E/GES", teacher: "Kircher", room: "M03"},
      ]}],
    wednesday: [
      {lessons: []},
      {lessons: [{subj: "Französisch als 3. Fremdsprache", teacher: "Florian Labes", room: "H306"}]},
      {lessons: [{subj: "Sport", teacher: "Daniel Schüller", room: "SP1"}]},
      {lessons: [{subj: "Deutsch", teacher: "Alexandra Berg-Karlsson", room: "H206"}]},
      {lessons: [{subj: "Biologie", teacher: "Daniel Schüller", room: "U11"}]},
      {lessons: [{subj: "MAthematik", teacher: "Konstantin Fischer", room: "H206"}]},
      {lessons: [{subj: "MAthematik", teacher: "Konstantin Fischer", room: "H206"}]},
      {lessons: [{subj: "Englisch", teacher: "Dr. Nina Tomaszewski", room: "M02"}]}],
    thursday: [
      {lessons: []},
      {lessons: [{subj: "Chemie", teacher: "Dr. Michaela Wahl", room: ""}]},
      {lessons: [{subj: "Chemie", teacher: "Dr. Michaela Wahl", room: ""}]},
      {lessons: [
        {subj: "Spanisch als 3. Fremdsprache", teacher: "Navalpotr", room: "M23"},
        {subj: "Spanisch als 3. Fremdsprache", teacher: "Langos", room: "M04"},
        {subj: "Französisch als 3. Fremdsprache", teacher: "Molch", room: "M02"},
        {subj: "Latein", teacher: "Grimmeis", room: "M22"},
      ], group: "Fremdsprache"},
      {lessons: [{subj: "Deutsch", teacher: "Alexandra Berg-Karlsson", room: "H206"}]},
      {lessons: [{subj: "Deutsch", teacher: "Alexandra Berg-Karlsson", room: "H206"}]}],
    friday: [
      {lessons: []},
      {lessons: [{subj: "Deutsch", teacher: "Alexandra Berg-Karlsson", room: "H206"}]},
      {lessons: [{subj: "Deutsch", teacher: "Alexandra Berg-Karlsson", room: "H206"}]},
      {lessons: [
        {subj: "Spanisch als 3. Fremdsprache", teacher: "Navalpotr", room: "M23"},
        {subj: "Spanisch als 3. Fremdsprache", teacher: "Langos", room: "M04"},
        {subj: "Französisch als 3. Fremdsprache", teacher: "Molch", room: "M02"},
        {subj: "Latein", teacher: "Grimmeis", room: "M22"},
      ], group: "Fremdsprachen"},
      {lessons: [{subj: "Deutsch", teacher: "Alexandra Berg-Karlsson", room: "H206"}]},
      {lessons: [{subj: "Deutsch", teacher: "Alexandra Berg-Karlsson", room: "H206"}]}],
  };
  
  function getLessonData(data: ObjectKey) {
    return 
  }
  
  const maxLen = Math.max(...Object.values(data).map(a => a.length));
  
  const stunden = data
  console.log(stunden)
</script>

<style>
  .cell {
    background-color: #555;
    color: whitesmoke;
    margin: 2px;
    padding: 5px;
  }

  .block {
    display: block;
  }

  .term {
    min-width: 20px;
  }

  th.td {
    min-height: 50px;
  }
</style>
