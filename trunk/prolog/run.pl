   /***************************************/
  /* inkludieren von benoetigten Dateien */
 /***************************************/

% Wissensbasis
:- consult(fakten).

% Testdaten
:- consult(test).

  /**************/
 /* Helferlein */
/**************/

% writeseq/1 gibt eine Liste in einer Zeile aus
writeseq([]).
writeseq([A|B]) :- write(A), writeseq(B).


% Abfragen des Elements an Position beginnend bei 1
pos_in_liste(Liste,Position,Element) :- pos(Liste,Position,1,Element).

% eigentliche Rekursion zur Bestimmung des Elementes an n-ter Stelle
pos([],_,_,Element) :- Element='NULL', fail.
pos([Kopf|_], Stelle, Stelle, Kopf) :- !.
pos([_|Rest], Stelle, Iter, Element) :-
	Next is Iter + 1,
	pos(Rest,Stelle,Next,Element), !.


  /*************/
 /* Debugging */
/*************/

% dbg/1 - wie write/1 bzw. writeseq/1, prueft jedoch auf debug_aktiv(ja)
dbg([K|R]) :- debug_aktiv(ja),!,write('DEBUG '),write(K),writeseq(R).
dbg(Text) :- debug_aktiv(ja),!,write('DEBUG '),write(Text).
dbg(_).

% Ausgeben aller KO Antworten in kokriterien/2
zeige_ko :-
	nl,dbg('Antworten auf KO-Fragen'),nl,
	kokriterien(C,A),dbg(['   ',C,': ',A]),nl,fail
	;
	nl.

% Ausgeben der uebrig gebliebenen Sportarten nach KO Auswertung
zeige_moegl_sportarten :-
	nl,dbg('Sportarten nach KO Auswertung'),nl,
	moegl_sportarten(X),dbg(['   ',X]),nl,fail
	;
	nl.

% Ausgeben aller Verfeinerungs-Antworten in verfeinerung/2
zeige_verfeinerung :-
	nl,dbg('Antworten auf Verfeinerungsfragen'),nl,
	verfeinerung(C,A),dbg(['   ',C,': ',A]),nl,fail
	;
	nl.

zeige_bewertungen :-
	dbg('Bewertungsdetails'),nl,
	bewertung(S,B),dbg(['   ',S,': ',B]),nl,fail
	;
	nl.


  /*************/
 /* ja_nein/2 */
/*************/

/* ja_nein/2 TEAMSPORT */
ja_nein(Anfrage,Antwort) :-
	Anfrage == 'Moechten Sie in einem Team Sport machen?',
	    jaeinzelflag(_),
	    japartnerflag(_),
	    Antwort = ja, !,
	    loesche_flags.

/* ja_nein/2 WINTERSPORT */
ja_nein(Anfrage,Antwort) :-
	Anfrage == 'Moechten Sie im Winter Sport treiben?',
	    neinsommerflag(_),
	    Antwort = ja, !,
	    loesche_flags.

/* ja_nein/2 INDOOR */
ja_nein(Anfrage,Antwort) :-
	Anfrage == 'Moechten Sie in einem Gebaeude Sport betreiben?',
	    neinoutdoorflag(_),
	    Antwort = ja, !,
	    loesche_flags.


/* ja_nein/2 ALLGEMEIN */
ja_nein(Anfrage,Antwort) :-
	repeat,
	    writeseq([Anfrage, ' (j./n.) ']),
	    read(L),
	    (	L == j,!, Antwort = ja
	     ;	L == n,!, Antwort = nein
	     ;	nl, write('Falsche Eingabe.'), nl,
		fail
	    ).


  /*************************/
 /* dynamische Praedikate */
/*************************/

:- dynamic kokriterien/2.

/* alle KO Antworten in kokriterien/2 loeschen */
loesche_kokriterien :- retract(kokriterien(_,_)),fail ; true.
merkeko(Context, Antwort) :- assertz(kokriterien(Context,Antwort)).


