package com.packt.example.frontend;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class CustomersView extends VerticalLayout implements View {

	public CustomersView() {

	}

	@Override
	public void enter(ViewChangeEvent event) {
		Label label = new Label("Customers");
		addComponent(label);
	}
}
