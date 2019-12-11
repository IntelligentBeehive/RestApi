#
# TABLE STRUCTURE FOR: pollen
#

DROP TABLE IF EXISTS `pollen`;

CREATE TABLE `pollen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plant_name` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `hex` varchar(8) COLLATE latin1_german1_ci NOT NULL,
  `rgb` varchar(15) COLLATE latin1_german1_ci NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('facere', '#362b66', '42,186,211', '2000-11-01 22:51:24');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('qui', '#ae9b50', '40,168,138', '2011-07-16 22:37:27');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('qui', '#53e5cd', '149,142,155', '2012-11-11 10:44:21');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('suscipit', '#3e6d88', '133,20,184', '1978-08-02 17:55:31');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('cupiditate', '#41a5b1', '245,152,16', '1983-04-13 10:48:47');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('molestiae', '#cf0181', '23,84,110', '1971-07-04 07:49:18');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('aut', '#6a0ff4', '106,227,7', '2005-04-24 17:19:49');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('ad', '#25269d', '14,177,7', '2009-10-18 14:24:13');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('autem', '#299840', '97,239,22', '1972-11-23 17:56:13');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quos', '#729577', '55,157,235', '2011-12-24 01:11:02');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('ut', '#6a1b16', '128,101,143', '2016-11-05 19:29:53');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('voluptatem', '#ed2287', '211,179,151', '2009-07-02 17:05:04');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('et', '#f0e7a3', '142,90,187', '1996-10-14 00:35:18');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('qui', '#2876ee', '203,141,209', '1972-03-25 00:58:54');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('sit', '#2b2e6f', '12,83,23', '2017-05-06 16:08:24');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('molestiae', '#917407', '72,54,37', '1984-07-22 13:32:40');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quisquam', '#ffdab0', '124,228,189', '2010-12-23 23:45:22');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('temporibus', '#f1b56b', '2,149,0', '2015-07-24 05:15:11');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('dolores', '#ba6b9a', '243,44,85', '1996-11-06 14:24:08');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('sit', '#5bab24', '79,16,167', '1975-11-22 12:53:15');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('optio', '#1c72ed', '209,0,26', '2015-07-03 00:42:33');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('facilis', '#b72dde', '197,105,138', '2016-06-26 13:25:33');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quae', '#cb0767', '23,250,55', '1990-05-14 16:20:48');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('dicta', '#c2d77e', '100,38,202', '1976-03-18 01:46:16');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('nobis', '#73dd42', '233,78,38', '2011-05-24 23:30:08');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('et', '#0eae53', '172,133,112', '1995-05-18 16:39:29');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quos', '#8a5d60', '252,30,158', '1997-11-24 11:12:08');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('numquam', '#388f4e', '100,144,124', '1998-02-14 16:11:44');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('delectus', '#cc0329', '201,16,31', '1988-01-06 03:48:28');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('esse', '#00a2b5', '24,68,228', '1982-02-17 03:45:51');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quis', '#2b3cd5', '144,235,25', '2010-07-16 18:31:39');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('ipsa', '#f64077', '251,131,81', '1974-03-07 10:55:49');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('eveniet', '#a48dea', '22,24,77', '1981-10-31 16:07:40');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('est', '#e6b3ca', '4,231,214', '1983-03-31 05:59:45');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('voluptas', '#7f0b39', '133,168,216', '2002-01-09 16:44:14');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('sequi', '#eb93ec', '69,51,202', '1997-08-09 09:48:51');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('veniam', '#69c85c', '173,106,220', '2011-10-05 05:54:08');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('libero', '#0fed4f', '216,211,254', '2011-01-06 18:59:50');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('possimus', '#c37a53', '36,226,226', '1986-04-16 03:28:03');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quibusdam', '#33bb92', '78,172,165', '2012-10-29 12:21:56');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('aut', '#45f297', '141,31,36', '1988-07-09 07:47:17');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('consequuntur', '#c20789', '105,52,54', '1997-03-18 17:23:58');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('ipsam', '#3ca8cd', '106,80,148', '1972-04-16 17:02:35');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('porro', '#cea672', '94,191,6', '2018-01-27 01:56:50');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('ea', '#1dae14', '92,111,159', '1978-10-04 05:17:38');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('sit', '#d42958', '204,153,65', '1970-09-10 05:37:23');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('illum', '#b737b0', '3,28,96', '1998-06-16 01:41:40');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('et', '#2a45c7', '30,71,68', '2008-07-05 00:03:51');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('asperiores', '#c1f53e', '88,173,194', '1997-08-02 02:20:04');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('eaque', '#d17a56', '94,170,101', '2009-02-11 10:56:16');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('soluta', '#1f5866', '162,125,96', '2009-09-22 19:30:44');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('odit', '#e6aace', '151,129,225', '1985-02-18 12:08:55');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('dicta', '#86fb81', '191,6,217', '2018-05-16 16:36:31');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('nulla', '#14fec5', '78,203,29', '1991-09-01 03:15:08');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('nemo', '#faad13', '195,26,135', '2011-04-01 00:56:42');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('tempora', '#74834f', '138,244,29', '1976-02-08 12:45:29');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('consequuntur', '#de94ae', '109,169,57', '1973-05-26 20:51:38');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('modi', '#5c77c2', '148,225,244', '2016-10-24 16:58:46');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('omnis', '#95e8a4', '48,108,123', '2018-03-21 19:40:39');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('et', '#e23a63', '254,232,17', '2000-12-24 01:59:42');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('rerum', '#cdcd7b', '29,129,16', '2013-05-31 23:06:37');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('tenetur', '#4047f5', '154,159,67', '2019-10-02 01:46:55');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quaerat', '#c888cb', '165,59,26', '1991-06-11 02:33:16');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('illum', '#94fbc5', '113,215,17', '2004-04-22 09:17:13');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('aut', '#b38b54', '148,8,69', '1981-04-11 03:14:18');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('hic', '#4a7096', '97,223,246', '1977-04-15 20:52:07');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('necessitatibus', '#a9fd8c', '250,100,251', '1970-01-19 06:48:48');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('sed', '#6989c2', '213,175,214', '2005-12-04 18:15:15');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('sed', '#c0d670', '121,187,166', '2016-08-30 14:45:40');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('enim', '#4ca728', '39,152,237', '1987-05-15 11:56:25');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('vel', '#a5c1f4', '252,47,205', '1994-08-18 14:38:19');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quod', '#863710', '59,148,1', '2010-02-11 05:15:31');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('nam', '#2de0a6', '108,134,20', '1998-04-26 17:37:58');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('ut', '#354377', '206,231,127', '1983-01-31 03:45:15');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('cupiditate', '#b4e3e5', '39,253,193', '1996-08-18 20:48:27');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('fuga', '#827351', '241,19,161', '1990-11-26 06:27:29');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('et', '#3d6566', '181,6,196', '2007-03-12 17:06:59');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('ea', '#35d5b9', '38,135,160', '2002-12-10 16:45:05');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quo', '#8d1313', '83,166,163', '1979-02-02 12:17:19');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('quibusdam', '#28f057', '161,69,237', '1984-11-01 18:02:55');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('et', '#07df44', '201,100,214', '1977-10-20 09:41:21');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('adipisci', '#3fb47d', '38,63,58', '1983-07-21 06:37:15');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('voluptatum', '#48d8a2', '223,13,217', '2019-07-12 08:55:42');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('pariatur', '#cb6a3a', '106,112,139', '2019-03-17 00:22:11');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('laudantium', '#215986', '248,178,202', '1977-08-02 04:29:52');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('porro', '#3c5a47', '248,141,217', '1972-08-31 11:45:41');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('voluptatem', '#0e5da5', '232,55,197', '2000-05-17 11:59:38');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('maiores', '#674b28', '47,232,64', '2000-08-18 13:40:27');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('itaque', '#738082', '212,78,160', '1982-06-26 20:11:46');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('maiores', '#8a289c', '27,166,245', '1985-09-27 16:38:42');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('sed', '#cadcd5', '116,124,157', '2019-05-25 16:05:13');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('autem', '#e5e94c', '96,169,138', '1988-04-29 19:26:50');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('delectus', '#d341f6', '46,139,47', '1977-07-08 23:14:19');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('molestias', '#12a00c', '79,232,165', '1997-12-28 19:19:01');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('vel', '#d92099', '101,1,73', '2007-06-25 03:09:09');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('ut', '#2e6ede', '210,178,232', '1974-01-26 02:39:43');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('qui', '#be4989', '46,154,214', '2017-07-07 14:04:05');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('at', '#50b784', '194,240,86', '2015-10-16 14:57:30');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('voluptatibus', '#37d817', '220,8,49', '2019-09-21 06:23:33');
INSERT INTO `pollen` ( `plant_name`, `hex`, `rgb`, `date_created`)VALUES ('et', '#882f52', '53,23,239', '2002-11-18 23:28:38');


