package abstractclasschallenge;

public class SearchTree implements NodeList {
    protected ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (root == null) {
            root = newItem;
            return true;
        }

        ListItem currentItem = root;
        while (true) {
            int comparison = (currentItem.compareTo(newItem));

            // newItem is greater, move right if possible
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there's no node at the right, so add at this point
                    currentItem.setNext(newItem);
                    return true;
                }
            }

            // newItem is smaller, move left if possible
            else if (comparison > 0) {
                if (currentItem.previous() != null ) {
                    currentItem = currentItem.previous();
                } else {
                    // there's no node to the left, so add at this point
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }

            // equal, so don't add
            else {
                System.out.println(newItem.getValue() + " is already present");
                return false;
            }
        }
    }

    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to left tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            // no left tree, so make parent point to right tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.next());
            } else {
                // again, we are deleting the root
                this.root = item.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier!
            // From the right sub-tree, find the smallest value (i.e., the leftmost).
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // Now put the smallest value into our node to be deleted
            item.setValue(current.getValue());
            // and delete the smallest
            if (leftmostParent == item) {
                // there was no leftmost node, so 'current' points to the smallest
                // node (the one that must now be deleted).
                item.setNext(current.next());
            } else {
                // set the smallest node's parent to point to
                // the smallest node's right child (which may be null).
                leftmostParent.setPrevious(current.next());
            }
        }
    }


    @Override
    public boolean removeItem(ListItem item) {

        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = root;
        ListItem parentItem = currentItem;

        while (true) {
            int comparison = currentItem.compareTo(item);

            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            }

            else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }

            // equal: we've found the item so remove it
            else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
    }

    @Override
    public void traverse(ListItem root) {

        // recursive method
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
