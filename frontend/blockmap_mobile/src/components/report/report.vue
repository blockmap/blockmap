<template>
  <div id="report" style="height: 92vh; overflow: scroll;"> <!-- 信息上报页面（这样设置保证地图的缓存） -->
    <yd-navbar :title="$t('message.epidemicreport')"> <!-- 顶部导航栏 -->
    </yd-navbar>
    <yd-cell-group :title="$t('message.basicinformation')"> <!-- 基本信息 -->
      <yd-cell-item>
        <span slot="left">{{$t("message.realname")}}：</span> <!-- 姓名： -->
        <yd-input slot="right" v-model="yourName" :readonly="true" :show-clear-icon="false" required></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.telephone")}}：</span> <!-- 手机号码： -->
        <yd-input slot="right" v-model="phoneNumber" :readonly="true" :show-clear-icon="false" required></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.email")}}：</span> <!-- 邮箱： -->
        <yd-input slot="right" v-model="mailBox" :readonly="true" :show-clear-icon="false" required></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.sex")}}：</span> <!-- 性别： -->
        <yd-input slot="right" v-model="sex" :readonly="true" :show-clear-icon="false" required></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.age")}}：</span> <!-- 年龄： -->
        <yd-input slot="right" required v-model="age" regex="[1-9][0-9]*" ref="age"></yd-input>
      </yd-cell-item>
    </yd-cell-group>
    <yd-cell-group :title="$t('message.readdress')"> <!-- 居住地址 -->
      <yd-cell-item>
        <span slot="left">{{$t("message.province")}}：</span> <!-- 省： -->
        <yd-input slot="right" v-model="province" :readonly="true" :show-clear-icon="false" required></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.city")}}：</span> <!-- 市： -->
        <yd-input slot="right" v-model="city" :readonly="true" :show-clear-icon="false" required></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.district")}}：</span> <!-- 区： -->
        <yd-input slot="right" v-model="district" :readonly="true" :show-clear-icon="false" required></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.detailaddress")}}：</span> <!-- 详细地址： -->
        <yd-input slot="right" v-model="deaddress" :readonly="true" :show-clear-icon="false" required></yd-input>
      </yd-cell-item>
    </yd-cell-group>
    <yd-cell-group :title="$t('message.bodycondition')"> <!-- 健康状况 -->
      <yd-cell-item type="radio">
        <span slot="left">{{$t("message.healthy")}}</span> <!-- 健康 -->
        <input slot="right" type="radio" value="health" v-model="bodyHealth"/>
      </yd-cell-item>
      <yd-cell-item type="radio">
        <span slot="left">{{$t("message.sick")}}</span> <!-- 确诊 -->
        <input slot="right" type="radio" value="sick" v-model="bodyHealth"/>
      </yd-cell-item>
      <yd-cell-item type="radio">
        <span slot="left">{{$t("message.suspected")}}</span> <!-- 疑似 -->
        <input slot="right" type="radio" value="isolate" v-model="bodyHealth"/>
      </yd-cell-item>
    </yd-cell-group>
    <yd-cell-group :title="$t('message.sicksituation')" class="forsick" style="display: none"> <!-- 确诊情况 -->
      <yd-cell-item arrow>
        <span slot="left">{{$t("message.sickdate")}}：</span> <!-- 确诊日期 -->
        <yd-datetime v-model="sickDate" type="date" slot="right" start-date="2019-01-01" :yearFormat="$t('message.yearformat')" :month-format="$t('message.monthformat')" :day-format="$t('message.dayformat')"></yd-datetime>
      </yd-cell-item>
      <yd-cell-item>
        <yd-textarea slot="right" :placeholder="$t('message.pathpost')" v-model="pathPost"></yd-textarea>
      </yd-cell-item>
      <yd-cell-item>
        <yd-textarea slot="right" :placeholder="$t('message.description')" v-model="description"></yd-textarea>
      </yd-cell-item>
    </yd-cell-group>
    <div style="padding-right: 0.3rem; padding-left: 0.3rem; padding-bottom: 0.3rem" slot="right">
      <yd-button size="large" bgcolor="#1E90FF" color="#FFF" @click.native="submitReport">{{$t("message.submit")}}</yd-button> <!-- 提交 -->
    </div>
    <yd-button shape="angle" size="small" bgcolor="#C0C0C0" @click.native="backToHome" class="back">
      <img src="../../assets/back.png" alt="no resource" width="24" height="24"/>
    </yd-button> <!-- 返回按钮 #2db7f5 -->
  </div>
</template>

