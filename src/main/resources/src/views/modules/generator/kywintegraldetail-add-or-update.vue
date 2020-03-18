<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="userId">
      <el-input v-model="dataForm.userId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="得分类型" prop="pointTypeId">
      <el-input v-model="dataForm.pointTypeId" placeholder="得分类型"></el-input>
    </el-form-item>
    <el-form-item label="得分" prop="point">
      <el-input v-model="dataForm.point" placeholder="得分"></el-input>
    </el-form-item>
    <el-form-item label="" prop="productId">
      <el-input v-model="dataForm.productId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="descContent">
      <el-input v-model="dataForm.descContent" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
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
          pointTypeId: '',
          point: '',
          productId: '',
          descContent: '',
          updateTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pointTypeId: [
            { required: true, message: '得分类型不能为空', trigger: 'blur' }
          ],
          point: [
            { required: true, message: '得分不能为空', trigger: 'blur' }
          ],
          productId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          descContent: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kywintegraldetail/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.kYwIntegralDetail.userId
                this.dataForm.pointTypeId = data.kYwIntegralDetail.pointTypeId
                this.dataForm.point = data.kYwIntegralDetail.point
                this.dataForm.productId = data.kYwIntegralDetail.productId
                this.dataForm.descContent = data.kYwIntegralDetail.descContent
                this.dataForm.updateTime = data.kYwIntegralDetail.updateTime
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
              url: this.$http.adornUrl(`/generator/kywintegraldetail/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'pointTypeId': this.dataForm.pointTypeId,
                'point': this.dataForm.point,
                'productId': this.dataForm.productId,
                'descContent': this.dataForm.descContent,
                'updateTime': this.dataForm.updateTime
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
