#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

vector<pair<int, int>> bresenhamLine(int x1, int y1, int x2, int y2) {
    vector<pair<int, int>> points;
    int dx = x2 - x1;
    int dy = y2 - y1;
    int abs_dx = abs(dx);
    int abs_dy = abs(dy);
    int s1 = dx > 0 ? 1 : -1;
    int s2 = dy > 0 ? 1 : -1;
    bool interchange = false;

    if (abs_dy > abs_dx) {
        swap(abs_dx, abs_dy);
        interchange = true;
    }

    int d = 2 * abs_dy - abs_dx;
    int x = x1;
    int y = y1;

    for (int i = 0; i <= abs_dx; i++) {
        points.push_back(make_pair(x, y));

        while (d >= 0) {
            if (interchange) {
                x += s1;
            } else {
                y += s2;
            }
            d -= 2 * abs_dx;
        }

        if (interchange) {
            y += s2;
        } else {
            x += s1;
        }
        d += 2 * abs_dy;
    }

    return points;
}

void drawGrid(const vector<pair<int, int>>& points) {

    int min_x = points[0].first, max_x = points[0].first;
    int min_y = points[0].second, max_y = points[0].second;
    
    for (const auto& p : points) {
        min_x = min(min_x, p.first);
        max_x = max(max_x, p.first);
        min_y = min(min_y, p.second);
        max_y = max(max_y, p.second);
    }
        min_x = max(0, min_x - 2);
    max_x = max_x + 2;
    min_y = max(0, min_y - 2);
    max_y = max_y + 2;
    
    int width = max_x - min_x + 1;
    int height = max_y - min_y + 1;

    vector<vector<char>> grid(height, vector<char>(width, '.'));
    for (auto& p : points) {
        int gridX = p.first - min_x;
        int gridY = max_y - p.second; 
        if (gridX >= 0 && gridX < width && gridY >= 0 && gridY < height) {
            grid[gridY][gridX] = '#';
        }
    }
    cout << "\n  ";
    for (int x = min_x; x <= max_x; x++) {
        cout << x % 10; 
    }
    cout << "\n";

    for (int y = 0; y < height; y++) {
        int actualY = max_y - y;
        cout << actualY << " ";
        for (int x = 0; x < width; x++) {
            cout << grid[y][x];
        }
        cout << "\n";
    }
}

int main() {
    int x1 = 3, y1 = 2, x2 = 11, y2 = 7;
    
    cout << "=== Bresenham's Line Drawing Algorithm ===" << endl;
    cout << "Drawing line from (" << x1 << "," << y1 << ") to (" << x2 << "," << y2 << ")\n\n";
    
   
    auto points = bresenhamLine(x1, y1, x2, y2);
    
    cout << "Points to be plotted:" << endl;
    for (auto& p : points) {
        cout << "(" << p.first << ", " << p.second << ")" << endl;
    }
    
    cout << "\nLine visualization (with origin at bottom-left):";
    drawGrid(points);
    
    return 0;
}