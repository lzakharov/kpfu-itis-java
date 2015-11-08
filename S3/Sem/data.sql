INSERT INTO "USER" ("user_id", "username", "first_name", "last_name", "password", "email") VALUES(1, 'lev', 'Lev', 'Zakharov', 'Ololo111', 'lev@example.coml');
INSERT INTO "USER" ("user_id", "username", "first_name", "last_name", "password", "email") VALUES(2, 'ivan', 'Ivan', 'Ivanov', 'Qwerty123', 'ivan@example.coml');
INSERT INTO "USER" ("user_id", "username", "first_name", "last_name", "password", "email") VALUES(3, 'john', 'John', 'Doe', 'Asdfg123', 'john@example.coml');

INSERT INTO "ARTICLE" VALUES(DEFAULT, 'Title', 1, CURRENT_TIMESTAMP, 'This is description of first article');
INSERT INTO "ARTICLE" VALUES(DEFAULT, 'Title', 2, CURRENT_TIMESTAMP, 'This is description of second article');
INSERT INTO "ARTICLE" VALUES(DEFAULT, 'Title', 1, CURRENT_TIMESTAMP, 'This is description');

INSERT INTO "ARTICLE_DATA" VALUES(1, NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi a erat ac libero feugiat fringilla. Donec ullamcorper sodales justo sit amet molestie. Fusce commodo velit ut mauris finibus, vel condimentum lorem molestie. Nam et ullamcorper justo. Morbi tempus, risus quis dapibus congue, nisi mi dictum nibh, vel dictum odio magna non enim. Aliquam hendrerit justo in turpis dictum venenatis. Vivamus auctor purus enim, at tincidunt nisi pulvinar et.
Cras id libero libero. Cras imperdiet volutpat eros sit amet scelerisque. Nulla sit amet ex mi. Vestibulum nisi metus, dapibus nec diam luctus, placerat blandit nunc. Etiam scelerisque maximus egestas. Quisque diam ex, condimentum nec ligula at, maximus fermentum nisl. Maecenas urna ipsum, ornare a bibendum consequat, bibendum a nisl. Nullam quis sapien condimentum, rutrum ex vel, mattis sapien. Donec gravida augue molestie, bibendum nisi sit amet, convallis ante.');
INSERT INTO "ARTICLE_DATA" VALUES(2, NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi a erat ac libero feugiat fringilla. Donec ullamcorper sodales justo sit amet molestie. Fusce commodo velit ut mauris finibus, vel condimentum lorem molestie. Nam et ullamcorper justo. Morbi tempus, risus quis dapibus congue, nisi mi dictum nibh, vel dictum odio magna non enim. Aliquam hendrerit justo in turpis dictum venenatis. Vivamus auctor purus enim, at tincidunt nisi pulvinar et.
Cras id libero libero. Cras imperdiet volutpat eros sit amet scelerisque. Nulla sit amet ex mi. Vestibulum nisi metus, dapibus nec diam luctus, placerat blandit nunc. Etiam scelerisque maximus egestas. Quisque diam ex, condimentum nec ligula at, maximus fermentum nisl. Maecenas urna ipsum, ornare a bibendum consequat, bibendum a nisl. Nullam quis sapien condimentum, rutrum ex vel, mattis sapien. Donec gravida augue molestie, bibendum nisi sit amet, convallis ante.');
INSERT INTO "ARTICLE_DATA" VALUES(3, NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi a erat ac libero feugiat fringilla. Donec ullamcorper sodales justo sit amet molestie. Fusce commodo velit ut mauris finibus, vel condimentum lorem molestie. Nam et ullamcorper justo. Morbi tempus, risus quis dapibus congue, nisi mi dictum nibh, vel dictum odio magna non enim. Aliquam hendrerit justo in turpis dictum venenatis. Vivamus auctor purus enim, at tincidunt nisi pulvinar et.
Cras id libero libero. Cras imperdiet volutpat eros sit amet scelerisque. Nulla sit amet ex mi. Vestibulum nisi metus, dapibus nec diam luctus, placerat blandit nunc. Etiam scelerisque maximus egestas. Quisque diam ex, condimentum nec ligula at, maximus fermentum nisl. Maecenas urna ipsum, ornare a bibendum consequat, bibendum a nisl. Nullam quis sapien condimentum, rutrum ex vel, mattis sapien. Donec gravida augue molestie, bibendum nisi sit amet, convallis ante.');

INSERT INTO "COMMENT" VALUES(DEFAULT, 1, 1, 'This is my first comment', DEFAULT);

INSERT INTO "BOOK" (name) VALUES('Harry Potter');
INSERT INTO "BOOK" (name) VALUES('The Call of Cthulhu');
INSERT INTO "BOOK" (name) VALUES('Surely You''re Joking, Mr. Feynman!');

INSERT INTO "AUTHOR" ("name", "rate") VALUES('J.K. Rowling', 4);
INSERT INTO "AUTHOR" ("name", "birthdate", "rate") VALUES('Howard Phillips Lovecraft', '1890-8-20', 5);
INSERT INTO "AUTHOR" ("name") VALUES('Ralph Leighton');
INSERT INTO "AUTHOR" ("name", "birthdate", "rate") VALUES('Richard Phillips Feynman', '1918-5-11', 5);

INSERT INTO "BOOK_AUTHOR" ("book_id", "author_id") VALUES(1, 1);
INSERT INTO "BOOK_AUTHOR" ("book_id", "author_id") VALUES(2, 2);
INSERT INTO "BOOK_AUTHOR" ("book_id", "author_id") VALUES(3, 3);
INSERT INTO "BOOK_AUTHOR" ("book_id", "author_id") VALUES(3, 4);

INSERT INTO "BOOK_DATA" ("book_id", "description") VALUES(1, 'Harry Potter is an English series of seven fantasy novels written by British author J. K. Rowling. The series chronicles the various adventures of a young wizard, Harry Potter, the titular character, and his friends Ronald Weasley and Hermione Granger, all of whom are students at Hogwarts School of Witchcraft and Wizardry. The main story arc concerns Harr''s quest to defeat the Dark wizard Lord Voldemort, who aims to become immortal, conquer the wizarding world, subjugate non-magical people, and destroy all those who stand in his way, especially Harry Potter.');
INSERT INTO "BOOK_DATA" ("book_id", "description") VALUES(2, '"The Call of Cthulhu" is a short story by American writer H. P. Lovecraft. Written in the summer of 1926, it was first published in the pulp magazine Weird Tales, in February 1928.');
INSERT INTO "BOOK_DATA" ("book_id", "description") VALUES(3, '"Surely You''re Joking, Mr. Feynman!": Adventures of a Curious Character is an edited collection of reminiscences by the Nobel Prize-winning physicist Richard Feynman. The book, released in 1985, covers a variety of instances in Feynman''s life. Some are lighthearted in tone, such as his fascination with safe-cracking, studying various languages, participating with groups of people who share different interests (such as biology or philosophy), and ventures into art and samba music. Others cover more serious material, including his work on the Manhattan Project (during which his first wife Arline Greenbaum died of tuberculosis) and his critique of the science education system in Brazil. The section "Monster Minds" describes his slightly nervous presentation of his graduate work on the Wheeler–Feynman absorber theory in front of Albert Einstein, Wolfgang Pauli and other major figures of the time.');

INSERT INTO "REVIEW" ("book_id", "user_id", "type", "text", "timestamp") VALUES('1', '1', '1', 'Such magic!', CURRENT_TIMESTAMP);
INSERT INTO "REVIEW" ("book_id", "user_id", "type", "text", "timestamp") VALUES('2', '1', '1', 'Ph'' nglui mglw''nafh Cthulhu R''lyeh wgah''nagl fhtagn', CURRENT_TIMESTAMP);
INSERT INTO "REVIEW" ("book_id", "user_id", "type", "text", "timestamp") VALUES('3', '1', '1', 'My favorite book!:)', CURRENT_TIMESTAMP);
