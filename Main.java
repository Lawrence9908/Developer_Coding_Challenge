package com.lawrence;
/**
 * Determines the most frequent number and least frequent
 * Number in the array of integers.
 * @Date 2022/11/24
 * @author Lawrencde Mugwena
 */

import java.util.Collections;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        //An array of integers
	    int[] numbers = {1,3,5,3,7,2,2,3,2,1,3,5};
	    /*
	    * The printResults() Method receive hashtable and array of size 2
	    * which the first element is the max number/value in the hashtable
	    * and second element is minimum value in the hashtable as arguments.
	    * from those two inputs the method print most frequent and least
	    * frequent element of the array.
	    * */
	    printResults(hash(numbers), checkMaxMinValue(hash(numbers)));

    }

    /**
     * Generates a hashtable from given array of integers
     * Each unique value will represent a key and the value
     * Will be the number of time each number appears on the
     * given array of integers.
     * @param myNumbers Array of integer.
     * @return HashTable<Integer, Integer>
     */
    public static Hashtable<Integer,Integer> hash(int[] myNumbers){
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int num: myNumbers) {
            //  add item in the hashtable and initial value of 1.
            if(!hashtable.containsKey(num)){
                hashtable.put(num, 1);
            }else {
                //increment the value with 1 that match with the key.
                hashtable.put(num,hashtable.get(num) +1);
            }
        }
        return hashtable;
    }

    /**
     * Check maximum and minimum value in the hashtable and
     * generate the integer array.
     * @param hashtable HashTable of Integer Key and Integer value.
     * @return integer array.
     */
    public static int[] checkMaxMinValue(Hashtable<Integer, Integer> hashtable){
        // Check for the maximum value from values present in the hashtable
        int maximum = Collections.max(hashtable.values());
        // Check for minimum value from the value present in the hashtable
        int minimum = Collections.min(hashtable.values());

        return new int[]{maximum, minimum};
    }

    /**
     * Print the most frequent number and least frequent
     * in the array of integer.
     * @param hashtable HashTable of integer key and Integer value.
     * @param maxAndMinValue Array of integers.
     */
    public static void printResults(Hashtable<Integer, Integer> hashtable, int[] maxAndMinValue){
        // Iterating over the hash table
        hashtable.forEach((k,v)->{
            // Check for the value that matches with the value at index 0
            // in the given array. if there is a match key will be printed.
            if(v == maxAndMinValue[0]){
                System.out.println("The most frequent number is: "+k);
            }
            // Check for the value that matches with the value at index 1
            // in the given array. if there is a match key will be printed.
            if (v == maxAndMinValue[1]){
                System.out.println("The least frequent number is: "+k);
            }
        });
    }
}
