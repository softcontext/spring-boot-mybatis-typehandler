--------------------------------------------------------
-- Thanks To : http://www.thespringriver.com/simple-example-of-mybatis-java-maven-implementation-8-customized-type-handler/
--------------------------------------------------------

drop table if exists user;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) character set latin1 NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB;
