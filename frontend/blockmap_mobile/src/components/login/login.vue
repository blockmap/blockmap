<template>
  <div id="login"> <!-- 登录页面 -->
    <div class="login_content"> <!-- 剩余的登录页面内容 -->
      <div class="logo">
        <label>blockMap</label>
      </div>
      <yd-tab v-model="whichTab" color="#000"> <!-- 选项卡 -->
        <yd-tab-panel :label="$t('message.loginmodule')"> <!-- 登录模块Login Module -->
          <yd-cell-group> <!-- 用户名密码框 -->
            <yd-cell-item>
              <yd-icon name="ucenter-outline" slot="icon"></yd-icon>
              <span slot="left" class="input">{{$t("message.username")}}:</span>
              <yd-input slot="right" v-model="username" required></yd-input>
            </yd-cell-item>
            <yd-cell-item>
              <yd-icon name="shield-outline" slot="icon"></yd-icon>
              <span slot="left" class="input">{{$t("message.password")}}:</span>
              <yd-input slot="right" type="password" v-model="password" required></yd-input>
            </yd-cell-item>
          </yd-cell-group>
          <yd-button size="large" bgcolor="#1E90FF" color="#FFF" @click.native="toLogin" class="button">{{$t("message.signin")}}</yd-button> <!-- 登录按钮 -->
          <yd-button size="large" bgcolor="#1E90FF" color="#FFF" @click.native="toNoLogin" class="button">{{$t("message.loginwithoutuser")}}</yd-button> <!-- 无状态登录按钮 -->
        </yd-tab-panel>
        <yd-tab-panel :label="$t('message.registermodule')"> <!-- 注册模块Register Module -->
          <yd-cell-group>
            <yd-cell-item>
              <yd-icon name="ucenter-outline" slot="icon"></yd-icon>
              <yd-input slot="right" v-model="usernamex" :placeholder="$t('message.pleaseinputuser')" required></yd-input>
            </yd-cell-item>
            <yd-cell-item>
              <yd-icon name="shield-outline" slot="icon"></yd-icon>
              <yd-input slot="right" type="password" v-model="passwordx" :placeholder="$t('message.pleaseinputpass')" required></yd-input>
            </yd-cell-item>
            <yd-cell-item>
              <yd-icon name="shield" slot="icon"></yd-icon>
              <yd-input slot="right" type="password" v-model="passwordConfirm" :placeholder="$t('message.pleaseconformpass')" required></yd-input>
            </yd-cell-item>
          </yd-cell-group>
          <yd-button size="large" bgcolor="#1E90FF" color="#FFF"  @click.native="toRegister" class="button">{{$t("message.register")}}</yd-button> <!-- 注册按钮 -->
        </yd-tab-panel>
      </yd-tab>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import Qs from 'qs'
export default {
  name: 'login',
  data () { // 数据
    return {
      username: '', // 用户名（登录）
      password: '', // 密码（登录）
      usernamex: '', // 用户名（注册）
      passwordx: '', // 密码（注册）
      passwordConfirm: '', // 密码确认
      whichTab: 0 // 默认选项卡
    }
  },
  methods: { // 方法
    toLogin () { // 登录函数
      if (this.username === '' || this.password === '') { // 检查是否输入
        this.showTips(this.$t('message.loginnull'), 'error') // 显示登录失败框
      } else {
        let param = {
          username: this.username,
          password: this.password
        }
        axios.post('api/blockMap/login', Qs.stringify(param)).then(
          response => {
            // 是否登录成功
            if (response.data.Type === 1) { // 是普通用户
              if (response.data.status === 'success') {
                sessionStorage.setItem('login', 'y') // 已登陆状态
                sessionStorage.setItem('username', response.data.username) // 保存用户名
                sessionStorage.setItem('portrait', response.data.Imageurl) // 保存头像
                sessionStorage.setItem('id', response.data.id) // 保存用户id（自动变为string）
                this.$router.push('/home') // 跳转到主页面
              } else {
                this.showTips(this.$t('message.loginfail'), 'error') // 显示登录失败框
              }
            } else {
              this.showTips(this.$t('message.loginfail'), 'error') // 显示登录失败框
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
    toNoLogin () { // 无状态登录函数
      sessionStorage.setItem('login', 'n')
      this.$router.push('/home')
    },
    enterKey (event) { // 监听enter键
      const componentName = this.$options.name
      if (componentName === 'login') {
        const code = event.keyCode
        if (code === 13) {
          if (this.whichTab === 0) {
            this.toLogin()
          } else {
            this.toRegister()
          }
        }
      }
    },
    enterKeyupDestroyed () { // 销毁监听器
      document.removeEventListener('keyup', this.enterKey)
    },
    enterKeyup () { // 安装监听器
      document.addEventListener('keyup', this.enterKey)
    },
    toRegister () { // 填写注册信息函数
      if (this.usernamex === '' || this.passwordx === '' || this.passwordConfirm === '') {
        this.showTips(this.$t('message.registernull'), 'error') // 显示失败框
      } else {
        if (this.passwordx !== this.passwordConfirm) { // 两次密码不一致
          this.showTips(this.$t('message.passwordnotequal'), 'error') // 显示失败框
        } else { // 成功
          sessionStorage.setItem('usernamer', this.usernamex)
          sessionStorage.setItem('passwordr', this.passwordx)
          this.$router.push('/register')
        }
      }
    },
    showTips (tip, type) { // 显示提示信息（tip为提示内容，type为success、error、或没有图标）
      this.$dialog.toast({
        mes: tip,
        timeout: 1000,
        icon: type
      })
    }
  },
  mounted () {
    this.enterKeyup() // 安装监听器
  },
  destroyed () { // 窗口销毁时
    this.enterKeyupDestroyed() // 销毁监听器
  }
}
</script>

<style scoped>
#login{ /*全局*/
  width: 100%; /*占满*/
  height: 100%;
  background: url("../../assets/register_otherx.png") no-repeat center; /*设置背景图片*/
  background-size: cover;
}
.login_content{ /*登陆页除导航栏外内容*/
  padding-left: 0.4rem; /*左内边距*/
  padding-right: 0.4rem; /*右内边距*/
  padding-top: 30vh;/*4rem;上内边距*/
  z-index: 10;
}
.input{ /*密码和用户框前提示*/
  text-align: center; /*居中*/
  width: 1.8rem; /*宽度*/
}
label{ /*logo*/
  color: white; /*字体颜色*/
  font-size: 0.7rem; /*字体大小*/
  position: fixed; /*相对父组件位置*/
  top: 20vh; /*上边距离*/
  width: 90%; /*宽度为整屏90%*/
  text-align: center; /*文字居中*/
  text-shadow: 0.1rem 0.1rem 0.1rem #FFF; /*文字效果*/
}
.button:active{ /*按钮点击效果*/
  opacity: 0.5; /*透明度*/
}
</style>
