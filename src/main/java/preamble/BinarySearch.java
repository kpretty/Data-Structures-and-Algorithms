package preamble;


/**
 * @author wjun
 * @date 2023/2/27 09:57
 * @email wjunjobs@outlook.com
 * @describe 前言-二分查找
 */
public class BinarySearch {
    /**
     * 二分查找-基础版
     *
     * @param array  升序数组
     * @param target 目标
     * @return int target 存在返回索引位置，不存在返回 -1
     */
    public static int binarySearchBasic(int[] array, int target) {
        // 定义查询边界，start 指向数组第一个元素位置，end 指向数据最后一个元素位置
        int start = 0, end = array.length - 1;
        // 定义结束条件，当 start > end 时表明没有元素可以查找
        while (start <= end) {
            // 取 start 和 end 中间位置，向下取整
            int middle = (start + end) / 2;
            int middleValue = array[middle];
            if (target < middleValue) {
                // 目标值比中间值小，移动 end
                end = middle - 1;
            } else if (middleValue < target) {
                // 目标值比中间值大，移动 start
                start = middle + 1;
            } else {
                // 匹配上
                return middle;
            }
        }
        return -1;
    }

    /*
     * int middle = (start + end) / 2
     * 当 start + end 超过 int 的返回时，会产生 int 溢出的情况
     * 解决方案：
     * 1. start + (start - end) / 2
     * 2. (start + end ) >>> 1
     * */
    public static int binarySearchOptimize(int[] array, int target) {
        // 定义查询边界，start 指向数组第一个元素位置，end 指向数据最后一个元素位置
        int start = 0, end = array.length - 1;
        // 定义结束条件，当 start > end 时表明没有元素可以查找
        while (start <= end) {
            // 取 start 和 end 中间位置，向下取整
            int middle = (start + end) >>> 1;
            int middleValue = array[middle];
            if (target < middleValue) {
                // 目标值比中间值小，移动 end
                end = middle - 1;
            } else if (middleValue < target) {
                // 目标值比中间值大，移动 start
                start = middle + 1;
            } else {
                // 匹配上
                return middle;
            }
        }
        return -1;
    }

    /**
     * 二叉搜索 version2
     * 修改 end 指向的含义
     *
     * @param array  数组
     * @param target 目标
     * @return int
     */
    public static int binarySearchVersion2(int[] array, int target) {
        // 定义查询边界，start 指向数组第一个元素位置，end 指向数据最后一个元素后面一个位置，因此 end 指向的数据不参与比较
        int start = 0, end = array.length;
        // 定义结束条件，因为 end 不参与比较，因此当 start = end 的时候也需要停止比较
        // 一定不能等于，否则
        // 当不存在的元素比最小的元素还小时会产生死循环
        // 当不存在的元素比最大的元素还大时会产生索引下标越界
        while (start < end) {
            // 取 start 和 end 中间位置，向下取整
            int middle = (start + end) >>> 1;
            int middleValue = array[middle];
            if (target < middleValue) {
                // 目标值比中间值小，移动 end，因为 end 不参与比较，因此移动 end 到 middle 即可，不需要前移一位，否则与假设相违背
                end = middle;
            } else if (middleValue < target) {
                // 目标值比中间值大，移动 start
                start = middle + 1;
            } else {
                // 匹配上
                return middle;
            }
        }
        return -1;
    }

    /**
     * 平衡版二分查找
     * 上述的二分查找时间复杂度最差 O(log(n)), 最优 O(1)
     * 其平均查询时间不确定，平衡二分查找保证最优最差的时间复杂度都是 O(log(n))
     *
     * @param array  数组
     * @param target 目标
     * @return int
     */
    public static int binarySearchBalance(int[] array, int target) {
        // 定义查询边界，start 指向数组第一个元素位置，end 指向数据最后一个元素后面一个位置，因此 end 指向的数据不参与比较
        int start = 0, end = array.length;
        // 定义结束条件
        // end - start 表示还有多少个未比较的元素
        while (end - start > 1) {
            // 取 start 和 end 中间位置，向下取整
            int middle = (start + end) >>> 1;
            int middleValue = array[middle];
            if (target < middleValue) {
                // 目标值比中间值小，移动 end
                end = middle;
            } else {
                // 目标值比中间值大，移动 start
                // else 包含等于的情况，因此 start 只需要移动到 middle 即可
                start = middle;
            }
        }
        // 循环结束
        // 判断 start 指向的值是否等于 target
        // 因为找到的这种情况只可能出现在 else 中，同时 end 指向的元素不参与比较，因此判断 start 即可。
        if (array[start] == target) {
            return start;
        } else {
            return -1;
        }
    }

    /**
     * 重复元素返回最左的索引
     *
     * @param array  数组
     * @param target 目标
     * @return 返回对应 target 最左边的元素位置
     */
    public static int binarySearchLeftMost(int[] array, int target) {
        // start 指向数组第一个元素，end 指向数组最后一个元素
        int start = 0, end = array.length - 1, preReturn = -1;
        while (start <= end) {
            int middle = (start + end) >>> 1;
            if (target < array[middle]) {
                // 目标值比中间值小，移动 end
                end = middle - 1;
            } else if (array[middle] < target) {
                // 目标值比中间值大，移动 start
                start = middle + 1;
            } else {
                // 匹配上仅记录，暂时不返回
                preReturn = middle;
                // 因为找最左边的元素位置，即假设本次没有找到想要的 target，且 target 在 middle 左边
                // 等价于 target < array[middle] 情况，因此移动 end
                end = middle - 1;
            }
        }

        return preReturn;
    }

    /**
     * 重复元素返回最左的索引
     *
     * @param array  数组
     * @param target 目标
     * @return 返回对应 target 最左边的元素位置，未找到返回预 -(插入位置) - 1
     */
    public static int binarySearchLeftMostVersion2(int[] array, int target) {
        // start 指向数组第一个元素，end 指向数组最后一个元素
        int start = 0, end = array.length - 1, preReturn = -1;
        while (start <= end) {
            int middle = (start + end) >>> 1;
            if (target < array[middle]) {
                // 目标值比中间值小，移动 end
                end = middle - 1;
            } else if (array[middle] < target) {
                // 目标值比中间值大，移动 start
                start = middle + 1;
            } else {
                // 匹配上仅记录，暂时不返回
                preReturn = middle;
                // 因为找最左边的元素位置，即假设本次没有找到想要的 target，且 target 在 middle 左边
                // 等价于 target < array[middle] 情况，因此移动 end
                end = middle - 1;
            }
        }

        return preReturn == -1 ? -start - 1 : preReturn;
    }
}
