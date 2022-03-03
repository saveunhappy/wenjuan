<template>
  <div class="card mb-4 shadow-sm">
    <img class="img-fluid" v-bind:src="plant.image">
    <div class="card-body">
      <h4 class="">{{plant.name}}</h4>
      <p class="card-text">{{plant.summary}}</p>
      <div class="d-flex justify-content-between align-items-center">
        <div class="btn-group">
          <button type="button" class="btn btn-sm btn-outline-secondary">绿植详情</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "the-plant",
  props:{
    plant:{},
  },
  data: function (){
    return {}
  },
}
</script>

<style scoped>

</style>