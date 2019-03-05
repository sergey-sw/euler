package org.skywind.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 02/03/2019.
 */
public class CounterMap<T> {

    Map<T, Integer> map = new HashMap<>();

    public void inc(T t) {
        Integer value = map.get(t);
        map.put(t, value != null ? value + 1 : 1);
    }

    public void inc(T t, int val) {
        Integer value = map.get(t);
        map.put(t, value != null ? value + val : val);
    }

    public Map<T, Integer> getMap() {
        return map;
    }
}
