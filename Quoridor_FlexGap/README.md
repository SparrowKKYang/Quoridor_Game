# CS611-Assignment 3
## Name of Assignment: Quoridor game
---------------------------------------------------------------------------
# Team of 2: 
    author1: Chengkai Yang
    Email:  cyang23@bu.edu
    BU_ID: U70568482

    author2: Jingbo Wang
    Email: jw6347@bu.edu
    BU_ID: U04536921 



## Files
---------------------------------------------------------------------------

#### 1. GameCenter.java

    - This class serves as the entrance of the entire project.
    - This class is responsible for choosing which game to play
    - Only this class has the main() method.

#### 2. TurnGame.java

    - This class is the interface of turn based game

#### 3. Menu.java

    - This class menu is with options for player to select option with number 1-N
    - Some static functions serve other classes that need to handle IO

#### 4. CellGroup.java

    - This class is group interface for board and cell
    - So the board can contain sub board

#### 5. Checker.java

    - This class is adding piece for cell with 3 types.

#### 6. Board.java

    - this class represent a configable board for turn based game.

#### 7. Cell.java

    - This class is cell for board. the cell contains a piece with 3 types.

#### 8. TTTGame.java

    - This class defines the game like Tic Tac Toe. other game class inherits it.

#### 9. TicTacToe.java

    - This class inherits from TTTGame.
    - The board's size can be changed, and Its shape can be retangle.

#### 10. OrderAndChaos.java

    - This class inherits from TTTGame.
    - Order and Chaos is on a 6x6 game board with different rules 

#### 11. SuperTicTacToe.java

    - This class inherits from TTTGame.
    - The Super Cells can be accessed using the alphabetic characters A, B, C

#### 12. Player.java

    - This class maintains data of a player. i.e. winning score. 


#### 13. BoardWithWall.java

    - BoardWithWall inherits from Board and implement the game rule.

#### 14. CellWithWall.java

    - It extends from Cell and has a cell with 4 walls.

#### 15. Quoridor.java

    - This class inherits from TTTGame.
    - Quoridoris on a 9x9 game board with flexible board size.  



## Notes
---------------------------------------------------------------------------

#### 1.Common base class TTTGame
```
The base class TTTGame implements the full functionality of a like tic tac toe game. 
All three games inherit this base class and implement their own functions.
They share the same code logic as the base class,
simply overriding the necessary functional functions for customization. 
Increased code reusability.
```

#### 2. Composite designe pattern
```
The class Board and Cell share an interface, CellGroup, to form a combinatorial design pattern.
You can make the board include child boards, which makes it easier to implement Super Tic Tac Toe games.
The code of the base class TTTGame is well reused.
```

#### 3. Rules about SuperTicTacToe
```
getMark for a cell, take the type of the piece.
getMark for a board takes the type of the winner of the board.
The large board contains a small board, and once a winner appears, 
no other pieces are allowed to be placed.
If you can, there will be chaos in the victory of the small chessboard.
Following the previous rule, if the same winner between small boards can connect, 
it means that the player wins
```

### 4. Input validation checking
Input validation checking is usable in this project. for example:
When a player enters a board size, the input validation will be checked for input data type and then maximum value allowed for input validation. When a player plays Super TTT and enter a sub board and then a cell to place, first they need to enter A-I for sub board and then 1-9 for cell, which is also input validation checked. 


#### 5. High Scalability: Flexible board class
```
The board is not limited to squares, it can be rectangular, like m*n, 4x3 board. It is also a configurable x-in-row. These features are convenient for other games.
The algorithm for finding the same pieces on a line is O(n), so the complexity of the algorithm for checking the winner of the board is O(n*n)
```
Quiridor game board is also felxible and can be playing in players' choice of 9*9 or 11*11. 

### 6. High Extendability: Turn based Game interface
```
the class TurnGame interface is for turn based game
if a new game that implements this interface, then the logic of GameCenter does not need to be changed, It can be done easily.
```

#### 7. User-friendly
```
It allowed the user to name the square using that number instead of entering of the row 
number and col number of the square.
The game supports exiting halfway, and when you enter position 0, you can exit the current game in case you have other important things to do. 
```


