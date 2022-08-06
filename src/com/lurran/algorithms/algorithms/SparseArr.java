package com.lurran.algorithms.algorithms;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/15 9:04 下午
 */
public class SparseArr {
    public static void main(String[] args) {
        int[][] chessArr1 =new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print(data+"\t");
            }
            System.out.println();
        }

        int[][] sparseArr = toSparseArr(chessArr1);
        int[][] ints = toChessArr(sparseArr);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }

    }

    /**
     * 将数组转化为稀疏数组
     * @param chessArr1 原数组
     * @return 稀疏数组
     */
    public static int[][] toSparseArr(int[][] chessArr1){
        int sum=0;
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);

        int[][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        int row=1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j]!=0){
                    sparseArr[row][0]=i;
                    sparseArr[row][1]=j;
                    sparseArr[row][2]=chessArr1[i][j];
                    if (row==sum){
                        break;
                    }
                    row++;

                }
            }
        }
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        return sparseArr;


    }

    /**
     * 将稀疏数组转化为原数组
     * @param sparseArr 稀疏数组
     * @return 原数组
     */
    public static int[][] toChessArr(int[][] sparseArr){
        int[][] chessArr=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        return chessArr;
    }
}
