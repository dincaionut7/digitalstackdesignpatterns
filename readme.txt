Design patterns folosite:

Factory ( pentru socketuri, o solutie pentru a ascunde eventuale detalii pentru socketuri custom, ex: implementat un layer pentru clienti deasupra la socketuri)
singelton (pentru un singur socket factory in clasa statica )
command pattern ( sa separam logica si detaliile de cand se apeleaza si cum pentru diverse functionalitati)

further instructions:
	eu am copiat proiectul de 2 ori si am deschis 2 proiecte in intellij, run config > application > unu cu clasa SimpleServer pt server si unul cu 
	clasa SimpleClient pentru client

	in clasa SimpleClient > main() -> comment/ uncomment la comenzi. :)