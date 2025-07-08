#include <iostream>
#include <vector>

using namespace std;

// Recursive 8-point flood fill function
void floodFill8(vector<vector<char>>& grid, int x, int y, char target, char replacement) {
    // Base conditions
    if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size())
        return;
    if (grid[x][y] != target || grid[x][y] == replacement)
        return;

    // Replace the character
    grid[x][y] = replacement;

    // 8-directional recursive calls
    floodFill8(grid, x + 1, y, target, replacement);     // Down
    floodFill8(grid, x - 1, y, target, replacement);     // Up
    floodFill8(grid, x, y + 1, target, replacement);     // Right
    floodFill8(grid, x, y - 1, target, replacement);     // Left
    floodFill8(grid, x + 1, y + 1, target, replacement); // Down-right
    floodFill8(grid, x + 1, y - 1, target, replacement); // Down-left
    floodFill8(grid, x - 1, y + 1, target, replacement); // Up-right
    floodFill8(grid, x - 1, y - 1, target, replacement); // Up-left
}

// Function to display the grid
void displayGrid(const vector<vector<char>>& grid) {
    for (const auto& row : grid) {
        for (char cell : row) {
            cout << cell << ' ';
        }
        cout << endl;
    }
}

int main() {
    // Sample grid
    vector<vector<char>> grid = {
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', '#', '#', '#', '#', '#', ' ', ' '},
        {' ', '#', ' ', ' ', ' ', '#', ' ', ' '},
        {' ', '#', ' ', ' ', ' ', '#', ' ', ' '},
        {' ', '#', '#', '#', '#', '#', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    cout << "Original Grid:\n";
    displayGrid(grid);

    int startX = 2, startY = 2; // Starting point inside the hollow shape
    floodFill8(grid, startX, startY, ' ', 'F');

    cout << "\nFilled Grid:\n";
    displayGrid(grid);

    return 0;
}
