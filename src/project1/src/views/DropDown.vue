<template>
  <v-card class="mx-auto" max-width="800" outlined>
    <v-list-item three-line>
      <v-list-item-content>
        <div>
          <v-col cols="12" sm="6" md="10">
            <v-text-field
              v-model="question"
              label="질문 내용"
            ></v-text-field>
          </v-col>
          <v-list-item-title class="text-h5 mb-1"> </v-list-item-title>
          <v-list-item-subtitle
            >드롭다운 텍스트 질문</v-list-item-subtitle
          >
        </div>
        <v-container fluid>
          <drop
            :qindex="qindex"
            v-for="(item, index) in Options"
            :key="index"
            :index="index"
          />
          <v-col>
            <v-btn rounded text @click="addOption">
              옵션 추가
            </v-btn>
          </v-col>
        </v-container>
      </v-list-item-content>
      <v-col class="d-flex" cols="12" sm="6">
        <v-spacer></v-spacer>
        <v-select
          @change="selectQuestion"
          v-model="selected"
          :items="items"
          label="Question type"
          dense
          solo
        ></v-select>
      </v-col>
    </v-list-item>
    <buttons @deleteQuestion="deleteQuestion" @addQuestion="addQuestion" />
  </v-card>
</template>


<script>
import buttons from "@/views/buttons";
import drop from "@/views/drop";
export default {
  props: ["index"],
  data() {
    return {
      qindex: this.index,
      selected: "",
      items: [
        "ShortAnswer",
        "LongAnswer",
        "RadioAnswer",
        "CheckBox",
        "DropDown",
      ],
    };
  },
  computed: {
    question: {
      get() {
        this.$store.state.Survey.questions[this.index].t = "DropQ";
        return this.$store.state.Survey.questions[this.index].q;
      },
      set(value) {
        let data = { value: value, index: this.index };
        this.$store.commit("updateQuestion", data);
      },
    },
    Options: {
      get() {
        return this.$store.state.Survey.questions[this.index].answers;
      },
      set(value) {
        let data = { value: value, index: this.index };
        this.$store.commit("updateOptions", data);
      },
    },
  },
  components: {
    buttons,
    drop,
  },
  methods: {
    addQuestion() {
      this.$emit("addQuestion");
    },
    deleteQuestion() {
      this.$emit("deleteQuestion", this.index);
    },
    selectQuestion() {
      this.$emit("selectQuestion", this.selected, this.index);
    },
    addOption() {
      this.$store.state.Survey.questions[this.qindex].answers.push({
        answer: {},
      });
    },
  },
};
</script>