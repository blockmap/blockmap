<template>
    <div></div> <!-- 设备判断页 -->
</template>

<script>
import Device from '../method/device' // 导入设备判断
export default {
  name: 'judge',
  mounted () {
    if (Device.isIOS) { // 是ios系统
      this.$router.push('/normalmap')
    } else {
      this.$router.push('/goodmap')
    }
  }
}
</script>

<style scoped>

</style>
