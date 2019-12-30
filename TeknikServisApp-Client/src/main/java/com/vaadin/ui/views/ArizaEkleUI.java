package com.vaadin.ui.views;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.service.dto.ArizaDto;
import com.vaadin.service.dto.enums.EnumArizaDurum;
import com.vaadin.service.rest.RestClientAriza;
import com.vaadin.ui.*;
import com.vaadin.ui.components.SaveButton;
import com.vaadin.ui.components.StTextField;

public class ArizaEkleUI extends HorizontalLayout {
    FormLayout formLayout;
    VerticalLayout filtreLayout;
    VerticalLayout tableOperationLayout;
    Table myTable;
    IndexedContainer indexedContainer;
    FormLayout islemLayout;

    StTextField idField;
    StTextField musteriAdiField;
    StTextField musteriSoyadiField;
    StTextField musteriIdField;
    DateField arizaKayitTarihiField;
    ComboBox arizaDurumuComboBox;
    SaveButton saveArizaButton;
    TextArea arizaIcerikField;

    public ArizaEkleUI() {
        buildFormLayout();
    }

    private void buildFormLayout() {
        formLayout = new FormLayout();
        formLayout.setMargin(true);
        addComponent(formLayout);

        Label arizaEkleLabel = new Label("Arıza Ekle");
        formLayout.addComponent(arizaEkleLabel);

        idField = new StTextField("Arıza No");
        idField.setEnabled(false);
        formLayout.addComponent(idField);

        musteriIdField = new StTextField("Müşteri Tc No");
        formLayout.addComponent(musteriIdField);

        musteriAdiField = new StTextField("Müşteri Adı");
        formLayout.addComponent(musteriAdiField);

        musteriSoyadiField = new StTextField("Müşteri Soyadı");
        formLayout.addComponent(musteriSoyadiField);

        arizaKayitTarihiField = new DateField("Kayıt Tarihi");
        formLayout.addComponent(arizaKayitTarihiField);

        arizaIcerikField = new TextArea("İçerik");
        formLayout.addComponent(arizaIcerikField);

        arizaDurumuComboBox = new ComboBox("Arıza Durumu");
        fillComboBoxwithEnumArizaDurum();
        formLayout.addComponent(arizaDurumuComboBox);

        saveArizaButton = new SaveButton();
        saveArizaButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                saveView();
            }
        });
        formLayout.addComponent(saveArizaButton);
    }

    private void saveView() {
        ArizaDto arizaDto = new ArizaDto();
        arizaDto.setMusteriAdi(musteriAdiField.getValue());
        arizaDto.setMusteriSoyadi(musteriSoyadiField.getValue());
        arizaDto.setMusteriTcNo(musteriIdField.getValue());
        arizaDto.setArizaKayitTarihi(arizaKayitTarihiField.getValue());
        arizaDto.setArizaIcerik(arizaIcerikField.getValue());
        arizaDto.setEnumArizaDurum((EnumArizaDurum) arizaDurumuComboBox.getValue());

        RestClientAriza restClientAriza = new RestClientAriza();
        arizaDto = restClientAriza.arizaKaydet(arizaDto);

        Notification.show("Arıza Kaydedildi");

    }

    private void fillComboBoxwithEnumArizaDurum() {
        for (EnumArizaDurum value : EnumArizaDurum.values()) {
            arizaDurumuComboBox.addItem(value);
        }

    }


}
