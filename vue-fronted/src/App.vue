<template>
  <div class="container">
    <h1>Vue + Spring Boot 通信演示</h1>

    <div>
      <input v-model="name" placeholder="请输入你的名字" />
      <button @click="greet">发送</button>
    </div>

    <p v-if="message">{{ message }}</p>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const name = ref('')
const message = ref('')

const greet = async () => {
  try {
    const res = await fetch('http://localhost:8080/api/greet', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ name: name.value })
    })

    const data = await res.json()
    message.value = data.message
  } catch (err) {
    message.value = '请求失败'
    console.error(err)
  }
}
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: 2rem auto;
  font-family: sans-serif;
  text-align: center;
}
input {
  padding: 0.5rem;
  margin-right: 0.5rem;
}
button {
  padding: 0.5rem 1rem;
}
</style>
