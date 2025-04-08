package project.lab5.comparison;

public class DoSomethingImpl implements DoSomething {

    @Override
    public String get() {
        return hidden() + "From impl";
    }
    
    public static String getStatic() {
        return "From static";
//        cannot be called.
//        return hidden() + get();
    }
}
