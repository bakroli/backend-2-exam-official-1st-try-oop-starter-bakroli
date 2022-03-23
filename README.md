# Bútorbolt

Ebben a feladatban egy bútorboltot kell modelezned ahol csak ágyakat lehet kapni.

Minden osztályodat a `hu.nive.ujratervezes.furnitureshop` packagben kell létrehozni.

A `Main` osztály `main` metódusában próbálhatod ki a kódodat, illetve használd az előre megírt teszteseteket az
algoritmusod kipróbálására!

## Feladatleírás

Implementáld az alábbi leírás szerinti programot:

### hu.nive.ujratervezes.furnitureshop.Bed

Tulajdonságai:

- `BedType type` ami az ágy típusa. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy getter.
- `double bedFramePrice` ami az ágykeret ára. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy
  getter.
- `List<Mattress> mattressList` ami az ágyhoz tartozó matracok listája. Konstruktor segítségével beállítható kell
  legyen. Tartozik hozzá egy getter. Metódusai:
- `double getPrice()` ami az ágykeret és a matracok árának teljes összegét adja vissza.

### hu.nive.ujratervezes.furnitureshop.BedType

Egy enum ami a `TWIN` és a `KING` értékeket veheti fel. Ennek az enumnak van egy `int width` változója, amiben tárolja
hogy a különböző típusú ágyak milyen szélesek és ez az adat getterrel lekérdezhető. (Twin:90 cm, King:180 cm)

### hu.nive.ujratervezes.furnitureshop.TwinBed

Az összes `TwinBed` egyben `Bed` is és BedType típusú változója mindig `TWIN` értéket kap.
Konstruktora kötelezően az ágykeret árát, és egy SingleMattress példányt vár el.

### hu.nive.ujratervezes.furnitureshop.KingBed

Az összes `KingBed` egyben `Bed` is és BedType típusú változója mindig `KING` értéket kap. Konstruktora kötelezően vagy
két darab SingleMattress példányt vagy egy DoubleMattress példányt vár el, és az ágykeret árát.

### hu.nive.ujratervezes.furnitureshop.Mattress

Tulajdonságai:

- `double price` ami a matrac ára. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy getter.
- `int width` ami a matrac szélessége. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy getter.

### hu.nive.ujratervezes.furnitureshop.SingleMattress

Az összes `SingleMattress` egyben `Mattress` is és a szélessége mindig 90 cm.

### hu.nive.ujratervezes.furnitureshop.DoubleMattress

Az összes `DoubleMattress` egyben `Mattress` is és a szélessége mindig 180 cm.

### hu.nive.ujratervezes.furnitureshop.FurnitureShop

Tulajdonsága:

- `List<Bed> bedList` a boltban megvásárolható ágyak listája. Tartozik hozzá egy getter.

Metodusai:

- `double calculateAveragePriceOfBeds()` vissza adja az átlag árát az elérhető ágyaknak.
- `int countAvailableBeds()` vissza adja, hogy hány darab elérhető ágy van a boltban.
- `List<Bed> getListOfBedsByType(BedType type)` vissza adja a bolt paraméterben meghatározott típusú ágyait.
  boltban.
- `void addNewBed(Bed bed)` a paraméterben kapott ágyat hozzá adja a bolt listájához.
- `void removeBed(Bed bed)` a paraméterben kapott ágyat eltávolítja a bolt listájáról.

## Pontozás

Egy feladatra 0 pontot ér, ha:

- nem fordul le
- lefordul, de egy teszteset sem fut le sikeresen.
- ha a forráskód olvashatatlan, nem felel meg a konvencióknak, nem követi a clean code alapelveket.

0 pont adandó továbbá, ha:

- kielégíti a teszteseteket, de a szöveges követelményeknek nem felel meg

Pontokat a további működési funkciók megfelelősségének arányában kell adni a vizsgafeladatra:

- 5 pont: az adott projekt lefordul, néhány teszteset sikeresen lefut, és ezek funkcionálisan is helyesek. Azonban több
  teszteset nem fut le, és a kód is olvashatatlan.
- 10 pont: a projekt lefordul, a tesztesetek legtöbbje lefut, ezek funkcionálisan is helyesek, és a clean code elvek
  nagyrészt betartásra kerültek.
- 20 pont: ha a projekt lefordul, a tesztesetek lefutnak, funkcionálisan helyesek, és csak apróbb funkcionális vagy
  clean code hibák szerepelnek a megoldásban.

Gyakorlati pontozás a project feladatokhoz:

- Alap pontszám egy feladatra(max 20): lefutó egység tesztek száma / összes egység tesztek száma * 20, feltéve, hogy a
  megoldás a szövegben megfogalmazott feladatot valósítja meg
- Clean kód, programozási elvek, bevett gyakorlat, kód formázás megsértéséért - pontlevonás jár. Szintén pontlevonás
  jár, ha valaki a feladatot nem a leghatékonyabb módszerrel oldja meg - amennyiben ez értelmezhető.