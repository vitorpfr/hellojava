package abstractclasschallenge;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem newItem) {

        System.out.println(root);

        // if root is null, add element as root
        if (root.getValue() == null) {
            root = newItem;
            return true;
        }

        // if new item is equal to root, return false without doing anything
        if (newItem.compareTo(root) == 0) {
            return false;
        }

        // if new item is greater than root, try to add it to the right side
        else if (newItem.compareTo(root) > 0) {

            // loop from root to right side of the list
            ListItem currentItem = root;
            ListItem previousItem = root.previous();

            while (currentItem != null) {

                // if new item is equal to current one, exit and return false
                if (newItem.compareTo(currentItem) == 0) {
                    return false;
                }

                // if new item is smaller than current one, add new element between previous and current
                if (newItem.compareTo(currentItem) < 0) {

                    // connect previous to new item
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());

                    // connect new item to current
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);

                    // return and end loop, since item was added successfully
                    return true;

                }

                // move all pointers left
                previousItem = currentItem;
                currentItem = currentItem.next();
            }

            //  if code got here without returning, it means that new item is the largest one
            //  add it to the end of the list
            previousItem.setNext(newItem);
            newItem.setPrevious(previousItem);
            return true;

        }

        // else (new item is smaller than root), try to add it to left side
        else {

            // loop from root to left side of the list
            ListItem currentItem = root;
            ListItem nextItem = root.next();

            while (currentItem != null) {

                // if new item is equal to current one, exit and return false
                if (newItem.compareTo(currentItem) == 0) {
                    return false;
                }

                // if new item is larger than current one, add new element between current and next
                if (newItem.compareTo(currentItem) > 0) {

                    // connect new item to next
                    newItem.setNext(currentItem.next());
                    currentItem.next().setPrevious(newItem);

                    // connect current to new item
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);

                    // return and end loop, since item was added successfully
                    return true;

                }

                // move all pointers left
                nextItem = currentItem;
                currentItem = currentItem.previous();
            }

            //  if code got here without returning, it means that new item is the smallest one
            //  add it to the end of the list
            nextItem.setPrevious(newItem);
            newItem.setNext(nextItem);
            return true;
        }
    }

    // todo: not tested
    @Override
    public boolean removeItem(ListItem item) {

        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;

        while (true) {
            int comparison = currentItem.compareTo(item);

            // found the item to delete
            if (comparison == 0) {

                // if this is the root record, set a new root
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }

                // returning because we've finished
                return true;

            }

            // we are at an item smaller than the one to be deleted
            else if (comparison < 0) {
                currentItem = currentItem.next();
            }

            // we are at an item greater than the one to be deleted
            else {
                currentItem = currentItem.previous();
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            ListItem currentNode = root;

            while (currentNode.previous() != null) {
                currentNode = currentNode.previous();
            }


            while (currentNode != null) {
                System.out.println(currentNode.getValue());
                currentNode = currentNode.next();
            }
        }
    }
}
