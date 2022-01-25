#include <bits/stdc++.h>
using namespace std;
vector<unordered_set<int> > make_graph(int numTasks, vector<pair<int, int> >& prerequisites)
{
	vector<unordered_set<int> > graph(numTasks);
	for (auto pre : prerequisites)
		graph[pre.second].insert(pre.first);
	return graph;
}
vector<int> compute_indegree(vector<unordered_set<int> >& graph)
{
	vector<int> degrees(graph.size(), 0);
	for (auto neighbors : graph)
		for (int neigh : neighbors)
			degrees[neigh]++;
	return degrees;
}
vector<int> findOrder(int numTasks,
		vector<pair<int, int> >& prerequisites)
{
	vector<unordered_set<int> > graph =
			make_graph(numTasks, prerequisites);
	vector<int> degrees = compute_indegree(graph);
	queue<int> zeros;
	for (int i = 0; i < numTasks; i++)
		if (!degrees[i])
			zeros.push(i);
	vector<int> toposort;
	for (int i = 0; i < numTasks; i++) {
		if (zeros.empty())
			return {};
		int zero = zeros.front();
		zeros.pop();
		toposort.push_back(zero);
		for (int neigh : graph[zero]) {
			if (!--degrees[neigh])
				zeros.push(neigh);
		}
	}
	return toposort;
}
int main()
{
	int numTasks = 4;
	vector<pair<int, int> > prerequisites;
	prerequisites.push_back(make_pair(1, 0));
	prerequisites.push_back(make_pair(2, 1));
	prerequisites.push_back(make_pair(3, 2));
	vector<int> v = findOrder(numTasks, prerequisites);

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << " ";
	}

	return 0;
}

