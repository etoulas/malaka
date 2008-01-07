wissensbasis('Beratung zur Wahl eines Freizeitsports').

auszugebende_antworten(3).
debug_aktiv(ja).

/*
'Sportarten'
KO:
'Schwimmen','Einzelsport','Partner benoetigt','Teamsport','Ballsport','Sommer','Winter','Outdoor','Indoor','Zuhause',
Rest:
'1-Ausdauer','2-Kraft','3-Verletzungsgef.','4-Zeitfakt.','5-Koordination','6-Finanzaufw. 1x','7-Finanz. Contin.','8-Familientaugl.','9-Sozialer Asp.','10-Präzision','11-Wettkampfbereitsch.'
*/
beschreibung('Sportart','Schwimmen','Einzelsport','Partner benoetigt','Teamsport','Ballsport','Sommer','Winter','Outdoor','Indoor','Zuhause',
	     'Ausdauer','Kraft','Verletzungsgef.','Zeitfakt.','Koordination','Finanzaufw. 1x','Finanz. Contin.','Familientaugl.','Sozialer Asp.','Präzision','Wettkampfbereitsch.').
merkmale('Schach',[1,1,2,1,1,2,2,2,2,2],[1,1,1,1,1,1,2,3,2,1,4]).
merkmale('Darten',[1,1,2,1,1,2,2,1,2,2],[1,1,1,1,1,1,2,3,3,4,3]).
merkmale('Schiessen',[1,2,1,1,1,2,2,2,2,2],[1,1,1,1,1,2,2,3,3,4,2]).
merkmale('Billard',[1,1,1,2,1,2,2,1,2,2],[1,1,1,1,1,2,2,3,3,4,3]).
merkmale('Reiten',[1,2,1,1,1,2,2,2,2,1],[2,2,3,2,1,3,4,3,2,1,1]).
merkmale('Laufen',[1,2,1,1,1,2,2,2,2,2],[3,2,2,2,1,2,1,3,1,1,2]).
merkmale('Radfahren',[1,2,1,1,1,2,1,2,1,1],[3,2,2,2,1,3,1,3,2,1,2]).
merkmale('Bowling/Kegeln',[1,1,1,2,2,2,2,1,2,1],[1,1,1,1,2,2,2,3,3,3,3]).
merkmale('Tauchen',[2,1,2,1,1,2,1,2,2,1],[1,1,2,2,2,4,3,3,2,1,1]).
merkmale('Golf',[1,2,1,1,1,2,1,2,1,1],[1,1,1,2,2,4,4,3,4,3,3]).
merkmale('Schwimmen',[2,2,1,1,1,2,2,2,2,1],[2,1,1,2,2,1,2,3,2,1,2]).
merkmale('Tischtennis',[1,1,2,2,2,2,2,2,2,2],[2,1,1,2,2,2,2,3,3,4,3]).
merkmale('Eisstockschiessen',[1,1,1,2,1,1,2,2,1,1],[2,1,1,1,2,2,1,3,4,2,2]).
merkmale('Gleitschirm/Fallschirm/Drachenfliegen',[1,2,1,1,1,2,1,2,1,1],[2,2,3,3,2,4,4,1,1,2,1]).
merkmale('Segeln',[2,1,1,2,1,2,2,2,1,1],[2,3,2,3,2,4,4,3,2,1,2]).
merkmale('Faustball',[1,1,1,3,2,2,2,1,2,1],[3,1,2,4,2,2,2,1,4,3,3]).
merkmale('Rudern',[2,1,1,2,1,2,2,2,1,1],[4,3,2,3,2,3,2,2,3,1,3]).
merkmale('Tanzen',[1,1,2,1,1,2,2,1,2,2],[2,1,1,1,3,2,3,2,4,1,2]).
merkmale('Yoga',[1,2,1,1,1,2,2,2,2,2],[2,2,1,2,3,1,2,3,2,1,1]).
merkmale('Schlittschufahren',[1,2,1,1,1,1,2,2,2,1],[2,2,2,1,3,2,2,3,2,1,1]).
merkmale('Taekwondo/Aikido',[1,1,2,1,1,2,2,1,2,1],[2,2,2,2,3,2,2,2,2,2,3]).
merkmale('Volleyball',[1,1,1,3,2,2,2,2,2,1],[2,2,2,4,3,2,2,2,4,3,3]).
merkmale('Windsurfen',[2,2,1,1,1,2,1,2,1,1],[2,2,2,3,3,3,2,2,1,1,1]).
merkmale('Aerobic',[1,2,1,1,1,2,2,2,2,2],[3,1,1,2,3,1,2,1,2,1,1]).
merkmale('Badminton',[1,1,2,2,2,2,2,2,2,1],[3,1,2,2,3,2,2,2,3,3,3]).
merkmale('Inline',[1,2,1,1,1,2,1,2,2,1],[3,2,3,2,3,2,1,3,2,1,1]).
merkmale('Tennis',[1,1,2,2,2,2,2,2,2,1],[3,2,2,2,3,2,2,2,3,3,3]).

