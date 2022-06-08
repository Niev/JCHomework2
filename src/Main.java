public class Main {
    private static final int arrSize = 4;
    private static final String summArr = "Summary: ";
    private static final String incSizeArr = "Incorrect size";
    private static final String incDataArr = "Incorrect data";
    






    public static void main(String[] args) {

        String[][] correctArr = new String[][]
                {{"1", "2", "5", "4"},
                        {"2", "4", "6", "1"},
                        {"4", "1", "8", "7"},
                        {"1", "9", "5", "3"}};
        String[][] incorrectSizeArr = new String[][]
                {{"1", "5", "7", "9"},
                        {"4", "7", "3"},
                        {"3", "2", "1", "4"},
                        {"5", "3", "2", "1"}};
        String[][] incorrectDataArr = new String[][]
                {{"7", "8", "2", "2"},
                        {"2", "V", "7", "2"},
                        {"6", "2", "4", "4"},
                        {"3", "7", "2", "3"}};




        try {
        System.out.println(sum(correctArr));
        System.out.println(sum(incorrectSizeArr));

    } catch (MyArrayExceptions myArrayExceptions) {
        myArrayExceptions.printStackTrace();
    }
        try {
        System.out.println(sum(incorrectDataArr));
    } catch (MyArrayExceptions myArrayExceptions) {
        myArrayExceptions.printStackTrace();
    }
}

    private static String sum(String[][] array) throws MyArrayExceptions {
        checkSizeArray(array);
        checkIntsArray(array);
        return summArr + "\n" + sums(array);
    }

    private static long sums(String[][] array) {
        long result = 0;
        for (String[] strings : array) {
            for (String string : strings) {
                result += (long) Long.parseLong(string);
            }
        }
        return result;
    }

    private static void checkIntsArray(String[][] array) throws MyArrayDataException {
        int row;
        int col;
        for (row = 0; row < array.length; row++) {
            for (col = 0; col < array[row].length; col++) {
                try {
                    Integer.parseInt(array[row][col]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(incDataArr +
                            "\n In row: " + (1 + row) + ", column: " + (1 + col));
                }
            }
        }
    }

    private static void checkSizeArray(String[][] array) throws MyArraySizeException {
        if (array.length != arrSize) {
            throw new MyArraySizeException(incSizeArr);
        }
        for (String[] strings : array) {
            if (strings.length != arrSize) {
                throw new MyArraySizeException(incSizeArr);
            }
        }
    }

}

