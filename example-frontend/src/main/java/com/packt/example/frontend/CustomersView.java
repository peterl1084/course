package com.packt.example.frontend;

import com.packt.service.CustomerDTO;
import com.vaadin.data.Binder;
import com.vaadin.data.BinderValidationStatus;
import com.vaadin.data.BindingValidationStatus;
import com.vaadin.data.Converter;
import com.vaadin.data.Result;
import com.vaadin.data.ValueContext;
import com.vaadin.data.converter.StringToBigDecimalConverter;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class CustomersView extends FormLayout implements View {

	private TextField firstName;
	private TextField lastName;
	private TextField yearOfBirth;
	private DateField birthDate;

	private CustomerDTO customerDto;

	private Binder<CustomerDTO> binder;

	public CustomersView() {
		firstName = new TextField("First name");
		lastName = new TextField("Last name");
		yearOfBirth = new TextField("Year of birth");
		birthDate = new DateField("Birth date");

		customerDto = new CustomerDTO();
		customerDto.setFirstName("Peter");
		customerDto.setLastName("Lehto");
		addComponents(firstName, lastName, yearOfBirth, birthDate);

		binder = new Binder<>();

		binder.forField(firstName).bind(CustomerDTO::getFirstName,
				CustomerDTO::setFirstName);
		binder.forField(lastName).bind(CustomerDTO::getLastName,
				CustomerDTO::setLastName);

		binder.forField(yearOfBirth)
				.withConverter(Integer::valueOf, String::valueOf)
				.withValidator(new IntegerRangeValidator("error", 2000, 2010))
				.withValidationStatusHandler(
						status -> onValidationStatusChange(status))
				.bind(CustomerDTO::getYearOfBirth, CustomerDTO::setYearOfBirth);

		binder.forField(birthDate).bind(CustomerDTO::getBirthDate,
				CustomerDTO::setBirthDate);

		binder.setBean(customerDto);
	}

	private void onValidationStatusChange(BindingValidationStatus<?> status) {
		status.getResult().ifPresent(result -> {
			if (result.isError()) {
				Notification.show(
						"Error in year of birth: " + result.getErrorMessage());
			}
		});
	}
}
