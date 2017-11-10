window.com_company_demo_web_toolkit_ui_TextFieldJSExtension = function() {
    var connector = this;
    var input = $(this.getElement(connector.getParentId()));
    input.on('keyup mouseup', function(event) {
        var target = event.target;
        var value = target.value;
        var selectedText = '';
        if (value) {
            selectedText = value.substring(target.selectionStart, target.selectionEnd);
        }
        connector.onTextSelectionChanged(selectedText);
    });
}