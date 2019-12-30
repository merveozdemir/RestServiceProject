package com.vaadin.ui.views;

import com.vaadin.MyUI;
import com.vaadin.server.FontAwesome;
import com.vaadin.service.dto.KullaniciDto;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.MenuButton;
import com.vaadin.ui.components.SideBarBaslikLabel;

public class KullaniciSidebarView extends VerticalLayout {
    public KullaniciSidebarView(KullaniciDto kullanici) {
        MyUI myUI = (MyUI) UI.getCurrent();

        SideBarBaslikLabel label = new SideBarBaslikLabel(kullanici.toString());
        addComponent(label);

        setMargin(true);
        setSpacing(true);

        MenuButton arizaEkleButton = new MenuButton(FontAwesome.PLUS_SQUARE, "Arıza Ekle");
        arizaEkleButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                ArizaEkleUI arizaEkleUI = new ArizaEkleUI();
                myUI.getMyContent().setContent(arizaEkleUI);
            }
        });
        addComponent(arizaEkleButton);

        MenuButton arizaTakipButton = new MenuButton(FontAwesome.CAR, "Arıza Takip");
        arizaTakipButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
               ArizaTakipUI arizaTakipUI = new ArizaTakipUI();
               myUI.getMyContent().setContent(arizaTakipUI);
            }
        });
        addComponent(arizaTakipButton);


        MenuButton cikisButton = new MenuButton(FontAwesome.SIGN_OUT, "Çıkış");
        cikisButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                GirisSidebarView girisSidebarView = new GirisSidebarView();
                myUI.getMySideBar().setContent(girisSidebarView);
                myUI.getMyContent().removeAllComponents();
            }
        });
        addComponent(cikisButton);
    }

}
