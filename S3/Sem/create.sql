CREATE TABLE "USER" (
  "user_id" SERIAL,
  "username" VARCHAR(20) NOT NULL,
  "first_name" VARCHAR(20) NOT NULL,
  "last_name" VARCHAR(20) NOT NULL,
  "password" VARCHAR(20) NOT NULL,
  "email" VARCHAR(100) NOT NULL,
  "birthdate" DATE,
  "address" VARCHAR(100),
  "avatar" VARCHAR(128),
  PRIMARY KEY ("user_id")
);

CREATE TABLE "ARTICLE" (
  "article_id" SERIAL,
  "title" VARCHAR(50) NOT NULL,
  "author_id" INTEGER NOT NULL,
  "timestamp" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  "description" VARCHAR(300),
  PRIMARY KEY ("article_id")
);

CREATE TABLE "ARTICLE_DATA" (
  "article_id" INTEGER NOT NULL,
  "image" VARCHAR(100),
  "text" text NOT NULL
);

CREATE TABLE "AUTHOR" (
  "author_id" SERIAL,
  "name" VARCHAR(100) NOT NULL,
  "birthdate" DATE,
  "rate" INTEGER,
  PRIMARY KEY ("author_id")
);

CREATE TABLE "COMMENT" (
  "comment_id" SERIAL,
  "article_id" INTEGER NOT NULL,
  "author_id" INTEGER NOT NULL,
  "text" TEXT NOT NULL,
  "timestamp" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY ("comment_id")
);

CREATE TABLE "BOOK" (
  "book_id" SERIAL,
  "name" VARCHAR(100) NOT NULL,
  "year" INTEGER,
  "publisher" VARCHAR(100),
  "rate" INTEGER,
  PRIMARY KEY ("book_id")
);

CREATE TABLE "BOOK_AUTHOR" (
  "book_id" INTEGER NOT NULL,
  "author_id" INTEGER NOT NULL
);

CREATE TABLE "BOOK_DATA" (
  "book_id" INTEGER NOT NULL,
  "description" TEXT,
  "text" VARCHAR(100),
  "cover" VARCHAR(100)
);

CREATE TABLE "MESSAGE" (
  "message_id" SERIAL,
  "sender_id" INTEGER NOT NULL,
  "receiver_id" INTEGER NOT NULL,
  "subject" VARCHAR(100),
  "text" TEXT NOT NULL,
  "date" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY ("message_id")
);

CREATE TABLE "NOTE" (
  "note_id" SERIAL,
  "user_id" INTEGER NOT NULL,
  "book_id" INTEGER NOT NULL,
  "title" VARCHAR(100),
  "text" TEXT,
  PRIMARY KEY ("note_id")
);

CREATE TABLE "REVIEW" (
  "review_id" SERIAL,
  "book_id" INTEGER NOT NULL,
  "user_id" INTEGER NOT NULL,
  "type" INTEGER NOT NULL,
  "text" TEXT NOT NULL,
  "timestamp" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY ("review_id")
);

ALTER TABLE "ARTICLE" ADD FOREIGN KEY ("author_id") REFERENCES "USER" ("user_id");
ALTER TABLE "ARTICLE_DATA" ADD FOREIGN KEY ("article_id") REFERENCES "ARTICLE" ("article_id");
ALTER TABLE "COMMENT" ADD FOREIGN KEY ("article_id") REFERENCES "ARTICLE" ("article_id");
ALTER TABLE "COMMENT" ADD FOREIGN KEY ("author_id") REFERENCES "USER" ("user_id");
ALTER TABLE "BOOK_DATA" ADD FOREIGN KEY ("book_id") REFERENCES "BOOK" ("book_id");
ALTER TABLE "BOOK_AUTHOR" ADD FOREIGN KEY ("book_id") REFERENCES "BOOK" ("book_id");
ALTER TABLE "BOOK_AUTHOR" ADD FOREIGN KEY ("author_id") REFERENCES "AUTHOR" ("author_id");
ALTER TABLE "MESSAGE" ADD FOREIGN KEY ("sender_id") REFERENCES "USER" ("user_id");
ALTER TABLE "MESSAGE" ADD FOREIGN KEY ("receiver_id") REFERENCES "USER" ("user_id");
ALTER TABLE "NOTE" ADD FOREIGN KEY ("user_id") REFERENCES "USER" ("user_id");
ALTER TABLE "NOTE" ADD FOREIGN KEY ("book_id") REFERENCES "BOOK" ("book_id");
ALTER TABLE "REVIEW" ADD FOREIGN KEY ("book_id") REFERENCES "BOOK" ("book_id");
ALTER TABLE "REVIEW" ADD FOREIGN KEY ("user_id") REFERENCES "USER" ("user_id");
