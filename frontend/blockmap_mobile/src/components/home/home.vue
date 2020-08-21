<template>
  <div id="home"> <!-- 手机适配版地图 -->
    <button v-on:click="iconDo" class="choose"> <!-- 图层类型控制按钮 -->
      <img src="../../assets/button.png" alt="no resource" width="32" height="32"/>
    </button>
    <yd-popup position="left" width="60%" v-model="decisionLeft"> <!-- 左边导航弹窗 -->
      <div class="popup_left">
        <yd-flexbox> <!-- 用户名显示 -->
          <img :src="portraitUrl" alt="no resource" width="64" height="64"/>
          <!-- <yd-icon name="ucenter" color="#A9A9A9" size="1rem"></yd-icon> -->
          <yd-flexbox-item style="padding-left: 0.1rem; font-size: 0.3rem">{{userName}}</yd-flexbox-item>
        </yd-flexbox>
        <yd-cell-group> <!-- 选项卡 -->
          <yd-cell-item arrow class="select" @click.native="goToInformation">
            <yd-icon name="more" slot="icon" size=".42rem"></yd-icon>
            <label slot="left">{{$t("message.personnalinfor")}}</label>
          </yd-cell-item>
          <yd-cell-item arrow class="select" @click.native="goToSummary">
            <yd-icon name="compose" slot="icon" size=".42rem"></yd-icon>
            <label slot="left">{{$t("message.risksummary")}}</label>
          </yd-cell-item>
          <yd-cell-item arrow class="select" @click.native="goToReport">
            <yd-icon name="feedback" slot="icon" size=".42rem"></yd-icon>
            <label slot="left">{{$t("message.epidemicreport")}}</label>
          </yd-cell-item>
          <yd-cell-item arrow class="select" @click.native="goToDID">
            <yd-icon name="verifycode" slot="icon" size=".42rem"></yd-icon>
            <label slot="left">{{$t("message.dididentity")}}</label>
          </yd-cell-item>
          <yd-cell-item arrow class="select" @click.native="goToAbout">
            <yd-icon name="question" slot="icon" size=".42rem"></yd-icon>
            <label slot="left">{{$t("message.aboutus")}}</label>
          </yd-cell-item>
          <yd-cell-item arrow class="select" @click.native="goToLogin">
            <yd-icon name="home-outline" slot="icon" size=".42rem"></yd-icon>
            <label slot="left">{{$t("message.signinout")}}</label>
          </yd-cell-item>
          <yd-cell-item arrow>
            <yd-icon name="discount" slot="icon" size=".42rem"></yd-icon>
            <label slot="left">{{$t("message.selectlanguage")}}</label>
            <select slot="right" v-model="language" class="select">
              <option value="zh">{{$t("message.chinese")}}</option> <!-- 简体中文 -->
              <option value="en">{{$t("message.english")}}</option> <!-- 英语 -->
            </select>
          </yd-cell-item>
        </yd-cell-group>
      </div>
    </yd-popup>
    <yd-popup position="bottom" height="35%" v-model="decisionDown"> <!-- 下方的弹窗（路径搜索） -->
      <div class="popup_down">
        <yd-cell-group> <!--  title="Location Input" -->
          <yd-cell-item> <!--  起始点:  placeholder="please input your start place"-->
            <span slot="left">{{$t("message.startplace")}}:</span>
            <yd-input slot="right" v-model="startPlace"></yd-input>
          </yd-cell-item>
          <yd-cell-item> <!--  终点:  placeholder="please input your destination"-->
            <span slot="left">{{$t("message.destination")}}:</span>
            <yd-input slot="right" v-model="destination"></yd-input>
          </yd-cell-item>
        </yd-cell-group>
        <yd-cell-group> <!--  title="Path Option" -->
        </yd-cell-group>
        <yd-radio-group v-model="pathOption" slot="right" size="15">
          <yd-radio val="avoid risk">{{$t("message.avoidrisk")}}</yd-radio>
          <yd-radio val="shortest">{{$t("message.shortest")}}</yd-radio>
        </yd-radio-group>
        <yd-button bgcolor="#2db7f5" @click.native="checkRoad" size="large" color="#FFF">{{$t("message.pathquery")}}</yd-button> <!--  查询路径 -->
      </div>
    </yd-popup>
    <yd-button shape="angle" size="small" bgcolor="#C0C0C0" @click.native="decisionLeft = true" class="showLeft">
      <img src="../../assets/go.png" alt="no resource" width="24" height="24"/>
    </yd-button> <!-- 左边弹窗按钮 #2db7f5 -->
    <yd-button shape="circle" size="small" bgcolor="#C0C0C0" @click.native="decisionDown = true" class="showDown">
      <yd-icon name="type" color="#000" size="0.5rem"></yd-icon>
    </yd-button> <!-- 下方弹窗按钮 -->
    <div id="map"></div> <!-- 地图（openlayers） v-on:contextmenu="checkLocation($event)" -->
  </div>
