<script>
import axios from 'axios'

export default {
  data() {
    return {
      count: 0,
      val: ""
    }
  },
  mounted() {
    axios.get("api/ping").then((x) => {
      this.val = x.data
    }).catch(() => {
      this.val = "Error"
    });
  }

}

</script>

<script setup>

defineProps({
  msg: String
})

</script>

<template>
  <h1>{{ msg }}</h1>
  <h1>{{ val }}</h1>

  <div class="card">
    <button type="button" @click="count++">count is {{ count }}</button>
    <p>
      Edit
      <code>components/HelloWorld.vue</code> to test various items
    </p>
  </div>

  <p>
    Check out
    <a href="https://vuejs.org/guide/quick-start.html#local" target="_blank"
    >create-vue</a
    >, the official Vue + Vite starter
  </p>
  <p>
    Install
    <a href="https://github.com/johnsoncodehk/volar" target="_blank">Volar</a>
    in your IDE for a better DX
  </p>
  <p class="read-the-docs">Click on the Vite and Vue logos to learn more</p>
</template>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>
