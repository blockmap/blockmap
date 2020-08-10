<template>
  <div id="register"> <!-- 注册填写信息页 -->
    <div style="margin-top: 1rem; margin-left: 0.3rem; margin-right: 0.3rem;">
      <yd-step v-bind:current="whichStep" current-color="#1E90FF">
        <yd-step-item>
          <span slot="bottom">{{$t("message.selectportrait")}}</span>
        </yd-step-item>
        <yd-step-item>
          <span slot="bottom">{{$t("message.completeinformation")}}</span>
        </yd-step-item>
      </yd-step>
      <div class="content_first">
        <yd-tab style="margin-top: 0.3rem" v-model="whichPic">
          <yd-tab-panel :label="$t('message.portraitfirst')">
            <div style="width: 100%; height: 6rem" v-on:click="selectPortrait">
              <label>{{$t("message.clickselect")}}</label>
              <img src="../../assets/boy_portrait.jpg" alt="no resource" width="200" height="200"/>
            </div>
          </yd-tab-panel>
          <yd-tab-panel :label="$t('message.portraitsecond')">
            <div style="width: 100%; height: 6rem" v-on:click="selectPortrait">
              <label>{{$t("message.clickselect")}}</label>
              <img src="../../assets/girl_portrait.jpg" alt="no resource" width="200" height="200"/>
            </div>
          </yd-tab-panel>
        </yd-tab>
      </div>
      <div class="content_second" style="padding-bottom: 0.3rem;">
        <yd-cell-group :title="$t('message.personnalinfor')"> <!-- 个人信息 -->
          <yd-cell-item>
            <span slot="left">{{$t("message.realname")}}：</span> <!-- 姓名： -->
            <yd-input slot="right" required v-model="yourName"></yd-input>
          </yd-cell-item>
          <yd-cell-item arrow>
            <span slot="left">{{$t("message.sex")}}：</span> <!-- 性别： -->
            <select slot="right" v-model="sex" class="select">
              <option value="male">{{$t("message.male")}}</option> <!-- 男 -->
              <option value="female">{{$t("message.female")}}</option> <!-- 女 -->
            </select>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.cardnumber")}}：</span> <!-- 身份证号： -->
            <yd-input slot="right" required v-model="cardNumber" ref="cardNum" regex="^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.email")}}：</span> <!-- 邮箱： -->
            <yd-input slot="right" v-model="mailBox" required regex="email" ref="email"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.telephone")}}：</span> <!-- 手机号码： -->
            <yd-input slot="right" v-model="phoneNumber" required regex="mobile" ref="phoneNumber"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.country")}}：</span> <!-- 国籍： -->
            <yd-input slot="right" required v-model="country"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.company")}}：</span> <!-- 所属公司 -->
            <yd-input slot="right" required v-model="company"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.department")}}：</span> <!-- 所属部门 -->
            <yd-input slot="right" required v-model="department"></yd-input>
          </yd-cell-item>
          <yd-cell-item arrow>
            <span slot="left">{{$t("message.province")}}：</span> <!-- 省： -->
            <select slot="right" v-model="province" class="select">
              <option v-for="item in provinces" :value="item.name" :key="item.name">{{item.word}}</option> // 这个版本的v-for需要key
            </select>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.city")}}：</span> <!-- 市： -->
            <yd-input slot="right" v-model="city" required></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.district")}}：</span> <!-- 区： -->
            <yd-input slot="right" v-model="district" required></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">{{$t("message.detailaddress")}}：</span> <!-- 详细地址： -->
            <yd-input slot="right" v-model="deaddress" required></yd-input>
          </yd-cell-item>
        </yd-cell-group>
        <yd-button size="large" bgcolor="#1E90FF" color="#FFF" @click.native="registerSubmit">{{$t("message.confirmsubmit")}}</yd-button> <!-- 确认 -->
      </div>
    </div>
  </div>
</template>

<script>
import getAllProvince from '../../data/province' // 导入获取省份数据函数
export default {
  name: 'register',
  data () { // 数据
    return {
      whichPic: 0, // 哪一个图像
      whichStep: '1', // 步骤条到哪一步
      mailBox: '', // 邮箱
      yourName: '', // 姓名
      sex: '', // 性别
      company: '', // 所属公司
      department: '', // 所属部门
      cardNumber: '', // 身份证号
      phoneNumber: '', // 手机号码
      country: '',
      province: '', // 省
      city: '', // 市
      district: '', // 区
      deaddress: '', // 详细地址
      provinces: null // 所有省份数据
    }
  },
  methods: { // 方法
    selectPortrait () { // 选择了头像
      this.$dialog.confirm({ // 确认选择
        title: this.$t('message.titleportrait'),
        mes: this.$t('message.sureportrait'),
        opts: [ // 选项
          {
            txt: this.$t('message.cancel'),
            color: false
          },
          {
            txt: this.$t('message.sure'),
            color: true,
            callback: () => { // 确定回调函数
              this.whichStep = '2' // 步骤条到2
              let objectDisplay = document.getElementsByClassName('content_second')[0]
              let objectHide = document.getElementsByClassName('content_first')[0]
              objectHide.style.display = 'none' // 隐藏头像选择
              objectDisplay.style.display = 'inline' // 出现信息填写
            }
          }
        ]
      })
    },
    registerSubmit () { // 注册信息提交
      let badtip = ''
      if (!this.$refs.email.valid) {
        badtip += this.$t('message.email_error')
      }
      this.showTips(badtip, 'error')
      // this.showTips('提交成功', 'success')
      this.$router.push('/home') // 跳转到主页面
    },
    showTips (tip, type) { // 显示提示信息（tip为提示内容，type为success、error、或没有图标）
      this.$dialog.toast({ // 显示上传成功框（上传成功）
        mes: tip,
        timeout: 1000,
        icon: type
      })
    }
  },
  mounted () { // 渲染完成后
    this.provinces = getAllProvince(this) // 获取所有省份数据
  }
}
</script>

<style scoped>
label{
  position: absolute;
  font-size: 0.3rem; /*字体大小*/
  width: 100%; /*宽度*/
  text-align: center; /*居中*/
  top: 0.2rem; /*与顶部距离*/
}
img{ /*头像*/
  position: absolute; /*相对父组件*/
  left: 50%; /*与下面的平移结合，使图片居中*/
  transform:translate(-100px); /*图片宽度高度均为200px*/
  -webkit-transform: translateX(-100px); /*兼容Safari*/
  top: 0.8rem; /*与顶部距离*/
}
.content_second{ /*资料填写*/
  position: absolute;
  top: 2.5rem; /*与顶部距离*/
  width: 93%; /*宽度*/
  display: none; /*是否显示*/
}
.select{ /*选择框*/
  color: black; /*字体颜色*/
  margin-left: 0.3rem; /*左外边距*/
}
</style>
