##包含Kotlin最基本语法的使用
1.不可变变量

    val name = "stephen"
2.可变变量

    var sex = "male"

3.声明int

    var bigInt :Int = Int.MAX_VALUE
    var smallInt:Int = Int.MIN_VALUE
4.字符串链接的两种方式 推荐第二种~

    println("Biggest Int : "+ bigInt)
    println("smallInt Int : $smallInt")

5.判断字符串类型

    if (sex is String){
        println("true")
    }else{
        println("false")
    }

6.$表达式简单的高级用法

    var letterGrade: Char = 'A'
    println("A is a Char : ${letterGrade is Char}")
    //kotlin中 $表达式可以做逻辑的运算和处理，letter is Char 是一个判断语句,并且A是一个是Char类型，所以返回true。控制台输出:A is a Char : true
7.类型转换

	println("3.14 to Int : " + (3.14.toInt()))
	println("A to Int : " + ('A'.toInt()))
	println("65 to Char : " + (65.toChar()))

	//控制台输出
	3.14 to Int : 3
	A to Int : 65
	65 to Char : A
8.String的简单使用

    //长String
    val longStr = """This is a long String"""
    var fName: String = "Luke"
    var lName: String = "W"
    fName = "Sally"    
    var fullName = "$fName $lName"
    println("Name : $fullName")//Run:Sally W
    
    //int的加减逻辑也可以放在这里
    println("1 + 2 = ${1 + 2}")//Run:1 + 2 = 3
    //也可以直接获取长度
    println("String Length =  ${longStr.length}")//Run:String Length =  21
   
    var str1 = "A random String"
    var str2 = "a random String"
    //判断是否相等
    println("Strings Equal : ${str1.equals(str2)}")
    //比较
    println("Compare A to B : ${"A".compareTo("B")}")
    //根据下标，拿到字符。
    println("2nd Index : ${str1.get(2)}") // or println("2nd Index : ${str1[2]}")
    //截取
    println("Index 2 - 7 : ${str1.subSequence(2, 8)}")
    //判断是否包含
    println("Contains random : ${str1.contains("random")} ")  
 9.数组常用方法

    //定义泛型数组
    var myArray = arrayOf(1, 1.23, "luke")
    //根据下标拿值
    println(myArray[2])
    //直接改变下标
    myArray[1] = 3.14
    //拿到长度
    println("Array Size : ${myArray.size}")
    //不用循环，直接可以通过函数判断是否存在某一个值
    println("Luke in Array : ${myArray.contains("luke")}")
    //复制数据前条到新的Array
    var partArray = myArray.copyOfRange(0, 1)
    //拿到第一个
    println("First : ${myArray.first()}")
    //根据值获取下标
    println("Luke Index : ${myArray.indexOf("luke")}")
    
    //通过函数设置数组值 Array(size,{ x -> x * x })
    var sqArray = Array(5, { x -> x * x })
    println(sqArray[3])
    println(sqArray.size)
    //设置Array固定类型
    var arrayInt: Array<Int> = arrayOf(1, 2, 3)
10.通过函数给数组赋值和遍历

    //一到十（表达式）
    val oneTo10 = 1..10;
    //A到Z（表达式）
    val alpha = "A".."Z"
    //判断R是否存在alpha中（代码）
    println("R in Alpha : ${"R" in alpha}")
    //10到1 倒序（代码）
    val tenTo1 = 10.downTo(1)
    //正序（代码）
    val twoTo20 = 2.rangeTo(20)
    //step可以进行任意数量的迭代（其实在这里就是加上下标为0的 每次加3）
    val rng3 = oneTo10.step(3)
    //遍历
    for (x in rng3) println("rng3 : $x")
    //reversed倒序
    for (x in tenTo1.reversed()) println("tenTo1 : $x") 
11.判断 

    //判断语句（if和java一样 就不写了~）
    var age = 100
    //when类似java的switch 不过写法更简单 更灵活
    when (age) {
        0, 1, 2, 3, 4, 5 -> println("幼稚园")
        in 6..12 -> {
            val grade = age - 5
            println("小学${grade}年级")
        }
        in 13..15 -> {
            val grade = age - 12
            println("初$grade")
        }
        in 16..18 -> {
            val grade = age - 15
            println("高$grade")
        }
        else -> println("大学")
    }
12.循环~
		
    val rand = Random();
    val magicNum = rand.nextInt(50) - 1
	
	
    var guess = 0

    while (magicNum != guess) {
        guess += 1
    }

    println("Magic Number was $guess")

    for (x in 1..100) {

        if (x % 2 == 0) continue

        println("Odd : $x")

        if (x == 31) break
    }

    var arr3: Array<Int> = arrayOf(3, 6, 9)

    for (i in arr3.indices) println("Muit 3 : ${arr3[i]}")

    for ((index,value) in arr3.withIndex()){
        println("Index : $index Value : $value")
    }
