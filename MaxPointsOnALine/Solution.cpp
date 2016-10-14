class Solution {
public:
    int maxPoints(vector<Point>& points) {
        int result = 0;
        for (int i = 0; i < points.size(); ++i) {
            int samePoint = 1;
            unordered_map<double, int> slopes;
            for (int j = i + 1; j < points.size(); ++j) {
                double xDiff = points[i].x - points[j].x;
                double yDiff = points[i].y - points[j].y;
                if (xDiff == 0) {
                    if (yDiff == 0) {
                        samePoint++;
                    } else {
                        slopes[INT_MAX]++;
                    }
                } else {
                    double slope = yDiff / xDiff;
                    slopes[slope]++;
                }
            }
            
            int currentMax = 0;
            for (auto it = slopes.begin(); it != slopes.end(); ++it) {
                currentMax = max(currentMax, it->second);
            }
            result = max(result, currentMax + samePoint);
        }
        return result;
    }
};
