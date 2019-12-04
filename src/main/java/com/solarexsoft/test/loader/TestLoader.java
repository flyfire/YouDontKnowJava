package com.solarexsoft.test.loader;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * Created by houruhou on 17/09/2017.
 */
class Singleton {
    private static Singleton sInstance = new Singleton();
    public static int counter1;
    public static int counter2 = 0;

    //    private static Singleton sInstance = new Singleton();
    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return sInstance;
    }
}

public class TestLoader {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.counter1);
        System.out.println(singleton.counter2);
        //bootstrap classloader
        System.out.println(String.class.getClassLoader()); //null
        //application classloader
        System.out.println(singleton.getClass().getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        //extension classloader
        ///opt/homebrew-cask/Caskroom/android-studio/2.0.0.20,143.2739321/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/lib/ext
//        System.out.println(com.sun.nio.zipfs.ZipFileStore.class.getClassLoader());//sun.misc.Launcher$ExtClassLoader@66d3c617
        System.out.println(Void.class.getClassLoader());//null
        System.out.println(int.class.getClassLoader());//null
        System.out.println(int[].class.getClassLoader());//null
        System.out.println(Singleton[].class.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
