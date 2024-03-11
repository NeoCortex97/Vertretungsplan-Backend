<template>
    <div id="code"></div>
</template>

<script lang="ts">
    import QRCode from 'ts-qrcode';

    QRCode.setCanvas('code', { text: "Hello Welt"})

</script>