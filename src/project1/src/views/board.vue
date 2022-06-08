<template>
  <div style="width: 100%">
    <v-card>
      <v-card-title>
        게시판 목록
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
      </v-card-title>
      <v-data-table
        v-model="selected"
        :single-select="singleSelect"
        show-select
        item-key="bId"
        :headers="headers"
        :items="boardlist"
        :search="search"
        @click:row="article"
      ></v-data-table>
    </v-card>
	<v-col cols="12" align="right">
      <v-btn depressed router :to="{ name: 'write' }"
        >게시판 작성</v-btn
      >
    </v-col>
  </div>
</template>
<script>
import { mapState, mapActions } from "vuex"

export default {
	data() {
    return {
      singleSelect: false,
      selected: [],
      search: "",
      headers: [
        {
          text: "#",
          align: "start",
          sortable: false,
          value: "bId",
        },
        { text: "제목", value: "bTitle" },
        { text: "작성자", value: "bWriter" },
        { text: "날짜", value: "bDatetime" },
		{ text: "조회수", value: "bBrdhit" },
        { text: "bId", value: "bId", align: " d-none" },
      ],
    };
  },
	created() {
		this.$store.dispatch('getBoardList')
	},
	computed: {
		...mapState(["boardlist"])
	},
	methods: {
    ...mapActions(["getArticle"]),
    article(row) {
      this.getArticle(row.bId);
    },
	}
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