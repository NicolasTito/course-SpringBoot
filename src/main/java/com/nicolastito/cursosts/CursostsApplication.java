package com.nicolastito.cursosts;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.nicolastito.cursosts.domain.Address;
import com.nicolastito.cursosts.domain.Categoria;
import com.nicolastito.cursosts.domain.City;
import com.nicolastito.cursosts.domain.Client;
import com.nicolastito.cursosts.domain.Order;
import com.nicolastito.cursosts.domain.OrderItem;
import com.nicolastito.cursosts.domain.Payment;
import com.nicolastito.cursosts.domain.PaymentWithBillet;
import com.nicolastito.cursosts.domain.PaymentWithCard;
import com.nicolastito.cursosts.domain.Product;
import com.nicolastito.cursosts.domain.State;
import com.nicolastito.cursosts.domain.enums.StatusPayment;
import com.nicolastito.cursosts.domain.enums.TypeClient;
import com.nicolastito.cursosts.repositories.AddressRepository;
import com.nicolastito.cursosts.repositories.CategoriaRepository;
import com.nicolastito.cursosts.repositories.CityRepository;
import com.nicolastito.cursosts.repositories.ClientRepository;
import com.nicolastito.cursosts.repositories.OrderItemRepository;
import com.nicolastito.cursosts.repositories.OrderRepository;
import com.nicolastito.cursosts.repositories.PaymentRepository;
import com.nicolastito.cursosts.repositories.ProductRepository;
import com.nicolastito.cursosts.repositories.StateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CursostsApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursostsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(1, "Computing");
		Categoria cat2 = new Categoria(2, "Desk");

		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");

		City c1 = new City(null, "Umberlandia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);

		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2, c3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", TypeClient.PESSOAFISICA);

		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

		Address ad1 = new Address(null, "Rua Flores", "300", "apt 303", "Jardim", "38220834", cli1, c1);
		Address ad2 = new Address(null, "Avenida Matos", "105", "sala 800", "Centro", "38777012", cli1, c2);

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Order order1 = new Order(null, sdf.parse("30/09/2020 10:32"), cli1, ad1);
		Order order2 = new Order(null, sdf.parse("10/10/2020 19:35"), cli1, ad2);

		cli1.getOrders().addAll(Arrays.asList(order1, order2));

		Payment pay1 = new PaymentWithCard(null, StatusPayment.QUITADO, order1, 6);
		order1.setPayment(pay1);
		Payment pay2 = new PaymentWithBillet(null, StatusPayment.PENDENTE, order2, sdf.parse("20/10/2020 00:00"), null);
		order2.setPayment(pay2);


		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

		OrderItem oI1 = new OrderItem(order1, p1, 0.00, 1, 2000.00);
		OrderItem oI2 = new OrderItem(order1, p3, 0.00, 2, 80.00);
		OrderItem oI3 = new OrderItem(order2, p2, 100.00, 1, 800.00);

		order1.getItems().addAll(Arrays.asList(oI1, oI2));
		order2.getItems().addAll(Arrays.asList(oI3));

		p1.getItems().addAll(Arrays.asList(oI1));
		p2.getItems().addAll(Arrays.asList(oI3));
		p3.getItems().addAll(Arrays.asList(oI2));

		orderItemRepository.saveAll(Arrays.asList(oI1, oI2, oI3));
	}
}
