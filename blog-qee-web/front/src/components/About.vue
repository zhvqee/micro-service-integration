<template>
  <div class="main">
    <div class="headtop"></div>
    <div class="contenttop">

      <div class="jztop"></div>
      <div class="container">

        {{msg}}
        <!-- container代码 结束 -->
      </div>
      <div class="jzend"></div>
      <footer>
        <div class="footer">
          <div class="f_l">
            <p>All Rights Reserved 版权所有：<a href="http://blog.leeqee.xyz">个人博客</a></p>
          </div>
          <div class="f_r textr">
            <p></p>
          </div>
        </div>
      </footer>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'about',
    data () {
      return {
        msg: '11111！',
      }
    }
  }
</script>
