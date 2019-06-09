package br.com.AVL;

public class AvlNode {
    protected static int globalID = 0;
    protected int id;
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
        id = globalID;
        ++globalID;

    }
}