/* Aufgabe 11 - Seite 39 */

/* Teillisten */
p1(['Timmy','Tino']).
p2(['Mischa','Max']).
z([0,1,2,3,4,5]).

/* Liste mittels append/3 */
p(L) :- p1(X),p2(Y),append(X,Y,L), !.


/* LISTE 4 - Seite 39 - Liste an Liste anhaengen
 * append(Liste1, Liste2, Erg).
 */
append([],Liste,Liste).

append([Kopf|Rest],Liste,[Kopf|Ergebnis]) :-
     append(Rest,Liste,Ergebnis).


/* a) Element an Liste voransetzen */
append(Kopf,Rest,[Kopf|Rest]).

runa :- p(L),append('Erster',L,Erg),
	write(Erg),nl.


/* b) Element hinten anfuegen 
 * last(Liste, Elem, Erg).
 */
last([],Elem,[Elem]). % Element als Liste ins Ergebnis kopieren

last([Kopf|Rest],Elem,[Kopf|Ergebnis]) :-
	last(Rest,Elem,Ergebnis).

runb :- p2(L),last(L,'Letzter',Erg),
	write(Erg),nl.


/* c) n-tes Element ausgeben
 * pos(Liste, Stelle).
 */
pos([],_,_) :- write('Nichts gefunden.'),nl, fail.

pos([Kopf|_], Stelle, Stelle) :-
	write(Stelle),write(' '),write(Kopf),nl.

pos([_|Rest], Stelle, Iter) :-
	Next is Iter + 1,
	pos(Rest,Stelle,Next), !.

/* Implementierung mit IF
pos([Kopf|Rest], Stelle, Iter) :-
	(   Iter =:= Stelle,
	    write(Iter),write(' '),write(Kopf),nl
	  ; Next is Iter + 1,
	    pos(Rest, Stelle, Next), !
	).
*/

pos(Liste, Stelle) :-
	pos(Liste, Stelle, 1).

runc :- p(L),pos(L, 2),pos(L,4),pos(L,5).


/* d) Deklarativ erklaeren
 * element(X,L) :- append(_,[X|_],L).
 * ist_letztes_element(X,L) :- append(_,[X],L).
 */
element(X,L) :- append(_,[X|_],L).

element2(X,[X|_]) :- write(X),write(' ist Element in Liste.'),nl.
element2(X,[_|Rest]) :-
	element2(X,Rest).

ist_letztes_element(X,L) :-
	append(_,[X],L).

isLast(X,[X]) :- write(X),write(' ist letztes Element in Liste.').
isLast(X,[_|Rest]) :-
	isLast(X,Rest).

rund :- p(L),
	element2('Mischa',L),
	isLast('Max',L).

/* g) Zahlen einer Liste summieren ohne Akkumulator
 * sum(Liste, Erg).
 *
 */
/* dynamische Praedikate */
:- dynamic summe/1.
summe(0).

sum([], Summe) :-
	summe(S),
	Summe is S.

sum([Kopf|Rest], Summe) :-
	summe(S),
	Sneu is S + Kopf,
	retract(summe(S)),
	assert(summe(Sneu)),
	sum(Rest, Summe).

rung :- summe(X),
	retract(summe(X)),
	assert(summe(0)),
	z(L),
	sum(L,Erg),
	write(Erg),nl.
