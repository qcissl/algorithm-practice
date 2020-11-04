package com.qc.algo.basic.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author qinc 2020/10/30 11:01
 */
public class SmallRootHeapForDijkstra {
    Node[] records;
    Map<Node, Integer> heapIndex = new HashMap<>();
    Map<Node, Dijkstra.NodeRecord> existMap = new HashMap<>();
    int size = 0;
    Comparator<Dijkstra.NodeRecord> comparator = new Comparator<Dijkstra.NodeRecord>() {
        @Override
        public int compare(Dijkstra.NodeRecord o1, Dijkstra.NodeRecord o2) {
            return o1.weight - o2.weight;
        }
    };

    public SmallRootHeapForDijkstra(int limit) {
        this.records = new Node[limit];
    }

    public void push(Dijkstra.NodeRecord record) {
        heapIndex.put(record.node, size);
        existMap.put(record.node, record);
        records[size] = record.node;
        heapInsert(size++);
    }

    public Dijkstra.NodeRecord pop() {
        Node node = records[0];
        Dijkstra.NodeRecord record = new Dijkstra.NodeRecord(node, existMap.get(node).weight);
        heapIndex.remove(record);
        existMap.get(node).weight = -1;
        swap(0, --size, records);
        records[size + 1] = null;
        heapfiy(0, size);
        return record;
    }

    public void resized(Dijkstra.NodeRecord record) {
        Integer index = heapIndex.get(record.node);
        if (index == null) {
            return;
        }
        heapInsert(index);
        heapfiy(index, size);
    }

    public void insertOrUpdateOrIgnore(Dijkstra.NodeRecord record) {
        Dijkstra.NodeRecord index = existMap.get(record.node);
        if (index == null) {
            push(record);
        } else if (index.weight == -1) {
            return;
        } else {
            index.weight = Math.min(index.weight, record.weight);
            resized(record);
        }

    }

    private void heapfiy(int index, int size) {
        int left = index * 2 + 1;
        int right = left + 1;
        while (left < size) {
            if (right < size) {
                left = comparator.compare(existMap.get(records[left]), existMap.get(records[right])) < 0 ? left : right;
            }
            if (comparator.compare(existMap.get(records[index]), existMap.get(records[left])) > 0) {
                swap(left, index, records);
                index = left;
                left = index * 2 + 1;
                right = left + 1;
            } else {
                break;
            }
        }
    }

    private void heapInsert(int index) {
        int parent = (index - 1) / 2;
        while (comparator.compare(existMap.get(records[parent]), existMap.get(records[index])) > 0) {
            swap(parent, index, records);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void swap(int i, int j, Node[] arr) {
        heapIndex.put(arr[i], j);
        heapIndex.put(arr[j], i);
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(records));
    }

    public static void main(String[] args) {
        SmallRootHeapForDijkstra smallRootHeap = new SmallRootHeapForDijkstra(10);

        Dijkstra.NodeRecord i1 = new Dijkstra.NodeRecord(null, 5245);
        smallRootHeap.push(i1);
        Dijkstra.NodeRecord i2 = new Dijkstra.NodeRecord(null, 436);
        smallRootHeap.push(i2);
        Dijkstra.NodeRecord i3 = new Dijkstra.NodeRecord(null, 45754);
        smallRootHeap.push(i3);
        Dijkstra.NodeRecord i4 = new Dijkstra.NodeRecord(null, 344);
        smallRootHeap.push(i4);
        Dijkstra.NodeRecord i5 = new Dijkstra.NodeRecord(null, 4666);
        smallRootHeap.push(i5);

        smallRootHeap.printHeap();

        i4.weight = 555;
        smallRootHeap.resized(i4);
        smallRootHeap.printHeap();
    }

}
