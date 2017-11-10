package com.company.demo.web.screens;

import com.company.demo.web.toolkit.ui.TextFieldExtension;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Inject;
import java.util.Map;

public class Screen extends AbstractWindow {
    @Inject
    private TextField textField;

    private TextFieldExtension textFieldExtension;

    @Override
    public void init(Map<String, Object> params) {
        textFieldExtension = TextFieldExtension.addTo(textField.unwrap(com.vaadin.ui.TextField.class));
    }

    public void showSelectedText() {
        showNotification("Selected Text: '" + textFieldExtension.getSelectedText() + "'");
    }
}