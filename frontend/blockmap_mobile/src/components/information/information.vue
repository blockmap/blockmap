<template>
  <div id="information" style="height: 92vh; overflow: scroll;"> <!-- 个人信息页面 -->
    <yd-navbar :title="$t('message.yourpersonalinfor')"> <!-- 顶部导航栏 -->
    </yd-navbar>
    <yd-cell-group :title="$t('message.accountinfor')"> <!-- 账号信息 -->
      <yd-cell-item>
        <span slot="left">{{$t("message.portrait")}}</span> <!-- 头像 -->
        <img src="../../assets/girl_portrait.jpg" alt="no resource" width="64" height="64" slot="right"/>
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
      <yd-button size="large" type="danger" shape="angle" @click.native="showModify = true">{{$t("message.modifypersonalinfor")}}</yd-button>
    </div>
    <div style="padding-right: 0.3rem; padding-left: 0.3rem; padding-bottom: 0.3rem">
      <yd-button size="large" type="danger" shape="angle">{{$t("message.modifypassword")}}</yd-button>
    </div>
    <yd-popup v-model="showModify" position="bottom" height="100%" :close-on-masker="false"> <!-- 信息修改弹窗 -->
      <div class="modifypop">
        <yd-cell-group :title="$t('message.informodify')">
          <yd-cell-item>
            <span slot="left">{{$t("message.username")}}：</span> <!-- 用户名： -->
            <yd-input slot="right" required v-model="modifyData.userNamex"></yd-input>
          </yd-cell-item>
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
          <yd-cell-item>
            <span slot="left">{{$t("message.department")}}：</span> <!-- 所属部门 -->
            <yd-input slot="right" required v-model="modifyData.departmentx"></yd-input>
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
export default {
  name: 'information',
  data () { // 数据
    return {
      cardNumberTrue: '', // 真实的身份证号
      userName: 'xiaoxin', // 用户名
      trueName: '卫晓欣', // 姓名
      sex: 'female', // 性别
      company: 'ICBC', // 上班所在公司
      email: '0123456789@qq.com', // 邮箱
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
      modifyData: { // 需要用于监听
        userNamex: 'xiaoxin', // 用户名（修改）
        trueNamex: '卫晓欣', // 姓名（修改）
        sexx: 'female', // 性别（修改）
        companyx: 'ICBC', // 上班所在公司（修改）
        emailx: '0123456789@qq.com', // 邮箱（修改）
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
      this.showTips('修改成功', 'success')
      this.showModify = false
    },
    cancelModify () { // 取消修改的信息
      this.showModify = false
      if (!this.submitButtonDis) { // 可以使用按钮
        this.submitButtonDis = true
      }
      if (this.submitButtonType !== 'disabled') { // 修改按钮样式
        this.submitButtonType = 'disabled'
      }
      // 还需要对值进行还原
    },
    showTips (tip, type) { // 显示提示信息（tip为提示内容，type为success、error、或没有图标）
      this.$dialog.toast({ // 显示上传成功框（上传成功）
        mes: tip,
        timeout: 1000,
        icon: type
      })
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
