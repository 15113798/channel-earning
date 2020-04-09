<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="userId">
      <el-input v-model="dataForm.userId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="发送电话号码" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="发送电话号码"></el-input>
    </el-form-item>
    <el-form-item label="发送类型" prop="sendType">
      <el-input v-model="dataForm.sendType" placeholder="发送类型"></el-input>
    </el-form-item>
    <el-form-item label="发送时间" prop="sendTime">
      <el-input v-model="dataForm.sendTime" placeholder="发送时间"></el-input>
    </el-form-item>
    <el-form-item label="验证码" prop="verCode">
      <el-input v-model="dataForm.verCode" placeholder="验证码"></el-input>
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
          phone: '',
          sendType: '',
          sendTime: '',
          verCode: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '发送电话号码不能为空', trigger: 'blur' }
          ],
          sendType: [
            { required: true, message: '发送类型不能为空', trigger: 'blur' }
          ],
          sendTime: [
            { required: true, message: '发送时间不能为空', trigger: 'blur' }
          ],
          verCode: [
            { required: true, message: '验证码不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kywsendsmshistory/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.kYwSendSmsHistory.userId
                this.dataForm.phone = data.kYwSendSmsHistory.phone
                this.dataForm.sendType = data.kYwSendSmsHistory.sendType
                this.dataForm.sendTime = data.kYwSendSmsHistory.sendTime
                this.dataForm.verCode = data.kYwSendSmsHistory.verCode
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
              url: this.$http.adornUrl(`/generator/kywsendsmshistory/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'phone': this.dataForm.phone,
                'sendType': this.dataForm.sendType,
                'sendTime': this.dataForm.sendTime,
                'verCode': this.dataForm.verCode
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
