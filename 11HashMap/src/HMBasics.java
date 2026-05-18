import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HMBasics {

    // Map Interface <-- HashTable , HashMap , TreeMap
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",140);
        hm.put("China",120);
        hm.put("Pak",25);
        hm.put("US",100);
        System.out.println(hm);

        hm.put("Nigeria",5);
        hm.put("US",110);
        System.out.println(hm);


        System.out.println(hm.get("India"));
        System.out.println(hm.get("Utopia"));

        System.out.println(hm.containsKey("India"));

        System.out.println(hm.remove("Pak"));

        /**  Keyset -> we get all keys from hashmap **/
        Set<String> set = hm.keySet();

        for(String key : hm.keySet())
            System.out.println(key+" "+hm.get(key));

        // get all keys in hm
        System.out.println(hm.keySet());

        // get all values in hm
        System.out.println(hm.values());

        // get all entries in hm
        System.out.println(hm.entrySet());

        for(Map.Entry<String,Integer> e : hm.entrySet()){
            System.out.println(e.getKey() +" "+ e.getValue());
        }

        // null as key
        hm.put(null,100);
        System.out.println(hm);
        System.out.println(hm.get(null));


        // given an array print highest frequent element from the array
        int[] a = {1,3,2,4,1,1,4,4,4,4,4,};
        Map<Integer,Integer> freq = new HashMap<>();

        for(int i=0; i<a.length ;i++){
            if(freq.containsKey(a[i])){
                int val = freq.get(a[i]);
                freq.put(a[i],val+1);
            }else{
                freq.put(a[i],1);
            }
        }

        System.out.println(freq);
        int max =0;
        int ans =0;
        for(Integer v : freq.keySet()){
            if(freq.get(v) > max) {
                max = freq.get(v);
                ans = v;
            }
        }
        System.out.println(ans);
    }
}
