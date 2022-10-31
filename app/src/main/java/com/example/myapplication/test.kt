fun main(){
    println(operations())

}
fun operations():Double{

    var rusult = "2151"
    var operations = "+"
    var result2 = "2112"
    var result3 = "25478"
    var smt = rusult + operations
    var new = smt + result2 + result3

    return new.toDouble()
}