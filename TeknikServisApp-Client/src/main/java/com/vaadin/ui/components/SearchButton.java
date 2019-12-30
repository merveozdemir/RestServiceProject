package com.vaadin.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;

public class SearchButton extends Button {

    public SearchButton(String caption) {
        setIcon(FontAwesome.SEARCH);
        setCaption(caption);
    }
}
