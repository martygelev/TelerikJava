package ok;

import java.util.ArrayList;
import java.util.List;

public class Asteroid {
    public static void main(String[] args) {
        int[] arr = {-2,1,-2,1};

       int[] result =  asteroidCollision(arr);

        for (int i : result) {
            System.out.print(i + ", ");
        }
    }
    public static int[] asteroidCollision(int[] asteroids){
        List<Integer> stack = new ArrayList<>();
        for (int asteroid : asteroids) {
            stack.add(asteroid);
        }

        int counter = stack.size()-1;
        while (counter>=1){
            int lastValue = stack.get(counter);
            int prevValue = stack.get(--counter);
            int prevIndex = stack.lastIndexOf(prevValue);
            int lastValueIndex = stack.lastIndexOf(lastValue);

            if (lastValue>0 && prevValue>0){
                continue;
            }
            if (lastValue<0 && prevValue<0){
                continue;
            }

            if (prevValue>0 && lastValue<0){
                lastValue=Math.abs(lastValue);
                if (lastValue>prevValue){
                    prevValue=-lastValue;
                    try{
                        stack.remove(lastValueIndex);
                        }
                    catch(Exception e){
                        stack.remove(stack.indexOf(lastValue));

                    }

                    try {
                        stack.remove(prevIndex);
                    }catch (Exception e){
                        stack.remove(stack.indexOf(prevValue));
                    }

                    stack.add(prevValue);

                }
                else if (prevValue==lastValue){
                    stack.remove(lastValueIndex);
                    stack.remove(prevIndex);
                    counter--;
                }
                else if (prevValue>lastValue){
                    stack.remove(lastValueIndex);
                }

            }
        }

        int[] arr = new int[stack.size()];
        for (int i =0; i<stack.size();i++){
            arr[i]=stack.get(i);
        }

        return arr;
    }
}
