<template>
  <div>
      <MyHeader></MyHeader>
      <h2 v-text="dat.title"></h2>
      <p>作者{{dat.author.loginname}} 发表于{{$utils.goodTime(dat.create_at)}}</p>
      <hr>
      <article v-html="dat.content"></article>
      <MyFooter></MyFooter>
  </div>
</template>

<script>
import MyHeader from '../components/header.vue'
import MyFooter from '../components/footer.vue'
export default {
  components: {MyHeader,MyFooter},
  data() {
      return {
          id: this.$route.params.id,
          dat: {}
      }
  },
  methods: {
      getData() {
          this.$api.get('topic/' + this.id, null, r => {
              this.dat = r.data
          })
      }
  },
  created() {
      this.getData()
  }
}
</script>

