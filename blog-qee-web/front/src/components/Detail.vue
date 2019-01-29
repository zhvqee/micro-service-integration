<template>
  <div class="main">
    <div class="headtop"></div>
    <div class="contenttop">
      <div class="logo f_l">向前冲！！！</div>
      <div class="blank"></div>

      <nav>
        <div class="navigation">
          <ul class="menu">

            <div v-for="item in theme.topSubjectCatalogueList">
              <router-link :to="{path:item.link}">
                <li><a>{{item.name}}</a></li>
              </router-link>
            </div>
          </ul>
        </div>
      </nav>

    </div>

    <div class="jztop"></div>
    <div class="container">
      <div class="con_content">
        <div class="about_box">
          <h2 class="nh1"><span>您现在的位置是：<a href="/" target="_blank">网站首页</a>>><a href="#"
                                                                                 target="_blank">{{article.title}}</a></span>
          </h2>
          <div class="f_box">
            <p class="a_title">{{article.title}}</p>
            <p class="p_title"></p>
            <p class="box_p">
              <span>发布时间：{{getTimeByStamp(article.updateTime)}}</span><span>作者：{{article.author}}</span><span>标签：{{article.tagsStr}}</span><span>点击：{{article.visitCount}}</span>
            </p>
          </div>
          <ul class="about_content">
            <p v-html="article.content"></p>
          </ul>
        </div>

      </div>


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
</template>

<script>

  import Vue from 'vue';
  import axios from 'axios';
  Vue.prototype.$axios = axios;

  export default {
    // name: 'main',
    created(){
      this.getArticleDetail();
      this.getThemeInfo();


    },
    methods: {
      getArticleDetail(){
        this.$axios.post("/blog/index/getArticleDetail", {
          articleId: this.$route.query.articleId
        }).then(res => {
          this.article = res.data.data;
        });
      },
      getThemeInfo(){
        this.$axios.post("/blog/index/getThemeInfo",).then(res => {
          this.theme = res.data.data;
        });
      },
      getTimeByStamp (timeStamp) {
        const timeFilter = (date, split) => {
          return (date < 10) ? '0' + date + split : date + split
        }
        const date = new Date(timeStamp)
        const Y = date.getFullYear() + '-'
        const M = timeFilter(date.getMonth() + 1, '-')
        const D = timeFilter(date.getDate(), ' ')
        const h = timeFilter(date.getHours(), ':')
        const m = timeFilter(date.getMinutes(), ':')
        const s = timeFilter(date.getSeconds(), '')
        return [Y, M, D, h, m, s].join('')
      }
    },
    data () {
      return {

        theme: {
          topSubjectCatalogueList: [{
            name: '',
            link: '',
          }],
          rightSubjectCatalogueList: [{
            name: '',
            link: '',
          }],
        },

        article: {
          articleId: '',
          url: '',
          title: '',
          content: '',
          createTime: '',
          updateTime: '',
          author: '',
          tags: [],
          visitCount: 0,

        },
      }
    }
  }
</script>
