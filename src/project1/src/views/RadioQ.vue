<template>
  <div>
    <br />
    <p>Q. {{ this.question }}</p>
    <v-container class="px-0" fluid>
      <v-radio-group v-model="radioGroup">
        <v-radio
          v-for="(item, index) in this.answers"
          :key="index"
          :label="item.answer"
          :value="item.answer"
        ></v-radio>
      </v-radio-group>
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
    radioGroup: {
      get() {
        return this.$store.state.Answers.questions[this.index].answers[0];
      },
      set(value) {
        let data = { value: value, index: this.index };
        this.$store.commit("update_SingleAnswer", data);
      },
    },
  },
  created() {
    this.$store.state.Answers.questions.push({
      qId: this.qId,
      t: "RadioQ",
      answers: [],
    });
  },
};
</script>