## ArrayList
В чем преимущества ArrayList?
- не надо думать о размере, он сам расширяется по мере необходимости (initial capacity 10 элементов, в 1,5 раза)
- не надо думать о переиндексации при вставке элемента
- каждый элемент имеет индекс
- быстрое добавление в конец списка
- можно вносить дубликаты
- можно отсортировать

Недостатки:
- медленное O(n) добавление элемента в середину или начало списка
- допускает наличие дубликатов

## HashSet
В чем преимущества HashSet?
- не содержит дубликатов
- быстрая вставка, поиск элемента

Недостатки:
- нет индексов
- невозможна сортировка