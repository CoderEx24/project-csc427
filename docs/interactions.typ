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

== Managing Resources using Singleton and Flyweight
The program uses resources like fonts and icons.
These resources need to be managed carefully to avoid exhausting memory.
The flyweight pattern is used to share instances of resources like fonts and icons.
These resources are only loaded once, when needed,
and components that use these resources refer to the same shared instance of that resource.
Loading resources is done by the Singleton class `ResourceManager`.
`ResourceManager` maintains a map of loaded resources.
Each resource is identified by its filename.
When a component requests a resource,
`ResourceManager` consults its maps.
If the resource is found, a reference to it is returned.
Otherwise, the resource is loaded, stored in the map, and then returned.

