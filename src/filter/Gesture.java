
package filter;

/**
 *
 * @author Erlkonig
 */
public class Gesture {
    private static int nextid=0;
    private int id;
    private String name;
    
    private double[][] matrix;
    private double[][] filteredMatrix;

    public Gesture(String name, double[][] matrix) {
        this.id=nextid++;
        this.name = name;
        this.matrix = matrix;
    }
    
    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] getFilteredMatrix() {
        return filteredMatrix;
    }

    public void setFilteredMatrix(double[][] filteredMatrix) {
        this.filteredMatrix = filteredMatrix;
    }

    public String getName() {
        return name;
    }
    
    
}
