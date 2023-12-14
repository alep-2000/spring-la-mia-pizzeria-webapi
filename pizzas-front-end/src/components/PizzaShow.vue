<template lang="">
    <div v-if="!pizzaUpdate">
        <h1>
            Pizza: {{ myPizza.nome }}
            <span 
                class="link"
                @click="$emit('closePizza', myPizza != pizza)">
                X
            </span>
        </h1>
        <p>Price: {{ myPizza.prezzo }}</p>
        <span>{{ myPizza.descrizione }}</span>
        <br>
        <br>
        <img :src="myPizza.foto" alt="pizza image" >
        <br>
        <button 
            @click="pizzaUpdate = true"
        >UPDATE</button>
        <br><br>
        <!-- <button 
            @click="deletePizza(myPizza.id)"
        >DELETE</button> -->
    </div>
    <pizza-form 
        v-else
        :oldPizza="pizza"
        @back="pizzaUpdate = false"
        @created="updatedPizza"
    />
</template>

<script setup>
// IMPORT LIBS
import { ref } from 'vue';


// IMPORT COMPONENTS
import PizzaForm from './PizzaForm.vue';

// PROPS
const props = defineProps({
    pizza: {
        type: Object,
        required: true
    }
});

// EMITS
const emits = defineEmits(["closePizza"]);

// DATA
const pizzaUpdate = ref(false);
const myPizza = ref(props.pizza);

//FUNCTIONS
const updatedPizza = (newPizza) => {
    pizzaUpdate.value = false;
    myPizza.value = newPizza;
}
</script>

<style scoped>
    .link {
    cursor: pointer;
    text-decoration: underline;
}
</style>