package com.company.demo.web.toolkit.ui;

import com.company.demo.web.toolkit.ui.client.textfield.TextFieldExtensionServerRpc;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.TextField;

/**
 * @author glebfox
 */
public class TextFieldExtension extends AbstractExtension {

    private String selectedText;

    protected TextFieldExtension(TextField textField) {
        extend(textField);
        selectedText = "";

        registerRpc((TextFieldExtensionServerRpc) selectedText ->
                TextFieldExtension.this.selectedText = selectedText);
    }

    public static TextFieldExtension addTo(TextField textField) {
        return new TextFieldExtension(textField);
    }

    /**
     * Gets the text currently selected within extended text field.
     *
     * @return the selected text, or an empty string if none is selected
     **/
    public String getSelectedText() {
        return selectedText;
    }


}