:- dynamic verfeinerung/2.

/* alle Verfeinerungen in verfeinerung/2 loeschen */
loesche_verfeinerung :- retract(verfeinerung(_,_)),fail ; true.
merke_verfeinerung(Context, Antwort) :- assertz(verfeinerung(Context,Antwort)).


:- dynamic moegl_sportarten/1.

/* alle Verfeinerungen in moegl_sportarten/1 loeschen */
loesche_moegl_sportarten :- retract(moegl_sportarten(_)),fail ; true.

/* zu Beginn sind alle Sportarten unter den Moeglichen */
init_moegl_sportarten :-
	loesche_moegl_sportarten,
	merkmale(S,_,_),
	assertz(moegl_sportarten(S)),
	fail
	;
	true.

:- dynamic bewertung/2.
loesche_bewertungen :- retract(bewertung(_,_)),fail ; true.
init_bewertungen :-
	loesche_bewertungen,
	moegl_sportarten(S),
	assertz(bewertung(S,0)),
	fail
	;
	true.

:- dynamic aktueller_zaehler/1.
loesche_akt_zaehler:- retract(aktueller_zaehler(_)),fail ; true.
init_akt_zaehler :-
	loesche_akt_zaehler,
	assert(aktueller_zaehler(0)),
	fail
	;
	true.


  /*********/
 /* Flags */
/*********/

:- dynamic jaeinzelflag/1.
loesche_jaeinzelflag :- retract(jaeinzelflag(1)),fail ; true.
set_jaeinzelflag :- assert(jaeinzelflag(1)),!.

:- dynamic japartnerflag/1.
loesche_japartnerflag :- retract(japartnerflag(1)),fail ; true.
set_japartnerflag :- assert(japartnerflag(1)),!.

:- dynamic neinsommerflag/1.
loesche_neinsommerflag :- retract(neinsommerflag(1)),fail ; true.
set_neinsommerflag :- assert(neinsommerflag(1)),!.

:- dynamic neinoutdoorflag/1.
loesche_neinoutdoorflag :- retract(neinoutdoorflag(1)),fail ; true.
set_neinoutdoorflag :- assert(neinoutdoorflag(1)),!.

% japartnerflag und jaeinzelflag zuruecksetzen
loesche_flags :-
	loesche_jaeinzelflag,
	loesche_japartnerflag,
	loesche_neinsommerflag,
	loesche_neinoutdoorflag.


  /**************/
 /* Interviews */
/**************/

interview :-
	frageko(Context,Anfrage),
	ja_nein(Anfrage,Antwort),
	(   Antwort == ja,
	    merkeko(Context,2),
	    auswertung_ko(Context),
	    Context == partnersport,    set_japartnerflag
	 ;
	    Antwort == nein,
	    merkeko(Context,1),
	    auswertung_ko(Context),
	    (	Context == einzelsport, set_jaeinzelflag
	     ;	Context == sommersport, set_neinsommerflag
	     ;	Context == outdoor,     set_neinoutdoorflag
	    )
	),
	fail.
interview.


interview_verfeinerung :-
	frage(Context,Anfrage),
	eingabe_loop(Context,Anfrage,Antwort),
	merke_verfeinerung(Context,Antwort),
	fail.
interview_verfeinerung :- zeige_verfeinerung.

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
	fail
	;
	nl.

antwort(Context,Antwort) :- option(Context,Antwort,_),!.
antwort(_,_) :- write('=>  Antwort ungueltig.'),nl,nl,fail.


  /****************/
 /* Auswertungen */
/****************/

