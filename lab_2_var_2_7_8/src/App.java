import java.util.Scanner;
import java.util.Formatter;
import java.util.Calendar;
import java.util.Arrays;

// Лабораторная №2
// Вариант 2, задачи 7 и 8

public class App {
    public static void main(String[] args) throws Exception {
        Formatter f = new Formatter();
        Calendar c = Calendar.getInstance();

        System.out.println(f.format(
                "Усманов%nВремя получения задания: 18 февраля 2022 5:25 pm%nВремя сдачи задания: %te %tB %tY %tl:%tM %tp",
                c, c, c, c, c, c
            )
        );

        System.out.println("Введите n:");

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        int[][] matrix = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                matrix[i][j] = (int) ((Math.random() * ((n) - (-n))) + (-n));
            }
        }

        console.close();

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        System.out.println("Определитель матрицы : "
                         + determinantOfMatrix(matrix, n));

        System.out.println("Поворот матрицы на 90 градусов:");
        rotateMatrixAnticlockwise90(matrix);
        printMatrix(matrix);
        
        System.out.println("Поворот матрицы на 180 градусов:");
        rotateMatrixAnticlockwise90(matrix);
        printMatrix(matrix);

    }


    private static void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    
    private static void rotateMatrixAnticlockwise90(int[][] matrix) {
        int n = matrix.length;

        for(int i=0;i<n;i++)  
        {  
            for(int j=i;j<n;j++) {  
                int temp = matrix[i][j];  
                matrix[i][j] = matrix[j][i];  
                matrix[j][i] = temp;  
            }  
        }  
        
        for(int i=0; i<n; i++) {  
            int low = 0, high = n-1;  
            while(low < high)  
            {  
                int temp = matrix[low][i];  
                matrix[low][i] = matrix[high][i];  
                matrix[high][i] = temp;  
                low++;  
                high--;  
            }  
        }
    }


    static void getCofactor(int mat[][], int temp[][],
                            int p, int q, int n)
    {
        int i = 0, j = 0;
 
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    static int determinantOfMatrix(int mat[][], int n)
    {
        int D = 0;
 
        if (n == 1)
            return mat[0][0];
 
        int temp[][] = new int[n][n];
 
        int sign = 1;
 
        for (int f = 0; f < n; f++) {
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                 * determinantOfMatrix(temp, n - 1);

            sign = -sign;
        }
 
        return D;
    }
 
    static void display(int mat[][], int row, int col)
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(mat[i][j]);
 
            System.out.print("\n");
        }
    }
}
