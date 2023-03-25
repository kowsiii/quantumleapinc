<template>
  <div class="split left">

                <div class="widget-cate">Basic Components</div>
                <draggable tag="ul" :list="basicComponents" 
                  v-bind="{group:{ name:'people', pull:'clone',put:false},sort:false, ghostClass: 'ghost'}"
                  @end="handleMoveEnd"
                  @start="handleMoveStart"
                  :move="handleMove"
                >
                  <template v-for="(item, index) in basicComponents">
                    <li v-if="basicFields.indexOf(item.type)>=0" class="form-edit-widget-label" :class="{'no-put': item.type == 'divider'}" :key="index">
                      <a>
                        <i class="icon iconfont" :class="item.icon"></i>
                        <span>{{item.name}}</span>
                      </a>
                    </li>
                  </template>                
                </draggable>        


  </div>
  <div class="split right"></div>
</template>

<script>
import {basicComponents, layoutComponents, advanceComponents} from '../components/componentsConfig.js';
import draggable from 'vuedraggable';
export default {
  name: 'FormBuilder',
  methods: {
    handleHome () {
      this.$router.push({path: '/'})
    },
    handleLangCommand (command) {
      this.$router.replace({name: this.$route.name, params: {lang: command}})
    }
  }
}
</script>

<style lang="scss">
.split {
  height: 100%;
  position: fixed;
  top: 0;
  overflow-x: hidden;
}

/* Control the left side */
.left {
  left: 0;
  width: 30%;
  background-color: lightgray;
}

/* Control the right side */
.right {
  right: 0;
  width: 70%;

}





.fm-header{
  height: 50px;
  box-shadow: 0 2px 10px rgba(70,160,252, 0.6);
  padding: 0 10px;
  background-image: linear-gradient(to right,#1278f6,#00b4aa);
  position: relative;
  .fm-logo{
    height: 26px;
    vertical-align: middle;
  }
  .fm-title{
    display: inline-block;
    line-height: 50px;
    vertical-align: middle;
    color: #fff;
    font-size: 20px;
    font-weight: 600;
    opacity: 0.8;
    margin-left: 6px;
    cursor: pointer;
  }
  .fm-link{
    height: 50px;
    float: right;
    
    a{
      color: #fff;
      text-decoration: none;
      font-size: 14px;
      line-height: 50px;
      font-weight: 500;
      margin-left: 15px;
      
      &:hover{
        opacity: 0.8;
      }
      &.ad{
        color: #f5dab1;
      }
    }
    .action-item{
      display: inline-block;
      margin-left: 15px;
      .el-dropdown{
        // font-size: 16px;
        // font-weight: 500;
      }
      .el-dropdown-link{
        cursor: pointer;
        color: #fff;
        &:hover{
          opacity: 0.8;
        }
      }
      &.action-item-user{
        .el-dropdown-link{
          color: #f5dab1;
        }
      }
    }
  }
}
.fm-container{
  height: calc(100% - 50px);
}
*, :after, :before {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
html,body{
  height: 100%;
}
#app {
  font-family: "Source Sans Pro", "Helvetica Neue", Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  min-height: 100%;
  height: 100%;
}
</style>
