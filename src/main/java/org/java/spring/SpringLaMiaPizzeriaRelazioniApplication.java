package org.java.spring;

import java.time.LocalDate;
import java.util.List;

import org.java.spring.auth.conf.AuthConf;
import org.java.spring.auth.db.Role;
import org.java.spring.auth.db.User;
import org.java.spring.auth.service.RoleService;
import org.java.spring.auth.service.UserService;
import org.java.spring.db.pojo.Ingrediente;
import org.java.spring.db.pojo.OffertaSpeciale;
import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.IngredienteService;
import org.java.spring.db.service.OffertaSpecialeService;
import org.java.spring.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaRelazioniApplication implements CommandLineRunner{

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private OffertaSpecialeService offertaSpecialeService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaRelazioniApplication.class, args);
		
	}


	@Override
	public void run(String... args) throws Exception {
	
		
		Ingrediente in1 = new Ingrediente("Peperoni");
		Ingrediente in2 = new Ingrediente("Polpette");
		Ingrediente in3 = new Ingrediente("Patatine");
		
		ingredienteService.save(in1);
		ingredienteService.save(in2);
		ingredienteService.save(in3);
		
		pizzaService.save(new Pizza("Margherita", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200", 6.99, in1));
		pizzaService.save(new Pizza("Marinara", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 8));
		pizzaService.save(new Pizza("Bufala", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 18));
		pizzaService.save(new Pizza("Funghi", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 15.50));
		pizzaService.save(new Pizza("Salsiccia", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 6.30));
		pizzaService.save(new Pizza("Capricciosa", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 10.50));
		pizzaService.save(new Pizza("Carbonara", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 22.80));
		pizzaService.save(new Pizza("4 Formaggi", "Una buona pizza con ingredienti freschi", "https://picsum.photos/200/300", 10.50));
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		offertaSpecialeService.save(new OffertaSpeciale(LocalDate.now().minusDays(9), LocalDate.of(2023, 12, 8), "Margherita gratis", pizzas.get(0)));
		offertaSpecialeService.save(new OffertaSpeciale(LocalDate.now().minusDays(50), LocalDate.of(2023, 12, 9), "Marinara x2", pizzas.get(1)));
		offertaSpecialeService.save(new OffertaSpeciale(LocalDate.now().minusDays(1), LocalDate.of(2023, 12, 15), "Bufala gigante", pizzas.get(2)));
		offertaSpecialeService.save(new OffertaSpeciale(LocalDate.now().minusDays(12), LocalDate.of(2023, 12, 18), "Funghi in omaggio", pizzas.get(3)));
		offertaSpecialeService.save(new OffertaSpeciale(LocalDate.now().minusDays(4), LocalDate.of(2023, 12, 28), "Salsiccia extra", pizzas.get(4)));
		offertaSpecialeService.save(new OffertaSpeciale(LocalDate.now().minusDays(5), LocalDate.of(2023, 12, 16), "Capricciosa x3", pizzas.get(5)));
		offertaSpecialeService.save(new OffertaSpeciale(LocalDate.now().minusDays(16), LocalDate.of(2023, 12, 31), "Carbonara x4", pizzas.get(6)));
		offertaSpecialeService.save(new OffertaSpeciale(LocalDate.now().minusDays(8), LocalDate.of(2023, 12, 2), "4 formaggi a scelta", pizzas.get(7)));
		
		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");
		roleService.save(roleUser);
		roleService.save(roleAdmin);
		
		String pws = AuthConf.passwordEncoder().encode("pws");
		
		User DioUser = new User("DioUser", pws, roleUser);
		User GiuseppeAdmin = new User("GiuseppeAdmin", pws, roleAdmin);
		
		userService.save(DioUser);
		userService.save(GiuseppeAdmin);
	}
}
