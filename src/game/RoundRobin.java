package game;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Daisy on 2/20/16.
 */
public class RoundRobin<E> {
    private Iterator<E> it;
    private List<E> list;

    public RoundRobin(List<E> list) {
        this.list = list;
        it = list.iterator();
    }

    public void reset() {
        it = list.iterator();
    }

    public E next() {
        if (!it.hasNext()) {
            it = list.iterator();
        }
        return it.next();
    }
}
