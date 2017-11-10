package com.company.demo.web.toolkit.ui.client.textfield;

import com.company.demo.web.toolkit.ui.TextFieldExtension;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.VTextField;
import com.vaadin.shared.ui.Connect;

/**
 * @author glebfox
 */
@Connect(value = TextFieldExtension.class, loadStyle = Connect.LoadStyle.LAZY)
public class TextFieldExtensionConnector extends AbstractExtensionConnector {

    @Override
    protected void extend(ServerConnector target) {
        final VTextField textField = (VTextField) ((ComponentConnector) target).getWidget();

        textField.addMouseUpHandler(event ->
                getRpcProxy(TextFieldExtensionServerRpc.class)
                        .onTextSelectionChanged(textField.getSelectedText()));

        textField.addKeyUpHandler(event ->
                getRpcProxy(TextFieldExtensionServerRpc.class)
                        .onTextSelectionChanged(textField.getSelectedText()));
    }
}
