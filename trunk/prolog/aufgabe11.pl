% This buffer is for notes you don't want to save.
% If you want to create a file, visit that file with C-x C-f,
% then enter the text in that file's own buffer.

p1(['Timmy', 'Tino', 'a', 'b']).
p2(['Mischa', 'Max']).	

anhaengen([],Liste,Liste).

anhaengen([Kopf|Rest],Liste,[Kopf|Ergebnis]):-
     anhaengen(Rest,Liste,Ergebnis).

anhaengen(E,Liste,[E|Liste]).

inArsch([],E,[E]).

inArsch([Kopf|Rest],E,[Kopf|Ergebnis]):-
	inArsch(Rest,E,Ergebnis).

run2 :- p1(X), inArsch(X,'am Ende',Erg), write(Erg), nl.

run :- p2(A), anhaengen('Test',A,Erg), write(Erg), nl,
       p1(B), anhaengen(B, Erg, Erg2), write(Erg2), nl.
  