auswertung_ko(Context) :-
	% holen der relevanten Daten
	positionen_ko(Context,Pos),
	moegl_sportarten(Sportart),
	merkmale(Sportart,Komerkmale,_),
	pos_in_liste(Komerkmale,Pos,Element),
	kokriterien(Context, Antwort),
	
	(   Antwort == 2, /* ja */
	    (	Context == zuhause,
		Element == 1,
		retract(moegl_sportarten(Sportart)),
		dbg(['LOESCHE alles was nicht zuhause geht: ',Sportart]),nl
	    
	    ;   Context == partnersport,
		Element == 2,
		retract(moegl_sportarten(Sportart)),
		dbg(['LOESCHE alles was einen Partner benoetigt: ',Sportart]),nl
	    )
	
	;  Antwort == 1, /* nein */
	    
	    /* Sonderfall TEAMSPORT: hier entspricht 3 dem JA */
	    (	Context==teamsport,
		Element==3,
		retract(moegl_sportarten(Sportart)),
		dbg(['LOESCHE alle Teamsportarten: ',Sportart]),nl
	    
	    /* Kein Sport im Sommer => Wintersport => LOESCHE alle Sportarten mit sommer=ja und winter=nein */
	     ;  Context == sommersport,
		positionen_ko(wintersport,Poswinter),
		pos_in_liste(Komerkmale,Poswinter,Winterelem),
		Element == 2,
		Winterelem == 1,
	        retract(moegl_sportarten(Sportart)),
		dbg(['LOESCHE reine Sommersportarten: ',Sportart]),nl
	    
	    /* Kein Sport im Winter => Sommersport => LOESCHE alle Sportarten mit winter=ja und sommer=nein */
	     ;	Context == wintersport,
		positionen_ko(sommersport,Possommer),
		pos_in_liste(Komerkmale,Possommer,Sommerelem),
		Element == 2,
		Sommerelem == 1,
		retract(moegl_sportarten(Sportart)),
		dbg(['LOESCHE reine Wintersportarten: ',Sportart]),nl
	    
	    /* Kein Sport innendrinnen => aussendraussen => LOESCHE alle Sportarten mit indoor=ja und outdoor=nein */
	     ;  Context == indoor,
		positionen_ko(outdoor,Posoutdoor),
		pos_in_liste(Komerkmale,Posoutdoor,Outdoorelem),
		Element == 2,
		Outdoorelem == 1,
	        retract(moegl_sportarten(Sportart)),
		dbg(['LOESCHE alle reinen Indoorsportarten: ',Sportart]),nl
	    
	    /* Kein Sport aussendraussen => innendrinnen => LOESCHE alle Sportarten mit outdoor=ja und indoor=nein */
	     ;	Context == outdoor,
		positionen_ko(indoor,Posindoor),
		pos_in_liste(Komerkmale,Posindoor,Indoorelem),
		Element == 2,
		Indoorelem == 1,
		retract(moegl_sportarten(Sportart)),
		dbg(['LOESCHE alle reinen Outdoorsportarten: ',Sportart]),nl
	    
	    
	    /* fuer alle uebrigen Sportarten LOESCHE, wenn Eigenschaft vorhanden */
	     ;	Context \== teamsport,
		Context \== sommersport,
		Context \== wintersport,
		Context \== indoor,
		Context \== outdoor,
		Context \== zuhause, /* ab hier wird nur bei JA Antwort behandelt */
		Context \== partnersport,
	        Element == 2,
		retract(moegl_sportarten(Sportart)),
		dbg(['LOESCHE ',Context,': ',Sportart]),nl
	    )
	),
	fail
	;
	true.

auswertung_verfeinerung :-
	% holen der relevanten Daten
	moegl_sportarten(Sportart),
	merkmale(Sportart,_,Verfeinerungsmerkmale),
	positionen_verfeinerung(Context,Pos),
	pos_in_liste(Verfeinerungsmerkmale,Pos,Element),
	verfeinerung(Context,Antwort),
	
	% absolute Differenz zwischen Eigenschaft und Antwort berechnen
	Differenz is Element - Antwort,
	Differenz_abs is abs(Differenz),
	
	% aktuelle Gesamtabweichung abfragen und neue Differenz addieren
	bewertung(Sportart,Bisherigeabweichung),
	Abweichungssumme is Bisherigeabweichung + Differenz_abs,
	
	% alte Bewertung loeschen und neue speichern
	retract(bewertung(Sportart,Bisherigeabweichung)),
	assertz(bewertung(Sportart,Abweichungssumme)),
	
	%writeseq([Context,': ',Element,' - ',Antwort,' = ',Differenz_abs]),nl,   /* DEBUG */
	
	fail.
