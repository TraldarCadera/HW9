public class Main {
    public static void main(String[] args) {

        String[][] arr = {
                {"3", "1", "4", "1"},
                {"5", "9", "2", "6"},
                {"5", "8", "4", "16"},
                {"23", "21", "2", "6"}
        };
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Ошибка. Превышен размер массива.");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Неверное значение в массиве.");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }
    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int x = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    x = x + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return x;
    }
}