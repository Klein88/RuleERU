
<template>
  <div>
    <input type="file" @change="handleFileUpload">
    <div v-if="data">
      <!-- 显示数据 -->
      <div v-for="(row, index) in data" :key="index">
        {{ row }}
      </div>
    </div>
  </div>
</template>


<script>
import Papa from 'papaparse';

export default {
  data() {
    return {
      data: null
    };
  },
  methods: {
    handleFileUpload(event) {
      const file = event.target.files[0];
      Papa.parse(file, {
        header: true, // 如果CSV包含标题行，将其设置为true
        complete: (result) => {
          this.data = result.data;
          console.log('Parsed Data:', this.data);
        }
      });
    }
  }
}
</script>


<style scoped>

</style>