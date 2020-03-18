<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="商品id" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="商品id"></el-input>
    </el-form-item>
    <el-form-item label="类型1评论2反馈" prop="type">
      <el-input v-model="dataForm.type" placeholder="类型1评论2反馈"></el-input>
    </el-form-item>
    <el-form-item label="评论人" prop="commentUserId">
      <el-input v-model="dataForm.commentUserId" placeholder="评论人"></el-input>
    </el-form-item>
    <el-form-item label="内容" prop="commentContent">
      <el-input v-model="dataForm.commentContent" placeholder="内容"></el-input>
    </el-form-item>
    <el-form-item label="时间" prop="commentTime">
      <el-input v-model="dataForm.commentTime" placeholder="时间"></el-input>
    </el-form-item>
    <el-form-item label="回复人" prop="replyUserId">
      <el-input v-model="dataForm.replyUserId" placeholder="回复人"></el-input>
    </el-form-item>
    <el-form-item label="回复内容" prop="replyContent">
      <el-input v-model="dataForm.replyContent" placeholder="回复内容"></el-input>
    </el-form-item>
    <el-form-item label="回复时间" prop="replyTime">
      <el-input v-model="dataForm.replyTime" placeholder="回复时间"></el-input>
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
          productId: '',
          type: '',
          commentUserId: '',
          commentContent: '',
          commentTime: '',
          replyUserId: '',
          replyContent: '',
          replyTime: ''
        },
        dataRule: {
          productId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类型1评论2反馈不能为空', trigger: 'blur' }
          ],
          commentUserId: [
            { required: true, message: '评论人不能为空', trigger: 'blur' }
          ],
          commentContent: [
            { required: true, message: '内容不能为空', trigger: 'blur' }
          ],
          commentTime: [
            { required: true, message: '时间不能为空', trigger: 'blur' }
          ],
          replyUserId: [
            { required: true, message: '回复人不能为空', trigger: 'blur' }
          ],
          replyContent: [
            { required: true, message: '回复内容不能为空', trigger: 'blur' }
          ],
          replyTime: [
            { required: true, message: '回复时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kywcomment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productId = data.kYwComment.productId
                this.dataForm.type = data.kYwComment.type
                this.dataForm.commentUserId = data.kYwComment.commentUserId
                this.dataForm.commentContent = data.kYwComment.commentContent
                this.dataForm.commentTime = data.kYwComment.commentTime
                this.dataForm.replyUserId = data.kYwComment.replyUserId
                this.dataForm.replyContent = data.kYwComment.replyContent
                this.dataForm.replyTime = data.kYwComment.replyTime
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
              url: this.$http.adornUrl(`/generator/kywcomment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productId': this.dataForm.productId,
                'type': this.dataForm.type,
                'commentUserId': this.dataForm.commentUserId,
                'commentContent': this.dataForm.commentContent,
                'commentTime': this.dataForm.commentTime,
                'replyUserId': this.dataForm.replyUserId,
                'replyContent': this.dataForm.replyContent,
                'replyTime': this.dataForm.replyTime
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
