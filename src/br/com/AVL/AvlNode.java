package br.com.AVL;

public class AvlNode {
    protected int height;       // Height
    protected String name;
    protected AvlNode left, right;
    public AvlNode ( String theElement ) {
        this( theElement, null, null );
    }
    public AvlNode ( String theElement, AvlNode lt, AvlNode rt ) {
        name = theElement;
        left = lt;
        right = rt;
        height   = 0;
    }
}