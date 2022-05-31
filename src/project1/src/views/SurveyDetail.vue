<template>
  <div style="width: 100%">
    <v-card class="mx-auto" width="80%">
      <v-card-text>
        <div># {{ SurveyDetail.sId }}</div>
        <span class="text-h4 text--primary"> {{ SurveyDetail.sTitle }} </span>
        <span>: {{ SurveyDetail.sDescription }}</span>
        <p>{{ SurveyDetail.sDatetime }}</p>
        <br />
        <component
          v-for="(item, index) in SurveyDetail.questions"
          :is="item.t"
          :key="index"
          :question="item.q"
          :qId="item.qId"
          :index="index"
          :answers="item.answers"
        />
      </v-card-text>
      <v-card-actions>
        <v-btn text color="teal accent-4" @click="submit"> 제출</v-btn>
        <v-btn text color="teal accent-4" router @click="results">
         결과 보기
        </v-btn>
      </v-card-actions>
    </v-card>
    <br />
    <v-col cols="12" align="right">
      <v-btn @click="deleteSurvey">Delete</v-btn>
    </v-col>
  </div>
</template>

<script>
import { mapState } from "vuex";
import ShortQ from "../views/ShortQ.vue";
import LongQ from "../views/LongQ.vue";
import RadioQ from "../views/RadioQ.vue";
import CheckQ from "../views/CheckQ.vue";
import DropQ from "../views/DropQ.vue";
export default {
  components: { ShortQ, LongQ, RadioQ, CheckQ, DropQ },
  data() {
    return {};
  },
  computed: {
    ...mapState(["SurveyDetail"]),
  },
  methods: {
    submit() {
      this.$store.dispatch("SubmitAnswers");
    },
    results() {
      this.$store.dispatch("getResults", this.SurveyDetail.sId);
    },
    deleteSurvey() {
      this.$store.dispatch("deleteSurvey", this.SurveyDetail.sId);
    },
  },
  created() {
    this.$store.state.Answers = { sId: "", questions: [] };
    this.$store.commit("update_S_num", this.SurveyDetail.sId);
  },
};
</script>