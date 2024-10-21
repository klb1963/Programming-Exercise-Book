# String.format()

Метод String.format() в Java используется для создания отформатированных строк.
Он позволяет вам вставлять различные переменные в строку с использованием форматных спецификаторов.
~~~
String formattedString = String.format("string_tamplate", arg1,arg2,arg3 ...... );
~~~
Где:

- string_tamplate - строка-шаблон. Это обычная строка, которая содержит символы вида %s, %d - т.е. спецификаторы, куда нужно
  подставить значения параметров
- args - аргументы, которые будут заменены в строке вместо спецификаторов.

Примеры спецификаторов:

- %d - целое число
- %f - число с плавающей точкой
- %s - строка

Пример: допустим fname = "jack", lname="Johnson" а age=45
~~~
String formattedString = String.format("User: %s %s age:%d", fname,lname,age);
~~~
в formattedString будет лежать строка: "User: jack Johnson age:45"