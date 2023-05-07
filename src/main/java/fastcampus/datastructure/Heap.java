package fastcampus.datastructure;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {

    ArrayList<Integer> heapList = null;

    public Heap(Integer data) {

        heapList = new ArrayList<>();

        heapList.add(null);
        heapList.add(data);
    }

    public boolean moveUp(Integer index) {
        if (index <= 1) {
            return false;
        }
        Integer parentIdx = index / 2;
        if (this.heapList.get(index) > this.heapList.get(parentIdx)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(Integer data) {
        Integer insertIdx;
        Integer parentIdx;

        if (heapList == null) {
            heapList = new ArrayList<>();
            heapList.add(null);
            heapList.add(data);
            return true;
        }
        this.heapList.add(data);
        insertIdx = this.heapList.size() - 1;

        while (this.moveUp(insertIdx)) {
            parentIdx = insertIdx / 2;
            Collections.swap(this.heapList, insertIdx, parentIdx);
            insertIdx = parentIdx;
        }
        return true;
    }

    public boolean moveDown(Integer index) {
        Integer leftChildIdx = index * 2;
        Integer rightChildIdx = index * 2 + 1;


        if (leftChildIdx >= heapList.size()) {
            // CASE1: 자식이 하나도 없을 때
            return false;
        } else if (rightChildIdx >= this.heapList.size()) {
            // CASE2: 왼쪽 자식만 있을때
            if (this.heapList.get(index) < this.heapList.get(leftChildIdx)) {
                return true;
            } else {
                return false;
            }
        } else {
            // 자식이 둘일 때
            if (this.heapList.get(rightChildIdx) < this.heapList.get(leftChildIdx)) {
                // 왼쪽 자식이 오른쪽 자식보다 더 클 때
                if (this.heapList.get(index) < this.heapList.get(leftChildIdx)) {
                    // 자식이 더 크면 자리를 바꿔야 함
                    return true;
                } else {
                    return false;
                }
            } else {
                // 오른쪽 자식이 왼쪽 자식보다 더 클 때
                if (this.heapList.get(index) < this.heapList.get(rightChildIdx)) {
                    // 자식이 더 크면 자리를 바꿔야 함
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public Integer pop() {
        Integer returnData;
        Integer popIdx;
        Integer leftChild;
        Integer rightChild;

        if (this.heapList == null) {
            return null;
        } else {
            returnData = this.heapList.get(1);
            this.heapList.set(1, this.heapList.get(this.heapList.size() - 1));
            this.heapList.remove(this.heapList.size() - 1);
            popIdx = 1;

            while (this.moveDown(popIdx)) {
                leftChild = popIdx * 2;
                rightChild = popIdx * 2 + 1;


                if (rightChild >= this.heapList.size()) {
                    // CASE1: 왼쪽 자식노드만 있을 때
                    if (this.heapList.get(popIdx) < heapList.get(leftChild)) {
                        // 삭제하려는 인덱스의 값보다 왼쪽 자식이 클 때
                        Collections.swap(heapList, popIdx, leftChild);
                        popIdx = leftChild;
                    }
                } else {
                    // CASE2: 자식이 둘 다 있을 떄
                    if (this.heapList.get(popIdx) < heapList.get(rightChild)) {
                        // 삭제하려는 인덱스의 값보다 오른쪽 자식이 클 때
                        Collections.swap(heapList, popIdx, rightChild);
                        popIdx = rightChild;
                    }
                }
            }
            return returnData;
        }
    }

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapList);

        heapTest.pop();
        System.out.println(heapTest.heapList);
    }
}
