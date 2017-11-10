package com.company.demo.web.toolkit.ui;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.TextField;

/**
 * @author glebfox
 */
@JavaScript("components/textfield/textfield-connector.js")
public class TextFieldJSExtension extends AbstractJavaScriptExtension {

    private String selectedText;

    protected TextFieldJSExtension(TextField textField) {
        extend(textField);
        selectedText = "";

        addFunction("onTextSelectionChanged", (JavaScriptFunction) arguments ->
                TextFieldJSExtension.this.selectedText = arguments.getString(0));
    }

    public static TextFieldJSExtension addTo(TextField textField) {
        return new TextFieldJSExtension(textField);
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
