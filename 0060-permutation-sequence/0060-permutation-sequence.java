class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            numbers.add(i);
        }
        int factorial = 1;
        for(int i = 1; i < n; i++){
            factorial *= i;
        }
        k--;
        StringBuilder result = new StringBuilder();
        for(int i =n; i > 0; i--){
            int index = k / factorial;
            result.append(numbers.get(index));
            numbers.remove(index);
            k = k % factorial;
            if(i > 1){
                factorial /= (i - 1);
            }
        }
        return result.toString();
    }
}