Contratti per lo UC "gestire menu" 
Pre-condizione generale: l'attore è identificato con un'instaza ch di chef 

1) predisponiMenu(titolo?:testo)
  - Pre-condizioni:
    - 
  - Post-condizioni:
    - È stata creata un'istanza _m_ di Menù 
    - [se è specificato un titolo] m.titolo = titolo 
    - _Ch_ **è proprietario** di _m_
    - _m.pubblicato_ = no

1c.1 scegliMenùPerCopia(menù: Menù)
  - Pre-condizione
    
  - Post-condizione
    - È stata creata un'istanza _m_ di menù 
    - M.titolo = menu.titolo
    - m.richiedeCuoco = menu.richiedeCuoco
    - M.buffet = menu.buffet
    - M.fingerFood = menu.fingerfood
    - m.richiestaCucina = menu.richiestaCucina
    - m.piattiCaldi = menu.piattiCaldi
    - m.pubblicato = no
    - Per ogni Sezione _sez_ tale che meniu contiene sez, è stata createa un'istanza s di Sezione tale che:
     - s.nome = sez.nome
     - m **contiene** s 
     - Per ogni Voce _voc_ tale che _voc_ appartiene a _sez_, e voc fa riferimento ad una Ricetta ric, è stata creata un'istanza _v_ di Voce tale che:
     - V.descrizione = voc.descrizione
     - v appartiene a m
     - v fa riferimento a ric
      - Per ogni Voce coc tale che appartiene a menu, e voce fa riferiemnto ad una ricetta ric, è stata creata un'istanza v di Voce tale che: 
        - v.descrizione = voc.descrizione
         - v appartiene a m 
         - v fa riferiemento a ric

  1a.1) eleminnaMenu(menù: testo)
    Pre-condizione: 
      - 
    Post-condizione: 
      - Se ch è proprietario di menu e menu non è in uso in alcun Evento
        - ogni sezione _sez_ tale che menù contiene _sez_:
          - per ogni voce _voc_ appartiene a _sez_, _voc_ è eliminata
          - _sez_ è eliminata
        - Ogni voce _voc_ tale che voc appartiene a menu è eliminata
        - Menù è eliminato 
    
2) definisciSezione(nome: testo)
  - Pre-condizioni:
    - È in corso la definizione di un Menù _m_

  - Post-condizioni:
    - È stata una seratta un'istanza 
    - sez.nome = nome
    - m **contiente** sez 

3) consultaInfoEvent()
    - Pre-condizioni 
      -  
    - Post-condizioni
      - 