## 用于学习基础单独分离模块
### 1.集合框架
COLLECTION、map、list、set、COLLECTIONS、ARRAYS

学习Java集合框架时，可以遵循以下路线来逐步深入理解并掌握其核心概念和使用方法：
### 基础概念
了解集合框架的基本概念：集合（Collection）、映射（Map）及其接口和实现类。
学习集合框架的主要接口如Collection, Set, List, Queue, Map等。

1. 集合（Collection）
  主要接口
  Collection：所有集合类的根接口。
  	List：有序且允许重复元素的集合。
  	Set：不允许重复元素的集合。
  	Queue：用于存储元素的先进先出（FIFO）队列。
  实现类
  List
  	ArrayList：基于动态数组实现，线程不安全，查询速度快。
  	LinkedList：基于双向链表实现，插入和删除操作快。
  	Vector：与 ArrayList 类似，但线程安全。
  	Stack：继承自 Vector，实现了后进先出（LIFO）栈。
  Set
  	HashSet：基于哈希表实现，不保证元素顺序。
  	TreeSet：基于红黑树实现，元素按自然顺序排序。
  	LinkedHashSet：结合了 HashSet 和 LinkedList 的特点，保证元素插入顺序。
  Queue
  	ArrayDeque：基于数组实现的双端队列，支持高效的插入和删除操作。
  	LinkedList：可以用作队列，支持高效的插入和删除操作。
  	PriorityQueue：基于优先级堆实现，按优先级排序。
  2. 映射（Map）
  主要接口
  Map：存储键值对的接口。
  实现类
  	HashMap：基于哈希表实现，不保证键值对的顺序。
  	TreeMap：基于红黑树实现，键值对按键的自然顺序排序。
  	LinkedHashMap：结合了 HashMap 和 LinkedList 的特点，保证键值对的插入顺序。
  	WeakHashMap：键为弱引用，适用于缓存场景。
  	IdentityHashMap：使用对象本身而不是哈希码作为键。
  	ConcurrentHashMap：线程安全的哈希表实现。

### 主要接口与实现
List：理解ArrayList与LinkedList的区别，包括它们的时间复杂度、内部实现机制以及适用场景。
Set：学习HashSet、TreeSet的特点及适用场景。注意不可重复元素的概念。
Queue：了解ArrayDeque、LinkedList作为队列的使用方式。
Map：掌握HashMap、TreeMap、LinkedHashMap等的不同之处，特别是键值对存储的方式和访问顺序。
### 高级特性
泛型在集合中的应用：如何正确地使用泛型来提高代码的安全性和可读性。
并发集合：学习ConcurrentHashMap等并发安全的集合类。
流式API：利用Stream API进行集合操作，提高编程效率。
### 实践应用
编写简单的程序或功能模块，实际操作各种集合类，加深理解。
分析现有项目中的集合使用情况，尝试优化集合选择和使用方式。
### 深入源码
对于常用的集合实现类，阅读其实现源码，理解其内部数据结构和操作逻辑。
特别关注如HashMap的扩容机制、LinkedList的双链表实现等细节。
### 性能调优
学习如何根据不同的应用场景选择合适的集合类型，以达到最优的性能表现。
通过实验比较不同集合在特定条件下的性能差异。
### 错误与调试
常见集合操作错误（如NullPointerException, ClassCastException等）及其避免方法。
使用调试工具分析集合相关问题，提升解决问题的能力。
### 持续学习
关注Java新版本中集合框架的更新和发展趋势。
参与社区讨论，了解业界最佳实践。
按照这个路线图，你可以系统地学习Java集合框架，并能够灵活运用到实际开发中去
### java基本类型
数据类型 
	基本类型 ：数值型（整数类型：byte、short、int、long;浮点类型：float、double）、字符型（char）、布尔类型（boolean）
	引用数据类型：类（class）、接口（interface）、数组、枚举等



