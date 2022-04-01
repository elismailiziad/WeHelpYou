





--   populating supplier
insert into supplier
	(supplier_ID,supplier_name,supplier_city,supplier_phone,supplier_country,supplier_address)
	VALUES
	(0001,'Mr.Bricolage','Marrakech','080 203 80 80','Morocco','Lot 15-16 PARC Marjane Avenue Abdelkrim al Khattabi' ),
	(0002,'Bricoma','Marrakech','+212 524 336 700','Morocco','Sidi Ghanem 3 Rte de Safi N 16 Marrakech');

-- populating customer
insert into customer 
    (cus_ID,cus_fname,cus_lname,cus_city,cus_address,cus_discount)
    VALUES
    (10,'Ahmed','Laemiriye','Marrakech','Les Portes de Marrakech I','0.05'),
   (11,'Abdelkime','Rouhi','Marrakech','Avenue Riddani','0.00'),
    (12,'Rachid','Babir','Marrakech','Quartier Masmoudi Targua','0.1');

-- populating cahsier
insert into cashier
    (user_ID,user_password,user_fname,user_lname,user_email,user_phone,salary)
    VALUES
    (9001,'PASS001','Ahmed','Salama','SalamaAhmed@gmail.com','06 234 432 01',3500),
    (9002,'PASS002','Zakaria','Rami','RamiZakaria@gmail.com','06 112 708 12',3500);

-- populating manager
    insert into manager
        (user_ID,user_password,user_fname,user_lname,user_email,user_phone)
        VALUES
        (1001,'ADMIN','Abdesselam','Rachda','RachdaAbdesselam@Yahoo.com','06 357 388 94');

 -- populating item 
INSERT INTO Item (item_Code, description, in_date, qoh,  discount_rate, price) VALUES

 ('35332', 'PINCE A SERTIR MECANIQUE', '2020-03-09',   75,  0.25, 2500.00),
 ('36260', 'CLE A CLIQUET JUNIOR', '2020-06-10', 60 , 0.00, 116.00),
 ('36255', 'CLE A MOLETTE 102361', '2020-02-18', 45, 0.1, 55.00),
 ('49443', 'CLE MIXTE 122005', '2020-02-18', 100,  0.00, 24.00),
 ('49444', 'CLE MIXTE 122006', '2020-02-18', 100,  0.00, 24.00),
 ('49445', 'CLE MIXTE 122007', '2020-02-18', 100,  0.00, 26.00),
 ('49446', 'CLE MIXTE 122008', '2020-02-18', 100,  0.00, 27.00), 
 ('98490', 'CLE EN CROIX POUR VOITURE 102280', '2020-11-05', 20,  0.00, 82.00), 
 ('38771', 'JEU DE 4 PINCES 100120', '2020-11-07', 15,  0.20, 230.00), 
 ('106522', 'LAME TRAPEZE 113016', '2020-12-04', 18,  0.00, 150.00), 
 ('57652', 'COMPRESSEUR 200L MONOPHASE 230V-50HZ', '2020-04-09', 7,  0.20, 7419.00), 
 ('94863', 'COMPRESSEUR A AIR CROWN 2HP 100L', '2020-04-09', 7,  0.20, 4339.00), 
 ('94369', 'COMPRESSEUR 2.0HP 195L/MIN 24L.25L', '2020-04-09', 7,  0.20, 1575.00),
 ('57654', 'KIT BOX POUR COMPRESSEUR 8PCS STANLEY', '2020-04-20', 20,  0.04, 338.00),
 ('103223', 'PISTOLET DE PEINTURE ELE 1200W/230V CROWN', '2020-04-10', 13,  0.00, 1250.00), 
 ('104572', 'PISTOLET A COLLE 40W/220V', '2020-09-17', 26,  0.00, 170.00), 
 ('102418', 'BATONNET DE COLLE DREMEL GG01', '2020-11-06', 100,  0.00, 39.00),
 ('94802', 'COMPRESEUR A COURROIE SUR CHARIOT ', '2020-12-02', 20,  0.20, 11099.00), 
 ('100282', 'BARRE DOUCHE DOUBLE CARRE', '2020-12-10', 13,  0.00, 550.00), 
 ('1011', 'KIT DOUCHE BARRE AQUAFRECH CHROME', '2020-10-17', 9,  0.10, 495.00),  
 ('100235', 'ELITE BARRE DE DOUCHE AVEC DISTRIBUTEURS 3 JETS', '2020-02-08', 8,  0.00, 249.00), 
 ('109680', 'COLONNE DOUCHE BARCELONA', '2020-02-08', 8,  0.15, 480.00), 
 ('105468', 'CABINE DE DOUCHE D ANGLE AVEC RECEVEUR', '2020-07-10', 4,  0.00, 1615.00), 
 ('37763', 'LAVABO URBI 2', '2020-05-15', 8,  0.10, 1075.00);
