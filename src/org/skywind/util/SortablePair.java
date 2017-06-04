package org.skywind.util;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 04/06/2017.
 */
public class SortablePair<K extends Comparable<K>, V extends Comparable<V>>
        extends Pair<K, V>
        implements Comparable<SortablePair<K, V>> {

    private int id;

    public SortablePair(K k, V v, int id) {
        super(k, v);
        this.id = id;
    }

    @Override
    public int compareTo(SortablePair<K, V> o) {
        return getK().compareTo(o.getK());
    }

    public int getId() {
        return id;
    }
}
