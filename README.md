# Welcome to Sudoku Solver</br>
</br>
<h1> 1.	Running the Program </br> </h1>
Run the jar file by executing the command: </br>
	<code>java -jar 9x9Solver.jar</code>  </br>
on the terminal to run the solver for a 9x9 Sudoku Puzzle </br>
Alternatively, run the 4x4Solver.jar to solve a 4x4 Sudoku Puzzle: </br>
	<code>java -jar 4x4Solver.jar</code> </br>
</br>
<h1> 2.	Class Design</br> </h1>
The project consists of the following five classes:</br>
<h2> Cell:</br></h2>
The cell class represents each cell of the Sudoku grid. Each cell has the attributes </br>
a)	value : a boolean array which holds true for the index that is filled</br>
b)	isFilled : a boolean variable that denoted if the cell has been filled</br>
c)	row, column : integers denoting the coordinates of the cell</br>
It has the methods:</br>
a)	Cell(int, int) : A constructor that accepts the coordinates as parameters</br>
b)	Cell(int, int, int) : A constructor that accepts the coordinates and value as parameters</br>
c)	setCell(int), unsetCell : To set and unset the cell value</br>
d)	getValue() : Returns the integer filled</br>
e)	toString() : For ease of printing</br>
<h2> Grid: </br></h2>
The grid class represents a sudoku grid. It has the attribute gridOfRows which is a two-dimensional arraylist of ‘Cell’s. It provides the Grid structure to the grid.</br>
It has the methods:</br>
a)	Grid() : A constructor that creates an empty grid of cells.</br>
b)	Grid(Grid) : A constructor that copies the values of a grid to another grid</br>
c)	acceptInput() : A function that accepts user input from the terminal(in the format specified in the sample input).</br>
d)	printGrid() : A function that prints the grid to the command line, if needed.</br>
e)	isSafe(int, Cell) : A function that returns a boolean value based on whether it is safe to assign an integer to a cell in the grid.</br>
<h2> Solver:</br></h2>
Solver has the methods that solve a sudoku. It has a single attribute - ‘solution’ which is an ArrayList of Grid and holds all the possible solutions.</br>
It has the methods:</br>
a)	Solver() : A constructor that intializes an empty ArrayList for solution</br>
b)	solve(Grid) : Solve() uses backtracking to find every possible solution to the given grid. It stores every solution that it finds in the solution ArrayList.</br>
c)	getSolution() : A getter method for solution</br>
<h2> GUI</br></h2>
GUI implements the graphical user interface for displaying the output. It provides an interface to browse through the different available solutions. It has the attributes:</br>
a)	frame : The Jframe of the GUI</br>
b)	mainPanel : A JPanel that contains the other Jpanels. Added to frame.</br>
c)	gridPanel : The JPanel that contains the grid. Added to mainPanel</br>
d)	panel2 : The JPanel that holds the buttons and the output text.</br>
e)	grid : The input Grid that is passed to the constructor</br>
f)	sol : The solution arraylist of Grid</br>
g)	gridLabel : 2-D arraylist containing contents of grid to be displayer. Added to gridPanel</br>
h)	outputText : The JLabel that displays the output text. Added to Panel2</br>
i)	next, previous : JButtons added to panel2 to navigate when multiple solutions are present</br>
The methods present are:</br>
a)	GUI(Grid, List<Grid>) : A constructor that accepts an input grid and a solution grid list. It sets up the GUI with the input Grid and initialises the Swing elements.</br>
b)	updateGUI(Grid) : It updates the GUI with the grid passed</br>
c)	updateGUI(int) : updateGUI that is called based on next or previous operation with different parameters(1 for next(default) and 2 for previous)</br>
d)	actionPerformed(ActionEvent) : The concrete realisation of actionPerformed from ActionListener interface that is used to make the buttons next and previous reactive.</br>
<h2> Driver:</br></h2>
Driver contains the main() function. It has instances of Grid, Solver and GUI. It calles the acceptInput method on the grid. It displays the input array on the GUI and then calls Solver’s solve() method for the grid and calls on GUI to display the solutions.</br>
 </br>
<h1> 3.	Test Cases:</br></h1>
The program expects an integer n as the input in the first line when prompted for the number of elements. The following n lines contain the input to the grid in the format</br>
Row Column Digit</br>
When prompted by the program.</br>
A window pops up with the GUI displaying the input and begins calculating the possible solutions.</br>
Once calculated, the GUI displays the total number of solutions, the current solution and provides an interface to browse through all the possible solutions (when the number of solutions >1).</br>
</br>
<h2> Sample Test Case 0:</br></h2>
Enter number of elements</br>
17</br>
Input 17 elements in the form:</br>
row column digit</br>
1 4 8</br>
1 6 1</br>
2 8 4</br>
2 9 3</br>
3 1 5</br>
4 5 7</br>
4 7 8</br>
5 7 1</br>
6 2 2</br>
6 5 3</br>
7 1 6</br>
7 8 7</br>
7 9 5</br>
8 3 3</br>
8 4 4</br>
9 4 2</br>
9 7 6</br>
</br>
<h2> Sample Test Case 1:</br></h2>
Enter number of elements</br>
29</br>
Input 29 elements in the form:</br>
row column digit</br>
1 1 9</br>
1 3 6</br>
1 5 7</br>
1 7 4</br>
1 9 3</br>
2 4 4</br>
2 7 2</br>
3 2 7</br>
3 5 2</br>
3 6 3</br>
3 8 1</br>
4 1 5</br>
4 7 1</br>
5 2 4</br>
5 4 2</br>
5 6 8</br>
5 8 6</br>
6 3 3</br>
6 9 5</br>
7 2 3</br>
7 4 7</br>
7 8 5</br>
8 3 7</br>
8 6 5</br>
9 1 4</br>
9 3 5</br>
9 5 1</br>
9 7 7</br>
9 9 8</br>
</br>
<h1> 4.	References</br></h1>
1)	Oracle docs</br>
2)	Various examples of testcases from assorted websites</br>
3)	GFGs blogpost on backtracking</br>
4)	Java GUI youtube video by Alex Lee</br>
5)	Various StackOverflow authors for GUI techniques</br>
</br>
