package jvtest;

import io.qameta.allure.*;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SolutionsTest {

    @Test(description = "Verify base case is satisfied where one plant can be placed")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Base requirements")
    public void testBaseCase1() {
        Solutions solutions = new Solutions();
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertTrue(result, "Failed");
    }

    @Test(description = "Verify base case is satisfied where two plants can be placed")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Base requirements")
    public void testBaseCase2() {
        Solutions solutions = new Solutions();
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertFalse(result, "Failed");
    }

    @Test(description = "Verify case where there's only one open plot")
    @Feature("Edge cases")
    public void testEdgeCase1() {
        Solutions solutions = new Solutions();
        int[] flowerbed = {0};
        int n = 1;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertTrue(result, "Edge case 1 Failed");
    }

    @Test(description = "Verify case where there's only one used plot")
    @Feature("Edge cases")
    public void testEdgeCase2() {
        Solutions solutions = new Solutions();
        int[] flowerbed = {1};
        int n = 1;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertFalse(result, "Edge case 2 Failed");
    }

    @Test(description = "Verify case where there are 10000 open plots")
    @Feature("Edge cases")
    public void testEdgeCase3() {
        Solutions solutions = new Solutions();
        int[] flowerbed = new int[10000];
        int n = 1;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertTrue(result, "Edge case 3 Failed");
    }

    @Test(description = "Verify case where there are 10000 used plots")
    @Feature("Edge cases")
    public void testEdgeCase4() {
        Solutions solutions = new Solutions();
        int[] flowerbed = new int[10000];
        Arrays.fill(flowerbed, 1);
        int n = 1;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertFalse(result, "Edge case 4 Failed");
    }

    @Test(description = "Verify case where there are 10000 open plots and 10000 plants can be placed")
    @Feature("Load testing")
    public void testLoadTest1() {
        Solutions solutions = new Solutions();
        int[] flowerbed = new int[10000];
        int n = flowerbed.length;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertFalse(result, "Load test 1 Failed");
    }

    @Test(description = "Verify case where there are 10000 used plots and 10000 plants can be placed")
    @Feature("Load testing")
    public void testLoadTest2() {
        Solutions solutions = new Solutions();
        int[] flowerbed = new int[10000];
        Arrays.fill(flowerbed, 1);
        int n = flowerbed.length;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertFalse(result, "Load test 1 Failed");
    }

    @Test(description = "Verify case where there are 9999 open plots")
    @Feature("Boundary cases")
    public void testBoundaryCase1() {
        Solutions solutions = new Solutions();
        int[] flowerbed = new int[9999];
        int n = 1;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertTrue(result, "Boundary case 1 Failed");
    }

    @Test(description = "Verify case where there are 9998 closed plots")
    @Feature("Boundary cases")
    public void testBoundaryCase2() {
        Solutions solutions = new Solutions();
        int[] flowerbed = new int[10000];
        Arrays.fill(flowerbed, 1);
        flowerbed[flowerbed.length - 1] = 0;
        flowerbed[flowerbed.length - 2] = 0;
        int n = 1;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertTrue(result, "Boundary case 2 Failed");
    }

    @Test(description = "Verify case where there are 7500 open plots and 2500 closed plots")
    @Feature("Boundary cases")
    public void testBoundaryCase3() {
        Solutions solutions = new Solutions();
        int[] flowerbed = new int[10000];
        for (int i = 0; i < flowerbed.length; i++) {
            if (i % 4 == 3) {
                flowerbed[i] = 1;
            }
        }
        int n = 2500;
        boolean result = solutions.canPlaceFlowers(flowerbed, n);
        Assert.assertTrue(result, "Boundary case 3 Failed");
    }

    @Test(description = "Verify fault case of no plots")
    @Feature("Fault cases")
    public void testFaultCase1() {
        Solutions solutions = new Solutions();
        int[] flowerbed = {};
        int n = 1;
        try{
            solutions.canPlaceFlowers(flowerbed, n);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Flowerbed array cannot be empty", "Fault case 1 Failed");
        }
    }

    @Test(description = "Verify fault case of other values other than 0 and 1")
    @Feature("Fault cases")
    public void testFaultCase2() {
        Solutions solutions = new Solutions();
        int[] flowerbed = {0, 1, 2, 3, 4};
        int n = 1;
        try {
            solutions.canPlaceFlowers(flowerbed, n);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Flowerbed array can only contain 0 or 1", "Fault case 2 Failed");
        }
    }
}