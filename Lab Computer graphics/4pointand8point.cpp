#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <windows.h> 

using namespace std;

enum Color {
    Black = 0,
    BlueDark = 1,
    GreenDark = 2,
    CyanDark = 3,
    RedDark = 4,
    MagentaDark = 5,
    YellowDark = 6,
    GrayLight = 7,
    GrayDark = 8,
    BlueLight = 9,
    GreenLight = 10,
    CyanLight = 11,
    RedLight = 12,
    MagentaLight = 13,
    YellowLight = 14,
    WhiteLight = 15
};

void ChangeConsoleColor(int foreground, int background = Black) {
    HANDLE consoleHandle = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleTextAttribute(consoleHandle, (WORD)((background << 4) | foreground));
}

void DisplayGrid(const vector<vector<char>>& grid) {
    for (const auto& row : grid) {
        for (char cell : row) {
            if (cell == '#') { 
                ChangeConsoleColor(RedLight);
            } else if (cell == 'F') { 
                ChangeConsoleColor(GreenLight);
            } else {
                ChangeConsoleColor(WhiteLight);
            }
            cout << cell << " ";
        }
        cout << endl;
    }
    ChangeConsoleColor(WhiteLight);
    cout << endl;
}

void RecursiveFloodFill4(vector<vector<char>>& grid, int x, int y, char target, char replacement) {
    if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size()) 
        return;
    if (grid[x][y] != target || grid[x][y] == replacement) 
        return;

    grid[x][y] = replacement;

    RecursiveFloodFill4(grid, x + 1, y, target, replacement);
    RecursiveFloodFill4(grid, x - 1, y, target, replacement);
    RecursiveFloodFill4(grid, x, y + 1, target, replacement);
    RecursiveFloodFill4(grid, x, y - 1, target, replacement);
}

void StackFloodFill4(vector<vector<char>>& grid, int x, int y, char target, char replacement) {
    stack<pair<int, int>> points;
    points.push({x, y});

    while (!points.empty()) {
        pair<int, int> pt = points.top();
        points.pop();
        int x = pt.first, y = pt.second;

        if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size())
            continue;
        if (grid[x][y] != target || grid[x][y] == replacement)
            continue;

        grid[x][y] = replacement;

        points.push({x + 1, y});
        points.push({x - 1, y});
        points.push({x, y + 1});
        points.push({x, y - 1});
    }
}

void RecursiveFloodFill8(vector<vector<char>>& grid, int x, int y, char target, char replacement) {
    if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size()) 
        return;
    if (grid[x][y] != target || grid[x][y] == replacement) 
        return;

    grid[x][y] = replacement;

    RecursiveFloodFill8(grid, x + 1, y, target, replacement);
    RecursiveFloodFill8(grid, x - 1, y, target, replacement);
    RecursiveFloodFill8(grid, x, y + 1, target, replacement);
    RecursiveFloodFill8(grid, x, y - 1, target, replacement);
    RecursiveFloodFill8(grid, x + 1, y + 1, target, replacement);
    RecursiveFloodFill8(grid, x + 1, y - 1, target, replacement);
    RecursiveFloodFill8(grid, x - 1, y + 1, target, replacement);
    RecursiveFloodFill8(grid, x - 1, y - 1, target, replacement);
}

void QueueFloodFill8(vector<vector<char>>& grid, int x, int y, char target, char replacement) {
    queue<pair<int, int>> pointsQueue;
    pointsQueue.push({x, y});
    while (!pointsQueue.empty()) {
        pair<int, int> pt = pointsQueue.front();
        pointsQueue.pop();
        int x = pt.first, y = pt.second;

        if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size())
            continue;
        if (grid[x][y] != target || grid[x][y] == replacement)
            continue;

        grid[x][y] = replacement;

        pointsQueue.push({x + 1, y});
        pointsQueue.push({x - 1, y});
        pointsQueue.push({x, y + 1});
        pointsQueue.push({x, y - 1});
        pointsQueue.push({x + 1, y + 1});
        pointsQueue.push({x + 1, y - 1});
        pointsQueue.push({x - 1, y + 1});
        pointsQueue.push({x - 1, y - 1});
    }
}

int main() {
    vector<vector<char>> grid = {
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', '#', '#', '#', '#', '#', '#', ' ', ' ', ' '},
        {' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' '},
        {' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' '},
        {' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' '},
        {' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' '},
        {' ', '#', '#', '#', '#', '#', '#', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    vector<vector<char>> grid4Rec = grid;
    vector<vector<char>> grid4Stack = grid;
    vector<vector<char>> grid8Rec = grid;
    vector<vector<char>> grid8Queue = grid;

    int startX = 3, startY = 3; 
    cout << "Initial grid:\n";
    DisplayGrid(grid);

    cout << "\n4-point Flood Fill (Recursive):\n";
    RecursiveFloodFill4(grid4Rec, startX, startY, ' ', 'F');
    DisplayGrid(grid4Rec);

    cout << "\n4-point Flood Fill (Stack):\n";
    StackFloodFill4(grid4Stack, startX, startY, ' ', 'F');
    DisplayGrid(grid4Stack);

    cout << "\n8-point Flood Fill (Recursive):\n";
    RecursiveFloodFill8(grid8Rec, startX, startY, ' ', 'F');
    DisplayGrid(grid8Rec);

    cout << "\n8-point Flood Fill (Queue):\n";
    QueueFloodFill8(grid8Queue, startX, startY, ' ', 'F');
    DisplayGrid(grid8Queue);

    return 0;
}