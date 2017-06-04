package org.skywind.util;

import java.util.*;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 04/06/2017.
 */
public class SimpleTC<T extends Comparable<T>> {

    public interface Callback<T> {
        void onClosure(Set<T> group);
    }

    private final List<SortablePair<T, T>> pairs = new ArrayList<>();
    private boolean[] processed;

    public void add(T t1, T t2) {
        pairs.add(new SortablePair<>(t1, t2, pairs.size()));
        pairs.add(new SortablePair<>(t2, t1, pairs.size()));
    }

    public void run(Callback<T> callback) {
        Collections.sort(pairs);
        processed = new boolean[pairs.size()];

        for (int i = 0; i < processed.length; i++) {
            if (!processed[i]) {
                callback.onClosure(findComponent(i));
            }
        }
    }

    private Set<T> findComponent(int idx) {
        T seed = pairs.get(idx).getK();

        Queue<T> queue = new LinkedList<>();
        queue.add(seed);

        Set<T> component = new HashSet<>();
        component.add(seed);

        while (queue.size() > 0) {
            T current = queue.poll();
            SortablePair<T, T> searchPair = new SortablePair<>(current, null, -1);
            int start = Collections.binarySearch(pairs, searchPair); // ищем пары, в которых 1й == current
            if (start >= 0) {
                int i = start;
                while (i >= 0 && pairs.get(i).compareTo(searchPair) == 0) { // идем влево
                    processNextElement(i, component, queue);
                    i--;
                }
                i = start + 1;
                while (i < pairs.size() && pairs.get(i).compareTo(searchPair) == 0) { // идем вправо
                    processNextElement(i, component, queue);
                    i++;
                }
            }
        }

        return component;
    }

    private void processNextElement(int idx, Set<T> component, Queue<T> queue) {
        processed[idx] = true; // помечаем как обработанный
        SortablePair<T, T> chainPair = pairs.get(idx); // берем пару

        if (!component.contains(chainPair.getV())) { // если второго элемента пары нет в компоненте
            queue.add(chainPair.getV()); // добавляем его в очередь на обход
            component.add(chainPair.getV());
        }
    }
}
