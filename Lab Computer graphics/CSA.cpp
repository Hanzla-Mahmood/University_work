#include <iostream>
using namespace std;

// Define clipping window
const int x_min = 10, y_min = 10, x_max = 30, y_max = 20;

// Bit codes
const int INSIDE = 0; // 0000
const int LEFT   = 1; // 0001
const int RIGHT  = 2; // 0010
const int BOTTOM = 4; // 0100
const int TOP    = 8; // 1000

// Function to compute region code
int computeCode(int x, int y) {
    int code = INSIDE;
    if (x < x_min) code |= LEFT;
    else if (x > x_max) code |= RIGHT;
    if (y < y_min) code |= BOTTOM;
    else if (y > y_max) code |= TOP;
    return code;
}

// Cohen-Sutherland Line Clipping Algorithm
void cohenSutherlandClip(int x1, int y1, int x2, int y2) {
    int code1 = computeCode(x1, y1);
    int code2 = computeCode(x2, y2);
    bool accept = false;

    while (true) {
        if ((code1 | code2) == 0) {
            // Both endpoints inside
            accept = true;
            break;
        } else if ((code1 & code2) != 0) {
            // Line is completely outside
            break;
        } else {
            // Line needs clipping
            int codeOut;
            int x, y;

            // Choose endpoint outside
            codeOut = code1 ? code1 : code2;

            // Find intersection
            if (codeOut & TOP) {
                x = x1 + (x2 - x1) * (y_max - y1) / (y2 - y1);
                y = y_max;
            } else if (codeOut & BOTTOM) {
                x = x1 + (x2 - x1) * (y_min - y1) / (y2 - y1);
                y = y_min;
            } else if (codeOut & RIGHT) {
                y = y1 + (y2 - y1) * (x_max - x1) / (x2 - x1);
                x = x_max;
            } else if (codeOut & LEFT) {
                y = y1 + (y2 - y1) * (x_min - x1) / (x2 - x1);
                x = x_min;
            }

            // Replace the point outside with intersection
            if (codeOut == code1) {
                x1 = x;
                y1 = y;
                code1 = computeCode(x1, y1);
            } else {
                x2 = x;
                y2 = y;
                code2 = computeCode(x2, y2);
            }
        }
    }

    if (accept) {
        cout << "Line accepted from (" << x1 << ", " << y1 << ") to (" << x2 << ", " << y2 << ")\n";
    } else {
        cout << "Line rejected (completely outside the window)\n";
    }
}

int main() {
    cout << "Clipping window: (" << x_min << ", " << y_min << ") to (" << x_max << ", " << y_max << ")\n\n";

    // Test cases
    cohenSutherlandClip(5, 5, 35, 25);     // Partially inside
    cohenSutherlandClip(12, 12, 28, 18);   // Completely inside
    cohenSutherlandClip(1, 1, 4, 4);       // Completely outside
    cohenSutherlandClip(15, 5, 15, 25);    // Vertical line, partially inside

    return 0;
}
