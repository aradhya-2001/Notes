fun main() {
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    var name: String // declaration
    name = "Ayu" // initialisation
    var age1: Int = 22
    var age2 = 22 // since we declared and intialised at same line so kotlin used type inference to recognize the type of literal assigned.
    val constName = "Singh" // val is const variable
    print("hello $name $constName aged $age1 or $age2")

    println("5 + 5 = ${5 + 5}")
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    println(Int.MAX_VALUE) // 4 bytes
    println(Byte.MAX_VALUE) // Byte data type stores whole no and its size is 1 byte.
    println(Short.MAX_VALUE) // stores whole no and size is 2 bytes.
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    var bool: Boolean = false
    println(bool)
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    var value1 =
        if (true || false) {
            println("if part")
            "last line of if is assigned to value1"
        } else {
            println("else part")
            "last line of else is assigned to value1"
        }
    println(value1)
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    var i = 11
    var value2 =
            when (i) { // below conds are in if else-if i.e. if one is true, exit when.
                in 1..10 -> {
                    println("if i is in range [1,10]")
                    "last line of in is assigned to value2"
                }
                12, 17, 7 -> "if i is 12 or 17 or 7, this string is assigned to value2"

                else -> "last line in else is assigned to value2" // since there is only 1 line so line line is this only.
            }
    println(value2) 

    var j = 7
    var value3 =
            when {
                j <= 10 -> "j <= 10"
                j == 7 || j == 10 -> "j=7 or j=10"
                else -> "else"
            }
    println(value3)
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    var text1 : String? = "name" // '?' at end of String tells our variable can store null.
    
    if(text1 != null) println(text1.length) 
    else println("null")
    println(text1?.length) // equivalent to above if else. Here '?' is called safe call operator 
    
    var text2 : String? = null
    println(text2!!.length) // here !! operator will throw null pointer exception if null is assigned otherwise length 
    
    var text3 : String? = null
    println(text3 ?: "text3 is null") // ?: is called elvis operator. If text3 is not null then text3 is printed otherwise "text3 is null" is printed
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    println(myFun(a = 5, b = 3))
    println(singleLineFunc(a = 3, b = 5))
    println(variableArguments(2, 2, 2, 2))
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    for(x in 1..10) println(x)
    for(x in 1 until 10 step 2) println(x)
    for(x in 10 downTo 1) println(x)
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    outer@ while(true) // labelled the outer loop
    {
        var x = 0
        while(true)
        {
            println("once")
            if(x == 0) break@outer // breaking outer loop 
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    var arr : Array<String> = arrayOf("hii", "hello", "xyz")
    println(arr.size)
    var mixedArr = arrayOf("hii", "hello", 1, 2, 3, 'c')
    println(mixedArr.size)
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    // primary contructor:-
    class PrimaryUser(fn : String, ln : String, age : Int) 
    { 
        var firstName : String // member variables can be assigned here also. Then no need for init 
        var lastName : String
        var age : Int
        var above18 : Boolean
        
        lateinit var movie : String // lateinit keywomrd doesn't work with primitive data type like Int, Char, etc.

        init{ // initializer block (it is executed just after creation of an object)
            this.firstName = fn
            this.lastName = ln
            this.age = age
            this.above18 = this.age > 18
        }
    }
    var user1 = PrimaryUser("ayu", "singh", 17)
    user1.movie = "flash"
    println("${user1.above18}")

    // primary constructor initialized in class header with default values. Directly initialised:-
    class DefaultUser(var firstName : String = "fname", var lastName : String = "lname", var age : Int = 0, var above18 : Boolean = false)
    {
        init{
            above18 = age > 18
        }
    }
    var user2 = DefaultUser("ayu", "singh", 21)
    println("${user2.above18}") 
    var user3 = DefaultUser()
    println("${user3.firstName} , ${user3.lastName} , ${user3.age} , ${user3.above18}")

    // secondary contructor. Notice here no parenthesis
    class secondaryUser 
    { 
        var firstName : String
        var lastName : String
        var age : Int
        var above18 : Boolean

        constructor(fn : String, ln : String, age: Int){  // here constructor() is the secondary constructor which has parameters. 
            firstName = fn
            lastName = ln
            this.age = age
            above18 = age > 18
            println("secondary constructor 1")
        }

        constructor(fn : String, ln : String){  
            firstName = fn
            lastName = ln
            age = 0
            above18 = false
            println("secondary constructor 2")
        }

        constructor(fn : String){  
            firstName = fn
            lastName = "lname"
            age = 0
            above18 = false
            println("secondary constructor 3")
        }

        constructor(){  
            firstName = "fname"
            lastName = "lname"
            age = 0
            above18 = false
            println("secondary constructor 4")
        }
    }
    secondaryUser("ayu", "singh", 17) 
    secondaryUser("ayu", "singh") 
    secondaryUser("ayu") 
    secondaryUser() 
 
    // a secondary constructor may call another secondary constructor of the same class using this() function
    class Add {
     
        constructor(a: Int, b: Int,c: Int) {
            var sumOfThree = a + b + c
            println("The sum of three numbers is: $sumOfThree")
        }
        // calling above constructor
        constructor(a: Int,b:Int) : this(a,b,7) {
            var sumOfTwo = a + b
            println("The sum of two numbers is: $sumOfTwo")
        }
    }
    Add(2,3,4) // this calls both constructors
    Add(2,3) // only calls last constructor

    class HeaderUser(var firstName : String, var lastName : String, var age : Int){
        constructor(firstName : String, lastName : String) : this(firstName, lastName, age = 0) // secondary constructor calls the primary constructor (class header).
        {
            println("secodary constructor 1")
        }

        constructor(firstName : String) : this(firstName, lastName = "lname", age = 0) 
        {
            println("secodary constructor 2")
        }

        constructor() : this(firstName = "fname", lastName = "lname", age = 0) 
        {
            println("secodary constructor 3")
        }
    }
    HeaderUser("ayu", "singh", 21) // calls the primary constructor (class header)
    HeaderUser("ayu", "singh") // this and below 2 calls the secondary constructor
    HeaderUser("ayu")
    HeaderUser()
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    class GetandSet(name : String)
    {
        var name = name
        
        get(){
            return "getter called with value $field \n"
        }

        set(value){
            println("setter called and name is set to $value")
            field = value // if written, name = value then this line again would call setterwhich ends in infinite recursion. So the keywoard field bypasses that error.
        }
    }

    var obj1 = GetandSet("ayu")
    print(obj1.name) // calls getter
    obj1.name = "ayush" // calls setter
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    var res = Static.sum(2,3)
    print(res)
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
  val instance1 = SingletonCustom.getInstance() // calls the func so the static variable "instance" being null, constructor is called by SingletonCustom() and an object or instance is created which is assigned to "instance" var. This var holds the memory address of that instance/object.
  val instance2 = SingletonCustom.getInstance() // on calling the func 2nd time, since instance var is static (is common to a class) is was set to an memory address (on prvs call), is not null . So the same address is returned
  println(instance1)
  println(instance2)

  println(singleton) // an instance is created which will trigger init println. Then the instance's address is printed.
  println(singleton) // since an instance is already created (up). So no new instance is created thats why no init println. Only the  prvs instance' address is printed.
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    class LazyInit(var name : String)
    {
        init {
            println("instance created")
        }
    }

    /* var normalObj = LazyInit("ayu")
    val lazyObj by lazy { LazyInit("ayu") } // can use val only, otherwise error. */
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    for(x in Enum.values()) println(x)

    Enum.NORTH.printData()

    var dir = Enum.NORTH
    println(dir)
    println("${dir.where} ${dir.dist} ${dir.name}") // printing dir.printData() will print "Enum = north and distance = 10" but also prints "kotlin.Unit" in next line. "kotlin.Unit" represents no meaningful value in Kotlin. This is because the printtData() function does not have an explicit return type, so it implicitly returns kotlin.Unit. Therefore, after printing the enum constant data, it also prints the value returned by the printtData() function, which is kotlin.Unit. "Enum.NORTH.printtData()" is a direct call to the function and not part of an expression like dir.printtData(), it doesn't print the value returned by the function.

    println(Enum.valueOf("NORTH"))
//-----------------------------------------------------------------------------------------------------------------------------------------------------------   
    class InnerClass(var a: Int)
    {
        inner class Inner
        {
            fun display(b: Int){
                var sum = a + b 
                println(sum)
            }
        }
     }

    val obj = InnerClass(2)
    obj.Inner().display(3)
//-----------------------------------------------------------------------------------------------------------------------------------------------------------   
    open class Parent(var par: String)
    {
        open fun func(){
            println("Parent")
        }
    }

    open class Child(chi1: String, var chi2: String): Parent(chi1)
    {
        override fun func(){
            println("Child")
            super.func() // calls to the parent func
        }
    }
    var par = Parent("ajay")
    var chi = Child("ayu", "sin")

    par.func()
    chi.func()
//-----------------------------------------------------------------------------------------------------------------------------------------------------------   
    /* var obj1 = SealedClass.Success("SUCCESS")
    var obj2 = SealedClass.Error("ERROR")

    getData(obj1)
    getData(obj2)  */
//-----------------------------------------------------------------------------------------------------------------------------------------------------------   
    // these classes are created to be inherited only. They can't have instances. They can have propeties and functions that is declared but can't be intialized coz initialization has to be done by child classes only.
    abstract class AbstractVehicle(var hasEngine: Boolean = true)
    {
        // this property is not abstract. Called concrete meathods.
        fun type(){
        } 

        // these functions are asbtract so cant have body.
        abstract fun move() 
        abstract fun stop()
    }

    class Car(var name: String): AbstractVehicle()
    {
        override fun move(){

        }

        override fun stop(){

        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------   
    class CustomDataClass(var name: String)
    {
        override fun equals(other: Any?): Boolean
        {
            if(this === other) // if both ahve same memory location then obviously true. 
            {
                println("called 1st if")
                return true
            }

            if(other is CustomDataClass)
            {
                println("called 2nd if")
                return this.name == other.name
            }
            println("RHS of == is of different data type")
            return false
        }

        override fun toString(): String {
            return "name is $name"
        }
    }
    var user11 = CustomDataClass("ayu")
    var user21 = CustomDataClass("ayu")
    var user31 = user11 
    var user41: String = "ayu"

    println(user11 == user31) 
    println(user11 == user21) // "this" is user1 and "other" is user2. When == is not overloaded, it behaves like === operator.
    println(user11.equals(user41))
    println(user41.equals(user11))
    println(user11)

    data class DataClass(var name: String)
    var user5 = DataClass("ayu")
    var user6 = DataClass("ayu")
    var user7 = user5 
    var user8: String = "ayu"

    println(user7 == user5) 
    println(user5 == user6) // "this" is user1 and "other" is user2. When == is not overloaded, it behaves like === operator.
    println(user5.equals(user8))
    println(user8.equals(user5))
    println(user5)
    

}  

//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    fun myFun(a : Int, b : Int) : Int{ // the parameters here are val i.e. constants and name has to be same as arguments. Int outside the parameters means return type is int.
        return if(a > b) a else b
    } 
    fun singleLineFunc(a : Int, b : Int) = if (a > b) a else b // this works without return type coz of type inference
    fun variableArguments(vararg nums : Int) : Int{
        var sum = 0
        for(num in nums) sum += num
        return sum
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    class Static
    {
        companion object {  // meathods and variables declared inside this object are static so class properties are not accesible here and are common to all instances.
            fun sum(a : Int, b : Int) = a + b
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    // here constructor is private so we cannot create an instance like var obj = SingletonCustom()
    class SingletonCustom private constructor() 
    {
        companion object {
            private var instance : SingletonCustom? = null

            fun getInstance() : SingletonCustom? {
                if(instance == null) instance = SingletonCustom()

                return instance
            }
        }
    }

    object singleton {
        init {
            println("instance created")
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    enum class Enum(var where : String, var dist : Int)
    {
        NORTH("north", 10), // these are called enum cosntants and they are instances of enum class. And since our class have properties so each of these intances are also to have those properties. 
        SOUTH("south", 20),
        EAST("east", 15),
        WEST("west", 40);
        
        fun printData() { // at line 224, var dir = Enum.NORTH so printing dir.printData()  prints println of func but also prints kotlin.Unit, 
            println("Enum = $where and distance = $dist")
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    sealed class SealedClass(val messg: String)
    {
        fun showMessg(){
            println("message $messg")
        }
        class Success(messg: String): SealedClass(messg)
        class Error(messg: String): SealedClass(messg)
    }
    fun getData(result: SealedClass){
        when(result)
        {
            is SealedClass.Success -> result.showMessg()
            is SealedClass.Error -> result.showMessg()
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------   
    // these are like abstract classes except it can't have contructors and in here, we can't have concrete meathods and properties. 
    interface Engine
    {
        var hasWheels: Boolean
        fun start()
    }

    class Ship(var name: String): Engine
    {
        override var hasWheels = false
        override fun start(){
            println("$name has started")
        }
    }

    class Plane(var name: String): Engine
    {
        override var hasWheels = true
        override fun start(){
            println("$name has started")
        }
    }

