package vpzomtrrfrt.netpad3.exampleclient;

public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public String toString() {
        return first+", "+last;
    }
}
