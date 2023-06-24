import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * AA
 */
class AA {
    String name;
    int age;
    AA(String n){
        name= n;
    }
    String getName() {
        return name;
    }

    int getAge(){
        return age;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
}
class Test{
    public static void main(String[] args) {
        ArrayList<AA> test= new ArrayList<AA>();
        test.add(new AA("1"));
        test.add(new AA("8"));
        test.add(new AA("2"));
        test.add(new AA("4"));
        test.add(new AA("7"));
        test.add(new AA("5"));
        test.add(new AA("3"));
        test.add(new AA("6"));
        test.sort(Comparator.comparing(AA::getName));
        test.forEach(System.out::println);
    }
}