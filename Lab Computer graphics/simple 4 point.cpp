#include <iostream>
#include <vector>

using namespace std;

// Recursive 4-point flood fill function
void floodFill4(vector<vector<char>>& grid, int x, int y, char target, char replacement) {
    // Boundary and condition checks
    if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size())
        return;
    if (grid[x][y] != target || grid[x][y] == replacement)
        return;

    // Replace the character
    grid[x][y] = replacement;

    // 4-directional recursive calls
    floodFill4(grid, x + 1, y, target, replacement); // Down
    floodFill4(grid, x - 1, y, target, replacement); // Up
    floodFill4(grid, x, y + 1, target, replacement); // Right
    floodFill4(grid, x, y - 1, target, replacement); // Left
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

    int startX = 2, startY = 2; // Starting point inside the enclosed area
    floodFill4(grid, startX, startY, ' ', 'F');

    cout << "\nFilled Grid:\n";
    displayGrid(grid);

    return 0;
}
