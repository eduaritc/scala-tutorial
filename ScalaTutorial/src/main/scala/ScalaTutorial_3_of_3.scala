
object ScalaTutotial_3_of_3 {

  def main(args: Array[String]): Unit = {
    /*
    Options in scala
    -Are container that can give you an instance either of Some or None
     */
    println("--- OPTIONS IN SCALA ---")
    println("###########################################################")
    val lst = List(1, 2, 3)
    val map = Map(1 -> "Tom", 2 -> "Max", 3 -> "John")
    val opt : Option[Int] = Some(5) //Option with values
    val opt2 : Option[Int] = None //empty option
    println(lst.find(_ > 6)) //Checking for values gt 6 on the list --> None
    println(lst.find(_ > 2)) //Checking for values gt 2 on the list --> Some
    println(lst.find(_ > 2).get) //to get the returned values
    println(map.get(5).getOrElse("No name found")) //if key, return it,  otherwise, return "No name Found"
    println("###########################################################")

    /*
    MAP AND FILTER in scala
    -MAP: Use to apply a function to a collection (every element in the collection)
    -Filter:
     */
    println("--- MAP AND FILTER IN SCALA ---")
    println("###########################################################")
    val lst2 = List(1, 2, 3)
    val map2 = Map(1 -> "Tom", 2 -> "Max", 3 -> "John")
    println(lst2.map(_* 2))
    println(lst2.map(x => x / 0.2))
    println(lst2.map(x => "hi " + x))
    println(lst2.map(x => "hi " * x)) //it'll show hi x times at the element i
    println(map2.mapValues(x => "hi "+ x ))
    println("Hello".map(_.toUpper))
    println(List(List(1,2,3)), List(3,4,5)) //list of list and another list
    println(List(List(1,2,3), List(3,4,5)).flatten) // turn the lists of lists into one regular list
    println(lst2.flatMap(x => List(x, x+1))) //list of element and element+1
    println(lst2.filter(x => x %2 == 0))//even numbers in the list
    println("###########################################################")

    /*
    Reduce, fold or scan
    -Use them to apply a binary operator of each element of a collection and the result of each step is passed
    to the next step
    -Fold is the same as Reduce with the difference that it allows us to pass a parameter to the function
    -scan is the same as Fold, with the difference of scan gives us the map (it's a list) of the intermediate results
    which last element is the final result of applying the function to the our initial collection.
     */
    println("--- REDUCE, FOLD OR SCAN SCALA ---")
    println("###########################################################")
    val lst3 = List(1, 2, 3, 5, 7, 10, 13)
    val lst4 = List("A", "B", "C")
    println(lst3.reduceLeft(_ + _))
    println(lst4.reduceLeft(_+_))
    println(lst3.reduceLeft((x, y) => {println(x + " , "+ y); x + y}))

    println(lst3.reduceLeft(_ - _))
    println(lst3.reduceRight(_ - _))
    println(lst3.reduceRight((x, y) => {println(x + " , "+ y); x + y}))

    println(lst3.foldLeft(100)(_ + _))
    println(lst4.foldLeft("z")(_ + _))

    println(lst3.scanLeft(100)(_ + _))
    println(lst4.scanLeft("z")(_ + _))
    println("###########################################################")
    /*
    Classes
    -Allow us to create objects
    - var getter/setter
    - default
     */
    println("--- CLASSES SCALA ---")
    println("###########################################################")
    class User(private var name: String, var age: Int){
      def printName{println(name)}
    };
//      class User(private var name: String, var age: Int) this is considered as a constructor (the defined constructor)
//    class User(val name: String, val age: Int); //allow it, but then we can't change the values later on
//    class User(private var name: String, var age: Int); field name is private (can't be accessed from outside the class)
    var user = new User("Max", 28);
    user.printName
    println(user.age)
//    user.name = "Tom"
//    user.age = 22
//    println(user.name)
//    println(user.age)
    println("###########################################################")

    /*
    Auxiliar constructors
    - Alternative constructor for a class
    - They're a methods inside of the class called "this"
    - you can have as many as you want to, they have different signature
    - They have to call the previous defined constructor

     */
    println("--- Auxiliary constructor SCALA ---")
    println("###########################################################")
    class User2(private var name: String, var age: Int) {
      def this (){
        this("Tom", 32)
      }
      def this(name: String) {
        this("Tom", 32)
      }
      def printName {println(name)}
    };
    var user1 = new User2("Max", 28) //will call the defined constrcutor
    var user2 = new User2() // will call the first auxiliar constructor (no parameters)
    var user3 = new User2("Max") // will call the second auxiliar constructor (1 parameter)
    user1.printName
    println(user1.age)
    user2.printName
    println(user2.age)
    user3.printName
    println(user3.age)
    println("###########################################################")
    /*
    Extending classes
    - Inheritance to reuse and extend code and functionality

     */
    println("--- EXTENDING CLASSES IN SCALA ---")
    println("###########################################################")
    class Polygon{
      def area: Double = 0.0
    };
    class Rectangle(var width: Double, var height: Double) extends Polygon{
      override def area: Double = width * height;
    };
    class Triangle(var width: Double,  var height: Double) extends Polygon {
      override def area: Double = width * height / 2;
    };

    def printArea(p: Polygon): Unit = {
      println(p.area)
    };

    var poly = new Polygon;
    printArea(poly);
    var rect = new Rectangle(55.2, 20.0);
    printArea(rect);
    var tri = new Triangle(55.2, 20.0);
    printArea(tri);


    println("###########################################################")
    println("###########################################################")
    /*
    Abstract classes
    - They can't be instantiated (need a subclass for it)
    - Abstract methods: Don't have body (subclasses implement them)
    -common interface among subclases.


     */
    println("--- ABSTRACT CLASSES IN SCALA ---")
    println("###########################################################")
    abstract class AbstractPolygon {
      def area: Double;
    };

    class AbstractRectangle(var width: Double, var height: Double) extends AbstractPolygon {
      override def area: Double = width * height;
    };
    class AbstractTriangle(var width: Double, var height: Double) extends AbstractPolygon {
      override def area: Double = width * height / 2;
    };

    def printAbstractArea(p: AbstractPolygon): Unit = {
      println(p.area)
    };

    //var poly = new AbstractPolygon; not allowed
    var abstractRect = new AbstractRectangle(55.2, 20.0);
    printAbstractArea(abstractRect);
    var abstractTri = new AbstractTriangle(55.2, 20.0);
    printAbstractArea(abstractTri);
    println("###########################################################")
    /*
    LAZY EVALUATION
    - Evaluation that delays the evaluation of an expression until its value is needed

     */
    println("--- LAZY EVALUATION IN SCALA ---")
    println("###########################################################")
    lazy val l = 9 //At this moment the value 9 isn't assigned to l
    println(l) //now that we're using l, is when the value 9 is assigned to it.

    class strict{
      val e = {
        println("Strict");
        9
      }
    }

    class LazyEval {
      lazy val l = {//at this moment the value isn't assigned to l
        println("Lazy");
        9
      }
    }

    val x = new strict;
    val y = new LazyEval
    println(x.e)
    println(y.l)//now the we're asking for it, is when the value gets assigned to l, so we can use it.

    def method1(n: Int) {
      println("Method1")
      println(n)
    }

    def method2(n: => Int) {
      println("Method2")
      println(n)
    }
    val add = (a:Int, b:Int) => {
      println("Add")
      a + b
    }
    method1(add(5,6))
    method2(add(5,6))
    println("###########################################################")
    /*
    TRAITS IN SCALA
    - Preface...
        -- Scala (nor java) doesn't admit multiple inheritance
        -- Java interfaces: Set of methods and fields that are implemented/used by
           the classes that implement ("inheritance") from these interfaces.
           Otherwise said, Interfaces are fully abstract classes
        -- Interfaces endow Java of multiple inheritance
    - traits endow Scala of multiple inheritance (like interfaces in java)
    - traits may contain abstract and non-abstract methods
    - traits don't have parameters
    - At least one method in traits should be an abstract method
    - Traits are not allowed to specify a constructor with parameters
    - A class that inherit from a trait, needs to implement (define) all of the abstract methods
      that such trait contains
     */

    println("--- TRAITS IN SCALA ---")
    println("###########################################################")
    trait Shape{
      def color: String; //abstract method
    }

    abstract class AbstractPolygon3{
      def area: Double;
    }
    object AbstractPolygon3{
      def printAreaPolygon3(p: AbstractPolygon3): Unit = {
        println(p.area)
      }
    }

    /*
    This woudln't be allowed due to multiple inheritnace (keyword "with") isn't allowed
    class Rectangle3(var width: Double, var height: Double)
      extends AbstractPolygon3 with shape{
        override def area:Double = width * height
    }
    */
    /* to sort the multiple inheritance problem, we use traits, so we han inheritance from
    one unique class and if we need to inherit from more classes, we use the keyword
    "with" and then the name of the trait*/
    class Rectangle3(var width: Double, var height: Double)
      extends AbstractPolygon3 with Shape {
      override def area: Double = width * height
      //we need to implement the color method cause is abstract
      override def color: String = "Green";
    }
    var rect3 = new Rectangle3(55.2, 20.0);
    println(rect3.area)
    println(rect3.color)
    println("###########################################################")

  }

}

