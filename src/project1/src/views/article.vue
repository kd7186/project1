<!-- <template>
<div class = "controller">
	<div class ="row">
		<div>
			<table class="table table-striped" style="text-align:left; width:840px">
				<thead>
					<tr>
						<td style="height:50px; font-size:25px;"><STRONG>{{article.bTitle}}</STRONG></td>
					</tr>
					<tr>
						<th colspan="2" align="center" style="height: 1px"></th>
					</tr>
					<tr>
						<td style="width: 10%; height: 20px"><strong>작성자</strong></td>
						<td colspan="2">{{article.bWriter}}</td>
					</tr>
					<tr>
						<td style="width: 10%; height: 20px"><strong>날짜</strong></td>
						<td colspan="2">{{article.bDatetime}}</td>
					</tr>
					<tr>
						<td style="width: 10%; height: 20px"><strong>조회수</strong></td>
						<td colspan="2">{{article.bBrdhit}}</td>
					</tr>
					<tr>
						<th colspan="2" align="center" style="height: 1px"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th colspan="2" align="center" style="height: 20px; background-color : rgb(255,255,255); color:white;" ></th>
					</tr>
					<tr id="content" valign="top" style="border-top-color: rgb(100, 100, 100); border-top-width: 15px">
						<td colspan="3">{{article.bContent }}</td>
					</tr>
					<tr>
						<th colspan="2" align="center" style="height: 0.25px; background-color : rgb(0,0,0);"></th>
					</tr>
                </tbody>
				</table>
		</div>
	</div>
</div>
</template> -->
<template>
  <div style="width: 100%">
    <v-card class="mx-auto" width="80%">
      <v-card-text>
        <div>NO. {{ article.sId }}</div>
        <span class="text-h4 text--primary"> {{ article.bTitle }} </span>
        <p>{{ article.bDatetime }}</p>
		<p>{{ article.bBrdhit}} views </p>
        <div> <span class="text-h6 text--primary"> {{ SurveyDetail.bContent }}</span> </div>
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
		console.log('param 확인' + this.$route.params.bId)
	},
	data () {
		return {
			bId: {bId: this.$route.params.bId,},
			bTitle : this.$store.state.article.bTitle,
			bContent : this.$store.state.article.bContent,
			bWriter : this.$store.state.article.bWriter,
			bDatetime : this.$store.state.article.bDatetime,
			bBrdhit : this.$store.state.article.bBrdhit,
			
		
		}
	},
	computed: {
		...mapState(["article"])
	}
}
</script>