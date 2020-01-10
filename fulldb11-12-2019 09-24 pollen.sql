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
