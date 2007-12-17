/* writeseq/1 gibt eine Liste in einer Zeile aus */
writeseq([]).
writeseq([A|B]) :- write(A), writeseq(B).


/* Element hinten anfuegen
 * hintenran(Liste, Elem, Erg).
 */
hintenran([],Elem,[Elem]). % Element als Liste ins Ergebnis kopieren
hintenran([Kopf|Rest],Elem,[Kopf|Ergebnis]) :-
	hintenran(Rest,Elem,Ergebnis),!.


/* ja_nein/2 fuer Teamsport */
ja_nein(Anfrage,Antwort) :-
	Anfrage == 'Moechten Sie in einem Team Sport machen?',
	/* write('Sport ja/nein'),nl, */
	    nonvar(jaeinzelflag),
	    nonvar(japartnerflag),
	    Antwort = ja, !,
	    loesche_flags.


ja_nein(Anfrage,Antwort) :-
	repeat,
	    /* write('Antworten Sie mit "j." fuer JA oder mit "n." fuer NEIN: '), nl, */
	    writeseq([Anfrage, ' (j./n.) ']),
	    read(L),
	    (	L == j, Antwort = ja, !
	     ;	L == n, Antwort = nein, !
	     ;	nl, write('Falsche Eingabe.'), nl,
		fail
	    
	    ).


:- dynamic kokriterien/1.

/* alle KO Antworten in kokriterien/2 loeschen */
loesche_kokriterien :- retract(kokriterien(C,A)),fail.
loesche_kokriterien.

merkeko(Context, Antwort) :- assertz(kokriterien(Context,Antwort)).

/* Liste mit KO Antworten zuruecksetzen */
loesche_kokriterien_liste :- retract(kokriterien(A)),fail.
loesche_kokriterien_liste.

/* Speichern in Liste */
merkeko_in_liste(X) :-
	kokriterien(K),
	hintenran(K, X, Kneu),
	retract(kokriterien(K)),
	assert(kokriterien(Kneu)),
	!.


:- dynamic jaeinzelflag/0.

loesche_jaeinzelflag :- retract(jaeinzelflag(1)),fail.
loesche_jaeinzelflag.

set_jaeinzelflag :- assert(jaeinzelflag(1)),!.


:- dynamic japartnerflag/0.

loesche_japartnerflag :- retract(japartnerflag(1)),fail.
loesche_japartnerflag.

set_japartnerflag :- assert(japartnerflag(1)),!.


/* japartnerflag und jaeinzelflag zuruecksetzen */
loesche_flags :- loesche_jaeinzelflag,loesche_japartnerflag.


/* KO Fragen abfragen */
interview :-
	frageko(Context,Anfrage),
	ja_nein(Anfrage,Antwort),
	(   Antwort == ja,
	    merkeko(Context,2),
	    Context == partnersport, set_japartnerflag    
	;
	    Antwort == nein,
	    merkeko(Context,1),
	    Context == einzelsport, set_jaeinzelflag	
	),
	fail.
interview.

/* Ausgeben aller KO Antworten in kokriterien/2 */
zeige_ko :- kokriterien(C,K),writeseq([C,': ',K]),nl,fail.
zeige_ko.

run :-
	loesche_kokriterien,
	asserta(kokriterien([])),
	/* Aufruf des Praedikats interview/0 */
	interview,
	zeige_ko.
run.



/*
 * Ausfiltern der Sportarten nach KO-Antworten
 * kofilter(Kriterien,Merkmale,Ergebnis).
 */
/*
kofilter([],_,_).
kofilter([Kkrit|Rkrit],[Kmerk|Rmerk],[Kerg|Rerg]) :-
	kofilter(Rkrit,Rmerk,Rerg).
*/
