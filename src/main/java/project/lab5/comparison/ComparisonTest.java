package project.lab5.comparison;

import static project.lab5.comparison.DoSomethingImpl.getStatic;

public class ComparisonTest {

    public static void main(String[] args) {
        anonim();
        lambda();
        methodReference();
    }

    private static void anonim() {
        //Створення тільки конкретного або нащадка, який є інтерфейсом/абстрактним класом, який вказаний як параметр в методі.
        //Може використовувати статичні і не статичні методи і обʼєкти.
        
        System.out.print("From anonim: ");
        print(new DoSomething() {
            @Override
            public String get() {
                return getStatic() + hidden() + " value";
            }
        });
    }

    private static void lambda() {
        //Не треба вказувати назву методу.
        //Може використовуватись без фігурних дужок в один рядок.
        //Лямбда може бути передана у будь-який інтерфейс із такими самим параметрами і типом, який повертається.
        //Може використовувати статичні методи і обʼєкти.
        
        System.out.print("From lambda: ");
        print(() -> {
            return getStatic() + " value";
//            return hidden() + " value";
        });
    }

    private static void methodReference() {
        //Для виклику потрібно вказати інстанс/клас, два рази двокрапки і назву метода(без параметрів і типом, який повертається)
        //Не можна використовувати при виклику "посилання на метод" інші методи, змінні, бо немає тіла. Тільки в самій реалізації цього метода.
        //Може бути переданий у будь-який інтерфейс із такими самим параметрами і типом, який повертається.
        
        DoSomethingImpl impl = new DoSomethingImpl();
        System.out.print("From instance method reference: ");
        print(impl::get);

        System.out.print("From static method reference: ");
        print(DoSomethingImpl::getStatic);

        System.out.print("From constructor method reference: ");
        print(String::new);
    }

    private static void print(DoSomething doSomething) {
        System.out.println(doSomething.get());
    }
    
//     private static void print(Supplier supplier) {
//        System.out.println(supplier.get());
//    }
}
