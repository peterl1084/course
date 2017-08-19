package com.packt.example.frontend;

import com.packt.service.CustomerDTO;
import com.vaadin.data.Binder;
import com.vaadin.data.Converter;
import com.vaadin.data.Result;
import com.vaadin.data.ValueContext;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.navigator.View;
import com.vaadin.server.SerializableFunction;
import com.vaadin.server.SerializableSupplier;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
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
		binder.forField(birthDate).bind(CustomerDTO::getBirthDate,
				CustomerDTO::setBirthDate);
		binder.forField(yearOfBirth)
				.withConverter(Integer::valueOf, String::valueOf,
						"Error converting")
				.bind(CustomerDTO::getYearOfBirth, CustomerDTO::setYearOfBirth);

		binder.setBean(customerDto);
	}

	private static class IntegerToStringConverter
			implements Converter<String, Integer> {

		@Override
		public Result<Integer> convertToModel(String value,
				ValueContext context) {
			return Result.of(new SerializableSupplier<Integer>() {

				@Override
				public Integer get() {
					return Integer.valueOf(value);
				}
			}, new SerializableFunction<Exception, String>() {

				@Override
				public String apply(Exception t) {
					return "Error while converting: " + value;
				}
			});
		}

		@Override
		public String convertToPresentation(Integer value,
				ValueContext context) {
			if (value == null) {
				return "";
			}

			return value.toString();
		}

	}
}
