<template>
  <div style="width: 100%">
    <v-col class="mx-auto" cols="12" sm="6">
      <v-textarea
        v-model="title"
        label="설문 제목"
        auto-grow
        outlined
        rows="3"
        row-height="30"
        shaped
      >
      </v-textarea>
      <v-text-field v-model="disc" label="설문지 설명"></v-text-field>
    </v-col>
    <br />
    <div>
      <component
        @selectQuestion="selectQuestion"
        @addQuestion="addQuestion"
        @deleteQuestion="deleteQuestion"
        v-for="(item, index) in Questions"
        :is="item"
        v-bind:key="index"
        :index="index"
      ></component>
    </div>
    <v-col cols="12" align="right">
      <v-btn router :to="{ name: 'SurveyList' }">
        <font-awesome-icon icon="backspace" />
      </v-btn>
      <v-btn @click="save"> save </v-btn>
    </v-col>
  </div>
</template>
<script>
/* import ShortAnswer from "@/views/ShortAnswer";
import LongAnswer from "@/views/LongAnswer";
import RadioAnswer from "@/views/RadioAnswer";
import CheckBox from "@/views/CheckBox.vue";
import DropDown from "@/views/DropDown.vue"; */
import { mapActions } from "vuex";
export default {
  data() {
    return {
      Questions: [],
      selectedType: "",
      selected: ShortAnswer,
    };
  },
  computed: {
    title: {
      get() {
        return this.$store.state.Survey.title;
      },
      set(value) {
        this.$store.commit("updateTitle", value);
      },
    },
    disc: {
      get() {
        return this.$store.state.Survey.disc;
      },
      set(value) {
        this.$store.commit("updateDisc", value);
      },
    },
  },
  /* components: {
    ShortAnswer,
    LongAnswer,
    RadioAnswer,
    CheckBox,
    DropDown,
  }, */
  methods: {
    ...mapActions(["CreateSurvey"]),
    addQuestion() {
      this.$store.state.Survey.questions.push({ t: {}, q: {}, answers: [] });
      this.Questions.push(ShortAnswer);
    },
    deleteQuestion(num) {
      this.Questions.splice(num, 1);
      this.$store.state.Survey.questions.splice(num, 1);
    },
    selectQuestion(selected, index) {
      this.$store.state.Survey.questions.splice(index, 1, {
        q: {},
        answers: [],
      });
      if (selected === "LongAnswer") {
        this.Questions.splice(index, 1, LongAnswer);
      } else if (selected === "RadioAnswer") {
        this.Questions.splice(index, 1, RadioAnswer);
      } else if (selected === "CheckBox") {
        this.Questions.splice(index, 1, CheckBox);
      } else if (selected === "ShortAnswer") {
        this.Questions.splice(index, 1, ShortAnswer);
      } else {
        this.Questions.splice(index, 1, DropDown);
      }
    },
    save() {
      this.CreateSurvey();
    },
  },
  created() {
    (this.$store.state.Survey = { title: "", disc: "", questions: [] }),
      this.$store.state.Survey.questions.push({ q: {}, answers: [] });
    this.Questions.push(ShortAnswer);
  },
};
</script>