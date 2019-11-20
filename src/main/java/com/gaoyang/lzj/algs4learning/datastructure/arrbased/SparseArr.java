package com.gaoyang.lzj.algs4learning.datastructure.arrbased;

/**
 * Desc: 稀疏数组的存储与恢复
 *
 * @author Cruiser_L
 * @date 2019/10/23
 */
public class SparseArr {

    public static int[][] initArr(int row, int vol){
        int[][] srcArr = new int[row][vol];

        srcArr[1][2] = 1;
        srcArr[2][3] = 2;
        System.out.println("原始数组：");
//        for(int i = 0;i<row;i++){
//            for(int j = 0;j<vol;j++){
//                System.out.printf("%d\t", srcArr[i][j]);
//            }
//            System.out.println();
//        }
        printArr(srcArr);
        return srcArr;
    }

    public static int itemNum(int[][] srcArr){
        int num = 0;
        for(int i = 0;i<srcArr.length;i++){
            for(int j = 0;j<srcArr[0].length;j++){
                if(srcArr[i][j]!=0){
                    num++;
                }
            }
        }
        System.out.printf("数组中非0元素个数：%d\n", num);
        return num;
    }

    public static int[][] arr2Sparse(int[][] srcArr, int num){

        int[][] sparseArr = new int[num+1][3];
        sparseArr[0][0] = srcArr.length;
        sparseArr[0][1] = srcArr[0].length;
        sparseArr[0][2] = num;
        int count = 1;
        for(int i = 0;i<srcArr.length;i++){
            for(int j = 0;j<srcArr[0].length;j++){
                if(srcArr[i][j]!=0){
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] =srcArr[i][j];
                    count++;
                }
            }
        }
        System.out.println("稀疏数组：");
//        for(int i = 0;i<count;i++){
//            for(int j = 0;j<3;j++){
//                System.out.printf("%d\t", sparseArr[i][j]);
//            }
//            System.out.println();
//        }
        printArr(sparseArr);
        return sparseArr;
    }

    public static int[][] sparse2src(int[][] sparseArr){
        int[][] originalArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1;i<=sparseArr[0][2];i++){
            originalArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("原数组：");
        printArr(originalArr);
        return originalArr;
    }

    public static void printArr(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 1 初始化原始数组
        int[][] srcArr = initArr(10, 10);
        // 2 将原始数组稀疏化存储
        int[][] sparseArr = arr2Sparse(srcArr, 2);
        // 3 将稀疏数组恢复为原始数组
        sparse2src(sparseArr);

    }
}
