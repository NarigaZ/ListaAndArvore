package br.com.AVL;
public class AvlTree {
    private AvlNode root = null;
    public AvlTree( ) {
        root = null;
    }
    public void clear() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public AvlNode getRootNode (){
        return root;
    }
    /** Retorna a altura da árvore */
    private static int height( AvlNode t ) {
        return t == null ? -1 : t.height;
    }
    /**
     * Retorna o maior valor ente lhs e rhs.
     */
    private static int max( int lhs, int rhs ) {
        return lhs > rhs ? lhs : rhs;
    }
    /** Retorna o fator de balanceamento da árvore com raiz t */
    private int getFactor (AvlNode t) {
        return height( t.left ) - height( t.right );
    }
    public boolean insert (String x) {
        root = insert (x, root);
        return true;
    }
    private AvlNode insert (String x, AvlNode t) {
        if( t == null )
            t = new AvlNode( x, null, null );
        else if( x.compareToIgnoreCase(t.name) > 0 ) t.left = insert( x, t.left );
        else if( x.compareToIgnoreCase(t.name) < 0 ) t.right = insert( x, t.right );
        t = balance (t);
        return t;
    }
    public AvlNode balance (AvlNode t) {
        if ( getFactor(t) == 2 ) {
            if (getFactor (t.left)>0) t = doRightRotation( t );
            else t = doDoubleRightRotation( t );
        }
        else if ( getFactor(t) == -2 ) {
            if ( getFactor(t.right)<0 ) t = doLeftRotation( t );
            else t = doDoubleLeftRotation( t );
        }
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    /** Faz Rotação simples a direita */
    private static AvlNode doRightRotation( AvlNode k2 ) {
        AvlNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }
    /** Rotação simples à esquerda */
    private static AvlNode doLeftRotation( AvlNode k1 ) {
        AvlNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    /** Rotação dupla à direita */
    private static AvlNode doDoubleRightRotation( AvlNode k3 ) {
        k3.left = doLeftRotation( k3.left );
        return doRightRotation( k3 );
    }
    /** Rotação dupla à esquerda */
    private static AvlNode doDoubleLeftRotation( AvlNode k1 ) {
        k1.right = doRightRotation( k1.right );
        return doLeftRotation( k1 );
    }
    public AvlNode search(String el) {
        return search(root,el);
    }
    protected AvlNode search(AvlNode p, String el) {
        while (p != null) {
            /* se valor procuradp == chave do nó retorna referência ao nó */
            if (el==p.name) return p;
                /* se valor procurado < chave do nó, procurar na sub-árvore esquerda deste nó */
            else if (el.compareToIgnoreCase(p.name) < 0) p = p.left;
                /* se valor procurado > chave do nó, procurar na sub-árvore direita deste nó */
            else p = p.right;
        }
        // caso chave não foi achada, retorna null
        return null;
    }
    public void inorder() {
        inorder(root);
    }
    protected void inorder(AvlNode p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.name+" - ");
            inorder(p.right);
        }
    }
    public void preorder() {
        preorder(root);
    }
    protected void preorder(AvlNode p) {
        if (p != null) {
            System.out.print(p.name + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }
    public void postorder() {
        postorder(root);
    }
    protected void postorder(AvlNode p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.name + " ");
        }
    }
    protected AvlNode searchFather (String el) {
        AvlNode p = root;
        AvlNode prev = null;
        while (p != null && !(p.name.equals(el))) {  // acha o nó p com a chave el
            prev = p;
            if (p.name.compareToIgnoreCase(el) > 0)
                p = p.right;
            else p = p.left;
        }
        if (p!=null && p.name==el) return prev;
        return null;
    }
    /* método de autoria de Leonardo Zandoná - 2006/2 */
    public void displayTree() {
        if (isEmpty()){
            System.out.println("Árvore vazia!");
            return;
        }
        String separator = String.valueOf("  |__");
        System.out.println(this.root.name+"("+root.height+")");
        displaySubTree(root.left,  separator);
        displaySubTree(root.right, separator);
    }
    private void displaySubTree(AvlNode node, String separator) {
        if (node != null) {
            AvlNode father = this.searchFather(node.name);
            if (node.equals(father.left)) {
                System.out.println(separator+node.name +"("+node.height+")"+" (ESQ)");
            }else{
                System.out.println(separator+node.name+"("+node.height+")"+" (DIR)");
            }
            displaySubTree(node.left,  "     "+separator);
            displaySubTree(node.right, "     "+separator);
        }
    }
} // class