## X/O represent the two pawns for two players
+---+---+---+---+---+---+---+---+---+
|  1|  2|  3|  4| O |  6|  7|  8|  9|
+---+---+---+---+---+---+---+---+---+
| 10| 11| 12| 13| 14| 15| 16| 17| 18|
+---+---+---+---+---+---+---+---+---+
| 19| 20| 21| 22| 23| 24| 25| 26| 27|
+---+---+---+---+---+---+---+---+---+
| 28| 29| 30| 31| 32| 33| 34| 35| 36|
+---+---+---+---+---+---+---+---+---+
| 37| 38| 39| 40| 41| 42| 43| 44| 45|
+---+---+---+---+---+---+---+---+---+
| 46| 47| 48| 49| 50| 51| 52| 53| 54|
+---+---+---+---+---+---+---+---+---+
| 55| 56| 57| 58| 59| 60| 61| 62| 63|
+---+---+---+---+---+---+---+---+---+
| 64| 65| 66| 67| 68| 69| 70| 71| 72|
+---+---+---+---+---+---+---+---+---+
| 73| 74| 75| 76| X | 78| 79| 80| 81|
+---+---+---+---+---+---+---+---+---+

## To placing a wall that take space of sides of 2 cells, follow the console message and enter the index number for the cell, ie, 11. Then select which side of cell #11 you want to place the wall.
## To get result like below, you need to enter 11 then enter "2" which means down. You can also enter cell 20 then enter 1 which means up and get the same result.  

+---+---+---+---+---+---+---+---+---+
|  1|  2|  3|  4|  5|  6|  7|  8|  9|
+---+---+---+---+---+---+---+---+---+
| 10| 11| 12| 13| O | 15| 16| 17| 18|
+---+###+###+---+---+---+---+---+---+
| 19| 20| 21| 22| 23| 24| 25| 26| 27|
+---+---+---+---+---+---+---+---+---+
| 28| 29| 30| 31| 32| 33| 34| 35| 36|
+---+---+---+---+---+---+---+---+---+
| 37| 38| 39| 40| 41| 42| 43| 44| 45|
+---+---+---+---+---+---+---+---+---+
| 46| 47| 48| 49| 50| 51| 52| 53| 54|
+---+---+---+---+---+---+---+---+---+
| 55| 56| 57| 58| 59| 60| 61| 62| 63|
+---+---+---+---+---+---+---+---+---+
| 64| 65| 66| 67| X | 69| 70| 71| 72|
+---+---+---+---+---+---+---+---+---+
| 73| 74| 75| 76| 77| 78| 79| 80| 81|
+---+---+---+---+---+---+---+---+---+


# The follwing placed a vertical wall that block the right sides of cell 11 and cell 20. It can be done by entering cell index 11 and then "4" which is right. Also can be done by entering cell index 12 and then enter "3" which is left. For more example on how the wall placing works in our Quoridor program, please refer to the Output Example. 
+---+---+---+---+---+---+---+---+---+
|  1|  2|  3|  4| O |  6|  7|  8|  9|
+---+---+---+---+---+---+---+---+---+
| 10| 11# 12| 13| 14| 15| 16| 17| 18|
+---+---+---+---+---+---+---+---+---+
| 19| 20# 21| 22| 23| 24| 25| 26| 27|
+---+---+---+---+---+---+---+---+---+
| 28| 29| 30| 31| 32| 33| 34| 35| 36|
+---+---+---+---+---+---+---+---+---+
| 37| 38| 39| 40| 41| 42| 43| 44| 45|
+---+---+---+---+---+---+---+---+---+
| 46| 47| 48| 49| 50| 51| 52| 53| 54|
+---+---+---+---+---+---+---+---+---+
| 55| 56| 57| 58| 59| 60| 61| 62| 63|
+---+---+---+---+---+---+---+---+---+
| 64| 65| 66| 67| 68| 69| 70| 71| 72|
+---+---+---+---+---+---+---+---+---+
| 73| 74| 75| 76| X | 78| 79| 80| 81|
+---+---+---+---+---+---+---+---+---+


