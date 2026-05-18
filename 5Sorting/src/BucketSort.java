import java.util.ArrayList;
import java.util.Collections;

/**
 *  Bucket Sort Algorithm
 */

public class BucketSort {
    public static void main(String[] args) {
        float[] a = {0.42f,0.32f,0.25f,0.52f,0.23f,0.47f,0.51f,0.91f,0.68f,0.75f};
        for(float ele: a)
            System.out.print(ele+" ");

        System.out.println();
        bucketSort(a);

        for(float ele: a)
            System.out.print(ele+" ");
    }

    static void bucketSort(float[] a){
        ArrayList<Float>[] bucket = new ArrayList[a.length];
        int n = a.length;
        int noOfBuckets = n;  // no of buckets

        // create empty buckets
        for(int i=0; i< noOfBuckets ;i++){
            bucket[i] = new ArrayList<>();
        }

        // adding ele in buckets
        for(int i=0; i<a.length ;i++){
            int idx = (int) (10*a[i]);   // bucket insertion formulae
            bucket[idx].add(a[i]);
        }

        // sort each buckets individually
        for(int i=0;i<n ;i++) {
            Collections.sort(bucket[i]);
        }

        // merge all buckets and replace a
        for(int i=0,k=0; i<n ;i++){
            ArrayList<Float> currBucket = bucket[i];
            for(int j=0 ; j < currBucket.size(); j++){
                a[k++] = currBucket.get(j);
            }
        }
    }
}
