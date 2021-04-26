// https://leetcode.com/problems/minimum-height-trees/

// Runtime: 72 ms, faster than 65.33% of C++ online submissions for Minimum Height Trees.
// Memory Usage: 38.7 MB, less than 27.90% of C++ online submissions for Minimum Height Trees.

#include <vector>
#include <unordered_set>
#include <iostream>
using namespace std;

class Solution
{
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>> &edges)
    {
        if (n < 2)
        {
            return vector<int>{ 0 };
        }
        // Construct an adjacency list
        vector<unordered_set<int>> adjacencyList(n);
        for (auto &edge : edges)
        {
            adjacencyList.at(edge.at(0)).insert(edge.at(1));
            adjacencyList.at(edge.at(1)).insert(edge.at(0));
        }
        // Find the initial leaf nodes
        vector<int> leaves;
        for (int vertexIdx = 0; vertexIdx < adjacencyList.size(); vertexIdx++)
        {
            if (adjacencyList.at(vertexIdx).size() == 1)
            {
                leaves.push_back(vertexIdx);
            }
        }
        // Remove leaves until we have found the centroids
        int verticesLeft = n;
        while (verticesLeft > 2)
        {
            verticesLeft -= leaves.size();
            vector<int> newLeaves;
            for (auto &leafToRemove : leaves)
            {
                // Remove removed leaf from adjacency list
                for (auto &neighborLeaf : adjacencyList.at(leafToRemove))
                {
                    adjacencyList.at(neighborLeaf).erase(leafToRemove);
                    if (adjacencyList.at(neighborLeaf).size() == 1)
                    {
                        newLeaves.push_back(neighborLeaf);
                    }
                }
            }
            leaves = newLeaves;
        }
        // Output result
        return leaves;
    }
};

int main()
{
    Solution test;
    vector<vector<int>> graph;
    graph.push_back(vector<int>{1, 0});
    graph.push_back(vector<int>{1, 2});
    graph.push_back(vector<int>{1, 3});
    auto result = test.findMinHeightTrees(4, graph);
    for (auto const &i : result)
    {
        cout << i << " | ";
    }
}