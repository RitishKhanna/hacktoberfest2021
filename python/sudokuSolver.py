from tkinter import *


root = Tk()
root.geometry('324x324')


class SolveSudoku():
    def __init__(self):
        self.allZero()
        self.startSolution()

    def allZero(self):
        for i in range(9):
            for j in range(9):
                if savedNumbers[i][j].get() not in ['1', '2', '3', '4', '5', '6', '7', '8', '9']:
                    savedNumbers[i][j].set(0)

    def startSolution(self, i=0, j=0):
        i, j = self.findNextCellToFill(i, j)

        if i == -1:
            return True
        for e in range(1, 10):
            if self.isValid(i, j, e):
                savedNumbers[i][j].set(e)
                if self.startSolution(i, j):
                    return True
                savedNumbers[i][j].set(0)
        return False

    def findNextCellToFill(self, i, j):

        for x in range(i, 9):
            for y in range(j, 9):
                if savedNumbers[x][y].get() == '0':
                    return x, y

        for x in range(0, 9):
            for y in range(0, 9):
                if savedNumbers[x][y].get() == '0':
                    return x, y

        return -1, -1

    def isValid(self, i, j, e):

        for x in range(9):
            if savedNumbers[i][x].get() == str(e):
                return False

        for x in range(9):
            if savedNumbers[x][j].get() == str(e):
                return False

        secTopX, secTopY = 3 * int((i/3)), 3 * int((j/3))
        for x in range(secTopX, secTopX+3):
            for y in range(secTopY, secTopY+3):
                if savedNumbers[x][y].get() == str(e):
                    return False

        return True


class Launch():

    def __init__(self, master):

        self.master = master
        master.title("Sudoku Solver")

        font = ('Arial', 18)
        color = 'white'
        px, py = 0, 0

        self.__table = []
        for i in range(1, 10):
            self.__table += [[0, 0, 0, 0, 0, 0, 0, 0, 0]]

        for i in range(0, 9):
            for j in range(0, 9):

                if (i < 3 or i > 5) and (j < 3 or j > 5):
                    color = 'gray'
                elif i in [3, 4, 5] and j in [3, 4, 5]:
                    color = 'gray'
                else:
                    color = 'white'

                self.__table[i][j] = Entry(master, width=2, font=font, bg=color, cursor='arrow', borderwidth=0,
                                           highlightcolor='yellow', highlightthickness=1, highlightbackground='black',
                                           textvar=savedNumbers[i][j])
                self.__table[i][j].bind('<Motion>', self.correctGrid)
                self.__table[i][j].bind('<FocusIn>', self.correctGrid)
                self.__table[i][j].bind('<Button-1>', self.correctGrid)
                self.__table[i][j].grid(row=i, column=j)

        menu = Menu(master)
        master.config(menu=menu)

        file = Menu(menu)
        menu.add_cascade(label='File', menu=file)
        file.add_command(label='Exit', command=master.quit)
        file.add_command(label='Clear', command=self.clearAll)
        menu.add_cascade(label='Solve', command=self.solveInput)

    def correctGrid(self, event):
        for i in range(9):
            for j in range(9):
                if savedNumbers[i][j].get() == '':
                    continue
                if len(savedNumbers[i][j].get()) > 1 or savedNumbers[i][j].get() not in ['1', '2', '3', '4', '5', '6', '7', '8', '9']:
                    savedNumbers[i][j].set('')

    def clearAll(self):
        for i in range(9):
            for j in range(9):
                savedNumbers[i][j].set('')

    def solveInput(self):
        solution = SolveSudoku()


savedNumbers = []
for i in range(1, 10):
    savedNumbers += [[0, 0, 0, 0, 0, 0, 0, 0, 0]]
for i in range(0, 9):
    for j in range(0, 9):
        savedNumbers[i][j] = StringVar(root)


app = Launch(root)
root.mainloop()
