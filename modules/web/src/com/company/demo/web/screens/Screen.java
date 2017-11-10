package com.company.demo.web.screens;

import com.company.demo.web.toolkit.ui.TextFieldExtension;
import com.company.demo.web.toolkit.ui.TextFieldJSExtension;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Inject;
import java.util.Map;

public class Screen extends AbstractWindow {
    @Inject
    private TextField textField1;
    @Inject
    private TextField textField2;

    private TextFieldExtension textFieldExtension;
    private TextFieldJSExtension textFieldJSExtension;

    @Override
    public void init(Map<String, Object> params) {
        textFieldExtension = TextFieldExtension.addTo(textField1.unwrap(com.vaadin.ui.TextField.class));
        textFieldJSExtension = TextFieldJSExtension.addTo(textField2.unwrap(com.vaadin.ui.TextField.class));
    }

    public void showSelectedText1() {
        showNotification("Selected Text: '" + textFieldExtension.getSelectedText() + "'");
    }

    public void showSelectedText2() {
        showNotification("Selected Text: '" + textFieldJSExtension.getSelectedText() + "'");
    }
}