</template>

<script>
import 'ol/ol.css' // 在OpenLayers 6.3.1 版本使用需要引入css
import Map from 'ol/Map' // 导入map容器
import View from 'ol/View' // 导入view视图
import LayerTile from 'ol/layer/Tile' // 导入瓦片图层
import ImageLayer from 'ol/layer/Image' // 导入图片图层
// import TileArcGISRest from 'ol/source/TileArcGISRest' // 导入arcgis服务源
import ImageWMS from 'ol/source/ImageWMS' // 导入图片WMS服务源
import VectorSource from 'ol/source/Vector' // 导入矢量源
import LayerVector from 'ol/layer/Vector' // 导入矢量图层
import Feature from 'ol/Feature' // 导入地图特征
import Style from 'ol/style/Style' // 导入样式
import Icon from 'ol/style/Icon' // 导入icon
import GeoPoint from 'ol/geom/Point' // 导入地理位置点
// import Text from 'ol/style/Text' // 导入text
// import Fill from 'ol/style/Fill' // 导入填充
import Stroke from 'ol/style/Stroke' // 导入笔画
import markImage from '../../assets/point.png' // 导入标注图
import Line from 'ol/geom/LineString' // 导入直线
import XYZ from 'ol/source/XYZ' // XYZ瓦片源
import {defaults} from 'ol/control' // 默认控件设置
import nologinportrait from '../../assets/nologin_portrait.png' // 用于本地图片引入（测试，网上图片资源不需要）
import girlportrait from '../../assets/girl_portrait.jpg' // 引入女生头像
import boyportrait from '../../assets/boy_portrait.jpg' // 引入男生头像
export default {
  name: 'home',
  data () { // 属性（数据）
    return {
      count: 0, // 用于实现图层类型切换（0为纯地图，1为玻璃图，2为疫情点地图）
      map: null, // map容器（openlayers）
      dotLayer: null, // 疫情点图层
      glassLayer: null, // 玻璃图图层
      roadLayer: null, // 路线图层
      decisionDown: false, // 用于决定下方弹窗隐藏或显示
      decisionLeft: false, // 用于决定左边弹窗隐藏或显示
      startPlace: '', // 路径起始位置
      destination: '', // 路径终点
      tiandiUrl: 'http://api.tianditu.gov.cn/geocoder?type=geocode&tk=320109f58cbb412b31e478ddc5c651bd&postStr=', // 天地图url
      // amapUrl: 'https://restapi.amap.com/v3/geocode/regeo?key=b8dd4a3e40e58d76a9805fe8847d7434&location=', // 高德地图url（逆地理编码），key需要写自己的
      vectorSource: null, // 添加标注的图层的源，因为只有矢量源才可以添加Feature
      userName: this.$t('message.nouser'), // 用户名
      pathOption: 'avoid risk', // 路径查询选项
      language: 'zh', // 语言选择
      portraitUrl: nologinportrait, // 头像地址
      loginOrNot: false
    }
  },
  mounted () { // 什么都加载好的时候
    this.map_init() // 进行地图加载（openlayers）
    this.other_init() // 其他项加载（包括语言加载、）
    // this.setRootFontSize() // 设置根元素字体大小（用于手机屏幕适配）
  },
  methods: { // 方法
    map_init () { // 地图初始化函数
      const center = [114.046, 22.620] // 地图中心（深圳）
      const geoserverUrl = 'http://113.106.111.75:5014/geoserver/BlockMap/wms' // geoserver的url
      // const globalmapUrl = 'https://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineCommunity/MapServer' // 底图url（中文）
      // const globalmapUrl = 'https://map.geoq.cn/arcgis/rest/services/ChinaOnlineCommunityENG/MapServer' // 底图url（英文）
      const token = '320109f58cbb412b31e478ddc5c651bd' // 天地图的key
      this.vectorSource = new VectorSource({}) // 创建矢量源
      this.dotLayer = new ImageLayer({ // 疫情点图层
        source: new ImageWMS({ // 设置获取源
          url: geoserverUrl, // geoserver的url
          params: {'LAYERS': 'BlockMap:ncov_china_data'}, // 图层名称
          serverType: 'geoserver' // 服务器类型是geoserver
          // crossOrigin: 'anonymous'
        }),
        opacity: 0.7 // 设置透明度为70%
      })
      this.glassLayer = new ImageLayer({ // 玻璃图层
        source: new ImageWMS({ // 设置获取源
          url: geoserverUrl, // geoserver的url
          params: {'LAYERS': 'BlockMap:ncov_china_vonoroi'}, // 图层名称
          serverType: 'geoserver' // 服务器类型是geoserver
          // crossOrigin: 'anonymous'
        }),
        opacity: 0.7 // 设置透明度为70%
      })
      this.roadLayer = new ImageLayer({ // 路线图
        source: new ImageWMS({ // 设置获取源r
          url: geoserverUrl, // geoserver的url
          params: {'LAYERS': 'BlockMap:ShortestRoad'}, // 图层名称
          serverType: 'geoserver' // 服务器类型是geoserver
          // crossOrigin: 'anonymous'
        }),
        zIndex: 9 // 设置图层在次高层
      })
      this.map = new Map({ // 创建地图容器
        target: 'map', // 设置目标为上面的map div
        layers: [
          // new LayerTile({ // 瓦片底图
          //   source: new TileArcGISRest({
          //     url: globalmapUrl
          //   })
          // }),
          new LayerTile({ // 天地图矢量图（底图之一）
            source: new XYZ({
              url: 'https://t0.tianditu.gov.cn/DataServer?T=vec_w&x={x}&y={y}&l={z}&tk=' + token
            }),
            type: 'base'
          }),
          new LayerTile({ // 天地图标注（底图之一）
            source: new XYZ({
              url: 'https://t0.tianditu.gov.cn/DataServer?T=cva_w&x={x}&y={y}&l={z}&tk=' + token
            }),
            type: 'base'
          }),
          new LayerVector({ // 绘制图标和线路的层
            source: this.vectorSource,
            zIndex: 10 // 设置图层在最高层
          })
          // new ImageLayer({ // 路网图
          //   source: new ImageWMS({ // 设置获取源
          //     url: geoserverUrl, // geoserver的url
          //     params: {'LAYERS': 'BlockMap:road'}, // 图层名称
          //     serverType: 'geoserver' // 服务器类型是geoserver
          //     // crossOrigin: 'anonymous'
          //   }),
          //   opacity: 0.7 // 设置透明度为70%
          // })
        ], // 设置图层
        view: new View({ // 设置视图
          projection: 'EPSG:4326', // 投影系
          center: center, // 初始化地图中心
          zoom: 13, // 默认缩放等级
          maxZoom: 18, // 最大缩放等级
          minZoom: 2 // 最小缩放等级
        }),
        controls: defaults({ // 禁用默认缩放按钮以及旋转按钮（功能）
          zoom: false,
          rotate: false
        })
      })
    },
    checkRoad () { // 查询路径函数
      this.vectorSource.clear() // 清除所有Feature，即点和线
      this.map.removeLayer(this.roadLayer) // 清除路线
      this.decisionDown = false // 收起弹窗
      this.map.getView().setZoom(18) // 设置放大倍数
      this.map.getView().setCenter([114.0274186903989, 22.671875493519373])
      this.addPointsFeature([[114.0274186903989, 22.671875493519373]]) // 添加起点
      setTimeout(this.mapAnimation_move, 1000) // 平移动画
      setTimeout(this.addPointForAnimation, 3000) // 添加终点
      setTimeout(this.addRoadForAnimation, 4000) // 添加路线
      setTimeout(this.mapAnimation_enlargeShrink, 5000) // 缩放动画
      setTimeout(this.endAnimation, 11000) // 添加玻璃图
    },
    mapAnimation_enlargeShrink () { // 地图缩放动画（从大到小）
      this.map.getView().animate({ // 地图缩放
        duration: 6000,
        zoom: 16
      })
    },
    mapAnimation_move () { // 地图平移动画
      this.map.getView().animate({ // 地图平移
        duration: 2000,
        center: [114.03136004058267, 22.67289465778219]
      })
    },
    endAnimation () { // 动画的结尾设置
      this.map.getView().setCenter([(114.0274186903989 + 114.03136004058267) / 2, (22.671875493519373 + 22.67289465778219) / 2]) // 设置中点为地图中心点
      this.count = 1 // 唤出玻璃图
    },
    addPointForAnimation () { // 为了动画效果
      this.map.getView().setCenter([114.03136004058267, 22.67289465778219]) // 设置终点为地图中心点
      this.addPointsFeature([[114.03136004058267, 22.67289465778219]]) // 添加终点
    },
    addRoadForAnimation () { // 为了动画效果
      this.map.addLayer(this.roadLayer) // 添加路线
    },
    addPointsFeature (coordinates) { // 加载一堆点Feature
      let featureList = []
      for (let i = 0; i < coordinates.length; ++i) { // 遍历所有点
        featureList.push(this.createPointFeature(coordinates[i]))
      }
      this.vectorSource.addFeatures(featureList)
    },
    createPointFeature (coordinate) { // 创建一个地图标注
      var feature = new Feature({
        geometry: new GeoPoint(coordinate)
      })
      feature.setStyle(new Style({
        image: new Icon({ // 设置图标
          anchor: [0.5, 1], // 设置图标偏移
          anchorOrigin: 'top-right', // 标注样式的起点位置
          // anchorXUnits: 'fraction', // X方向单位：分数
          // anchorYUnits: 'pixels', // Y方向单位：像素
          offsetOrigin: 'top-right', // 偏移起点位置的方向
          opacity: 0.9, // 透明度
          src: markImage, // 图片路径
          scale: 0.1
        })
        // text: new Text({
        //   textAlign: 'center', // 位置
        //   textBaseline: 'middle', // 基准线
        //   font: '12px Calibri,sans-serif', // 文字样式
        //   text: '标注点', // 文本内容
        //   fill: new Fill({ // 文本填充样式（即文字颜色)
        //     color: '#000'
        //   }),
        //   stroke: new Stroke({
        //     color: '#F00',
        //     width: 2
        //   })
        // })
      }))
      return feature
    },
    createLineFeature (coordinates) { // 创建线，首尾相接
      var feature = new Feature({ // 创建线feature
        geometry: new Line(coordinates)
      })
      feature.setStyle(new Style({
        stroke: new Stroke({ // 设置笔画
          width: 3,
          color: '#0F0'
        })
      }))
      return feature
    },
    addLinesFeature (coordinates) { // 画线函数（首尾相连）
      this.vectorSource.addFeature(this.createLineFeature(coordinates))
    },
    // setRootFontSize () { // 设置根元素字体大小，确定rem
    //   let root = document.documentElement || document.body // 找root，html或者是body
    //   root.style.fontSize = 13.33 + 'vw' // 这里需要解释一下，一般手机页面设计图宽为750px，也就是手机屏幕宽度，1px相当于0.13333vw，100px就是13.33vw，相当于1rem等于100px
    // },
    iconDo () { // 用于实现图层类型切换
      if (this.count === 2) {
        this.count = 0
      } else {
        this.count += 1
      }
    },
    // checkLocation (event) {
    //   event.preventDefault() // 禁止浏览器右键菜单行为
    //   let coordinate = this.map.getEventCoordinate(event) // 获取点击位置地理坐标
    //   console.log(coordinate)
    // },
    goToSummary () { // 跳转当天风险等级总结页面
      if (this.loginOrNot) { // 没有登录无法使用该功能
        this.$router.push('/summary')
      } else {
        this.$dialog.toast({
          mes: this.$t('message.loginuse'),
          timeout: 1000,
          icon: 'error'
        })
      }
    },
    goToLogin () { // 跳转登录页面
      this.$router.push('/login')
    },
    goToReport () { // 跳转上报页面
      if (this.loginOrNot) { // 没有登录无法使用该功能
        this.$router.push('/report')
      } else {
        this.$dialog.toast({
          mes: this.$t('message.loginuse'),
          timeout: 1000,
          icon: 'error'
        })
      }
    },
    goToInformation () { // 跳转个人信息页面
      if (this.loginOrNot) { // 没有登录无法使用该功能
        this.$router.push('/information')
      } else {
        this.$dialog.toast({
          mes: this.$t('message.loginuse'),
          timeout: 1000,
          icon: 'error'
        })
      }
    },
    goToDID () { // 跳转数字身份验证页面
      if (this.loginOrNot) { // 没有登录无法使用该功能
        this.$router.push('/did')
      } else {
        this.$dialog.toast({
          mes: this.$t('message.loginuse'),
          timeout: 1000,
          icon: 'error'
        })
      }
    },
    goToAbout () { // 跳转关于我们页面
      this.$router.push('/about')
    },
    other_init () { // 其他事项初始化
      this.language = sessionStorage.getItem('locale') || 'zh' // 语言项加载（刷新后也不变）
      let login = sessionStorage.getItem('login') || 'n'
      if (login === 'y') {
        this.loginOrNot = true
        this.userName = sessionStorage.getItem('username') || this.$t('message.nouser')
        let por = sessionStorage.getItem('portrait') || 'n'
        if (por === '0') {
          this.portraitUrl = boyportrait
        } else if (por === '1') {
          this.portraitUrl = girlportrait
        }
      }
    }
  },
  watch: { // 监听并执行
    count (newName, oldName) { // 监听count的变化，改变图层类型
      if (oldName === 1) { // 去除图层
        this.map.removeLayer(this.glassLayer)
      } else if (oldName === 2) {
        this.map.removeLayer(this.dotLayer)
      }
      if (newName === 1) { // 加入图层
        this.map.addLayer(this.glassLayer)
      } else if (newName === 2) {
        this.map.addLayer(this.dotLayer)
      }
    },
    language (newVal, oldVal) { // 监听语言变化
      sessionStorage.setItem('locale', newVal) // 保存在session存储
      this.$i18n.locale = newVal
      if (!this.loginOrNot) {
        if (newVal === 'en') {
          this.userName = 'Please Sign In'
        } else {
          this.userName = '请登录'
        }
      }
    }
  },
  beforeRouteEnter (to, from, next) { // 路由钩子之进入页面前调用
    if (from.name === 'register') { // 注册信息页面进来需要刷新
      sessionStorage.setItem('refresh', 'y')
    } else if (from.name === 'login') { // 登录页面进来需要刷新
      sessionStorage.setItem('refresh', 'y')
    }
    next()
  },
  activated () { // keepalive组件缓存的页面直接进入activated
    let isrefresh = sessionStorage.getItem('refresh') || 'n'
    if (isrefresh === 'y') { // 如果需要刷新
      sessionStorage.removeItem('refresh')
      window.location.reload() // 页面刷新
    }
  }
}
</script>

