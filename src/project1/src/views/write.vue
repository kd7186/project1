<template>
<div style="width: 100%">
	<v-card>
	<v-card-title>
        게시글 작성
	</v-card-title>
    <v-col class="mx-auto" cols="12" sm="6">
      <v-text-field
        v-model="bTitle"
        label="제목"
        auto-grow
        outlined
        rows="3"
        row-height="30"
        shaped
      >
      </v-text-field>
      <v-textarea v-model="bContent" label="내용"></v-textarea>
	  <v-file-input v-model="file" class="input" type="file" name="fileList" label="여러개 선택가능" multiple></v-file-input>
    </v-col>
    <br />
    <v-col cols="12" align="right">
      <v-btn @click="writeaction({file,bTitle,bContent})"> 작성 </v-btn>
    </v-col>
	</v-card>
  </div>
</template>
<script>
import { mapActions } from "vuex"
export default {
	data () {
		return {
			bTitle:'',
			bContent:'',
			file:null
		}
	},
	methods: {
		...mapActions(["writeaction"]),
	}
};
</script>
