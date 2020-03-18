<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="商品id" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="商品id"></el-input>
    </el-form-item>
    <el-form-item label="1收藏2取消收藏" prop="state">
      <el-input v-model="dataForm.state" placeholder="1收藏2取消收藏"></el-input>
    </el-form-item>
    <el-form-item label="收藏时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="收藏时间"></el-input>
    </el-form-item>
    <el-form-item label="取消收藏时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="取消收藏时间"></el-input>
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
          userId: '',
          productId: '',
          state: '',
          startTime: '',
          endTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          productId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '1收藏2取消收藏不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '收藏时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '取消收藏时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kywuserproduct/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.kYwUserProduct.userId
                this.dataForm.productId = data.kYwUserProduct.productId
                this.dataForm.state = data.kYwUserProduct.state
                this.dataForm.startTime = data.kYwUserProduct.startTime
                this.dataForm.endTime = data.kYwUserProduct.endTime
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
              url: this.$http.adornUrl(`/generator/kywuserproduct/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'productId': this.dataForm.productId,
                'state': this.dataForm.state,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime
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
