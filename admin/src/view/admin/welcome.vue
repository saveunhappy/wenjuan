<template>
  <div>

    <div id="main" style="width: 100%;height:600px;"></div>
  </div>
</template>
<script>
export default {
  name: "welcome",
  data: function () {
    return {
      courseTarget: {},
      courseTargets: [],
    }
  },
  mounted() {
    let _this = this;
    _this.list(1);
   // this.$parent.activeSidebar("welcome-sidebar");
  },
  methods:{
    list(page) {
      let _this = this;
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/courseTarget/list",
          {
            page: page,
            size: 1000
          }).then((response) => {
        console.log("查询课程目标列表结果", response);
        let resp = response.data;
        _this.courseTargets = resp.content.list;
        let list = resp.content.list;
        // console.log('_this.courseTargets',_this.courseTargets);
        // 基于准备好的dom，初始化echarts实例
        const myChart = echarts.init(document.getElementById('main'));
        console.log("list",list);

        const xAxis = [];
        const seriesExpect = [];
        const seriesActual = [];

        for (let i = 0; i < list.length; i++) {
          const record = list[i];
          xAxis.push(record.target);
          seriesExpect.push(record.teacherEvaluate);
          seriesActual.push(record.goalScore);
        }

        // 指定图表的配置项和数据
        const option = {
          title: {
            text: '课程目标达成评价值'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              crossStyle: {
                color: '#999'
              }
            }
          },
          toolbox: {
            feature: {
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar']},
              restore: {show: true},
              saveAsImage: {show: true}
            }
          },
          legend: {
            data: ['Evaporation']
          },
          xAxis: [
            {
              type: 'category',
              data: xAxis,
              axisPointer: {
                type: 'shadow'
              }
            }
          ],
          yAxis: [
            {
              type: 'value',
              name: '',
              min: 0,
              max: 1,
              interval: 0.2,
              axisLabel: {
                formatter: '{value} '
              }
            },
            {
              type: 'value',
              name: '',
              min: 0,
              max: 1,
              interval: 0.2,
              axisLabel: {
                formatter: '{value} '
              }
            }
          ],
          series: [
            {
              name: '达成值',
              type: 'bar',
              tooltip: {
                valueFormatter: function (value) {
                  return value;
                }
              },
              data: seriesActual
            },

            {
              name: '期望值',
              type: 'line',
              yAxisIndex: 1,
              tooltip: {
                valueFormatter: function (value) {
                  return value;
                }
              },
              data: seriesExpect
            }
          ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
      })
    },



    getCourseTargetEcharts(list){
      // 基于准备好的dom，初始化echarts实例
      const myChart = echarts.init(document.getElementById('main'));
      console.log("list",list);

      const xAxis = [];
      const seriesExpect = [];
      const seriesActual = [];

      for (let i = 0; i < list.length; i++) {
        const record = list[i];
        xAxis.push(record.target);
        seriesExpect.push(record.teacherEvaluate);
        seriesActual.push(record.goalScore);
      }

      // 指定图表的配置项和数据
      const option = {
        title: {
          text: '课程目标达成评价值'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999'
            }
          }
        },
        toolbox: {
          feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
          }
        },
        legend: {
          data: ['Evaporation']
        },
        xAxis: [
          {
            type: 'category',
            data: xAxis,
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '',
            min: 0,
            max: 1,
            interval: 0.2,
            axisLabel: {
              formatter: '{value} '
            }
          },
          {
            type: 'value',
            name: '',
            min: 0,
            max: 1,
            interval: 0.2,
            axisLabel: {
              formatter: '{value} '
            }
          }
        ],
        series: [
          {
            name: '达成值',
            type: 'bar',
            tooltip: {
              valueFormatter: function (value) {
                return value;
              }
            },
            data: seriesActual
          },

          {
            name: '期望值',
            type: 'line',
            yAxisIndex: 1,
            tooltip: {
              valueFormatter: function (value) {
                return value;
              }
            },
            data: seriesExpect
          }
        ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    }
  }
}
</script>