package com.coursera.week1.assignment;

/**
 * Created by mato on 4/16/17.
 */
public class Percolation {
    private boolean[][] opened;
    private int size;
    private WeightedQuickUnionUF qf;
    private int noOfOpenSites;
    private boolean parcolates;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        size = n;
        qf = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        opened[row - 1][col - 1] = true;
        int d = getIndex(row, col);
        checkAndOpen(row + 1, col, d);
        checkAndOpen(row, col + 1, d);
    }

    private void checkAndOpen(int i, int j, int d) {
        if (isOpen(i, j)) {
            qf.union(d, getIndex(i, j));
        }
    }

    /**
     * Validate orow and column to make sure they fall within the prescribed ranges
     *
     * @param row - No of rows in the block
     * @param col - No of columns in the block
     * @return true or false
     */
    private void validate(int row, int col) {
        if (row < 0 || row > size || col < 0 || col > size) {
            throw new IllegalArgumentException();
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        try {
            validate(row, col);
            return opened[row - 1][col - 1];
        } catch (Exception e) {
            return false;
        }
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return qf.connected(0, getIndex(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return noOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        if (size == 1) {
            return opened[0][0];
        }

        parcolates = qf.connected(0, size * size + 1);
        if (parcolates) {
            noOfOpenSites++;
        }

        return parcolates;
    }

    private int getIndex(int i, int j) {
        return size * (i - 1) + j;
    }
}