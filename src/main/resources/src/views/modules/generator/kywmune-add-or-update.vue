<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="父级id，顶级用0" prop="pid">
      <el-input v-model="dataForm.pid" placeholder="父级id，顶级用0"></el-input>
    </el-form-item>
    <el-form-item label="标题" prop="name">
      <el-input v-model="dataForm.name" placeholder="标题"></el-input>
    </el-form-item>
    <el-form-item label="logo路径" prop="logoUrl">
      <el-input v-model="dataForm.logoUrl" placeholder="logo路径"></el-input>
    </el-form-item>
    <el-form-item label="标题说明" prop="titleContent">
      <el-input v-model="dataForm.titleContent" placeholder="标题说明"></el-input>
    </el-form-item>
    <el-form-item label="请求路径" prop="requestPath">
      <el-input v-model="dataForm.requestPath" placeholder="请求路径"></el-input>
    </el-form-item>
    <el-form-item label="类型 1首页顶部导航栏  2首页底部导航栏" prop="type">
      <el-input v-model="dataForm.type" placeholder="类型 1首页顶部导航栏  2首页底部导航栏"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          pid: '',
          name: '',
          logoUrl: '',
          titleContent: '',
          requestPath: '',
          type: '',
          sort: ''
        },
        dataRule: {
          pid: [
            { required: true, message: '父级id，顶级用0不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '标题不能为空', trigger: 'blur' }
          ],
          logoUrl: [
            { required: true, message: 'logo路径不能为空', trigger: 'blur' }
          ],
          titleContent: [
            { required: true, message: '标题说明不能为空', trigger: 'blur' }
          ],
          requestPath: [
            { required: true, message: '请求路径不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类型 1首页顶部导航栏  2首页底部导航栏不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/kywmune/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.pid = data.kYwMune.pid
                this.dataForm.name = data.kYwMune.name
                this.dataForm.logoUrl = data.kYwMune.logoUrl
                this.dataForm.titleContent = data.kYwMune.titleContent
                this.dataForm.requestPath = data.kYwMune.requestPath
                this.dataForm.type = data.kYwMune.type
                this.dataForm.sort = data.kYwMune.sort
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/kywmune/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'pid': this.dataForm.pid,
                'name': this.dataForm.name,
                'logoUrl': this.dataForm.logoUrl,
                'titleContent': this.dataForm.titleContent,
                'requestPath': this.dataForm.requestPath,
                'type': this.dataForm.type,
                'sort': this.dataForm.sort
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
