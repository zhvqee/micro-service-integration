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

      <div class="bloglist f_l">
        <div v-for="item in articles ">
          <h3>{{item.title}}</h3>
          <figure><img v-if="item.images!='' && item.images!=null" src="item.images">
          </figure>
          <ul>
            <p> {{item.content}}</p>

            <router-link :to="{path: 'detail', query: {articleId: item.articleId }}">
              <a class="readmore">阅读全文&gt;&gt;</a>
            </router-link>

          </ul>
          <p class="dateview">
            <span>{{item.createTime}}</span>
            <span>作者：{{item.author}}</span>
            <span>阅读量：{{item.visitCount}}</span>
            <span>标签：<a href="" v-for="tag in item.tags">[{{tag}}]</a></span>
          </p>
        </div>


      </div>

      <div class="r_box f_r">

        <div v-for="item in theme.rightSubjectCatalogueList">
          <h3 class="tit">{{item.name}}</h3>
          <div :class="item.style">
            <ul>
              <li><a class="email" href="zhvqee@163.com" target="_blank">我的邮箱</a></li>
              <li><a class="qq" href="281961682" target="_blank">我的QQ</a></li>
            </ul>
          </div>
        </div>


        <div class="ad">
          <img src="../../static/images/erwm.jpg" height="200" width="250"/>
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
    mounted: function () {

      this.$nextTick(function () {
        this.getAllArticles();
        this.getThemeInfo();
      })

    },
    methods: {
      getAllArticles(){
        this.$axios.post("/blog/index/getAllArticles",).then(res => {
          this.articles = res.data.data;
        });
      },
      getThemeInfo(){
        this.$axios.post("/blog/index/getThemeInfo",).then(res => {
          this.theme = res.data.data;
        });
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

        articles: [{
          articleId: '',
          url: '',
          title: '',
          content: '',
          createTime: '',
          author: '',
          tags: [],
          visitCount: 0,

        }],
        // articles: []
      }
    }
  }
</script>
