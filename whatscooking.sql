-- psql path: C:\Users\sofya\Documents\pgsql\bin
-- login:psql -U ah1867 -d ah1867 -h 104.199.20.214
-- User: ah1867 Password: 6duag1oi
-- run the script:source C:\Users\sofya\Documents\LocalWorkSpace\Whats-Cooking\whatscooking.sql
-- psql path: C:\Users\sofya\Documents\pgsql\bin

drop database if exists whatscooking;

create database whatscooking;

\c whatscooking;

create table Recipe (
	id SERIAL PRIMARY KEY,
	name CHAR(50),
	prep_time CHAR(10),
	instructions VARCHAR(2000)
);

create table Ingredient (
	id SERIAL PRIMARY KEY,
	name CHAR(50));

create table Recipe_Ingredient (
	recipe_id INT NOT NULL,
	ingredient_id INT NOT NULL,
	FOREIGN KEY(recipe_id) REFERENCES Recipe(id),
	FOREIGN KEY(ingredient_id) REFERENCES Ingredient(id));
--------------------QUERY search by ingredient_id-------------------------------
WITH cte AS (
SELECT recipe_id, count(*) AS cnt FROM Recipe_Ingredient WHERE ingredient_id IN (1,8)
GROUP BY recipe_id
) SELECT r.id as Recipeid, r.name, c.cnt FROM Recipe r JOIN cte c
    ON r.id = c.recipe_id
    ORDER BY c.cnt DESC;
		------NAME and ID ONLY-----
		WITH cte AS (
		SELECT recipe_id, count(*) AS cnt FROM Recipe_Ingredient WHERE ingredient_id IN (1,8)
		GROUP BY recipe_id
		) SELECT r.id as Recipeid, r.name FROM Recipe r JOIN cte c
		    ON r.id = c.recipe_id
		    ORDER BY c.cnt DESC;
	------------------INSERT INGREDIENTS-----------------------------------------
INSERT INTO Ingredient(name) VALUES ('');
update Recipe set measure = '2 avokado
1 tomat
1 liten chili, eller 0,5 tsk sambal oelek
1 klyfta vitlök
1 msk pressad citron
2 krm salt
0,5 krm svartpeppar
kajennpeppar' where id = 2;
-------------------INSERT Recipe_Ingredient------------------------------------
insert into Recipe_Ingredient (recipe_id, ingredient_id) values (1,1);
	insert into Recipe_Ingredient (recipe_id, ingredient_id) values (1,2);
		insert into Recipe_Ingredient (recipe_id, ingredient_id) values (1,3);
			insert into Recipe_Ingredient (recipe_id, ingredient_id) values (1,4);
				insert into Recipe_Ingredient (recipe_id, ingredient_id) values (1,5);
					insert into Recipe_Ingredient (recipe_id, ingredient_id) values (1,6);
						insert into Recipe_Ingredient (recipe_id, ingredient_id) values (1,7);
insert into Recipe_Ingredient (recipe_id, ingredient_id) values (2,8);
	insert into Recipe_Ingredient (recipe_id, ingredient_id) values (2,1);
		insert into Recipe_Ingredient (recipe_id, ingredient_id) values (2,9);
			insert into Recipe_Ingredient (recipe_id, ingredient_id) values (2,10);
				insert into Recipe_Ingredient (recipe_id, ingredient_id) values (2,11);
--------------------INSERT RECIPES---------------------------------------------
insert into Recipe (name, prep_time, instructions, measure) values
  ('Guacamole', '10 minuter',
'Dela avokadon och ta ur kärnorna. Gröp ur fruktköttet. Lägg fruktköttet i en skål och mixa eller mosa sönder med en gaffel eller i mixer.
Kärna ur tomaten och hacka fint. Dela, kärna ur och hacka chilin fint. Blanda tomat, chili, pressad vitlök pressad citron och kryddor tillsammans med avokadomoset.
Servera till tacos, nachos eller chips.', '2 avokado
1 tomat
1 liten chili, eller 0,5 tsk sambal oelek
1 klyfta vitlök
1 msk pressad citron
2 krm salt
0,5 krm svartpeppar
kajennpeppar');
insert into Recipe (name, prep_time, instructions, measure) values(
	'Grillad avokadotoast','15 minuter',
	'Fördela pesto, skivad avokado, spenat och lagrad ost på två skivor surdegsbröd. Lägg ihop.
Stek brödet i lite olivolja i en stekpanna på båda sidor tills osten smälter eller använd en mackgrill.',
'4 msk pesto
2 skivad avokado
4 dl bladspenat
16 skivor lagrad ost (gärna cheddar)
8 skivor ljust surdegsbröd
olivolja (till stekning)');
