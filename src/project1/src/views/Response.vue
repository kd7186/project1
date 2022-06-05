<template>
  <div style="width: 100%">
    <v-card class="mx-auto" width="80%" style="padding-left: 50px">
      <v-card-title>{{ this.Response.sId }}번 설문지 통계자료</v-card-title>
      <br />
      <component
        v-for="(item, index) in this.Response.questions"
        :key="index"
        :is="item.t + 'Chart'"
        :index="index"
        :answers="Response.questions[index].resultAnswers"
        :count="Response.questions[index].resultCount"
      >
      </component>
    </v-card>
  </div>
</template>
<script>
import RadioQChart from "@/views/RadioQChart";
import ShortQChart from "@/views/ShortQChart";
import LongQChart from "@/views/LongQChart";
import CheckQChart from "@/views/CheckQChart";
import DropQChart from "@/views/DropQChart";
import { mapState } from "vuex";
export default {
  //<RadioQChart :height="'200px'" :first-data="'100'" :second-data="'500'" />
  computed: {
    ...mapState(["Response"]),
  },
  components: {
    RadioQChart,
    ShortQChart,
    LongQChart,
    CheckQChart,
    DropQChart,
  },
};
</script>