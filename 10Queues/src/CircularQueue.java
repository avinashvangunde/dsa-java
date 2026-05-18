public class CircularQueue {
    public  static class CircularQImpl{
        int[] q = new int[5];
        int f,r =-1;
        int size = 0;
        int n = q.length;

        void add(int v){
            if(size == 0){
                f = r = 0;
                q[0] = v;
                size++;
            } else if(size == n){
                System.out.println("Queue is full");
            } else if(r < n-1){
                q[++r] = v;
                size++;
            } else if(r == n-1){
                r = 0;
                q[0] = v;
                size++;
            }
        }

        int peek(){
            if(size == 0){
                System.out.println("Queue is empty");
                return -1;
            }
            return q[f];
        }

        int remove(){
            if(size == 0){
                System.out.println("Queue is empty");
                return -1;
            } else {
                int n = q[f];
                if(f == n-1)
                    f=0;
                else
                    f++;
                size--;
                return n;
            }
        }


        void disp(){
            if(f<=r){
                for(int i=f;i<=r;i++){
                    System.out.print(q[i]+" ");
                }
            } else {
                for(int i=0 ;i<=r;i++)
                    System.out.println(q[i]+" ");


                for (int i=f;i<n;i++)
                    System.out.println(q[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Array implementation of circular queue
        CircularQImpl circularQ = new CircularQImpl();
        circularQ.add(10);
        circularQ.add(20);
        circularQ.add(30);
        circularQ.add(40);
        circularQ.add(50);
        circularQ.disp();
        System.out.println(circularQ.peek());
        circularQ.remove();
        circularQ.disp();
        circularQ.remove();
        circularQ.disp();
        System.out.println(circularQ.peek());

    }
}
