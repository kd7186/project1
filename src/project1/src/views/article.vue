
<template>
  <div style="width: 100%">
    <v-card class="mx-auto" width="80%">
      <v-card-text>
        <div>NO. {{ article.bId }}</div>
        <span class="text-h4 text--primary"> {{ article.bTitle }} </span>
        <p>{{ article.bDatetime }}</p>
		<p>{{ article.bBrdhit}} views </p>
        <div v-for="file in article.files" :key="article.bId">
        <img :src="file.fileUrl + file.fileName"/>
        </div>
        <div>
          <span class="text-h6 text--primary"> {{ article.bContent }}</span> </div>
        <br />
      </v-card-text>
    </v-card>
    <br />
  </div>
</template>
<script>
import { mapState, mapActions } from "vuex"
export default {
	created() {
		this.$store.dispatch('article', {params: {bId: this.$route.params.bId}})
	},
	data () {
		return {
		}
	},
	computed: {
		...mapState(["article"])
	}
}
</script>