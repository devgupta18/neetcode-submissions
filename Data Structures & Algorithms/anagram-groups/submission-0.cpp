class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<int>> mp;
        for(int i=0; i<strs.size(); i++) {
            string temp = strs[i];
            sort(temp.begin(), temp.end());
            mp[temp].push_back(i);
        }
        vector<vector<string>> ans;
        for(auto i:mp) {
            vector<string> st;
            for(int j=0; j<i.second.size(); j++) {
                st.push_back(strs[i.second[j]]);
            }
            ans.push_back(st);
        }
        return ans;
    }
};
