<template>
	<section>
		<!--工具条-->
		<el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
			<el-form :inline="true" >
				<el-form-item>
					<el-button type="primary" @click="handleAdd">新增</el-button>
				</el-form-item>
			</el-form>
		</el-col>

		<!--列表-->
		<el-table :data="articleList" highlight-current-row v-loading="listLoading" @selection-change="selsChange" style="width: 100%;">
			<el-table-column type="selection" width="55">
			</el-table-column>
			<el-table-column type="index" label="编号" width="120">
			</el-table-column>
			<el-table-column prop="title" label="标题" width="250" >
			</el-table-column>
			<el-table-column prop="tags" label="标签" width="150"  >
			</el-table-column>
			<el-table-column prop="visitCount" label="阅读量" width="100" >
			</el-table-column>
			<el-table-column prop="createTime" label="创建时间" width="180" >
			</el-table-column>
			<el-table-column prop="updateTime" label="更新时间" min-width="180">
			</el-table-column>
			<el-table-column label="操作" width="120">
				<template scope="scope">
					<el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
					<el-button type="danger" size="small" @click="handleDel(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>

		<!--编辑界面-->
		<el-dialog title="新增/编辑" v-model="editFormVisible" :close-on-click-modal="false" >
			<el-form :model="editForm" label-width="80px" ref="editForm">

				<el-form-item label="标题" prop="title">
					<el-input v-model="editForm.title" auto-complete="off"></el-input>
				</el-form-item>

				<el-form-item label="标签">

					<el-select v-model="editForm.tags" multiple placeholder="请选择">
						<el-option
								v-for="item in tagsList"
								:key="item.value"
								:label="item.label"
								:value="item.value">
						</el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="介绍">
					<el-input v-model="editForm.introduce" ></el-input>
				</el-form-item>


				<el-form-item label="内容">
					<el-input v-model="editForm.content" ></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click.native="editFormVisible = false">取消</el-button>
				<el-button type="primary" @click.native="editSubmit" :loading="editLoading">提交</el-button>
			</div>
		</el-dialog>
	</section>
</template>

<script>
    import Vue from 'vue';
    import axios from 'axios';
    import { getUserListPage, removeUser, batchRemoveUser, editUser, addUser } from '../../api/api';
    Vue.prototype.$axios = axios;

    export default {
        data() {
            return {

                tagsList:[
					{value:'java', label:'java'},
					{value:'分布式',label:'分布式'}
				],
                articleList: [],
                total: 0,
                page: 1,
                listLoading: false,
                sels: [],//列表选中列

                editFormVisible: false,//编辑界面是否显示
                editLoading: false,

                //编辑界面数据
                editForm: {
                    articleId:'',
                    title: '',
                    tags: [],
                    introduce:'',
                    content: '',
                    author:'',
                    createTime:'',
                    updateTime:'',
                    visitCount:''
                }
            }
        },
        methods: {


			getAllArticleList(){
                this.$axios.get("/blog/index/getAllArticleList").then(res => {
                    alert(res);
                    this.articleList = res.data.data;
                });
			},
            //删除
            handleDel: function (index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    this.listLoading = true;
                    //NProgress.start();
                    let para = { id: row.id };
                    removeUser(para).then((res) => {
                        this.listLoading = false;
                        //NProgress.done();
                        this.$message({
                            message: '删除成功',
                            type: 'success'
                        });
                        this.getUsers();
                    });
                }).catch(() => {

                });
            },
            //显示编辑界面
            handleEdit: function (index, row) {
                this.editFormVisible = true;
                this.editForm = Object.assign({}, row);
            },
            //显示新增界面
            handleAdd: function () {
                this.editFormVisible = true;
            },
            //编辑
            editSubmit: function () {
                this.$refs.editForm.validate((valid) => {
                    if (valid) {
                        this.$confirm('确认提交吗？', '提示', {}).then(() => {
                            this.editLoading = true;
                            //NProgress.start();
                            let para = Object.assign({}, this.editForm);

                        });
                    }
                });
            },
            selsChange: function (sels) {
                this.sels = sels;
            },
        },
        mounted: function () {
            this.$nextTick(function () {
                this.getAllArticleList();
            })

        }
    }

</script>

<style scoped>

</style>