merkmale('Fussball',[1,1,1,3,2,2,2,2,2,1],[3,2,3,4,3,2,2,1,4,3,3]).

merkmale('Streethockey',[1,1,1,3,2,2,2,2,2,1],[3,2,3,2,3,3,2,2,3,3,3]).
merkmale('Judo/Ju-Jutsu/Karate',[1,1,2,1,1,2,2,1,2,2],[3,3,3,2,3,2,2,2,2,1,3]).
merkmale('Squash',[1,1,2,1,2,2,2,1,2,1],[3,3,3,2,3,2,2,1,2,3,3]).
merkmale('Rugby',[1,1,1,3,2,2,2,2,1,1],[3,3,4,2,3,2,2,1,3,3,3]).
merkmale('Klettern',[1,1,2,1,1,2,2,2,2,1],[3,4,3,3,3,2,3,3,2,1,1]).
merkmale('Boxen',[1,1,2,1,1,2,2,1,2,1],[4,4,4,4,3,2,2,1,2,2,4]).
merkmale('Wasserball',[2,1,1,3,2,2,2,2,2,1],[4,3,2,2,3,1,2,1,4,3,3]).
merkmale('Tai Ji',[1,2,1,1,1,2,2,2,2,2],[2,1,1,2,4,2,2,1,2,1,1]).
merkmale('Skateboard',[1,2,1,1,1,2,1,2,2,1],[2,1,3,2,4,2,1,1,4,1,2]).
merkmale('Turnen',[1,2,1,1,1,2,2,1,2,1],[2,2,3,2,4,2,2,2,2,3,2]).
merkmale('Ballet',[1,1,2,1,1,2,2,1,2,1],[3,2,1,4,4,1,4,1,2,3,1]).
merkmale('Leichtathletik',[1,2,1,1,1,2,2,2,2,1],[3,2,2,2,4,2,2,2,2,2,3]).
merkmale('Basketball',[1,1,1,3,2,2,2,2,2,2],[3,2,3,4,4,2,2,2,4,4,3]).
merkmale('Icehockey',[1,1,1,3,2,1,2,2,2,1],[3,2,3,4,4,3,2,2,3,4,3]).
merkmale('Handball',[1,1,1,3,2,2,2,1,2,1],[3,3,3,4,4,2,2,1,4,3,3]).


/* Zuordnung der KO-Fragen Kontexte zu Listenpositionen */
positionen_ko(schwimmen,   1).
positionen_ko(einzelsport, 2).
positionen_ko(partnersport,3).
positionen_ko(teamsport,   4).
positionen_ko(ballsport,   5).
positionen_ko(sommersport, 6).
positionen_ko(wintersport, 7).
positionen_ko(outdoor,     8).
positionen_ko(indoor,      9).
positionen_ko(zuhause,    10).


/* Zuordnung der Verfeirungsfragen Kontexte zu Listenpositionen */
positionen_verfeinerung(ausdauer,1,maximum).
positionen_verfeinerung(kraft,2,maximum).
positionen_verfeinerung(verletzungsrisiko,3,maximum).
positionen_verfeinerung(zeitfaktor,4,maximum).
positionen_verfeinerung(koordination,5,maximum).
positionen_verfeinerung(finanzieller_aspekt_einmalig,6,maximum).
positionen_verfeinerung(finanzieller_aspekt_laufend,7,maximum).
positionen_verfeinerung(familientauglichkeit,8,abweichung).
positionen_verfeinerung(sozialer_aspekt,9,abweichung).
positionen_verfeinerung(praezision,10,maximum).
positionen_verfeinerung(wettkampfbereitschaft,11,abweichung).


/* 10 KO-Fragen */
frageko(schwimmen,   'Wuerde Wassersport fuer Sie in Frage kommen?').
frageko(einzelsport, 'Kommt es fuer Sie in Frage alleine Sport zu machen?').
frageko(partnersport,'Stoert es Sie zur Ausuebung der Sportart einen Partner suchen zu muessen?').
frageko(teamsport,   'Wuerden Sie auch einen Teamsport betreiben?').
frageko(ballsport,   'Moegen Sie Ballsport?').
frageko(sommersport, 'Moechten Sie im Sommer Sport treiben?').
frageko(wintersport, 'Moechten Sie auch im Winter Sport treiben?').
frageko(outdoor,     'Moechten Sie im Freien Sport treiben?').
frageko(indoor,      'Moechten Sie auch in einem Gebaeude Sport treiben?').
frageko(zuhause,     'Moechten Sie ausschliesslich zuhause Sport treiben?').


