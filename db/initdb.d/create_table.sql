CREATE TABLE `teams`
(
    `id`        bigint      NOT NULL AUTO_INCREMENT,
    `name`      varchar(50) NOT NULL,
    `league`    varchar(50) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `teams_name_unique` UNIQUE (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `players`
(
    `id`            bigint      NOT NULL AUTO_INCREMENT,
    `name`          varchar(50) NOT NULL,
    `back_number`   int,
    `nationality`   varchar(50) NOT NULL,
    `team_id`       bigint      NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `players_teams_ref` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX `teams_name_idx` ON `teams` (`name`);
CREATE INDEX `teams_league_idx` ON `teams` (`league`);
CREATE INDEX `players_name_idx` ON `players` (`name`);