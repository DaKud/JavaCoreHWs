## Урок 2. Данные и функции 
1. Полностью разобраться с кодом программы разработанной на семинаре, переписать программу. Это минимальная задача для сдачи домашней работы.

Усложняем задачу:

2. * Переработать метод проверки победы, логика проверки победы должна работать для поля 5х5 и
количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
возможных ситуаций! Используйте вспомогательные методы, используйте циклы!

3. **** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
- #### A universal method for verifying victory
      boolean isWin()
 
- #### A method for a bot that implements a mechanism that allows in some situations to prevent a player from winning on his next turn
      int[] checkHumansMoves()
 
- #### Methods that directly implement the verification of winning combinations
      boolean firsDiagonal()
      boolean secondDiagonal()
      boolean horizontal()
      boolean vertical() 

- #### A universal method for more active blocking of user moves
      boolean findWinPlayersCombination()

- #### A method that adds a search for pre-winner combinations.
      int[] checkPrevention()
 
- #### Methods that directly implement the verification of the Player's pre-win winning combinations for the Bot
      boolean firsDiagonalForBot()
      boolean secondDiagonalForBot()
      boolean horizontalForBot()
      boolean verticalForBot()