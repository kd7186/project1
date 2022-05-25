 <template>
  <v-col class="d-flex">
    <v-text-field
      v-model="answer"
      style="width: 5px"
      label="DropDown Option"
    ></v-text-field>
    <v-btn @click="deleteOption" x-small>X</v-btn>
  </v-col>
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