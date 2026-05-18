import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Questions2 {
    static boolean validAnagram(String str1 , String str2){
        if(str1.length()!= str2.length()) return false;

        Map<Character,Integer> mp = new HashMap<>();
        for(char ch : str1.toCharArray()){
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }else{
                mp.put(ch,1);
            }
        }

        System.out.println(mp);
        for(char ch: str2.toCharArray()){
            if(mp.containsKey(ch))
                mp.put(ch,mp.get(ch)-1);
            else
                return false;
        }

        for(Integer val : mp.values()){
            if(val != 0)  return false;
        }

        return true;
    }


    static boolean checkIsomorphic(String s , String t){
        if(s.length() != t.length()) return false;

        Map<Character,Character> mp = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mp.containsKey(c1)){
                char val = mp.get(c1);
                if(val != c2)
                    return false;
            } else {
                if(hs.contains(c2))
                    return false;

                mp.put(c1, c2);
                hs.add(c2);
            }
        }
        System.out.println(mp);
        return true;
    }

    static int[] twoSum(int[] a,int tar){
        Map<Integer,Integer> hm = new HashMap<>();

        int[] ans = new int[2];
        for(int i=0;i<a.length;i++){
            int v = tar - a[i];
            if(hm.containsKey(v)){
                ans[0] = i;
                ans[1] = hm.get(v);
                return ans;
            }else{
                hm.put(a[i],i);
            }
        }

        return ans;
    }

    private static int[] prefixSum(int[] a){
        for(int i=1;i<a.length;i++)
            a[i] = a[i]+a[i-1];

        System.out.println(Arrays.toString(a));
        return a;
    }

    static int maxSubArray0Sum(int[] a){
        int[] pref = prefixSum(a.clone());
        Map<Integer,Integer> mp = new HashMap<>();

        int maxLen = 0;
        for(int i=0; i<pref.length ;i++){
            if(mp.containsKey(pref[i])){
                maxLen = Math.max(maxLen ,i - mp.get(pref[i]));
            } else{
                mp.put(pref[i],i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Quest1 : Valid anagram ,, two given string are anagrams of each other  if all characters from str1 is present in str2
        String str1 = "keen";
        String str2 = "knee";
        //System.out.println(validAnagram(str1,str2));

        // Quest2 : Isomorphic strings ,, if char in str1 can be replaced with char in str2
        String s = "badc";
        String t = "baba";
        System.out.println(checkIsomorphic(s,t));


        // Quest3: two sum
        int[] a = {3,2,4};
        int tar = 6;
        int[] ans = twoSum(a,tar);
        System.out.println(ans[0]+" "+ans[1]);

        // Quest4: largest subarray with sum '0'

        int[] arr = {15,-2,2,-8,1,7,10};
        System.out.println(maxSubArray0Sum(arr));

    }
}
