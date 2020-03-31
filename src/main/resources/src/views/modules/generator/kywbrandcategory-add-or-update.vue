<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="品牌团id" prop="brandId">
      <el-input v-model="dataForm.brandId" placeholder="品牌团id"></el-input>
    </el-form-item>
    <el-form-item label="商品分类id" prop="productTypeId">
      <el-input v-model="dataForm.productTypeId" placeholder="商品分类id"></el-input>
    </el-form-item>
    <el-form-item label="是否主营 0是1否" prop="isMain">
      <el-input v-model="dataForm.isMain" placeholder="是否主营 0是1否"></el-input>
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
          brandId: '',
          productTypeId: '',
          isMain: ''
        },
        dataRule: {
          brandId: [
            { required: true, message: '品牌团id不能为空', trigger: 'blur' }
          ],
          productTypeId: [
            { required: true, message: '商品分类id不能为空', trigger: 'blur' }
          ],
          isMain: [
            { required: true, message: '是否主营 0是1否不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kywbrandcategory/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.brandId = data.kYwBrandCategory.brandId
                this.dataForm.productTypeId = data.kYwBrandCategory.productTypeId
                this.dataForm.isMain = data.kYwBrandCategory.isMain
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
              url: this.$http.adornUrl(`/generator/kywbrandcategory/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'brandId': this.dataForm.brandId,
                'productTypeId': this.dataForm.productTypeId,
                'isMain': this.dataForm.isMain
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
