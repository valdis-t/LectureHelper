package interfaces;

public interface Changeable<E> extends Readable<E> {
    void setData(E data);

    void removeLast();

    void removeAll();
}
