public class BstAsserts {
    public static void main(String[] args) {
        BST bst = new BST();
        assert bst.isAVL();

        int[] values = new int[]{41,20,11,29,32,65,50,91,72,99};
        for (int i : values)
            bst.add(i);
        assert bst.isAVL();

        bst = new BST();
        bst.add(1);
        assert bst.isAVL();
        bst.add(2);
        assert bst.isAVL();
        bst.add(3);
        assert !bst.isAVL();

        bst = new BST();
        bst.add(1);
        assert bst.isAVL();
        bst.add(3);
        assert bst.isAVL();
        bst.add(2);
        assert !bst.isAVL();

        bst = new BST();
        bst.add(10);
        assert bst.isAVL();
        bst.add(5);
        assert bst.isAVL();
        bst.add(1);
        assert !bst.isAVL();

        bst = new BST();
        bst.add(10);
        assert bst.isAVL();
        bst.add(5);
        assert bst.isAVL();
        bst.add(6);
        assert !bst.isAVL();

        bst = new BST();
        values = new int[]{90,13,4,8,37,16,24,44,42,88,51,72,81,84,92};
        for (int i : values)
            bst.add(i);
        assert !bst.isAVL();

        bst = new BST();
        values = new int[]{23, 12, 40, 9, 25, 60, 50};
        for (int i : values)
            bst.add(i);
        assert bst.isAVL();
    }

    //Teste para quantos nó's desbalanceados há em uma árvore 

    public static void testContUnBalanced() {

    BST bst = new BST();

    // árvore vazia
    assert bst.contUnBalanced() == 0;


    // um único nó
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


    // LL (apenas a raiz)
    bst = new BST();

    bst.add(30);
    bst.add(20);
    bst.add(10);

    assert bst.contUnBalanced() == 1;


    // RR (apenas a raiz)
    bst = new BST();

    bst.add(10);
    bst.add(20);
    bst.add(30);

    assert bst.contUnBalanced() == 1;


    // LR
    bst = new BST();

    bst.add(30);
    bst.add(10);
    bst.add(20);

    assert bst.contUnBalanced() == 1;


    // RL
    bst = new BST();

    bst.add(10);
    bst.add(30);
    bst.add(20);

    assert bst.contUnBalanced() == 1;

    // árvore com vários nós desbalanceados
    bst = new BST();

    int[] big = {50,40,30,20,10};

    for(int v : big)
        bst.add(v);

    assert bst.contUnBalanced() == 3;


    // exemplo maior
    bst = new BST();

    values = new int[]{90,13,4,8,37,16,24,44,42,88,51,72,81,84,92};

    for(int v : values)
        bst.add(v);

    assert bst.contUnBalanced() > 0;
}

    //Teste para o primeiro desbalanceado

    public static void testFirstUnBalanced() {

    BST bst = new BST();

    assert bst.firstUnBalanced() == null;

    bst.add(10);
    assert bst.firstUnBalanced() == null;

    bst.add(5);
    assert bst.firstUnBalanced() == null;

    bst.add(15);
    assert bst.firstUnBalanced() == null;


    // LL
    bst = new BST();
    bst.add(10);
    bst.add(5);
    bst.add(1);

    assert bst.firstUnBalanced().value == 10;


    // RR
    bst = new BST();
    bst.add(10);
    bst.add(20);
    bst.add(30);

    assert bst.firstUnBalanced().value == 10;


    // LR
    bst = new BST();
    bst.add(10);
    bst.add(5);
    bst.add(7);

    assert bst.firstUnBalanced().value == 10;


    // RL
    bst = new BST();
    bst.add(10);
    bst.add(20);
    bst.add(15);

    assert bst.firstUnBalanced().value == 10;

    // árvore maior
    bst = new BST();
    int[] values = {90,13,4,8,37,16,24,44,42,88,51,72,81,84,92};

    for(int v : values)
        bst.add(v);

    assert bst.firstUnBalanced() != null;
    
    }

    //Teste para rotação que precisa

    // public static void testRotationNeeded() {

    // BST bst = new BST();

    // // LL
    // bst.add(30);
    // bst.add(20);
    // bst.add(10);

    // assert bst.rotationNeeded(bst.firstUnBalanced()).equals("LL");


    // // RR
    // bst = new BST();

    // bst.add(10);
    // bst.add(20);
    // bst.add(30);

    // assert bst.rotationNeeded(bst.firstUnBalanced()).equals("RR");


    // // LR
    // bst = new BST();

    // bst.add(30);
    // bst.add(10);
    // bst.add(20);

    // assert bst.rotationNeeded(bst.firstUnBalanced()).equals("LR");


    // // RL
    // bst = new BST();

    // bst.add(10);
    // bst.add(30);
    // bst.add(20);

    // assert bst.rotationNeeded(bst.firstUnBalanced()).equals("RL");
    // }

}
