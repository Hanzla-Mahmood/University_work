#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

// Struct to store a 2D point
struct Point {
    int x, y;
};

// DDA Algorithm: computes all points of the line
vector<Point> DDA(int x1, int y1, int x2, int y2) {
    vector<Point> points;

    int dx = x2 - x1;
    int dy = y2 - y1;

    int steps = max(abs(dx), abs(dy));
    float xInc = dx / (float)steps;
    float yInc = dy / (float)steps;

    float x = x1;
    float y = y1;

    for (int i = 0; i <= steps; i++) {
        int roundedX = round(x);
        int roundedY = round(y);
        points.push_back({roundedX, roundedY});
        cout << "Point " << i << ": (" << roundedX << "," << roundedY << ")\n";
        x += xInc;
        y += yInc;
    }

    return points;
}

// Function to draw ASCII grid with plotted points
void drawGrid(const vector<Point>& points, int width, int height) {
    cout << "\nGrid View:\n";
    for (int y = height - 1; y >= 0; y--) {
        cout << y << (y < 10 ? "  | " : " | ");
        for (int x = 0; x < width; x++) {
            bool found = false;
            for (const auto& p : points) {
                if (p.x == x && p.y == y) {
                    cout << "* ";
                    found = true;
                    break;
                }
            }
            if (!found) cout << ". ";
        }
        cout << endl;
    }

    // X-axis
    cout << "    ";
    for (int x = 0; x < width; x++) cout << "--";
    cout << "\n     ";
    for (int x = 0; x < width; x++) cout << x % 10 << " ";
    cout << endl;
}

int main() {
    int x1 = 3, y1 = 2, x2 = 11, y2 = 7;

    cout << "DDA Line from (" << x1 << "," << y1 << ") to (" << x2 << "," << y2 << "):\n\n";

    // Run DDA and get all plotted points
    vector<Point> points = DDA(x1, y1, x2, y2);

    // Show points on a grid (change size if needed)
    drawGrid(points, 15, 10);

    return 0;
}
