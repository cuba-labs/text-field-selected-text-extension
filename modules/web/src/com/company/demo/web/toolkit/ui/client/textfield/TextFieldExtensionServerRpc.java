package com.company.demo.web.toolkit.ui.client.textfield;

import com.vaadin.shared.communication.ServerRpc;

/**
 * @author glebfox
 */
public interface TextFieldExtensionServerRpc extends ServerRpc {
    void onTextSelectionChanged(String selectedText);
}
