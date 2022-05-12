<template>
    <div class="controller">
	<table>
	<tr>
	<td width="40px">#</td>
	<td width="510px">제목</td>
	<td width="120px">작성자</td>
	<td width="120px">날짜</td>
	<td width="50px">조회수</td>
	</tr>
			<tr v-for="(item, i) in boardlist" :key="i">
			<td>{{item.bId}}</td>
			<td>
				<router-link :to="{name:'article', params:{ bId : item.bId }}">{{item.bTitle}}</router-link>
			</td>
			<td>{{item.bWriter}}</td>
			<td>{{item.bDatetime}}</td>
			<td>{{item.bBrdhit}}</td>
			</tr>
	</table>
			<form name="sform" method="get" action="/1">
    			<select name="find">
        			<option value="b_writer">작성자</option>
        			<option value="b_title">제목</option>
       				<option value="b_content">내용</option>
    			</select>
    			<input name="search" type="text" class="form-control" size="20" placeholder="검색어를 입력하세요.">
    			<input type="submit" value="찾기">
			</form>
            <a href="/write"><button>글쓰기</button></a>
		</div>
</template>
<script>
import { mapState, mapActions } from "vuex"

export default {
	created() {
		this.$store.dispatch('board')
	},
	computed: {
		...mapState(["boardlist"])
	}
}
</script>