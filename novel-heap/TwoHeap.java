public final class TwoHeap {
    private int[] Heap;
    private int size;

    private final int logChildrenBase2;
    private final int childrenPerNode;

    public TwoHeap(int logChildrenBase2) {
        if (logChildrenBase2 < 1 || logChildrenBase2 > 30) {
            throw new IllegalArgumentException("logChildrenBase2 must at least greater than 0");
        }
        this(logChildrenBase2, 16);
    }

    public TwoHeap(int logChildrenBase2, int initialCapacity) {
        if (logChildrenBase2 < 0 || logChildrenBase2 > 30) {
            // 2^31 would overflow int child index maths
            throw new IllegalArgumentException("logChildrenBase2 must satisfy 0 <= logChildrenBase2 <= 30");
        }
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity must not be negative");
        }
        this.logChildrenBase2 = logChildrenBase2;
        this.childrenPerNode = 1 << logChildrenBase2;
        this.heap = new int[Math.max(initialCapacity, 1)];
        this.size = 0;
    }

    private void ensureCapacity(int need) {
        if (need > heap.length) {
            int extendedLength = Math.max(need, heap.length * 2);
            int[] newHeap = new int[extendedLength];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
        return;
    }
}