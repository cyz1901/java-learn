import scala.collection.mutable.ArrayBuffer

// 面试错题
class Error {

}


object ShowMeBugTest {

  // 大数相加
  def add(a: Any, b: Any): Any = {
    // a -> string -> char[]
    val arrayA : Array[Char] = a.toString.toCharArray
    val arrayB : Array[Char] = b.toString.toCharArray

    if (arrayA.length == arrayB.length){
      val arrayC: Array[Int] = new Array(arrayA.length)
      for (x <- 0 until arrayA.length) {
        // 不能直接转Int因为会导致变为ascii码
        arrayC(x) = arrayA(x).toString.toInt + arrayB(x).toString.toInt
      }
      arrayC
    }else{
      throw Exception
    }
  }

  def main(args: Array[String]): Unit = {
    val a = "44444444444444444444444444444444444"
    val b = "5555555555555555555555555"
    val c: Array[Int] = add(a,b).asInstanceOf[Array[Int]]
    println(c.mkString("Array(", ", ", ")"))
  }
}