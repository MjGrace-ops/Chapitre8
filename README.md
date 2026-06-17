# BookShelf 📚

Un projet Java illustrant la conception orientée objet et les **streams Java 8+** à travers une bibliothèque de livres capable de trier et regrouper son contenu selon différents critères. Développé en TDD (Test-Driven Development) avec JUnit 5 et AssertJ.

## Comment ça marche ?

Le projet repose sur deux classes principales :

- **`Book`** représente un livre immuable (titre, auteur, date de publication). Il implémente `Comparable<Book>` pour définir un ordre naturel basé sur le titre.
- **`BookShelf`** gère une collection de livres. Elle encapsule sa liste interne et n'expose qu'une vue **immuable** via `books()`, garantissant que seule la méthode `add()` peut faire évoluer son contenu.

`BookShelf` propose deux familles de fonctionnalités basées sur les **Streams** :

- **Tri (`arrange`)** — par ordre naturel (titre) ou selon un `Comparator` personnalisé, sans jamais modifier l'ordre d'insertion original.
- **Regroupement (`groupBy`)** — par année de publication, ou selon n'importe quel critère fourni via une `Function<Book, K>` générique (ex : par auteur).

## Structure du projet

```
├── Book.java            # Classe représentant un livre (immuable, Comparable)
├── BookShelf.java       # Bibliothèque : ajout, tri, regroupement
└── BookShelfSpec.java   # Suite de tests JUnit 5 / AssertJ (TDD)
```

## Technologies utilisées

`Java` `POO` `Streams` `Generics` `JUnit 5` `AssertJ` `TDD`

## Commencer

```bash
# Compiler tous les fichiers (avec les dépendances JUnit/AssertJ sur le classpath)
javac -cp .:junit-jupiter.jar:assertj-core.jar *.java

# Lancer les tests via Maven ou Gradle
mvn test
# ou
gradle test
```

## Concepts clés illustrés

`Immuabilité`
`Book` n'a aucun setter : une fois créé, ses données ne changent plus. Cela évite les effets de bord lorsqu'un livre est partagé entre plusieurs structures (listes triées, maps de regroupement).

`Encapsulation`
`BookShelf.books()` retourne une liste enveloppée dans `Collections.unmodifiableList()`. Toute tentative de modification externe lève une `UnsupportedOperationException`, protégeant ainsi l'état interne de la classe.

`Varargs`
`add(Book... bookToAdd)` permet d'ajouter zéro, un ou plusieurs livres en un seul appel, sans surcharge de méthode.

`Generics`
`groupBy(Function<Book, K> fx)` est générique : la clé de regroupement `<K>` peut être n'importe quel type (`Year`, `String`, etc.), ce qui rend la méthode réutilisable pour tout critère futur.

## Personnalisation

`Book`
Ajoutez des attributs comme `isbn`, `publisher` ou `pageCount` pour enrichir le modèle, en pensant à mettre à jour le constructeur et `toString()`.

`BookShelf`
Ajoutez des méthodes comme `remove(Book book)`, `findByAuthor(String author)` ou `countByGenre()` pour étendre les fonctionnalités de la bibliothèque.