<style scoped>
#home{ /*全局*/
  width: 100%; /*占满*/
  height: 100%;
}
#map{ /*地图openlayers*/
  width: 100%; /*占满*/
  height: 100%;
}
.popup_down{ /*整个下部弹窗*/
  background-color: #f5f5f5; /*设置背景色*/
  padding-left: 0.5rem; /*左内边距*/
  padding-right: 0.5rem; /*右内边距*/
  padding-top: 0.2rem; /*上内边距*/
}
.popup_left{ /*这个左边弹窗*/
  padding-top: 0.2rem; /*上内边距*/
  padding-left: 0.1rem; /*左内边距*/
  padding-right: 0.1rem; /*右内边距*/
}
.showDown{ /*下方弹窗按钮*/
  position: absolute; /*相对于整个窗口的位置*/
  bottom: 0; /*贴近底部*/
  left: 43vw; /*与左边窗口的距离,43%屏幕宽度*/
  z-index: 99; /*在最高层*/
  opacity: 0.7; /*设置透明度*/
}
.choose{ /*图层类型控制按钮*/
  position: absolute; /*相对全局*/
  right: 0.1rem; /*与右边窗口的距离（根据750px做的计算，100px为1rem）*/
  top: 0.5rem; /*与上边窗口的距离*/
  z-index: 99; /*在最高层*/
  border: none; /*设置边框*/
}
.choose:active{ /*图层类型控制按钮按动效果*/
  opacity: 0.3;
}
span{ /*位置输入栏文字*/
  font-weight: bold; /*字体加粗*/
  width: 1rem; /*设置宽度*/
  text-align: center; /*文字居中*/
}
.showLeft{ /*左方弹窗按钮*/
  position: absolute;
  z-index: 99; /*在最高层*/
  opacity: 0.7; /*设置透明度*/
  top: 1rem; /*离手机顶部的距离*/
}
.select:active{ /*左边弹窗选项卡点击效果*/
  background-color: lightgrey;
}
.select{ /*选择框*/
  color: black; /*字体颜色*/
  margin-left: 0.3rem; /*左外边距*/
}
</style>
