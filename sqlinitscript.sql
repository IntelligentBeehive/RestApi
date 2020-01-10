DROP TABLE IF EXISTS `beehealth`;
CREATE TABLE `beehealth` (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date_created timestamp NOT NULL DEFAULT current_timestamp,
    bee_count int,
    brood_pattern_healthy_confidence int,
    brood_pattern_unhealthy_confidence int,
    hive_health int,
    message varchar(200)
)