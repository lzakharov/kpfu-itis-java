INSERT INTO `USER` (`username`, `password`, `email`, `birthdate`, `address`, `educational_status`) VALUES('user1', '12345', 'user1@mail.com', '1900-1-1', 'address1', '1');
INSERT INTO `USER` (`username`, `password`, `email`, `birthdate`, `address`, `educational_status`) VALUES('user2', '12345', 'user2@mail.com', '1980-2-20', 'address2', '2');
INSERT INTO `USER` (`username`, `password`, `email`, `birthdate`, `address`, `educational_status`) VALUES('user3', '12345', 'user3@mail.com', '2000-1-1', 'address3', '1');

INSERT INTO `MESSAGE` (`sender_id`, `receiver_id`, `subject`, `text`) VALUES('1', '2', 'subject1', 'Hi!');
INSERT INTO `MESSAGE` (`sender_id`, `receiver_id`, `subject`, `text`) VALUES('2', '1', 'subject1', 'Hi! How r u?');
INSERT INTO `MESSAGE` (`sender_id`, `receiver_id`, `subject`, `text`) VALUES('3', '1', 'subject1', 'Hello!:)');

INSERT INTO `NEWS` (`title`, `text`) VALUES('Very interesting news', 'Very interesting text:)');
INSERT INTO `NEWS` (`title`, `text`) VALUES('Very boring news', 'Very boring text:/');
INSERT INTO `NEWS` (`title`, `text`) VALUES('Normal news', 'Here some text...');

INSERT INTO `COMMENT` (`news_id`, `user_id`, `text`) VALUES('1', '1', 'WOW! Such interesting!');
INSERT INTO `COMMENT` (`news_id`, `user_id`, `text`) VALUES('2', '2', 'Damn! So boring -...-');
INSERT INTO `COMMENT` (`news_id`, `user_id`, `text`) VALUES('1', '1', 'Ok, nice text.');

INSERT INTO `COMMENT` (`news_id`, `user_id`, `text`) VALUES('1', '1', 'Ok, nice text.');
INSERT INTO `COMMENT` (`news_id`, `user_id`, `text`) VALUES('1', '1', 'Ok, nice text.');
INSERT INTO `COMMENT` (`news_id`, `user_id`, `text`) VALUES('1', '1', 'Ok, nice text.');

INSERT INTO `BOOK` (`title`) VALUES('Harry Potter');
INSERT INTO `BOOK` (`title`) VALUES('The Call of Cthulhu');
INSERT INTO `BOOK` (`title`) VALUES('Surely You\'re Joking, Mr. Feynman!');

INSERT INTO `REVIEW` (`book_id`, `user_id`, `type`, `text`) VALUES('1', '1', '1', 'Such magic!');
INSERT INTO `REVIEW` (`book_id`, `user_id`, `type`, `text`) VALUES('2', '1', '1', 'Ph\' nglui mglw\'nafh Cthulhu R\'lyeh wgah\'nagl fhtagn');
INSERT INTO `REVIEW` (`book_id`, `user_id`, `type`, `text`) VALUES('3', '3', '1', 'My favorite book!:)');

INSERT INTO `NOTE` (`title`, `text`, `user_id`, `book_id`) VALUES('note1', 'This my first note', '1', '1');
INSERT INTO `NOTE` (`title`, `text`, `user_id`, `book_id`) VALUES('note2', 'This my second note', '1', '1');
INSERT INTO `NOTE` (`title`, `text`, `user_id`, `book_id`) VALUES('note1', 'This my first note', '2', '1');

INSERT INTO `AUTHOR` (`name`, `rate`) VALUES('J.K. Rowling', 4);
INSERT INTO `AUTHOR` (`name`, `birthdate`, `rate`) VALUES('Howard Phillips Lovecraft', '1890-8-20', 5);
INSERT INTO `AUTHOR` (`name`) VALUES('Ralph Leighton');
INSERT INTO `AUTHOR` (`name`, `birthdate`, `rate`) VALUES('Richard Phillips Feynman', '1918-5-11', 5);

INSERT INTO `BOOK_AUTHOR` (`book_id`, `author_id`) VALUES(1, 1);
INSERT INTO `BOOK_AUTHOR` (`book_id`, `author_id`) VALUES(2, 2);
INSERT INTO `BOOK_AUTHOR` (`book_id`, `author_id`) VALUES(3, 3);
INSERT INTO `BOOK_AUTHOR` (`book_id`, `author_id`) VALUES(3, 4);

INSERT INTO `BOOK_DATA` (`book_id`, `description`) VALUES(1, 'Harry Potter is an English series of seven fantasy novels written by British author J. K. Rowling. The series chronicles the various adventures of a young wizard, Harry Potter, the titular character, and his friends Ronald Weasley and Hermione Granger, all of whom are students at Hogwarts School of Witchcraft and Wizardry. The main story arc concerns Harry\'s quest to defeat the Dark wizard Lord Voldemort, who aims to become immortal, conquer the wizarding world, subjugate non-magical people, and destroy all those who stand in his way, especially Harry Potter.');
INSERT INTO `BOOK_DATA` (`book_id`, `description`) VALUES(2, '\"The Call of Cthulhu\" is a short story by American writer H. P. Lovecraft. Written in the summer of 1926, it was first published in the pulp magazine Weird Tales, in February 1928.');
INSERT INTO `BOOK_DATA` (`book_id`, `description`) VALUES(3, '\"Surely You\'re Joking, Mr. Feynman!\": Adventures of a Curious Character is an edited collection of reminiscences by the Nobel Prize-winning physicist Richard Feynman. The book, released in 1985, covers a variety of instances in Feynman\'s life. Some are lighthearted in tone, such as his fascination with safe-cracking, studying various languages, participating with groups of people who share different interests (such as biology or philosophy), and ventures into art and samba music. Others cover more serious material, including his work on the Manhattan Project (during which his first wife Arline Greenbaum died of tuberculosis) and his critique of the science education system in Brazil. The section \"Monster Minds\" describes his slightly nervous presentation of his graduate work on the Wheeler–Feynman absorber theory in front of Albert Einstein, Wolfgang Pauli and other major figures of the time.');