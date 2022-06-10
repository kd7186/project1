<template>
<div style="width: 100%">
	<v-card>
	<v-card-title>
        게시글 작성
	</v-card-title>
    <v-col class="mx-auto" cols="12" sm="6">
      <v-text-field
        v-model="input.bTitle"
        label="제목"
        auto-grow
        outlined
        rows="3"
        row-height="30"
        shaped
      >
      </v-text-field>
      <v-textarea v-model="input.bContent" label="내용"></v-textarea>
	  <input multiple @change='onInputImage()' ref="boardImage" type="file">
    </v-col>
    <br />
    <v-col cols="12" align="right">
      <v-btn @click="writeaction(input)"> 작성 </v-btn>
    </v-col>
	</v-card>
  </div>
</template>
<script>
import { mapActions } from "vuex"
export default {
	data () {
		return {
			input: {
				bTitle:'',
				bContent:'',
				image:null
			}
		}
	},
	methods: {
		...mapActions(["writeaction"]),
		onInputImage() {
			this.input.image = this.$refs.boardImage.files
			console.log("this.input.image")
		},
	}
};
</script>
