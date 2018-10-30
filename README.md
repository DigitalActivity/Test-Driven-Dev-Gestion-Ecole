# TestDrivenDev---GestionEcole
Développement piloté par les tests

- Cours de Programmation agile 
- Cegep de Saint-Jean-sur-Richelieu A2017
- Objectif : Développer un système d’information permettant la gestion d’une école en utilisant la methodologie de développement piloté par les tests.

Consignes	
	
Section	École	
	
1.	TestCoursSession	et	TestRapportInscription	utilisent	une	méthode	creerDate.	On	veut	plutôt	créer	une	classe	DateUtil.	Le	constructeur	sera	private	et	la	méthode	creerDate()	sera	statique.	
	
• Créer	une	classe	TestDateUtil	• Créer	une	classe	DateUtil	tel	qu’indiqué	• Modifier	TestComplet	pour	intégrer	le	nouveau	test	• Ajuster	le	reste	du	code	au	besoin	pour	l’utiliser	
	
2.	On	veut	ajouter	un	compteur	pour	garder	le	nombre	de	CoursSession	créés.	Il	est	logique	de	créer	une	variable	statique.	Cependant,	de	la	même	façon	qu’on	n’expose	pas	les	variables	membres,	on	voudra	garder	le	compteur	private	et	utiliser	des	méthodes	pour	lui	accéder.	
	
• Modifier	TestCoursSession	pour	tester	le	compte	de	cours.	On	doit	aussi	pouvoir	réinitialiser	le	compte	de	CoursSession	à	0	• Ajuster	CoursSession	pour	que	le	test	passe	
	
3.	On	veut	maintenant	savoir	si	un	étudiant	est	à	temps	(>=	9	unités).	
	
• Modifier	TestEtudiant	pour	permettre	d’ajouter	des	unités,	vérifier	le	nombre	d’unités	d’un	élève	et	vérifier	s’il	est	à	temps	plein	• Ajuster	Étudiant	pour	que	le	test	passe	
	
4.	Réusiner	TestCoursSession	et	CoursSession	de	façon	à	utiliser	une	fabrique	pour	la	création	d’un	CoursSession.		
	
• Modifier	TestCoursSession	de	façon	à	ce	qu’on	crée	un	cours	à	l’aide	de	la	fabrique	de	CoursSession	et	qu’on	puisse	définir	le	nombre	d’unités	du	cours	à	la	création	• Ajuster	le	reste	du	code	au	besoin	
	
5.	On	veut	vérifier	qu’un	étudiant	est	étranger	ou	non	
	
• Modifier	TestEtudiant	pour	permettre	de	définir	le	pays	d’un	élève	(ex	:	CA,	FR,	US	…)	et	pour	vérifier	s’il	est	canadien	• Ajuster	Étudiant	pour	que	le	test	passe	
	
