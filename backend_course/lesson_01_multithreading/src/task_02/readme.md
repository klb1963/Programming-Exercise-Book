````
Задача.
Имеется целочисленный счётчик.
Работают три потока.
Каждый поток увеличивает миллион раз значение счётчика на единицу,
после чего значение выводится в консоль.
Ожидаемое значение счётчика: 3_000_000
Действительное значение счётчика: непредсказуемо.
Тем самым демонстрируем студентам проблему доступа к общему ресурсу в многопоточности.