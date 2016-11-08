-- begin DEMO_PHONE
alter table DEMO_PHONE add constraint FK_DEMO_PHONE_CONTACT foreign key (CONTACT_ID) references DEMO_CONTACT(ID)^
create index IDX_DEMO_PHONE_CONTACT on DEMO_PHONE (CONTACT_ID)^
-- end DEMO_PHONE
