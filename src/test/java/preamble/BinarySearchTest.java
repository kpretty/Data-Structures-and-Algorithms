package preamble;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wjun
 * @date 2023/2/27 10:13
 * @email wjunjobs@outlook.com
 * @describe
 */
public class BinarySearchTest {
    private final int[] array = {1, 10, 23, 45, 67, 80, 93, 100};
    private final int[] arrayWithRepeat = {1, 10, 23, 23, 67, 80, 80, 100};

    @Test
    @DisplayName("基础版二分查找：找到了")
    public void binarySearchBasicTest1() {
        Assertions.assertEquals(0, BinarySearch.binarySearchBasic(array, 1));
        Assertions.assertEquals(1, BinarySearch.binarySearchBasic(array, 10));
        Assertions.assertEquals(2, BinarySearch.binarySearchBasic(array, 23));
        Assertions.assertEquals(3, BinarySearch.binarySearchBasic(array, 45));
        Assertions.assertEquals(4, BinarySearch.binarySearchBasic(array, 67));
        Assertions.assertEquals(5, BinarySearch.binarySearchBasic(array, 80));
        Assertions.assertEquals(6, BinarySearch.binarySearchBasic(array, 93));
        Assertions.assertEquals(7, BinarySearch.binarySearchBasic(array, 100));
    }

    @Test
    @DisplayName("基础版二分查找：没有找到")
    public void binarySearchBasicTest2() {
        Assertions.assertEquals(-1, BinarySearch.binarySearchBasic(array, 0));
        Assertions.assertEquals(-1, BinarySearch.binarySearchBasic(array, 190));
    }

    @Test
    @DisplayName("优化版二分查找：找到了")
    public void binarySearchBasicTest3() {
        Assertions.assertEquals(0, BinarySearch.binarySearchOptimize(array, 1));
        Assertions.assertEquals(1, BinarySearch.binarySearchOptimize(array, 10));
        Assertions.assertEquals(2, BinarySearch.binarySearchOptimize(array, 23));
        Assertions.assertEquals(3, BinarySearch.binarySearchOptimize(array, 45));
        Assertions.assertEquals(4, BinarySearch.binarySearchOptimize(array, 67));
        Assertions.assertEquals(5, BinarySearch.binarySearchOptimize(array, 80));
        Assertions.assertEquals(6, BinarySearch.binarySearchOptimize(array, 93));
        Assertions.assertEquals(7, BinarySearch.binarySearchOptimize(array, 100));
    }

    @Test
    @DisplayName("优化版二分查找：没有找到")
    public void binarySearchBasicTest4() {
        Assertions.assertEquals(-1, BinarySearch.binarySearchOptimize(array, 0));
        Assertions.assertEquals(-1, BinarySearch.binarySearchOptimize(array, 190));
    }

    @Test
    @DisplayName("重置版(version2)二分查找：找到了")
    public void binarySearchBasicTest5() {
        Assertions.assertEquals(0, BinarySearch.binarySearchVersion2(array, 1));
        Assertions.assertEquals(1, BinarySearch.binarySearchVersion2(array, 10));
        Assertions.assertEquals(2, BinarySearch.binarySearchVersion2(array, 23));
        Assertions.assertEquals(3, BinarySearch.binarySearchVersion2(array, 45));
        Assertions.assertEquals(4, BinarySearch.binarySearchVersion2(array, 67));
        Assertions.assertEquals(5, BinarySearch.binarySearchVersion2(array, 80));
        Assertions.assertEquals(6, BinarySearch.binarySearchVersion2(array, 93));
        Assertions.assertEquals(7, BinarySearch.binarySearchVersion2(array, 100));
    }

    @Test
    @DisplayName("重置版(version2)二分查找：没有找到")
    public void binarySearchBasicTest6() {
        Assertions.assertEquals(-1, BinarySearch.binarySearchVersion2(array, 0));
        Assertions.assertEquals(-1, BinarySearch.binarySearchVersion2(array, 190));
    }

    @Test
    @DisplayName("平衡版二分查找：找到了")
    public void binarySearchBasicTest7() {
        Assertions.assertEquals(0, BinarySearch.binarySearchBalance(array, 1));
        Assertions.assertEquals(1, BinarySearch.binarySearchBalance(array, 10));
        Assertions.assertEquals(2, BinarySearch.binarySearchBalance(array, 23));
        Assertions.assertEquals(3, BinarySearch.binarySearchBalance(array, 45));
        Assertions.assertEquals(4, BinarySearch.binarySearchBalance(array, 67));
        Assertions.assertEquals(5, BinarySearch.binarySearchBalance(array, 80));
        Assertions.assertEquals(6, BinarySearch.binarySearchBalance(array, 93));
        Assertions.assertEquals(7, BinarySearch.binarySearchBalance(array, 100));
    }

    @Test
    @DisplayName("平衡版二分查找：没有找到")
    public void binarySearchBasicTest8() {
        Assertions.assertEquals(-1, BinarySearch.binarySearchBalance(array, 0));
        Assertions.assertEquals(-1, BinarySearch.binarySearchBalance(array, 190));
    }

    @Test
    @DisplayName("java版二分查找：找到了")
    public void binarySearchBasicTest9() {
        Assertions.assertEquals(0, Arrays.binarySearch(array, 1));
        Assertions.assertEquals(1, Arrays.binarySearch(array, 10));
        Assertions.assertEquals(2, Arrays.binarySearch(array, 23));
        Assertions.assertEquals(3, Arrays.binarySearch(array, 45));
        Assertions.assertEquals(4, Arrays.binarySearch(array, 67));
        Assertions.assertEquals(5, Arrays.binarySearch(array, 80));
        Assertions.assertEquals(6, Arrays.binarySearch(array, 93));
        Assertions.assertEquals(7, Arrays.binarySearch(array, 100));
    }

    @Test
    @DisplayName("java版二分查找：没有找到")
    public void binarySearchBasicTest10() {
        // 为找到的情况 java 版返回了 -(预插入下标) - 1
        Assertions.assertEquals(-1, Arrays.binarySearch(array, 0));
        Assertions.assertEquals(-9, Arrays.binarySearch(array, 190));
    }

    @Test
    @DisplayName("重复元素二分查找left：找到了")
    public void binarySearchBasicTest11() {
        Assertions.assertEquals(2, BinarySearch.binarySearchLeftMost(array, 23));
        Assertions.assertEquals(5, BinarySearch.binarySearchLeftMost(array, 80));
    }

    @Test
    @DisplayName("重复元素二分查找left：没有找到")
    public void binarySearchBasicTest12() {
        Assertions.assertEquals(-1, BinarySearch.binarySearchLeftMost(array, 0));
        Assertions.assertEquals(-1, BinarySearch.binarySearchLeftMost(array, 190));
    }

    @Test
    @DisplayName("重复元素二分查找left：没有找到")
    public void binarySearchBasicTest13() {
        Assertions.assertEquals(-1, BinarySearch.binarySearchLeftMostVersion2(arrayWithRepeat, 0));
        Assertions.assertEquals(-5, BinarySearch.binarySearchLeftMostVersion2(arrayWithRepeat, 60));
        Assertions.assertEquals(-9, BinarySearch.binarySearchLeftMostVersion2(arrayWithRepeat, 190));
    }

}
