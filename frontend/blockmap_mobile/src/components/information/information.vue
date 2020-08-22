<template>
  <div id="information" style="height: 92vh; overflow: scroll;"> <!-- 个人信息页面 -->
    <yd-navbar :title="$t('message.yourpersonalinfor')"> <!-- 顶部导航栏 -->
    </yd-navbar>
    <yd-cell-group :title="$t('message.accountinfor')"> <!-- 账号信息 -->
      <yd-cell-item>
        <span slot="left">{{$t("message.portrait")}}</span> <!-- 头像 -->
        <img :src="portrait" alt="no resource" width="64" height="64" slot="right"/>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.username")}}</span> <!-- 用户名 -->
        <span slot="right">{{userName}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.email")}}</span> <!-- 邮箱 -->
        <span slot="right">{{email}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.telephone")}}</span> <!-- 手机号码： -->
        <span slot="right">{{phoneNumber}}</span>
      </yd-cell-item>
    </yd-cell-group>
    <yd-cell-group :title="$t('message.otherinfor')"> <!-- 其他信息 -->
      <yd-cell-item>
        <span slot="left">{{$t("message.realname")}}</span> <!-- 姓名 -->
        <span slot="right">{{trueName}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.sex")}}</span> <!-- 性别 -->
        <span slot="right">{{sex}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.company")}}</span> <!-- 所属公司 -->
        <span slot="right">{{company}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.department")}}</span> <!-- 所属部门 -->
        <span slot="right">{{department}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.country")}}</span> <!-- 国籍： -->
        <span slot="right">{{country}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.province")}}</span> <!-- 省： -->
        <span slot="right">{{province}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.city")}}</span> <!-- 市： -->
        <span slot="right">{{city}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.district")}}</span> <!-- 区： -->
        <span slot="right">{{district}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">{{$t("message.detailaddress")}}</span> <!-- 详细地址： -->
        <span slot="right">{{deaddress}}</span>
      </yd-cell-item>
    </yd-cell-group>
    <div style="padding-right: 0.3rem; padding-left: 0.3rem">
      <yd-button size="large" type="danger" shape="angle" @click.native="toModify">{{$t("message.modifypersonalinfor")}}</yd-button>
    </div>
    <yd-popup v-model="showModify" position="bottom" height="100%" :close-on-masker="false"> <!-- 信息修改弹窗 -->
      <div class="modifypop">
        <yd-cell-group :title="$t('message.informodify')">
          <yd-cell-item>
            <span slot="left">{{$t("message.realname")}}：</span> <!-- 姓名： -->
            <yd-input slot="right" required v-model="modifyData.trueNamex"></yd-input>
          </yd-cell-item>
          <yd-cell-item arrow>
            <span slot="left">{{$t("message.sex")}}：</span> <!-- 性别： -->
            <select slot="right" v-model="modifyData.sexx" class="select">
              <option value="male">{{$t("message.male")}}</option> <!-- 男 -->
              <option value="female">{{$t("message.female")}}</option> <!-- 女 -->
            </select>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.email")}}：</span> <!-- 邮箱： -->
            <yd-input slot="right" v-model="modifyData.emailx" required regex="email" ref="email"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.telephone")}}：</span> <!-- 手机号码： -->
            <yd-input slot="right" v-model="modifyData.phoneNumberx" required regex="mobile" ref="phoneNumber"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.cardnumber")}}：</span> <!-- 身份证号： -->
            <yd-input slot="right" v-model="modifyData.cardNumberx" :placeholder="cardNumber" ref="cardNumber" regex="^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.company")}}：</span> <!-- 所属公司 -->
            <yd-input slot="right" v-model="modifyData.companyx" required></yd-input>
          </yd-cell-item>
          <yd-cell-item arrow>
            <span slot="left">{{$t("message.department")}}：</span> <!-- 所属部门 -->
            <select slot="right" v-model="modifyData.departmentx" class="select" id="departItem">
            </select>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.country")}}：</span> <!-- 国籍： -->
            <yd-input slot="right" required v-model="modifyData.countryx"></yd-input>
          </yd-cell-item>
          <yd-cell-item arrow>
            <span slot="left">{{$t("message.province")}}：</span> <!-- 省： -->
            <select slot="right" v-model="modifyData.provincex" class="select">
              <option v-for="item in provinces" :value="item.name" :key="item.name">{{item.word}}</option> // 这个版本的v-for需要key
            </select>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.city")}}：</span> <!-- 市： -->
            <yd-input slot="right" v-model="modifyData.cityx" required></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.district")}}：</span> <!-- 区： -->
            <yd-input slot="right" v-model="modifyData.districtx" required></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.detailaddress")}}：</span> <!-- 详细地址： -->
            <yd-input slot="right" v-model="modifyData.deaddressx" required></yd-input>
          </yd-cell-item>
        </yd-cell-group>
        <yd-button size="large" v-bind:type="submitButtonType" v-bind:disabled="submitButtonDis" @click.native="submitModify">{{$t("message.confirmsubmit")}}</yd-button>
        <yd-button size="large" type="hollow" @click.native="cancelModify">{{$t("message.cancel")}}</yd-button>
      </div>
    </yd-popup>
    <yd-button shape="angle" size="small" bgcolor="#C0C0C0" @click.native="backToHome" class="back">
      <img src="../../assets/back.png" alt="no resource" width="24" height="24"/>
    </yd-button> <!-- 返回按钮 #2db7f5 -->
  </div>
</template>

<script>
import getAllProvince from '../../data/province' // 导入获取省份数据函数
import axios from 'axios' // 导入ajax库
import Qs from 'qs' // 导入参数转化库
import girlportrait from '../../assets/girl_portrait.jpg' // 引入女生头像
import boyportrait from '../../assets/boy_portrait.jpg' // 引入男生头像
export default {
  name: 'information',
  data () { // 数据
    return {
      cardNumberTrue: '', // 真实的身份证号
      password: '', // 保存密码
      userName: '', // 用户名
      trueName: '', // 姓名
      sex: '', // 性别
      company: '', // 上班所在公司
      email: '', // 邮箱
      cardNumber: '', // 身份证号（处理过的）
      phoneNumber: '', // 电话号码
      department: '', // 所属部门
      country: '', // 国籍
      province: '', // 省
      city: '', // 市
      district: '', // 区
      deaddress: '', // 详细地址
      showModify: false, // 是否显示修改信息弹窗
      submitButtonDis: true, // 提交按钮是否可用
      submitButtonType: 'disabled', // 提交按钮样式
      provinces: null, // 所有省份数据
      portrait: '', // 头像
      imgurl: null, // 保存头像选择
      status: null, // 保存身体状态
      age: null, // 保存年龄
      lat: null,
      lon: null,
      modifyData: { // 需要用于监听
        trueNamex: '', // 姓名（修改）
        sexx: '', // 性别（修改）
        companyx: '', // 上班所在公司（修改）
        emailx: '', // 邮箱（修改）
        cardNumberx: '', // 身份证号（修改）
        phoneNumberx: '', // 电话号码（修改）
        departmentx: '', // 所属部门（修改）
        countryx: '', // 国籍（修改）
        provincex: '', // 省（修改）
        cityx: '', // 市（修改）
        districtx: '', // 区（修改）
        deaddressx: '' // 详细地址（修改）
      }
    }
  },
  methods: {
    backToHome () { // 返回地图主页
      this.$router.push('/home')
    },
    submitModify () { // 提交修改信息
      if (this.modifyData.sexx === '' || this.modifyData.emailx === '' || this.modifyData.companyx === '' ||
        this.modifyData.departmentx === '' || this.modifyData.phoneNumberx === '' || this.modifyData.countryx === '' || this.modifyData.trueNamex === '' ||
        this.modifyData.provincex === '' || this.modifyData.cityx === '' || this.modifyData.districtx === '' || this.modifyData.deaddressx === '') {
        this.showTips(this.$t('message.blank_error'), 'error')
      } else {
        let badtip = ''
        let haveerror = false
        if (!this.$refs.email.valid) {
          haveerror = true
          badtip += this.$t('message.email_error')
        }
        if (this.modifyData.cardNumberx !== '') {
          if (!this.$refs.cardNumber.valid) {
            haveerror = true
            badtip += this.$t('message.cardnum_error')
          }
        }
        if (!this.$refs.phoneNumber.valid) {
          haveerror = true
          badtip += this.$t('message.phonenum_error')
        }
        if (haveerror) {
          this.showTips(badtip, 'error')
        } else {
          this.$dialog.loading.open(this.$t('message.submitting'))
          let id = sessionStorage.getItem('id')
          let gender = this.modifyData.sexx === 'male' ? '男' : '女'
          let card = this.modifyData.cardNumberx === '' ? this.cardNumberTrue : this.modifyData.cardNumberx
          let param = {
            // 参数
            id: id,
            username: this.userName,
            password: this.password,
            realname: this.modifyData.trueNamex,
            identity: card,
            email: this.modifyData.emailx,
            phone: this.modifyData.phoneNumberx,
            institutionid: this.modifyData.companyx,
            subinstitutionid: this.modifyData.departmentx,
            type: 1, // 普通用户
            gender: gender,
            age: this.age,
            status: this.status, // 健康状况默认2，即健康
            country: this.modifyData.countryx,
            province: this.modifyData.provincex,
            city: this.modifyData.cityx,
            district: this.modifyData.districtx,
            address: this.modifyData.deaddressx,
            imgurl: this.imgurl,
            lon: this.lon,
            lat: this.lat
          }
          axios.post('api/blockMap/update', Qs.stringify(param)).then(
            response => {
              this.$dialog.loading.close()
              // 是否修改成功
              if (response.data.status === 'success') {
                this.showTips(this.$t('message.modifysuccess'), 'success')
                // 反填
                let sex = this.modifyData.sexx === 'male' ? '男' : '女'
                if (this.modifyData.cardNumberx !== '') {
                  this.cardNumberTrue = this.modifyData.cardNumberx
                  this.cardNumber = this.cardNumber = this.cardNumberTrue.substring(0, 5) + '**********' + this.cardNumberTrue.slice(-3)
                }
                this.department = this.modifyData.departmentx // 对信息进行反填充
                this.phoneNumber = this.modifyData.phoneNumberx
                this.city = this.modifyData.cityx
                this.trueName = this.modifyData.trueNamex
                this.sex = sex
                this.company = this.modifyData.companyx
                this.email = this.modifyData.emailx
                this.country = this.modifyData.countryx
                this.province = this.modifyData.provincex
                this.district = this.modifyData.districtx
                this.deaddress = this.modifyData.deaddressx
                this.showModify = false // 收起弹窗
                if (!this.submitButtonDis) { // 不可以使用按钮
                  this.submitButtonDis = true
                }
                if (this.submitButtonType !== 'disabled') { // 修改按钮样式
                  this.submitButtonType = 'disabled'
                }
              } else {
                this.showTips(this.$t('message.modifyfail'), 'error') // 显示上传失败框
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
    },
    cancelModify () { // 取消修改的信息
      this.showModify = false
      if (!this.submitButtonDis) { // 不可以使用按钮
        this.submitButtonDis = true
      }
      if (this.submitButtonType !== 'disabled') { // 修改按钮样式
        this.submitButtonType = 'disabled'
      }
    },
    showTips (tip, type) { // 显示提示信息（tip为提示内容，type为success、error、或没有图标）
      this.$dialog.toast({ // 显示上传成功框（上传成功）
        mes: tip,
        timeout: 1000,
        icon: type
      })
    },
    toModify () { // 显示修改信息页面
      let sex = this.sex === '男' ? 'male' : 'female'
      this.modifyData.departmentx = this.department // 对信息进行填充
      this.modifyData.phoneNumberx = this.phoneNumber
      this.modifyData.cityx = this.city
      this.modifyData.trueNamex = this.trueName
      this.modifyData.sexx = sex
      this.modifyData.companyx = this.company
      this.modifyData.emailx = this.email
      this.modifyData.cardNumberx = ''
      this.modifyData.countryx = this.country
      this.modifyData.provincex = this.province
      this.modifyData.districtx = this.district
      this.modifyData.deaddressx = this.deaddress
      this.showModify = true // 弹窗显示
    },
    loadInformation () { // 加载信息
      let id = sessionStorage.getItem('id')
      let port = sessionStorage.getItem('portrait')
      if (port === '0') {
        this.portrait = boyportrait
      } else {
        this.portrait = girlportrait
      }
      this.imgurl = port
      let param = {
        id: id
      }
      axios.post('api/blockMap/query', Qs.stringify(param)).then(
        response => {
          this.department = response.data.user.subinstitutionid // 对信息进行填充
          this.phoneNumber = response.data.user.phone
          this.city = response.data.user.city
          this.userName = response.data.user.username
          this.trueName = response.data.user.realname
          this.sex = response.data.user.gender
          this.company = response.data.user.institutionid
          this.email = response.data.user.email
          this.password = response.data.user.password
          this.cardNumberTrue = response.data.user.identity
          this.country = response.data.user.country
          this.province = response.data.user.province
          this.district = response.data.user.district
          this.deaddress = response.data.user.address
          this.cardNumber = response.data.user.identity.substring(0, 5) + '**********' + response.data.user.identity.slice(-3)
          this.status = response.data.user.status
          this.age = response.data.user.age
          this.lon = response.data.user.lon
          this.lat = response.data.user.lat
        }
      ).catch(
        error => {
          console.log(error)
          this.showTips(this.$t('message.networkerror'), 'error') // 显示失败框
        }
      )
      axios.post('api/blockMap/allsubinstitution').then(
        response => {
          // 动态添加选项
          let options = response.data.data
          let selectItem = document.getElementById('departItem')
          for (let i = 0; i < options.length; ++i) {
            let option = document.createElement('option')
            option.value = options[i]
            option.text = options[i]
            selectItem.options.add(option)
          }
        }
      ).catch(
        error => {
          console.log(error)
          this.showTips(this.$t('message.networkerror'), 'error') // 显示失败框
        }
      )
    }
  },
  watch: {
    modifyData: {
      deep: true, // 深度监听，看值是否有变化
      handler: function (newVal, oldVal) {
        if (this.submitButtonDis) { // 可以使用按钮
          this.submitButtonDis = false
        }
        if (this.submitButtonType === 'disabled') { // 修改按钮样式
          this.submitButtonType = 'primary'
        }
      }
    }
  },
  mounted () { // 渲染完成后
    this.provinces = getAllProvince(this) // 获取所有省份数据
    this.loadInformation() // 加载页面信息
  }
}
</script>

<style scoped>
/*
#information{
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
.select{ /*选择框*/
  color: black; /*字体颜色*/
  margin-left: 0.3rem; /*左外边距*/
}
.modifypop{ /*修改信息弹窗*/
  padding: 0.2rem 0.3rem 1rem; /*内边距*/
  background-color: #f5f5f5; /*设置背景颜色*/
  height: 92vh; /*高度*/
  overflow: scroll; /*多余滚动*/
}
</style>
