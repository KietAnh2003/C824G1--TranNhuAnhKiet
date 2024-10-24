package ss1_ss11.ss1_java.ss2_loop.ss10_dsa.linked_list;

public class MyLinkListTest {
        public static void main(String[] args) {
            MyLinkedList<Integer> myList = new MyLinkedList<>(1);
            myList.add(2);
            myList.add(3);
            myList.addFirst(0);

            System.out.println("Danh sách sau khi thêm các phần tử: ");
            myList.printList();

            System.out.println("Phần tử tại vị trí 2: " + myList.get(2));

            System.out.println("Số lượng phần tử trong danh sách: " + myList.size());

            myList.remove(2);
            System.out.println("Danh sách sau khi xóa phần tử tại vị trí 2: ");
            myList.printList();

            myList.remove((Integer) 1);
            System.out.println("Danh sách sau khi xóa phần tử 1: ");
            myList.printList();

            System.out.println("Kiểm tra phần tử 3 có trong danh sách không: " + myList.contains(3));
            System.out.println("Vị trí của phần tử 3 trong danh sách: " + myList.indexOf(3));
        }
    }

