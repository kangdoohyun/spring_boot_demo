DROP DATABASE IF EXISTS spring_boot_demo;

CREATE DATABASE spring_boot_demo;

USE spring_boot_demo;

CREATE TABLE article(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    title CHAR(50) NOT NULL,
    `body` TEXT
);

INSERT INTO article SET
regDate = NOW(),
updateDate = NOW(),
title = "제목1",
`body` = "내용1";

INSERT INTO article SET
regDate = NOW(),
updateDate = NOW(),
title = "제목2",
`body` = "내용2";

INSERT INTO article SET
regDate = NOW(),
updateDate = NOW(),
title = "제목3",
`body` = "내용3";

SELECT * FROM article;