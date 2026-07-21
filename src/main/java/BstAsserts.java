public class BstAsserts {

    public static void main(String[] args) {

        testIsAVL();
        testContUnBalanced();
        testFirstUnBalanced();
        testIsLeftPending();
        testIsRightPending();
        //testRotationNeeded();

        System.out.println("Todos os testes passaram!");
    }

    public static void testContUnBalanced() {

    BST bst = new BST();

    // árvore vazia
    assert bst.contUnBalanced() == 0;

    // um nó
    bst.add(10);
    assert bst.contUnBalanced() == 0;

    // dois nós
    bst.add(5);
    assert bst.contUnBalanced() == 0;

    // perfeitamente balanceada
    bst = new BST();
    int[] values = {4,2,6,1,3,5,7};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() == 0;

    // LL
    bst = new BST();
    values = new int[]{30,20,10};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() == 1;

    // RR
    bst = new BST();
    values = new int[]{10,20,30};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() == 1;

    // LR
    bst = new BST();
    values = new int[]{30,10,20};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() == 1;

    // RL
    bst = new BST();
    values = new int[]{10,30,20};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() == 1;

    // cadeia esquerda
    bst = new BST();
    values = new int[]{50,40,30,20,10};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() == 3;

    // cadeia direita
    bst = new BST();
    values = new int[]{10,20,30,40,50};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() == 3;

    // vários níveis
    bst = new BST();
    values = new int[]{50,30,70,20,40,10,5};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() == 3;

    // árvore grande
    bst = new BST();
    values = new int[]{90,13,4,8,37,16,24,44,42,88,51,72,81,84,92};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() > 0;
}


    public static void testPredecessor() {

        BST bst = new BST();
        int[] values = {50,30,70,20,40,60,80};
        for (int v : values) bst.add(v);

        assert bst.predecessor(bst.search(50)).value == 40;
        assert bst.predecessor(bst.search(70)).value == 60;
        assert bst.predecessor(bst.search(40)).value == 30;
        assert bst.predecessor(bst.search(20)) == null;

        bst = new BST();
        bst.add(10);
        assert bst.predecessor(bst.search(10)) == null;
    }

    public static void testFirstUnBalanced(){

    BST bst = new BST();

    // árvore vazia
    assert bst.firstUnBalanced() == null;

    // um nó
    bst.add(10);
    assert bst.firstUnBalanced() == null;

    // dois nós
    bst.add(5);
    assert bst.firstUnBalanced() == null;

    bst.add(15);
    assert bst.firstUnBalanced() == null;

    // LL
    bst = new BST();

    bst.add(30);
    bst.add(20);
    bst.add(10);

    assert bst.firstUnBalanced().value == 30;

    // RR
    bst = new BST();

    bst.add(10);
    bst.add(20);
    bst.add(30);

    assert bst.firstUnBalanced().value == 10;

    // LR
    bst = new BST();

    bst.add(30);
    bst.add(10);
    bst.add(20);

    assert bst.firstUnBalanced().value == 30;

    // RL
    bst = new BST();

    bst.add(10);
    bst.add(30);
    bst.add(20);

    assert bst.firstUnBalanced().value == 10;

    // cadeia esquerda
    bst = new BST();

    int[] values = {50,40,30,20,10};

    for(int v : values)
        bst.add(v);

    assert bst.firstUnBalanced().value == 50;

    // cadeia direita
    bst = new BST();

    values = new int[]{10,20,30,40,50};

    for(int v : values)
        bst.add(v);

    assert bst.firstUnBalanced().value == 10;

    // árvore perfeita
    bst = new BST();

    values = new int[]{4,2,6,1,3,5,7};

    for(int v : values)
        bst.add(v);

    assert bst.firstUnBalanced() == null;

    // árvore maior
    bst = new BST();

    values = new int[]{90,13,4,8,37,16,24,44,42,88,51,72,81,84,92};

    for(int v : values)
        bst.add(v);

    assert bst.firstUnBalanced() != null;
}


    public static void testSucessor() {

        BST bst = new BST();
        int[] values = {50,30,70,20,40,60,80};
        for (int v : values) bst.add(v);

        assert bst.sucessor(bst.search(50)).value == 60;
        assert bst.sucessor(bst.search(30)).value == 40;
        assert bst.sucessor(bst.search(60)).value == 70;
        assert bst.sucessor(bst.search(80)) == null;

        bst = new BST();
        bst.add(10);
        assert bst.sucessor(bst.search(10)) == null;
    }


    public static void testIsAVL() {

        BST bst = new BST();
        assert bst.isAVL();

        bst.add(10);
        assert bst.isAVL();

        bst.add(5);
        assert bst.isAVL();

        bst.add(15);
        assert bst.isAVL();

        // árvore perfeita
        bst = new BST();
        int[] values = {4,2,6,1,3,5,7};
        for (int v : values) bst.add(v);
        assert bst.isAVL();

        // LL
        bst = new BST();
        bst.add(30);
        bst.add(20);
        bst.add(10);
        assert !bst.isAVL();

        // RR
        bst = new BST();
        bst.add(10);
        bst.add(20);
        bst.add(30);
        assert !bst.isAVL();

        // LR
        bst = new BST();
        bst.add(30);
        bst.add(10);
        bst.add(20);
        assert !bst.isAVL();

        // RL
        bst = new BST();
        bst.add(10);
        bst.add(30);
        bst.add(20);
        assert !bst.isAVL();

        // degenerada à esquerda
        bst = new BST();
        values = new int[]{50,40,30,20,10};
        for (int v : values) bst.add(v);
        assert !bst.isAVL();

        // degenerada à direita
        bst = new BST();
        values = new int[]{10,20,30,40,50};
        for (int v : values) bst.add(v);
        assert !bst.isAVL();

        // árvore maior balanceada
        bst = new BST();
        values = new int[]{41,20,11,29,32,65,50,91,72,99};
        for (int v : values) bst.add(v);
        assert bst.isAVL();

        // árvore maior desbalanceada
        bst = new BST();
        values = new int[]{90,13,4,8,37,16,24,44,42,88,51,72,81,84,92};
        for (int v : values) bst.add(v);
        assert !bst.isAVL();

        // desbalanceamento profundo
        bst = new BST();
        values = new int[]{100,50,150,25,75,10,5};
        for (int v : values) bst.add(v);
        assert !bst.isAVL();
    }

    // public static void testRotationNeeded() {

    //     BST bst = new BST();

    //     // LL
    //     bst.add(30);
    //     bst.add(20);
    //     bst.add(10);
    //     assert bst.rotationNeeded(bst.firstUnBalanced()).equals("LL");

    //     // RR
    //     bst = new BST();
    //     bst.add(10);
    //     bst.add(20);
    //     bst.add(30);
    //     assert bst.rotationNeeded(bst.firstUnBalanced()).equals("RR");

    //     // LR
    //     bst = new BST();
    //     bst.add(30);
    //     bst.add(10);
    //     bst.add(20);
    //     assert bst.rotationNeeded(bst.firstUnBalanced()).equals("LR");

    //     // RL
    //     bst = new BST();
    //     bst.add(10);
    //     bst.add(30);
    //     bst.add(20);
    //     assert bst.rotationNeeded(bst.firstUnBalanced()).equals("RL");

    //     // árvore balanceada
    //     bst = new BST();
    //     int[] values = {4,2,6,1,3,5,7};

    //     for(int v : values)
    //         bst.add(v);

    //     assert bst.firstUnBalanced() == null;

    //     // caso maior LL
    //     bst = new BST();

    //     values = new int[]{50,40,60,30,20,10};

    //     for(int v : values)
    //         bst.add(v);

    //     assert bst.rotationNeeded(bst.firstUnBalanced()).equals("LL");

    //     // caso maior RR
    //     bst = new BST();

    //     values = new int[]{50,40,60,70,80,90};

    //     for(int v : values)
    //         bst.add(v);

    //     assert bst.rotationNeeded(bst.firstUnBalanced()).equals("RR");
    // }


    public static void testCheckDesbalanced(){

        BST bst = new BST();

        assert !bst.checkDesbalanced();

        bst.add(10);
        assert !bst.checkDesbalanced();

        bst.add(20);
        assert !bst.checkDesbalanced();

        bst.add(30);
        assert bst.checkDesbalanced();

        bst = new BST();

        int[] values = {4,2,6,1,3,5,7};

        for(int v : values)
            bst.add(v);

        assert !bst.checkDesbalanced();

    }

    public static void testIsLeftPending(){

        BST bst = new BST();

        bst.add(30);
        bst.add(20);
        bst.add(10);

        Node n = bst.firstUnBalanced();

        assert bst.isLeftPending(n);

        bst = new BST();

        bst.add(30);
        bst.add(10);
        bst.add(20);

        n = bst.firstUnBalanced();

        assert !bst.isRightPending(n);
        assert bst.isLeftPending(n);

    }
  
    public static void testIsRightPending(){

        BST bst = new BST();

        bst.add(10);
        bst.add(20);
        bst.add(30);

        Node n = bst.firstUnBalanced();

        assert bst.isRightPending(n);

        bst = new BST();

        bst.add(10);
        bst.add(30);
        bst.add(20);

        n = bst.firstUnBalanced();

        assert !bst.isLeftPending(n);
        assert bst.isRightPending(n);

    }

}
 
