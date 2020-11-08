package com.company;
import java.util.Scanner;
import java.util.*;

public class Manage {
    private static Scanner scanner = new Scanner(System.in);
    public Manage() {
        menu();
    }
    public int rowA;
    public int colA;
    public int rowB;
    public int colB;
    public  int count=0;
    int[][] matrtixA = new int[100][100];
    int[][] matrtixB = new int[100][100];
    int[][] matrtixT = new int[100][100];
    private void menu(){
        System.out.println();
        System.out.println("------------------------ MENU ------------------------");
        System.out.println("1. add");
        System.out.println("2. subtraction");
        System.out.println("3. multiply");
        System.out.println("4. transpose");
        System.out.println("5. reset");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                add();
                menu();
                break;
            case 2:
                subtraction();
                menu();
                break;
            case 3:
                multiply();
                menu();
                break;
            case 4:
                transpose();
                menu();
                break;
            case 5:
                menu();
                break;
        }
    }



    private void getMatrixSize(String operation) {
        if (operation.equals("add") || operation.equals("subtraction") || operation.equals("transpose")) {
            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.println("SIZE :");
            System.out.println("Enter matrix row number:");
            rowA = scanner.nextInt();
            rowB = rowA;
            System.out.println("Enter matrix column number:");
            colA = scanner.nextInt();
            colB = colA;
        } else if (operation.equals("multiply")) {
            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.println("SIZE :");
            System.out.println("Enter matrix A row number:");
            rowA = scanner.nextInt();
            System.out.println("Enter matrix A column number:");
            colA = scanner.nextInt();
            System.out.println("Enter matrix B row number:");
            rowB = scanner.nextInt();
            System.out.println("Enter matrix B column number:");
            colB = scanner.nextInt();
        }

    }

    private void receivingInformation(String operation) {
        if (operation.equals("add") || operation.equals("subtraction")) {
            System.out.println("Enter matrix A members");

            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {

                    matrtixA[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Enter matrix B members");

            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < colB; j++) {

                    matrtixB[i][j] = scanner.nextInt();
                }
            }
        } else if (operation.equals("transpose")) {
            System.out.println("Enter matrix  members");

            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {

                    matrtixT[i][j] = scanner.nextInt();
                }
            }

        } else if (operation.equals("multiply")) {
            System.out.println("Enter matrix A members");

            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {

                    matrtixA[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Enter matrix B members");

            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < colB; j++) {

                    matrtixB[i][j] = scanner.nextInt();
                }
            }
        }
    }

    private void add() {
        getMatrixSize("add");
        receivingInformation("add");
        int A[][] = sparse(matrtixA);
        int c1 = count;
        int B[][] = sparse(matrtixB);
        int c2 = count;

        int aa = 0, ab = 0; int b = 0;
        int[][] result = new int[100][3];
        System.out.println();
        System.out.println("-------- SPARSE A --------");
        for (int i = 0; i < c1; i++){
            System.out.println(A[i][0]+" "+A[i][1]+" "+A[i][2]);
        }
        System.out.println("-------- SPARSE B --------");
        for (int i = 0; i < c2; i++){

            System.out.println(B[i][0]+" "+B[i][1]+" "+B[i][2]);

        }
        while (aa < c1 && ab < c2){
            if (A[aa][0] == B[ab][0] ){
                if(A[aa][1] == B[ab][1]) {
                    int sum = A[aa][2] + B[ab][2];
                    if (sum != 0) {
                        result[b][0] = A[aa][0];
                        result[b][1] = A[aa][1];
                        result[b][2] = A[aa][2] + B[ab][2];
                        b++;

                    }
                    aa++;
                    ab++;
                }else if (A[aa][1] < B[ab][1] ){
                    result[b][0] = A[aa][0];
                    result[b][1] = A[aa][1];
                    result[b][2] = A[aa][2];
                    b++;
                    aa++;
                }else {
                    result[b][0] = B[ab][0];
                    result[b][1] = B[ab][1];
                    result[b][2] = B[ab][2];
                    b++;
                    ab++;
                }

            }else if ( A[aa][0] < B[ab][0]){
                result[b][0] = A[aa][0];
                result[b][1] = A[aa][1];
                result[b][2] = A[aa][2];
                b++;
                aa++;
            }else if ( A[aa][0] > B[ab][0]){
                result[b][0] = B[ab][0];
                result[b][1] = B[ab][1];
                result[b][2] = B[ab][2];
                b++;
                ab++;
            }
            if (aa == c1 && ab < c2){
                while (ab < c2) {
                    result[b][0] = B[ab][0];
                    result[b][1] = B[ab][1];
                    result[b][2] = B[ab][2];
                    b++;
                    ab++;
                }
            }else if (ab == c2 && aa < c1){
                while (aa < c1){
                    result[b][0] = A[aa][0];
                    result[b][1] = A[aa][1];
                    result[b][2] = A[aa][2];
                    b++;
                    aa++;
                }
            }

        }
        System.out.println("---------- SUM ----------");
        for (int i = 0; i < b; i++){

            System.out.println(result[i][0]+" "+result[i][1]+" "+result[i][2]);

        }

    }

    private void subtraction() {
        getMatrixSize("subtraction");
        receivingInformation("subtraction");
        int A[][] = sparse(matrtixA);
        int c1 = count;
        int B[][] = sparse(matrtixB);
        int c2 = count;

        int aa = 0, ab = 0; int b = 0;
        int[][] result = new int[100][3];
        System.out.println();
        System.out.println("-------- SPARSE A --------");
        for (int i = 0; i < c1; i++){
            System.out.println(A[i][0]+" "+A[i][1]+" "+A[i][2]);
        }
        System.out.println("-------- SPARSE B --------");
        for (int i = 0; i < c2; i++){

            System.out.println(B[i][0]+" "+B[i][1]+" "+B[i][2]);

        }
        while (aa < c1 && ab < c2){
            if (A[aa][0] == B[ab][0] ){
                if(A[aa][1] == B[ab][1]) {
                    int sum = A[aa][2] - B[ab][2];
                    if (sum != 0) {
                        result[b][0] = A[aa][0];
                        result[b][1] = A[aa][1];
                        result[b][2] = A[aa][2] - B[ab][2];
                        b++;

                    }
                    aa++;
                    ab++;

                }else if (A[aa][1] < B[ab][1] ){
                    result[b][0] = A[aa][0];
                    result[b][1] = A[aa][1];
                    result[b][2] = A[aa][2];
                    b++;
                    aa++;
                }else {
                    result[b][0] = (B[ab][0]);
                    result[b][1] = (B[ab][1]);
                    result[b][2] = (B[ab][2])*-1;
                    b++;
                    ab++;
                }

            }else if ( A[aa][0] < B[ab][0]){
                result[b][0] = A[aa][0];
                result[b][1] = A[aa][1];
                result[b][2] = A[aa][2];
                b++;
                aa++;
            }else if ( A[aa][0] > B[ab][0]){
                result[b][0] = (B[ab][0]);
                result[b][1] = (B[ab][1]);
                result[b][2] = (B[ab][2])*-1;
                b++;
                ab++;
            }
            if (aa == c1 && ab < c2){
                while (ab < c2) {
                    result[b][0] = (B[ab][0]);
                    result[b][1] = (B[ab][1]);
                    result[b][2] = (B[ab][2])*-1;
                    b++;
                    ab++;
                }
            }else if (ab == c2 && aa < c1){
                while (aa < c1){
                    result[b][0] = A[aa][0];
                    result[b][1] = A[aa][1];
                    result[b][2] = A[aa][2];
                    b++;
                    aa++;
                }
            }

        }
        System.out.println("---------- SUBTRACTION ----------");
        for (int i = 0; i < b; i++){

            System.out.println(result[i][0]+" "+result[i][1]+" "+result[i][2]);

        }



    }
    private void multiply() {
        getMatrixSize("multiply");
        validation();
        receivingInformation("multiply");
        int A[][] = sparse(matrtixA);
        int c1 = count;
        int B[][] = sparse(matrtixB);
        int c2 = count;
        int T[][] = new int[c2][3];
        for (int i = 0; i < c2; i++){
            T[i][0] = B[i][1];
            T[i][1] = B[i][0];
            T[i][2] = B[i][2];
        }
        sortbyColumn(T,0);

        for (int i = c2-1; i >= 0  ; i--  ){
            B[c2-i-1][0] = T[i][0];
            B[c2-i-1][1] = T[i][1];
            B[c2-i-1][2] = T[i][2];


        }

        int aa = 0, ab = 0; int b = 0;
        int[][] result = new int[A.length][B[0].length];
        System.out.println();
        System.out.println("-------- SPARSE A --------");
        for (int i = 0; i < c1; i++){
            System.out.println(A[i][0]+" "+A[i][1]+" "+A[i][2]);
        }
        System.out.println("-------- Transpose SPARSE B --------");
        for (int i = 0; i < c2; i++){

            System.out.println(B[i][0]+" "+B[i][1]+" "+B[i][2]);

        }
        System.out.println();
        System.out.println("-------- MULTIPLY --------");


        for (aa = 0; aa < c1; ){
            int c = A[aa][0];
            for (ab = 0; ab < c2; ){
                int r = B[ab][0];
                int scanA = aa;
                int scanB = ab;
                int sum = 0;
                while (scanA < c2 && A[scanA][0] == c && scanB < c1 && B[scanB][0] == r){
                  if (A[scanA][1] < B[scanB][1]) scanA++;
                  else if (A[scanA][1] > B[scanB][1]) scanB++;
                  else sum += A[scanA++][2] * B[scanB++][2];
                }
                if (sum != 0){
                    result[b][0] = c;
                    result[b][1] = r;
                    result[b][2] = sum;
                    b++;
                }
                while (ab < c2 && B[ab][0] == r) ab++;
            }
            while (aa < c1 && A[aa][0] == c) aa++;
        }




        for (int i = 0; i < b; i++){

            System.out.println(result[i][0]+" "+result[i][1]+" "+result[i][2]);

        }

    }


    private void transpose() {
        getMatrixSize("transpose");
        receivingInformation("transpose");
        int A[][] = sparse(matrtixT);
        int lenA = count;
        int T[][] = new int[lenA][3];

        int[][] result = new int[100][3];
        System.out.println();
        System.out.println("-------- SPARSE MATRIX --------");
        for (int i = 0; i < lenA; i++){

            System.out.println(A[i][0]+" "+A[i][1]+" "+A[i][2]);

        }

        for (int i = 0; i < lenA; i++){
            T[i][0] = A[i][1];
            T[i][1] = A[i][0];
            T[i][2] = A[i][2];
        }


        System.out.println();
        System.out.println("--- TRANSPOSE SPARSE MATRIX ----");

        sortbyColumn(T,0);

        for (int i = lenA-1; i >= 0; i--){

            System.out.println(T[i][0]+" "+T[i][1]+" "+T[i][2]);

        }
    }




        public void sortbyColumn(int arr[][],int col  )
        {
            // Using built-in sort function Arrays.sort
            Arrays.sort(arr, new Comparator<int[]>() {

                @Override
                // Compare values according to columns
                public int compare(final int[] entry1,
                                   final int[] entry2) {

                    // To sort in descending order revert
                    // the '>' Operator
                    if (entry1[col] < entry2[col])
                        return 1;
                    else
                        return -1;
                }
            });  // End of function call sort().
        }


        private void validation() {
        if (colA != rowB) {
            System.out.println("Column A and row B must be the same");
            multiply();
        }


    }
    private int[][] sparse(int[][] matrix){
        int[][] matrtixSparse = new int[100][3];
        count = 0;
        for (int i = 0; i < rowA; i++){
            for (int j = 0; j < colA; j++){
                if (matrix[i][j] != 0){
                    matrtixSparse[count][0] = i;
                    matrtixSparse[count][1] = j;
                    matrtixSparse[count][2] = matrix[i][j];
                    count++;


                }
            }
        }
        return matrtixSparse;

    }

}