<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="发布者id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="发布者id"></el-input>
    </el-form-item>
    <el-form-item label="淘宝用户id" prop="taobaoUserId">
      <el-input v-model="dataForm.taobaoUserId" placeholder="淘宝用户id"></el-input>
    </el-form-item>
    <el-form-item label="淘宝用户名" prop="taobaoUserNick">
      <el-input v-model="dataForm.taobaoUserNick" placeholder="淘宝用户名"></el-input>
    </el-form-item>
    <el-form-item label="授权验证code" prop="authCode">
      <el-input v-model="dataForm.authCode" placeholder="授权验证code"></el-input>
    </el-form-item>
    <el-form-item label="授权令牌" prop="sessionKey">
      <el-input v-model="dataForm.sessionKey" placeholder="授权令牌"></el-input>
    </el-form-item>
    <el-form-item label="授权时间" prop="authTime">
      <el-input v-model="dataForm.authTime" placeholder="授权时间"></el-input>
    </el-form-item>
    <el-form-item label="授权过期时间" prop="expiresTime">
      <el-input v-model="dataForm.expiresTime" placeholder="授权过期时间"></el-input>
    </el-form-item>
    <el-form-item label="状态；0=不明，1=正常，2=异常" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态；0=不明，1=正常，2=异常"></el-input>
    </el-form-item>
    <el-form-item label="pid 平台：QQ二合" prop="ehyPid">
      <el-input v-model="dataForm.ehyPid" placeholder="pid 平台：QQ二合"></el-input>
    </el-form-item>
    <el-form-item label="pid 平台：淘口令" prop="tklPid">
      <el-input v-model="dataForm.tklPid" placeholder="pid 平台：淘口令"></el-input>
    </el-form-item>
    <el-form-item label="pid CMS：QQ二合" prop="cmsEhyPid">
      <el-input v-model="dataForm.cmsEhyPid" placeholder="pid CMS：QQ二合"></el-input>
    </el-form-item>
    <el-form-item label="pid CMS：淘口令" prop="cmsTklPid">
      <el-input v-model="dataForm.cmsTklPid" placeholder="pid CMS：淘口令"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="comment">
      <el-input v-model="dataForm.comment" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
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
          taobaoUserId: '',
          taobaoUserNick: '',
          authCode: '',
          sessionKey: '',
          authTime: '',
          expiresTime: '',
          status: '',
          ehyPid: '',
          tklPid: '',
          cmsEhyPid: '',
          cmsTklPid: '',
          comment: '',
          updateTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '发布者id不能为空', trigger: 'blur' }
          ],
          taobaoUserId: [
            { required: true, message: '淘宝用户id不能为空', trigger: 'blur' }
          ],
          taobaoUserNick: [
            { required: true, message: '淘宝用户名不能为空', trigger: 'blur' }
          ],
          authCode: [
            { required: true, message: '授权验证code不能为空', trigger: 'blur' }
          ],
          sessionKey: [
            { required: true, message: '授权令牌不能为空', trigger: 'blur' }
          ],
          authTime: [
            { required: true, message: '授权时间不能为空', trigger: 'blur' }
          ],
          expiresTime: [
            { required: true, message: '授权过期时间不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态；0=不明，1=正常，2=异常不能为空', trigger: 'blur' }
          ],
          ehyPid: [
            { required: true, message: 'pid 平台：QQ二合不能为空', trigger: 'blur' }
          ],
          tklPid: [
            { required: true, message: 'pid 平台：淘口令不能为空', trigger: 'blur' }
          ],
          cmsEhyPid: [
            { required: true, message: 'pid CMS：QQ二合不能为空', trigger: 'blur' }
          ],
          cmsTklPid: [
            { required: true, message: 'pid CMS：淘口令不能为空', trigger: 'blur' }
          ],
          comment: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kywtaobaoauth/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.kYwTaobaoAuth.userId
                this.dataForm.taobaoUserId = data.kYwTaobaoAuth.taobaoUserId
                this.dataForm.taobaoUserNick = data.kYwTaobaoAuth.taobaoUserNick
                this.dataForm.authCode = data.kYwTaobaoAuth.authCode
                this.dataForm.sessionKey = data.kYwTaobaoAuth.sessionKey
                this.dataForm.authTime = data.kYwTaobaoAuth.authTime
                this.dataForm.expiresTime = data.kYwTaobaoAuth.expiresTime
                this.dataForm.status = data.kYwTaobaoAuth.status
                this.dataForm.ehyPid = data.kYwTaobaoAuth.ehyPid
                this.dataForm.tklPid = data.kYwTaobaoAuth.tklPid
                this.dataForm.cmsEhyPid = data.kYwTaobaoAuth.cmsEhyPid
                this.dataForm.cmsTklPid = data.kYwTaobaoAuth.cmsTklPid
                this.dataForm.comment = data.kYwTaobaoAuth.comment
                this.dataForm.updateTime = data.kYwTaobaoAuth.updateTime
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
              url: this.$http.adornUrl(`/generator/kywtaobaoauth/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'taobaoUserId': this.dataForm.taobaoUserId,
                'taobaoUserNick': this.dataForm.taobaoUserNick,
                'authCode': this.dataForm.authCode,
                'sessionKey': this.dataForm.sessionKey,
                'authTime': this.dataForm.authTime,
                'expiresTime': this.dataForm.expiresTime,
                'status': this.dataForm.status,
                'ehyPid': this.dataForm.ehyPid,
                'tklPid': this.dataForm.tklPid,
                'cmsEhyPid': this.dataForm.cmsEhyPid,
                'cmsTklPid': this.dataForm.cmsTklPid,
                'comment': this.dataForm.comment,
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
