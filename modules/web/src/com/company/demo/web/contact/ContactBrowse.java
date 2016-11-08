package com.company.demo.web.contact;

import com.company.demo.entity.Contact;
import com.company.demo.entity.Phone;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Map;
import java.util.Set;

public class ContactBrowse extends AbstractLookup {
    @Inject
    private Table<Contact> contactsTable;
    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        contactsTable.addGeneratedColumn("phones", entity -> {
            Set<Phone> phones = entity.getPhones();
            int phonesCount = phones.size();

            if (phonesCount <= 1) {
                Label label = componentsFactory.createComponent(Label.class);
                if (phonesCount == 1) {
                    Phone phone = phones.iterator().next();
                    String phoneNumber = phone.getCode() + " " + phone.getNumber();
                    label.setValue(phoneNumber);
                } else {
                    label.setValue(getMessage("noPhoneMessage"));
                }
                return label;
            } else {
                VBoxLayout vBox = componentsFactory.createComponent(VBoxLayout.class);
                vBox.add(createPhonesListLabel(entity));

                PopupView popupView = componentsFactory.createComponent(PopupView.class);
                popupView.setMinimizedValue(String.format(getMessage("phonesCountMessage"), phonesCount));
                popupView.setHideOnMouseOut(false);
                popupView.setPopupContent(vBox);
                return popupView;
            }
        });
    }

    private Component createPhonesListLabel(Contact entity) {
        Label content = componentsFactory.createComponent(Label.class);
        content.setHtmlEnabled(true);
        StringBuilder sb = new StringBuilder();
        sb.append("<ul style=\"margin-right: 1em;\">");
        for (Phone phone : entity.getPhones()) {
            sb.append("<li>").append(phone.getInstanceName()).append("</li>");
        }
        sb.append("</ul>");
        content.setValue(sb.toString());
        return content;
    }
}