package modular.design.studio;

public interface AbstractUIFactory {
    UIComponent createButton();
    UIComponent createTextbox();
    UIComponent createDropdown();
}