# Coffee Machine

Eine Kaffeemaschine wird über eine Fernbedienung mit Kommandos gesteuert. Als Kommandos
stehen BREW und CLEAN zur Verfügung. Das Kommando BREW startet nachfolgenden Prozess.
Eine Kaffeemaschine hat fünf Behälter für (i) Kaffeebohnen, (ii) Kaffeemehl, (iii) Wasser, (iv) Brühvorgang
und (v) Abfall. Der Behälter für Kaffeebohnen wird durch eine 2-dimensionale Matrix mit
20 Zeilen und 5 Spalten (Kapazität von 100 Bohnen) dargestellt. Der Behälter Kaffeemehl wird
durch eine 2-dimensionale Matrix mit fünf Zeilen und zehn Spalten (Kapazität von 50 Zeichen F)
dargestellt. Eine gemahlene Bohne ergibt fünf F. Um den Behälter Kaffeemehl zu befüllen sind
demnach zehn Bohnen notwendig. Das Mahlen einer Bohne dauert 200 Millisekunden. Der
Behälter für Kaffeemehl wird von unten nach oben aufgefüllt. Der Behälter mit Wasser wird durch
eine 2-dimensionale Matrix mit 25 Zeilen und 20 Spalten (Kapazität von 500 Einheiten Wasser)
dargestellt. Standardmäßig ist der Behälter Wasser mit 500 Zeichen W befüllt. Der Behälter mit
Wasser beobachtet kontinuierlich den Füllgrad des Behälters mit Kaffeemehl. Sobald der Behälter
mit dem Kaffeemehl vollständig befüllt ist, wird das Wasser innerhalb von 5 Sekunden erhitzt. Beim
Erhitzen verändern sich pro Sekunde 100 Zeichen W in 100 Zeichen H. Der Behälter Brühvorgang
(Kapazität von 550 Einheiten) beobachtet den Behälter Wasser. Sobald das Wasser erhitzt wurde,
wird das Kaffeemehl (50 Einheiten F) und das Wasser (500 Einheiten H) in den Behälter Brühvorgang
übernommen und vermischt (shuffle). Pro Sekunde verändert eine Einheit F entsprechend
zehn Einheiten H in zehn Einheiten C. Nachdem der Brühvorgang abgeschlossen ist, wird das
Gemisch gefiltert. Der Filter trennt das Gemisch in zwei Kanäle auf. Im ersten Kanal befinden sich
die Einheiten F, welche in dem Behälter (v) aufgenommen werden. Im zweiten Kanal befinden sich
die Zeichen C, welche in einer Tasse aufgenommen werden. Das Kommando CLEAN leert den
Behälter (v).
