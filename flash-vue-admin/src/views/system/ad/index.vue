<template>
  <div class="app-container">
    <div class="block">
      <el-row  :gutter="20">
        <el-col :span="6">
          <el-input v-model="listQuery.name" placeholder="请输入字典名称"></el-input>
        </el-col>
        <el-col :span="6">
          <el-button type="success" icon="el-icon-search" @click.native="search">{{ $t('button.search') }}</el-button>
          <el-button type="primary" icon="el-icon-refresh" @click.native="reset">{{ $t('button.reset') }}</el-button>
        </el-col>
      </el-row>
      <br>
      <el-row>
        <el-col :span="24">
          <el-button type="success" icon="el-icon-plus" @click.native="add">{{ $t('button.add') }}</el-button>
          <el-button type="primary" icon="el-icon-edit" @click.native="edit">{{ $t('button.edit') }}</el-button>
          <el-button type="danger" icon="el-icon-delete" @click.native="remove">{{ $t('button.delete') }}</el-button>
        </el-col>
      </el-row>
    </div>


    <el-table :data="list" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row
    @current-change="handleCurrentChange">
      <el-table-column label="ID">
        <template slot-scope="scope">
          {{scope.row.id}}
        </template>
      </el-table-column>
      <el-table-column label="广告名称">
        <template slot-scope="scope">
          {{scope.row.adName}}
        </template>
      </el-table-column>
      <el-table-column label="关联用户">
        <template slot-scope="scope">
          {{scope.row.userName}}
        </template>
      </el-table-column>
      <el-table-column label="开始时间">
        <template slot-scope="scope">
          {{scope.row.beginTime}}
        </template>
      </el-table-column>
      <el-table-column label="结束时间">
        <template slot-scope="scope">
          {{scope.row.endTime}}
        </template>
      </el-table-column>
    </el-table>


    <el-dialog
      :title="formTitle"
      :visible.sync="formVisible"
      width="60%">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-form-item label="广告名称" prop="name">
          <el-input v-model="form.adName"  minlength=1></el-input>
        </el-form-item>

        <el-form-item label="关联用户" >
          <!-- 添加filterable可以实现搜索功能 -->
          <el-select v-model="form.userName" filterable size="small" style="width: 100%;" placeholder="请选择">
            <el-option
                v-for="(item, i) in userInfoData"
                :key="i"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      
        <el-form-item label="广告投放时间">
          <el-date-picker type="date" placeholder="选择日期" v-model="form.beginTime" style="width: 100;">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="投放结束时间">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.endTime" style="width: 100%;">
            </el-date-picker>
        </el-form-item>
        <el-form-item
          v-for="(rec, index) in form.details"
          :label="'字典' + (index+1)"
          :key="rec.key"
          :prop="'details.' + index + '.value'"
          :rules="{
            required: true, message: '不能为空', trigger: 'blur'
          }"
        >
          <el-col :span="10">
          <el-input v-model="rec.key" placeholder="值"></el-input>
          </el-col>
          <el-col class="line" :span="1">&nbsp; </el-col>
          <el-col :span="10">
          <el-input v-model="rec.value" placeholder="名称"></el-input>
          </el-col>
          <el-col :span="3">&nbsp;
          <el-button @click.prevent="removeDetail(rec)" type="danger" icon="el-icon-delete" >{{ $t('button.delete')
            }}</el-button>
          </el-col>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="save">{{ $t('button.submit') }}</el-button>
          <el-button @click="addDetail">新增字典</el-button>
          <el-button @click.native="formVisible = false">{{ $t('button.cancel') }}</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script src="./ad.js"></script>
<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/common.scss";
</style>
