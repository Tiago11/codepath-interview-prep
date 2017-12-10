// package whatever; // don't place package name!

import java.io.*;
import java.util.*;

class MyCode {

  public static interface Hashtable<K,V> {
    V get(K key);
    void put(K key, V value);
    void remove(K key);
    int size();
    void clear();
    boolean isEmpty();
  }

  public static class MyHashTable<K, V> implements Hashtable<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75; // 3/4.

    private int size;
    private int capacity;
    private Entry<K, V>[] table;

    public MyHashTable() {
      this.size = 0;
      this.capacity = INITIAL_CAPACITY;
      this.table = new Entry[INITIAL_CAPACITY];
    }

    public V get(K key) {

      int hashKey = key.hashCode() % this.capacity;

      if (table[hashKey] != null) {

        Entry<K, V> node = table[hashKey];
        while (node != null && !node.key.equals(key)) {
          node = node.next;
        }

        if (node == null) {
          return null;
        } else {
          return node.value;
        }

      } else {
        return null;
      }

    }

    public void put(K key, V value) {

      // Add first.
      int hashKey = key.hashCode() % this.capacity;

      if (table[hashKey] == null) {

        table[hashKey] = new Entry<K, V>(key, value);
        this.size++;

      } else {

        if (table[hashKey].key.equals(key)) {

          table[hashKey].value = value;

        } else {
          // key3
          // key1, key2, key3
          Entry<K, V> node = table[hashKey];
          while (node.next != null && !node.next.key.equals(key)) {
            node = node.next;
          }

          if (node.next == null) {

            node.next = new Entry<K, V>(key, value);
            this.size++;

          } else {

            node.next.value = value;

          }

        }

      }


      // Resize if needed.
      if (this.size > (int) this.capacity*LOAD_FACTOR) {
        resize();
      }

    }

    public int size() {
      return this.size;
    }

    public void clear() {
      this.table = new Entry[this.capacity];
      this.size = 0;
    }

    public boolean isEmpty() {
      return (this.size == 0);
    }

    public void remove(K key) {

      int hashKey = key.hashCode() % this.capacity;

      if (table[hashKey] == null) {
        return;
      } else {

        if (table[hashKey].key.equals(key)) {

          table[hashKey] = table[hashKey].next;
          this.size--;

        } else {

          Entry<K, V> node = table[hashKey];
          while (node.next != null && !node.next.key.equals(key)) {
            node = node.next;
          }

          if (node.next != null) {

            node.next = node.next.next;
            this.size--;

          } else {

            return;

          }

        }

      }

    }

    private void resize() {
      int newCapacity = this.capacity*2;
      Entry<K, V>[] newTable = new Entry[newCapacity];

      for (int i=0; i < this.capacity; i++) {
        newTable[i] = this.table[i];
        this.table[i] = null;
      }

      this.table = newTable;
      this.capacity = newCapacity;
    }

    public class Entry<K, V> {
      public K key;
      public V value;
      public Entry<K, V> next;

      public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
      }
    }

  }

  public static void main (String[] args) {
        Hashtable<Object, Object> map = new MyHashTable<>();

        System.out.println(map.isEmpty()==true);
        for(int i = 0; i < 50; i++){
            map.put(i, 50 - i);
        }
        System.out.println(50 == map.size());
        System.out.println(map.isEmpty()!=true);
        for(int i = 0; i < 50; i++){
            System.out.println((int)50 - i ==  (int)map.get(i));
        }
        map.remove(49);
        System.out.println(49 == map.size());
        System.out.println(map.get(49)==null);
        map.clear();
        System.out.println(0 == map.size());
        System.out.println(map.isEmpty());
  }
}
