object ScalaTutorial {

    def main(args: Array[String]): Unit = {
    /*
    ### - String Interpolation - ###
     */
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
    }
}
