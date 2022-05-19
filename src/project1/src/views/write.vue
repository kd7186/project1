<template>
    <div class="controller">
		<div id="wriTitle" style="height: 50px"><b>글 작성</b></div>
		<table>
			<tbody>
				<tr>
					<td><input type="text" name="bTitle" placeholder="제목을 입력하세요" v-model="bTitle" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="12" cols="50" placeholder="내용을 입력하세요" name="bContent" v-model="bContent"></textarea></td>
				</tr>
				<tr>
					<td><input id="file" ref="file" @change='onInputImage()' type="file"></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="등록" class="button" @click="writeaction({bTitle:bTitle, bContent:bContent, file:file})"></td>
				</tr>
			</tbody>
		</table>
	</div>
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
	data () {
		return {
			bTitle:'',
			bContent:'',
			file: ''
		}
	},
	methods: {
		onInputImage() {
			this.file= this.$refs.file
			console.log(this.file)
		},
		...mapActions(['writeaction']),
		}
	}
</script>
