<template>
  <div>
    <br />
    <p>Q. {{ this.question }}</p>
    <v-container class="px-0" fluid>
      <v-checkbox
        v-for="(item, index) in this.answers"
        :key="index"
        v-model="selected"
        :label="item.answer"
        :value="item.answer"
      ></v-checkbox>
    </v-container>
  </div>
</template>
<script>
export default {
  props: ["question", "answers", "qId", "index"],
  data() {
    return {};
  },
  computed: {
    selected: {
      get() {
        return this.$store.state.Answers.questions[this.index].answers;
      },
      set(value) {
        let data = { value: value, index: this.index };
        this.$store.commit("update_MultipleAnswer", data);
      },
    },
  },
  created() {
    this.$store.state.Answers.questions.push({
      qId: this.qId,
      t: "CheckQ",
      answers: [],
    });
  },
};
</script>