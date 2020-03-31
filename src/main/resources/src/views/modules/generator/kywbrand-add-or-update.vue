<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="品牌名称" prop="brandName">
      <el-input v-model="dataForm.brandName" placeholder="品牌名称"></el-input>
    </el-form-item>
    <el-form-item label="品牌小标题" prop="brandTitle">
      <el-input v-model="dataForm.brandTitle" placeholder="品牌小标题"></el-input>
    </el-form-item>
    <el-form-item label="品牌历史" prop="brandHistory">
      <el-input v-model="dataForm.brandHistory" placeholder="品牌历史"></el-input>
    </el-form-item>
    <el-form-item label="品牌定位" prop="brandPosition">
      <el-input v-model="dataForm.brandPosition" placeholder="品牌定位"></el-input>
    </el-form-item>
    <el-form-item label="消费群体" prop="consumer">
      <el-input v-model="dataForm.consumer" placeholder="消费群体"></el-input>
    </el-form-item>
    <el-form-item label="品牌标签" prop="brandLabel">
      <el-input v-model="dataForm.brandLabel" placeholder="品牌标签"></el-input>
    </el-form-item>
    <el-form-item label="是否推荐" prop="isRecommend">
      <el-input v-model="dataForm.isRecommend" placeholder="是否推荐"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createId">
      <el-input v-model="dataForm.createId" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="状态1审核中2审核失败3审核成功4上架5下架6删除" prop="state">
      <el-input v-model="dataForm.state" placeholder="状态1审核中2审核失败3审核成功4上架5下架6删除"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="审核人" prop="checkedId">
      <el-input v-model="dataForm.checkedId" placeholder="审核人"></el-input>
    </el-form-item>
    <el-form-item label="审核时间" prop="checkedTime">
      <el-input v-model="dataForm.checkedTime" placeholder="审核时间"></el-input>
    </el-form-item>
    <el-form-item label="审核信息" prop="checkedMessage">
      <el-input v-model="dataForm.checkedMessage" placeholder="审核信息"></el-input>
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
          brandName: '',
          brandTitle: '',
          brandHistory: '',
          brandPosition: '',
          consumer: '',
          brandLabel: '',
          isRecommend: '',
          createTime: '',
          createId: '',
          state: '',
          remark: '',
          checkedId: '',
          checkedTime: '',
          checkedMessage: ''
        },
        dataRule: {
          brandName: [
            { required: true, message: '品牌名称不能为空', trigger: 'blur' }
          ],
          brandTitle: [
            { required: true, message: '品牌小标题不能为空', trigger: 'blur' }
          ],
          brandHistory: [
            { required: true, message: '品牌历史不能为空', trigger: 'blur' }
          ],
          brandPosition: [
            { required: true, message: '品牌定位不能为空', trigger: 'blur' }
          ],
          consumer: [
            { required: true, message: '消费群体不能为空', trigger: 'blur' }
          ],
          brandLabel: [
            { required: true, message: '品牌标签不能为空', trigger: 'blur' }
          ],
          isRecommend: [
            { required: true, message: '是否推荐不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createId: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '状态1审核中2审核失败3审核成功4上架5下架6删除不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          checkedId: [
            { required: true, message: '审核人不能为空', trigger: 'blur' }
          ],
          checkedTime: [
            { required: true, message: '审核时间不能为空', trigger: 'blur' }
          ],
          checkedMessage: [
            { required: true, message: '审核信息不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kywbrand/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.brandName = data.kYwBrand.brandName
                this.dataForm.brandTitle = data.kYwBrand.brandTitle
                this.dataForm.brandHistory = data.kYwBrand.brandHistory
                this.dataForm.brandPosition = data.kYwBrand.brandPosition
                this.dataForm.consumer = data.kYwBrand.consumer
                this.dataForm.brandLabel = data.kYwBrand.brandLabel
                this.dataForm.isRecommend = data.kYwBrand.isRecommend
                this.dataForm.createTime = data.kYwBrand.createTime
                this.dataForm.createId = data.kYwBrand.createId
                this.dataForm.state = data.kYwBrand.state
                this.dataForm.remark = data.kYwBrand.remark
                this.dataForm.checkedId = data.kYwBrand.checkedId
                this.dataForm.checkedTime = data.kYwBrand.checkedTime
                this.dataForm.checkedMessage = data.kYwBrand.checkedMessage
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
              url: this.$http.adornUrl(`/generator/kywbrand/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'brandName': this.dataForm.brandName,
                'brandTitle': this.dataForm.brandTitle,
                'brandHistory': this.dataForm.brandHistory,
                'brandPosition': this.dataForm.brandPosition,
                'consumer': this.dataForm.consumer,
                'brandLabel': this.dataForm.brandLabel,
                'isRecommend': this.dataForm.isRecommend,
                'createTime': this.dataForm.createTime,
                'createId': this.dataForm.createId,
                'state': this.dataForm.state,
                'remark': this.dataForm.remark,
                'checkedId': this.dataForm.checkedId,
                'checkedTime': this.dataForm.checkedTime,
                'checkedMessage': this.dataForm.checkedMessage
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
