# Решение задачи

## Математическое описание решения

Для поиска наибольшей общей подстроки (а не *подпоследовательности*):
* (1) построить обобщенное суффиксное дерево (по вычислениям: O(N), по памяти: O(N), N - длина всех строк)
* (2) найти самые длинные цепочки узлов в ветвях, которые содержат листья для всех входных строк (по вычислениям: O(N K), K - число строк)

Ссылки на описание решения:
* http://en.wikipedia.org/wiki/Longest_common_substring_problem#Suffix_tree
* http://www.cs.ucdavis.edu/~gusfield/cs224f09/commonsubstrings.pdf

## Программная реализация

Для ускорения написания решения была взята реализация суффиксного дерева из репозитория https://github.com/abahgat/suffixtree

В том же репозитории есть реализация LCS: https://github.com/abahgat/suffixtree/tree/commons

Некоторые предложения по улучшению существующей реализации автора @abahgat:
* сделать осмысленными имена переменных
* применить единый стиль написания кода
* развернуть рекурсию `GeneralizedSuffixTree.traverseTree` в цикл

Мною были реализованы ( https://github.com/alexander-myltsev/suffixtree/commits/summer-camp ):
* Класс Main для чтения входных данных из потока ввода в формате:

```
количество_строк
строка_0
строка_1
строка_2
```

Формат вывода (общих наибольших различных подстрок одинаковой длины может быть несколько):

```
наибольшая_общая_подстрока_0
наибольшая_общая_подстрока_1
```

* Реализация стресс-тестирования ( https://github.com/alexander-myltsev/suffixtree/blob/summer-camp/src/test/java/lcs/StressTest.java ) с помощью наивной реализации алгоритма ( https://github.com/alexander-myltsev/suffixtree/blob/summer-camp/src/main/java/lcs/NaiveImplementation.java )

## License

This Generalized Suffix Tree is released under the Apache License 2.0

   Copyright 2012 Alessandro Bahgat Shehata

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.