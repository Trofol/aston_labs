public class HashMap_lab<K,V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K,V>[] table;
    private int size;

    private static class Node<K,V>{
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public HashMap_lab(){
        table = new Node[DEFAULT_CAPACITY];
    }


    public void put(K key, V value){
        if(key == null){
            System.out.println("Ключ не может быть равен нулю!");
            return;
        }

        int index = getIndex(key);
        Node<K, V> node = table[index];
        //проверка на "есть ли уже такой ключ"
        while(node != null){
            if(node.key.equals(key)){
                node.value = value;
                System.out.println("Изменено: " + key + ": " + value);
                return;
            }
            node = node.next;
        }

        Node<K,V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
        System.out.println("Добавлено: " + key + ": " + value);
    }

    public V get(K key){
        if(key == null){
            System.out.println("Ключ не может быть равен нулю!");
            return null;
        }
        int index = getIndex(key);
        Node<K, V> node = table[index];

        while(node != null){
            if(node.key.equals(key)){
                System.out.println("Найдено: " + key + ": " + node.value);
                return node.value;
            }
        }
        System.out.println("Ключ не найден");
        return null;
    }

    public V remove(K key){
        if (key == null) {
            System.out.println("[Ошибка] Ключ не может быть null!");
            return null;
        }

        int index = getIndex(key);
        Node<K, V> prev = null;
        Node<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                System.out.println("Удалено: " + key + ": " + current.value);
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Ключ для удаления не найден!!");
        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Размер HashMap
    public int size() {
        return size;
    }

}