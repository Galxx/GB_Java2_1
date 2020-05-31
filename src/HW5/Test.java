package HW5;

import java.util.Arrays;

public class Test {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {

        Test1();
        Test2();

    }

    public static void Test1() {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        arrayHandle(arr,0);

        System.out.println("Время выполнения: " + (System.currentTimeMillis() - a));
    }

    public static void Test2() throws InterruptedException {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        long a = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> arrayHandle(a1, 0));
        Thread thread2 = new Thread(() -> arrayHandle(a2, h));
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Время выполнения: " + (System.currentTimeMillis() - a));
    }

    private static void arrayHandle(float[] arr, int h){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
        }

    }

}
