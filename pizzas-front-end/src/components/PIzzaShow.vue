<template lang="">
    <div>
        <h1>
            Pizza: {{ myPizza.name }}
            <span 
                class="link"
                @click="$emit('closePizza', myPizza != pizza)">
                X
            </span>
        </h1>
        <p>Price: {{ myPizza.prezzo }}</p>
        <span>{{ myPizza.descrizione }}</span>
        <br>
        <img :src="myPizza.foto" alt="pizza image" >
    </div>
</template>
<script setup>
// IMPORT LIBS
import { ref } from 'vue';


// PROPS
const props = defineProps({
    pizza: {
        type: Object,
        required: true
    }
});

// EMITS
const emits = defineEmits(["closePizza"]);


const myPizza = ref(props.pizza);
</script>
<style scoped>
    .link {
    cursor: pointer;
    text-decoration: underline;
}
</style>