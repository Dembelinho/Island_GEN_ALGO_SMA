# Island_GEN_ALGO_SMA
# Qu'est-ce que l'algorithme génétique ?

L'algorithme génétique est une méthode permettant de résoudre des problèmes d'optimisation avec ou sans contraintes.
Il est basé sur la sélection naturelle, le processus qui régit l'évolution biologique. 
L'algorithme génétique modifie de manière répétée une population de solutions individuelles. À chaque étape, l'algorithme génétique sélectionne des individus de la population actuelle comme parents et les utilise pour produire les enfants de la génération suivante. 
Au fil des générations successives, la population "évolue" vers une solution optimale. Vous pouvez appliquer l'algorithme génétique pour résoudre une variété de problèmes d'optimisation qui ne sont pas bien adaptés aux algorithmes d'optimisation standard, y compris les problèmes dans lesquels la fonction objective est discontinue, non différentiable, stochastique ou hautement non linéaire. 
L'algorithme génétique peut résoudre des problèmes de programmation mixte en nombres entiers, où certaines composantes sont limitées à des valeurs entières.


![Parallel-Genetic-Algorithm](https://github.com/Dembelinho/Island_GEN_ALGO_SMA/assets/110602716/c47637bf-01df-4932-af48-bb4bf7a60d57)
![gaflowchart](https://github.com/Dembelinho/Island_GEN_ALGO_SMA/assets/110602716/c0840a84-ce90-45a6-919b-372683ced0b0)

# Parallel and distributed genetic algorithms

L'algorithme génétique parallèle est un algorithme qui utilise plusieurs algorithmes génétiques pour résoudre une seule tâche. Tous ces algorithmes tentent de résoudre la même tâche et une fois qu'ils ont terminé leur travail, le meilleur individu de chaque algorithme est sélectionné, puis le meilleur d'entre eux est sélectionné, et c'est ainsi que l'on obtient la solution à un problème.
C'est l'une des approches les plus populaires des algorithmes génétiques parallèles, même s'il en existe d'autres. Cette approche est souvent appelée "modèle insulaire" parce que les populations sont isolées les unes des autres, comme les populations de créatures de la vie réelle peuvent être isolées et vivre sur des îles différentes. L'image ci-dessus illustre cette situation.
Ces algorithmes génétiques ne dépendent pas les uns des autres et peuvent donc être exécutés en parallèle, en tirant parti d'une unité centrale multicœur. Chaque algorithme possède son propre ensemble d'individus, qui peuvent donc différer des individus d'un autre algorithme, parce qu'ils ont des antécédents de mutation/croisement différents.

![Parallel-genetic-algorithm-with-island-model](https://github.com/Dembelinho/Island_GEN_ALGO_SMA/assets/110602716/bd56f340-4604-4178-a5dc-4d2a6622846a)
![Capture d’écran (90)](https://github.com/Dembelinho/Island_GEN_ALGO_SMA/assets/110602716/920f7973-2765-42c2-9c9f-d0f3c0957255)

# Algorithme génétique distribué

L'algorithme génétique distribué est en fait un algorithme génétique parallèle dont les algorithmes indépendants sont exécutés sur des machines distinctes. De plus, dans ce cas, chacun de ces algorithmes peut être à son tour un algorithme génétique parallèle ! L'algorithme génétique distribué met également en œuvre le "modèle de l'île" et chaque "île" est encore plus isolée des autres. Si chaque machine exécute un algorithme génétique parallèle, on peut parler de "modèle de l'archipel", car nous avons des groupes d'îles. En fait, ce qu'est un algorithme génétique unique n'a pas d'importance, car l'algorithme génétique distribué consiste à faire fonctionner plusieurs machines avec des algorithmes génétiques indépendants afin de résoudre la même tâche. L'image suivant l'illustre.
![Capture d’écran (88)](https://github.com/Dembelinho/Island_GEN_ALGO_SMA/assets/110602716/b4e38dc6-252f-4931-83d7-9641be194525)
