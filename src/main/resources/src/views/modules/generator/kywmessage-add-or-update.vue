<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="发送人" prop="sendUserId">
      <el-input v-model="dataForm.sendUserId" placeholder="发送人"></el-input>
    </el-form-item>
    <el-form-item label="发送内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="发送内容"></el-input>
    </el-form-item>
    <el-form-item label="发送时间" prop="sendTime">
      <el-input v-model="dataForm.sendTime" placeholder="发送时间"></el-input>
    </el-form-item>
    <el-form-item label="发送类型" prop="typeId">
      <el-input v-model="dataForm.typeId" placeholder="发送类型"></el-input>
    </el-form-item>
    <el-form-item label="接收人" prop="arriverUserId">
      <el-input v-model="dataForm.arriverUserId" placeholder="接收人"></el-input>
    </el-form-item>
    <el-form-item label="发送状态1已发送2已读" prop="state">
      <el-input v-model="dataForm.state" placeholder="发送状态1已发送2已读"></el-input>
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
          sendUserId: '',
          content: '',
          sendTime: '',
          typeId: '',
          arriverUserId: '',
          state: ''
        },
        dataRule: {
          sendUserId: [
            { required: true, message: '发送人不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '发送内容不能为空', trigger: 'blur' }
          ],
          sendTime: [
            { required: true, message: '发送时间不能为空', trigger: 'blur' }
          ],
          typeId: [
            { required: true, message: '发送类型不能为空', trigger: 'blur' }
          ],
          arriverUserId: [
            { required: true, message: '接收人不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '发送状态1已发送2已读不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kywmessage/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.sendUserId = data.kYwMessage.sendUserId
                this.dataForm.content = data.kYwMessage.content
                this.dataForm.sendTime = data.kYwMessage.sendTime
                this.dataForm.typeId = data.kYwMessage.typeId
                this.dataForm.arriverUserId = data.kYwMessage.arriverUserId
                this.dataForm.state = data.kYwMessage.state
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
              url: this.$http.adornUrl(`/generator/kywmessage/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'sendUserId': this.dataForm.sendUserId,
                'content': this.dataForm.content,
                'sendTime': this.dataForm.sendTime,
                'typeId': this.dataForm.typeId,
                'arriverUserId': this.dataForm.arriverUserId,
                'state': this.dataForm.state
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
