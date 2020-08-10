<template>
    <div id="viewer"> <!-- 3D动画页面 -->
      <vc-viewer ref="vcViewer" @ready="ready"> <!-- 3D地图 -->
        <vc-layer-imagery>
          <vc-provider-imagery-arcgis-mapserver :url="'https://services.arcgisonline.com/arcgis/rest/services/World_Street_Map/MapServer'"></vc-provider-imagery-arcgis-mapserver>
        </vc-layer-imagery>
      </vc-viewer>
    </div>
</template>

<script>
export default {
  name: 'goodmap',
  data () { // 数据
    return {
      timer: null, // 定时器
      viewer: null, // Cesium的Viewer对象
      cesium: null, // Cesium对象
      lon: null, // 经度
      time: null, // 移动次数，用于自转动画
      forCesium: null
    }
  },
  methods: { // 方法
    ready (cesiumInstance) { // cesium渲染完成时进行调用，可以根据这个来获取Cesium和其viewer对象（异步加载的不能在mount中调用）
      const { Cesium, viewer } = cesiumInstance
      this.forCesium = Cesium // 自转第一种方法，这里的赋值用来避免Cesium没有用到报错
      this.lon = viewer.camera.positionWC.x // 获取相机默认中心点的经度
      this.time = 900 // 移动次数
      this.timer = setInterval(this.doRotate, 10) // 每10ms移动一次
      // this.x = Cesium // 自转第二种方法，有缺陷，导致地图加载不成功
      // this.time = Date.now()
      // viewer.clock.onTick.addEventListener(this.doRotate)
      // setTimeout(this.stopListener, 5000)
    },
    doRotate () { // 自转动画
      this.lon = this.lon + 0.3 // 第一种方法
      if (this.lon >= 178.5) { // 经度最大180
        this.lon = -180
      }
      this.viewer.camera.setView({
        destination: this.cesium.Cartesian3.fromDegrees(this.lon, 0, 20000000)
      })
      this.time = this.time - 1
      if (this.time === 0) {
        clearInterval(this.timer) // 清除定时器
        this.viewer.camera.setView({
          destination: this.cesium.Cartesian3.fromDegrees(116.41667, 39.91667, 20000000) // 设置中心（北京）
        })
        this.time = 195 // 缩放次数
        this.timer = setInterval(this.doZoom, 10) // 每10ms缩放一次
      }
      // var a = 0.1 // 第二种方法
      // var t = Date.now()
      // var n = (t - this.time) / 1e3
      // this.time = t
      // this.viewer.camera.rotate(this.cesium.Cartesian3.UNIT_Z, -a * n)
    },
    // stopListener () { // 配合自传第二种方法使用
    //   this.viewer.clock.onTick.removeEventListener(this.doRotate)
    // },
    doZoom () { // 缩放动画
      this.viewer.camera.zoomIn(100000)
      this.time = this.time - 1
      if (this.time === 0) {
        clearInterval(this.timer)
        this.$router.push('/home') // 动画完毕，进入主页
      }
    }
  },
  mounted () {
    this.$refs.vcViewer.createPromise.then(({Cesium, viewer}) => { // 必须捕获，不然会报错
      viewer.cesiumWidget.creditContainer.style.display = 'none' // 去掉cesium的logo
      this.cesium = Cesium // 在这里获取Cesium和Viewer
      this.viewer = viewer
    })
  }
}
</script>

<style scoped>
#viewer{
  width: 100%;
  height: 100%;
}
</style>
