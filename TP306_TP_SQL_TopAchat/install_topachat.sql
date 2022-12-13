CREATE TABLE Produit AS SELECT * FROM scott.Produit;
ALTER TABLE topachat.Produit ADD CONSTRAINT P_key PRIMARY KEY (noProduit);
