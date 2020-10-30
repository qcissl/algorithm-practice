package com.qc.algo.basic.heap;

import java.util.*;

/**
 * description
 *
 * @author qinc 2020/10/17 10:01
 */
public class SmallRootHeap<T> {

    private ArrayList<T> heap;
    private Map<T, Integer> heapIndex;
    private Comparator<T> comparator;

    public SmallRootHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = new ArrayList<>();
        this.heapIndex = new HashMap<>();
    }

    public SmallRootHeap(ArrayList<T> heap, Comparator<T> comparator) {
        this.heap = heap;
        this.comparator = comparator;
        this.heapIndex = new HashMap<>();
        for (int i = heap.size() - 1; i >= 0; i--) {
            heapify(i, heap.size() - 1);
        }
    }

    public SmallRootHeap(T[] heap, Comparator<T> comparator) {
        this.heap = new ArrayList(Arrays.asList(heap));
        this.comparator = comparator;
        this.heapIndex = new HashMap<>();
        for (int i = heap.length - 1; i >= 0; i--) {
            heapify(i, heap.length - 1);
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public void push(T t) {
        heap.add(t);
        heapIndex.put(t, heap.size() - 1);
        heapInsert(heap.size() - 1);
    }

    public boolean contains(T t) {
        return heapIndex.containsKey(t);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T t = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapIndex.remove(t);
        heapify(0, heap.size());
        return t;
    }

    public void resized(T t) {
        Integer index = heapIndex.get(t);
        if (index == null) {
            return;
        }

        heapInsert(index);
        heapify(index, heap.size());

    }

    private void heapify(int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int right = left + 1;
            if (right < size) {
                left = comparator.compare(heap.get(left), heap.get(right)) < 0 ? left : right;
            }
            if (comparator.compare(heap.get(left), heap.get(index)) < 0) {
                swap(left, index);
            } else {
                break;
            }
            index = left;
            left = left * 2 + 1;
        }
    }

    private void heapInsert(int index) {
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int j, int i) {
        T t1 = heap.get(j);
        T t2 = heap.get(i);
        heap.set(j, t2);
        heap.set(i, t1);
        heapIndex.put(t1, i);
        heapIndex.put(t2, j);
    }

    public void printHeap() {
        System.out.println(Arrays.toString(heap.toArray()));
    }

    public static void main(String[] args) {
        SmallRootHeap<Student> smallRootHeap = new SmallRootHeap(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });

        Student i1 = new Student("i1", 5245);
        smallRootHeap.push(i1);
        Student i2 = new Student("i2", 436);
        smallRootHeap.push(i2);
        Student i3 = new Student("i3", 45754);
        smallRootHeap.push(i3);
        Student i4 = new Student("i4", 344);
        smallRootHeap.push(i4);
        Student i5 = new Student("i5", 4666);
        smallRootHeap.push(i5);

        smallRootHeap.printHeap();

        i4.setAge(555);
        smallRootHeap.resized(i4);
        smallRootHeap.printHeap();
    }

    public static class Student {
        String name;
        Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
