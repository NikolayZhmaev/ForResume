package net.thumbtack.school.online.matrix;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestMatrixNonSimilarRows {

    @Test
    public void testMatrixNonSimilarRows() {
        int[][] matrix1 = {{}, {1, 2, 2, 4, 4}, {4, 2, 1, 4}, {3, 2, 4, 1, 5, 8}, {2, 3, 1, 4, 1, 5, 8}, {1, 8, 1, 1, 8}};
        List<int[]> nonSimilarRows1 = new MatrixNonSimilarRows(matrix1).getNonSimilarRows();
        assertEquals(4, nonSimilarRows1.size());
        assertTrue(nonSimilarRows1.contains(matrix1[0]));
        assertTrue(nonSimilarRows1.contains(matrix1[2]));
        assertTrue(nonSimilarRows1.contains(matrix1[4]));
        assertTrue(nonSimilarRows1.contains(matrix1[5]));
        int[][] matrix2 = {{1, 2, 2, 4, 4}, {4, 5, 1, 4}, {2, 4, 1}, {2, 4, 1, 4, 1, 2}, {1, 8, 1, 1, 8}};
        List<int[]> nonSimilarRows2 = new MatrixNonSimilarRows(matrix2).getNonSimilarRows();
        assertEquals(3, nonSimilarRows2.size());
        assertTrue(nonSimilarRows2.contains(matrix2[1]));
        assertTrue(nonSimilarRows2.contains(matrix2[3]));
        assertTrue(nonSimilarRows2.contains(matrix2[4]));
        int[][] matrix3 = {{}, {}};
        List<int[]> nonSimilarRows3 = new MatrixNonSimilarRows(matrix3).getNonSimilarRows();
        assertEquals(1, nonSimilarRows3.size());
        assertTrue(nonSimilarRows3.contains(matrix3[1]));
    }
}