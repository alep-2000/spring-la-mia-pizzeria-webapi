<script setup>
  // IMPORT LIBS
  import { onMounted, ref } from 'vue';
  import axios from 'axios';

  // IMPORT COMPONENTS
  import PizzaIndex from './components/PizzaIndex.vue';

  // DATA
  const pizzas = ref(null);
  const pizzaActive = ref(null);

  // FUNCTIONS
  const openPizza = (id) => {
    pizzas.value.forEach((pizza) => {
      if (pizza.id === id) {
        pizzaActive.value = pizza;
      }
    });
  };

  const updatePizzas = async () => {
    const data = await axios.get("http://localhost:8080/api/p1.0/pizzas");
    pizzas.value = data.data;
  };

  // HOOKS
  onMounted(updatePizzas);
</script>

<template>
  <h1>Pizze</h1>
  <div>
    <pizza-index 
      :pizzas="pizzas" 
      @open-pizza="openPizza"
    />
  </div>
  
</template>