/* 11 Verfeinerungsfragen */
frage(ausdauer,'Wie schaetzen Sie ihre Ausdauer ein?').
frage(kraft,'Wie schaetzen Sie ihre Kraft ein?').
frage(verletzungsrisiko,'Inwieweit sind Sie bereit Verletzungen in Kauf zu nehmen?').
frage(zeitfaktor,'Wieviel Zeit wollen Sie in Ihre sportliche Aktivitaet investieren?').
frage(koordination,'Wie ist es um ihr Koordinationsvermoegen bestellt?').
frage(finanzieller_aspekt_einmalig,'Wieviel moechten Sie für die Ausruestung maximal ausgeben?').
frage(finanzieller_aspekt_laufend,'Wie hoch duerfen die laufenden Kosten pro Monat maximal sein?').
frage(familientauglichkeit,'Wieviel Wert legen Sie darauf die Sportart im Kreise der Familie betreiben zu koennen?').
frage(sozialer_aspekt,'Was beschreibt Sie am Besten?').
frage(praezision,'Wie schaetzen Sie ihre Praezision ein?').
frage(wettkampfbereitschaft,'Wie gerne messen Sie sich mit anderen?').


/* Optionen fuer Verfeinerungsfragen */
option(familientauglichkeit,1,'keinen').
option(familientauglichkeit,2,'wenig').
option(familientauglichkeit,3,'viel').

option(verletzungsrisiko,1,'gar nicht').
option(verletzungsrisiko,2,'wenig').
option(verletzungsrisiko,3,'ich kann damit leben').
option(verletzungsrisiko,4,'bring it on').

option(zeitfaktor,1,'sporadisch').
option(zeitfaktor,2,'1x pro Woche').
option(zeitfaktor,3,'2x pro Woche').
option(zeitfaktor,4,'mehr als 2x pro Woche').

option(wettkampfbereitschaft,1,'ungern').
option(wettkampfbereitschaft,2,'nur wenn es sein muss').
option(wettkampfbereitschaft,3,'ich mag Herausforderungen').
option(wettkampfbereitschaft,4,'ich zeig gern, dass ich der Beste bin').

option(sozialer_aspekt,1,'Ich bin gern fuer mich alleine.').
option(sozialer_aspekt,2,'Ein bisschen Gesellschaft kann nicht schaden.').
option(sozialer_aspekt,3,'Ich fuehle mich wohl unter Menschen.').
option(sozialer_aspekt,4,'Ohne Gesellschaft fuehle ich mich nicht vollstaendig.').

option(finanzieller_aspekt_einmalig,1,'< 100 EUR').
option(finanzieller_aspekt_einmalig,2,'< 500 EUR').
option(finanzieller_aspekt_einmalig,3,'< 1000 EUR').
option(finanzieller_aspekt_einmalig,4,'> 1000 EUR').

option(finanzieller_aspekt_laufend,1,'keine').
option(finanzieller_aspekt_laufend,2,'< 10 EUR').
option(finanzieller_aspekt_laufend,3,'< 30 EUR').
option(finanzieller_aspekt_laufend,4,'> 30 EUR').

option(kraft,1,'Ich bin eher schwach.').
option(kraft,2,'Ich bin maessig kraeftig.').
option(kraft,3,'Ich bin kraeftig.').
option(kraft,4,'Ich bin sehr kraeftig.').

option(ausdauer,1,'Treppensteigen macht mich fertig.').
option(ausdauer,2,'Kuerzere Strecken gehe ich zu Fuss.').
option(ausdauer,3,'Ich kann laengere Strecken laufen.').
option(ausdauer,4,'Ich bin ausdauernder Sportler.').

option(koordination,1,'Ich bin eher unkoordiniert.').
option(koordination,2,'Ich bin maessig koordiniert.').
option(koordination,3,'Ich habe eine gute Koordination.').
option(koordination,4,'Ich habe eine ausserordentlich gute Koordination.').

option(praezision,1,'Ich bin eher unpraezise.').
option(praezision,2,'Ich bin maessig praezise.').
option(praezision,3,'Ich habe eine gute Praezision.').
option(praezision,4,'Ich habe eine ausserordentlich gute Praezision.').



