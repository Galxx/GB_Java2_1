package HW2;

public class Test {

    public static void main(String[] args)  {

        String[][] arrayString1 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8d"}, {"9", "10", "11", "12","32"}, {"13", "14", "15", "1ee"}};;
        Sum(arrayString1);

        String[][] arrayString2 = {{"10", "2", "3", "4"}, {"5", "6", "7", "8d"}, {"9", "10", "11", "12"}, {"13", "14", "15", "1ee"}};
        Sum(arrayString2);

    }

     static void Sum(String[][] arrayString)  {
        int i = 0;
        int j = 0;

        try{
            if (arrayString.length != 4){
                throw new MyArraySizeException();
            }else{
                for (String[] colonm: arrayString) {
                    if (colonm.length !=4){
                        throw new MyArraySizeException();
                    }
                }
            }

        int result = 0;

        for (i = 0; i < arrayString.length; i++) {
            for (j = 0; j < arrayString[i].length; j++) {
                    result += Integer.parseInt(arrayString[i][j]);
            }
        }
        System.out.println(""+result);

        }catch (MyArraySizeException exception){
            System.out.println(exception);
        }catch(NumberFormatException e) {
            throw new MyArrayDataException(i+1, j+1);
        }

    }
}

class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException(int row, int colonm) {
        System.out.println("Ошибка преобразования в ячейке ["+row+"]["+colonm+"]" );
    }

}

class MyArraySizeException extends Exception {

    @Override
    public String toString() {
        return "Размер массива должен быть 4Х4";
    }
}
