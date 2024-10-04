public class ArrayListIntApp {
    public static void main(String[] args){
        ArrayListInt arrayList = new ArrayListInt();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(5);
        arrayList.add(5);
        arrayList.print();
        int currentSize = arrayList.size();
        int firstElement = arrayList.get(0);
        
        System.out.println("現在のサイズ：　" + currentSize);
        System.out.println("配列の最初のあたいは" + firstElement);

        return;
    }
}