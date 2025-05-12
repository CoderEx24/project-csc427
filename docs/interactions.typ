== Exporting using Iterator, Factory Method and Visitor
In order to export the user interface to a file,
the program needs to iterate through the tree structure of the user interface.
The iterator method abstracts the iteration through the structure.
The visitor pattern access the iterator through a factory method, by calling `iterator()` on the root element.
The visitor then loops through all the components using the iterator, accumulating state.
The client code then calls a `export()` method to export to a file.

== Building a User Interface Model using Builder and Composite
The builder pattern is used to separate the logic of building a user interface, from the logic that represents it.
The builder builds a user interface tree by methods that adds components like buttons and textboxes and containers for those components.
The builder is used to gradually build the user interface, allowing for the creation of complex interfaces with maintainable code.

