import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static boolean mode = true;

    public static void main (String[] jdhfb) throws NoDescription {
        Area somewhere = new Area();
        Area sandPlace = new Area("песчаная площадка", AreaType.SHORE);
        sandPlace.setDescription("усеянна ракушками - потаённое место плясок морских русалок.");
        Area islandOtherSide = new Area("другая сторона острова");
        Area clefts = new Area("таинственные темные расщелины", AreaType.MOUNTAIN);
        clefts.setPassable(false);
        Area onePlace = new Area("одни места");
        Area otherPlace = new Area("другие места");
        Area smallHole = new Area("небольшой грот", AreaType.MOUNTAIN);
        Area bigHole = new Area("громадные котлы", AreaType.MOUNTAIN);
        bigHole.setPassable(false);
        Area mostHightRock = new Area("вершина самой высокой скалы", AreaType.MOUNTAIN);
        Area island = new Area("остров");
        Area there = new Area("вон там");
        Area canyon = new Area("ущелье", AreaType.MOUNTAIN);
        ArrayList<Area> areasForMap = new ArrayList<>();
        areasForMap.add(sandPlace);
        areasForMap.add(clefts);
        areasForMap.add(smallHole);
        areasForMap.add(bigHole);
        areasForMap.add(mostHightRock);
        areasForMap.add(canyon);
        Map map;
        System.out.println("Веберите режим: история/управление(и/у)");
        Scanner in = new Scanner(System.in);
        String pMode = in.nextLine();
        if(pMode.equalsIgnoreCase("и")){
            mode = false;
        }
        if(mode){
            map = new Map(areasForMap, 16, GenerationType.ISLAND);
        }

        Thing waterTurn = new Thing("водовороты");
        Thing wreckage = new Thing("всякое добро и обломки потерпевших крушение кораблей");
        Thing hat = new Thing("шляпа Снусмумрика");
        Thing lightning = new Thing("молния");
        Thing parts = new Thing("обе половины");
        Thing lightningWay = new Thing("путь молнии");
        Thing otherStripe = new Thing("другая светлая и блестящая полоска");
        Thing gold = new Thing("золото");
        class Rocks{
            Thing firstRocks = new Thing("утёсы");
            Thing secondRocks = new Thing("утёсы");
            Thing cliff = new Thing("скала");
            Thing largeBoulder = new Thing("большущая каменная глыба");

            public Rocks() {
                firstRocks.setArea(onePlace);
                secondRocks.setArea(otherPlace);
                cliff.setArea(sandPlace);
            }
        }
        Rocks rocks = new Rocks();


        Mumi mumiMom = new Mumi("Муми-мама", Gender.FEMALE);
        mumiMom.setArea(somewhere);
        Mumi snork = new Mumi("Снорк", Gender.MALE);
        if(mode){
            snork.setArea(mostHightRock);
        }else {
            snork.setArea(somewhere);
        }
        Mumi sniff = new Mumi("Снифф", Gender.MALE);
        Mumi hemul = new Mumi("Хемуль", Gender.MALE);

        Plant seaPinks = new Plant("морские гвоздики", Size.BIG, true);
        Plant wildOast = new Plant("дикий овёс", Size.SMALL);
        seaPinks.setArea(sandPlace);
        wildOast.setArea(sandPlace);

        Wind wind = new Wind("ветер");
        wind.setArea(sandPlace);
        wind.setVisible(false);

        UncownCreature they = new UncownCreature("Они");
        they.setCount(Count.SEVERAL);

        Sea sea = new Sea();

        PrimevalRock primevalRocks = new PrimevalRock("первозданные скалы");
        primevalRocks.setArea(islandOtherSide);

        Surf surf = new Surf("прибой");
        surf.setVisible(false);
        surf.setArea(mostHightRock);

        if(mode){
            String command = in.nextLine();
            for(;!command.equalsIgnoreCase("выход");){
                if(command.equalsIgnoreCase("оглядеться")) {
                    snork.lookAround();
                }
                if(command.equalsIgnoreCase("Идти на север")) {
                    snork.moveToArea(AreaPart.NORTH);
                }
                if(command.equalsIgnoreCase("Идти на юг")) {
                    snork.moveToArea(AreaPart.SOUTH);
                }
                if(command.equalsIgnoreCase("Идти на запад")) {
                    snork.moveToArea(AreaPart.WEST);
                }
                if(command.equalsIgnoreCase("Идти на восток")) {
                    snork.moveToArea(AreaPart.EAST);
                }
                command = in.nextLine();
            }
        }else {
            they.make("так");
            islandOtherSide.show("На", TextPosition.BEFORE);
            primevalRocks.rise();
            sandPlace.show("Там можно было найти", TextPosition.BEFORE);
            sandPlace.showDescription();
            clefts.show("В", TextPosition.BEFORE);
            Surf.Beats beats = new Surf.Beats("гулко, словно в железную дверь.");
            beats.makeBeat(surf);
            onePlace.show("В", TextPosition.BEFORE);
            ((Thing) onePlace.getObjects().get(0)).show("среди", TextPosition.BEFORE);
            smallHole.show("мог открыться", TextPosition.BEFORE);
            endLine(".");
            otherPlace.show("В", TextPosition.BEFORE);
            rocks.firstRocks.action("круто обрывались вниз, образуя " + bigHole.getName());
            endLine(".");
            bigHole.show("В", TextPosition.BEFORE);
            waterTurn.action("шипели и бурлили");
            endLine(".");
            sea.through(sandPlace, wreckage);
            they.split();
            they.goLookingFor(null, null, true);
            mumiMom.goLookingFor(sandPlace, wreckage, false);
            seaPinks.grow();
            wildOast.grow();
            wind.blow();
            mumiMom.lieNear(rocks.cliff);
            mumiMom.see();
            seaPinks.wobble();
            mumiMom.think("Полежу здесь совсем немножко");
            mumiMom.sleep();
            snork.moveToArea(mostHightRock);
            snork.lookAround();
            island.show("распахнулся перед ним от побережья до побережья и казался букетом цветов, плывущим по неспокойному морю", TextPosition.AFTER);
            endLine(".");
            there.show("виднеется маленькая движущаяся точка", TextPosition.AFTER);
            sniff.show("это", TextPosition.BEFORE);
            endLine(".");
            sniff.action("ищет обломки кораблекрушения");
            endLine(".");
            there.show("", TextPosition.AFTER);
            hat.action("мелькнула");
            endLine(".");
            there.show("", TextPosition.AFTER);
            hemul.action("выкапывает особо редкую разновидность венерина башмачка");
            endLine(".");
            there.show("- ", TextPosition.AFTER);
            Showable insert = new Showable() {
                @Override
                public void show(String s, TextPosition pos) {
                    System.out.printf("%1$s", s);
                }
            };
            insert.show("это как дважды два четыре", null);
            there.show("-", TextPosition.BEFORE);
            lightning.action("ударила");
            endLine(".");
            rocks.largeBoulder.show(", больше, чем десять Муми-домов, вместе взятых,", TextPosition.AFTER);
            rocks.largeBoulder.action("раскололась, словно яблоко");
            parts.action("раздались в стороны, образовав ущелье с отвесными стенами");
            endLine("...");
            snork.moveToArea(canyon);
            snork.lookAround();
            there.show("", TextPosition.AFTER);
            lightning.action("прошла");
            endLine(".");
            lightningWay.action("обозначился извилистой черной как уголь линией");
            endLine(".");
            otherStripe.action("бежала рядом с ней");
            endLine(".");
            gold.show("Это было", TextPosition.BEFORE);
            gold.show(", ничто иное как", TextPosition.BEFORE);
            endLine("!");
        }
    }

    public static void endLine(String s){
        System.out.printf("%1$s \n", s);
    }
}
