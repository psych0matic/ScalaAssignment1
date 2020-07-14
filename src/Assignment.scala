import scala.collection.mutable.HashSet
import scala.collection.mutable.ListBuffer

/*  Scala Assignment 1
 *  Author: Sherwin Adams (216177499)
 *  Date: 14/07/2020
 */

/* RUN THE PROGRAM AND INCREASE YOUR CONSOLE SIZE FOR PRETTY COLOURS :) */

object Assignment extends App{

  /* Task 1: Number sequence between 50 and 100 */
  print(Console.MAGENTA)
  println("\nTask 1: Number sequence between 50 and 100\n")
  val numberSequence = ListBuffer.range(50,101)

  println(numberSequence)

  /* Task 2: Data Structures */
  print(Console.YELLOW)
  println("\nTask 2: Data Structures\n")

  // Define 2 hashsets
  val setOne = HashSet(11,13,15,20,10)
  val setTwo = HashSet(10,7,8,19,10)

  println(s"${Console.BLUE}First set: ${Console.YELLOW}$setOne\n${Console.BLUE}Second set: ${Console.YELLOW}$setTwo")
  // Find duplicates
  println(s"${Console.BLUE}Duplicates in both sets: ${Console.YELLOW}${setOne & setTwo}")

  // Find values that are not in the second list
  println(s"${Console.BLUE}Values not present in second set: ${Console.YELLOW}${setOne &~ setTwo}")

  // Find values that are not in the first list
  println(s"${Console.BLUE}Values not present in first set: ${Console.YELLOW}${setTwo &~ setOne}")

  /* Task 3: Data Structures */
  print(Console.RED)
  println("\nTask 3: Data Structures\n")
  // Define the lists
  val list1 = List(99,10,5,5,7,10,1)
  val list2 = List(10,30.0,50,4,5)

  // Concatenate them
  val newList = List.concat(list1,list2)

  // Get the first number of the list
  val firstNum = s"${Console.BLUE}First number: ${Console.RED}${newList.head}"

  // Get the middle number of the list.
  // If the list is even, print the middle 2 numbers
  val middleNum = newList.length % 2 match {
    case 0 => s"${Console.BLUE}List is even, printing middle 2 numbers: ${Console.RED}${newList(newList.length/2-1)}, ${newList(newList.length/2)}"
    case _ => s"${Console.BLUE}Middle number: ${Console.RED}${newList(newList.length/2)}"
  }
  // Get the last number of the list
  val lastNum = s"${Console.BLUE}Last number: ${Console.RED}${newList.last}"


  println(s"${Console.BLUE}First list: ${Console.RED}$list1\n${Console.BLUE}Second list: ${Console.RED}$list2\n${Console.BLUE}Concatenated list: ${Console.RED}$newList")
  println(s"$firstNum\n$middleNum\n$lastNum")


  /* Task 4: Case classes */
  print(Console.GREEN)
  println("\nTask 4: Case Classes\n")

  // Define CourseInventory case class
  case class CourseInventory(name:String,price:Double)

  // Define Course object that has a method to return a courseID
  case object Course {
    implicit def courseID(course:CourseInventory):Int = course.name.hashCode()
  }

  // Define 3 courses
  val c1 = CourseInventory("ICE362S Elective, FT",40000)
  val c2 = CourseInventory("ICE262S Elective, FT",35000)
  val c3 = CourseInventory("ICF152S Elective, FT",30000)

  // Map a course ID to each course object
  val courseWithHash = Map(
    s"${Console.BLUE}Course Name: ${Console.GREEN}${c1.name}\n${Console.BLUE}Course Price: ${Console.GREEN}${c1.price}" -> s"${Console.BLUE}Course ID: ${Console.GREEN}${Course.courseID(c1)}",
    s"${Console.BLUE}Course Name: ${Console.GREEN}${c2.name}\n${Console.BLUE}Course Price: ${Console.GREEN}${c2.price}" -> s"${Console.BLUE}Course ID: ${Console.GREEN}${Course.courseID(c2)}",
    s"${Console.BLUE}Course Name: ${Console.GREEN}${c3.name}\n${Console.BLUE}Course Price: ${Console.GREEN}${c3.price}" -> s"${Console.BLUE}Course ID: ${Console.GREEN}${Course.courseID(c3)}")

  // Print each course object with its ID
  courseWithHash.foreach {
    case (course,courseID) => println(s"$course\n$courseID\n")
  }

}



