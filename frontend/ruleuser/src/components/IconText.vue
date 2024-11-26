<template>
  <span class="align">
    <el-icon>
      <component :is="icon"></component>
    </el-icon>
    <span class="mar">{{text}}</span>
  </span>
</template>

<script>
export default {
  name: "IconText",
  props:['icon','text']
}
</script>

<style scoped>
.align{
  display: flex;
  justify-content: center;
  align-items: center;
}
.mar{
  margin-left: 3px;
}
</style>