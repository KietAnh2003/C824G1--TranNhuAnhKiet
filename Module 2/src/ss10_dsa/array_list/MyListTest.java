package ss10_dsa.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();

        myList.add("1");
        myList.add("2");
        myList.add("3");
        System.out.println("Danh sách sau khi thêm phần tử:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println("");

        myList.add(2, "4");
        System.out.println("Danh sách sau khi thêm 4 vào vị trí thứ 2:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println("");

        myList.remove(1);
        System.out.println("Danh sách sau khi xóa phần tử tại vị trí thứ 1:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println("");

        MyList<String> clonedList = myList.clone();
        System.out.println("Danh sách clone:");
        for (int i = 0; i < clonedList.size(); i++) {
            System.out.print(clonedList.get(i) + " ");
        }
        System.out.println("");

        int index = myList.indexOf("5");
        System.out.println("Vị trí của '5' trong danh sách: " + index);

        myList.clear();
        System.out.println("Danh sách sau khi clear");
        System.out.println("Kích thước: " + myList.size());
    }
}
