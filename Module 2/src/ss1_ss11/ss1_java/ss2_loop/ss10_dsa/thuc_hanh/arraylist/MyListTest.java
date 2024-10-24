package ss1_ss11.ss1_java.ss2_loop.ss10_dsa.thuc_hanh.arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);

        System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));

//     listInteger.get(6);
//        System.out.println("element 6: "+listInteger.get(6));
    }
}
