Streams
A Collection contains its elements, whereas a Stream does not,
Stream operates on a view whose elements are kept in a collection or array, but any changes made to Stream do not affect the original collection.

Collections
https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html

The following list describes the core collection interfaces:

    Collection — the root of the collection hierarchy. A collection represents a group of objects known as its elements. The Collection interface is the least common denominator that all collections implement and is used to pass collections around and to manipulate them when maximum generality is desired. Some types of collections allow duplicate elements, and others do not. Some are ordered and others are unordered. The Java platform doesn't provide any direct implementations of this interface but provides implementations of more specific subinterfaces, such as Set and List. Also see The Collection Interface section.
    Set — a collection that cannot contain duplicate elements. This interface models the mathematical set abstraction and is used to represent sets, such as the cards comprising a poker hand, the courses making up a student's schedule, or the processes running on a machine. See also The Set Interface section.
    List — an ordered collection (sometimes called a sequence). Lists can contain duplicate elements. The user of a List generally has precise control over where in the list each element is inserted and can access elements by their integer index (position). If you've used Vector, you're familiar with the general flavor of List. Also see The List Interface section.
    Queue — a collection used to hold multiple elements prior to processing. Besides basic Collection operations, a Queue provides additional insertion, extraction, and inspection operations.

    Queues typically, but do not necessarily, order elements in a FIFO (first-in, first-out) manner. Among the exceptions are priority queues, which order elements according to a supplied comparator or the elements' natural ordering. Whatever the ordering used, the head of the queue is the element that would be removed by a call to remove or poll. In a FIFO queue, all new elements are inserted at the tail of the queue. Other kinds of queues may use different placement rules. Every Queue implementation must specify its ordering properties. Also see The Queue Interface section.
    Deque — a collection used to hold multiple elements prior to processing. Besides basic Collection operations, a Deque provides additional insertion, extraction, and inspection operations.

    Deques can be used both as FIFO (first-in, first-out) and LIFO (last-in, first-out). In a deque all new elements can be inserted, retrieved and removed at both ends. Also see The Deque Interface section.
    Map — an object that maps keys to values. A Map cannot contain duplicate keys; each key can map to at most one value. If you've used Hashtable, you're already familiar with the basics of Map. Also see The Map Interface section.

The last two core collection interfaces are merely sorted versions of Set and Map:

    SortedSet — a Set that maintains its elements in ascending order. Several additional operations are provided to take advantage of the ordering. Sorted sets are used for naturally ordered sets, such as word lists and membership rolls. Also see The SortedSet Interface section.
    SortedMap — a Map that maintains its mappings in ascending key order. This is the Map analog of SortedSet. Sorted maps are used for naturally ordered collections of key/value pairs, such as dictionaries and telephone directories. Also see The SortedMap Interface section.




Oops concept 
https://www.digitalocean.com/community/tutorials/oops-concepts-java-example
    Abstraction
    Encapsulation
    Polymorphism
    Inheritance
    Association
    Aggregation
    Composition



API error codes
One program to store object with last name if similar last name matches
Basic JavaScript questions
How to validate a date, such as Is 1999-02-30 a valid date. 
OOP Concepts, Java Stream, White Board Task , Testing Pyramid 
OOP concepts and where did you use in your framework?
What is thread in Java?
What are the status codes in API?
framework
What's the difference between TDD and BDD?
How do you handle exceptions in Java?
What is static in Java?

LEAD 
 data structure , java, api automation, spring boot, selenium, framework, performance testing
What is REST
What is BDD and its Advantages and disadvantages 
Difference between load testing and stress testing?

given a parapgraph with multiple sentences. Find the sentence with the max words and return the number of words.
HashMap HashSet

difference between final, finally and finalize?
https://techdifferences.com/difference-between-final-finally-and-finalize-in-java.html


Synchronize keyword
The synchronized keyword locks a single thread with the shared data so that no other thread can access it.


