<template>
  <div>
    <br />
    <p>Q. {{ this.question }}</p>
    <v-container class="px-0" fluid>
      <v-row align="center">
        <v-col class="d-flex" cols="12" sm="6">
          <v-select
            :items="items"
            label="Outlined style"
            v-model="selected"
            outlined
          ></v-select>
        </v-col>
      </v-row>
      {{ this.selected }}
    </v-container>
  </div>
</template>
<script>
export default {
  props: ["question", "answers", "qId", "index"],
  data() {
    return {
      items: [],
    };
  },
  computed: {
    selected: {
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
      t: "DropQ",
      answers: [],
    });
    for (let i = 0; i < this.answers.length; i++) {
      this.items.push(this.answers[i].answer);
    }
  },
};
</script>