auswertung_verfeinerung.


anzeige_bewertung :-
	% Abbruch, falls bereits genug Antworten ausgegeben wurden
	aktueller_zaehler(X),
	auszugebende_antworten(Y),
	X >= Y,
	!.

anzeige_bewertung :-
	dekrement_ausgabe,
	anzeige_bewertung.


dekrement_ausgabe :-
	% Bewertung aller auszuwertenden Sportarten dekrementieren
	% und falls 0 erreicht wurde ausgeben und Zaehler erhoehen
	bewertung(Sportart,Wert),
	
	(   Wert == 0,
	    writeseq([' * ',Sportart]),nl,
	    
	    aktueller_zaehler(X1),
	    X2 is X1 + 1,
	    
	    retract(aktueller_zaehler(X1)),
	    assertz(aktueller_zaehler(X2))
	
	;   Wert \== 0
	),
	
	Tempwert is Wert - 1,
	
	retract(bewertung(Sportart,Wert)),
	assertz(bewertung(Sportart,Tempwert)),
	fail
	;
	true.


  /********/
 /* INIT */
/********/

% stellt einen definierten Ausgangszustand her
init :- wissensbasis(W),
	nl,nl,write('Willkommen zur'),nl,
	writeseq(['   "',W,'".']),nl,nl,
	loesche_kokriterien,
	loesche_verfeinerung,
	init_moegl_sportarten,
	init_akt_zaehler.

run :-
	init,
	interview,
	
	% v DEBUG v
	zeige_ko,
	zeige_moegl_sportarten,
	% ^ DEBUG ^
	
	interview_verfeinerung,
	
	% init erst hier, da wir moegl_sportarten/2 abfragen
	init_bewertungen,
	auswertung_verfeinerung,
	
	write('Wir empfehlen Ihnen folgende Sportarten:'),nl,
	anzeige_bewertung,nl,
	
	zeige_bewertungen,
	
	test_generierung.


test_generierung :-
	ja_nein('Soll auf Basis der Eingaben ein Test generiert werden?',Antwort),
	Antwort == ja,!,
	write('Symbolischen Name des Tests: '),
	read(Name),
	nl,
	generiere_ko(Name),
	generiere_verf(Name)
	;
	true.

generiere_ko(Name) :-
	kokriterien(C,A),
	writeseq(['ko_test(',Name,',',C,',',A,').']),nl,
	fail
	;
	true.

generiere_verf(Name) :-
	verfeinerung(C,A),
	writeseq(['verf_test(',Name,',',C,',',A,').']),nl,
	fail
	;
	true.

  /****************/
 /* TEST Routine */
/****************/

/* Aufruf z.B. mit: test(boxen). */
test(Typ) :-
	init,
	test_ko(Typ),
	
	/* DEBUG >> */
	zeige_ko,
	zeige_moegl_sportarten,
	/* << DEBUG */
	
	test_verfeinerung(Typ),
	zeige_verfeinerung,
	
	init_bewertungen,
	auswertung_verfeinerung,
	write('Wir empfehlen Ihnen folgende Sportarten:'),nl,
	anzeige_bewertung,nl,
	
	zeige_bewertungen.
	

test_ko(Typ) :-
	ko_test(Typ,Context,Antwort),
	merkeko(Context,Antwort),
	auswertung_ko(Context),
	fail
	;
	true.

test_verfeinerung(Typ) :-
	verf_test(Typ,Contextv,Antwortv),
	merke_verfeinerung(Contextv,Antwortv),
	fail
	;
	true.
