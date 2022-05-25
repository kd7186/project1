<template>
  <v-card class="mx-auto" max-width="800" outlined>
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">
          <v-col cols="12" sm="6" md="10">
            <v-text-field
              v-model="question"
              label="질문"
            ></v-text-field>
          </v-col>
        </div>
        <v-list-item-title class="text-h5 mb-1"> </v-list-item-title>
        <v-list-item-subtitle>단답형 텍스트 질문</v-list-item-subtitle>
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
export default {
  name: "ShortAnswer",
  props: ["index"],
  data() {
    return {
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
        this.$store.state.Survey.questions[this.index].t = "ShortQ";
        return this.$store.state.Survey.questions[this.index].q;
      },
      set(value) {
        let data = { value: value, index: this.index };
        this.$store.commit("updateQuestion", data);
      },
    },
  },
  components: {
    buttons,
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
  },
};
</script>