#### 8. Quoridor
```
Quoridor inherits TTTGAME and uses the BoardWithWall and CellWithWall classes. These two also inherit Board and Cell, respectively. The other classes are basically unchanged, except for Player, which increases the amount of data. In order that the walls do not block the pieces, use the method of recursive backtracking to find the path.
```


## How to compile and run
---------------------------------------------------------------------------
Your directions on how to run the code. Ideally should resemble the lines below

1. Navigate to the directory "YourCodeDirectory" after unzipping the files
2. Run the following command line:
    mkdir -p bin && javac *.java -d bin
    java -cp ./bin GameCenter

If using Java GUI to run the program
1. Copy-paste all the files mentioned above to the **/src** folder.   
2. Create a new JAVA project from Exsiting Sources
3. Run the main in GameCenter.java




## Input/Output Example
---------------------------------------------------------------------------

    Welcome to play TTT games.
    you have  games to choose.

    1. Quoridor
    2. Tic Tac Toe
    3. Order and Chaos
    4. Super Tic Tac Toe
    5. exit game
    Please input 1 - 5: 1
    You will play quoridor
    Please enter one player's name: 1
    Please enter the other player's name: 2
    Quoridor is played on a game board of 81 square spaces (9×9). Each
    player is represented by a pawn which begins at the center space of
    one edge of the board (in a two-player game, the pawns begin
    opposite each other). The objective is to be the first player to move
    their pawn to any space on the opposite side of the game board from
    which it begins.

    Please Choose who play first.
    1. 1
    2. 2
    Please input 1 - 2: 1
    choose board size
    1. 9*9
    2. 11*11
    Please input 1 - 2: 1
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4| O |  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+---+---+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33| 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42| 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| X | 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 2
    Select a cell as the start position of wall (The wall take sapce of 2 cells' side, enter 0 to exit game). 
    Please input 0 - 81: 13

    Input direction for placing the wall on selected cell. you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4| O |  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33| 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42| 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| X | 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 1
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4| O |  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33| 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42| 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| X | 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| O | 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33| 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42| 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| X | 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| O | 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33| 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42| 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| X | 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    This move is invalid.
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 4
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| O | 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33| 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42| 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| X | 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 1
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| O | 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33| 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42| 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| X | 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| O | 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33| 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42| 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| X | 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 2
    Select a cell as the start position of wall (The wall take sapce of 2 cells' side, enter 0 to exit game). 
    Please input 0 - 81: 33

    Input direction for placing the wall on selected cell. you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 4
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| O | 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42# 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| X | 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| O # 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42# 43| 44| 45|
    +---+---+---+---+---+---+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| X | 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 2
    Select a cell as the start position of wall (The wall take sapce of 2 cells' side, enter 0 to exit game). 
    Please input 0 - 81: 41

    Input direction for placing the wall on selected cell. you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| O # 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| X | 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| O # 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| X | 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 1
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| O # 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| X | 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    This move is invalid.
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 3
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| O | 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| X | 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 1
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| O | 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| X | 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 3
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| O | 41| 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| X | 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 3
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| O | 41| 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| X | 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| X | 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| O | 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 1
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| X | 41| 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| O | 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| 31| 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| X | 41| 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| O | 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 1
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| X | 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| O | 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| 76| 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9|
    +---+---+---+---+---+---+---+---+---+
    | 10| 11| 12| 13| 14| 15| 16| 17| 18|
    +---+---+---+###+###+---+---+---+---+
    | 19| 20| 21| 22| 23| 24| 25| 26| 27|
    +---+---+---+---+---+---+---+---+---+
    | 28| 29| 30| X | 32| 33# 34| 35| 36|
    +---+---+---+---+---+---+---+---+---+
    | 37| 38| 39| 40| 41| 42# 43| 44| 45|
    +---+---+---+---+###+###+---+---+---+
    | 46| 47| 48| 49| 50| 51| 52| 53| 54|
    +---+---+---+---+---+---+---+---+---+
    | 55| 56| 57| 58| 59| 60| 61| 62| 63|
    +---+---+---+---+---+---+---+---+---+
    | 64| 65| 66| 67| 68| 69| 70| 71| 72|
    +---+---+---+---+---+---+---+---+---+
    | 73| 74| 75| O | 77| 78| 79| 80| 81|
    +---+---+---+---+---+---+---+---+---+

    Congratulations 1!
    You are the winner!
    Would you like to start another round?
    Press 'y' to continue, or any other key to exit game.y
    Quoridor is played on a game board of 81 square spaces (9×9). Each
    player is represented by a pawn which begins at the center space of
    one edge of the board (in a two-player game, the pawns begin
    opposite each other). The objective is to be the first player to move
    their pawn to any space on the opposite side of the game board from
    which it begins.

    Please Choose who play first.
    1. 1
    2. 2
    Please input 1 - 2: 1
    choose board size
    1. 9*9
    2. 11*11
    Please input 1 - 2: 2
    +---+---+---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5| O |  7|  8|  9| 10| 11|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 12| 13| 14| 15| 16| 17| 18| 19| 20| 21| 22|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 23| 24| 25| 26| 27| 28| 29| 30| 31| 32| 33|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 34| 35| 36| 37| 38| 39| 40| 41| 42| 43| 44|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 45| 46| 47| 48| 49| 50| 51| 52| 53| 54| 55|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 56| 57| 58| 59| 60| 61| 62| 63| 64| 65| 66|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 67| 68| 69| 70| 71| 72| 73| 74| 75| 76| 77|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 78| 79| 80| 81| 82| 83| 84| 85| 86| 87| 88|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 89| 90| 91| 92| 93| 94| 95| 96| 97| 98| 99|
    +---+---+---+---+---+---+---+---+---+---+---+
    |100|101|102|103|104|105|106|107|108|109|110|
    +---+---+---+---+---+---+---+---+---+---+---+
    |111|112|113|114|115| X |117|118|119|120|121|
    +---+---+---+---+---+---+---+---+---+---+---+

    Hi, 1:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 1
    you have 4 directions to choose
    1. up
    2. down
    3. left
    4. right
    Please input 1 - 4: 2
    +---+---+---+---+---+---+---+---+---+---+---+
    |  1|  2|  3|  4|  5|  6|  7|  8|  9| 10| 11|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 12| 13| 14| 15| 16| O | 18| 19| 20| 21| 22|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 23| 24| 25| 26| 27| 28| 29| 30| 31| 32| 33|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 34| 35| 36| 37| 38| 39| 40| 41| 42| 43| 44|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 45| 46| 47| 48| 49| 50| 51| 52| 53| 54| 55|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 56| 57| 58| 59| 60| 61| 62| 63| 64| 65| 66|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 67| 68| 69| 70| 71| 72| 73| 74| 75| 76| 77|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 78| 79| 80| 81| 82| 83| 84| 85| 86| 87| 88|
    +---+---+---+---+---+---+---+---+---+---+---+
    | 89| 90| 91| 92| 93| 94| 95| 96| 97| 98| 99|
    +---+---+---+---+---+---+---+---+---+---+---+
    |100|101|102|103|104|105|106|107|108|109|110|
    +---+---+---+---+---+---+---+---+---+---+---+
    |111|112|113|114|115| X |117|118|119|120|121|
    +---+---+---+---+---+---+---+---+---+---+---+

    Hi, 2:
    Please choose your action
    1. move a piece
    2. place a wall
    3. exit game
    Please input 1 - 3: 2
    Select a cell as the start position of wall (The wall take sapce of 2 cells' side, enter 0 to exit game). 
    Please input 0 - 121: 0
    Would you like to start another round?
    Press 'y' to continue, or any other key to exit game.w
    Good job, guys!
    Player 1 gets 1 points
    Player 2 gets 0 points
    See you next time.
    Welcome to play TTT games.
    you have  games to choose.

    1. Quoridor
    2. Tic Tac Toe
    3. Order and Chaos
    4. Super Tic Tac Toe
    5. exit game
    Please input 1 - 5: 5
    


