[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/t19xNtmg)

		TP1 - Le Design Pattern Observer
				Génie Logiciel


							Rédigé par:
							 EOC BELGHINI Nada
							 RSD


  Objectifs du TP:
Comprendre et implémenter le design pattern Observer
Gérer les notifications entre composants
Résoudre les problèmes de concurrence
Créer une interface graphique fonctionnelle

  premiere partie:
j'ai completée l'implimentation de la classe horloge qui affiche le temps reel avec un petit test dans App.java 
Puis j'ai implementée une autre classe CompteARebours similaire à classe Horloge mais avec un compteur à decrementer jusqu'à 0 il desinstancie t automatique , et un petit test aussi avec 10 instances avec valeurs aleatoires
Apres l'execution de cette partie j'ai rencontrée un probleme de concurrence à cause de la désinscription pendant la notification et pour cela j'ai utiliser la classe standard PropertyChangeSupport qui est mentionnée dans la qst f pour offrir une gestion thread-safe des listeners
  Deuxieme partie:
pour realiser une interface graphique en utilisant ce service j'ai besion de faire appele a la classe Swing 
  Conclusion:
Ce TP a permis de maîtriser le pattern Observer dans un contexte concret et complet.