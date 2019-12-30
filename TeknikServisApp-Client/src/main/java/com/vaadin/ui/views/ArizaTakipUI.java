package com.vaadin.ui.views;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.service.dto.ArizaDto;
import com.vaadin.service.dto.enums.EnumArizaDurum;
import com.vaadin.service.rest.RestClientAriza;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.*;
import com.vaadin.ui.components.SaveButton;
import com.vaadin.ui.components.SearchButton;
import com.vaadin.ui.components.StTextField;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArizaTakipUI extends HorizontalLayout {
    VerticalLayout tableOperationLayout;
    FormLayout islemLayout;

    Table myTable;
    IndexedContainer indexedContainer;
    ArizaDto selectedArizaDto;

    TextArea aciklamaField;
    SaveButton saveAciklamaEkleButton;


    public ArizaTakipUI() {
        buildTableLayout();
        buildIslemLayout();
    }

    private void buildIslemLayout() {
        islemLayout = new FormLayout();
        addComponent(islemLayout);

        addFiltreComponents();

        addArizaAciklamaEkleComponents();

    }

    private void addArizaAciklamaEkleComponents() {
        Label filtreLabel = new Label("Açıklama Ekle");
        islemLayout.addComponent(filtreLabel);

        aciklamaField = new TextArea();
        aciklamaField.setNullRepresentation("");
        islemLayout.addComponents(aciklamaField);

        saveAciklamaEkleButton = new SaveButton();
        saveAciklamaEkleButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                selectedArizaDto.setArizaAciklama(aciklamaField.getValue());

                RestClientAriza restClientAriza = new RestClientAriza();
                restClientAriza.arizaKaydet(selectedArizaDto);

                Notification.show("Açıklama kaydedildi");

                List<ArizaDto> allArizaDto = getAllAriza();
                updateTable(allArizaDto);
            }
        });
        saveAciklamaEkleButton.setEnabled(false);
        islemLayout.addComponent(saveAciklamaEkleButton);

    }

    private void buildTableLayout() {
        tableOperationLayout = new VerticalLayout();
        tableOperationLayout.setSpacing(true);
        tableOperationLayout.setMargin(true);
        addComponent(tableOperationLayout);

        Label tableLabel = new Label("Tüm Arızalar");
        tableOperationLayout.addComponent(tableLabel);

        buildTableContainer();
        buildTable();

        List<ArizaDto> arizaDtoList = getAllAriza();
        fillTable(arizaDtoList);
        tableOperationLayout.addComponents(myTable);
    }

    private List<ArizaDto> getAllAriza() {
        RestClientAriza restClientAriza = new RestClientAriza();
        return restClientAriza.tumArizaListele();
    }

    private void addFiltreComponents() {
        Label filtreLabel = new Label("Müşteri Ara");
        islemLayout.addComponent(filtreLabel);

        StTextField filtreField = new StTextField();
        islemLayout.addComponent(filtreField);

        SearchButton searchButtonName = new SearchButton("Ada Göre Ara");
        searchButtonName.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                String isim = filtreField.getValue();

                RestClientAriza restClientAriza = new RestClientAriza();
                List<ArizaDto> arizaDtoList = restClientAriza.adaGoreListele(isim);

                updateTable(arizaDtoList);

            }
        });
        islemLayout.addComponent(searchButtonName);

        SearchButton searchButtonId = new SearchButton("Tc No'ya Göre Ara");
        searchButtonId.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                String tcNo = filtreField.getValue();

                RestClientAriza restClientAriza = new RestClientAriza();
                List<ArizaDto> arizaDtoList = restClientAriza.tcNoyaGoreListele(tcNo);

                updateTable(arizaDtoList);
            }
        });
        islemLayout.addComponent(searchButtonId);

        SearchButton tumArizaGoruntule = new SearchButton("Tüm arızaları listele");
        tumArizaGoruntule.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                List<ArizaDto> allAriza = getAllAriza();
                updateTable(allAriza);
            }
        });
        islemLayout.addComponent(tumArizaGoruntule);

    }
    private void buildTableContainer() {
        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("musteriAdi", String.class, null);
        indexedContainer.addContainerProperty("musteriSoyadi", String.class, null);
        indexedContainer.addContainerProperty("musteriTcNo", String.class, null);
        indexedContainer.addContainerProperty("arizaIcerik", String.class, null);
        indexedContainer.addContainerProperty("arizaKayitTarihi", Date.class, null);
        indexedContainer.addContainerProperty("enumArizaDurum", EnumArizaDurum.class, null);
        indexedContainer.addContainerProperty("arizaAciklama", String.class, null);

    }
    private void fillTable(List<ArizaDto> arizaDtoList) {

        for (ArizaDto arizaDto : arizaDtoList) {
            Item item = indexedContainer.addItem(arizaDto);
            item.getItemProperty("id").setValue(arizaDto.getId());
            item.getItemProperty("musteriAdi").setValue(arizaDto.getMusteriAdi());
            item.getItemProperty("musteriSoyadi").setValue(arizaDto.getMusteriSoyadi());
            item.getItemProperty("musteriTcNo").setValue(arizaDto.getMusteriTcNo());
            item.getItemProperty("arizaIcerik").setValue(arizaDto.getArizaIcerik());
            item.getItemProperty("arizaKayitTarihi").setValue(arizaDto.getArizaKayitTarihi());
            item.getItemProperty("enumArizaDurum").setValue(arizaDto.getEnumArizaDurum());
            item.getItemProperty("arizaAciklama").setValue(arizaDto.getArizaAciklama());
        }
    }

    private void buildTable() {
        myTable = new Table();
        myTable.setHeight("400px");
        myTable.setWidth("650px");
        myTable.setContainerDataSource(indexedContainer);
        myTable.setSelectable(true);
        myTable.setMultiSelectMode(MultiSelectMode.SIMPLE);
        myTable.setMultiSelect(false);
        myTable.setColumnHeaders("NO", "Müşteri Adi", "Müşteri Soyadi",
                "Müşteri Tc No", "Arıza İçerik", "Kayıt Tarihi",
                "Arıza Durum", "Arıza açıklama");
        myTable.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                selectedArizaDto = (ArizaDto) itemClickEvent.getItemId();

                saveAciklamaEkleButton.setEnabled(true);
                aciklamaField.setValue(selectedArizaDto.getArizaAciklama());

            }
        });
    }

    private void updateTable(List<ArizaDto> allArizaDto) {
        indexedContainer.removeAllItems();
        fillTable(allArizaDto);
    }



}
