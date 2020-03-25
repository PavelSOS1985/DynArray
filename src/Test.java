import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        DynArray<Integer> test = new DynArray<>(Integer.class);
        for (int i = 0; i < test.capacity; i++) {
            test.append(i);
        }
        test.append(55);
      //  test.append(33);
       //test.insert(1111, 15);
      //  test.insert(2222, 11);
        System.out.println("===================");
        for (int i = 0; i < test.capacity; i++) {
            System.out.println(i + " - " + test.getItem(i));
        }
        test.remove(5);
        //test.remove(2);
        //test.remove(2);
        System.out.println("===================");
        for (int i = 0; i < test.capacity; i++) {
            System.out.println(i + " - " + test.getItem(i));
        }
        //System.out.println(test.getItem(33));



        /*ArrayList<Integer> u = new ArrayList<>();
        u.add(55);
        u.add(53);
        u.add(522);
        for (int i = 0; i< 16; i++) {
            System.out.println(u.get(i));
        }*/

    }

}