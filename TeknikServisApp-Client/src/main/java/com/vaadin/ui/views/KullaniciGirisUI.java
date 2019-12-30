package com.vaadin.ui.views;

import com.vaadin.MyUI;
import com.vaadin.service.dto.KullaniciDto;
import com.vaadin.service.rest.RestClientKullanici;
import com.vaadin.ui.*;
import com.vaadin.ui.components.LoginButton;

public class KullaniciGirisUI extends VerticalLayout {
    FormLayout formLayout;

    public KullaniciGirisUI() {
        buildFormLayout();
    }

    private void buildFormLayout() {
        MyUI myUI = (MyUI) UI.getCurrent();

        formLayout = new FormLayout();
        addComponent(formLayout);

        TextField kullaniciAdiField = new TextField("Kullanıcı No");
        formLayout.addComponent(kullaniciAdiField);

        PasswordField passwordField = new PasswordField("Şifre");
        formLayout.addComponent(passwordField);

        LoginButton loginButton = new LoginButton();
        loginButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                RestClientKullanici restClientKullanici = new RestClientKullanici();
                try{
                    KullaniciDto kullaniciDto = restClientKullanici.kullaniciyiGetir(kullaniciAdiField.getValue(), passwordField.getValue());
                    myUI.setMyKullanici(kullaniciDto);
                    KullaniciSidebarView kullaniciSidebarView = new KullaniciSidebarView(kullaniciDto);
                    ArizaEkleUI arizaEkleUI = new ArizaEkleUI();
                    myUI.getMyContent().setContent(arizaEkleUI);
                    myUI.getMySideBar().setContent(kullaniciSidebarView);
                }catch (NullPointerException e){
                    Notification.show("Kullanıcı adı veya şifre hatalı!");
                }


            }
        });
        formLayout.addComponent(loginButton);

    }
}
