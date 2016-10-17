class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        vector<int> profits;
        stack<pair<int, int>> pairs;
        
        int v = 0, p = -1;
        while (true) {
            for (v = p + 1; v + 1 < prices.size() && prices[v] >= prices[v+1]; ++v);
            for (p = v; p + 1 < prices.size() && prices[p] <= prices[p + 1]; ++p);
            
            if (v == p) {
                break;
            }
            
            while (!pairs.empty() && prices[v] <= prices[pairs.top().first]) {
                profits.push_back(prices[pairs.top().second] - prices[pairs.top().first]);
                pairs.pop();
            }
            
            while (!pairs.empty() && prices[p] >= prices[pairs.top().second]) {
                profits.push_back(prices[pairs.top().second] - prices[v]);
                v = pairs.top().first;
                pairs.pop();
            }
            
            pairs.emplace(v, p);
        }
        
        while(!pairs.empty()) {
            profits.push_back(prices[pairs.top().second] - prices[pairs.top().first]);
            pairs.pop();
        }
        
        if (profits.size() <= k) {
            return accumulate(profits.begin(), profits.end(), 0);
        } else {
            nth_element(profits.begin(), profits.end() - k, profits.end());
            return accumulate(profits.end() - k, profits.end(), 0);
        }
    }
};
