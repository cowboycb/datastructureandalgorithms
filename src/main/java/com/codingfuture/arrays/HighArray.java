package com.codingfuture.arrays;

class HighArray {

    private long[] array;                 // ref to array a

    private int nElems;               // number of data items

    //-----------------------------------------------------------

    public HighArray(int max)         // constructor

    {

        array = new long[max];                 // create the array

        nElems = 0;                        // no items yet

    }

    //-----------------------------------------------------------

    public boolean find(long searchKey) {                              // find specified value

        int j;

        for (j = 0; j < nElems; j++)            // for each element,

            if (array[j] == searchKey)           // found item?

                break;                       // exit loop before end

        if (j == nElems)                    // gone to end?

            return false;                   // yes, can't find it

        else

            return true;                    // no, found it

    }  // end find()

    //-----------------------------------------------------------

    public void insert(long value)    // put element into array

    {

        array[nElems] = value;             // insert it

        nElems++;                      // increment size

    }

    //-----------------------------------------------------------

    public boolean delete(long value) {

        int j;

        for (j = 0; j < nElems; j++)        // look for it

            if (value == array[j])

                break;

        if (j == nElems) {               // can't find it
            System.out.println("Not Found " + value);
            return false;

        }else                           // found it
        {

            for (int k = j; k < nElems; k++) // move higher ones down

                array[k] = array[k + 1];

            nElems--;                   // decrement size
            System.out.println("Deleted " + value);
            return true;

        }

    }  // end delete()

    //-----------------------------------------------------------

    public void display()             // displays array contents

    {

        for (int j = 0; j < nElems; j++)       // for each element,

            System.out.print(array[j] + " ");  // display it

        System.out.println("");

    }

    public long getMax(){
        if (nElems == 0) { return -1; }
        long max = array[0];
        for (int i = 1; i < nElems; i++) {
            if (array[i]>max){
                max = array[i];
            }
        }
        return max;
    }

    public long removeMax(){
        long max = getMax();
        if (max != -1) {
            delete(max);
        }
        return max;
    }

    //-----------------------------------------------------------

}  // end class HighArray

////////////////////////////////////////////////////////////////

