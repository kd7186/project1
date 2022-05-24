<template>
		<table>
			<tbody>
				<tr>
					<td>
						<h2 class="pt-2">글 작성</h2>
					</td>
				</tr>
				<tr>
					<td><input style="height:100%; width:100%;" placeholder="제목을 입력하세요" v-model="bTitle">
					</td>
				</tr>
				<tr>
					<td colspan="2"><input style="height:650px; width:840px;" placeholder="내용을 입력하세요" v-model="bContent"></td>
				</tr>
				<tr>
					<td><v-file-input id="file" ref="file" v-model="fileinput"></v-file-input></td>
				</tr>
				<tr>
					<td align="center"><v-btn @click="writeaction({bTitle:bTitle, bContent:bContent})">등록 </v-btn></td>
				</tr>
			</tbody>
		</table>
</template>
<style scoped>
.controller { padding:25px 0; margin: auto; width:840px;}
#wriTitle{text-align: center; background-color: #2b2b2b; width:850px; height: 25px; padding:12px 0; color: white;}
table { width:840px; margin:25px 0; padding:25px; border-collapse:collapse;}
#title{width : 840px; height: 24px;}
textarea{width: 840px; height: 650px;}
.button {margin : 4px 0; padding: 10px 0; width: 100px; background-color: #000000; color : white; border: none;}
button {align: center; margin : 4px 0; padding: 10px 0; width: 100px; background-color: #a34654; color : white; border: none;}
textarea {resize:none;}
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
<script>
import { mapActions } from "vuex"
export default {
	created() {
		this.$store.dispatch('board')
	},
	data () {
		return {
			bTitle:'',
			bContent:'',
			fileinput:null
		}
	},
	methods: {
		...mapActions(["writeaction"]),
	}
}
</script>
