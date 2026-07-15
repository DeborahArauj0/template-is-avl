public class BstAsserts {

    public static void main(String[] args) {

        // TESTES isAVL()

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
        values = new int[]{23,12,40,9,25,60,50};
        for (int i : values)
            bst.add(i);
        assert bst.isAVL();

        testContUnBalanced();
        testFirstUnBalanced();
      //  testRotationNeeded();

        System.out.println("Todos os testes passaram!");
    }

    // contUnBalanced()

    public static void testContUnBalanced() {

        BST bst = new BST();

        assert bst.contUnBalanced() == 0;

        bst.add(10);
        assert bst.contUnBalanced() == 0;

        bst.add(5);
        assert bst.contUnBalanced() == 0;

        bst = new BST();
        int[] values = {4,2,6,1,3,5,7};

        for(int v : values)
            bst.add(v);

        assert bst.contUnBalanced() == 0;

        // LL
        bst = new BST();
        bst.add(30);
        bst.add(20);
        bst.add(10);
        assert bst.contUnBalanced() == 1;

        // RR
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

        // vários desbalanceados (esquerda)
        bst = new BST();
        values = new int[]{50,40,30,20,10};

        for(int v : values)
            bst.add(v);

        assert bst.contUnBalanced() == 3;

        // vários desbalanceados (direita)
        bst = new BST();
        values = new int[]{10,20,30,40,50};

        for(int v : values)
            bst.add(v);

        assert bst.contUnBalanced() == 3;

        // primeiro desbalanceado não é a raiz
        bst = new BST();
        values = new int[]{50,30,70,20,40,10,5};

        for(int v : values)
            bst.add(v);

        assert bst.contUnBalanced() == 2;

        // outro caso semelhante
        bst = new BST();
        values = new int[]{50,30,70,20,40,60,80,10,5};

        for(int v : values)
            bst.add(v);

        assert bst.contUnBalanced() == 2;

        // árvore maior
        bst = new BST();
        values = new int[]{90,13,4,8,37,16,24,44,42,88,51,72,81,84,92};

        for(int v : values)
            bst.add(v);

        assert bst.contUnBalanced() > 0;
    }

    // firstUnBalanced()

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

        // primeiro desbalanceado não é a raiz
        bst = new BST();
        int[] values = {50,30,70,20,40,10,5};

        for(int v : values)
            bst.add(v);

        assert bst.firstUnBalanced().value == 20;

        // outro caso semelhante
        bst = new BST();
        values = new int[]{50,30,70,20,40,60,80,10,5};

        for(int v : values)
            bst.add(v);

        assert bst.firstUnBalanced().value == 20;

        // desbalanceado profundo
        bst = new BST();
        values = new int[]{100,50,150,25,75,10,5};

        for(int v : values)
            bst.add(v);

        assert bst.firstUnBalanced().value == 25;

        // árvore grande
        bst = new BST();
        values = new int[]{90,13,4,8,37,16,24,44,42,88,51,72,81,84,92};

        for(int v : values)
            bst.add(v);

        assert bst.firstUnBalanced() != null;
    }

    // rotationNeeded()


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
    // }

}