<template>
  <v-radio>
    <template v-slot:label>
      <v-col class="d-flex">
        <v-text-field
          style="width: 280px"
          label="Radio Option"
          v-model="answer"
        ></v-text-field>
        <v-btn @click="deleteOption" x-small>X</v-btn>
      </v-col>
    </template>
  </v-radio>
</template>
<script>
export default {
  props: ["index", "qindex"],
  computed: {
    answer: {
      get() {
        return this.$store.state.Survey.questions[this.qindex].answers[
          this.index
        ].answer;
      },
      set(value) {
        let data = { value: value, index: this.index, qindex: this.qindex };
        this.$store.commit("updateAnswer", data);
      },
    },
  },
  methods: {
    deleteOption() {
      this.$store.state.Survey.questions[this.qindex].answers.splice(
        this.index,
        1
      );
    },
  },
};
</script>