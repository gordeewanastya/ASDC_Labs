public class BinarySearchTree {
    private Node root;

    private class Node {
        private Student student;
        private Node left;
        private Node right;

        public Node(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(Student student) {
        root = insert(root, student);
    }

    private Node insert(Node node, Student student) {
        if (node == null) {
            return new Node(student);
        }

        if (student.getIdentificationNumber() < node.student.getIdentificationNumber()) {
            node.left = insert(node.left, student);
        } else if (student.getIdentificationNumber() > node.student.getIdentificationNumber()) {
            node.right = insert(node.right, student);
        }

        return node;
    }

    public Student search(long id) {
        Node node = search(root, id);

        if (node == null) {
            return null;
        } else {
            return node.student;
        }
    }

    private Node search(Node node, long id) {
        if (node == null || node.student.getIdentificationNumber() == id) {
            return node;
        }

        if (id < node.student.getIdentificationNumber()) {
            return search(node.left, id);
        } else {
            return search(node.right, id);
        }
    }


    public void resultOfBinaryTreeSearch(Student foundStudent, Long studentIDNPtoSearch){

        if (foundStudent == null) {
            System.out.println("Student with identification number " + studentIDNPtoSearch + " not found.");
        } else {
            System.out.println("Found student: " + foundStudent.getFirstName() + " " + foundStudent.getLastName());
        }
    }
}
