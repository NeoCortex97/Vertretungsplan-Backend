/**
 * main.ts
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Plugins
import { registerPlugins } from '@/plugins'

// Components
import App from './App.vue'
// import VueQRCodeComponent from 'vue-qrcode-component';


// Composables
import { createApp } from 'vue'

const app = createApp(App)
// app.component("qr-code", VueQRCodeComponent);

registerPlugins(app)

app.mount('#app')
