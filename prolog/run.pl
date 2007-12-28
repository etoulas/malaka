/* writeseq/1 gibt eine Liste in einer Zeile aus */
writeseq([]).
writeseq([A|B]) :- write(A), writeseq(B).

/* Abfragen des Elements an Position beginnend bei 1 */
pos_in_liste(Liste,Position,Element) :- pos(Liste,Position,1,Element).

pos([],_,_,Element) :- Element='NULL', fail.
pos([Kopf|_], Stelle, Stelle, Kopf) :- !.
pos([_|Rest], Stelle, Iter, Element) :-
	Next is Iter + 1,
	pos(Rest,Stelle,Next,Element), !.


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


:- dynamic moegl_sportarten/1.

/* alle Verfeinerungen in moegl_sportarten/1 loeschen */
loesche_moegl_sportarten :- retract(moegl_sportarten(S)),fail.
loesche_moegl_sportarten.

/* zu Beginn sind alle Sportarten unter den Moeglichen */
init_moegl_sportarten :-
	loesche_moegl_sportarten,
	merkmale(S,_,_),
	assertz(moegl_sportarten(S)),
	fail.
init_moegl_sportarten.


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
	    auswertung_ko(Context),
	    Context == partnersport, set_japartnerflag
	 ;
	    Antwort == nein,
	    merkeko(Context,1),
	    auswertung_ko(Context),
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


auswertung_ko(Context) :-
	positionen_ko(Context,Pos),
	moegl_sportarten(Sportart),
	merkmale(Sportart,Komerkmale,_),
	pos_in_liste(Komerkmale,Pos,Element),
	kokriterien(Context, Antwort),
	(   Antwort == 2, /* ja */
	    Context == zuhause,
	    Element == 1,
	    retract(moegl_sportarten(Sportart)),
	    writeseq(['LOESCHE alles was nicht zuhause geht: ',Sportart]),nl
	 ;  Antwort == 1, /* nein */
	    
	    /* Sonderfall TEAMSPORT: hier entspricht 3 dem JA */
	    (	Context==teamsport,
		Element==3,
		retract(moegl_sportarten(Sportart)),
		writeseq(['LOESCHE ',Sportart]),nl
	    
	    /* Kein Sport im Sommer => Wintersport => LOESCHE alle Sportarten mit sommer=ja und winter=nein */
	     ;  Context == sommersport,
		positionen_ko(wintersport,Poswinter),
		pos_in_liste(Komerkmale,Poswinter,Winterelem),
		Element == 2,
		Winterelem == 1,
	        retract(moegl_sportarten(Sportart)),
		writeseq(['LOESCHE ',Sportart]),nl
	    
	    /* Kein Sport im Winter => Sommersport => LOESCHE alle Sportarten mit winter=ja und sommer=nein */
	     ;	Context == wintersport,
		positionen_ko(sommersport,Possommer),
		pos_in_liste(Komerkmale,Possommer,Sommerelem),
		Element == 2,
		Sommerelem == 1,
		retract(moegl_sportarten(Sportart)),
		writeseq(['LOESCHE ',Sportart]),nl
	    
	    /* Kein Sport innendrinnen => aussendraussen => LOESCHE alle Sportarten mit indoor=ja und outdoor=nein */
	     ;  Context == indoor,
		positionen_ko(outdoor,Posoutdoor),
		pos_in_liste(Komerkmale,Posoutdoor,Outdoorelem),
		Element == 2,
		Outdoorelem == 1,
	        retract(moegl_sportarten(Sportart)),
		writeseq(['LOESCHE ',Sportart]),nl
	    
	    /* Kein Sport aussendraussen => innendrinnen => LOESCHE alle Sportarten mit outdoor=ja und indoor=nein */
	     ;	Context == outdoor,
		positionen_ko(indoor,Posindoor),
		pos_in_liste(Komerkmale,Posindoor,Indoorelem),
		Element == 2,
		Indoorelem == 1,
		retract(moegl_sportarten(Sportart)),
		writeseq(['LOESCHE ',Sportart]),nl
	    
	    
	    /* fuer alle uebrigen Sportarten LOESCHE, wenn Eigenschaft vorhanden */
	     ;	Context \== teamsport,
		Context \== sommersport,
		Context \== wintersport,
		Context \== indoor,
		Context \== outdoor,
		Context \== zuhause, /* wird nur bei JA Antwort behandelt */
	        Element == 2,
		retract(moegl_sportarten(Sportart)),
		writeseq(['LOESCHE ',Sportart]),nl
	    )
	),
	fail.
auswertung_ko(Context).

/*
auswertung_schwimmen:
1) ja:
moegliche(alle).
2) nein:
moegliche(alle\schwimmen).

auswertung_einzelsport:
1) ja:
keine veraenderung
2) nein:
lese alle moeglichen ein
entferne alle die einzelsport sind

auswertung_partnersport:
1) ja: keine veraenderung
2) nein:
pruefe jedes der gespeicherten auf reinen partnersport
   wenn der fall dann retract diesen fakt
reiner(!) partnersport wird entfernt
*/

init :- loesche_kokriterien,
	loesche_verfeinerung,
	init_moegl_sportarten.

run :-
	init,
	interview,
	nl,zeige_ko,
	interview_rest,
	nl,zeige_rest.
