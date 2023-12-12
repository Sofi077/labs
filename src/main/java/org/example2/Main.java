package org.example2;

import org.example.OurContainer;
import org.fpm.di.Container;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        OurContainer pico = new OurContainer();
        pico.bind(ArrayList.class);
        List list = pico.getComponent(ArrayList.class);

        //Цей код робить те саме, що й це:
        //List list = new ArrayList();

        System.out.println("-------------------------------------------");

        //кешування
        OurContainer pico1 = new OurContainer();
        pico1.bind(Apple.class);
        Apple a1 = pico1.getComponent(Apple.class);
        Apple a2 = pico1.getComponent(Apple.class); // різні екземпляри
        System.out.println("різні");
        System.out.println(a1);
        System.out.println(a2);


        OurContainer pico2 = new OurContainer();
        pico2.bind(SingletonAplle.class);
        SingletonAplle a3 = pico2.getComponent(SingletonAplle.class);
        SingletonAplle a4 = pico2.getComponent(SingletonAplle.class); // обидва ті самі екземпляри
        System.out.println("однакові");
        System.out.println(a3);
        System.out.println(a4);
        System.out.println("-------------------------------------------");


//        OurContainer cont = new OurContainer();
//        cont.bind(Apple.class);
//        cont.bind(Juicer.class);
//        cont.bind(Peeler.class);
//
//        Juicer juicer = (Juicer) cont.getComponent(Juicer.class);
//        System.out.println(juicer);
//
//
        System.out.println("-------------------------------------------");

        OurContainer x = new OurContainer();
        x.bind(Apple.class);
        OurContainer y = new OurContainer( x );
        y.bind(Juicer.class);
        OurContainer z = new OurContainer( y );
        z.bind(Peeler.class);

        Peeler peeler = (Peeler) z.getComponent(Peeler.class);
        //peeler = (Peeler) x.getComponent(Peeler.class); // не працюватиме!
        Juicer juicer1 =  z.getComponent(Juicer.class);
        System.out.println(juicer1);

        System.out.println("-------------------------------------------");
//
//
//
//        //прив'язка класу до його реалізації
//        OurContainer binder = new OurContainer();
//        binder.bind(Apple.class, Pear.class);
//        binder.bind(Pear.class, new Pear()); //однакові будуть
//        //binder.bind(Pear.class);  //так різні
//
//        //коли буде викликано метод getComponent(Apple.class) в контейнері,
//        //буде повернуто екземпляр Pear,
//        //оскільки клас Apple має залежність від класу Pear
//
//        Apple e1 = binder.getComponent(Apple.class);
//        System.out.println(e1);
//        Pear e2 = binder.getComponent(Pear.class);
//        System.out.println(e2);
//
//        System.out.println("-------------------------------------------");
//        //прив'язка класу до його екземпляру
//        Apple appleInstance = new Apple();
//
//        OurContainer binder2 = new OurContainer();
//        binder2.bind(Apple.class, appleInstance);
//        Apple r1 = binder2.getComponent(Apple.class);
//        System.out.println(r1);
//
//        System.out.println("-------------------------------------------");
//        //прив'язка класу до його екземпляру
//        ArrayList<String> arrayListInstance = new ArrayList<>();
//        arrayListInstance.add("2, 5, 4");
//        OurContainer container = new OurContainer();
//
//        container.bind(ArrayList.class, arrayListInstance);
//
//        ArrayList<String> ret = container.getComponent(ArrayList.class);
//        System.out.println(ret);
//
//
//
//        System.out.println("-------------------------------------------");
//
//        //це щоб вивести ієрархію, тобто наш клас і все що з ним пов'язане
//        OurContainer ourContainer = new OurContainer();
//        List<String> hierarchy = ourContainer.printSubClassesInterfaces(OurContainer.class);
//        System.out.println(hierarchy);

    }
}
