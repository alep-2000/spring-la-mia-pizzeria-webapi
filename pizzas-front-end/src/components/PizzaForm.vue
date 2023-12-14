<template lang="">
    <form @submit.prevent="submit">
        <label for="nome">Nome</label>
        <input type="text" nome="nome" id="nome" v-model="newPizza.nome">
        <br>
        <label for="descrizione">Descrizione</label>
        <input type="text" name="descrizione" id="descrizione" v-model="newPizza.descrizione">
        <br>
        <label for="foto">Foto</label>
        <input type="text" name="foto" id="foto" v-model="newPizza.foto">
        <br>
        <label for="prezzo">Prezzo</label>
        <input type="number" name="prezzo" id="prezzo" v-model="newPizza.prezzo">
        <br>
        <button type="submit">
            {{ props.oldPizza == null ? "Create" : "Update" }}
        </button>
        <button 
            type="button" 
            @click="$emit('back')">
            Back
        </button>
    </form>
</template>

<script setup>
    // IMPORT LIBS
    import { defineEmits, ref } from 'vue';
    import axios from 'axios';

    
    // PROPS
    const props = defineProps({
        oldPizza: {
            type: Object,
            required: false,
            default: null
        }
    });

    // DATA
    const newPizza = ref({
        nome: "",
        descrizione: "",
        foto: "",
        prezzo: ""
    });
    if (props.oldPizza != null) {

        newPizza.value = {
            nome: props.oldPizza.nome,
            descrizione: props.oldPizza.descrizione,
            foto: props.oldPizza.foto,
            prezzo: props.oldPizza.prezzo
        };
    }

    // EMITS
    const emits = defineEmits(["back", "created"]);

    // FUNCTIONS
    const submit = async () => {
        if (props.oldPizza == null) {
        
            const data = await axios.post(
                "http://localhost:8080/api/p1.0/pizzas", 
                newPizza.value
            );

            console.log("data", data);

            emits("created");

            return;
        } 

        const data = await axios.put(
            `http://localhost:8080/api/p1.0/pizzas/${props.oldPizza.id}`, 
            newPizza.value
        );

        console.log("data", data);

        emits("created", newPizza.value);
    }
</script>

<style scoped>
    
</style>