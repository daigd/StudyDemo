<template>
  <div>
      <MyHeader></MyHeader>
      <el-card class="box-card">
          <!-- <div slot="header" class="clearfix">
              <h2 style="line-height:36px;color: #20A0FF">文章列表</h2>
          </div> -->
          <div v-for="item in list" :key="item.id" class="text item">
            <time v-text="$utils.goodTime(item.create_at)"></time>
            <router-link :to="'/content/' + item.id">
                {{item.title}}
            </router-link>
        </div>
      </el-card>
      <MyFooter></MyFooter>
  </div>
</template>
<script>
import MyHeader from '../components/header.vue'
import MyFooter from '../components/footer.vue'
export default {
  created(){
      this.getData()
  },
  components:{MyHeader,MyFooter},
  data() {
      return {
          list: []
      }
  },
  methods: {
      getData() {
          this.$api.get('topics', null, r => {
              this.list = r.data
          })
      }
  }
}
</script>

