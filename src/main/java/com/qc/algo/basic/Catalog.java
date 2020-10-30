package com.qc.algo.basic;

/**
 * 基础12节
 * <p>
 * 1）排序、二分查找、异或操作
 *
 * @see com.qc.algo.basic.sort.SelectSort 选择排序
 * @see com.qc.algo.basic.sort.BubblingSort 冒泡排序
 * @see com.qc.algo.basic.sort.InsertSort 插入排序
 * @see com.qc.algo.basic.binarySearch.BinarySearch 二分查找、局部最小
 * @see com.qc.algo.basic.exor.ExorOption 异或操作
 * <p>
 * 2）链表、队列、栈
 * @see com.qc.algo.basic.linkedList.ReverseLinkedList 翻转链表
 * @see com.qc.algo.basic.linkedList.RemoveValueLinkedList 删除链表给定值
 * @see com.qc.algo.basic.queue.MyQueue 链表实现队列
 * @see com.qc.algo.basic.stack.MyStack 链表实现栈
 * @see com.qc.algo.basic.queue.ArrayQueue 数组实现队列
 * @see com.qc.algo.basic.stack.MinValueStack 获取栈中最小值
 * @see com.qc.algo.basic.stack.StackByTwoQueue 两个队列实现栈
 * @see com.qc.algo.basic.queue.QueueByTwoStack 两个栈实现队列
 * <p>
 * 3）归并排序和快速排序
 * @see com.qc.algo.basic.sort.MergeSort 归并排序
 * @see com.qc.algo.basic.recursion.SmallSum 小和累加问题
 * @see com.qc.algo.basic.partition.Partition 分组问题
 * @see com.qc.algo.basic.partition.DutchFlag 荷兰国旗问题
 * @see com.qc.algo.basic.sort.QuickSortOne 快排1版本
 * @see com.qc.algo.basic.sort.QuickSortTwo 快排2版本
 * @see com.qc.algo.basic.sort.QuickSortThree 快排3版本
 * <p>
 * 4）比较器与堆
 * @see com.qc.algo.basic.heap.BigRootHeap 大根堆
 * @see com.qc.algo.basic.sort.BigRootHeapSort 大根堆排序
 * @see com.qc.algo.basic.heap.SmallRootHeap 小根堆带resized功能
 * @see com.qc.algo.basic.sort.SmallRootHeapSort 小根堆排序
 * @see com.qc.algo.basic.heap.SortArrayDistanceLessK 移动的距离不超过k的数组排序
 * <p>
 * 5）前缀树与桶排序
 * @see com.qc.algo.basic.trie.TrieTree 前缀树
 * @see com.qc.algo.basic.bucket.CountSort 计数排序
 * @see com.qc.algo.basic.bucket.RadixSort 基数排序
 * <p>
 * 6）链表相关习题
 * @see com.qc.algo.basic.linkedList.LinkedListMid 链表中点附近节点
 * @see com.qc.algo.basic.linkedList.IsPalindromeList 判断链表是否是回文
 * @see com.qc.algo.basic.linkedList.LinkedListPartition 对单链表做荷兰国旗问题
 * @see com.qc.algo.basic.linkedList.CopyListWithRandom 复制带有随机指针的单链表
 * @see com.qc.algo.basic.linkedList.FindFirstIntersectNode 返回俩个单链表相交的第一个节点
 * <p>
 * 7）二叉树的基本算法
 * @see com.qc.algo.basic.binaryTree.RecursiveTraversalBT 二叉树的先序、中序、后续递归遍历
 * @see com.qc.algo.basic.binaryTree.UnRecursiveTraversalBT 二叉树的先序、中序、后续非递归遍历
 * @see com.qc.algo.basic.binaryTree.LevelTraversalBT 二叉树宽度优先遍历
 * @see com.qc.algo.basic.binaryTree.SerializeAndReconstructBT 二叉树的序列化与反序列化
 * @see com.qc.algo.basic.binaryTree.TreeMaxWidth 二叉树的最大宽度
 * @see com.qc.algo.basic.binaryTree.SuccessorNode 二叉树任意一个点的后继节点（中序遍历）
 * @see com.qc.algo.basic.binaryTree.PaperFolding 白纸折痕问题
 * <p>
 * 8）二叉树递归套路
 * @see com.qc.algo.basic.binaryTreeDP.BalancedBinaryTree 是否平衡二叉树
 * @see com.qc.algo.basic.binaryTreeDP.FullBinaryTree 是否满二叉树
 * @see com.qc.algo.basic.binaryTreeDP.CompleteBinaryTree 是否完全二叉树
 * @see com.qc.algo.basic.binaryTreeDP.SearchBinaryTree 是否搜索二叉树
 * @see com.qc.algo.basic.binaryTreeDP.MaxSubSBTHead 二叉树最大的搜索子树的头节点
 * @see com.qc.algo.basic.binaryTreeDP.MaxSubSBTSize 二叉树最大的搜索子树的大小
 * @see com.qc.algo.basic.binaryTreeDP.LowestAncestor 二叉树上任意两个节点的最低公共祖先
 * @see com.qc.algo.basic.binaryTreeDP.MaxDistance 二叉树的最大距离
 * @see com.qc.algo.basic.binaryTreeDP.MaxHappy 派对的最大快乐值
 * <p>
 * 9）贪心算法
 * @see com.qc.algo.basic.greedy.LowestLexicography 必须把所有的字符串拼接起来，返回所有可能的拼接结果中，字典序最小的结果
 * @see com.qc.algo.basic.greedy.StreetLight 路灯摆放问题
 * @see com.qc.algo.basic.greedy.LessMoneySplitGold 黄金分割问题（哈夫曼树）
 * @see com.qc.algo.basic.greedy.BestArrange 会议室安排会议场次最多
 * <p>
 * 10）并查集与图
 * @see com.qc.algo.basic.unionSet.UnionFindSet 并查集
 * @see com.qc.algo.basic.unionSet.MergeUsers 合并相同属性的用户
 * @see com.qc.algo.basic.graph.GraphBFS 图的宽度遍历
 * @see com.qc.algo.basic.graph.GraphDFS 图的深度遍历
 * @see com.qc.algo.basic.graph.TopologySort 图的拓扑排序
 * @see com.qc.algo.basic.graph.Kruskal 最小生成树 K算法
 * @see com.qc.algo.basic.graph.Prim 最小生成树 P算法
 * @see com.qc.algo.basic.graph.Dijkstra 最短路径
 */
public class Catalog {

}
