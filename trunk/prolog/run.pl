/* writeseq/1 gibt eine Liste in einer Zeile aus */
writeseq([]).
writeseq([A|B]) :- write(A), writeseq(B).


/* Element hinten anfuegen
 * hintenran(Liste, Elem, Erg).
 */
hintenran([],Elem,[Elem]). % Element als Liste ins Ergebnis kopieren
hintenran([Kopf|Rest],Elem,[Kopf|Ergebnis]) :-
	hintenran(Rest,Elem,Ergebnis),!.


/* ja_nein/2 TEAMSPORT */
ja_nein(Anfrage,Antwort) :-
	Anfrage == 'Moechten Sie in einem Team Sport machen?',
	/* write('Sport ja/nein'),nl, */
	    jaeinzelflag(X),
	    japartnerflag(Y),
	    Antwort = ja, !,
	    loesche_flags.

/* ja_nein/2 WINTERSPORT */
ja_nein(Anfrage,Antwort) :-
	Anfrage == 'Moechten Sie im Winter Sport treiben?',
	/* write('Sport ja/nein'),nl, */
	    neinsommerflag(X),
	    Antwort = ja, !,
	    loesche_flags.

/* ja_nein/2 INDOOR */
ja_nein(Anfrage,Antwort) :-
	Anfrage == 'Moechten Sie in einem Gebaeude Sport betreiben?',
	/* write('Sport ja/nein'),nl, */
	    neinoutdoorflag(X),
	    Antwort = ja, !,
	    loesche_flags.


/* ja_nein/2 ALLGEMEIN */
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


:- dynamic kokriterien/2.

/* alle KO Antworten in kokriterien/2 loeschen */
loesche_kokriterien :- retract(kokriterien(C,A)),fail.
loesche_kokriterien.

merkeko(Context, Antwort) :- assertz(kokriterien(Context,Antwort)).

/* Liste mit KO Antworten zuruecksetzen */
/* :- dynamic kokriterien/1.
loesche_kokriterien_liste :- retract(kokriterien(A)),fail.
loesche_kokriterien_liste.

/* Speichern in Liste */
merkeko_in_liste(X) :-
	kokriterien(K),
	hintenran(K, X, Kneu),
	retract(kokriterien(K)),
	assert(kokriterien(Kneu)),
	!.
*/


:- dynamic verfeinerung/2.

/* alle Verfeinerungen in verfeinerung/2 loeschen */
loesche_verfeinerung :- retract(verfeinerung(C,A)),fail.
loesche_verfeinerung.

merke_verfeinerung(Context, Antwort) :- assertz(verfeinerung(Context,Antwort)).


:- dynamic jaeinzelflag/1.

loesche_jaeinzelflag :- retract(jaeinzelflag(1)),fail.
loesche_jaeinzelflag.

set_jaeinzelflag :- assert(jaeinzelflag(1)),!.



:- dynamic japartnerflag/1.

loesche_japartnerflag :- retract(japartnerflag(1)),fail.
loesche_japartnerflag.

set_japartnerflag :- assert(japartnerflag(1)),!.


:- dynamic neinsommerflag/1.

loesche_neinsommerflag :- retract(neinsommerflag(1)),fail.
loesche_neinsommerflag.

set_neinsommerflag :- assert(neinsommerflag(1)),!.


:- dynamic neinoutdoorflag/1.

loesche_neinoutdoorflag :- retract(neinoutdoorflag(1)),fail.
loesche_neinoutdoorflag.

set_neinoutdoorflag :- assert(neinoutdoorflag(1)),!.


/* japartnerflag und jaeinzelflag zuruecksetzen */
loesche_flags :-
	loesche_jaeinzelflag,
	loesche_japartnerflag,
	loesche_neinsommerflag,
	loesche_neinoutdoorflag.


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
	    (	Context == einzelsport, set_jaeinzelflag
	    ;	Context == sommersport, set_neinsommerflag
	    ;	Context == outdoor, set_neinoutdoorflag
	    )
	),
	fail.
interview.

/* Ausgeben aller KO Antworten in kokriterien/2 */
zeige_ko :- kokriterien(C,A),writeseq([C,': ',A]),nl,fail.
zeige_ko.

/* Ausgeben aller Verfeinerungs-Antworten in verfeinerung/2 */
zeige_rest :- verfeinerung(C,A),writeseq([C,': ',A]),nl,fail.
zeige_rest.


interview_rest :-
	 frage(Context,Anfrage),
	 eingabe_loop(Context,Anfrage,Antwort),
	 merke_verfeinerung(Context,Antwort),
	fail.
interview_rest.

eingabe_loop(Context,Anfrage,Antwort) :-
	repeat,
	 write(Anfrage),nl,
	 auswahl(Context),
	 write('Ihre Eingabe: '),
	 read(Antwort),
	 antwort(Context,Antwort),
	!.


auswahl(Context) :-
	option(Context,Kuerzel,Text),
	writeseq(['    ',Kuerzel,' - ', Text]),nl,
	fail.
auswahl(Context) :- nl.


antwort(Context,Antwort) :- option(Context,Antwort,_),!.
antwort(Context,_) :- write('=>  Antwort ungueltig.'),nl,nl,fail.

run :-
	loesche_kokriterien,
	loesche_verfeinerung,
	interview,
	zeige_ko,
	interview_rest,
	zeige_rest.

run2 :-	loesche_verfeinerung,
	interview_rest,
	zeige_rest.



/*
 * Ausfiltern der Sportarten nach KO-Antworten
 * kofilter(Kriterien,Merkmale,Ergebnis).
 */
/*
kofilter([],_,_).
kofilter([Kkrit|Rkrit],[Kmerk|Rmerk],[Kerg|Rerg]) :-
	kofilter(Rkrit,Rmerk,Rerg).
*/
