import scala.util.control.Breaks.{break, breakable}

object ShowMeBug {

  // esc
  def bubbleSort(array: Array[Int]) {
    var flag = true
    breakable {
      for (x <- 0 until array.length) {
        var temp = 0
        for (y <- x until array.length) {
          if (array(x) > array(y)) {
            temp = array(x)
            array(x) = array(y)
            array(y) = temp
            flag = false
          }
        }
        if (flag) {
          println("break")
          break
        }
      }
    }
  }

  def quickSort(array: Array[Int]): Unit = {
    var left = 0
    var right = array.length - 1
    var pivot = array(left)
    while (left < right) {
      while (left < right && pivot > array(right)) {
        array(left) = array(right)
        left += 1
        right -= 1
      }
      //      if (pivot > array(right)) {
      //        array(left) = array(right)
      //        array(right) = pivot
      //
      //      }
    }
    //    println(s"${array.indices}")
  }

  def main(args: Array[String]) = {
    val unsort_array: Array[Int] = Array[Int](7, 8, 9, 4, 3, 2, 1, 5, 6)
    //    bubbleSort(unsort_array)
    //    println(unsort_array.mkString("Array(", ", ", ")"))
    quickSort(unsort_array)

  }
}