<script>
import axios from 'axios' // 导入ajax库
import Qs from 'qs' // 导入qs库用于编码
export default {
  name: 'report',
  data () { // 数据
    return {
      yourName: '', // 姓名
      userName: '', // 用户名
      phoneNumber: '', // 手机号（可以添加验证）
      mailBox: '', // 邮箱（可以添加验证）
      sex: '', // 性别
      age: '', // 年龄
      province: '', // 省
      city: '', // 市
      district: '', // 区
      deaddress: '', // 详细地址
      bodyHealth: 'health', // 身体健康状况
      sickDate: '', // 确诊日期
      pathPost: '', // 确诊前去过的地方
      description: '' // 备注
    }
  },
  mounted () { // 页面加载好后
    this.loadInformation() // 加载信息
  },
  methods: { // 方法
    backToHome () { // 返回地图主页
      this.$router.push('/home')
    },
    submitReport () { // 信息上报
      if (this.age === '') {
        this.showTips(this.$t('message.blank_error'), 'error')
      } else {
        let go = true
        if (this.bodyHealth === 'sick') {
          if (this.pathPost === '' || this.description === '') {
            go = false
            this.showTips(this.$t('message.blank_error'), 'error')
          }
        }
        if (go) {
          let badtip = ''
          let haveerror = false
          if (!this.$refs.age.valid) {
            haveerror = true
            badtip += this.$t('message.age_error')
          }
          if (haveerror) {
            this.showTips(badtip, 'error')
          } else {
            this.$dialog.loading.open(this.$t('message.submitting'))
            let id = sessionStorage.getItem('id')
            let date = this.bodyHealth === 'sick' ? this.sickDate : 'null'
            let pathpost = this.pathPost === '' ? 'null' : this.pathPost
            let sickstatus = this.bodyHealth === 'health' ? 2 : (this.bodyHealth === 'sick' ? 0 : 1)
            let descript = this.description === '' ? 'null' : this.description
            let param = {
              id: id,
              username: this.userName,
              gender: this.sex,
              age: this.age,
              email: this.mailBox,
              phone: this.phoneNumber,
              province: this.province,
              city: this.city,
              district: this.district,
              detailAddress: this.deaddress,
              pathPost: pathpost,
              confirmDate: date,
              status: sickstatus,
              description: descript,
              state: 'pending'
            }
            axios.post('api/blockMap/post', Qs.stringify(param)).then(
              response => {
                this.$dialog.loading.close()
                // 是否上传成功
                if (response.data.status === 'success') {
                  this.showTips(this.$t('message.submitsuccess'), 'success')// 显示上传成功框
                } else {
                  this.showTips(this.$t('message.submitfail'), 'error') // 显示上传失败框
                }
              }
            ).catch(
              error => {
                this.$dialog.loading.close()
                console.log(error)
                this.showTips(this.$t('message.networkerror'), 'error') // 显示失败框
              }
            )
          }
        }
      }
    },
    showTips (tip, type) { // 显示提示信息（tip为提示内容，type为success、error、或没有图标）
      this.$dialog.toast({
        mes: tip,
        timeout: 1000,
        icon: type
      })
    },
    loadInformation () { // 加载信息
      let id = sessionStorage.getItem('id')
      let param = {
        id: id
      }
      axios.post('api/blockMap/query', Qs.stringify(param)).then(
        response => {
          this.yourName = response.data.user.realname
          this.phoneNumber = response.data.user.phone
          this.city = response.data.user.city
          this.sex = response.data.user.gender
          this.mailBox = response.data.user.email
          this.province = response.data.user.province
          this.district = response.data.user.district
          this.deaddress = response.data.user.address
          this.userName = response.data.user.username
        }
      ).catch(
        error => {
          console.log(error)
          this.showTips(this.$t('message.networkerror'), 'error') // 显示失败框
        }
      )
    }
  },
  watch: { // 监听变化
    bodyHealth (newVal, oldVal) { // 健康状况选确诊时确诊详细情况填写才出现
      if (newVal === 'sick') {
        let item = document.getElementsByClassName('forsick')[0]
        item.style.display = 'inline'
      } else {
        if (oldVal === 'sick') {
          let item = document.getElementsByClassName('forsick')[0]
          item.style.display = 'none'
        }
      }
    }
  }
}
</script>

<style scoped>
/*
#report{
width: 100%;
height: 100%;
}
*/
.back{ /*返回按钮*/
  position: absolute;
  z-index: 99; /*在最高层*/
  opacity: 0.5; /*设置透明度*/
  top: 1.5rem; /*离手机顶部的距离*/
}
</style>
