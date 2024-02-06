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
            <div v-if="i < stunden.monday.length && stunden.monday[i - 1].group == undefined">
              <div class="cell rounded-lg" :key="key" v-for="(lesson, key) in stunden.monday[i - 1].lessons" v-if="i < stunden.monday.length">
                <span class="block font-weight-black">{{ lesson.subj }}</span>
                <span class="block">{{ lesson.teacher }}</span>
                <span class="block font-weight-thin">{{ (lesson.room.length > 0 ? lesson.room : '-') }}</span>
              </div>
            </div>
            <div v-else>
              <div class="cell rounded-lg" v-if="i < stunden.monday.length" @click="showGroup(stunden.monday[i- 1])">
                <span class="block font-weight-black">{{ stunden.monday[i - 1].group }}</span>
                <span class="block">GRUPPIERT</span>
                <span class="block font-weight-thin">Für details antippen</span>
              </div>
            </div>
          </td>
          <td>
            <div v-if="i < stunden.tuesday.length && stunden.tuesday[i - 1].group == undefined">
              <div class="cell rounded-lg" :key="key" v-for="(lesson, key) in stunden.tuesday[i - 1].lessons" v-if="i < stunden.tuesday.length">
                <span class="block font-weight-black">{{ lesson.subj }}</span>
                <span class="block">{{ lesson.teacher }}</span>
                <span class="block font-weight-thin">{{ (lesson.room.length > 0 ? lesson.room : '-') }}</span>
              </div>
            </div>
            <div v-else>
              <div class="cell rounded-lg" v-if="i < stunden.tuesday.length">
                <span class="block font-weight-black">{{ stunden.tuesday[i - 1].group }}</span>
                <span class="block">GRUPPIERT</span>
                <span class="block font-weight-thin">Für details antippen</span>
              </div>
            </div>
          </td>
          <td>
            <div v-if="i < stunden.wednesday.length && stunden.wednesday[i - 1].group == undefined">
              <div class="cell rounded-lg" :key="key" v-for="(lesson, key) in stunden.wednesday[i - 1].lessons" v-if="i < stunden.wednesday.length">
                <span class="block font-weight-black">{{ lesson.subj }}</span>
                <span class="block">{{ lesson.teacher }}</span>
                <span class="block font-weight-thin">{{ (lesson.room.length > 0 ? lesson.room : '-') }}</span>
              </div>
            </div>
            <div v-else>
              <div class="cell rounded-lg" v-if="i < stunden.wednesday.length">
                <span class="block font-weight-black">{{ stunden.wednesday[i - 1].group }}</span>
                <span class="block">GRUPPIERT</span>
                <span class="block font-weight-thin">Für details antippen</span>
              </div>
            </div>
          </td>
          <td>
            <div v-if="i < stunden.thursday.length && stunden.thursday[i - 1].group == undefined">
              <div class="cell rounded-lg" :key="key" v-for="(lesson, key) in stunden.thursday[i - 1].lessons" v-if="i < stunden.thursday.length">
                <span class="block font-weight-black">{{ lesson.subj }}</span>
                <span class="block">{{ lesson.teacher }}</span>
                <span class="block font-weight-thin">{{ (lesson.room.length > 0 ? lesson.room : '-') }}</span>
              </div>
            </div>
            <div v-else>
              <div class="cell rounded-lg" v-if="i < stunden.thursday.length">
                <span class="block font-weight-black">{{ stunden.thursday[i - 1].group }}</span>
                <span class="block">GRUPPIERT</span>
                <span class="block font-weight-thin">Für details antippen</span>
              </div>
            </div>
          </td>
          <td>
            <div v-if="i < stunden.friday.length && stunden.friday[i - 1].group == undefined">
              <div class="cell rounded-lg" :key="key" v-for="(lesson, key) in stunden.friday[i - 1].lessons" v-if="i < stunden.friday.length">
                <span class="block font-weight-black">{{ lesson.subj }}</span>
                <span class="block">{{ lesson.teacher }}</span>
                <span class="block font-weight-thin">{{ (lesson.room.length > 0 ? lesson.room : '-') }}</span>
              </div>
            </div>
            <div v-else>
              <div class="cell rounded-lg" v-if="i < stunden.friday.length">
                <span class="block font-weight-black">{{ stunden.friday[i - 1].group }}</span>
                <span class="block">GRUPPIERT</span>
                <span class="block font-weight-thin">Für details antippen</span>
              </div>
            </div>
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

  function showGroup(data: any) {
    console.log(data)
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
