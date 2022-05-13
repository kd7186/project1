<template>
    <div class="controller">
	<table>
	<tr style="background-color : #000000">
	<td width="40px" style="color:white">#</td>
	<td width="510px" style="color:white">제목</td>
	<td width="120px" style="color:white">작성자</td>
	<td width="120px" style="color:white">날짜</td>
	<td width="50px" style="color:white">조회수</td>
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
	<div style="text-align: center;">
			<form name="sform" method="get" action="/1"  >
    			<select name="find">
        			<option value="b_writer">작성자</option>
        			<option value="b_title">제목</option>
       				<option value="b_content">내용</option>
    			</select>
    			<input name="search" type="text" class="form-control" size="20" placeholder="검색어를 입력하세요.">
    			<input type="submit" value="찾기">
			</form>
            <a href="/write">글쓰기</a>
	</div>
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
	},
	methods: {
    article: function (bId) {
      this.$router.push({name: '/article', params: {bId: bId}})
   		}	
	},
	props: ['bId']
}
</script>
<style scoped>
.controller {
	padding: 25px 0;
	margin : auto;
	width : 840px;
	text-align: center;
	}
table {
	width: 840px
	}
	th {
	background-color : rgb(100,100,100);
	color : white;
	}
	button {
	margin : 4px 0;
	padding: 10px 0;
	width: 100px;
	background-color: #1595a3;
	color : white;
	border: none;
}
	a{
	text-decoration: none;
	color: black;
	}
	a:hover {
		color: #000000;
		text-decoration-line: underline;
		}
		
	nav {
  display: flex;
 justify-content: space-around;
  align-items: center;
  background-color: #404040;
  color: white;
  margin : 0;
  padding : 0;
}

	nav ul li{
		display : inline-block;
	}
	
	.logo {
	letter-spacing:2px;
	font-size : 15px;
	text-align : left;
	float : center;
	}
	
	.logo a {
	color:white;
	padding : 16px 16px;
	}
	
	.dropdown {
		position : relative;
	}
	
	.dropdown-menu {
		color : white;
		font-size: 16px;
	}
	
	.dropdown-content {
			position: absolute;
   			 background-color: #f9f9f9;
    		min-width: 160px;
    		box-shadow: 0px 8px 24px 0px rgba(0,0,0,0.2);
    		display: none;
	}
	
	.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}   

	.dropdown-menu:hover:not(.home){
    background-color:#7a7a7a ;
    color: white;
}

	.dropdown:hover .dropdown-content {
    display: block;
}

	.dropdown-content a:hover {background-color: #f1f1f1}
</style>