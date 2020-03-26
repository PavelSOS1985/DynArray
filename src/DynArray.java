import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz;
        // new DynArray<Integer>(Integer.class);
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        if (capacity != 0) {
            new_capacity = new_capacity < 16 ? 16 : new_capacity;
            array = Arrays.copyOf(array, new_capacity);
        } else {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
        }
        capacity = new_capacity;
    }

    public T getItem(int index) throws ArrayIndexOutOfBoundsException {
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Index Out Of Bounds Exception");
        }
    }

    public void append(T itm) {
        if (count >= capacity) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) throws ArrayIndexOutOfBoundsException {
        if (index > count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index Out Of Bounds Exception");
        }
        if (count >= capacity) {
            makeArray(capacity * 2);
        }
        T tempAr[] = (T[]) Array.newInstance(this.clazz, count - index);

        for (int i = 0; i < count - index; i++) {
            tempAr[i] = array[index + i];
        }
        array[index] = itm;
        for (int i = 0; i < count - index; i++) {
            array[index + i + 1] = tempAr[i];
        }
        count++;
    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index > (count - 1) || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index Out Of Bounds Exception");
        }
        T tempAr[] = (T[]) Array.newInstance(this.clazz, count - index);
        for (int i = 0; i < count - index - 1; i++) {
            tempAr[i] = array[index + i + 1];
        }
        for (int i = 0; i < (count - index); i++) {
            array[index + i] = tempAr[i];
        }
        if (count-- <= (capacity / 1.5)) {
            makeArray((int) (capacity / 1.5));
        }
    }

}