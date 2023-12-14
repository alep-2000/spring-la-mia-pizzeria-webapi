<script setup>
  // IMPORT LIBS
  import { onMounted, ref } from 'vue';
  import axios from 'axios';

  // IMPORT COMPONENTS
  import PizzaIndex from './components/PizzaIndex.vue';
  import PizzaShow from './components/PizzaShow.vue';

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
  const closePizza = (update) => {
  pizzaActive.value = null;
  if (update) updatePizzas();
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
      v-if="pizzaActive == null"
      :pizzas="pizzas" 
      @open-pizza="openPizza"
    />
    <pizza-show 
        v-else
        :pizza="pizzaActive"
        @close-pizza="closePizza"
      />
  </div>
</template>
