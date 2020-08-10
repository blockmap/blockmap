<template>
  <div id="normalmap"><!-- 普通地球动画页 -->
  </div>
</template>

<script>
export default {
  name: 'normalmap',
  mounted () {
    setTimeout(this.toHome, 2800)
  },
  methods: {
    toHome () { // 挑战到主页面
      this.$router.push('/home')
    }
  }
}
</script>

<style scoped>
#normalmap{ /*全局*/
  width: 100%; /*填满*/
  height: 100%;
  background: url("../../assets/ip_background.jpg") no-repeat center; /*设置背景图片*/
  background-size: cover;
  animation-name: magnify; /*用下面的地球放大动画*/
  -webkit-animation-name: magnify;  /*兼容Safari和Chrome*/
  animation-duration: 1.5s; /*动画持续时间为1s*/
  -webkit-animation-duration: 1.5s; /*兼容Safari和Chrome*/
  animation-timing-function: linear; /*线性函数递增透明值*/
  -webkit-animation-timing-function: linear; /*兼容Safari和Chrome*/
  animation-delay: 1.5s; /*动画开始前的延迟*/
  -webkit-animation-delay: 1.5s; /*兼容Safari和Chrome*/
}
@keyframes magnify { /*地球放大动画*/
  from{
    transform: scale(1); /*初始状态*/
    -webkit-transform: scale(1);
  }
  to{
    transform: scale(5); /*结束状态*/
    -webkit-transform: scale(5);
  }
}
@-moz-keyframes magnify { /*兼容firefox*/
  from{
    transform: scale(1); /*初始状态*/
    -webkit-transform: scale(1);
  }
  to{
    transform: scale(5); /*结束状态*/
    -webkit-transform: scale(5);
  }
}
@-webkit-keyframes magnify { /*兼容Safari和Chrome*/
  from{
    transform: scale(1); /*初始状态*/
    -webkit-transform: scale(1);
  }
  to{
    transform: scale(5); /*结束状态*/
    -webkit-transform: scale(5);
  }
}
@-o-keyframes magnify { /*兼容Opera*/
  from{
    transform: scale(1); /*初始状态*/
    -webkit-transform: scale(1);
  }
  to{
    transform: scale(5); /*结束状态*/
    -webkit-transform: scale(5);
  }
}
</style>
