<template>
  <div>
    <p>{{ this.index + 1 }}번 질문</p>
    <p v-for="(item, index) in this.answers" :key="index">- {{ item }}</p>
    <br />
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  props: ["index", "answers"],
  computed: {
    ...mapState(["Response"]),
  },
};
</script>