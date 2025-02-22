<template>
    <div>
        <NavBar/>
        <v-row>
            <ProfileSide/>
            <v-col cols="8" style="margin-right: 8%; margin-top: 5%">
                <v-card align="center" style="margin-bottom: 5%">
                    <h2 style="padding: 5%">
                        写文章
                    </h2>
                </v-card>
                <v-card>
                    <h2 align="center">
                        文章内容
                    </h2>
                    <el-divider></el-divider>
                    <v-form v-model="valid">
                        <h3>
                            文章标题
                        </h3>
                        <v-text-field
                                v-model="tempArticleData.articleTitle"
                                style="margin: 5%"
                                label="标题"
                                name="articleTitle"
                                :rules="titleRules"
                                filled
                        ></v-text-field>
                        <h3>
                            文章内容
                        </h3>
                        <v-textarea
                                v-model="tempArticleData.articleContent"
                                style="margin: 5%"
                                name="articleContent"
                                filled
                                label="内容"
                                :rules="contentRules"
                                auto-grow
                        >
                        </v-textarea>
                    </v-form>
                </v-card>

                <el-card>
                    <h2 align="center">
                        文章封面
                    </h2>
                    <el-divider></el-divider>
                    <el-upload
                            align="center"
                            class="avatar-uploader"
                            action="https://upload-z1.qiniup.com"
                            :show-file-list="false"
                            :data="postData"
                            :on-success="onCropUploadSuccess"
                            :before-upload="beforeAvatarUpload">
                        <img v-if="tempArticleData.articleFront" :src="tempArticleData.articleFront" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-card>

                <el-card style="margin-bottom: 10%; margin-top: 5%">
                    <v-btn large min-height="100px" min-width="200px" @click="handlePublish" :disabled="!valid">
                        发布
                    </v-btn>
                </el-card>
            </v-col>
        </v-row>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import NavBar from "@/layout/components/NavBar.vue";
    import ProfileSide from "@/layout/components/ProfileSide.vue";
    import {createArticle, defaultArticleData} from "@/api/articles";
    import {getToken} from "@/api/token";
    import {isValidateEmail, isValidatePassword} from "@/utils/validate";
    import {UserModule} from "@/store/modules/user";

    @Component({
        name: 'AddArticle',
        components: {
            NavBar,
            ProfileSide
        }
    })
    export default class App extends Vue {
        private tempArticleData = defaultArticleData
        private valid = true

        private postData = {
            key: '',
            token: ''
        }
        private backUrl = 'http://q3lynq058.bkt.clouddn.com/'

        private titleRules = [
            (v: any) => !!v || '请输入邮箱!'
        ]
        private contentRules = [
            (v: any) => !!v || '请输入密码!'
        ]

        created() {
            this.genToken()
        }

        private async genToken() {
            let data = await getToken()
            this.postData.token = data.data
        }

        private onCropUploadSuccess(res: any, file: any) {
            this.tempArticleData.articleFront = this.backUrl + res.key
        }

        private beforeAvatarUpload(file: any) {
            this.postData.key = file.uid.toString() + file.name;
            const isJPG = file.type === "image/jpeg";
            const isPNG = file.type === "image/png";
            const isLt2M = file.size / 1024 / 1024 < 4;
            if (!isJPG && !isPNG) {
                this.$message.error("图片只能是 JPG/PNG 格式!");
                return false;
            }
            if (!isLt2M) {
                this.$message.error("图片大小不能超过 4MB!");
                return false;
            }
        }

        private async handlePublish() {
            let formData = new FormData()
            formData.append('articleTitle', this.tempArticleData.articleTitle)
            formData.append('articleContent', this.tempArticleData.articleContent)
            formData.append('articleAuthor', UserModule.id.toString())
            formData.append('articleFront', this.tempArticleData.articleFront)
            let datas = await createArticle(formData)
            datas = datas.data
            console.log(datas)
            this.$router.push("/my-profile")
        }

    }
</script>

<style scoped>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 984px;
        height: 484px;
        line-height: 178px;
        text-align: center;
    }

    .avatar {
        width: 984px;
        height: 484px;
        display: block;
    }
</style>
