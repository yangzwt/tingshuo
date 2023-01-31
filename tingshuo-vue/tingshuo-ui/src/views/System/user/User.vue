<template>
  <div id="app">
    <h1>用户基本信息展示</h1>
    <!-- 查询条件 -->
    <el-form :inline="true" :model="queryList" ref="queryList" label-width="68px" class="demo-form-inline">
      <el-form-item label="用户名称">
        <el-input v-model="queryList.userName" placeholder="用户名称" 
              size="small"
              style="width: 240px"
              @keyup.enter.native="getUserList"></el-input>
      </el-form-item>
      <el-form-item label="手机号码">
        <el-input v-model="queryList.phonenumber" placeholder="手机号码" 
              size="small"
              style="width: 240px"></el-input>
      </el-form-item>
      <el-form-item label="用户状态">
        <el-input v-model="queryList.status" placeholder="用户状态" 
              size="small"
              style="width: 240px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="getUserList">查询</el-button>
      </el-form-item>
    </el-form>
    <!-- 页面列表部分 -->
    <el-table :data="UserList" style="width: 100%" stripe="true">
      <el-table-column type="selection" width="50" align="center" />
      <el-table-column
        label="用户编号"
        align="center"
        key="userId"
        prop="userId"
        v-if="columns[0].visible"
        width="180"
      >
      </el-table-column>
      <el-table-column
        label="用户名称"
        align="center"
        key="userName"
        prop="userName"
        v-if="columns[1].visible"
        :show-overflow-tooltip="true"
      >
      </el-table-column>
      <el-table-column
        label="用户昵称"
        align="center"
        key="nickName"
        prop="nickName"
        v-if="columns[2].visible"
        :show-overflow-tooltip="true"
      >
      </el-table-column>
      <el-table-column
        label="手机号码"
        align="center"
        key="phonenumber"
        prop="phonenumber"
        v-if="columns[3].visible"
        :show-overflow-tooltip="true"
      >
      </el-table-column>
      <el-table-column
        label="状态"
        align="center"
        key="status"
        prop="status"
        v-if="columns[4].visible"
        :show-overflow-tooltip="true"
      >
      </el-table-column>
      <el-table-column
        label="创建时间"
        align="center"
        key="createTime"
        prop="createTime"
        v-if="columns[5].visible"
        :show-overflow-tooltip="true"
      >
      </el-table-column>
    </el-table>
    <div class="block">
      <!-- <span class="demonstration">分页功能实现</span> -->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[20, 30, 40, 50]"
        :page-size="20"
        layout="->,total, sizes, prev, pager, next, jumper"
        :total="this.total"
      >
      </el-pagination>
    </div>
  </div>
</template>
<script>
export default {
  name: "User",
  data() {
    return {
      //用户列表
      UserList: null,
      // 列信息
      columns: [
        { key: 0, label: `用户编号`, visible: true },
        { key: 1, label: `用户名称`, visible: true },
        { key: 2, label: `用户昵称`, visible: true },
        { key: 3, label: `手机号码`, visible: true },
        { key: 4, label: `状态`, visible: true },
        { key: 5, label: `创建时间`, visible: true },
      ],
      //总页数
      total: 0,
      currentPage: 0,
      queryList: {
        userName: "",
        phonenumber: "",
        status: ""
      }
    };
  },
  created() {
    this.getUserList();
  },
  methods: {
    getUserList() {
      this.$http({
        method: "post",
        url: "/user/list?pageNum=1&pageSize=10",
        data: this.queryList
      }).then((res) => {
        this.UserList = res.data.content;
        this.total = res.data.totalSize;
      });
    },
    handleSizeChange(val) {
      //console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      //console.log(`当前页: ${val}`);
    },
  },
  mounted() {
    //this.getUserList();
  },
};
</script>
<style scoped>
.block{
  margin-top: 20px;
}
</style>