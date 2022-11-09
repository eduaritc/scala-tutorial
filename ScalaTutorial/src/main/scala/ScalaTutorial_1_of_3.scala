object ScalaTutorial_1_of_3 {

    def main(args: Array[String]): Unit = {
    /*
    ### - String Interpolation - ###
     */

      println("###########################################################")
      println("--- STRING INTERPOLATION ---")
      println("###########################################################")
      val name = "mark"
      val age = 18
      println(name + " is " + age + " years old")
      println(s"$name is $age years old")
      println(f"$name%s is $age%f years old")
      println(s"Hello \n world")
      println(raw"Hello \n world")
      //this is a comment
      /* this is a long
      and
      multiple line comment
       */
      println("###########################################################")
      println("--- IF-ELSE STATEMENT ---")
      println("###########################################################")
      /*
      ### - If/else statement - ###
       */
      val x = 20
      val y = 30
      var res = ""

      if(x == 20 && y == 30){
        res = "x == 20 && y == 30"
      }else{
        res = "x != 20"
      }
      println(res);
      //other of doing the same
      //val res2 = if (x != 20) "x != 20" else "x == 20"
      println(if (x != 20) "x != 20" else "x == 20")
      println("###########################################################")
      println("--- WHILE AND DO-WHILE LOOPS ---")
      println("###########################################################")
      /*
      ### - while and do-while Loops - ###
       */
      var x1 = 0
      while (x < 10){
        println("x = " +x1)
        x1 += 1
      }
      var y1 = 0
      //do while loops get executed at least one time,(even when the conditions is evaluated to false)
      do{
        println("y = "+y1)
        y1 +=1
      }while(y < 10)
      println("###########################################################")
      println("--- FOR LOOPS ---")
      println("###########################################################")
      /*
      ### - for Loops - ###
       */
      for (i <- 1 to 5){
        println("i using to " +i)
      }

      for (i <- 1.to(5)) {
        println("i using to " + i)
      }
      for (i <- 1 until 6 ) {
        println("i using until " + i)
      }
      for (i <- 1 to 6; j <- 1 to 3) {
        println("i using multiples ranges " + i + " " + j)
      }

      val lst = List(1,2,3,4,5,6,7,8,9)

      for (i <- lst) {
        println("i using lst " + i)
      }
      for (i <- lst; if i < 6) {
        println("i using filters " + i)
      }

      var result = for {i <- lst; if i < 6} yield {
        i * i
      }
      println("result "+ result)
      result = for {
        i <- lst
        if i < 6} yield {
        i * i
      }
      println("result "+ result)
      println("###########################################################")
      println("--- MATCH EXPRESSION ---")
      println("###########################################################")
      /*
      ### - Match expresion - ###
       */
      val age1 = 18;
      //match as statement
      age1 match{
        case 20 =>println(age1)
        case 30 =>println(age1)
        case 40 =>println(age1)
        case 20 =>println(age1)
        case 18 =>println(age1)
        case _ => println("Default")

      }
      val age2 = 22
      //match as an expression
      val result_match1 = age2 match {
        case 20 => age2
        case 30 => age2
        case 40 => age2
        case 20 => age2
        case 18 => age2
        case _ => "Default"
      }
      println("Result "+result_match1)

      //printing the same result for multiple match cases
      val iMatch = 7
      iMatch match{
        case 1 | 3 | 5 | 7 | 9 => println("odd")
        case 2 | 4 | 6 | 8 | 10 => println("even")

      }
      println("###########################################################")
      println("--- SCALA FUNCTIONS ---")
      println("###########################################################")
      object Math{
        def add(x: Int, y: Int): Int = {
          return x + y
        }
        def square(x:Int) = x*x
      }

      def add(x:Int, y:Int):Int ={
        return x + y
      }
      def substract(x: Int, y: Int): Int = {
        x - y //last line is considered as the return statement
      }
      def multiply(x: Int, y: Int): Int =  x * y
      def divide(x: Int, y: Int): Int = x / y

      println(Math.add(13,12))
      println(Math.square(25))
      println(Math square 25) //to functions that have only one argument
      println(add(1,2))
      println(substract(2,3))
      println(multiply(3,4))
      println(divide(4,2))

      println("###########################################################")
      println("--- ANONYMOUS FUNCTIONS + DEFAULT VALUES---")
      println("###########################################################")
      object Math1 {
        def add(x: Int = 45, y: Int = 15): Int = {
          return x + y
        }
        /*these are a valid function declaration on scala
        def add(x: Int = 45, y: Int = 15): Int = {
          return x + y
        }

        def **(x: Int) = x*x

        Now, the symbols + and ** are functions
         */

        def square(x: Int) = x * x
        def print(x:Int, y:Int): Unit = {
          println(x+y)
        }
        println(Math1.add())//making use of the default values (Int=45, Int=15)
        println(Math1.add(1,2))
        println(Math1.square(2))

        /*
        These are valid calls to the previous functions (+ and **)
        println(Math.+(1,2))
        println(Math ** 3)
         */
      }
      //Example of anonymous function (functions without a name) that can be assign to variables
      var sum = (x: Int, y: Int) => x + y
      println(sum(300, 500))

      println("###########################################################")
      println("--- HIGHER ORDER FUNCTIONS ---")
      /*
      This functions allow us to pass a undefined function as a function parameter,
      so, whenever we use such parameter, we decided what's this parameter (function)
      task is going to perform
       */
      println("###########################################################")
      def math(x: Double, y:Double, f: (Double, Double) => Double): Double = f(x, y)
      println(math(50, 20, (x,y)=> x+y))
      println(math(50, 20, (x,y)=> x*y))
      println(math(50, 20, (x,y)=> x min y))
      println(math(50, 20, (x,y)=> x max y))


      def math1(x: Double, y:Double, z:Double,  f: (Double, Double) => Double): Double = f(f(x, y), z)
      println(math1(50,20, 10, (x,y) => x + y))
      println(math1(50,20, 10, (x,y) => x * y))
      println(math1(50, 20, 10, (x, y) => x min y))
      println(math1(50, 20, 10, (x, y) => x max y))
      // writing the f function with wildcards (character underscore "_")
      println(math1(50, 20, 10, _ + _))
      println(math1(50, 20, 10, _ max _))
      println("###########################################################")
    }

}
