class Solution {
public:
    bool isPalindrome(string s) {
        string temp;
        for(int i=0; i<s.length(); i++) {
            if(isalnum(s[i])) {
                temp += s[i];
            }
        }
        for (auto& x : temp) {
            x = tolower(x);
        }
        int n = temp.length()-1;
        for(int i=0; i<temp.length()/2; i++) {
            if(temp[i] != temp[n]) {
                return false;
            }
            n--;
        }
        cout<<temp;
        return true;
    }
};
