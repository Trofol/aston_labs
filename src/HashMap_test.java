public class HashMap_test {
    public static void main(String[] args) {
        HashMap_lab <Integer, String> map = new HashMap_lab<>();

        map.put(12,"Audi");
        map.put(5,"Aston Martin)");
        map.put(2,"Ferrari");
        map.put(7,"BMW");
        System.out.println(map.size());

        map.put(2,"Tesla");

        map.get(12);

        map.remove(123);
        map.remove(7);
    }
}
