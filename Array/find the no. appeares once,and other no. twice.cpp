int appearesOnce( vector<int> nums){
  int XOR=0;
  for (int i=0; i<nums.size() ; i++){
    XOR= XOR^nums[i];                   
  }
  return XOR;
}

// 1^1^2^3^3^4^4
//= 0^2^3^3^4^4    same no.^same no.= 0
//=2------> XOR result
