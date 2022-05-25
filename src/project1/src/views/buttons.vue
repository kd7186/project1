<template>
  <v-card-actions>
    <v-col cols="12" align="right">
      <v-btn rounded text @click="addQuestion">
        질문 추가
      </v-btn>
      <v-btn rounded text @click="deleteQuestion">
        질문 삭제
      </v-btn>
    </v-col>
  </v-card-actions>
</template>
<script>
export default {
  methods: {
    addQuestion() {
      this.$emit("addQuestion");
    },
    deleteQuestion() {
      this.$emit("deleteQuestion");
    },
  },
};
</script>