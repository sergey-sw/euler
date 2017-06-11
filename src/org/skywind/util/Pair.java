package org.skywind.util;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 04/06/2017.
 */
public class Pair<K, V> {

    private final K k;
    private final V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "k=" + k +
                ", v=" + v +
                '}';
    }
}
