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
              <yd-input slot="right" v-model="username"></yd-input>
            </yd-cell-item>
            <yd-cell-item>
              <yd-icon name="shield-outline" slot="icon"></yd-icon>
              <span slot="left" class="input">{{$t("message.password")}}:</span>
              <yd-input slot="right" type="password" v-model="password"></yd-input>
            </yd-cell-item>
          </yd-cell-group>
          <yd-button size="large" bgcolor="#1E90FF" color="#FFF" @click.native="toLogin" class="button">{{$t("message.signin")}}</yd-button> <!-- 登录按钮 -->
          <yd-button size="large" bgcolor="#1E90FF" color="#FFF" @click.native="toNoLogin" class="button">{{$t("message.loginwithoutuser")}}</yd-button> <!-- 无状态登录按钮 -->
        </yd-tab-panel>
        <yd-tab-panel :label="$t('message.registermodule')"> <!-- 注册模块Register Module -->
          <yd-cell-group>
            <yd-cell-item>
              <yd-icon name="ucenter-outline" slot="icon"></yd-icon>
              <yd-input slot="right" v-model="usernamex" :placeholder="$t('message.pleaseinputuser')"></yd-input>
            </yd-cell-item>
            <yd-cell-item>
              <yd-icon name="shield-outline" slot="icon"></yd-icon>
              <yd-input slot="right" type="password" v-model="passwordx" :placeholder="$t('message.pleaseinputpass')"></yd-input>
            </yd-cell-item>
            <yd-cell-item>
              <yd-icon name="shield" slot="icon"></yd-icon>
              <yd-input slot="right" type="password" v-model="passwordConfirm" :placeholder="$t('message.pleaseconformpass')"></yd-input>
            </yd-cell-item>
          </yd-cell-group>
          <yd-button size="large" bgcolor="#1E90FF" color="#FFF"  @click.native="toRegister" class="button">{{$t("message.register")}}</yd-button> <!-- 注册按钮 -->
        </yd-tab-panel>
      </yd-tab>
    </div>
  </div>
</template>

<script>
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
      sessionStorage.setItem('login', 'y')
      this.$router.push('/home')
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
          this.toLogin()
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
      this.$router.push('/register')
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
