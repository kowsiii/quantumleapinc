<template>
    <div ref="el" >
        <NodeHeader  title="Form"/>
        <el-select v-model="method" placeholder="Select" @change="updateSelect" size="small" df-method>
        <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
        >
        </el-option>
    </el-select>
    <br><br>
        <el-input v-model="url" df-url placeholder="Please input" size="small">
        <template #prepend>https://</template>
        </el-input>
        <el-button ></el-button>
    </div>
</template>

<script>
import { defineComponent, onMounted, getCurrentInstance, readonly, ref, nextTick } from 'vue'
import NodeHeader from './NodeHeader.vue'

export default defineComponent({
    components: {
        NodeHeader
    },
    setup() {
        const el = ref(null);
        const nodeId = ref(0);
        let df = null
        const url = ref('');
        const method = ref('get');
        const dataNode = ref({});
        const options = readonly([
            {
                value: 'get',
                label: 'GET'
            },
            {
                value: 'post',
                label: 'POST'
            }
        ]);
        
        df = getCurrentInstance().appContext.config.globalProperties.$df.value;

        const updateSelect = (value) => {
            dataNode.value.data.method = value;
            df.updateNodeDataFromId(nodeId.value, dataNode.value);
        }
        
        
        onMounted(async () => {
            await nextTick()
            nodeId.value = el.value.parentElement.parentElement.id.slice(5)
            dataNode.value = df.getNodeFromId(nodeId.value)
            
            url.value = dataNode.value.data.url;
            method.value = dataNode.value.data.method;
        });
        
        return {
            el, url, method, options, updateSelect
        }

    }    
    
})
</script>

