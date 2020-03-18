<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="商品id" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="商品id"></el-input>
    </el-form-item>
    <el-form-item label="推广类型id" prop="tgTypeId">
      <el-input v-model="dataForm.tgTypeId" placeholder="推广类型id"></el-input>
    </el-form-item>
    <el-form-item label="图片路径,多图的话用逗号分隔" prop="imgUrl">
      <el-input v-model="dataForm.imgUrl" placeholder="图片路径,多图的话用逗号分隔"></el-input>
    </el-form-item>
    <el-form-item label="文案内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="文案内容"></el-input>
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
          tgTypeId: '',
          imgUrl: '',
          content: ''
        },
        dataRule: {
          productId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          tgTypeId: [
            { required: true, message: '推广类型id不能为空', trigger: 'blur' }
          ],
          imgUrl: [
            { required: true, message: '图片路径,多图的话用逗号分隔不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '文案内容不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kywproducttgcontent/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productId = data.kYwProductTgContent.productId
                this.dataForm.tgTypeId = data.kYwProductTgContent.tgTypeId
                this.dataForm.imgUrl = data.kYwProductTgContent.imgUrl
                this.dataForm.content = data.kYwProductTgContent.content
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
              url: this.$http.adornUrl(`/generator/kywproducttgcontent/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productId': this.dataForm.productId,
                'tgTypeId': this.dataForm.tgTypeId,
                'imgUrl': this.dataForm.imgUrl,
                'content': this.dataForm.content
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
