//Brute
vector<int> sortedArray(vector<int>a, vector<int>b) {
  int n1=a.size();
  int n2=b.insert();
  set<int> st;  // contains unoque and sorted elements
  for(int i=0;i<n1;i++){   //itterate though the 1st array//
    st.insert(a[i]);
  }
  for(int i=0;i<n2;i++){   //iterate through the 2nd array//
    st.insert(b[i]);
  }
  vector<int> temp;       //store the elements form the set to the temp vector//
  for(auto it : st){
    temp.push_back(it);
  }
  return temp;
}

//optimal--->two pointer approach
vector<int>sortedArray(vector<int> a, vector<int> b){
  int n1=a.size();
  int n2=b.size();
  int i=0,j=0;
  vector<int> unionArr;
  while (i < n1 && j < n2) {
    if(a[i] <= b[j]) {
      if(unionArr.size()==0 || unionArr.back() != a[i]) {
        unionArr.push_back(a[i]);
      }
      i++;
    }
    else  {
      if(unionArr.size()==0 || unionArr.back() != b[j]) {
        unionArr.push_back(b[j]);
      }
      j++;
    }
  }
     while (i < n1 ) {
      if(unionArr.size()==0 || unionArr.back() != a[i]) {
        unionArr.push_back(a[i]);
      }
      i++;
    }
     while (j < n2 ) {
      if(unionArr.size()==0 || unionArr.back() != b[j]) {
        unionArr.push_back(b[j]);
      }
      j++;
    }  
}
