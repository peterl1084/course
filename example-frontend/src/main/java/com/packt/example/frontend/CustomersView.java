package com.packt.example.frontend;

import com.packt.service.CustomerDTO;
import com.vaadin.data.Binder;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class CustomersView extends FormLayout implements View {

	private TextField firstName;
	private TextField lastName;
	private DateField birthDate;

	private CustomerDTO customerDto;

	private Binder<CustomerDTO> binder;

	public CustomersView() {
		firstName = new TextField("First name");
		lastName = new TextField("Last name");
		birthDate = new DateField("Birth date");

		customerDto = new CustomerDTO();
		customerDto.setFirstName("Peter");
		customerDto.setLastName("Lehto");
		addComponents(firstName, lastName, birthDate);

		binder = new Binder<>();

		binder.forField(firstName).bind(CustomerDTO::getFirstName,
				CustomerDTO::setFirstName);
		binder.forField(lastName).bind(CustomerDTO::getLastName,
				CustomerDTO::setLastName);
		binder.forField(birthDate).bind(CustomerDTO::getBirthDate,
				CustomerDTO::setBirthDate);

		binder.setBean(customerDto);
	}
}
