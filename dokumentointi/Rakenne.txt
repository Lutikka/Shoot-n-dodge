Perus ideana rakenteessa on pitää pelilogiikka ja käyttöliittymä erillään
tai helposti eroteltavissa tarvittaessa. Main luokka hoitaa perus peliloopin pyörittämisen ja yhdistää ja konstruktoi kaikki tarvittavat luokat toisiinsa initialisoitaessa.

Syöte menee MyGraphicsin JFramesta suoraan Input luokkaan ja sieltä keybindsin kautta se tekee asioita pelissä. 

Pelissä olevat objektit piirtävät itsensä draw metodia kutsuttaessa