# TondeuseApp
Tondeuse à gazon

Ce programme est une gestion de tondeuse à gazon. Il reçoit un fichier en argument de ce type :
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA

La première ligne comporte l'abscisse et l'ordonnée du coin supérieur droit du gazon. Le coin inférieur gauche a pour coordonnées 0 0.
Les lignes suivantes sont couplées entre elle :
    - La première indique la position de départ d'une tondeuse et dans quel sens elle est tournée.
    - La deuxième est la suite d'instructions à appliquer à la tondeuse.

Le programme lit un fichier et affiche les positions finales des tondeuse sur le gazon.
Le fichier ci-dessus donnerait :
1 3 N
5 1 E
