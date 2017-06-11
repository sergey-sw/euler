package org.skywind.util;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 12/06/2017.
 */
public class Triple<T1, T2, T3> {

    private T1 t1;
    private T2 t2;
    private T3 t3;

    public Triple() {
    }

    public Triple(T1 t1, T2 t2, T3 t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public T1 getT1() {
        return t1;
    }

    public void setT1(T1 t1) {
        this.t1 = t1;
    }

    public T2 getT2() {
        return t2;
    }

    public void setT2(T2 t2) {
        this.t2 = t2;
    }

    public T3 getT3() {
        return t3;
    }

    public void setT3(T3 t3) {
        this.t3 = t3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;

        if (t1 != null ? !t1.equals(triple.t1) : triple.t1 != null) return false;
        if (t2 != null ? !t2.equals(triple.t2) : triple.t2 != null) return false;
        return t3 != null ? t3.equals(triple.t3) : triple.t3 == null;
    }

    @Override
    public int hashCode() {
        int result = t1 != null ? t1.hashCode() : 0;
        result = 31 * result + (t2 != null ? t2.hashCode() : 0);
        result = 31 * result + (t3 != null ? t3.hashCode() : 0);
        return result;
    }
}
