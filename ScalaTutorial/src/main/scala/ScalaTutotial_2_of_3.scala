import java.util.Date
object ScalaTutotial_2_of_3 {
  def log(date:Date, message:String)= {
    print(date + " " + message)
  }
  def main(args: Array[String]): Unit = {
    /*
    ### - Partially applied functions - ###
     */
    println("###########################################################")
    println("--- PARTIALLY APPLIED FUNCTIONS ---")
    println("###########################################################")
    /*
    Functions which we don't pass all of the parameters when we call them
    even when these functions don't have a default parameter or their
    parameters aren't declared with wildcards
     */
    println("###########################################################")
    val sum = (a:Int, b:Int, c:Int) => a + b + c
    val f = sum(10, _:Int,  _:Int)
    println(f(100, 200))
    val date = new Date
    val newLog = log(date, _:String)
    newLog("The message 1\n")
    newLog("The message 2\n")
    newLog("The message 3\n")
    newLog("The message 4\n")

    /*
    CLOSURES IN SCALA
    Closures are functions which uses one or more variables declared outside this function

     */
    println("###########################################################")
    println("--- CLOSURE IN SCALA ---")
    println("###########################################################")
    //impure closure
    var number_impure = 10
    val add_impure = (x: Int) => {


      /*
          -Impure closures are those closure functions which the value of the closure variable change either
          from the inside or the outside the closure function
          -changes made inside of the closure function, affect the closure variable
          -Pure closures are those closure functiosn which the of the closure "variable" can't be
          modified (variable declared as val = valor)
           */
      number_impure = x + number_impure
      number_impure
    }
    number_impure = 15 //closures always take the most recent state of the variable we're using (the variable outside)
    println(add_impure(2))
    println(number_impure)
    //pure closure
    val number_pure= 10
    val add_pure = (x: Int) => {

      //this is not allowed and that's why this is a pure closure number_impure = x + number_impure
      number_impure
    }
    println(add_pure(2))
    println("###########################################################")
    /*
    FUNCTION CARRYING IN SCALA
    Technique of transformation a function that takes multiple aruents into a function
    that takes a single argumement.

     */
    println("###########################################################")
    println("--- FUNCTION CARRYING IN SCALA ---")
    println("###########################################################")
    object Demo{
      def add2(x:Int, y:Int) = x+y
      //carrying function with a parameter and another function which is the one that does the job
      def add3(x:Int) = (y: Int) => x + y
      //Another signature/way of doing the same. With this way, we need to provide all of the arguments or use a wildcard
      def add4(x:Int) (y:Int) = x + y
      println(add2(10, 20))
      println(add3(20)(30))
      val sum40 = add3(40)
      println(sum40(50))
      println(add4(100)(200))
      val sum50 = add4(50)_
      println(sum50(100))
    }
    println("###########################################################")
    /*
    STRINGS IN SCALA
    we can't modify strings in scala, there immutable
    Scala string methods are coming from Java

    */
    println("###########################################################")
    println("--- STRINGS ON SCALA ---")
    println("###########################################################")
    val num1 = 75
    val num2 = 100.25
    val str1 : String = "Hello World"
    val str2 : String = "Max"
    println(str1.length())
    println(str1.concat(str2))
    println(str1 + str2)
    val result = printf("(%d -- %f -- %s)", num1, num2, str1)
    println(result)
    println("(%d -- %f -- %s)".format(num1, num2, str1))
    printf("(%d -- %f -- %s)\n", num1, num2, str1)
    println("###########################################################")
    println("###########################################################")
    /*
    Arrays in scala
     */
    import Array._ // Importing arrays methods in scala
    println("--- ARRAYS IN SCALA ---")
    println("###########################################################")
    val myarray1: Array[Int] = new Array[Int](4)
    val myarray2 = new Array[Int](5)
    val myarray3 = Array(1,2,3,4,5,6,7,8,9)
    myarray1(0) = 20
    myarray1(1) = 30
    myarray1(2) = 40
    myarray1(3) = 50
    println(myarray1)
    for(x <- myarray2){
      //As we diddn't assign any value to array2, it's gonna print the default value for every element
      println(x)
    }
    for (i <- 0 to (myarray1.length - 1)){
      println(myarray1(i))
    }
    val array_result = concat(myarray1, myarray3)
    println(array_result)
    println("###########################################################")
    println("###########################################################")
    /*
    Lists in scala
    -THE MAIN DIFFERENCE BETWEEN ARRAYS AND LISTS, IS THE FACT THAT LISTS
    ARE IMMUTABLE, WHEREAS ARRAYS ARE MUTABLE. This is, we can't change
    the value of one list element, once this one is assigned
    -Lists, represent a linked list, where arrays are flat
     */
    println("--- LISTS IN SCALA ---")
    println("###########################################################")
    val mylist: List[Int] = List(1,2,3,4,5,6,7,8,9)
    val names: List[String] = List("Max", "Tom", "John")
    //mylist(0) = 5 this line would throw an error (this operation is not allowed)
    println(mylist)
    println(names)
    //append element to the begining of the list
    println(0 :: mylist) //this just show an extra element, but it doesn't change the list (they're immutable ;)
    println(mylist)
    println(names)
    // whenever we use "Nil" at the end of the of an expression like: 1 :: 5 :: 7 :: Nil, that'd return a list
    println(1 :: 3 :: 5 :: Nil)
    println(mylist.head) //first element
    println(mylist.tail) //it shows all of the elements after the first one
    println(mylist)
    println(mylist.isEmpty) //is it empty
    println(mylist.reverse) // in reverse order
    println(List.fill(5)(2)) // to create a list with all of the lements same value
    println(mylist.max)
    mylist.foreach(println) // to print all of th element, eac on a different line
    var sumlist : Int = 0
    mylist.foreach(sumlist += _)
    println(sum)
    for (name <- names){
      println(name)
    }
    println(names(0))
    println("###########################################################")
    println("###########################################################")
    /*
    SETS IN SCALA
    -They can't have duplicate values
    -There are two kind of sets: Mutable and Immutable sets
    -Sets in scala are not ordered --> you can't index sets
     */
    println("--- SETS EN SCALA ---")
    println("###########################################################")
    //you can have repeated values inside of a set, but when you print it, just one of them is gonna be shown
    val myset: Set[Int] = Set(1,2,3,4,5,6,7,8,9,9)
    // to set a mutable set we have to declare it as follow:
    var myMutableSet = scala.collection.mutable.Set(1,2,3,4,5,6,7,8,9)
    val names2: Set[String] = Set("Max", "Tom", "John")
    println(myset + 10)//this create a new set (a different one) with the new element (the second element)
    println(myset)
    println(myset(7)) //return true, cause the value 7 is part of the set
    println(names2("Max")) //return true, cause the value Max is part of the set
    println(names2("Maxxxx")) //return false, cause the value Maxxxx is part of the set
    println(myset.head)//print the first element in the set
    println(myset.tail) //print from the second element
    println(myset.isEmpty) //return false cause the set isn't empty
    //concatening sets (method concat - only concatenate unique values)
    println(myset ++ myMutableSet)
    println(myset.++(myMutableSet))
    //set intersection, operator & or intersect method
    println(myset.&(myMutableSet))
    println(myset.intersect(myMutableSet))
    println(myset.min)
    println(myset.max)
    myset.foreach(println)
    for (name <- names2){
      println(name)
    }
    /*
    MAPS IN SCALA
    -Collection of key-value pairs
    -keys are unique in the map
    -If we duplicate a key, the value is gonna be overwritten with the last one
     */
    println("--- MAPS IN SCALA ---")
    println("###########################################################")
    val myMap: Map[Int, String] = Map(
      801 -> "Max",
      802 -> "Tom",
      803 -> "Alex",
      801 -> "Max isn't Max anymore"
    )

    val myMap2: Map[Int, String] = Map(
      701 -> "Tax",
      702 -> "Uom",
      703 -> "Vlex"
    )
    println(myMap)
    println(myMap(801))
    //println(myMap(804)) --> Error, key ins't in the map
    println(myMap.keys)
    println(myMap.values)
    println(myMap.isEmpty)

    myMap.keys.foreach{ key =>
      println("Key "+ key)
      println("Value "+ myMap(key))
    }
    println(myMap.contains(8012))//checking if a key is present in the map
    println(myMap2 ++ myMap2) //Concatenating maps
    println("###########################################################")
    /*
    TUPLES IN SCALA
    -structure that have different kind of element - heterogeneus datatype
    -they are ummatable
    -Only can contain up to 22 elements, if you need more, use another structure
     */
    println("--- TUPLES IN SCALA ---")
    println("###########################################################")
    val myTuple = (1,2,"HELLO", true)
    val mySecondTuple = new Tuple3(1, 2, "HeLLO") //the number in new Tuple got to be same as number of eltos in the tuple
    //val myThirdTuple = new Tuple2(1, 2, "HeLLO") //Error cause Tuple2(1, 2, "Hello") has three elements
    val myFourthTuple = new Tuple3(1, "Hello", (2,3))
    println(myTuple)
    println(myTuple._1)//to get the first element, these indexes are created automatically to access the eltos.
    println(myTuple._2)
    println(myTuple._3)
    println(myTuple._4)

    myTuple.productIterator.foreach({
      i => println(i)
    })
    //joining two tuples
    println(1 -> "TOm", true)
    //getting a value of tuples inside of another tuple --> 3 (second element of tuple(2,3) inside of 4th tuple)
    println(myFourthTuple._3._2)
    println("###########################################################")
  }
}
